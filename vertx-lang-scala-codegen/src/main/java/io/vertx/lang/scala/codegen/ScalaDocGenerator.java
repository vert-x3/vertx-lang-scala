package io.vertx.lang.scala.codegen;

import io.vertx.codegen.type.*;
import io.vertx.codetrans.CodeTranslator;
import io.vertx.codetrans.lang.scala.ScalaLang;
import io.vertx.docgen.Coordinate;
import io.vertx.docgen.DocGenerator;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.element.*;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:jochen@codepitbull.de">Jochen Mader</a>
 */
public class ScalaDocGenerator implements DocGenerator {
  private TypeMirrorFactory factory;
  private CodeTranslator translator;
  private ProcessingEnvironment env;

  @Override
  public void init(ProcessingEnvironment processingEnvironment) {
    factory = new TypeMirrorFactory(processingEnvironment.getElementUtils(), processingEnvironment.getTypeUtils());
    translator = new CodeTranslator(processingEnvironment);
    env = processingEnvironment;
  }

  @Override
  public String getName() {
    return "scala";
  }

  @Override
  public String renderSource(ExecutableElement elt, String source) {
    ScalaLang lang = new ScalaLang();
    try {
      return translator.translate(elt, lang);
    }
    catch (Exception e){
      e.printStackTrace();
      System.out.println("Cannot generate " + elt.getEnclosingElement().getSimpleName() + "#" + elt.getSimpleName() + " : " + e.getMessage());
      return "Code not translatable";
    }
  }

  @Override
  public String resolveTypeLink(TypeElement elt, Coordinate coordinate) {
    TypeInfo type = null;
    try {
      type = factory.create(elt.asType());
    }

    catch (Exception e) {
      System.out.println("Could not resolve doc link for type " + elt.getQualifiedName());
      return null;
    }
    if (type.getKind().equals(ClassKind.ENUM) && ((EnumTypeInfo)type).isGen()) {
      String baselink = null;
      if (coordinate == null) baselink = "../";
      else baselink = "../../" + coordinate.getArtifactId() + "/";
      return baselink + "enums.html#" + elt.getSimpleName().toString();
    }
    if (type.getDataObject() != null) {
      String baselink = null;
      if (coordinate == null) baselink = "../";
      else baselink = "../../" + coordinate.getArtifactId() + "/";
      return baselink + "dataobjects.html#" + elt.getSimpleName().toString();
    }
    if (type.getKind().equals(ClassKind.API)) {
      ApiTypeInfo api = (ApiTypeInfo)type.getRaw();
      return "../../scaladocs/" + api.translateName("scala").replace('.', '/') + ".html";
    }
    return null;
  }

  @Override
  public String resolveConstructorLink(ExecutableElement executableElement, Coordinate coordinate) {
    return "todo";
  }

  @Override
  public String resolveMethodLink(ExecutableElement elt, Coordinate coordinate) {
    TypeElement typeElt = (TypeElement)elt.getEnclosingElement();
    String link = resolveTypeLink(typeElt, coordinate);
    if (link != null) if (link.contains("cheatsheet")) link = link + '#' + java.beans.Introspector.decapitalize(elt.getSimpleName().toString().substring(3));
    else {

      StringBuilder anchor = new StringBuilder('#' + elt.getSimpleName().toString() + "(");
      TypeMirror type = elt.asType();
      ExecutableType methodType = (ExecutableType)env.getTypeUtils().erasure(type);

      List<? extends TypeMirror> parameterTypes = methodType.getParameterTypes();

      IntStream.range(0, parameterTypes.size()-1).forEach(index -> {
        if(index > 0) anchor.append(",%20");
        //drop preceding annotations as they mess up linking
        String[] splitted = parameterTypes.get(index).toString().split(" :: ");
        anchor.append(splitted[splitted.length - 1]);
      });

      anchor.append(')');
      link = link + anchor.toString();
    }
    return link;
  }

  @Override
  public String resolveFieldLink(VariableElement variableElement, Coordinate coordinate) {
    return "todo";
  }

  @Override
  public String resolveLabel(Element elt, String defaultLabel) {
    if (elt.getKind().equals(ElementKind.METHOD)) {
      TypeInfo type = factory.create(elt.getEnclosingElement().asType());
      if (type.getDataObject() != null) {
        String name = elt.getSimpleName().toString();
        if (name.startsWith("set") && name.length() > 3 && Character.isUpperCase(name.charAt(3))) name = java.beans.Introspector.decapitalize(name.substring(3));
        return name;
      }
    }
    return defaultLabel;
  }
}
