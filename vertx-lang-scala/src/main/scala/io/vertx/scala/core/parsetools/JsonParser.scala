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

package io.vertx.scala.core.parsetools

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.parsetools.{JsonEvent => JJsonEvent}
import io.vertx.core.buffer.Buffer
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.parsetools.{JsonParser => JJsonParser}
import io.vertx.core.Handler

/**
  * A parser class which allows to incrementally parse json elements and emit json parse events instead of parsing a json
  * element fully. This parser is convenient for parsing large json structures.
  * <p/>
  * The parser can also parse entire object or array when it is convenient, for instance a very large array
  * of small objects can be parsed efficiently by handling array <i>start</i>/<i>end</i> and <i>object</i>
  * events.
  * <p/>
  * Whenever the parser fails to parse or process the stream, the [[io.vertx.scala.core.parsetools.JsonParser#exceptionHandler]] is called with
  * the cause of the failure and the current handling stops. After such event, the parser should not handle data
  * anymore.
  */
class JsonParser(private val _asJava: Object)
    extends  ReadStream[JsonEvent] 
    with io.vertx.core.Handler[io.vertx.core.buffer.Buffer]  {

  def asJava = _asJava


  /**
    * Handle a `Buffer`, pretty much like calling [[io.vertx.scala.core.Handler#handle]].
    * @return a reference to this, so the API can be used fluently
    */
  def write(buffer: io.vertx.core.buffer.Buffer): JsonParser = {
    asJava.asInstanceOf[JJsonParser].write(buffer)
    this
  }

  /**
    * Flip the parser to emit a stream of events for each new json object.
    * @return a reference to this, so the API can be used fluently
    */
  def objectEventMode(): JsonParser = {
    asJava.asInstanceOf[JJsonParser].objectEventMode()
    this
  }

  /**
    * Flip the parser to emit a single value event for each new json object.
    * </p>
    * Json object currently streamed won't be affected.
    * @return a reference to this, so the API can be used fluently
    */
  def objectValueMode(): JsonParser = {
    asJava.asInstanceOf[JJsonParser].objectValueMode()
    this
  }

  /**
    * Flip the parser to emit a stream of events for each new json array.
    * @return a reference to this, so the API can be used fluently
    */
  def arrayEventMode(): JsonParser = {
    asJava.asInstanceOf[JJsonParser].arrayEventMode()
    this
  }

  /**
    * Flip the parser to emit a single value event for each new json array.
    * </p>
    * Json array currently streamed won't be affected.
    * @return a reference to this, so the API can be used fluently
    */
  def arrayValueMode(): JsonParser = {
    asJava.asInstanceOf[JJsonParser].arrayValueMode()
    this
  }

  override def pause(): JsonParser = {
    asJava.asInstanceOf[JJsonParser].pause()
    this
  }

  override def resume(): JsonParser = {
    asJava.asInstanceOf[JJsonParser].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]): JsonParser = {
    asJava.asInstanceOf[JJsonParser].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  override def handler(handler: Handler[JsonEvent]): JsonParser = {
    asJava.asInstanceOf[JJsonParser].handler({x: JJsonEvent => handler.handle(JsonEvent(x))})
    this
  }

  override def exceptionHandler(handler: Handler[Throwable]): JsonParser = {
    asJava.asInstanceOf[JJsonParser].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  /**
    * Something has happened, so handle it.
    * @param event the event to handle
    */
  override def handle(event: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JJsonParser].handle(event)
  }

  /**
    * End the stream, this must be called after all the json stream has been processed.
    */
  def end(): Unit = {
    asJava.asInstanceOf[JJsonParser].end()
  }

}

object JsonParser {
  def apply(asJava: JJsonParser) = new JsonParser(asJava)  
  /**
    * Create a new `JsonParser` instance.
    */
  def newParser(): JsonParser = {
    JsonParser(JJsonParser.newParser())
  }

  /**
    * Create a new `JsonParser` instance.
    */
  def newParser(stream: ReadStream[io.vertx.core.buffer.Buffer]): JsonParser = {
    JsonParser(JJsonParser.newParser(stream.asJava.asInstanceOf[JReadStream[Buffer]]))
  }

}
