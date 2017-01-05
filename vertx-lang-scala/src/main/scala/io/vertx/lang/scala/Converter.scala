package io.vertx.lang.scala

import io.vertx.core.json.JsonArray
import io.vertx.lang.scala.json.JsonObject

import scala.util.{Success, Failure, Try}
import scala.reflect.runtime.universe._

/**
  * Created by jochen on 26.11.16.
  */
object Converter {

  def toScala[T](t: Object)(implicit tag: TypeTag[T]): T = {
    val typ = typeOf(tag)
    val name = typ.typeSymbol.fullName
    val n = t == null
    if(n || t.isInstanceOf[JsonObject] || t.isInstanceOf[JsonArray] || t.getClass.isEnum || !name.startsWith("io.vertx.scala")){
      t.asInstanceOf[T]
    }
    else {
      val mirror = runtimeMirror(getClass.getClassLoader)
      val instance = mirror.reflectModule(typ.typeSymbol.companion.asModule).instance
      //TODO: I have to do this because of some tests using an Impl-class. Need to check the perf-impact
      Try(instance.getClass.getMethod("apply", t.getClass)) match {
        case Success(m) => m.invoke(instance, t).asInstanceOf[T]
        case Failure(_) => instance.getClass.getMethod("apply", t.getClass.getInterfaces()(0)).invoke(instance, t).asInstanceOf[T]
      }

    }
  }

  def toJava[T](t: T)(implicit tag: TypeTag[T]): Object = {
    val typ = typeOf(tag)
    val name = typ.typeSymbol.fullName
    val n = t == null
    if(n || t.isInstanceOf[JsonObject] || t.isInstanceOf[JsonArray] || t.getClass.isEnum || !name.startsWith("io.vertx.scala")){
      t.asInstanceOf[Object]
    }
    else
      t.getClass.getMethod("asJava").invoke(t)
  }

  def toJavaClass[T](clazz: Class[T])(implicit tag: TypeTag[T]): Class[Object] = {
    val typ = typeOf(tag)
    val name = typ.typeSymbol.fullName
    val n = clazz == null
    if(n || clazz == classOf[JsonObject] || clazz == classOf[JsonArray] || !name.startsWith("io.vertx.scala")){
      clazz.asInstanceOf[Class[Object]]
    }
    else {
      clazz.getClassLoader.loadClass(name.replace(".scala","")).asInstanceOf[Class[Object]]
    }
  }
  def toScalaClass[T](clazz: Class[T])(implicit tag: TypeTag[T]): Class[Object] = {
    val typ = typeOf(tag)
    val name = typ.typeSymbol.fullName
    val n = clazz == null
    if(n || clazz == classOf[JsonObject] || clazz == classOf[JsonArray] || !name.startsWith("io.vertx")){
      clazz.asInstanceOf[Class[Object]]
    }
    else {
      clazz.getClassLoader.loadClass(name.replace("io.vertx", "io.vertx.scala")).asInstanceOf[Class[Object]]
    }
  }

  def companion(name: String): Object =
    Class.forName(name + "$").getField("MODULE$").get(null)

  def transformPackage(name: String): String = {
    name.replace("io.vertx", "io.vertx.scala")
  }
}
