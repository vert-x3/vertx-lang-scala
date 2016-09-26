package io.vertx.lang.scala

import java.util
import java.util.Arrays

import com.sun.source.tree.LambdaExpressionTree
import com.sun.source.tree.LambdaExpressionTree.BodyKind
import io.vertx.codegen.`type`.{ApiTypeInfo, ClassTypeInfo, EnumTypeInfo, TypeInfo}
import io.vertx.codetrans.{CodeModel, CodeWriter}
import io.vertx.codetrans.expression.{DataObjectLiteralModel, ExpressionModel, JsonArrayLiteralModel, JsonObjectLiteralModel}
import io.vertx.codetrans.statement.StatementModel

import collection.JavaConversions._


class ScalaCodeWriter(builder: ScalaCodeBuilder) extends CodeWriter(builder){

  override def renderNewMap(): Unit = append("Map()")

  override def renderNew(expression: ExpressionModel, `type`: TypeInfo, argumentModels: util.List[ExpressionModel]): Unit = {
//    append("new ")
    expression.render(this)
    append('(')
    argumentModels.zipWithIndex.foreach{
      case (v, i) => {
        if(i > 0) append(", ")
        v.render(this)
      }
    }
    append(')')
  }

  override def renderSystemOutPrintln(expression: ExpressionModel): Unit = {
    append("println(")
    expression.render(this)
    append(")")
  }

  override def renderAsyncResultFailed(resultType: TypeInfo, name: String): Unit = append("renderAsyncResultFailed")

  override def renderListGet(list: ExpressionModel, index: ExpressionModel): Unit = {
    list.render(this)
    append("(")
    index.render(this)
    append(")")

  }

  override def renderSystemErrPrintln(expression: ExpressionModel): Unit = {
    append("System.err.println(")
    expression.render(this)
    append(")")
  }

  override def renderMethodReference(expression: ExpressionModel, methodName: String): Unit = {
    expression.render(this)
    append(methodName).append(" _")
  }

  override def renderApiType(apiType: ApiTypeInfo): Unit = append(apiType.getSimpleName())

  override def renderListLiteral(arguments: util.List[ExpressionModel]): Unit = {
    append("List(")
    arguments.zipWithIndex.foreach{
      case (v, i) => {
        if(i > 0) append(", ")
        v.render(this)
      }
    }
    append(')')
  }

  override def renderJsonObjectMemberSelect(expression: ExpressionModel, name: String): Unit = {
    expression.render(this)
    append('.')
    append(name)
  }

  override def renderDataObjectMemberSelect(expression: ExpressionModel, name: String): Unit = renderJsonObjectMemberSelect(expression, name)

  override def renderEnumConstant(`type`: EnumTypeInfo, constant: String): Unit = append(`type`.getSimpleName()).append('.').append(constant)

  override def renderJsonObjectAssign(expression: ExpressionModel, name: String, value: ExpressionModel): Unit = {
    expression.render(this)
    append(".put(")
    append(name)
    append(", ")
    value.render(this)
    append(")")
  }

  override def renderListSize(list: ExpressionModel): Unit = {
    list.render(this)
    append(".size")
  }

  override def renderLambda(bodyKind: BodyKind, parameterTypes: util.List[TypeInfo], parameterNames: util.List[String], body: CodeModel): Unit = {
    append("(")
    parameterNames.zipWithIndex.foreach{
      case (v, i) => {
        if(i > 0) append(", ")
        append(s"${v}: ${parameterTypes(i)}")
      }
    }
    append(") => {\n")
    indent
    body.render(this)
    if (bodyKind eq LambdaExpressionTree.BodyKind.EXPRESSION) append("\n")
    unindent
    append("}")
  }

  override def renderMapGet(map: ExpressionModel, key: ExpressionModel): Unit = {
    map.render(this)
    append('(')
    key.render(this)
    append(')')
  }

  override def renderNewList(): Unit = append("List()")

  override def renderAsyncResultCause(resultType: TypeInfo, name: String): Unit = append("renderAsyncResultCause")

  override def renderJavaType(apiType: ClassTypeInfo): Unit = append(apiType.getName)

  override def renderMapPut(map: ExpressionModel, key: ExpressionModel, value: ExpressionModel): Unit = {
    map.render(this)
    append(" + (")
    key.render(this)
    append(" -> ")
    value.render(this)
    append(")")
  }

  override def renderThrow(throwableType: String, reason: ExpressionModel): Unit = {
    if (reason == null) append("throw new ").append(throwableType).append("()")
    else {
      append("throw new ").append(throwableType).append("(")
      reason.render(this)
      append(")")
    }
  }

  override def renderMapForEach(map: ExpressionModel, keyName: String, keyType: TypeInfo, valueName: String, valueType: TypeInfo, bodyKind: BodyKind, block: CodeModel): Unit = {
    map.render(this)
    append(".foreach(")
    renderLambda(bodyKind, Arrays.asList(keyType, valueType), Arrays.asList(keyName, valueName), block)
    append(")")
  }

  override def renderJsonObject(jsonObject: JsonObjectLiteralModel): Unit = append("renderJsonObject")

  override def renderTryCatch(tryBlock: StatementModel, catchBlock: StatementModel): Unit = {
    append("try {\n")
    indent
    tryBlock.render(this)
    unindent
    append("} catch {\n")
    indent
    append("e:Exception => ")
    catchBlock.render(this)
    unindent
    append("}\n")
  }

  override def renderJsonObjectToString(expression: ExpressionModel): Unit = append("renderJsonObjectToString")

  override def renderJsonArray(jsonArray: JsonArrayLiteralModel): Unit = append("renderJsonArray")

  override def renderDataObject(model: DataObjectLiteralModel): Unit = append("renderDataObject")

  override def renderListAdd(list: ExpressionModel, value: ExpressionModel): Unit = {
    list.render(this)
    append(" += ")
    value.render(this)
  }

  override def renderStatement(statement: StatementModel): Unit = {
    statement.render(this)
    append("\n")
  }

  override def renderThis(): Unit = append("this")

  override def renderJsonArrayToString(expression: ExpressionModel): Unit = append("renderJsonArrayToString")

  override def renderAsyncResultValue(resultType: TypeInfo, name: String): Unit = append("renderAsyncResultValue")

  override def renderAsyncResultSucceeded(resultType: TypeInfo, name: String): Unit = append("renderAsyncResultSucceeded")

  override def renderDataObjectAssign(expression: ExpressionModel, name: String, value: ExpressionModel): Unit = renderJsonObjectAssign(expression, name, value)
}
