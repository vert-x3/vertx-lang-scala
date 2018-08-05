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

import io.vertx.core.buffer.Buffer
import scala.reflect.runtime.universe._
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * An HTTP/2 frame.
  */

class HttpFrame(private val _asJava: Object) {
  def asJava = _asJava
  private var cached_0: Option[Int] = None
  private var cached_1: Option[Int] = None
  private var cached_2: Option[io.vertx.core.buffer.Buffer] = None


  /**
   * @return the 8-bit type of the frame
   */
  def `type`(): Int = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JHttpFrame].`type`()
      cached_0 = Some(tmp.asInstanceOf[Int])
    }
    cached_0.get
  }

  /**
   * @return the 8-bit flags specific to the frame
   */
  def flags(): Int = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JHttpFrame].flags()
      cached_1 = Some(tmp.asInstanceOf[Int])
    }
    cached_1.get
  }

  /**
   * @return the frame payload
   */
  def payload(): io.vertx.core.buffer.Buffer = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JHttpFrame].payload()
      cached_2 = Some(tmp)
    }
    cached_2.get
  }





}

object HttpFrame {
  def apply(asJava: JHttpFrame) = new HttpFrame(asJava)
  
}
