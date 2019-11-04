<#if incrementalIndex == 0>
  <#include "extensions/LicenseHeader.ftl">

package ${modulePackage}

import scala.collection.JavaConverters._
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
<#if type.kind == CLASS_DATA_OBJECT>
  <#include "implicit_dataobject.ftl">
<#elseif !type.name?contains("Handler") && futureMethods?has_content>
  <#include "class.ftl">
<#elseif !type.name?contains("Handler") && helper.getSimpleName(type.name) != 'Message'>
  type ${typeHelper.getSimpleNameWithScalaNotation(type)} = ${typeHelper.getFullNameWithScalaNotation(type)}
</#if>

<#if helper.getSimpleName(type.name) == 'Message'>
  <#include "extensions/Message.ftl">
</#if>

<#if incrementalIndex == incrementalSize-1>
}
</#if>
