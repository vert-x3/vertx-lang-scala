package io.vertx.lang.scala.json

import io.vertx.scala.core.Vertx

/**
  * Created by jochen on 07.07.16.
  */
object VerticleMain {
  def main(args: Array[String]) {
    val vertx = Vertx.vertx
    vertx.deployVerticle(classOf[TestVerticle].getName, res => println)
  }
}
