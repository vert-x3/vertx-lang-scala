package io.vertx.lang.scala.testing

import scala.quoted.{Expr, Quotes, Type}

trait TypeUtility {
  inline given [A]: TypeName[A] =
    ${TypeUtility.impl[A]}
}

object TypeUtility {
  def impl[A](using t: Type[A], ctx: Quotes): Expr[TypeName[A]] =
    '{TypeName[A](${Expr(Type.show[A])})}

  def typeName[A](implicit ev: TypeName[A]): String =
    ev.value
}

final case class TypeName[A](value: String)

object TypeName extends TypeUtility
