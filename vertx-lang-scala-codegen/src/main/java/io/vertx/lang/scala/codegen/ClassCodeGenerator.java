package io.vertx.lang.scala.codegen;

import io.vertx.codegen.Generator;
import io.vertx.codegen.MethodInfo;
import io.vertx.codegen.Model;
import io.vertx.codegen.TypeParamInfo;
import io.vertx.codegen.doc.Doc;
import io.vertx.codegen.type.ClassTypeInfo;
import io.vertx.codegen.type.TypeInfo;
import io.vertx.lang.scala.codegen.gen.Imports;
import io.vertx.lang.scala.codegen.gen.Templates;

import javax.annotation.processing.ProcessingEnvironment;
import java.io.IOException;
import java.util.*;
import java.util.logging.LogManager;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class ClassCodeGenerator extends Generator<Model> {

  public String filename;
  public String templateFilename;
  public Map<String, Set<String>> fileToImports = new HashMap<>();

  public static final List<String> ignoredPackages;

  static {
    List<String> temp = new ArrayList<>();
    temp.add("io.vertx.redis");
    temp.add("io.vertx.ext.consul.token");
    ignoredPackages = Collections.unmodifiableList(temp);
  }

  public static final List<String> ignoreClassname = Collections.unmodifiableList(new ArrayList<>());

  public ClassCodeGenerator() {
    LogManager.getLogManager().reset();
    this.incremental = true;
  }

  @Override
  public void load(ProcessingEnvironment processingEnv) {
    super.load(processingEnv);
  }

  @Override
  public String filename(Model model) {
    if (!((TypeInfo) model.getVars().get("type")).getName().equals("io.vertx.core.buffer.Buffer")
      && !(model.getFqn().contains(".impl.") || model.getFqn().endsWith(".impl"))
      && model.getAnnotations().stream().noneMatch(annotation -> annotation.getSimpleName().equals("Deprecated"))) {

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
    Map<String, Object> modelVars = model.getVars();
    ClassTypeInfo type = ((ClassTypeInfo) modelVars.get("type"));
    if (!ignoredPackages.contains(type.getPackageName()) && !ignoreClassname.contains(type.getSimpleName())) {
      try {
        return Templates.renderPackageObject(
          model,
          type,
          index,
          size,
          fileToImports.get(filenameForModel(model)),
          (Boolean) modelVars.get("concrete"),
          (Boolean) modelVars.get("hasEmptyConstructor"),
          (Doc) modelVars.get("doc"),
          (List<MethodInfo>) modelVars.get("instanceMethods"),
          (List<MethodInfo>) modelVars.get("staticMethods"),
          (Collection<TypeParamInfo>) modelVars.get("typeParams")
        );
      } catch (IOException ioe) {
        throw new RuntimeException(ioe);
      }
    }
    return "";
  }

  public Set<String> adjustedImports(ClassTypeInfo type, Set<TypeInfo> importedTypes) {
    Set<String> imps = Imports.generateImports(type, importedTypes, Collections.emptyList());

    //Change
    //import io.vertx.scala.ext.web.common.template.TemplateEngine

    if (type.getName().equals("io.vertx.ext.web.templ.TemplateEngine")) {

      imps.remove("io.vertx.scala.ext.web.common.template.TemplateEngine");
      imps.add("io.vertx.scala.ext.web.common.template.{TemplateEngine => STemplateEngine}");
      imps.remove("io.vertx.ext.web.common.template.{TemplateEngine => JTemplateEngine}");
    }

    if (type.getName().equals("io.vertx.core.Vertx")) {
      imps.add("io.vertx.lang.scala.ScalaVerticle");
    }

    return imps;
  }
}
