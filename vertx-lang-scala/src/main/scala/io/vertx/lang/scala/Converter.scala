package io.vertx.lang.scala

import scala.reflect.runtime.universe._

/**
  * Created by jochen on 26.11.16.
  */
object Converter {
  def toScala[T](t:Object)(implicit tag: TypeTag[T]): T = {
    val typ = typeOf(tag)
    //AnyVals are already handled by implicit conversions, nothing to do
    if(typ <:< typeOf[AnyVal])
      t.asInstanceOf[T]
    else
      throw new RuntimeException(s"Unable to convert toScala for ${typ}")
  }

  def toJava[T](t:T)(implicit tag: TypeTag[T]): Object = {
    val typ = typeOf(tag)
    //AnyVals are already handled by implicit conversiosn, nothing to do
    if(typ <:< typeOf[AnyVal])
      t.asInstanceOf[Object]
    else
      throw new RuntimeException(s"Unable to convert toJava for ${typ}")
  }
}
