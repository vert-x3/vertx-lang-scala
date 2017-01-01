package io.vertx.lang.scala

import scala.language.implicitConversions
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.scala.codegen.testmodel.TestDataObject

/**
  * Created by jochen on 31.12.16.
  */
object ConversionTest {
  implicit def testDataObjectToScala(x: JTestDataObject): TestDataObject = TestDataObject(x)
  implicit def testDataObjectToJava(x: TestDataObject): JTestDataObject = x.asJava

  def main(args: Array[String]): Unit = {
    println("WTF")
    val jt = new JTestDataObject()
    testIt(jt)
    println(getIt(jt))
  }

  def testIt(tt: TestDataObject): Unit = {
    println(tt.getWibble)
  }

  def getIt(tt: JTestDataObject): TestDataObject = {
    tt
  }
}
