package io.vertx.lang.scala

import com.sun.source.tree.LambdaExpressionTree.BodyKind
import io.vertx.codegen.`type`.ApiTypeInfo
import io.vertx.codegen.`type`.ClassTypeInfo
import io.vertx.codegen.`type`.EnumTypeInfo
import io.vertx.codegen.`type`.ParameterizedTypeInfo
import io.vertx.codegen.`type`.TypeInfo
import io.vertx.codetrans._
import io.vertx.codetrans.expression.ApiTypeModel
import io.vertx.codetrans.expression.EnumExpressionModel
import io.vertx.codetrans.expression.ExpressionModel
import io.vertx.codetrans.expression.LambdaExpressionModel
import io.vertx.codetrans.expression.VariableScope
import io.vertx.codetrans.statement.StatementModel
import java.util.Collections
import java.util.function.Consumer

import scala.collection.JavaConversions._

class ScalaCodeBuilder extends CodeBuilder {

  val imports = scala.collection.mutable.LinkedHashSet[ClassTypeInfo]()

  override def newWriter(): CodeWriter = new ScalaCodeWriter(this)


  override def apiType(`type`: ApiTypeInfo): ApiTypeModel = {
    imports += `type`
    return super.apiType(`type`)
  }


  override def enumType(`type`: EnumTypeInfo): EnumExpressionModel = {
    imports += `type`
    return super.enumType(`type`)
  }

  override def variableDecl(scope: VariableScope, `type`: TypeInfo, name: String, initializer: ExpressionModel): StatementModel =
    StatementModel.render(new Consumer[CodeWriter] {
      override def accept(renderer: CodeWriter): Unit = {
          renderer.append("var ").append(name);
          if (initializer != null) {
            renderer.append(" = ");
            initializer.render(renderer);
          }
      }
    })

  override def asyncResultHandler(bodyKind: BodyKind, resultType: ParameterizedTypeInfo, resultName: String, body: CodeModel): ExpressionModel = new LambdaExpressionModel(this, bodyKind, Collections.singletonList(resultType), Collections.singletonList(resultName), body)

  override def enhancedForLoop(variableName: String, expression: ExpressionModel, body: StatementModel): StatementModel = {
    new StatementModel() {
      override def render(renderer: CodeWriter): Unit = {
        renderer.append("enhancedForLoop")
      }
    }
  }

  override def forLoop(initializer: StatementModel, condition: ExpressionModel, update: ExpressionModel, body: StatementModel): StatementModel = {
    new StatementModel() {
      override def render(renderer: CodeWriter): Unit = {
        renderer.append("forLoop")
      }
    }
  }


  override def render(unit: RunnableCompilationUnit): String = {
    val writer: CodeWriter = newWriter

    for (importedType <- imports) {
      var fqn: String = importedType.getName
      if (importedType.isInstanceOf[ApiTypeInfo]) fqn = importedType.translateName("groovy")
      writer.append("import ").append(fqn).append('\n')
    }
    import scala.collection.JavaConversions._
    for (field <- unit.getFields.entrySet) {
      writer.append("val ")
      field.getValue.render(writer)
      writer.append("\n")
    }
    for (method <- unit.getMethods.entrySet) {
      writer.append("def ").append(method.getKey).append("(")

      method.getValue.getParameterNames.zipWithIndex.foreach{
        case (v, i) => {
          if(i > 0) writer.append(", ")
          writer.append(v)
        }
      }

      writer.append(") {\n")
      writer.indent
      method.getValue.render(writer)
      writer.unindent
      writer.append("}\n")
    }
    unit.getMain.render(writer)
    return writer.getBuffer.toString
  }
}
