package io.vertx.lang.scala.codegen;

import io.vertx.codegen.Case;
import io.vertx.codegen.MethodInfo;
import io.vertx.codegen.ParamInfo;
import io.vertx.codegen.doc.Doc;
import io.vertx.codegen.doc.Tag;
import io.vertx.codegen.doc.Text;
import io.vertx.codegen.doc.Token;
import io.vertx.codegen.type.ClassKind;
import io.vertx.codegen.type.ClassTypeInfo;
import io.vertx.codegen.type.TypeInfo;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import java.util.stream.Collectors;

public class Docs {
  //DOCS
  public static String methodDoc(TypeInfo type, MethodInfo method, String indentation, boolean future) {
    String doc = "";

    String commentedIndentation = indentation;
    commentedIndentation += " *";

    if (method.getDoc()!= null) {
      TypeInfo returnType = method.getReturnType();
      Text returnDescription = method.getReturnDescription();

      doc += indentation;
      doc += "/**\n";

      if (future) {
        doc += commentedIndentation;
        String params = method.getParams().stream().map(param -> Templates.convertToScalaNotation(param.getType().getSimpleName())).collect(Collectors.joining(","));
        if (params != "") {
          params = "(" + params +")";
        }
        doc += " Like " +  method.getName() + " from [[" + type.getName() + "]] but returns a Scala Future instead of taking an AsyncResultHandler.\n";
      } else {
        doc += renderDoc(type, commentedIndentation, method.getDoc());
        for (ParamInfo param : method.getParams()) {
          if (param.getDescription() != null) {
            doc += commentedIndentation;
            doc += " @param " + param.getName()+ " ";
            doc += convertLink(param.getDescription());
            if (param.getType().getDataObject() != null) {
              doc += " see " + renderDataObjectHtmlLink(type, param.getType());
            }
            doc = doc.replace("{@code ","`").replace("{@literal","`").replace("@literal{","`").replace("@code{","`").replace("}","`");
            doc += "\n";
          }
        }
        if (!returnType.getName().equals("void")) {
          if (returnDescription != null) {
            doc += commentedIndentation;
            doc += " @return ";
            doc += convertLink(returnDescription);

            if (returnType.getDataObject() != null) {
              doc += "see " + renderDataObjectHtmlLink(type, returnType);
            }
            doc = doc.replace("{@code ","`").replace("{@literal","`").replace("@literal{","`").replace("@code{","`").replace("}","`");
            doc += "\n";
          }
        }
      }
      doc += commentedIndentation;
      doc += "/";
    }
    return doc;
  }

  public static String convertLink(Text doc) {
    String linkText = "{@link";
    String transformedDoc = "";

    int start = 0;
    int index = doc.getValue().indexOf(linkText);
    while (index >= 0) {
      int end = doc.getValue().indexOf("}", index);
      transformedDoc += doc.getValue().substring(start, index) + toScalaDocType(doc.getValue().substring(index + 1 + linkText.length(), end));
      start = end + 1;
      index = doc.getValue().indexOf(linkText, start);
    }

    transformedDoc += doc.getValue().substring(start);
    return transformedDoc;
  }

  public static String toScalaDocType(String type) {

    if (type.contains("AsyncResult")) {
      return "io.vertx.lang.scala.AsyncResult";
    } else if (type.equals("void") || type.equals("java.lang.Void")) {
      return "Unit";
    } else if (type.equals("Object") || type.equals("java.lang.Object")) {
      return "AnyRef";
    } else if (type.equals("Throwable") || type.equals("java.lang.Throwable")) {
      return "Throwable";
    } else if (type.equals("String") || type.equals("java.lang.String")) {
      return "String";
    } else if (type.equals("byte") || type.equals("java.lang.Byte")) {
      return "Byte";
    } else if (type.equals("short") || type.equals("java.lang.Short")) {
      return "Short";
    } else if (type.equals("int") || type.equals("java.lang.Integer")) {
      return "Int";
    } else if (type.equals("long") || type.equals("java.lang.Long")) {
      return "Long";
    } else if (type.equals("float") || type.equals("java.lang.Float")) {
      return "Float";
    } else if (type.equals("double") || type.equals("java.lang.Double")) {
      return "Double";
    } else if (type.equals("boolean") || type.equals("java.lang.Boolean")) {
      return "Boolean";
    } else if (type.equals("char") || type.equals("java.lang.Character")) {
      return "Char";
    } else if (type.equals("List") || type.equals("java.util.List")) {
      return "scala.collection.immutable.List";
    } else if (type.equals("Set") || type.equals("java.util.Set")) {
      return "scala.collection.immutable.Set";
    } else if (type.equals("Map") || type.equals("java.util.Map")) {
      return "scala.collection.immutable.Map";
    } else if (type.equals("Handler") || type.equals("io.vertx.core.Handler")) {
      return "scala-function";
    } else if (type.contains("io.vertx") && !type.endsWith("Exception")) {
      return Templates.convertToScalaNotation(type).replace("io.vertx.", "io.vertx.scala.");
    } else {
      return type;
    }
  }



  /**
   * Checks if the given Element is an AsyncResultHandler
   * @param type
   * @return
   */
  public static boolean isAsyncResultHandler(Element type) {
    return type.toString().contains("io.vertx.core.Handler") && type.toString().contains("io.vertx.core.AsyncResult");
  }

  public static String renderDataObjectHtmlLink(TypeInfo type, TypeInfo dataObjectType) {
    StringBuilder link = new StringBuilder();
    for (String name : Case.QUALIFIED.parse(type.getRaw().getPackageName())) {
      link.append("../");
    }

    link.append("../../../cheatsheet/").append(dataObjectType.getSimpleName()).append(".html");
    return "<a href=\"" + link + "\">" + dataObjectType.getSimpleName() + "</a>";
  }

  /**
   * Render fixed Doc-Links
   */
  public static String renderDocLink(TypeInfo type, Tag.Link link) {
    ClassTypeInfo rawType = link.getTargetType().getRaw();
    if (rawType.getModule() != null) {
      String label = link.getLabel().trim();
      if (rawType.getKind() == ClassKind.ENUM) {
        return "[[" + Templates.convertToScalaNotation(rawType.getName()) + "]]";
      }
      if (rawType.getDataObject() != null) {
        if (label.length() == 0) {
          label = rawType.getSimpleName();
        }
        return renderDataObjectHtmlLink(type, rawType);
      } else if (type.getKind() == ClassKind.API && !type.getName().equals("io.vertx.core.Handler")) {
        Element elt = link.getTargetElement();
        if (elt.getSimpleName().toString().equals("Verticle")) {
          return "[[io.vertx.lang.scala.ScalaVerticle]]";
        } else if (elt.getSimpleName().toString().equals("Handler")) {
          if (isAsyncResultHandler(elt)) {
            return "[[scala.concurrent.Future]]";
          } else {
            return "scala-function";
          }
        } else {
          String eltKind = elt.getKind().name();
          String ret = "[[" + rawType.getRaw();
          if (eltKind.equals("METHOD")) {
            if (!elt.getSimpleName().toString().equals("executeBlocking") && ((ExecutableElement)elt).getParameters().size() > 0 && isAsyncResultHandler(((ExecutableElement)elt).getParameters().get(((ExecutableElement)elt).getParameters().size()-1))) {
              ret += "#" + elt.getSimpleName().toString() + "Future";
            } else {
              ret += "#" + elt.getSimpleName().toString();
            }
          }
          ret += "]]";
          return ret;
        }
      } else {
        return "[[" + toScalaDocType(rawType.getName()) + "]]";
      }
    }
    return null;
  }

  /**
   * Render an adjusted Docs-header.
   */
  public static String renderDoc(TypeInfo type, String margin, Doc doc) {
    boolean need = true;
    StringBuilder output = new StringBuilder();
    for (Token token : doc.getTokens()) {
      if (need) {
        output.append(margin);
        need = false;
      }
      if (token.isLineBreak()) {
        output.append("\n");
        need = true;
      } else {
        if (token.isText()) {
          output.append(token.getValue());
        } else {
          Tag tag = ((Token.InlineTag)token).getTag();
          if (tag instanceof Tag.Link) {
            String outputLink = renderDocLink(type, (Tag.Link)tag);
            if (outputLink == null || outputLink.trim().isEmpty()) {
              outputLink = ((Tag.Link) tag).getLabel();
            }
            if (outputLink == null || outputLink.trim().isEmpty()) {
              outputLink = ((Tag.Link) tag).getTargetElement().getSimpleName().toString();
            }
            output.append(outputLink);
          } else if (tag.getName().equals("code")) {
            // I have to do the replacement as the replaced code would be interpreted as a comment by scaladoc
            output.append("`").append(tag.getValue().trim().replace("/*","/\\*")).append("`");
          }
        }
      }
    }
    return output.toString().replace("<p>", "");
  }
}
