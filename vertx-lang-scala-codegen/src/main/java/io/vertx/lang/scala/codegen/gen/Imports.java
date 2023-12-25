package io.vertx.lang.scala.codegen.gen;

import io.vertx.codegen.Helper;
import io.vertx.codegen.MethodInfo;
import io.vertx.codegen.type.ClassKind;
import io.vertx.codegen.type.ParameterizedTypeInfo;
import io.vertx.codegen.type.TypeInfo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static io.vertx.codegen.Helper.getNonGenericType;

public class Imports {
  /**
   * Every usage of a Vert.x-Java-type has to be aliased. This takes care of generating the required snippet.
   */
  public static String convertTypeToAliasedType(TypeInfo type) {
    return Helper.getPackageName(getNonGenericType(type.getName())) + ".{"+getNonGenericType(type.getSimpleName())+" => J"+getNonGenericType(type.getSimpleName())+"}";
  }

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
    methods.stream()
      .filter(methodInfo -> !methodInfo.isDeprecated())
      .flatMap(methodInfo -> methodInfo.getParams().stream())
      .forEach(paramInfo -> importForType(Helper.getPackageName(type.getName()), paramInfo.getType(), ret));
    return ret;
  }
}
