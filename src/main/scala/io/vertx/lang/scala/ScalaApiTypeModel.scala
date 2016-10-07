package io.vertx.lang.scala

import java.util

import io.vertx.codegen.`type`.{ClassKind, ParameterizedTypeInfo, TypeInfo}
import io.vertx.codetrans.{CodeBuilder, CodeWriter, MethodSignature}
import io.vertx.codetrans.expression.{ApiModel, ExpressionModel, MethodInvocationModel}

import scala.collection.JavaConversions._

class ScalaApiTypeModel(builder: CodeBuilder, expression: ExpressionModel) extends ApiModel(builder, expression) {

  override def onMethodInvocation(receiverType: TypeInfo, method: MethodSignature, returnType: TypeInfo, argumentModels: util.List[ExpressionModel], argumentTypes: util.List[TypeInfo]): ExpressionModel = {
    if (argumentTypes.size() > 0) {
      val last = argumentTypes.get(argumentTypes.size() - 1)
      if (last.getKind() == ClassKind.HANDLER && last.asInstanceOf[ParameterizedTypeInfo].getArg(0).getKind() == ClassKind.ASYNC_RESULT){
        // Return an ExpressionModel that the composition of two MethodInvocationModel that
        // the first one calls the method that returns the future
        // the second one does the onComplete call

        val lastIndex = if(method.getParameterTypes.size()-1 < 0) 0 else method.getParameterTypes.size()
        val futureMethodSignature = new MethodSignature(method.getName+"Future", method.getParameterTypes.subList(0, lastIndex), false)
        val futureArgumentModels = argumentModels.subList(0, if(argumentModels.size()-1 < 0) 0 else argumentModels.size()-1)
        val futureArgumentTypes = argumentTypes.subList(0, if(argumentTypes.size()-1 < 0) 0 else argumentTypes.size()-1)

        val futureModel = new MethodInvocationModel(builder, expression, receiverType, futureMethodSignature, returnType, futureArgumentModels, futureArgumentTypes)

        val handlerMethodSignature = new MethodSignature("onComplete", List(method.getParameterTypes.get(method.getParameterTypes.size()-1)), false)
        val completeMethod =  new MethodInvocationModel(builder, expression, receiverType, handlerMethodSignature, returnType, List(argumentModels.get(argumentModels.size()-1)), List(argumentTypes.get(argumentTypes.size()-1)))


        return new ExpressionModel(builder) {
          override def render(writer: CodeWriter): Unit = {
            futureModel.render(writer)
            completeMethod.render(writer)
          }
        }
      }
    }

    return super.onMethodInvocation(receiverType, method, returnType, argumentModels, argumentTypes)
  }

}
