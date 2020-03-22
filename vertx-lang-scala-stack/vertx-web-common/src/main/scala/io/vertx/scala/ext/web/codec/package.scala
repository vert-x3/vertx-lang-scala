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
     * Like string from [[io.vertx.ext.web.codec.BodyCodec]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def string() = {
      io.vertx.ext.web.codec.BodyCodec.string()
}
    /**
     * Like string from [[io.vertx.ext.web.codec.BodyCodec]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def string(encoding: java.lang.String) = {
      io.vertx.ext.web.codec.BodyCodec.string(encoding)
}
    /**
     * Like buffer from [[io.vertx.ext.web.codec.BodyCodec]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def buffer() = {
      io.vertx.ext.web.codec.BodyCodec.buffer()
}
    /**
     * Like jsonObject from [[io.vertx.ext.web.codec.BodyCodec]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def jsonObject() = {
      io.vertx.ext.web.codec.BodyCodec.jsonObject()
}
    /**
     * Like jsonArray from [[io.vertx.ext.web.codec.BodyCodec]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def jsonArray() = {
      io.vertx.ext.web.codec.BodyCodec.jsonArray()
}
    /**
     * Like json from [[io.vertx.ext.web.codec.BodyCodec]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def json[U](`type`: Class[U]) = {
      io.vertx.ext.web.codec.BodyCodec.json[U](`type`)
}
    /**
     * Like none from [[io.vertx.ext.web.codec.BodyCodec]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def none() = {
      io.vertx.ext.web.codec.BodyCodec.none()
}
    /**
     * Like create from [[io.vertx.ext.web.codec.BodyCodec]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def create[T](decode: io.vertx.core.buffer.Buffer => T) = {
      io.vertx.ext.web.codec.BodyCodec.create[T]({x: Buffer => decode(x)})
}
    /**
     * Like pipe from [[io.vertx.ext.web.codec.BodyCodec]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def pipe(stream: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) = {
      io.vertx.ext.web.codec.BodyCodec.pipe(stream)
}
    /**
     * Like pipe from [[io.vertx.ext.web.codec.BodyCodec]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def pipe(stream: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer],close: java.lang.Boolean) = {
      io.vertx.ext.web.codec.BodyCodec.pipe(stream, close)
}
    /**
     * Like jsonStream from [[io.vertx.ext.web.codec.BodyCodec]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def jsonStream(parser: io.vertx.core.parsetools.JsonParser) = {
      io.vertx.ext.web.codec.BodyCodec.jsonStream(parser)
}
  }


}
