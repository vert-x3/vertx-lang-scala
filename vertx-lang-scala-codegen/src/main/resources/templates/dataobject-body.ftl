<#ftl  stripWhitespace=true>
  <#if !isAllSuperTypesAbstract || type.simpleName == "MySQLConnectOptions" || type.simpleName == "PgConnectOptions">override </#if>def asJava = _asJava
<#list properties as property>
  <#if property.doc?? >
  /**
${typeHelper.renderDoc(type, "   *", property.doc)}
   */
  </#if>
  <#if property.adder>
    <#if property.map>
        <#lt>${"  "}<#if !property.declared && superTypes?hasContent>override </#if>def ${property.adderMethod}(key: String, value: ${typeHelper.toScalaType(property.type, false)}) = {
        <#lt>${"    "}asJava.${property.adderMethod}(key, ${typeHelper.toJavaWithConversion('value', property.type)})
        <#lt>${"    "}this
        <#lt>${"  "}}
    <#else>
        <#lt>${"  "}<#if !property.declared && superTypes?hasContent>override </#if>def ${property.adderMethod}(value: ${typeHelper.toScalaType(property.type, false)}) = {
      <#if property.type.kind == CLASS_DATA_OBJECT >
        <#lt>${"    "}asJava.${property.adderMethod}(${typeHelper.toJavaWithConversion('value', property.type)})
      <#elseIf property.type.kind == CLASS_PRIMITIVE || property.type.kind == CLASS_BOXED_PRIMITIVE || property.type.kind == CLASS_STRING || property.type.kind == CLASS_JSON_OBJECT || property.type.kind == CLASS_JSON_ARRAY || property.type.kind == CLASS_ENUM || property.type.name == 'io.vertx.core.buffer.Buffer'>
        <#lt>${"    "}asJava.${property.adderMethod}(value)
      <#else>
        <#lt>${"    "}asJava.${property.adderMethod}(value.asInstanceOf)
      </#if>
        <#lt>${"    "}this
        <#lt>${"  "}}
    </#if>

  </#if>
  <#if property.setter>
    <#if property.list>
        <#lt>${"  "}<#if !property.declared && superTypes?hasContent >override </#if>def ${property.setterMethod}(value: scala.collection.mutable.Buffer[${typeHelper.toScalaType(property.type, false)}]) = {
      <#if property.type.kind == CLASS_PRIMITIVE || property.type.kind == CLASS_BOXED_PRIMITIVE>
        <#lt>${"    "}asJava.${property.setterMethod}(value.map(${typeHelper.toScalaType(property.type, false)}.box).asJava)
      <#elseIf (property.type.kind == CLASS_DATA_OBJECT || property.type.kind == CLASS_API) &&  property.type.name != 'io.vertx.core.buffer.Buffer'>
        <#lt>${"    "}asJava.${property.setterMethod}(value.map(${typeHelper.toJavaWithConversion('_', property.type)}).asJava)
      <#else>
        <#lt>${"    "}asJava.${property.setterMethod}(value.asJava)
      </#if>
        <#lt>${"    "}this
        <#lt>${"  "}}
    <#elseIf property.set >
        <#lt>${"  "}<#if !property.declared && superTypes?hasContent >override </#if>def ${property.setterMethod}(value: Set[${typeHelper.toScalaType(property.type, false)}]) = {
      <#if property.type.kind == CLASS_PRIMITIVE || property.type.kind == CLASS_BOXED_PRIMITIVE>
        <#lt>${"    "}asJava.${property.setterMethod}(value.map(${typeHelper.toScalaType(property.type, false)}.box).asJava)
      <#elseIf (property.type.kind == CLASS_DATA_OBJECT || property.type.kind == CLASS_API) &&  property.type.name != 'io.vertx.core.buffer.Buffer'>
        <#lt>${"    "}asJava.${property.setterMethod}(value.map(${typeHelper.toJavaWithConversion('_', property.type)}).asJava)
      <#else>
        <#lt>${"    "}asJava.${property.setterMethod}(value.asJava)
      </#if>
        <#lt>${"    "}this
        <#lt>${"  "}}
    <#elseIf property.map>
        <#lt>${"  "}<#if !property.declared && superTypes?hasContent >override </#if>def ${property.setterMethod}(value: Map[String, ${typeHelper.toScalaType(property.type, false)}]) = {
      <#if property.type.kind == CLASS_PRIMITIVE || property.type.kind == CLASS_BOXED_PRIMITIVE>
        <#lt>${"    "}asJava.${property.setterMethod}(value.mapValues(${typeHelper.toScalaType(property.type, false)}.box).asJava)
      <#elseIf property.type.kind == CLASS_DATA_OBJECT>
        <#lt>${"    "}asJava.${property.setterMethod}(value.mapValues(${typeHelper.toJavaWithConversion('_', property.type)}).asJava)
      <#else>
        <#lt>${"    "}asJava.${property.setterMethod}(value.asJava)
      </#if>
        <#lt>${"    "}this
        <#lt>${"  "}}
    <#else>
        <#lt>${"  "}<#if !property.declared && superTypes?hasContent >override </#if>def ${property.setterMethod}(value: ${typeHelper.toScalaType(property.type, false)}) = {
      <#if property.type.kind == CLASS_DATA_OBJECT>
        <#lt>${"    "}asJava.${property.setterMethod}(${typeHelper.toJavaWithConversion('value', property.type)})
      <#elseIf property.type.kind == CLASS_API && property.type.name != 'io.vertx.core.buffer.Buffer'>
        <#lt>${"    "}asJava.${property.setterMethod}(value.asInstanceOf[J${property.type.simpleName}])
      <#elseIf property.type.kind == CLASS_PRIMITIVE || property.type.kind == CLASS_BOXED_PRIMITIVE || property.type.kind == CLASS_STRING || property.type.kind == CLASS_JSON_OBJECT || property.type.kind == CLASS_JSON_ARRAY || property.type.kind == CLASS_ENUM || property.type.name != 'io.vertx.core.buffer.Buffer'>
        <#lt>${"    "}asJava.${property.setterMethod}(value)
      <#else>
        <#lt>${"    "}asJava.${property.setterMethod}(value)
      </#if>
        <#lt>${"    "}this
        <#lt>${"  "}}
    </#if>

  </#if>
  <#if (property.setter || property.adder) && property.getterMethod??>
    <#if className == "JWTAuthOptions" && property.getterMethod == "getJWTOptions">
      <#lt>${"  "}def getJWTOptions: io.vertx.scala.ext.auth.JWTOptions = {
      <#lt>${"    "}io.vertx.scala.ext.auth.JWTOptions(asJava.getJWTOptions())
      <#lt>${"  "}}
    <#else>
      <#lt>${"  "}<#if !property.declared && superTypes?hasContent>override </#if>def ${property.getterMethod}: ${typeHelper.fromPropertyInfoToScala(property)} = {
      <#lt>${"    "}${typeHelper.fromPropertyInfoToScalaTypeWithConversion(type, 'asJava.' + property.getterMethod + '()', property)}
      <#lt>${"  "}}
    </#if>

  </#if>
</#list>
}


object ${className} {

  def apply() = {
    new ${className}(new J${className}(emptyObj()))
  }

  def apply(t: J${className}) = {
    if (t != null) {
      new ${className}(t)
    } else {
      new ${className}(new J${className}(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): ${className} = {
    if (json != null) {
      new ${className}(new J${className}(json))
    } else {
      new ${className}(new J${className}(emptyObj()))
    }
  }
}

