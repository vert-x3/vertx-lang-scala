
<#if concrete>
  type ${className} = ${helper.getNonGenericType(type)}

  object ${helper.getSimpleName(type.name)} {
    <#if hasEmptyConstructor>def apply() = new ${helper.getSimpleName(type.name)}()</#if>
    def apply(json: JsonObject) = new ${helper.getSimpleName(type.name)}(json)
  }
</#if>

