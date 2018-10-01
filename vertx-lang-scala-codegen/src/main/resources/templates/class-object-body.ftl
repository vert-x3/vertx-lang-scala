object ${className} {
  def apply${typeHelper.assembleTypeParams(typeParams, true)}(asJava: J${className}${typeHelper.assembleTypeParamsAsObjects(typeParams)}) = new ${className}${typeHelper.assembleTypeParams(typeParams, false)}(asJava)
  
  <#list staticMethods as method >
    <#lt><#if method.doc??>${typeHelper.methodDoc(type, method, '  ', false)}</#if>
  def ${typeHelper.escapeIfKeyword(method.name)}${typeHelper.assembleTypeParams(method.typeParams, true)}(<#list method.params as param>${typeHelper.escapeIfKeyword(param.name)}: ${typeHelper.toScalaType(param.type, false)}<#sep>,</#list>): ${typeHelper.toScalaType(method.returnType, false)} = {
    ${typeHelper.invokeStaticMethod('J'+className, type, method)}
  }

  </#list>
}
