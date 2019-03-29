  def asJava: java.lang.Object

<#list instanceMethods as method>
  <#if method.doc??>${typeHelper.methodDoc(type, method, '  ', false)}</#if>
  <@compress single_line=true>
  <#if typeHelper.isMethodNeedsOverride(type.name, method)>override </#if>
  def ${typeHelper.escapeIfKeyword(method.name)}
  ${typeHelper.assembleTypeParams(method.typeParams, true)}(
  <#list method.params as param>${typeHelper.escapeIfKeyword(param.name)}: ${typeHelper.toScalaType(param.type, false)}<#sep>, </#list>): ${typeHelper.toScalaType(method.returnType, false)}
  </@compress>
</#list>

<#list staticMethods as method>
  <#if method.doc??>${typeHelper.methodDoc(type, method, '  ', false)}</#if>
  <@compress single_line=true>
  <#if typeHelper.isMethodNeedsOverride(type.name, method)>override </#if>
  def ${typeHelper.escapeIfKeyword(method.name)}
  ${typeHelper.assembleTypeParams(method.typeParams, true)}(
  <#list method.params as param>${typeHelper.escapeIfKeyword(param.name)}: ${typeHelper.toScalaType(param.type, false)}<#sep>, </#list>): ${typeHelper.toScalaType(method.returnType, false)}
  </@compress>
</#list>

<#list futureMethods as method>
  <#if method.name != 'executeBlocking'>
  <#if method.doc??>${typeHelper.methodDoc(type, method, ' ', true)}</#if>
  <@compress single_line=true>
  <#if typeHelper.isMethodNeedsOverride(type.name, method) && !method.name?endsWith("Handler")>override </#if>
  def ${typeHelper.createNameForMethodReturningAFuture(method)}
  ${typeHelper.assembleTypeParams(method.typeParams, true)}(
  <#list typeHelper.removeLastParam(method.params) as param>${typeHelper.escapeIfKeyword(param.name)}: ${typeHelper.toScalaType(param.type, false)}<#sep>, </#list>): scala.concurrent.Future[${typeHelper.toScalaType(typeHelper.typeOfReturnedFuture(method), false)}]
  </@compress>
  </#if>
</#list>

}
