package io.vertx.lang.scala

import io.vertx.core.json.JsonArray
import io.vertx.lang.scala.json.JsonObject

import scala.reflect.runtime.universe._

/**
  * Created by jochen on 26.11.16.
  */
object Converter {

  def toScala[T](t: Object)(implicit tag: TypeTag[T]): T = {
    val typ = typeOf(tag)
    val name = typ.typeSymbol.fullName
    if(t.isInstanceOf[JsonObject] || t.isInstanceOf[JsonArray] || t.getClass.isEnum || !name.startsWith("io.vertx.scala")){
      t.asInstanceOf[T]
    }
    else {
      val mirror = runtimeMirror(getClass.getClassLoader)
      val instance = mirror.reflectModule(typ.typeSymbol.companion.asModule).instance
      val meth = instance.getClass.getMethod("apply", t.getClass)
      meth.invoke(instance, t).asInstanceOf[T]
    }
  }

  def toJava[T](t: T)(implicit tag: TypeTag[T]): Object = {
    val typ = typeOf(tag)
    val name = typ.typeSymbol.fullName
    if(t.isInstanceOf[JsonObject] || t.isInstanceOf[JsonArray] || t.getClass.isEnum || !name.startsWith("io.vertx")){
      t.asInstanceOf[Object]
    }
    else
      t.getClass.getMethod("asJava").invoke(t)
  }

  def companion(name: String): Object =
    Class.forName(name + "$").getField("MODULE$").get(null)

  def transformPackage(name: String): String = {
    name.replace("io.vertx", "io.vertx.scala")
  }
}
