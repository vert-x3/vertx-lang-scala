package io.vertx.lang.scala.codegen;

import io.vertx.codegen.*;
import io.vertx.codegen.doc.Doc;
import io.vertx.codegen.doc.Tag;
import io.vertx.codegen.doc.Text;
import io.vertx.codegen.doc.Token;
import io.vertx.codegen.type.*;

import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.vertx.codegen.Helper.getNonGenericType;

public class TypeHelper {


  public static final Map<String,String> javaBasicToWrapperTyper;
  static {
    Map<String, String> writable = new HashMap<>();
    writable.put("byte", "java.lang.Byte");
    writable.put("java.lang.Byte", "java.lang.Byte");
    writable.put("short", "java.lang.Short");
    writable.put("java.lang.Short", "java.lang.Short");
    writable.put("int", "java.lang.Integer");
    writable.put("java.lang.Integer", "java.lang.Integer");
    writable.put("long", "java.lang.Long");
    writable.put("java.lang.Long", "java.lang.Long");
    writable.put("float", "java.lang.Float");
    writable.put("java.lang.Float", "java.lang.Float");
    writable.put("double", "java.lang.Double");
    writable.put("java.lang.Double", "java.lang.Double");
    writable.put("boolean", "java.lang.Boolean");
    writable.put("java.lang.Boolean", "java.lang.Boolean");
    writable.put("char", "java.lang.Character");
    writable.put("java.lang.Character", "java.lang.Character");
    writable.put("String", "java.lang.String");
    writable.put("java.lang.String", "java.lang.String");
    javaBasicToWrapperTyper = Collections.unmodifiableMap(writable);
  }

  public static final Map<String,String> javaBasicToScalaType;
  static {
    Map<String, String> writable = new HashMap<>();
    writable.put("byte", "Byte");
    writable.put("java.lang.Byte", "Byte");
    writable.put("short", "Short");
    writable.put("java.lang.Short", "Short");
    writable.put("int", "Int");
    writable.put("java.lang.Integer", "Int");
    writable.put("long", "Long");
    writable.put("java.lang.Long", "Long");
    writable.put("float", "Float");
    writable.put("java.lang.Float", "Float");
    writable.put("double", "Double");
    writable.put("java.lang.Double", "Double");
    writable.put("boolean", "Boolean");
    writable.put("java.lang.Boolean", "Boolean");
    writable.put("char", "Char");
    writable.put("java.lang.Character", "Char");
    writable.put("String", "String");
    writable.put("java.lang.String", "String");
    javaBasicToScalaType = Collections.unmodifiableMap(writable);
  }

  public static final Map<ClassKind, Function<TypeInfo,String>> toScalaType;
  static {
    Map<ClassKind, Function<TypeInfo,String>> writable = new HashMap<>();
    writable.put(ClassKind.VOID, t -> "Void");
    writable.put(ClassKind.OBJECT, t -> t.isVariable() ? t.getName() : "AnyRef");
    writable.put(ClassKind.THROWABLE, t -> "Throwable");
    writable.put(ClassKind.STRING, t -> javaBasicToWrapperTyper.get(t.getName()));
    writable.put(ClassKind.PRIMITIVE, t -> javaBasicToWrapperTyper.get(t.getName()));
    writable.put(ClassKind.BOXED_PRIMITIVE, t -> javaBasicToWrapperTyper.get(t.getName()));
    writable.put(ClassKind.LIST, t -> "scala.collection.mutable.Buffer" +  ((!((ParameterizedTypeInfo)t).getArgs().isEmpty()) ? "[" + fromTypeToScalaTypeString(((ParameterizedTypeInfo)t).getArgs().get(0)) + "]" : ""));
    writable.put(ClassKind.SET, t -> "scala.collection.mutable.Set" +  ((!((ParameterizedTypeInfo)t).getArgs().isEmpty()) ? "[" + fromTypeToScalaTypeString(((ParameterizedTypeInfo)t).getArgs().get(0)) + "]" : ""));
    writable.put(ClassKind.MAP, t -> "scala.collection.mutable.Map" +  ((!((ParameterizedTypeInfo)t).getArgs().isEmpty()) ? "[String, " + fromTypeToScalaTypeString(((ParameterizedTypeInfo)t).getArgs().get(1)) + "]" : ""));
    writable.put(ClassKind.HANDLER, t -> fromTypeToScalaTypeString(((ParameterizedTypeInfo)t).getArgs().get(0)) + " => Unit");
    writable.put(ClassKind.JSON_OBJECT, TypeInfo::getName);
    writable.put(ClassKind.JSON_ARRAY, TypeInfo::getName);
    writable.put(ClassKind.ENUM, TypeInfo::getName);
    writable.put(ClassKind.ASYNC_RESULT, t -> "AsyncResult" + (!((ParameterizedTypeInfo)t).getArgs().isEmpty() ? "[" + fromTypeToScalaTypeString(((ParameterizedTypeInfo)t).getArgs().get(0)) + "]" : "[_]"));
    writable.put(ClassKind.CLASS_TYPE, t -> "Class" + (((ParameterizedTypeInfo)t).getArgs().isEmpty() ? "[_]" : "[" + ((ParameterizedTypeInfo)t).getArgs().stream().map(TypeHelper::fromTypeToScalaTypeString).collect(Collectors.joining(", ")) + "]"));

    writable.put(ClassKind.API, t -> {
      String ret = getNonGenericType(t.getName());
      if(t.isParameterized()) {
        if (((ParameterizedTypeInfo)t).getArgs().isEmpty()) {
          ret += "[_]";
        } else {
          ret += "[" + ((ParameterizedTypeInfo)t).getArgs().stream().map(TypeHelper::fromTypeToScalaTypeString).collect(Collectors.joining(", ")) + "]";
        }
        return ret;
      }
      return ret;
    });

    writable.put(ClassKind.FUNCTION, t -> {
      String type1 = fromTypeToScalaTypeString(((ParameterizedTypeInfo)t).getArgs().get(0));
      String type2 = fromTypeToScalaTypeString(((ParameterizedTypeInfo)t).getArgs().get(1));
      if (type1.equals("Void")) {
        return "() => " + type2;
      } else {
        return type1 + " => " + type2;
      }
    });

    toScalaType = Collections.unmodifiableMap(writable);
  }

  public static final Map<ClassKind, BiFunction<String, TypeInfo, String>> toJavaWithConversionFromScala;
  static {
    Map<ClassKind, BiFunction<String, TypeInfo,String>> writable = new HashMap<>();
    writable.put(ClassKind.VOID, (name, type) -> name);
    writable.put(ClassKind.STRING, (name, type) ->  name + (type.isNullable() ? ".getOrElse(null)" : ""));
    writable.put(ClassKind.PRIMITIVE, (name, type) ->  name + (type.isNullable() ? ".getOrElse(null)" : ""));
    writable.put(ClassKind.BOXED_PRIMITIVE, (name, type) ->  name + (type.isNullable() ? ".getOrElse(null)" : ""));
    writable.put(ClassKind.THROWABLE, (name, type) ->  name + (type.isNullable() ? ".getOrElse(null)" : ""));
    writable.put(ClassKind.OBJECT, (name, type) ->  name + (type.isNullable() ? ".getOrElse(null)" : ""));
    writable.put(ClassKind.CLASS_TYPE, (name, type) ->  name + (type.isNullable() ? ".getOrElse(null)" : ""));
    writable.put(ClassKind.JSON_OBJECT, (name, type) ->  name + (type.isNullable() ? ".getOrElse(null)" : ""));
    writable.put(ClassKind.JSON_ARRAY, (name, type) ->  name + (type.isNullable() ? ".getOrElse(null)" : ""));
    writable.put(ClassKind.ENUM, (name, type) ->  name + (type.isNullable() ? ".getOrElse(null)" : ""));
    writable.put(ClassKind.API, (name, type) ->  name + (type.isNullable() ? ".getOrElse(null)" : ""));
    writable.put(ClassKind.HANDLER, (name, type) ->  name + ".asInstanceOf[" + convertToScalaNotation(type.toString()) + "]");
    writable.put(ClassKind.ASYNC_RESULT, (name, type) ->  "AsyncResultWrapper[" + fromTypeToScalaTypeString(((ParameterizedTypeInfo)type).getArg(0)) + ", " + toJavaType(((ParameterizedTypeInfo)type).getArg(0)) + "](x, a => " + fromScalatoJavaWithConversion("a", ((ParameterizedTypeInfo)type).getArg(0)) + ")" + (type.isNullable() ? ".getOrElse(null)" : ""));
    writable.put(ClassKind.SET, (name, type) ->  name + (type.isNullable() ? ".map(_.asJava).getOrElse(null)" : ".asJava"));
    writable.put(ClassKind.LIST, (name, type) ->  name + (type.isNullable() ? ".map(_.asJava).getOrElse(null)" : ".asJava"));
    writable.put(ClassKind.MAP, (name, type) ->  name + (type.isNullable() ? ".map(_.asJava).getOrElse(null)" : ".asJava"));
    writable.put(ClassKind.FUNCTION, (name, type) ->  {
      ParameterizedTypeInfo parameterizedType = (ParameterizedTypeInfo)type;
      String executed = name;
      if (parameterizedType.getArg(0).getKind() == ClassKind.VOID) {
        executed = executed + "()";
      } else {
        executed = executed + "(x)";
      }
      executed = fromScalatoJavaWithConversion(executed, parameterizedType.getArg(1));
      String ret = "{x: " + toJavaType(parameterizedType.getArg(0)) + " => " + executed + "}";
      if (type.isNullable()) {
        ret = name + ".map(" + name +" => " + ret + ").orNull";
      }
      return ret;
    });


    toJavaWithConversionFromScala = Collections.unmodifiableMap(writable);
  }

  public static String convertArgListToScalaFormatedString(TypeInfo type) {
    if (type.isParameterized()) {
        return "[" + ((ParameterizedTypeInfo)type)
          .getArgs().stream()
          .map(TypeHelper::toJavaType)
          .collect(Collectors.joining(", ")) + "]";
    }
    return "";
  }

  public static String toScalaWithConversion(String name, TypeInfo type) {
    ClassKind kind = type.getKind();
    String conversion = "";

    if (kind.collection){
     conversion = ".asScala";
    }

    return name + conversion;
  }

  public static String fromTypeToScalaTypeString(TypeInfo type) {
    if (type.getDataObject() != null) {
      return getNonGenericType(type.getName());
    }
    return toScalaType.get(type.getKind()).apply(type);
  }

  /**
   * Generate conversion code to convert a given instance from Scala to Java:
   * 'scala.Int' becomes 'scala.Int.asInstanceOf[java.lang.Integer]'
   */
  public static String fromScalatoJavaWithConversion(String name, TypeInfo type) {
    if (type.getDataObject() != null) {
      return name + (type.isNullable() ? ".getOrElse(null)" : "");
    } else if (type.getKind() == ClassKind.OTHER && type.getName().equals("java.time.Instant")) {
      return name + ".asInstanceOf[java.time.Instant]";
    }
    return toJavaWithConversionFromScala.get(type.getKind()).apply(name, type);
  }

  /**
   * Generate the Java type name for a given Scala type name:
   * "scala.Int" becomes "java.lang.Integer"
   */
  public static String toJavaType(TypeInfo type) {
    if (type.getKind().basic) {
      return javaBasicToWrapperTyper.containsKey(type.getName()) ? javaBasicToWrapperTyper.get(type.getName()) : type.getName();
    } else if (type.getKind() == ClassKind.THROWABLE
      || type.getKind() == ClassKind.VOID
      || type.getKind() == ClassKind.JSON_OBJECT
      || type.getKind() == ClassKind.JSON_ARRAY
      || type.getKind() == ClassKind.ENUM
      || type.getName().equals("java.lang.Void")
      || type.getName().equals("void")
      || type.getName().equals("io.vertx.core.buffer.Buffer")) {
      return type.getSimpleName();
    } else if (type.getKind() == ClassKind.OBJECT) {
      return type.getSimpleName();
    } else if (type.getDataObject() != null) {
      return type.getName();
    } else if (type.getKind() == ClassKind.API) {
      String ret = getNonGenericType(type.getName());
      if (type.isParameterized()) {
        ret += convertArgListToScalaFormatedString(type);
      } else if (!type.getRaw().getParams().isEmpty()) {
        String args = type.getRaw().getParams().stream().map(v -> "Object").collect(Collectors.joining(", "));
        ret += "[" + args + "]";
      }
      return ret;
    } else if (type.getKind() == ClassKind.CLASS_TYPE) {
      String ret = type.getSimpleName();
      String args = convertArgListToScalaFormatedString(type);
      return  ret + "[" + args + "]";
    } else if (type.getKind() == ClassKind.HANDLER) {
      ParameterizedTypeInfo parameterizedType = (ParameterizedTypeInfo)type;
      return "Handler["+ toJavaType(parameterizedType.getArg(0)) +"]";
    } else if (type.getKind().collection) {
      ParameterizedTypeInfo parameterizedType = (ParameterizedTypeInfo)type;
      String ret = "";
      if (type.getKind() == ClassKind.LIST){
        ret += "java.util.List["+ toJavaType(parameterizedType.getArg(0)) +"]";
      } else if (type.getKind() == ClassKind.SET){
        ret += "java.util.Set["+ toJavaType(parameterizedType.getArg(0)) +"]";
      } else if (type.getKind() == ClassKind.MAP){
        ret += "java.util.Map[String, "+ toJavaType(parameterizedType.getArg(1)) +"]";
      }
      return ret;
    } else if (type.getKind() == ClassKind.ASYNC_RESULT) {
      ParameterizedTypeInfo parameterizedType = (ParameterizedTypeInfo)type;
      return getNonGenericType(type.getSimpleName()) + "["+ toJavaType(parameterizedType.getArg(0)) +"]";
    } else {
      return "Unknown type for toJavaType "+type.getName()+" "+type.getKind();
    }
  }

  public static String convertToOptionIfNullable(boolean nullable, String expression) {
    if (nullable) {
      return "scala.Option[" + expression + "]";
    }
    return expression;
  }

  public static String wrapInOptionIfNullable(boolean nullable, String expression) {
    if (nullable) {
      return "scala.Option(" + expression + ")";
    }
    return expression;
  }

  public static String assembleTypeParams(Collection<TypeParamInfo> typeParams) {
    if (!typeParams.isEmpty()){
      return "[" + typeParams.stream().map(TypeParamInfo::getName).collect(Collectors.joining(", ")) + "]";
    } else {
      return "";
    }
  }

  public static String escapeIfKeyword(String possibleKeyword) {
    if (possibleKeyword.equals("type") || possibleKeyword.equals("object")) {
      return "`" + possibleKeyword + "`";
    }
    return possibleKeyword;
  }


  //IMPORTS


  public static void importForType(String packageName, TypeInfo type, Set<String> ret) {
    if (type.getKind() == ClassKind.JSON_OBJECT ||
      type.getKind() == ClassKind.JSON_ARRAY ||
      type.getKind() == ClassKind.ENUM ||
      type.getName().equals("io.vertx.core.buffer.Buffer")) {
      ret.add(type.getRaw().toString());
    } else if (type.getKind() == ClassKind.API || type.getDataObject() != null) {
      if (!Helper.getPackageName(type.getName()).equals(packageName)) {
        ret.add(getNonGenericType(type.getRaw().getPackageName()));
      }
      ret.add(convertTypeToAliasedType(type));
    } else if (type.getKind() == ClassKind.HANDLER) {
      ret.add(type.getRaw().toString());
      if (type.isParameterized()) {
        for (TypeInfo param : ((ParameterizedTypeInfo)type).getArgs()) {
          importForType(packageName, param, ret);
        }
      }
    } else if (type.getKind() == ClassKind.ASYNC_RESULT) {
      ret.add(type.getRaw().toString());
      if (type.isParameterized()) {
        for (TypeInfo param : ((ParameterizedTypeInfo)type).getArgs()) {
          importForType(packageName, param, ret);
        }
      }
    }
  }

  public static Set<String> generateImports(TypeInfo type, Collection<TypeInfo> imps, List<MethodInfo> methods) {
    Set<String> ret = new java.util.HashSet<>();
    ret.add(convertTypeToAliasedType(type));
    for (TypeInfo imported : imps) {
      /*Don't import implementations*/
      if (!imported.getName().contains(".impl.")) {
        importForType(Helper.getPackageName(type.getName()), imported, ret);
      }
    }
    for (MethodInfo method : methods) {
      for (ParamInfo param : method.getParams()) {
        importForType(Helper.getPackageName(type.getName()), param.getType(), ret);
      }
    }
    return ret;
  }

  /**
   * Every usage of a Vert.x-Java-type has to be aliased. This takes care of generating the required snippet.
   */
  public static String convertTypeToAliasedType(TypeInfo type) {
    return Helper.getPackageName(getNonGenericType(type.getName())) + ".{"+getNonGenericType(type.getSimpleName())+" => J"+getNonGenericType(type.getSimpleName())+"}";
  }


  //IMPORTS


  //METHODS



  /**
   * Since some methods lack necessary type infos for scala we
   * will exclude these from rendering.
   *
   * @see <a href="https://github.com/vert-x3/vertx-lang-scala/issues/23">Issue</a>
   */
  public static boolean skipMethod(MethodInfo method) {
    return method.getName().equals("addInterceptor") || method.getName().equals("removeInterceptor");
  }

  /**
   * Find methods which don't fall into any other category.
   * @param methods
   * @return
   */
  public static List<MethodInfo> findBasicMethods(List<MethodInfo> methods) {
    if(methods == null)
      return Collections.emptyList();
    return methods.stream()
      .filter(method -> !skipMethod(method))
      .filter(method -> !method.isFluent() && !method.isCacheReturn() && !method.isStaticMethod() && !method.isDefaultMethod())
      .collect(Collectors.toList());
  }

  /**
   * Find methods which are default methods.
   * @param methods
   * @return
   */
  public static List<MethodInfo> findDefaultMethods(List<MethodInfo> methods) {
    if(methods == null)
      return Collections.emptyList();
    return methods.stream()
      .filter(method -> !skipMethod(method))
      .filter(method -> method.isDefaultMethod() && !method.isFluent() && !method.isCacheReturn())
      .collect(Collectors.toList());
  }

  /**
   * Find methods which implement the fluent API-style.
   * @param methods
   * @return
   */
  public static List<MethodInfo> findFluentMethods(List<MethodInfo> methods) {
    if(methods == null)
      return Collections.emptyList();
    return methods.stream()
      .filter(method -> !skipMethod(method))
      .filter(method -> method.isFluent() && !method.isCacheReturn())
      .collect(Collectors.toList());
  }

  /**
   * Find methods which return a value that can be cached.
   * @param methods
   * @return
   */
  public static List<MethodInfo> findCacheReturnMethods(List<MethodInfo> methods) {
    if(methods == null)
      return Collections.emptyList();
    return methods.stream()
      .filter(method -> !skipMethod(method))
      .filter(method -> method.isCacheReturn())
      .collect(Collectors.toList());
  }

  public static List<MethodInfo> findFutureMethods(List<MethodInfo> methods) {
    if(methods == null)
      return Collections.emptyList();
    return methods.stream()
      .filter(method -> !skipMethod(method))
      .filter(method -> shouldMethodReturnAFuture(method))
      .collect(Collectors.toList());
  }

  public static List<MethodInfo> findNullableMethods(List<MethodInfo> methods) {
    if(methods == null)
      return Collections.emptyList();
    return methods.stream()
      .filter(method -> !skipMethod(method))
      .filter(method -> {
          if (method.getReturnType().isNullable()) {
            return true;
          }
          for(ParamInfo param : method.getParams()) {
            if(param.isNullable()) {
              return true;
            }
          }
          return false;
        })
      .collect(Collectors.toList());
  }


  public static boolean isAsyncResultHandler(TypeInfo type) {
    return type.getKind() == ClassKind.HANDLER && ((ParameterizedTypeInfo)type).getArg(0).getKind() == ClassKind.ASYNC_RESULT;
  }

  public static boolean isLastParamAsyncResultHandler(MethodInfo method) {
    int size = method.getParams().size();
    return isAsyncResultHandler(method.getParam(size-1).getType());
  }

  public static TypeInfo typeOfReturnedFuture(MethodInfo method) {
    return ((ParameterizedTypeInfo)((ParameterizedTypeInfo)method.getParam(method.getParams().size()-1).getType()).getArg(0)).getArg(0);
  }

  public static boolean shouldMethodReturnAFuture(MethodInfo method) {
    int size = method.getParams().size();
    return size > 0 && isLastParamAsyncResultHandler(method) && !(method.getReturnType().getKind() == ClassKind.HANDLER);
  }

  public static String assembleTypeParamString(MethodInfo method) {
    if (!method.getTypeParams().isEmpty()) {
      String args = String.join(", ", method.getTypeParams().stream()
        .map(v -> v.getName()).collect(Collectors.toList()));
      return "[" + args + "]";
    }
    return "";
  }

  public static String invokeMethodWithoutConvertingReturn(String target, MethodInfo method) {
    String paramString = String.join(", ", method.getParams().stream()
      .map(param -> fromScalatoJavaWithConversion(escapeIfKeyword(param.getName()), param.getType()))
      .collect(Collectors.toList()));

    return target + "." + escapeIfKeyword(method.getName()) + assembleTypeParamString(method) + "(" + paramString + ")";
  }

  public static String invokeMethodAndUseProvidedHandler(String target, MethodInfo method, String handler) {
    String typeParamString = assembleTypeParamString(method);

    String paramString = method.getParams().stream().map(param -> {
      if (isAsyncResultHandler(param.getType())) {
        return handler;
      } else {
        return fromScalatoJavaWithConversion(escapeIfKeyword(param.getName()), param.getType());
      }
    }).collect(Collectors.joining(", "));

    return target + "." + escapeIfKeyword(method.getName()) + typeParamString + "(" + paramString + ")";
  }

  /**
   * Some method names require special treatment when used in lang-scala. e.g. we have to convert the name
   * of methods where the original version gets replaced with one returning a scala.Future.
   */
  public static String createNameForMethodReturningAFuture(MethodInfo method) {
    String methodName = method.getName();
    if (methodName.endsWith("Handler")) {
      methodName = methodName.substring(0, methodName.length()-7);
    }
    methodName += "Future";
    return escapeIfKeyword(methodName);
  }


  //METHODS

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
        String params = method.getParams().stream().map(param -> convertToScalaNotation(param.getType().getSimpleName())).collect(Collectors.joining(","));
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

  public static String renderDataObjectHtmlLink(TypeInfo type, TypeInfo dataObjectType) {
    StringBuilder link = new StringBuilder();
    for (String name : Case.QUALIFIED.parse(type.getRaw().getPackageName())) {
      link.append("../");
    }

    link.append("../../../cheatsheet/").append(dataObjectType.getSimpleName()).append(".html");
    return "<a href=\"" + link + "\">" + dataObjectType.getSimpleName() + "</a>";
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
      return convertToScalaNotation(type).replace("io.vertx.", "io.vertx.scala.");
    } else {
      return type;
    }
  }

  public static String convertToScalaNotation(String type) {
    return  type
      .replace("<", "[").replace(">", "]");
  }

  /**
   * Checks if the given Element is an AsyncResultHandler
   * @param type
   * @return
   */
  public static boolean isAsyncResultHandlerHandler(Element type) {
    return type.toString().contains("io.vertx.core.Handler") && type.toString().contains("io.vertx.core.AsyncResult");
  }


  //Rendering output

  /**
   * Render fixed Doc-Links
   */
  public static String renderDocLink(TypeInfo type, Tag.Link link) {
    ClassTypeInfo rawType = link.getTargetType().getRaw();
    if (rawType.getModule() != null) {
      String label = link.getLabel().trim();
      if (rawType.getKind() == ClassKind.ENUM) {
        return "[[" + convertToScalaNotation(rawType.getName()) + "]]";
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
          if (isAsyncResultHandlerHandler(elt)) {
            return "[[scala.concurrent.Future]]";
          } else {
            return "scala-function";
          }
        } else {
          String eltKind = elt.getKind().name();
          String ret = "[[" + rawType.getRaw();
          if (eltKind.equals("METHOD")) {
            if (!elt.getSimpleName().toString().equals("executeBlocking") && ((ExecutableElement)elt).getParameters().size() > 0 && isAsyncResultHandlerHandler(((ExecutableElement)elt).getParameters().get(((ExecutableElement)elt).getParameters().size()-1))) {
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

  /**
   * Render a method that accepts a AsyncResult-Handler into one that returns a Scala-Future.
   * @param type
   * @param method
   * @return
   */
  public static String renderFutureMethod(TypeInfo type, MethodInfo method) {
    List<ParamInfo> params = method.getParams();
    params = params.subList(0, params.size() - 1);
    String paramList = params.stream().map(param -> escapeIfKeyword(param.getName()) + ": " + convertToOptionIfNullable(param.getType().isNullable(), fromTypeToScalaTypeString(param.getType()))).collect(Collectors.joining(","));

    String asyncType = typeOfReturnedFuture(method).getName().replace('<', '[').replace('>', ']');

    String ret = "";

    if (method.getDoc() != null) {
      ret += methodDoc(type, method, "    ", true);
      ret += "\n";
    }

    ret +="def "+ createNameForMethodReturningAFuture(method) + assembleTypeParams(method.getTypeParams().stream().map(p -> (TypeParamInfo)p).collect(Collectors.toList())) + "(" + paramList + ") : scala.concurrent.Future[" + fromTypeToScalaTypeString(typeOfReturnedFuture(method)) + "] = {\n" +
      "      val promise = concurrent.Promise[" + fromTypeToScalaTypeString(typeOfReturnedFuture(method))+ "]()\n" +
      "      " + invokeMethodAndUseProvidedHandler("asJava", method, "new Handler[AsyncResult[" + asyncType + "]] { override def handle(event: AsyncResult[" + asyncType + "]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(" + toScalaWithConversion("event.result()", typeOfReturnedFuture(method))) + "}})\n" +
      "      promise.future\n" +
      "}";
    return ret;
  }

  /**
   * Render a static method.
   * @param type
   * @param method
   * @return
   */
  public static String renderStaticMethod(ClassTypeInfo type, MethodInfo method) {
    List<ParamInfo> params = method.getParams();
    String paramList = params.stream().map(param -> escapeIfKeyword(param.getName()) + ": " + convertToOptionIfNullable(param.getType().isNullable(), fromTypeToScalaTypeString(param.getType()))).collect(Collectors.joining(", "));

    String option = method.getReturnType().isNullable() ? "Option" : "";

    String exec = method.getReturnType().isNullable() ? "scala.Option(" + invokeMethodWithoutConvertingReturn(type.getName(), method) + ")" : invokeMethodWithoutConvertingReturn(type.getName(), method);
    String ret = "";

    if (method.getDoc() != null) {
      ret += methodDoc(type, method, "    ", true);
      ret += "\n";
    }

    ret += "def "+ escapeIfKeyword(method.getName())+ option + assembleTypeParams(method.getTypeParams().stream().map(p -> (TypeParamInfo)p).collect(Collectors.toList())) + "(" + paramList + ") = {\n" +
      "      " + exec + "\n" +
      "}";
    return ret;
  }

  /**
   * Render methods with a nullable return-type so they return a scala.Option instead.
   * @param type
   * @param method
   * @return
   */
  public static String renderNullableMethod(ClassTypeInfo type, MethodInfo method) {
    List<ParamInfo> params = method.getParams();
    String paramList = params.stream().map(param -> escapeIfKeyword(param.getName()) + ": " + convertToOptionIfNullable(param.getType().isNullable(), fromTypeToScalaTypeString(param.getType()))).collect(Collectors.joining(", "));

    String option = method.getReturnType().isNullable() ? "Option" : "";

    String ret = "";

    if (method.getDoc() != null) {
      ret += methodDoc(type, method, "    ", true);
      ret += "\n";
    }

    String exec =

    ret +="def "+ escapeIfKeyword(method.getName())+ option + assembleTypeParams(method.getTypeParams().stream().map(p -> (TypeParamInfo)p).collect(Collectors.toList())) + "(" + paramList + ") = {\n" +
      "      " + wrapInOptionIfNullable(method.getReturnType().isNullable(), invokeMethodWithoutConvertingReturn("asJava", method)) + "\n" +
      "}";
    return ret;
  }

  /**
   * Takes care of rendering DataObjects.
   */
  public static String renderDataobject(String className, ClassTypeInfo type, boolean concrete, boolean hasEmptyConstructor, Helper helper) {
    if (concrete) {
        return "  type " +className + " = "+ helper.getNonGenericType(type.getName()) +"\n" +
        "  object " + helper.getSimpleName(type.getName()) + " {\n" +
          (hasEmptyConstructor ? "    def apply() = new " + helper.getSimpleName(type.getName()) + "()\n" : "") +
        "    def apply(json: JsonObject) = new " + helper.getSimpleName(type.getName()) + "(json)\n" +
        "  }\n";
    }
    return "";
  }

  /**
   * Takes care of rendering all APP-classes except DataObjects.
   */
  public static String renderClass(ClassTypeInfo type, Doc doc, String className, List<MethodInfo> nullableMethods, List<MethodInfo> futureMethods, String nonGenericType, Collection<TypeParamInfo> typeParams) throws IOException{

    String docs = doc != null ? "  /**\n" +
      renderDoc(type, "    *", doc) + "\n" +
      "    */\n"
      : "";

    String nullableMethodsRendered = (!"CompositeFuture".equals(className) && !"Future".equals(className)) ? nullableMethods.stream().filter(method -> !method.getName().equals("executeBlocking"))
      .map(method -> renderNullableMethod(type, method))
      .collect(Collectors.joining("\n"))
      : "";

    String futureMethodsRendered = futureMethods.stream().filter(method -> !method.getName().equals("executeBlocking"))
      .map(method -> renderFutureMethod(type, method))
      .collect(Collectors.joining("\n"));

    return
      "\n" +
      docs +
      "\n" +
      ("Vertx".equals(className) ? renderFile("extensions/VertxObject.ftl")+ "\n" : "") +
      "  implicit class "+ className + "Scala" + assembleTypeParams(typeParams) + "(val asJava: " + nonGenericType + assembleTypeParams(typeParams) + ") extends AnyVal {\n" +
      ("Vertx".equals(className) ? renderFile("extensions/Vertx.ftl")+ "\n" : "") +
      ("Vertx".equals(className) ? renderFile("extensions/executeblocking.ftl")+ "\n" : "") +
      ("Context".equals(className) ? renderFile("extensions/executeblocking.ftl") + "\n" : "") +
      ("WorkerExecutor".equals(className) ? renderFile("extensions/executeblocking.ftl") + "\n" : "") +
      "\n" +
      nullableMethodsRendered +
      "\n" +
      futureMethodsRendered +
      "\n" +
      "  }\n";
  }


  /**
   * Main entry point which renders the packagae-object.
   * It takes care of the incremental rendering part.
   */
  public static String renderPackageObject(ClassTypeInfo type, int incrementalIndex, int incrementalSize, Set<String> imps, Boolean concrete, Boolean hasEmptyConstructor, Doc doc, List<MethodInfo> instanceMethods, List<MethodInfo> staticMethods, Collection<TypeParamInfo> typeParams) throws IOException{
    Helper helper = new Helper();
    String nonGenericType = Helper.getNonGenericType(type.toString());
    String translatedPackage = type.getModule().translatePackageName("scala");
    String modulePackage = translatedPackage.substring(0, translatedPackage.lastIndexOf('.'));
    String moduleName = translatedPackage.substring(translatedPackage.lastIndexOf('.') + 1);

    List<MethodInfo> nullableMethods = findNullableMethods(instanceMethods);
    List<MethodInfo> futureMethods = findFutureMethods(instanceMethods);

    String header = "";
    if (incrementalIndex == 0) {
      header =
        renderFile("extensions/LicenseHeader.ftl")+ "\n" +
        "\n" +
        "package " + modulePackage +"\n" +
        "\n" +
        "import scala.jdk.CollectionConverters._\n" +
        "import io.vertx.core.json.JsonObject\n" +
        "import io.vertx.core.json.JsonArray\n" +
        "import io.vertx.core.AsyncResult\n" +
        "import io.vertx.core.Handler\n" +
        "import scala.concurrent.Promise\n" +
          ("io.vertx.core.Vertx".equals(type.getName()) ? "import io.vertx.lang.scala.ScalaVerticle\n" : "") +
        "\n" +
          (imps.stream().map(imp -> "import " + imp).collect(Collectors.joining("\n"))) +
        "\n" +
        "package object " + moduleName +"{\n" +
        "\n" +
          ("core".equals(moduleName) ? renderFile("extensions/Json.ftl") + "\n" : "") +
        "\n";
    }

    String body = "";
    if(type.getDataObject() != null) {
      body = renderDataobject(type.getSimpleName(), type, concrete, hasEmptyConstructor, helper) + "\n";
    }
    else if (!type.getName().contains("Handler") && !futureMethods.isEmpty()) {
      body = renderClass(type, doc, type.getSimpleName(), nullableMethods, futureMethods, nonGenericType, typeParams) + "\n";
    }
    else if (!type.getName().contains("Handler") && (staticMethods != null && !staticMethods.isEmpty()) &&  !"Message".equals(type.getSimpleName())) {
      body = "  object " + type.getSimpleName() + " {\n" +
        (staticMethods.stream().map(method -> renderStaticMethod(type, method)).collect(Collectors.joining("\n"))) +
        "  }\n";
    }

    return
      header +
      body +
      "\n" +
        ("Message".equals(type.getSimpleName()) ? renderFile("extensions/Message.ftl") : "") +
      "\n" +
        (incrementalIndex == incrementalSize-1 ? "}\n" : "");
  }



  //HELPER STUFF

  /**
   * Read template-file from the classpath and return contents as string.
   * @param fileName
   * @return
   * @throws IOException
   */
  public static String renderFile(String fileName) throws IOException{
    Class clazz = TypeHelper.class;
    InputStream inputStream = clazz.getResourceAsStream("/templates/"+ fileName);
    return readFromInputStream(inputStream);
  }

  /**
   * Helper for converting an InputStream to a String.
   * @param inputStream
   * @return
   * @throws IOException
   */
  public static String readFromInputStream(InputStream inputStream) throws IOException {
    StringBuilder resultStringBuilder = new StringBuilder();
    try (BufferedReader br
           = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        resultStringBuilder.append(line).append("\n");
      }
    }
    return resultStringBuilder.toString();
  }
}
