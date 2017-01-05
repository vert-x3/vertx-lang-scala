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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{Session => JSession}

/**
  * Represents a browser session.
  * 
  * Sessions persist between HTTP requests for a single browser session. They are deleted when the browser is closed, or
  * they time-out. Session cookies are used to maintain sessions using a secure UUID.
  * 
  * Sessions can be used to maintain data for a browser session, e.g. a shopping basket.
  * 
  * The context must have first been routed to a [[io.vertx.scala.ext.web.handler.SessionHandler]]
  * for sessions to be available.
  */
class Session(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
  def put(key: String,obj: AnyRef):Session = {
    asJava.asInstanceOf[JSession].put(key.asInstanceOf[java.lang.String],toJava[Object](obj))
    this
  }

//default methods
//basic methods
  def regenerateId():Session = {
    Session(asJava.asInstanceOf[JSession].regenerateId())
  }

  def id():String = {
    asJava.asInstanceOf[JSession].id().asInstanceOf[String]
  }

  def get[T:TypeTag](key: String):T = {
    toScala[T](asJava.asInstanceOf[JSession].get[Object](key.asInstanceOf[java.lang.String]))
  }

  def remove[T:TypeTag](key: String):T = {
    toScala[T](asJava.asInstanceOf[JSession].remove[Object](key.asInstanceOf[java.lang.String]))
  }

  def lastAccessed():Long = {
    asJava.asInstanceOf[JSession].lastAccessed().asInstanceOf[Long]
  }

  def destroy():Unit = {
    asJava.asInstanceOf[JSession].destroy()
  }

  def isDestroyed():Boolean = {
    asJava.asInstanceOf[JSession].isDestroyed().asInstanceOf[Boolean]
  }

  def isRegenerated():Boolean = {
    asJava.asInstanceOf[JSession].isRegenerated().asInstanceOf[Boolean]
  }

  def oldId():String = {
    asJava.asInstanceOf[JSession].oldId().asInstanceOf[String]
  }

  def timeout():Long = {
    asJava.asInstanceOf[JSession].timeout().asInstanceOf[Long]
  }

  def setAccessed():Unit = {
    asJava.asInstanceOf[JSession].setAccessed()
  }

//future methods
}

  object Session{
    def apply(asJava: JSession) = new Session(asJava)  
  //static methods
  }
