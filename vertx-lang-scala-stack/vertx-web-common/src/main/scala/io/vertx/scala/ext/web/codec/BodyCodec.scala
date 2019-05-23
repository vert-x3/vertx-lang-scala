/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.ext.web.codec

import io.vertx.core.json.JsonArray
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.codec.{BodyCodec => JBodyCodec}
import scala.reflect.runtime.universe._
import io.vertx.core.json.JsonObject
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A codec for encoding and decoding HTTP bodies.
  */

class BodyCodec[T: TypeTag](private val _asJava: Object) {
  def asJava = _asJava






}

object BodyCodec {
  def apply[T: TypeTag](asJava: JBodyCodec[_]) = new BodyCodec[T](asJava)
  
  /**
   * @return the UTF-8 string codec
   */
  def string(): BodyCodec[String] = {
    BodyCodec[String](JBodyCodec.string())
  }

  /**
   * A codec for strings using a specific `encoding`.   * @param encoding the encoding
   * @return the codec
   */
  def string(encoding: String): BodyCodec[String] = {
    BodyCodec[String](JBodyCodec.string(encoding.asInstanceOf[java.lang.String]))
  }

  /**
   * @return the Buffer codec
   */
  def buffer(): BodyCodec[io.vertx.core.buffer.Buffer] = {
    BodyCodec[io.vertx.core.buffer.Buffer](JBodyCodec.buffer())
  }

  /**
   * @return the JsonObject codec
   */
  def jsonObject(): BodyCodec[io.vertx.core.json.JsonObject] = {
    BodyCodec[io.vertx.core.json.JsonObject](JBodyCodec.jsonObject())
  }

  /**
   * @return the JsonArray codec
   */
  def jsonArray(): BodyCodec[io.vertx.core.json.JsonArray] = {
    BodyCodec[io.vertx.core.json.JsonArray](JBodyCodec.jsonArray())
  }

  /**
   * Create and return a codec for Java objects encoded using Jackson mapper.   * @return a codec for mapping POJO to Json
   */
  def json[U: TypeTag](`type`: Class[U]): BodyCodec[U] = {
    BodyCodec[U](JBodyCodec.json[Object](toJavaClass(`type`)))
  }

  /**
   * @return a codec that simply discards the response
   */
  def none(): BodyCodec[Unit] = {
    BodyCodec[Unit](JBodyCodec.none())
  }

  /**
   * Create a codec that buffers the entire body and then apply the `decode` function and returns the result.   * @param decode the decode function
   * @return the created codec
   */
  def create[T: TypeTag](decode: io.vertx.core.buffer.Buffer => T): BodyCodec[T] = {
    BodyCodec[T](JBodyCodec.create[Object]({x: Buffer => toJava[T](decode(x))}))
  }

  /**
   * A body codec that pipes the body to a write stream.
   * </p>
   * Same as pipe(stream, true).   * @param stream the destination tream
   * @return the body codec for a write stream
   */
  def pipe(stream: WriteStream[io.vertx.core.buffer.Buffer]): BodyCodec[Unit] = {
    BodyCodec[Unit](JBodyCodec.pipe(stream.asJava.asInstanceOf[JWriteStream[Buffer]]))
  }

  /**
   * A body codec that pipes the body to a write stream.   * @param stream the destination stream
   * @param close whether the destination stream should be closed
   * @return the body codec for a write stream
   */
  def pipe(stream: WriteStream[io.vertx.core.buffer.Buffer],close: Boolean): BodyCodec[Unit] = {
    BodyCodec[Unit](JBodyCodec.pipe(stream.asJava.asInstanceOf[JWriteStream[Buffer]], close.asInstanceOf[java.lang.Boolean]))
  }

}
