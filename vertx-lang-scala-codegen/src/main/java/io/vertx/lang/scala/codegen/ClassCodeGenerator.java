package io.vertx.lang.scala.codegen;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import io.vertx.codegen.*;
import io.vertx.codegen.type.*;

import javax.annotation.processing.ProcessingEnvironment;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ClassCodeGenerator extends Generator<Model> {

  public String filename;
  public String templateFilename;
  public Template template;
  public Map<String, Set<String>> fileToImports = new HashMap<>();

  public static final List<String> ignoredPackages;
  static {
    List<String> temp = new ArrayList<>();
    temp.add("io.vertx.redis");
    ignoredPackages = Collections.unmodifiableList(temp);
  }

  public ClassCodeGenerator() {
    this.incremental = true;
  }

  @Override
  public void load(ProcessingEnvironment processingEnv) {
    super.load(processingEnv);
    TemplateLoader templateLoader = new ClassTemplateLoader(ClassCodeGenerator.class, "/templates");
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
    cfg.setTemplateLoader(templateLoader);
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    try {
      template = cfg.getTemplate("package_object.ftl");
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public String filename(Model model) {
    if(!((TypeInfo)model.getVars().get("type")).getName().equals("io.vertx.core.buffer.Buffer")) {
      String fileName = filenameForModel(model);
      fileToImports.put(fileName, new HashSet<>());

      ClassTypeInfo type = ((ClassTypeInfo)model.getVars().get("type"));
      Set<TypeInfo> importedTypes = (Set<TypeInfo>)model.getVars().get("importedTypes");

      fileToImports.get(fileName).addAll(adjustedImports(type, importedTypes));

      return fileName;
    }
    return null;
  }

  String filenameForModel(Model model) {
    return "scala/" + model.getModule().translatePackageName("scala").replace('.', '/') + "/package.scala";
  }

  @Override
  public String render(Model model, int index, int size, Map<String, Object> session) {
    ClassTypeInfo type = ((ClassTypeInfo)model.getVars().get("type"));
    if(!ignoredPackages.contains(type.getPackageName())) {
      Map<String, Object> vars = new HashMap<>();
      String translatedPackage = type.getModule().translatePackageName("scala");

      vars.putAll(TypeNameTranslator.vars(name));
      vars.putAll(model.getVars());
      vars.put("nonGenericType", Helper.getNonGenericType(type.toString()));
      vars.put("modulePackage", translatedPackage.substring(0, translatedPackage.lastIndexOf('.')));
      vars.put("moduleName", translatedPackage.substring(translatedPackage.lastIndexOf('.') + 1));

      vars.put("basicMethods", TypeHelper.findBasicMethods((List<MethodInfo>)vars.get("instanceMethods")));
      vars.put("cacheReturnMethods", TypeHelper.findCacheReturnMethods((List<MethodInfo>)vars.get("instanceMethods")));
      vars.put("defaultMethods", TypeHelper.findDefaultMethods((List<MethodInfo>)vars.get("instanceMethods")));
      vars.put("fluentMethods", TypeHelper.findFluentMethods((List<MethodInfo>)vars.get("instanceMethods")));
      vars.put("futureMethods", TypeHelper.findFutureMethods((List<MethodInfo>)vars.get("instanceMethods")));
      vars.put("nullableMethods", TypeHelper.findNullableMethods((List<MethodInfo>)vars.get("instanceMethods")));


      vars.put("typeHelper", new TypeHelper());
      vars.put("helper", new Helper());
      vars.put("className", type.getSimpleName());
      vars.put("packageName", translatedPackage);
      vars.put("imps", fileToImports.get(filenameForModel(model)));
      vars.putAll(ClassKind.vars());
      vars.putAll(MethodKind.vars());
      vars.putAll(Case.vars());
      vars.put("incrementalIndex", index);
      vars.put("incrementalSize", size);

      Writer writer = new StringWriter();
      try {
        template.process(vars, writer);
        return writer.toString();
      } catch (TemplateException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    }
    return "";
  }

  public Set<String> adjustedImports(ClassTypeInfo type, Set<TypeInfo> importedTypes) {
    Set<String> imps = TypeHelper.generateImports(type, importedTypes, Collections.emptyList());

    //Change
    //import io.vertx.scala.ext.web.common.template.TemplateEngine

    if(type.getName().equals("io.vertx.ext.web.templ.TemplateEngine")) {

      imps.remove("io.vertx.scala.ext.web.common.template.TemplateEngine");
      imps.add("io.vertx.scala.ext.web.common.template.{TemplateEngine => STemplateEngine}");
      imps.remove("io.vertx.ext.web.common.template.{TemplateEngine => JTemplateEngine}");
    }

    if(type.getName().equals("io.vertx.core.Vertx")) {
      imps.add("io.vertx.lang.scala.ScalaVerticle");
    }

    return imps;
  }
}
