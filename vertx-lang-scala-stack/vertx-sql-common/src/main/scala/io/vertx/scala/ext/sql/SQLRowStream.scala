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

package io.vertx.scala.ext.sql

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.json.JsonArray
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.ext.sql.{SQLRowStream => JSQLRowStream}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * A ReadStream of Rows from the underlying RDBMS. This class follows the ReadStream semantics and will automatically
  * close the underlying resources if all returned rows are returned. For cases where the results are ignored before the
  * full processing of the returned rows is complete the close method **MUST** be called in order to release underlying
  * resources.
  *
  * The interface is minimal in order to support all SQL clients not just JDBC.
  */
class SQLRowStream(private val _asJava: Object) 
    extends ReadStream[io.vertx.core.json.JsonArray] {

  def asJava = _asJava

//cached methods
//fluent methods
  override def exceptionHandler(arg0: Handler[Throwable]):ReadStream[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JSQLRowStream].exceptionHandler({x: Throwable => arg0.handle(x)})
    this
  }

  override def handler(arg0: Handler[io.vertx.core.json.JsonArray]):ReadStream[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JSQLRowStream].handler({x: JsonArray => arg0.handle(x)})
    this
  }

  override def pause():ReadStream[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JSQLRowStream].pause()
    this
  }

  override def resume():ReadStream[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JSQLRowStream].resume()
    this
  }

  override def endHandler(arg0: Handler[Unit]):ReadStream[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JSQLRowStream].endHandler({x: Void => arg0.handle(x)})
    this
  }

//default methods
//basic methods
  def column(name: String):Int = {
    asJava.asInstanceOf[JSQLRowStream].column(name.asInstanceOf[java.lang.String]).asInstanceOf[Int]
  }

  def resultSetClosedHandler(handler: Handler[Unit]):SQLRowStream = {
    SQLRowStream(asJava.asInstanceOf[JSQLRowStream].resultSetClosedHandler({x: Void => handler.handle(x)}))
  }

  def moreResults():Unit = {
    asJava.asInstanceOf[JSQLRowStream].moreResults()
  }

  def close():Unit = {
    asJava.asInstanceOf[JSQLRowStream].close()
  }

  def close(handler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JSQLRowStream].close({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

//future methods
    def closeFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JSQLRowStream].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object SQLRowStream{
    def apply(asJava: JSQLRowStream) = new SQLRowStream(asJava)  
  //static methods
  }
