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

package io.vertx.scala.core.http

import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer

/**
  * An HTTP/2 frame.
  */
class HttpFrame(private val _asJava: JHttpFrame) {

  def asJava: JHttpFrame = _asJava

  /**
    * @return the 8-bit type of the frame
    */
  def `type`(): Int = {
    if (cached_0 == null) {
      cached_0 = asJava.`type`().asInstanceOf
    }
    cached_0
  }

  /**
    * @return the 8-bit flags specific to the frame
    */
  def flags(): Int = {
    if (cached_1 == null) {
      cached_1 = asJava.flags().asInstanceOf
    }
    cached_1
  }

  /**
    * @return the frame payload
    */
  def payload(): Buffer = {
    if (cached_2 == null) {
      cached_2 = Buffer.apply(asJava.payload()).asInstanceOf
    }
    cached_2
  }

  private var cached_0: Int = _
  private var cached_1: Int = _
  private var cached_2: Buffer = _
}

object HttpFrame {

  def apply(_asJava: JHttpFrame): HttpFrame =
    new HttpFrame(_asJava)

}
