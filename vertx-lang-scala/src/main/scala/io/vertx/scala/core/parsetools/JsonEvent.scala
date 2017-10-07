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
import io.vertx.core.json.JsonArray
import io.vertx.core.parsetools.{JsonEvent => JJsonEvent}
import io.vertx.core.parsetools.JsonEventType
import io.vertx.core.buffer.Buffer
import io.vertx.core.json.JsonObject

/**
  * A JSON event emited by the [[io.vertx.scala.core.parsetools.JsonParser]].
  */
class JsonEvent(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * @return the type of the event
    */
  def `type`(): io.vertx.core.parsetools.JsonEventType = {
    asJava.asInstanceOf[JJsonEvent].`type`()
  }

  /**
    * @return the name of the field when the event is emitted as a JSON object member
    */
  def fieldName(): String = {
    asJava.asInstanceOf[JJsonEvent].fieldName().asInstanceOf[String]
  }

  /**
    * @return the json value for JsonEventType#VALUE events
    */
  def value(): AnyRef = {
    toScala[java.lang.Object](asJava.asInstanceOf[JJsonEvent].value())
  }

  /**
    * @return true when the JSON value is a number
    */
  def isNumber(): Boolean = {
    asJava.asInstanceOf[JJsonEvent].isNumber().asInstanceOf[Boolean]
  }

  /**
    * @return the `Integer` value or `null` if the event has no JSON value
    */
  def integerValue(): Int = {
    asJava.asInstanceOf[JJsonEvent].integerValue().asInstanceOf[Int]
  }

  /**
    * @return the `Long` value or `null` if the event has no JSON value
    */
  def longValue(): Long = {
    asJava.asInstanceOf[JJsonEvent].longValue().asInstanceOf[Long]
  }

  /**
    * @return the `Float` value or `null` if the event has no JSON value
    */
  def floatValue(): Float = {
    asJava.asInstanceOf[JJsonEvent].floatValue().asInstanceOf[Float]
  }

  /**
    * @return the `Double` value or `null` if the event has no JSON value
    */
  def doubleValue(): Double = {
    asJava.asInstanceOf[JJsonEvent].doubleValue().asInstanceOf[Double]
  }

  /**
    * @return true when the JSON value is a boolean
    */
  def isBoolean(): Boolean = {
    asJava.asInstanceOf[JJsonEvent].isBoolean().asInstanceOf[Boolean]
  }

  /**
    * @return the `Boolean` value or `null` if the event has no JSON value
    */
  def booleanValue(): Boolean = {
    asJava.asInstanceOf[JJsonEvent].booleanValue().asInstanceOf[Boolean]
  }

  /**
    * @return true when the JSON value is a string
    */
  def isString(): Boolean = {
    asJava.asInstanceOf[JJsonEvent].isString().asInstanceOf[Boolean]
  }

  /**
    * @return the string value or `null` if the event has no JSON value
    */
  def stringValue(): String = {
    asJava.asInstanceOf[JJsonEvent].stringValue().asInstanceOf[String]
  }

  /**
    * Return the binary value.
    * 
    * JSON itself has no notion of a binary, this extension complies to the RFC-7493, so this method assumes there is a
    * String value with the key and it contains a Base64 encoded binary, which it decodes if found and returns.
    * @return the binary value or `null` if the event has no JSON value
    */
  def binaryValue(): io.vertx.core.buffer.Buffer = {
    asJava.asInstanceOf[JJsonEvent].binaryValue()
  }

  /**
    * @return true when the JSON value is null
    */
  def isNull(): Boolean = {
    asJava.asInstanceOf[JJsonEvent].isNull().asInstanceOf[Boolean]
  }

  /**
    * @return true when the JSON value is a JSON object
    */
  def isObject(): Boolean = {
    asJava.asInstanceOf[JJsonEvent].isObject().asInstanceOf[Boolean]
  }

  /**
    * @return the JSON object value or `null` if the event has no JSON value
    */
  def objectValue(): io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JJsonEvent].objectValue()
  }

  /**
    * @return true when the JSON value is a JSON array
    */
  def isArray(): Boolean = {
    asJava.asInstanceOf[JJsonEvent].isArray().asInstanceOf[Boolean]
  }

  /**
    * @return the JSON array value or `null` if the event has no JSON value
    */
  def arrayValue(): io.vertx.core.json.JsonArray = {
    asJava.asInstanceOf[JJsonEvent].arrayValue()
  }

  /**
    * Decodes and returns the current value as the specified `type`.
    * @param type the type to decode the value to
    * @return the decoded value
    */
  def mapTo[T: TypeTag](`type`: Class[T]): T = {
    toScala[T](asJava.asInstanceOf[JJsonEvent].mapTo[Object](toJavaClass(`type`)))
  }

}

object JsonEvent {
  def apply(asJava: JJsonEvent) = new JsonEvent(asJava)  
}
