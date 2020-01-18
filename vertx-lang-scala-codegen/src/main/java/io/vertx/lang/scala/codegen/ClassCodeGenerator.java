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

  @Override
  public void load(ProcessingEnvironment processingEnv) {
    super.load(processingEnv);
    TemplateLoader templateLoader = new ClassTemplateLoader(ClassCodeGenerator.class, "/templates");
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
    cfg.setTemplateLoader(templateLoader);
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    try {
      template = cfg.getTemplate("class.ftl");
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public String filename(Model model) {
    if(!((TypeInfo)model.getVars().get("type")).getName().equals("io.vertx.core.buffer.Buffer")) {
      return "scala/" + model.getModule().translateQualifiedName(model.getFqn(), "scala").replace('.', '/') + ".scala";
    }
    return null;
  }

  @Override
  public String render(Model model, int index, int size, Map<String, Object> session) {
    Map<String, Object> vars = new HashMap<>();

    ClassTypeInfo type = ((ClassTypeInfo)model.getVars().get("type"));
    if(type.getName().equals("io.vertx.ext.web.Cookie")) {
      return null;
    }
    Set<TypeInfo> importedTypes = (Set<TypeInfo>)model.getVars().get("importedTypes");
    List<TypeInfo> superTypes = ((List<TypeInfo>)model.getVars().get("superTypes")).stream().filter(ti -> !ti.getName().equals("io.vertx.ext.web.Cookie")).collect(Collectors.toList());

    vars.putAll(TypeNameTranslator.vars(name));
    vars.putAll(model.getVars());
    vars.put("typeHelper", new TypeHelper());
    vars.put("className", Helper.getSimpleName(type.getName()));
    vars.put("packageName", type.getRaw().translatePackageName("scala"));
    vars.put("imps", adjustedImports(type, importedTypes));
    vars.putAll(ClassKind.vars());
    vars.putAll(MethodKind.vars());
    vars.putAll(Case.vars());
    vars.put("classes", classes(superTypes));
    vars.put("abstractClasses", abstractClasses(superTypes));

    vars.put("basicMethods", TypeHelper.findBasicMethods((List<MethodInfo>)vars.get("instanceMethods")));
    vars.put("cacheReturnMethods", TypeHelper.findCacheReturnMethods((List<MethodInfo>)vars.get("instanceMethods")));
    vars.put("defaultMethods", TypeHelper.findDefaultMethods((List<MethodInfo>)vars.get("instanceMethods")));
    vars.put("fluentMethods", TypeHelper.findFluentMethods((List<MethodInfo>)vars.get("instanceMethods")));
    vars.put("futureMethods", TypeHelper.findFutureMethods((List<MethodInfo>)vars.get("instanceMethods")));

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

  public Set<String> adjustedImports(ClassTypeInfo type, Set<TypeInfo> importedTypes) {
    Set<String> imps = TypeHelper.generateImports(type, importedTypes, Collections.emptyList());

    imps.add("io.vertx.lang.scala.HandlerOps._");
    imps.add("scala.reflect.runtime.universe._");
    imps.add("io.vertx.lang.scala.Converter._");

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

    imps.remove("io.vertx.ext.web.{Cookie => JCookie}");

    return imps;
  }

  public List<TypeInfo> classes(Collection<TypeInfo> classTypeInfos) {
    return classTypeInfos
      .stream()
      .filter(clazz -> ((ApiTypeInfo)clazz.getRaw()).isConcrete())
      .collect(Collectors.toList());
  }

  public List<TypeInfo> abstractClasses(Collection<TypeInfo> classTypeInfos) {
    return classTypeInfos
      .stream()
      .filter(clazz -> !((ApiTypeInfo)clazz.getRaw()).isConcrete())
      .collect(Collectors.toList());
  }
}
