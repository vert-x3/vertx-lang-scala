package io.vertx.lang.scala

import io.vertx.core.json.{JsonArray, JsonObject}
import io.vertx.scala.core.buffer.Buffer

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
object Types {
  type StringAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[String]]
  type BooleanAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Boolean]]
  type CharAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Char]]
  type ByteAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Byte]]
  type IntAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Int]]
  type ShortAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Short]]
  type LongAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Long]]
  type FloatAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Float]]
  type DoubleAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Double]]
  type JsonObjectAsyncMsg= io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[JsonObject]]
  type JsonArrayAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[JsonArray]]
  type BufferAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Buffer]]
}
