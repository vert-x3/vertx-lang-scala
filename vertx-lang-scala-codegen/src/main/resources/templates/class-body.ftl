<#if !superTypes?has_content || !typeHelper.isParentConcrete(superTypes)>  def asJava = _asJava</#if>
<#assign cached_counter=0>
<#list cacheReturnMethods as method>
  private var cached_${cached_counter}: Option[${typeHelper.toScalaType(method.returnType, false)}] = None
<#assign cached_counter++>
</#list>

<#if className == 'Vertx'>
<#include "extensions/Vertx.ftl">
</#if>

<#assign cached_method_counter=0>
<#list cacheReturnMethods as method>
  <#lt><#if method.doc??>${typeHelper.methodDoc(type, method, '  ', false)}</#if>
  <#if typeHelper.isMethodNeedsOverride(type.name, method)>override </#if>def ${typeHelper.escapeIfKeyword(method.name)}<#rt>
  ${typeHelper.assembleTypeParams(method.typeParams, true)}<#t>(<#list method.params as param>${typeHelper.escapeIfKeyword(param.name)}: ${typeHelper.toScalaType(param.type, false)}<#sep>, </#list>): ${typeHelper.toScalaType(method.returnType, false)} = {

    if (cached_${cached_method_counter} == None) {
      val tmp = ${typeHelper.invokeMethodWithoutConvertingReturn('asJava' + typeHelper.fromObjectToInstanceOf(type, typeParams, method.typeParams), type, method, typeParams)}
      cached_${cached_method_counter} = Some(${typeHelper.toScalaWithConversion('tmp', method.returnType, typeParams, method.typeParams)})
    }
    <#if !method.fluent>
    cached_${cached_method_counter}.get
    <#else>
    this
    </#if>
  }

  <#assign cached_method_counter++>
</#list>

<#list fluentMethods as method>
  <#lt><#if method.doc??>${typeHelper.methodDoc(type, method, '  ', false)}</#if>
  <#if typeHelper.isMethodNeedsOverride(type.name, method)>override </#if>
  def ${typeHelper.escapeIfKeyword(method.name)}<#rt>
  ${typeHelper.assembleTypeParams(method.typeParams, true)}<#t>(<#list method.params as param>${typeHelper.escapeIfKeyword(param.name)}: ${typeHelper.toScalaType(param.type, false)}<#sep>, </#list>): ${typeHelper.toScalaType(method.returnType, false)} = {

    ${typeHelper.invokeMethodWithoutConvertingReturn('asJava' + typeHelper.fromObjectToInstanceOf(type, typeParams, method.typeParams), type, method, typeParams)}
    this
  }

</#list>

<#list defaultMethods as method>
  <#if method.name == 'executeBlocking'>
  <#if method.params?size == 2>
   <#include "extensions/executeblocking.ftl">
   </#if>
  <#else>
  <#lt><#if method.doc??>${typeHelper.methodDoc(type, method, '  ', false)}</#if>
  <#if typeHelper.isMethodNeedsOverride(type.name, method)>override </#if>def ${typeHelper.escapeIfKeyword(method.name)}<#rt>
  ${typeHelper.assembleTypeParams(method.typeParams, true)}<#t>(<#list method.params as param>${typeHelper.escapeIfKeyword(param.name)}: ${typeHelper.toScalaType(param.type, false)}<#sep>, </#list>): ${typeHelper.toScalaType(method.returnType, false)} = {

    ${typeHelper.invokeMethod('asJava' + typeHelper.fromObjectToInstanceOf(type, typeParams, method.typeParams), type, method, typeParams)}
  }

  </#if>
</#list>

<#list basicMethods as method>
  <#if method.name == 'executeBlocking'>
  <#if method.params?size == 2>
  <#include "extensions/executeblocking.ftl">
  </#if>
  <#else>
  <#lt><#if method.doc??>${typeHelper.methodDoc(type, method, '  ', false)}</#if>
  <#if typeHelper.isMethodNeedsOverride(type.name, method)>override </#if><#rt>
  def ${typeHelper.escapeIfKeyword(method.name)} ${typeHelper.assembleTypeParams(method.typeParams, true)}<#t>(<#list method.params as param>${typeHelper.escapeIfKeyword(param.name)}: ${typeHelper.toScalaType(param.type, false)}<#sep>, </#list>): ${typeHelper.toScalaType(method.returnType, false)} = {

    ${typeHelper.invokeMethod('asJava' + typeHelper.fromObjectToInstanceOf(type, typeParams, method.typeParams), type, method, typeParams)}
  }

  </#if>
</#list>

<#if className != 'CompositeFuture' && className != 'Future' >
<#list futureMethods as method>
  <#if method.name != 'executeBlocking'>
  <#lt><#if method.doc??>${typeHelper.methodDoc(type, method, ' ', true)}</#if>
  <#if typeHelper.isMethodNeedsOverride(type.name, method) && !method.name?ends_with("Handler")>override <#elseif method.name?ends_with("Handler")><#list classes as superType><#if superType.name != "io.vertx.core.Future<java.lang.Boolean>">override </#if></#list></#if><#rt>
  def ${typeHelper.createNameForMethodReturningAFuture(method)} ${typeHelper.assembleTypeParams(method.typeParams, true)}<#t>(<#list typeHelper.removeLastParam(method.params) as param>${typeHelper.escapeIfKeyword(param.name)}: ${typeHelper.toScalaType(param.type, false)}<#sep>, </#list>): scala.concurrent.Future[${typeHelper.toScalaType(typeHelper.typeOfReturnedFuture(method), false)}] = {

    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[${typeHelper.toJavaType(typeHelper.typeOfReturnedFuture(method), true)}, ${typeHelper.toScalaType(typeHelper.typeOfReturnedFuture(method), false)}](x => ${typeHelper.toScalaWithConversion('x', typeHelper.typeOfReturnedFuture(method), typeParams, method.typeParams)})
    ${typeHelper.invokeMethodAndUseProvidedHandler('asJava' + typeHelper.fromObjectToInstanceOf(type), type, method, typeParams, 'promiseAndHandler._1')}
    promiseAndHandler._2.future
  }

  </#if>
</#list>
</#if>
}
