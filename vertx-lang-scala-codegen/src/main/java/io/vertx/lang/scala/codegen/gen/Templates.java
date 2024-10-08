package io.vertx.lang.scala.codegen.gen;

import io.vertx.codegen.*;
import io.vertx.codegen.processor.DataObjectModel;
import io.vertx.codegen.processor.Helper;
import io.vertx.codegen.processor.MethodInfo;
import io.vertx.codegen.processor.Model;
import io.vertx.codegen.processor.ParamInfo;
import io.vertx.codegen.processor.PropertyInfo;
import io.vertx.codegen.processor.TypeParamInfo;
import io.vertx.codegen.processor.doc.Doc;
import io.vertx.codegen.processor.type.ClassKind;
import io.vertx.codegen.processor.type.ClassTypeInfo;
import io.vertx.codegen.processor.type.ParameterizedTypeInfo;
import io.vertx.codegen.processor.type.TypeInfo;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import static io.vertx.codegen.processor.Helper.getNonGenericType;
import static io.vertx.codegen.processor.type.ClassKind.*;

public class Templates {

  private static final Map<String, String> javaBasicToWrapperTyper = new HashMap<String, String>() {
    {
      put("byte", "java.lang.Byte");
      put("java.lang.Byte", "java.lang.Byte");
      put("short", "java.lang.Short");
      put("java.lang.Short", "java.lang.Short");
      put("int", "java.lang.Integer");
      put("java.lang.Integer", "java.lang.Integer");
      put("long", "java.lang.Long");
      put("java.lang.Long", "java.lang.Long");
      put("float", "java.lang.Float");
      put("java.lang.Float", "java.lang.Float");
      put("double", "java.lang.Double");
      put("java.lang.Double", "java.lang.Double");
      put("boolean", "java.lang.Boolean");
      put("java.lang.Boolean", "java.lang.Boolean");
      put("char", "java.lang.Character");
      put("java.lang.Character", "java.lang.Character");
      put("String", "java.lang.String");
      put("java.lang.String", "java.lang.String");
    }
  };

  private static final Map<String, String> javaBasicToScalaType = new HashMap<String, String>() {
    {
      put("byte", "Byte");
      put("java.lang.Byte", "Byte");
      put("short", "Short");
      put("java.lang.Short", "Short");
      put("int", "Int");
      put("java.lang.Integer", "Int");
      put("long", "Long");
      put("java.lang.Long", "Long");
      put("float", "Float");
      put("java.lang.Float", "Float");
      put("double", "Double");
      put("java.lang.Double", "Double");
      put("boolean", "Boolean");
      put("java.lang.Boolean", "Boolean");
      put("char", "Char");
      put("java.lang.Character", "Char");
      put("String", "String");
      put("java.lang.String", "String");
    }
  };

  private static final Map<ClassKind, Function<TypeInfo, String>> toScalaType = new HashMap<ClassKind, Function<TypeInfo, String>>() {
    {
      put(VOID, t -> "Void");
      put(OBJECT, t -> t.isVariable() ? t.getName() : "AnyRef");
      put(THROWABLE, t -> "Throwable");
      put(STRING, t -> javaBasicToWrapperTyper.get(t.getName()));
      put(PRIMITIVE, t -> javaBasicToWrapperTyper.get(t.getName()));
      put(BOXED_PRIMITIVE, t -> javaBasicToWrapperTyper.get(t.getName()));
      put(LIST,
          t -> "scala.collection.mutable.Buffer" + ((!((ParameterizedTypeInfo) t).getArgs().isEmpty())
              ? "[" + fromTypeToScalaTypeString(((ParameterizedTypeInfo) t).getArgs().get(0)) + "]"
              : ""));
      put(SET,
          t -> "scala.collection.mutable.Set" + ((!((ParameterizedTypeInfo) t).getArgs().isEmpty())
              ? "[" + fromTypeToScalaTypeString(((ParameterizedTypeInfo) t).getArgs().get(0)) + "]"
              : ""));
      put(MAP,
          t -> "scala.collection.mutable.Map" + ((!((ParameterizedTypeInfo) t).getArgs().isEmpty())
              ? "[String, " + fromTypeToScalaTypeString(((ParameterizedTypeInfo) t).getArgs().get(1)) + "]"
              : ""));
      put(HANDLER, t -> fromTypeToScalaTypeString(((ParameterizedTypeInfo) t).getArgs().get(0)) + " => Unit");
      put(JSON_OBJECT, TypeInfo::getName);
      put(JSON_ARRAY, TypeInfo::getName);
      put(ENUM, TypeInfo::getName);
      put(OTHER, type -> {
        if (type.getName().equals("byte[]")) {
          return "Array[Byte]";
        } else if (type.isParameterized()) {
          return toScalaParameterizedType(type);
        } else {
          return getNonGenericType(type.getName());
        }
      });
      put(CLASS_TYPE,
          t -> "Class" + (((ParameterizedTypeInfo) t).getArgs().isEmpty() ? "[?]"
              : "[" + ((ParameterizedTypeInfo) t).getArgs().stream().map(Templates::fromTypeToScalaTypeString)
                  .collect(Collectors.joining(", ")) + "]"));

      put(API, Templates::toScalaParameterizedType);

      put(FUNCTION, t -> {
        boolean paramIsVoid = ((ParameterizedTypeInfo) t).getArgs().get(0).getKind() == VOID;
        String type1 = fromTypeToScalaTypeString(((ParameterizedTypeInfo) t).getArgs().get(0));
        String type2 = fromTypeToScalaTypeString(((ParameterizedTypeInfo) t).getArgs().get(1));
        if (paramIsVoid) {
          return "() => " + type2;
        } else {
          return type1 + " => " + type2;
        }
      });
    }
  };

  private static final String toScalaParameterizedType(TypeInfo t) {
    String ret = getNonGenericType(t.getName());
    if (((ParameterizedTypeInfo) t).getArgs().isEmpty()) {
      ret += "[?]";
    } else {
      ret += "[" + ((ParameterizedTypeInfo) t).getArgs().stream().map(Templates::fromTypeToScalaTypeString)
          .collect(Collectors.joining(", ")) + "]";
    }
    return ret;
  }

  private static final Map<ClassKind, BiFunction<String, TypeInfo, String>> toJavaWithConversionFromScala = new HashMap<ClassKind, BiFunction<String, TypeInfo, String>>() {
    {
      put(VOID, (name, type) -> name);
      put(STRING, (name, type) -> name + (type.isNullable() ? ".getOrElse(null)" : ""));
      put(PRIMITIVE, (name, type) -> name + (type.isNullable() ? ".getOrElse(null)" : ""));
      put(BOXED_PRIMITIVE, (name, type) -> name + (type.isNullable() ? ".getOrElse(null)" : ""));
      put(THROWABLE, (name, type) -> name + (type.isNullable() ? ".getOrElse(null)" : ""));
      put(OBJECT, (name, type) -> name + (type.isNullable() ? ".getOrElse(null)" : ""));
      put(CLASS_TYPE, (name, type) -> name + (type.isNullable() ? ".getOrElse(null)" : ""));
      put(JSON_OBJECT, (name, type) -> name + (type.isNullable() ? ".getOrElse(null)" : ""));
      put(JSON_ARRAY, (name, type) -> name + (type.isNullable() ? ".getOrElse(null)" : ""));
      put(ENUM, (name, type) -> name + (type.isNullable() ? ".getOrElse(null)" : ""));
      put(API, (name, type) -> name + (type.isNullable() ? ".getOrElse(null)" : ""));
      put(HANDLER, (name, type) -> name + (type.isNullable() ? ".map(hdlr => hdlr" : "") + ".asInstanceOf["
          + convertToScalaGenericsNotation(type.toString()) + "]" + (type.isNullable() ? ").getOrElse(null)" : ""));
      put(SET, (name, type) -> name + (type.isNullable() ? ".map(_.asJava).getOrElse(null)" : ".asJava"));
      put(LIST, (name, type) -> name + (type.isNullable() ? ".map(_.asJava).getOrElse(null)" : ".asJava"));
      put(MAP, (name, type) -> name + (type.isNullable() ? ".map(_.asJava).getOrElse(null)" : ".asJava"));
      put(OTHER, (name, type) -> name + (type.isNullable() ? ".getOrElse(null)" : ""));
      put(FUNCTION, (name, type) -> {
        ParameterizedTypeInfo parameterizedType = (ParameterizedTypeInfo) type;
        String executed = name;
        if (parameterizedType.getArg(0).getKind() == VOID) {
          executed = executed + "()";
        } else {
          executed = executed + "(x)";
        }
        executed = fromScalatoJavaWithConversion(executed, parameterizedType.getArg(1));
        String ret = "{x: " + toJavaType(parameterizedType.getArg(0)) + " => " + executed + "}";
        if (type.isNullable()) {
          ret = name + ".map(" + name + " => " + ret + ").orNull";
        }
        return ret;
      });
    }
  };

  private static final Map<ClassKind, Function<TypeInfo, String>> toJavaString = new HashMap<ClassKind, Function<TypeInfo, String>>() {
    {
      put(PRIMITIVE,
          type -> javaBasicToWrapperTyper.containsKey(type.getName()) ? javaBasicToWrapperTyper.get(type.getName())
              : type.getName());
      put(BOXED_PRIMITIVE,
          type -> javaBasicToWrapperTyper.containsKey(type.getName()) ? javaBasicToWrapperTyper.get(type.getName())
              : type.getName());
      put(STRING,
          type -> javaBasicToWrapperTyper.containsKey(type.getName()) ? javaBasicToWrapperTyper.get(type.getName())
              : type.getName());
      put(THROWABLE, TypeInfo::getSimpleName);
      put(VOID, TypeInfo::getSimpleName);
      put(JSON_OBJECT, TypeInfo::getSimpleName);
      put(JSON_ARRAY, TypeInfo::getSimpleName);
      put(ENUM, TypeInfo::getSimpleName);
      put(OBJECT, TypeInfo::getSimpleName);
      put(CLASS_TYPE, type -> type.getSimpleName() + "[" + convertArgListToScalaFormatedString(type) + "]");
      put(HANDLER, type -> "Handler[" + toJavaType(((ParameterizedTypeInfo) type).getArg(0)) + "]");
      put(LIST, type -> "java.util.List[" + toJavaType(((ParameterizedTypeInfo) type).getArg(0)) + "]");
      put(SET, type -> "java.util.Set[" + toJavaType(((ParameterizedTypeInfo) type).getArg(0)) + "]");
      put(MAP, type -> "java.util.Map[String, " + toJavaType(((ParameterizedTypeInfo) type).getArg(1)) + "]");
      put(OTHER, TypeInfo::getName);
      put(API, type -> {
        String ret = getNonGenericType(type.getName());
        if (type.isParameterized()) {
          ret += convertArgListToScalaFormatedString(type);
        } else if (!type.getRaw().getParams().isEmpty()) {
          String args = type.getRaw().getParams().stream().map(v -> "Object").collect(Collectors.joining(", "));
          ret += "[" + args + "]";
        }
        return ret;
      });
    }
  };

  private static String convertArgListToScalaFormatedString(TypeInfo type) {
    return type.isParameterized() ? "["
        + ((ParameterizedTypeInfo) type).getArgs().stream().map(Templates::toJavaType).collect(Collectors.joining(", "))
        + "]" : "";
  }

  /**
   * Convert a given type parameter list into a Scala String representation.
   */
  private static String assembleTypeParamsForScala(Collection<TypeParamInfo> typeParams) {
    return typeParams.isEmpty() ? ""
        : "[" + typeParams.stream().map(TypeParamInfo::getName).collect(Collectors.joining(", ")) + "]";
  }

  private static String toScalaWithConversion(String name, TypeInfo type) {
    ClassKind kind = type.getKind();
    String conversion = "";

    if (kind.collection) {
      conversion = ".asScala";
    }

    return name + conversion;
  }

  private static String fromTypeToScalaTypeString(TypeInfo type) {
    return toScalaType.get(type.getKind()).apply(type);
  }

  /**
   * Generate conversion code to convert a given instance from Scala to Java:
   * 'scala.Int' becomes 'scala.Int.asInstanceOf[java.lang.Integer]'
   */
  private static String fromScalatoJavaWithConversion(String name, TypeInfo type) {
    return toJavaWithConversionFromScala.get(type.getKind()).apply(name, type);
  }

  /**
   * Generate the Java type name for a given Scala type name:
   * "scala.Int" becomes "java.lang.Integer"
   */
  private static String toJavaType(TypeInfo type) {
    return toJavaString.get(type.getKind()).apply(type);
  }

  private static String makeTypeOptionIfNullable(boolean nullable, String expression) {
    if (nullable) {
      return "scala.Option[" + expression + "]";
    } else {
      return expression;
    }
  }

  private static String convertToOptionIfNullable(boolean nullable, String expression) {
    if (nullable) {
      return "scala.Option(" + expression + ")";
    } else {
      return expression;
    }
  }

  /**
   * Some keywords that are legal in Java can only be used when quoted in Scala
   */
  private static String quoteIfScalaKeyword(String possibleKeyword) {
    if (possibleKeyword.equals("type") || possibleKeyword.equals("object") || possibleKeyword.equals("match")) {
      return "`" + possibleKeyword + "`";
    }
    return possibleKeyword;
  }

  /**
   * Convert a String containing generics to the Scala notation.
   */
  public static String convertToScalaGenericsNotation(String type) {
    return type
        .replace("<", "[").replace(">", "]");
  }

  // METHODS

  /**
   * Since some methods lack necessary type infos for scala we
   * will exclude these from rendering.
   *
   * @see <a href=
   *      "https://github.com/vert-x3/vertx-lang-scala/issues/23">Issue</a>
   */
  private static boolean keepMethod(MethodInfo method) {
    return !method.getName().equals("addInterceptor") && !method.getName().equals("removeInterceptor");
  }

  /**
   * Find methods accepting collections.
   */
  private static List<MethodInfo> findMethodsAcceptingCollections(List<MethodInfo> methods) {
    if (methods == null)
      return Collections.emptyList();
    return methods.stream()
        .filter(Templates::keepMethod)
        .filter(method -> !shouldMethodReturnAFuture(method) && method.isFluent() && !method.isCacheReturn()
            && !method.isStaticMethod() && !method.isDefaultMethod())
        .filter(method -> method.getParams().stream().anyMatch(param -> param.getType().getKind().collection))
        .collect(Collectors.toList());
  }

  /**
   * Find methods which are default methods.
   */
  private static List<MethodInfo> findDefaultMethods(List<MethodInfo> methods) {
    if (methods == null)
      return Collections.emptyList();
    return methods.stream()
        .filter(Templates::keepMethod)
        .filter(method -> method.isDefaultMethod() && !method.isFluent() && !method.isCacheReturn())
        .collect(Collectors.toList());
  }

  /**
   * Find methods which implement the fluent API-style.
   */
  private static List<MethodInfo> findFluentMethods(List<MethodInfo> methods) {
    if (methods == null)
      return Collections.emptyList();
    return methods.stream()
        .filter(Templates::keepMethod)
        .filter(method -> method.isFluent() && !method.isCacheReturn())
        .collect(Collectors.toList());
  }

  /**
   * Find methods which return a value that can be cached.
   */
  private static List<MethodInfo> findCacheReturnMethods(List<MethodInfo> methods) {
    if (methods == null)
      return Collections.emptyList();
    return methods.stream()
        .filter(Templates::keepMethod)
        .filter(MethodInfo::isCacheReturn)
        .collect(Collectors.toList());
  }

  private static List<MethodInfo> findFutureMethods(List<MethodInfo> methods) {
    if (methods == null)
      return Collections.emptyList();
    return methods.stream()
        .filter(Templates::keepMethod)
        .filter(Templates::shouldMethodReturnAFuture)
        .collect(Collectors.toList());
  }

  private static List<MethodInfo> findNullableMethods(List<MethodInfo> methods) {
    if (methods == null)
      return Collections.emptyList();
    return methods.stream()
        .filter(Templates::keepMethod)
        .filter(method -> {
          if (method.getReturnType().isNullable()) {
            return true;
          }
          return method.getParams().stream().anyMatch(ParamInfo::isNullable);
        })
        .collect(Collectors.toList());
  }

  private static boolean shouldMethodReturnAFuture(MethodInfo method) {
    return method.getReturnType().getKind() == ClassKind.FUTURE;
  }

  private static String assembleTypeParamString(MethodInfo method) {
    if (!method.getTypeParams().isEmpty()) {
      return "[" + method.getTypeParams().stream().map(TypeParamInfo::getName).collect(Collectors.joining(", ")) + "]";
    }
    return "";
  }

  private static String invokeMethodWithoutConvertingReturn(String target, MethodInfo method) {
    String paramString = method.getParams().stream()
        .map(param -> fromScalatoJavaWithConversion(quoteIfScalaKeyword(param.getName()), param.getType()))
        .collect(Collectors.joining(", "));

    return target + "." + quoteIfScalaKeyword(method.getName()) + assembleTypeParamString(method) + "(" + paramString
        + ")";
  }

  private static String invokeMethodAndUseProvidedHandler(String target, MethodInfo method, String handler) {
    String typeParamString = assembleTypeParamString(method);

    String paramString = method.getParams().stream()
        .map(param -> fromScalatoJavaWithConversion(quoteIfScalaKeyword(param.getName()), param.getType()))
        .collect(Collectors.joining(", "));

    return target + "." + quoteIfScalaKeyword(method.getName()) + typeParamString + "(" + paramString + ")";
  }

  // Rendering output

  private static String renderMethodDocs(TypeInfo type, MethodInfo method, boolean future) {
    String ret = "";

    if (method.getDoc() != null) {
      ret += Docs.methodDoc(type, method, "    ", future);
      ret += "\n";
    }

    return ret;
  }

  /**
   * Render methods that take a convertable argument..
   */
  private static String renderBasicMethod(TypeInfo type, MethodInfo method) {
    String ret = renderMethodDocs(type, method, false);

    List<ParamInfo> params = method.getParams();
    String paramList = params.stream()
        .map(param -> quoteIfScalaKeyword(param.getName()) + ": "
            + makeTypeOptionIfNullable(param.getType().isNullable(), fromTypeToScalaTypeString(param.getType())))
        .collect(Collectors.joining(", "));

    ret += "  def " + quoteIfScalaKeyword(method.getName())
        + assembleTypeParamsForScala(
            method.getTypeParams().stream().map(p -> (TypeParamInfo) p).collect(Collectors.toList()))
        + "(" + paramList + ") = {\n" +
        "      " + invokeMethodWithoutConvertingReturn("asJava", method) + "\n" +
        "  }\n";
    return ret;
  }

  /**
   * Render a method that accepts a AsyncResult-Handler into one that returns a
   * Scala-Future.
   */
  private static String renderFutureMethod(TypeInfo type, MethodInfo method) {
    String ret = renderMethodDocs(type, method, true);

    List<ParamInfo> params = method.getParams();
    params = params.subList(0, params.size() - 1);
    String paramList = params.stream()
        .map(param -> quoteIfScalaKeyword(param.getName()) + ": "
            + makeTypeOptionIfNullable(param.getType().isNullable(), fromTypeToScalaTypeString(param.getType())))
        .collect(Collectors.joining(", "));

    TypeInfo typeOfReturnedFuture = ((ParameterizedTypeInfo) ((ParameterizedTypeInfo) method
        .getParam(method.getParams().size() - 1).getType()).getArg(0)).getArg(0);
    String asyncType = convertToScalaGenericsNotation(typeOfReturnedFuture.getName());

    String methodName = quoteIfScalaKeyword(
        (method.getName().endsWith("Handler") ? method.getName().substring(0, method.getName().length() - 7)
            : method.getName()) + "Future");

    String typeToBeReturned = typeOfReturnedFuture.getKind() != API ? fromTypeToScalaTypeString(typeOfReturnedFuture)
        : asyncType;

    ret += "  def " + methodName
        + assembleTypeParamsForScala(
            method.getTypeParams().stream().map(p -> (TypeParamInfo) p).collect(Collectors.toList()))
        + "(" + paramList + ") : scala.concurrent.Future[" + typeToBeReturned + "] = {\n" +
        "      val promise = concurrent.Promise[" + typeToBeReturned + "]/*" + asyncType + " "
        + typeOfReturnedFuture.getKind() + "*/()\n" +
        "      "
        + invokeMethodAndUseProvidedHandler("asJava", method,
            "new Handler[AsyncResult[" + asyncType + "]] { override def handle(event: AsyncResult[" + asyncType
                + "]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success("
                + toScalaWithConversion("event.result()", typeOfReturnedFuture))
        + "}})\n" +
        "      promise.future\n" +
        "  }\n";
    return ret;
  }

  /**
   * Render a static method.
   */
  private static String renderStaticMethod(ClassTypeInfo type, MethodInfo method) {
    String ret = renderMethodDocs(type, method, method.getReturnType().isNullable());

    List<ParamInfo> params = method.getParams();
    String paramList = params.stream()
        .map(param -> quoteIfScalaKeyword(param.getName()) + ": "
            + makeTypeOptionIfNullable(param.getType().isNullable(), fromTypeToScalaTypeString(param.getType())))
        .collect(Collectors.joining(", "));

    String option = method.getReturnType().isNullable() ? "Option" : "";

    String exec = method.getReturnType().isNullable()
        ? "scala.Option(" + invokeMethodWithoutConvertingReturn(type.getName(), method) + ")"
        : invokeMethodWithoutConvertingReturn(type.getName(), method);

    ret += "  def " + quoteIfScalaKeyword(method.getName()) + option
        + assembleTypeParamsForScala(
            method.getTypeParams().stream().map(p -> (TypeParamInfo) p).collect(Collectors.toList()))
        + "(" + paramList + ") = {\n" +
        "      " + exec + "\n" +
        "  }\n";
    return ret;
  }

  /**
   * Render methods with a nullable return-type so they return a scala.Option
   * instead.
   */
  private static String renderNullableMethod(ClassTypeInfo type, MethodInfo method) {
    String ret = renderMethodDocs(type, method, method.getReturnType().isNullable());

    List<ParamInfo> params = method.getParams();
    String paramList = params.stream()
        .map(param -> quoteIfScalaKeyword(param.getName()) + ": "
            + makeTypeOptionIfNullable(param.getType().isNullable(), fromTypeToScalaTypeString(param.getType())))
        .collect(Collectors.joining(", "));

    String option = method.getReturnType().isNullable() ? "Option" : "";

    ret += "  def " + quoteIfScalaKeyword(method.getName()) + option
        + assembleTypeParamsForScala(
            method.getTypeParams().stream().map(p -> (TypeParamInfo) p).collect(Collectors.toList()))
        + "(" + paramList + ") = {\n" +
        "      "
        + convertToOptionIfNullable(method.getReturnType().isNullable(),
            invokeMethodWithoutConvertingReturn("asJava", method))
        + "\n" +
        "  }\n";
    return ret;
  }

  /**
   * Takes care of rendering DataObjects.
   */
  private static String renderDataobject(DataObjectModel model, String className, ClassTypeInfo type) {
    String constructor = "";

    if ((model.hasEmptyConstructor() || model.hasJsonConstructor())
        && model.getPropertyMap().values().stream().anyMatch(pi -> pi.isSetter() && !pi.isDeprecated())) {
      if (model.hasJsonConstructor()) {
        constructor = applyDataObject(model, type) + " = {\n" +
            "      val ret = new " + Helper.getSimpleName(type.getName())
            + "(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))\n"
            +
            dataObjectSetters(model, type) + "\n" +
            "      ret\n" +
            "    }";
      } else {
        constructor = applyDataObject(model, type) + " = {\n" +
            "      val ret = new " + Helper.getSimpleName(type.getName()) + "()\n" +
            dataObjectSetters(model, type) + "\n" +
            "      ret\n" +
            "    }";
      }

    }

    if (model.isConcrete()) {
      return "  type " + className + " = " + getNonGenericType(type.getName()) + "\n" +
          "  object " + Helper.getSimpleName(type.getName()) + " {\n" +
          (model.hasJsonConstructor()
              ? "    def apply(json: JsonObject) = new " + Helper.getSimpleName(type.getName()) + "(json)\n"
              : "")
          +
          (model.hasStringConstructor()
              ? "    def apply(str: String) = new " + Helper.getSimpleName(type.getName()) + "(str)\n"
              : "")
          +
          constructor + "\n" +
          "  }\n";
    }
    return "";
  }

  private static String applyDataObject(DataObjectModel model, ClassTypeInfo type) {
    Set<Entry<String, PropertyInfo>> dataObjectProperties = model.getPropertyMap().entrySet();
    return "    def apply( " + dataObjectProperties.stream()
        .filter(e -> !e.getValue().isDeprecated())
        .map(entry -> {
          String propertyName = entry.getKey();
          PropertyInfo propertyType = entry.getValue();
          if (propertyType.isList()) {
            if (propertyType.isSetter()) {
              return quoteIfScalaKeyword(propertyName) + ": scala.collection.immutable.List["
                  + propertyType.getType().getName() + "] = null";
            }
          } else if (propertyType.isSet()) {
            if (propertyType.isSetter()) {
              return quoteIfScalaKeyword(propertyName) + ": scala.collection.immutable.Set["
                  + propertyType.getType().getName() + "] = null";
            }
          } else if (propertyType.isMap()) {
            if (propertyType.isSetter()) {
              return quoteIfScalaKeyword(propertyName) + ": scala.collection.immutable.Map[String,"
                  + propertyType.getType().getName() + "] = null";
            }
          } else {
            return quoteIfScalaKeyword(propertyName) + ": "
                + toScalaType.get(propertyType.getType().getKind()).apply(propertyType.getType()) + " = null";
          }
          return null;
        })
        .filter(Objects::nonNull)
        .collect(Collectors.joining(", ")) + "): " + Helper.getSimpleName(type.getName());
  }

  private static String dataObjectSetters(DataObjectModel model, ClassTypeInfo type) {
    return model.getPropertyMap().entrySet().stream()
        .filter(e -> !e.getValue().isDeprecated())
        .map(entry -> {
          String propertyName = entry.getKey();
          PropertyInfo propertyType = entry.getValue();
          if (propertyType.isSetter()) {
            String conv = "";
            if (propertyType.isList()) {
              conv = ".asJava";
            } else if (propertyType.isSet()) {
              conv = ".asJava";
            } else if (propertyType.isMap()) {
              conv = ".asJava";
            }
            return "      if (" + quoteIfScalaKeyword(propertyName) + " != null) ret."
                + entry.getValue().getSetterMethod() + "(" + quoteIfScalaKeyword(propertyName) + conv + ") ";
          }
          return null;
        })
        .filter(Objects::nonNull)
        .collect(Collectors.joining("\n"));
  }

  /**
   * Takes care of rendering all APP-classes except DataObjects.
   */
  private static String renderClass(ClassTypeInfo type, Doc doc, String className, List<MethodInfo> nullableMethods,
      List<MethodInfo> futureMethods, List<MethodInfo> basicMethods, String nonGenericType,
      Collection<TypeParamInfo> typeParams) throws IOException {

    String docs = doc != null ? "  /**\n" +
        Docs.renderDoc(type, "    *", doc) + "\n" +
        "    */\n"
        : "";

    String nullableMethodsRendered = (!"CompositeFuture".equals(className) && !"Future".equals(className))
        ? nullableMethods.stream().filter(method -> !method.getName().equals("executeBlocking"))
            .map(method -> renderNullableMethod(type, method))
            .collect(Collectors.joining("\n"))
        : "";

    String futureMethodsRendered = futureMethods.stream().filter(method -> !method.getName().equals("executeBlocking"))
        .map(method -> renderFutureMethod(type, method))
        .collect(Collectors.joining("\n"));

    String basicMethodsRendered = basicMethods.stream().filter(method -> !method.getName().equals("executeBlocking"))
        .map(method -> renderBasicMethod(type, method))
        .collect(Collectors.joining("\n"));

    return "\n" +
        docs +
        "\n" +
        ("Vertx".equals(className) ? RenderHelpers.renderFile("extensions/VertxObject.ftl") + "\n" : "") +
        "  implicit class " + className + "Scala" + assembleTypeParamsForScala(typeParams) + "(val asJava: "
        + nonGenericType + assembleTypeParamsForScala(typeParams) + ") extends AnyVal {\n" +
        ("Vertx".equals(className) ? RenderHelpers.renderFile("extensions/Vertx.ftl") + "\n" : "") +
        ("Vertx".equals(className) ? RenderHelpers.renderFile("extensions/executeblocking.ftl") + "\n" : "") +
        ("Context".equals(className) ? RenderHelpers.renderFile("extensions/executeblocking.ftl") + "\n" : "") +
        ("WorkerExecutor".equals(className) ? RenderHelpers.renderFile("extensions/executeblocking.ftl") + "\n" : "") +
        "\n" +
        nullableMethodsRendered +
        "\n" +
        futureMethodsRendered +
        "\n" +
        basicMethodsRendered +
        "\n" +
        "  }\n";
  }

  /**
   * Main entry point which renders the package-object.
   * It takes care of the incremental rendering part.
   */
  public static String renderPackageObject(Model model, ClassTypeInfo type, int incrementalIndex, int incrementalSize,
      Set<String> imps, Boolean concrete, Boolean hasEmptyConstructor, Doc doc, List<MethodInfo> instanceMethods,
      List<MethodInfo> staticMethods, Collection<TypeParamInfo> typeParams) throws IOException {
    String nonGenericType = getNonGenericType(type.toString());
    String translatedPackage = type.getModule().translatePackageName("scala");
    String modulePackage = translatedPackage.substring(0, translatedPackage.lastIndexOf('.'));
    String moduleName = translatedPackage.substring(translatedPackage.lastIndexOf('.') + 1);

    List<MethodInfo> nullableMethods = findNullableMethods(instanceMethods);
    List<MethodInfo> futureMethods = findFutureMethods(instanceMethods);
    List<MethodInfo> basicMethods = findMethodsAcceptingCollections(instanceMethods);

    String header = "";
    if (incrementalIndex == 0) {
      header = RenderHelpers.renderFile("extensions/LicenseHeader.ftl") + "\n" +
          "\n" +
          "package " + modulePackage + "\n" +
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
          "package object " + moduleName + "{\n" +
          "\n" +
          ("core".equals(moduleName) ? RenderHelpers.renderFile("extensions/Json.ftl") + "\n" : "") +
          "\n";
    }

    String body = "";
    if (model instanceof DataObjectModel && !((DataObjectModel) model).isDeprecated()) {
      body = renderDataobject((DataObjectModel) model, type.getSimpleName(), type) + "\n";
    } else if (type.getKind() != HANDLER && !futureMethods.isEmpty()) {
      body = renderClass(type, doc, type.getSimpleName(), nullableMethods, futureMethods, basicMethods, nonGenericType,
          typeParams) + "\n";
    } else if (type.getKind() != HANDLER && (staticMethods != null && !staticMethods.isEmpty())
        && !"Message".equals(type.getSimpleName())) {
      body = "  object " + type.getSimpleName() + " {\n" +
          (staticMethods.stream().map(method -> renderStaticMethod(type, method)).collect(Collectors.joining("\n"))) +
          "  }\n";
    }

    return header +
        body +
        "\n" +
        ("Message".equals(type.getSimpleName()) ? RenderHelpers.renderFile("extensions/Message.ftl") : "") +
        "\n" +
        (incrementalIndex == incrementalSize - 1 ? "}\n" : "");
  }

}
