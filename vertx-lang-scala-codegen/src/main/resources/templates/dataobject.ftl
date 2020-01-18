<#include "extensions/LicenseHeader.ftl">

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
<#if isClass>
<#if !concrete>abstract</#if> class ${className}(private val _asJava: J${className})
<#else>
trait ${className}
</#if>
<#if superTypes?has_content>
 extends <#list superTypes as superType>Ext${typeHelper.toScalaType(superType, false)}<#if !superType.isAbstract() || (superType.isAbstract() && !superType.isInterface())>(_asJava)</#if><#sep>with </#list>
</#if>
 {
</@compress>

<#if concrete>
<#include "dataobject-body.ftl">
<#else>
<#include "dataobject-trait-body.ftl">
</#if>
