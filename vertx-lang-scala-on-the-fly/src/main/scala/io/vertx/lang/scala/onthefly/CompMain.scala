package io.vertx.lang.scala.onthefly

/**
  * Created by jochen on 17.03.17.
  */
object CompMain {
  def main(args: Array[String]): Unit = {
    val compiler = new OnTheFlyCompiler(None)
    val clazz = compiler
      .tryToCompileClass("/Users/jochen/Development/8_vertx/vertx-lang-scala/vertx-lang-scala-on-the-fly/src/test/resources/SourceClass.scala")
        .get

    val method = clazz.getDeclaredMethod("doIt")
    val inst = clazz.newInstance()
    println(method.invoke(inst))
  }
}
