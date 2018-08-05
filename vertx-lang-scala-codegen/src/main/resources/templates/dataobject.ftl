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
${typeHelper.renderDoc(type, " *", doc)}
 */
</#if>

<@compress single_line=true>
<#if concrete>
class ${className}(private val _asJava: J${className})
<#else>
trait ${className}
</#if>
<#if superTypes?has_content>
 extends <#list superTypes as superType>Ext${typeHelper.toScalaType(superType, false)}<#if !superType.isAbstract()>(_asJava)</#if><#sep>with </#list>
</#if>
 {
</@compress>

<#if concrete>
<#include "dataobject-body.ftl">
<#else>
<#include "dataobject-trait-body.ftl">
</#if>
