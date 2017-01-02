package io.vertx.lang.scala

import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}

import io.vertx.scala.codegen.testmodel.TestDataObject

import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._

/**
  * Created by jochen on 02.01.17.
  */
class Con {
  def returnsScala[T:TypeTag](): T = {
    toScala[T](new JTestDataObject())
  }


  def returnsJava[T:TypeTag](): T = {
    toJava[T](TestDataObject())
  }
}
