<#if incrementalIndex == 0>
  <#include "extensions/LicenseHeader.ftl">

package ${modulePackage}

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise
  <#if type.name == 'io.vertx.core.Vertx'>
    import io.vertx.lang.scala.ScalaVerticle
  </#if>

<#list imps as imp>
import ${imp}
</#list>

package object ${moduleName}{

<#if moduleName=="core">
  <#include "extensions/Json.ftl">
</#if>
</#if>
<#if type.dataObject??>
  <#include "implicit_dataobject.ftl">
<#elseif !type.name?contains("Handler") && futureMethods?has_content>
  <#include "class.ftl">
<#elseif !type.name?contains("Handler") && helper.getSimpleName(type.name) != 'Message' && staticMethods?has_content>
  object ${helper.getSimpleName(type.name)} {
  <#list staticMethods as method>
      <#if method.doc??>
${typeHelper.methodDoc(type, method, "    ", false)}
      </#if>
${typeHelper.renderStaticMethod(type, method)}
  </#list>
  }
</#if>

<#if helper.getSimpleName(type.name) == 'Message'>
  <#include "extensions/Message.ftl">
</#if>

<#if incrementalIndex == incrementalSize-1>
}
</#if>
