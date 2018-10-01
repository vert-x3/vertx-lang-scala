package io.vertx.lang.scala.codegen;

import freemarker.template.TemplateException;
import io.vertx.codegen.*;
import io.vertx.codegen.type.*;

import javax.annotation.processing.ProcessingEnvironment;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.*;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import static io.vertx.lang.scala.codegen.TypeHelper.convertTypeToAliasedType;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class DataObjectCodeGenerator extends Generator<Model> {

  public String filename;
  public String templateFilename;
  public Template template;

  @Override
  public void load(ProcessingEnvironment processingEnv) {
    super.load(processingEnv);
    TemplateLoader templateLoader = new ClassTemplateLoader(DataObjectCodeGenerator.class, "/templates");
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
    cfg.setTemplateLoader(templateLoader);
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

    try {
      template = cfg.getTemplate("dataobject.ftl");
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  @Override
  public String filename(Model model) {
    if(!((TypeInfo)model.getVars().get("type")).getName().equals("io.vertx.ext.web.handler.sockjs.PermittedOptions")) {
      return "scala/" + model.getModule().translateQualifiedName(model.getFqn(), "scala").replace('.', '/') + ".scala";
    }
    return null;
  }

  @Override
  public String render(Model model, int index, int size, Map<String, Object> session) {
    Map<String, Object> vars = new HashMap<>();

    ClassTypeInfo type = ((ClassTypeInfo)model.getVars().get("type"));
    Set<TypeInfo> importedTypes = (Set<TypeInfo>)model.getVars().get("importedTypes");
    Set<TypeInfo> superTypes = (Set<TypeInfo>)model.getVars().get("superTypes");

    vars.putAll(TypeNameTranslator.vars(name));
    vars.putAll(model.getVars());
    vars.put("typeHelper", new TypeHelper());
    vars.put("className", Helper.getSimpleName(type.getName()));
    vars.put("packageName", type.getRaw().translatePackageName("scala"));
    vars.put("imps", adjustedImports(type, importedTypes, superTypes));
    vars.put("isAllSuperTypesAbstract",isAllSuperTypesAbstract(superTypes));
    vars.putAll(ClassKind.vars());
    vars.putAll(MethodKind.vars());
    vars.putAll(Case.vars());

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

  public Set<String> adjustedImports(ClassTypeInfo type, Set<TypeInfo> importedTypes, Set<TypeInfo> superTypes) {
    Set<String> imps = TypeHelper.generateImports(type, importedTypes, Collections.emptyList());
    for (TypeInfo superType : superTypes) {
      imps.remove(superType.getRaw().translatePackageName("scala")+'.'+superType.getSimpleName());
      imps.remove(convertTypeToAliasedType(superType));
    }
    for (TypeInfo superType : superTypes) {
      imps.add(superType.getRaw().translatePackageName("scala") + ".{" + superType.getSimpleName() + " => Ext" + superType.getSimpleName() + "}");
    }
    imps.add("io.vertx.lang.scala.json.Json._");
    imps.add("io.vertx.core.json.JsonObject");
    imps.add("scala.collection.JavaConverters._");


    return imps;
  }

  public boolean isAllSuperTypesAbstract(Set<TypeInfo> superTypes) {
    return superTypes
      .stream()
      .map(type -> (DataObjectTypeInfo)type)
      .allMatch(DataObjectTypeInfo::isAbstract);
  }
}
