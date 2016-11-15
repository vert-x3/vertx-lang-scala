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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.sql.{SQLRowStream => JSQLRowStream}
import io.vertx.core.json.JsonArray
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream

/**
  * A ReadStream of Rows from the underlying RDBMS. This class follows the ReadStream semantics and will automatically
  * close the underlying resources if all returned rows are returned. For cases where the results are ignored before the
  * full processing of the returned rows is complete the close method **MUST** be called in order to release underlying
  * resources.
  *
  * The interface is minimal in order to support all SQL clients not just JDBC.
  */
class SQLRowStream(private val _asJava: JSQLRowStream) 
    extends ReadStream[JsonArray] {

  def asJava: JSQLRowStream = _asJava

  def exceptionHandler(arg0: Throwable => Unit): ReadStream[JsonArray] = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(arg0))
    this
  }

  def handler(arg0: JsonArray => Unit): ReadStream[JsonArray] = {
    _asJava.handler(funcToHandler[JsonArray](arg0))
    this
  }

  def pause(): ReadStream[JsonArray] = {
    _asJava.pause()
    this
  }

  def resume(): ReadStream[JsonArray] = {
    _asJava.resume()
    this
  }

  def endHandler(arg0: () => Unit): ReadStream[JsonArray] = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => arg0()))
    this
  }

  /**
    * Will convert the column name to the json array index
    * @return 
    */
  def column(name: String): Int = {
    _asJava.column(name)
  }

  /**
    * Closes the stream/underlying cursor(s)
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SQLRowStream {

  def apply(_asJava: JSQLRowStream): SQLRowStream =
    new SQLRowStream(_asJava)

}
