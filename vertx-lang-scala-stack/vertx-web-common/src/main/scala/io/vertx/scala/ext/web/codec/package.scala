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

package io.vertx.scala.ext.web

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core.json.JsonArray
import io.vertx.core.buffer.Buffer
import io.vertx.ext.web.codec.{BodyCodec => JBodyCodec}
import io.vertx.core.streams
import io.vertx.core.parsetools.{JsonParser => JJsonParser}
import io.vertx.core.json.JsonObject
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.core.parsetools

package object codec{

  object BodyCodec {
    /**
     * @return the UTF-8 string codec
     */
def string() = {
      io.vertx.ext.web.codec.BodyCodec.string()
}
    /**
     * A codec for strings using a specific `encoding`.     * @param encoding the encoding
     * @return the codec
     */
def string(encoding: java.lang.String) = {
      io.vertx.ext.web.codec.BodyCodec.string(encoding)
}
    /**
     * @return the Buffer codec
     */
def buffer() = {
      io.vertx.ext.web.codec.BodyCodec.buffer()
}
    /**
     * @return the JsonObject codec
     */
def jsonObject() = {
      io.vertx.ext.web.codec.BodyCodec.jsonObject()
}
    /**
     * @return the JsonArray codec
     */
def jsonArray() = {
      io.vertx.ext.web.codec.BodyCodec.jsonArray()
}
    /**
     * Create and return a codec for Java objects encoded using Jackson mapper.     * @return a codec for mapping POJO to Json
     */
def json[U](`type`: Class[U]) = {
      io.vertx.ext.web.codec.BodyCodec.json[U](`type`)
}
    /**
     * @return a codec that simply discards the response
     */
def none() = {
      io.vertx.ext.web.codec.BodyCodec.none()
}
    /**
     * Create a codec that buffers the entire body and then apply the `decode` function and returns the result.     * @param decode the decode function
     * @return the created codec
     */
def create[T](decode: io.vertx.core.buffer.Buffer => T) = {
      io.vertx.ext.web.codec.BodyCodec.create[T]({x: Buffer => decode(x)})
}
    /**
     * A body codec that pipes the body to a write stream.
     * </p>
     * Same as pipe(stream, true).     * @param stream the destination stream
     * @return the body codec for a write stream
     */
def pipe(stream: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) = {
      io.vertx.ext.web.codec.BodyCodec.pipe(stream)
}
    /**
     * A body codec that pipes the body to a write stream.     * @param stream the destination stream
     * @param close whether the destination stream should be closed
     * @return the body codec for a write stream
     */
def pipe(stream: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer],close: java.lang.Boolean) = {
      io.vertx.ext.web.codec.BodyCodec.pipe(stream, close)
}
    /**
     * A body codec that parse the response as a JSON stream.     * @param parser the non-null JSON parser to emits the JSON object. The parser must be configured for the stream. Not e that you need to keep a reference on the parser to retrieved the JSON events.
     * @return the body codec for a write stream
     */
def jsonStream(parser: io.vertx.core.parsetools.JsonParser) = {
      io.vertx.ext.web.codec.BodyCodec.jsonStream(parser)
}
  }


}
