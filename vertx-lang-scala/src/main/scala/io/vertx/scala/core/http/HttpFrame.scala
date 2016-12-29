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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.scala.core.buffer.Buffer

/**
  * An HTTP/2 frame.
  */
class HttpFrame(private val _asJava: Object, private val _useTypeTags:Boolean = false) {

  def asJava = _asJava
  private var cached_0:Int = _
  private var cached_1:Int = _
  private var cached_2:Buffer = _

//cached methods
  def `type`():Int = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JHttpFrame].`type`()
      cached_0 = tmp.asInstanceOf[Int]
    }
    cached_0
  }

  def flags():Int = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JHttpFrame].flags()
      cached_1 = tmp.asInstanceOf[Int]
    }
    cached_1
  }

  def payload():Buffer = {
    if(cached_2 == null) {
      var tmp = asJava.asInstanceOf[JHttpFrame].payload()
      cached_2 = Buffer(tmp)
    }
    cached_2
  }

//fluent methods
//default methods
//basic methods
//future methods
}

  object HttpFrame{
    def apply(asJava: Object, useTypeTags:Boolean = false) = new HttpFrame(asJava, useTypeTags)  
  //static methods
  }
