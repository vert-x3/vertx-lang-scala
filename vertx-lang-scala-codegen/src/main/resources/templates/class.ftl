
<#if doc??>
  /**
${typeHelper.renderDoc(type, "    *", doc)}
    */
</#if>

<#if className == "Vertx">
  <#include "extensions/VertxObject.ftl">
</#if>
  implicit class ${className}Scala${typeHelper.assembleTypeParams(typeParams, true)}(val asJava: ${nonGenericType}${typeHelper.assembleTypeParams(typeParams, true)}) extends AnyVal {
<#if className == "Vertx">
  <#include "extensions/Vertx.ftl">
  <#include "extensions/executeblocking.ftl">
</#if>
<#if className == "Context">
  <#include "extensions/executeblocking.ftl">
</#if>
<#if className == "WorkerExecutor">
  <#include "extensions/executeblocking.ftl">
</#if>

<#if className != "CompositeFuture" && className != "Future" >
  <#list nullableMethods as method>
    <#if method.name != "executeBlocking">

      <#if method.doc??>
${typeHelper.methodDoc(type, method, "    ", true)}
      </#if>
    def ${method.name}<#if method.returnType.nullable>Option</#if>${typeHelper.assembleTypeParams(method.typeParams, true)}(<#list method.params as param>${typeHelper.escapeIfKeyword(param.name)}: ${typeHelper.wrapInOptionIfNullable(param.type.nullable, typeHelper.toScalaMethodParam(param.type))}<#sep>,</#list>): ${typeHelper.wrapInOptionIfNullable(method.returnType.nullable, typeHelper.toReturnType(method.returnType))} = {
      <#if method.returnType.nullable>scala.Option(</#if>${typeHelper.invokeMethodWithoutConvertingReturn('asJava', method)}<#if method.returnType.nullable>)</#if>
    }

    </#if>
  </#list>
  <#list futureMethods as method>
    <#if method.name != "executeBlocking">
      <#if method.doc??>
${typeHelper.methodDoc(type, method, "    ", true)}
      </#if>
${typeHelper.renderFutureMethod(type, typeParams, method)}

    </#if>
  </#list>
</#if>
  }
