package io.vertx.lang.scala.codegen;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.annotation.processing.ProcessingEnvironment;

import io.vertx.codegen.ClassModel;
import io.vertx.codegen.Generator;
import io.vertx.codegen.MethodInfo;
import io.vertx.codegen.MethodKind;
import io.vertx.codegen.ParamInfo;
import io.vertx.codegen.TypeParamInfo;
import io.vertx.codegen.type.ClassKind;
import io.vertx.codegen.type.ParameterizedTypeInfo;
import io.vertx.codegen.type.TypeInfo;

import static java.util.stream.Collectors.joining;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ScalaGenerator extends Generator<ClassModel> {

  private static final Set<String> genericClasses = new HashSet<>();
  static {
    genericClasses.add("io.vertx.core.eventbus.MessageConsumer");
  }

  private static final Map<String, Predicate<MethodInfo>> overrideMethods = new HashMap<>();
  private static final Predicate<MethodInfo> noParams = mi -> mi.getParams().isEmpty();
  static {
    overrideMethods.put("toString", noParams);
    overrideMethods.put("hashCode", noParams);
    overrideMethods.put("equals", noParams);
  }

  @Override
  public void load(ProcessingEnvironment processingEnv) {
    super.load(processingEnv);
  }

  @Override
  public String filename(ClassModel model) {

    return "scala/" + model.getType()
        .translatePackageName("scala")
        .replace('.', '/') + "/" + className(model) + ".scala";
  }

  @Override
  public String render(ClassModel model, int index, int size, Map<String, Object> session) {
    // Skip deprecated classes
    if (model.isDeprecated()) {
      return null;
    }

    Set<String> imports = new HashSet<>();
    String methods = model.getInstanceMethods().stream()
        .filter(not(MethodInfo::isDeprecated))
        .filter(not(m -> m.getKind() == MethodKind.CALLBACK))
        .map(m -> renderMethod(m, imports))
        .collect(joining("\n\n"));

    String _type = model.isConcrete() ? "class" : "trait";
    String typeParamList = convertClassTypeParams(model.getTypeParams());
    String constructor = "delegate: " + model.getType().getName() + typeParamList;

    return "package " + model.getModule().translatePackageName("scala") + "\n\n"
        + String.join("\n", imports) + "\n\n"
        + "/** " + model.getType().getKind().name() + "*/\n"
        + _type + " " + className(model) + typeParamList + "(" + constructor + ")" + ":\n\n"
        + methods + "\n\n"
        + "end " + className(model);
  }

  private String renderMethod(MethodInfo m, Set<String> imports) {
    String typeParamList = m.getTypeParams().stream()
        .map(TypeParamInfo.Method::getName)
        .reduce((a, b) -> String.join(",", a, b))
        .map(tpl -> "[" + tpl + "]")
        .orElse("");

    String paramList = m.getParams().stream()
        .map(pi -> {
          String typeDesc = convertTypeInfo(pi.getType(), imports);
          return String.format("%s: %s", quoteForScala(pi.getName()), typeDesc);
        })
        .reduce((a, b) -> String.join(", ", a, b))
        .orElse("");

    String overrideString = renderOverrideString(m);
    String methodName = quoteForScala(m.getName());
    String returnType = convertTypeInfo(m.getReturnType(), imports);
    String impl = createImplementation(m);

    return "  //params: " + m.getParams().stream()
        .map(pi -> pi.getType().getName() + " " + pi.getName())
        .collect(joining("\n    //"))
        + "\n  //returns: " + m.getReturnType().getName()
        + "\n  " + overrideString + "def " + methodName + typeParamList + "(" + paramList + "): " + returnType + " = "
        + impl;
  }

  private String renderOverrideString(MethodInfo methodInfo) {
    Predicate<MethodInfo> doesOverride = overrideMethods.getOrDefault(methodInfo.getName(), __ -> false);
    return doesOverride.test(methodInfo) ? "override " : "";
  }

  private String convertTypeInfo(TypeInfo typeInfo, Set<String> imports) {
    Function<String, String> typeConverter = typeName -> this.toScalaType(typeName, imports);
    return convertTypeInfo(typeInfo, false, typeConverter);
  }

  private String convertTypeInfo(
      TypeInfo typeInfo,
      Boolean isTypeParam,
      Function<String, String> toScalaTypeConverter) {

    boolean isCollection = typeInfo.isParameterized() && isCollection(typeInfo.getRaw().getKind());

    // Parameters and return types which are collections and not type parameters
    // itself
    if (isCollection && !isTypeParam) {
      ParameterizedTypeInfo pti = (ParameterizedTypeInfo) typeInfo;
      return pti.getArgs().stream()
          .map(parameterTypeInfo -> toScalaTypeConverter.apply(parameterTypeInfo.getName()))
          .reduce((a, b) -> String.join(",", a, b))
          .map(til -> toScalaTypeConverter.apply(pti.getRaw().getName()) + "[" + til + "]")
          .orElse("");
      // All other parameterized types
    } else if (typeInfo.isParameterized()) {
      ParameterizedTypeInfo pti = ((ParameterizedTypeInfo) typeInfo);
      return pti.getArgs().stream()
          .map(parameterTypeInfo -> convertTypeInfo(parameterTypeInfo, true, toScalaTypeConverter))
          .reduce((a, b) -> String.join(",", a, b))
          .map(til -> pti.getRaw().getName() + "[" + til + "]")
          .orElse("[?]");
      // All type params of other parameterized types
    } else if (isTypeParam) {
      return typeInfo.getName();
    } else {
      String wildcardTypeParam = genericClasses.contains(typeInfo.getName()) ? "[?]" : "";
      return toScalaTypeConverter.apply(typeInfo.getName()) + wildcardTypeParam;
    }
  }

  private String createImplementation(MethodInfo methodInfo) {
    String methodName = quoteForScala(methodInfo.getName());
    if (methodInfo.getKind() == MethodKind.CALLBACK) {
      return "???";
    } else if (methodInfo.getKind() == MethodKind.FUTURE) {
      return "???";
    } else if (methodInfo.getKind() == MethodKind.HANDLER) {
      return "???";
    } else {
      String callParamList = methodInfo.getParams().stream()
          .map(this::addAsJava)
          .reduce((a, b) -> String.join(", ", a, b))
          .orElse("");

      return "\n    delegate." + methodName + "(" + callParamList + ")"
          + addAsScala("", methodInfo.getReturnType())
          + addReturnTypeConversion(methodInfo.getReturnType());
    }
  }

  private String convertClassTypeParams(List<TypeParamInfo.Class> typeParams) {
    return typeParams.stream()
        .map(TypeParamInfo.Class::getName)
        .reduce((a, b) -> String.join(",", a, b))
        .map(tpl -> "[" + tpl + "]")
        .orElse("");
  }

  private String addAsJava(ParamInfo paramInfo) {
    String paramName = quoteForScala(paramInfo.getName());
    String paramTypeName = paramInfo.getType().getName();
    if (paramTypeName.startsWith("java.util.List")
        || paramTypeName.startsWith("java.util.Map")
        || paramTypeName.startsWith("java.util.Set")) {
      return paramName + addParameterConversion(paramInfo.getType()) + ".asJava";
    } else {
      return paramName;
    }
  }

  private String addAsScala(String paramName, TypeInfo ti) {
    String typeName = ti.getName();
    if (typeName.startsWith("java.util.List")
        || typeName.startsWith("java.util.Map")
        || typeName.startsWith("java.util.Set")) {
      return paramName + ".asScala";
    } else {
      return paramName;
    }
  }

  private String addParameterConversion(TypeInfo ti) {
    Function<String, Optional<String>> toJavaBoxed = typeParamName -> {
      if (typeParamName.equals("java.lang.Integer")) {
        return Optional.of("Int.box(_)");
      } else if (typeParamName.equals("java.lang.Long")) {
        return Optional.of("Long.box(_)");
      } else if (typeParamName.equals("java.lang.Byte")) {
        return Optional.of("Byte.box(_)");
      } else if (typeParamName.equals("java.lang.Character")) {
        return Optional.of("Char.box(_)");
      } else if (typeParamName.equals("java.lang.Short")) {
        return Optional.of("Short.box(_)");
      } else if (typeParamName.equals("java.lang.Float")) {
        return Optional.of("Float.box(_)");
      } else if (typeParamName.equals("java.lang.Double")) {
        return Optional.of("Double.box(_)");
      } else if (typeParamName.equals("java.lang.Boolean")) {
        return Optional.of("Boolean.box(_)");
      } else {
        return Optional.empty();
      }
    };
    return _addConversion(ti, toJavaBoxed);
  }

  private String addReturnTypeConversion(TypeInfo ti) {
    Function<String, Optional<String>> toScalaVal = typeParamName -> {
      if (typeParamName.equals("java.lang.Integer")) {
        return Optional.of("Integer2int(_)");
      } else if (typeParamName.equals("java.lang.Long")) {
        return Optional.of("Long2long(_)");
      } else if (typeParamName.equals("java.lang.Byte")) {
        return Optional.of("Byte2byte(_)");
      } else if (typeParamName.equals("java.lang.Character")) {
        return Optional.of("Character2char(_)");
      } else if (typeParamName.equals("java.lang.Short")) {
        return Optional.of("Short2short(_)");
      } else if (typeParamName.equals("java.lang.Float")) {
        return Optional.of("Float2float(_)");
      } else if (typeParamName.equals("java.lang.Double")) {
        return Optional.of("Double2double(_)");
      } else if (typeParamName.equals("java.lang.Boolean")) {
        return Optional.of("Boolean2boolean(_)");
      } else {
        return Optional.empty();
      }
    };
    return _addConversion(ti, toScalaVal);
  }

  private String _addConversion(TypeInfo ti, Function<String, Optional<String>> conversion) {
    String typeName = ti.getName();
    if (ti.isParameterized()) {
      if (typeName.startsWith("java.util.List") || typeName.startsWith("java.util.Set")) {
        String typeParamName = ((ParameterizedTypeInfo) ti).getArg(0).getName();
        return conversion.apply(typeParamName).map(b -> ".map(" + b + ")").orElse("");
      } else if (typeName.startsWith("java.util.Map")) {
        String typeParamName1 = ((ParameterizedTypeInfo) ti).getArg(0).getName();
        String typeParamName2 = ((ParameterizedTypeInfo) ti).getArg(1).getName();
        String boxedKey = conversion.apply(typeParamName1).orElse("_");
        String boxedValue = conversion.apply(typeParamName2).orElse("_");
        return (boxedKey.equals("_") && boxedValue.equals("_")) ? "" : ".map(" + boxedKey + " -> " + boxedValue + ")";
      } else {
        return "";
      }
    } else {
      return "";
    }
  }

  private String className(ClassModel model) {
    return model.getType().getSimpleName();
  }

  private String quoteForScala(String name) {
    switch (name) {
      case "match":
        return "`match`";
      case "object":
        return "`object`";
      case "type":
        return "`type`";
      default:
        return name;
    }
  }

  private String toScalaType(String typeName, Set<String> imports) {
    switch (typeName) {
      case "byte":
      case "java.lang.Byte":
        return "Byte";
      case "char":
      case "java.lang.Character":
        return "Char";
      case "short":
      case "java.lang.Short":
        return "Short";
      case "int":
      case "java.lang.Integer":
        return "Int";
      case "long":
      case "java.lang.Long":
        return "Long";
      case "java.lang.String":
        return "String";
      case "boolean":
      case "java.lang.Boolean":
        return "Boolean";
      case "float":
      case "java.lang.Float":
        return "Float";
      case "double":
      case "java.lang.Double":
        return "Double";
      case "void":
        return "Unit";
      case "java.util.List":
        imports.add("import scala.collection.mutable.Buffer");
        imports.add("import scala.jdk.CollectionConverters.*");
        return "Buffer";
      case "java.util.Map":
        imports.add("import scala.collection.mutable.Map");
        imports.add("import scala.jdk.CollectionConverters.*");
        return "Map";
      case "java.util.Set":
        imports.add("import scala.collection.mutable.Set");
        imports.add("import scala.jdk.CollectionConverters.*");
        return "Set";
      case "java.lang.Object":
        return "AnyRef";
      default:
        return typeName;
    }
  }

  private boolean isCollection(ClassKind kind) {
    return kind == ClassKind.LIST
        || kind == ClassKind.MAP
        || kind == ClassKind.SET;
  }

  private <X> Predicate<X> not(Predicate<X> positive) {
    return x -> !positive.test(x);
  }

}
