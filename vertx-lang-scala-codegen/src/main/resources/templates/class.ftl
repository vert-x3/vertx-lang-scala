/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package ${packageName}

<#list imps as imp>
import ${imp}
</#list>

<#if doc??>
/**
${typeHelper.renderDoc(type, "  *", doc)}
  */
</#if>

<@compress single_line=true>
<#if concrete>
class ${className}${typeHelper.assembleTypeParams(typeParams, true)}(private val _asJava: Object)
<#else>
trait ${className}${typeHelper.assembleTypeParams(typeParams, false)}
</#if>
<#if superTypes?has_content >
      extends <#list classes as superType>${typeHelper.toScalaType(superType, false)} <#if superType.raw.isConcrete()>(_asJava)</#if><#sep>with </#list>
   <#if classes?has_content && abstractClasses?has_content>with </#if><#list abstractClasses as superType>${typeHelper.toScalaType(superType, false)}<#if superType.raw.concrete>(_asJava)</#if><#sep>with </#list>
   <#if type.handler>
      with io.vertx.core.Handler[${typeHelper.toScalaType(type.handlerArg, false)}]
   </#if>
<#elseif type.handler>
      extends io.vertx.core.Handler[${typeHelper.toScalaType(type.handlerArg, false)}]
</#if>{
</@compress>

<#if concrete>
<#include "class-body.ftl">

<#include "class-object-body.ftl">
<#else>
<#include "class-trait-body.ftl">

object ${className} {
  def apply${typeHelper.assembleTypeParams(typeParams, true)}(asJava: J${className}${typeHelper.assembleTypeParamsAsObjects(typeParams)}): ${className}${typeHelper.assembleTypeParams(typeParams, false)} = new ${className}Impl${typeHelper.assembleTypeParams(typeParams, false)}(asJava)
    private class ${className}Impl${typeHelper.assembleTypeParams(typeParams, true)}(private val _asJava: Object) extends ${className}${typeHelper.assembleTypeParams(typeParams, false)} {
<#include "class-body.ftl">
}
</#if>
