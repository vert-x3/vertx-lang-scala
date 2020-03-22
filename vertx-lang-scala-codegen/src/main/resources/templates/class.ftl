
<#if doc??>
  /**
${typeHelper.renderDoc(type, "    *", doc)}
    */
</#if>

<#if className == "Vertx">
${typeHelper.renderFile("extensions/VertxObject.ftl")}
</#if>
  implicit class ${className}Scala${typeHelper.assembleTypeParams(typeParams, true)}(val asJava: ${nonGenericType}${typeHelper.assembleTypeParams(typeParams, true)}) extends AnyVal {
<#if className == "Vertx">
${typeHelper.renderFile("extensions/Vertx.ftl")}
${typeHelper.renderFile("extensions/executeblocking.ftl")}
</#if>
<#if className == "Context">
${typeHelper.renderFile("extensions/executeblocking.ftl")}
</#if>
<#if className == "WorkerExecutor">
${typeHelper.renderFile("extensions/executeblocking.ftl")}
</#if>

<#if className != "CompositeFuture" && className != "Future" >
  <#list nullableMethods as method>
    <#if method.name != "executeBlocking">
${typeHelper.renderNullableMethod(type, method)}

    </#if>
  </#list>
  <#list futureMethods as method>
    <#if method.name != "executeBlocking">
${typeHelper.renderFutureMethod(type, typeParams, method)}

    </#if>
  </#list>
</#if>
  }
