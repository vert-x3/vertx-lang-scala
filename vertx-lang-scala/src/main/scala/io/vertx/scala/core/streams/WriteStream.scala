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

package io.vertx.scala.core.streams

import io.vertx.core.streams.{StreamBase => JStreamBase}
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}

/**
  *
  * Represents a stream of data that can be written to.
  * 
  * Any class that implements this interface can be used by a [[io.vertx.scala.core.streams.Pump]] to pump data from a `ReadStream`
  * to it.
  */
trait WriteStream 
    extends StreamBase(_asJava) {

//methods returning a future
//cached methods
//fluent methods
def exceptionHandler
def write
def setWriteQueueMaxSize
def drainHandler
//basic methods
def end()
def writeQueueFull()
//in object!
//static methods
//default methods
def end
}
