package io.vertx.lang.scala

import java.util
import java.util.Arrays
import javax.lang.model.element.TypeElement

import com.sun.source.tree.LambdaExpressionTree
import com.sun.source.tree.LambdaExpressionTree.BodyKind
import io.vertx.codegen.`type`.{ApiTypeInfo, ClassTypeInfo, EnumTypeInfo, TypeInfo}
import io.vertx.codetrans.{BlockModel, CodeModel, CodeWriter, MethodSignature}
import io.vertx.codetrans.expression._
import io.vertx.codetrans.statement.{ConditionalBlockModel, StatementModel}

import collection.JavaConversions._


class ScalaCodeWriter(builder: ScalaCodeBuilder) extends CodeWriter(builder){

  override def renderNewMap(): Unit = append("Map()")

  override def renderStringLiteral(parts: util.List[_]): Unit =  {
    if(parts.exists(_.isInstanceOf[ExpressionModel]))
      append("s\"")
    else append("\"")
    parts.foreach(part => {
      if (part.isInstanceOf[ExpressionModel]) {
        append("${")
        part.asInstanceOf[ExpressionModel].render(this)
        append("}")
      } else {
        renderChars(part.toString)
      }
    })
    append("\"")
  }

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

  override def renderAsyncResultFailed(resultType: TypeInfo, name: String): Unit = append("todo-renderAsyncResultFailed")

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

  override def renderDataObjectMemberSelect(expression: ExpressionModel, name: String): Unit = append("todo-renderDataObjectMemberSelect")

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
        append(s"${v}: ${parameterTypes(i).translateName("scala")}")
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

  override def renderAsyncResultCause(resultType: TypeInfo, name: String): Unit = append("todo-renderAsyncResultCause")

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

  override def renderJsonObject(jsonObject: JsonObjectLiteralModel): Unit = append("todo-renderJsonObject")

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

  override def renderJsonObjectToString(expression: ExpressionModel): Unit = append("todo-renderJsonObjectToString")

  override def renderJsonArray(jsonArray: JsonArrayLiteralModel): Unit = append("todo-renderJsonArray")

  override def renderDataObject(model: DataObjectLiteralModel): Unit = {
    append(s"${model.getType.getSimpleName()}()")
    if(model.getMembers.size > 0) {
      append("\n")
      indent()
    }
    model.getMembers.foreach(member => {
      append(s".set${member.getName.capitalize}(")
      if (member.isInstanceOf[Member.Single]) member.asInstanceOf[Member.Single].getValue.render(this)
      else if (member.isInstanceOf[Member.Sequence]) {
        append("Set(")
        member.asInstanceOf[Member.Sequence].getValues.zipWithIndex.foreach{
          case (v, i) => {
            if(i > 0)
              append(", ")
            v.render(this)
          }
        }
        append(")")
      }
      else if (member.isInstanceOf[Member.Entries]) append("todo-renderDataObject-entries")
      append(s")\n")
    })
    if(model.getMembers.size > 0) {
      unindent()
    }
  }

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

  override def renderJsonArrayToString(expression: ExpressionModel): Unit = append("todo-renderJsonArrayToString")

  override def renderAsyncResultValue(resultType: TypeInfo, name: String): Unit = append("todo-renderAsyncResultValue")

  override def renderAsyncResultSucceeded(resultType: TypeInfo, name: String): Unit = append("todo-renderAsyncResultSucceeded")

  override def renderDataObjectAssign(expression: ExpressionModel, name: String, value: ExpressionModel): Unit = {
    expression.render(this)
    append(s".set${name.capitalize}(")
    value.render(this)
    append(")")
  }

  override def renderInstanceOf(expression: ExpressionModel, `type`: TypeElement): Unit = {
    expression.render(this)
    append(".isInstanceOf[")
    append(`type`.getSimpleName)
    append("]")
  }

  override def renderPrefixDecrement(expression: ExpressionModel): Unit = renderPostfixDecrement(expression)

  override def renderPrefixIncrement(expression: ExpressionModel, writer: CodeWriter): Unit = renderPostfixDecrement(expression)

  override def renderPostfixIncrement(expression: ExpressionModel): Unit = {
    expression.render(this)
    append(" += 1")
  }

  override def renderPostfixDecrement(expression: ExpressionModel): Unit = {
    expression.render(this)
    append(" -= 1")
  }

  override def renderMethodInvocation(expression: ExpressionModel, receiverType: TypeInfo, method: MethodSignature, returnType: TypeInfo, argumentModels: util.List[ExpressionModel], argumentTypes: util.List[TypeInfo]): Unit = {
    val lbracket = if(method.getName == "onComplete") '{' else '('
    val rbracket = if(method.getName == "onComplete") '}' else ')'
    if(method.getName != "onComplete")
      expression.render(this) // ?
    append('.')
    append(method.getName)
    append(lbracket)
    var i: Int = 0
    while (i < argumentModels.size) {
      {
        if (i > 0) append(", ")
        argumentModels.get(i).render(this)
      }
      {
        i += 1; i - 1
      }
    }
    append(rbracket)
  }

}
