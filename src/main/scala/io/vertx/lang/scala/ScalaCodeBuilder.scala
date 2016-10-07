package io.vertx.lang.scala

import com.sun.source.tree.LambdaExpressionTree.BodyKind
import io.vertx.codegen.`type`.ApiTypeInfo
import io.vertx.codegen.`type`.ClassTypeInfo
import io.vertx.codegen.`type`.EnumTypeInfo
import io.vertx.codegen.`type`.ParameterizedTypeInfo
import io.vertx.codegen.`type`.TypeInfo
import io.vertx.codetrans._
import io.vertx.codetrans.expression._
import io.vertx.codetrans.statement.StatementModel
import java.util.function.Consumer

import scala.collection.JavaConversions._

class ScalaCodeBuilder extends CodeBuilder {

  val imports = scala.collection.mutable.LinkedHashSet[ClassTypeInfo]()

  var asyncResults:List[String] = List()

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
          renderer.append("var ").append(name)
          if (initializer != null) {
            renderer.append(" = ")
            initializer.render(renderer)
          }
      }
    })


  override def asyncResultHandler(bodyKind: BodyKind, parameterizedTypeInfo: ParameterizedTypeInfo, s: String, codeModel: CodeModel, codeModel1: CodeModel, codeModel2: CodeModel): ExpressionModel = {
    new ExpressionModel(this) {
      override def render(writer: CodeWriter) {
        asyncResults = s :: asyncResults
        writer.append("\n")
        writer.indent()
        writer.append(s"case Success(result) => ")
        writer.indent()

        if(codeModel1 != null) {
          writer.append("{\n")
          codeModel1.render(writer)
          writer.unindent()
          writer.append("}\n")
        }
        else {
          writer.append("println(\"Success\")\n")
          writer.unindent()
        }

        writer.append(s"case Failure(cause) => ")
        writer.indent()
        if(codeModel2 != null) {
          writer.append("{\n")
          writer.append("println(s\"$cause\")")
//          codeModel2.render(writer)
          writer.unindent()
          writer.append("}\n")
        }
        else {
          writer.append("println(\"Failure\")\n")
          writer.unindent()
        }
        writer.unindent()
      }
    }
  }

  override def enhancedForLoop(variableName: String, expression: ExpressionModel, body: StatementModel): StatementModel = {
    new StatementModel() {
      override def render(renderer: CodeWriter): Unit = {
        expression.render(renderer)
        renderer.append(s".foreach(${variableName} => {")
        renderer.append("\n")
        renderer.indent()
        body.render(renderer)
        renderer.unindent()
        renderer.append("}\n")
      }
    }
  }


  override def forLoop(initializer: StatementModel, condition: ExpressionModel, update: ExpressionModel, body: StatementModel): StatementModel = {
    new StatementModel() {
      override def render(renderer: CodeWriter): Unit = {
        val condExp = condition.asInstanceOf[BinaryExpressionModel]
        initializer.render(renderer)
        renderer.append("\nwhile(")
        condition.render(renderer)
        renderer.append("){\n")
        renderer.indent()
        condExp.getLeft.render(renderer)
        renderer.append(" += ")
        update.render(renderer)
        renderer.append("\n")
        body.render(renderer)
        renderer.unindent()
        renderer.append("}\n")
      }
    }
  }

  override def sequenceForLoop(variableName: String, fromValue: ExpressionModel, toValue: ExpressionModel, body: StatementModel): StatementModel = {
    new StatementModel() {
      override def render(renderer: CodeWriter): Unit = {
        renderer.append(s"for ( ${variableName} <- ")
        fromValue.render(renderer)
        renderer.append(" to ")
        toValue.render(renderer)
        renderer.append(") {\n")
        renderer.indent
        body.render(renderer)
        renderer.unindent
        renderer.append("}\n")
      }
    }
  }


  override def api(expr: ExpressionModel): ApiModel = {
    new ScalaApiTypeModel(this, expr)
  }

  override def render(unit: RunnableCompilationUnit): String = {
    val writer: CodeWriter = newWriter

    for (importedType <- imports) {
      var fqn: String = importedType.getName
      if (importedType.isInstanceOf[ApiTypeInfo]) fqn = importedType.translateName("scala")
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

    asyncResults.foldLeft(writer.getBuffer.toString)((ret, ar) => ret.replace(s"${ar}.result()", "result"))
  }


}
