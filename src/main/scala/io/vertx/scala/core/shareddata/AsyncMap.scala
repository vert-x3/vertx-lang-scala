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

package io.vertx.scala.core.shareddata;

import scala.util.Try
import io.vertx.core.Handler

class AsyncMap[K, V](private val _asJava: io.vertx.core.shareddata.AsyncMap[K, V]) {

  def asJava: java.lang.Object = _asJava

  def get(k: K)(resultHandler: Try[V] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.get(k, funcToAsyncResultHandler(resultHandler))
  }

  def put(k: K, v: V)(completionHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.put(k, v, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(completionHandler))
  }

  def put(k: K, v: V, timeout: Long)(completionHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.put(k, v, timeout, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(completionHandler))
  }

  def putIfAbsent(k: K, v: V)(completionHandler: Try[V] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.putIfAbsent(k, v, funcToAsyncResultHandler(completionHandler))
  }

  def putIfAbsent(k: K, v: V, timeout: Long)(completionHandler: Try[V] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.putIfAbsent(k, v, timeout, funcToAsyncResultHandler(completionHandler))
  }

  def remove(k: K)(resultHandler: Try[V] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.remove(k, funcToAsyncResultHandler(resultHandler))
  }

  def removeIfPresent(k: K, v: V)(resultHandler: Try[Boolean] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.removeIfPresent(k, v, funcToMappedAsyncResultHandler[java.lang.Boolean, Boolean](x => x)(resultHandler))
  }

  def replace(k: K, v: V)(resultHandler: Try[V] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.replace(k, v, funcToAsyncResultHandler(resultHandler))
  }

  def replaceIfPresent(k: K, oldValue: V, newValue: V)(resultHandler: Try[Boolean] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.replaceIfPresent(k, oldValue, newValue, funcToMappedAsyncResultHandler[java.lang.Boolean, Boolean](x => x)(resultHandler))
  }

  def clear(resultHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.clear(funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(resultHandler))
  }

  def size(resultHandler: Try[Int] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.size(funcToMappedAsyncResultHandler[java.lang.Integer, Int](x => x)(resultHandler))
  }

}

object AsyncMap {

  def apply[K, V](_asJava: io.vertx.core.shareddata.AsyncMap[K,V]): io.vertx.scala.core.shareddata.AsyncMap[K, V] =
    new io.vertx.scala.core.shareddata.AsyncMap[K, V](_asJava)
}
