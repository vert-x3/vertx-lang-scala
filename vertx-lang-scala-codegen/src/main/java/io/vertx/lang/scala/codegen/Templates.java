package io.vertx.lang.scala.codegen;

import io.vertx.codegen.*;
import io.vertx.codegen.doc.Doc;
import io.vertx.codegen.type.*;

import java.io.IOException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.vertx.codegen.Helper.getNonGenericType;

public class Templates {


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
    writable.put(ClassKind.OTHER, type -> getNonGenericType(type.getName()));
    writable.put(ClassKind.ASYNC_RESULT, t -> "AsyncResult" + (!((ParameterizedTypeInfo)t).getArgs().isEmpty() ? "[" + fromTypeToScalaTypeString(((ParameterizedTypeInfo)t).getArgs().get(0)) + "]" : "[_]"));
    writable.put(ClassKind.CLASS_TYPE, t -> "Class" + (((ParameterizedTypeInfo)t).getArgs().isEmpty() ? "[_]" : "[" + ((ParameterizedTypeInfo)t).getArgs().stream().map(Templates::fromTypeToScalaTypeString).collect(Collectors.joining(", ")) + "]"));

    writable.put(ClassKind.API, t -> {
      String ret = getNonGenericType(t.getName());
      if(t.isParameterized()) {
        if (((ParameterizedTypeInfo)t).getArgs().isEmpty()) {
          ret += "[_]";
        } else {
          ret += "[" + ((ParameterizedTypeInfo)t).getArgs().stream().map(Templates::fromTypeToScalaTypeString).collect(Collectors.joining(", ")) + "]";
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
    writable.put(ClassKind.OTHER, (name, type) ->  name + (type.isNullable() ? ".getOrElse(null)" : ""));
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


  public static final Map<ClassKind, Function<TypeInfo, String>> toJavaString;
  static {
    Map<ClassKind, Function<TypeInfo, String>> writable = new HashMap<>();
    writable.put(ClassKind.PRIMITIVE, type -> javaBasicToWrapperTyper.containsKey(type.getName()) ? javaBasicToWrapperTyper.get(type.getName()) : type.getName());
    writable.put(ClassKind.BOXED_PRIMITIVE, type -> javaBasicToWrapperTyper.containsKey(type.getName()) ? javaBasicToWrapperTyper.get(type.getName()) : type.getName());
    writable.put(ClassKind.STRING, type -> javaBasicToWrapperTyper.containsKey(type.getName()) ? javaBasicToWrapperTyper.get(type.getName()) : type.getName());
    writable.put(ClassKind.THROWABLE, TypeInfo::getSimpleName);
    writable.put(ClassKind.VOID, TypeInfo::getSimpleName);
    writable.put(ClassKind.JSON_OBJECT, TypeInfo::getSimpleName);
    writable.put(ClassKind.JSON_ARRAY, TypeInfo::getSimpleName);
    writable.put(ClassKind.ENUM, TypeInfo::getSimpleName);
    writable.put(ClassKind.OBJECT, TypeInfo::getSimpleName);
    writable.put(ClassKind.CLASS_TYPE, type -> type.getSimpleName() + "[" + convertArgListToScalaFormatedString(type) + "]");
    writable.put(ClassKind.HANDLER, type -> "Handler["+ toJavaType(((ParameterizedTypeInfo)type).getArg(0)) +"]");
    writable.put(ClassKind.ASYNC_RESULT, type -> getNonGenericType(type.getSimpleName()) + "["+ toJavaType(((ParameterizedTypeInfo)type).getArg(0)) +"]");
    writable.put(ClassKind.LIST, type -> "java.util.List["+ toJavaType(((ParameterizedTypeInfo)type).getArg(0)) +"]");
    writable.put(ClassKind.SET, type -> "java.util.Set["+ toJavaType(((ParameterizedTypeInfo)type).getArg(0)) +"]");
    writable.put(ClassKind.MAP, type -> "java.util.Map[String, "+ toJavaType(((ParameterizedTypeInfo)type).getArg(1)) +"]");
    writable.put(ClassKind.OTHER, TypeInfo::getName);
    writable.put(ClassKind.API, type -> {
      String ret = getNonGenericType(type.getName());
      if (type.isParameterized()) {
        ret += convertArgListToScalaFormatedString(type);
      } else if (!type.getRaw().getParams().isEmpty()) {
        String args = type.getRaw().getParams().stream().map(v -> "Object").collect(Collectors.joining(", "));
        ret += "[" + args + "]";
      }
      return ret;
    });

    toJavaString = Collections.unmodifiableMap(writable);
  }

  public static String convertArgListToScalaFormatedString(TypeInfo type) {
    if (type.isParameterized()) {
        return "[" + ((ParameterizedTypeInfo)type)
          .getArgs().stream()
          .map(Templates::toJavaType)
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
    return toScalaType.get(type.getKind()).apply(type);
  }

  /**
   * Generate conversion code to convert a given instance from Scala to Java:
   * 'scala.Int' becomes 'scala.Int.asInstanceOf[java.lang.Integer]'
   */
  public static String fromScalatoJavaWithConversion(String name, TypeInfo type) {
    return toJavaWithConversionFromScala.get(type.getKind()).apply(name, type);
  }

  /**
   * Generate the Java type name for a given Scala type name:
   * "scala.Int" becomes "java.lang.Integer"
   */
  public static String toJavaType(TypeInfo type) {
    return toJavaString.get(type.getKind()).apply(type);
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
    return typeParams.isEmpty() ? "" : "[" + typeParams.stream().map(TypeParamInfo::getName).collect(Collectors.joining(", ")) + "]";
  }

  public static String escapeIfKeyword(String possibleKeyword) {
    if (possibleKeyword.equals("type") || possibleKeyword.equals("object")) {
      return "`" + possibleKeyword + "`";
    }
    return possibleKeyword;
  }

  public static String convertToScalaNotation(String type) {
    return  type
      .replace("<", "[").replace(">", "]");
  }

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
          return method.getParams().stream().anyMatch(ParamInfo::isNullable);
        })
      .collect(Collectors.toList());
  }


  public static boolean isAsyncResultHandler(TypeInfo type) {
    return type.getKind() == ClassKind.HANDLER && ((ParameterizedTypeInfo)type).getArg(0).getKind() == ClassKind.ASYNC_RESULT;
  }

  public static boolean shouldMethodReturnAFuture(MethodInfo method) {
    int size = method.getParams().size();
    return size > 0 && isAsyncResultHandler(method.getParam(size-1).getType()) && !(method.getReturnType().getKind() == ClassKind.HANDLER);
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

  //Rendering output

  /**
   * Render a method that accepts a AsyncResult-Handler into one that returns a Scala-Future.
   * @param type
   * @param method
   * @return
   */
  public static String renderFutureMethod(TypeInfo type, MethodInfo method) {
    String ret = renderMethodDocs(type, method);

    List<ParamInfo> params = method.getParams();
    params = params.subList(0, params.size() - 1);
    String paramList = params.stream().map(param -> escapeIfKeyword(param.getName()) + ": " + convertToOptionIfNullable(param.getType().isNullable(), fromTypeToScalaTypeString(param.getType()))).collect(Collectors.joining(","));

    TypeInfo typeOfReturnedFuture = ((ParameterizedTypeInfo)((ParameterizedTypeInfo)method.getParam(method.getParams().size()-1).getType()).getArg(0)).getArg(0);
    String asyncType = typeOfReturnedFuture.getName().replace('<', '[').replace('>', ']');

    String methodName = escapeIfKeyword((method.getName().endsWith("Handler") ? method.getName().substring(0, method.getName().length()-7) : method.getName()) + "Future");

    ret +="def "+ methodName + assembleTypeParams(method.getTypeParams().stream().map(p -> (TypeParamInfo)p).collect(Collectors.toList())) + "(" + paramList + ") : scala.concurrent.Future[" + fromTypeToScalaTypeString(typeOfReturnedFuture) + "] = {\n" +
      "      val promise = concurrent.Promise[" + fromTypeToScalaTypeString(typeOfReturnedFuture)+ "]()\n" +
      "      " + invokeMethodAndUseProvidedHandler("asJava", method, "new Handler[AsyncResult[" + asyncType + "]] { override def handle(event: AsyncResult[" + asyncType + "]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(" + toScalaWithConversion("event.result()", typeOfReturnedFuture)) + "}})\n" +
      "      promise.future\n" +
      "}";
    return ret;
  }

  public static String renderMethodDocs(TypeInfo type, MethodInfo method) {
    String ret = "";

    if (method.getDoc() != null) {
      ret += Docs.methodDoc(type, method, "    ", true);
      ret += "\n";
    }

    return ret;
  }

  /**
   * Render a static method.
   * @param type
   * @param method
   * @return
   */
  public static String renderStaticMethod(ClassTypeInfo type, MethodInfo method) {
    String ret = renderMethodDocs(type, method);

    List<ParamInfo> params = method.getParams();
    String paramList = params.stream().map(param -> escapeIfKeyword(param.getName()) + ": " + convertToOptionIfNullable(param.getType().isNullable(), fromTypeToScalaTypeString(param.getType()))).collect(Collectors.joining(", "));

    String option = method.getReturnType().isNullable() ? "Option" : "";

    String exec = method.getReturnType().isNullable() ? "scala.Option(" + invokeMethodWithoutConvertingReturn(type.getName(), method) + ")" : invokeMethodWithoutConvertingReturn(type.getName(), method);


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
    String ret = renderMethodDocs(type, method);

    List<ParamInfo> params = method.getParams();
    String paramList = params.stream().map(param -> escapeIfKeyword(param.getName()) + ": " + convertToOptionIfNullable(param.getType().isNullable(), fromTypeToScalaTypeString(param.getType()))).collect(Collectors.joining(", "));

    String option = method.getReturnType().isNullable() ? "Option" : "";

    ret +="def "+ escapeIfKeyword(method.getName())+ option + assembleTypeParams(method.getTypeParams().stream().map(p -> (TypeParamInfo)p).collect(Collectors.toList())) + "(" + paramList + ") = {\n" +
      "      " + wrapInOptionIfNullable(method.getReturnType().isNullable(), invokeMethodWithoutConvertingReturn("asJava", method)) + "\n" +
      "}";
    return ret;
  }

  /**
   * Takes care of rendering DataObjects.
   */
  public static String renderDataobject(String className, ClassTypeInfo type, boolean concrete, boolean hasEmptyConstructor) {
    if (concrete) {
        return "  type " +className + " = "+ getNonGenericType(type.getName()) +"\n" +
        "  object " + Helper.getSimpleName(type.getName()) + " {\n" +
          (hasEmptyConstructor ? "    def apply() = new " + Helper.getSimpleName(type.getName()) + "()\n" : "") +
        "    def apply(json: JsonObject) = new " + Helper.getSimpleName(type.getName()) + "(json)\n" +
        "  }\n";
    }
    return "";
  }

  /**
   * Takes care of rendering all APP-classes except DataObjects.
   */
  public static String renderClass(ClassTypeInfo type, Doc doc, String className, List<MethodInfo> nullableMethods, List<MethodInfo> futureMethods, String nonGenericType, Collection<TypeParamInfo> typeParams) throws IOException{

    String docs = doc != null ? "  /**\n" +
      Docs.renderDoc(type, "    *", doc) + "\n" +
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
      ("Vertx".equals(className) ? RenderHelpers.renderFile("extensions/VertxObject.ftl")+ "\n" : "") +
      "  implicit class "+ className + "Scala" + assembleTypeParams(typeParams) + "(val asJava: " + nonGenericType + assembleTypeParams(typeParams) + ") extends AnyVal {\n" +
      ("Vertx".equals(className) ? RenderHelpers.renderFile("extensions/Vertx.ftl")+ "\n" : "") +
      ("Vertx".equals(className) ? RenderHelpers.renderFile("extensions/executeblocking.ftl")+ "\n" : "") +
      ("Context".equals(className) ? RenderHelpers.renderFile("extensions/executeblocking.ftl") + "\n" : "") +
      ("WorkerExecutor".equals(className) ? RenderHelpers.renderFile("extensions/executeblocking.ftl") + "\n" : "") +
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
    String nonGenericType = getNonGenericType(type.toString());
    String translatedPackage = type.getModule().translatePackageName("scala");
    String modulePackage = translatedPackage.substring(0, translatedPackage.lastIndexOf('.'));
    String moduleName = translatedPackage.substring(translatedPackage.lastIndexOf('.') + 1);

    List<MethodInfo> nullableMethods = findNullableMethods(instanceMethods);
    List<MethodInfo> futureMethods = findFutureMethods(instanceMethods);

    String header = "";
    if (incrementalIndex == 0) {
      header =
        RenderHelpers.renderFile("extensions/LicenseHeader.ftl")+ "\n" +
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
          ("core".equals(moduleName) ? RenderHelpers.renderFile("extensions/Json.ftl") + "\n" : "") +
        "\n";
    }

    String body = "";
    if(type.getDataObject() != null) {
      body = renderDataobject(type.getSimpleName(), type, concrete, hasEmptyConstructor) + "\n";
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
        ("Message".equals(type.getSimpleName()) ? RenderHelpers.renderFile("extensions/Message.ftl") : "") +
      "\n" +
        (incrementalIndex == incrementalSize-1 ? "}\n" : "");
  }

}
