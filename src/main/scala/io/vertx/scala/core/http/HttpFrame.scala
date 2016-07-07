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

package io.vertx.scala.core.http;

import io.vertx.lang.scala.HandlerOps._
import io.vertx.scala.core.buffer.Buffer

/**
  * An HTTP/2 frame.
  */
class HttpFrame(private val _asJava: io.vertx.core.http.HttpFrame) {

  def asJava: io.vertx.core.http.HttpFrame = _asJava

  /**
    * @return the 8-bit type of the frame
    */
  def `type`: Int = {
    _asJava.`type`()
  }

  /**
    * @return the 8-bit flags specific to the frame
    */
  def flags: Int = {
    _asJava.flags()
  }

  /**
    * @return the frame payload
    */
  def payload: io.vertx.scala.core.buffer.Buffer = {
    Buffer.apply(_asJava.payload())
  }

}

object HttpFrame {

  def apply(_asJava: io.vertx.core.http.HttpFrame): io.vertx.scala.core.http.HttpFrame =
    new io.vertx.scala.core.http.HttpFrame(_asJava)
}
