
<#list properties as property>
<#if property.declared>
<#if property.doc??>
  /**
${typeHelper.renderDoc(type, "   *", property.doc)}
   */
</#if>
<#if property.adder>
  <#if property.map>
  def ${property.adderMethod}(key: String, value: ${typeHelper.toScalaType(property.type, false)}): ${className}
  <#else>
  def ${property.adderMethod}(value: ${typeHelper.toScalaType(property.type, false)}): ${className}
  </#if>

</#if>
<#if property.setter>
  <#if property.list>
  def ${property.setterMethod}(value: scala.collection.mutable.Buffer[${typeHelper.toScalaType(property.type, false)}]): ${className}
  <#elseIf property.set>
  def ${property.setterMethod}(value: Set[${typeHelper.toScalaType(property.type, false)}]): ${className}
  <#elseIf property.map>
  def ${property.setterMethod}(value: Map[String, ${typeHelper.toScalaType(property.type, false)}]): ${className}
  <#else>
  def ${property.setterMethod}(value: ${typeHelper.toScalaType(property.type, false)}): ${className}
  </#if>

</#if>
<#if (property.setter || property.adder) && property.getterMethod??>
  def ${property.getterMethod}: ${typeHelper.fromPropertyInfoToScala(property)}

</#if>
</#if>
</#list>
}
