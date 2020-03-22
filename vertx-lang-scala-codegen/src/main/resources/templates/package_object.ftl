<#if incrementalIndex == 0>
${typeHelper.renderFile("extensions/LicenseHeader.ftl")}

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
${typeHelper.renderFile("extensions/Json.ftl")}
</#if>
</#if>
<#if type.dataObject??>
  ${typeHelper.renderDataobject(className, type, concrete, hasEmptyConstructor, helper)}
<#elseif !type.name?contains("Handler") && futureMethods?has_content>
${typeHelper.renderClass(type, doc, className, nullableMethods, futureMethods, nonGenericType, typeParams)}
<#elseif !type.name?contains("Handler") && helper.getSimpleName(type.name) != 'Message' && staticMethods?has_content>
  object ${helper.getSimpleName(type.name)} {
  <#list staticMethods as method>
${typeHelper.renderStaticMethod(type, method)}
  </#list>
  }
</#if>

<#if helper.getSimpleName(type.name) == 'Message'>
${typeHelper.renderFile("extensions/Message.ftl")}
</#if>

<#if incrementalIndex == incrementalSize-1>
}
</#if>
