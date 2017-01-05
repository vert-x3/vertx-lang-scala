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
import io.vertx.ext.web.{ParsedHeaderValue => JParsedHeaderValue}
import scala.collection.JavaConverters._

trait ParsedHeaderValue {

  def asJava: java.lang.Object

  def rawValue():String

  def value():String

  def weight():Float

  def parameter(key: String):scala.Option[String]

  def parameters():scala.collection.mutable.Map[String, String]

  def isPermitted():Boolean

  def isMatchedBy(matchTry: ParsedHeaderValue):Boolean

  def weightedOrder():Int

}

object ParsedHeaderValue{
  def apply(asJava: JParsedHeaderValue):ParsedHeaderValue = new ParsedHeaderValueImpl(asJava)
    private class ParsedHeaderValueImpl(private val _asJava: Object) extends ParsedHeaderValue {

      def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def rawValue():String = {
    asJava.asInstanceOf[JParsedHeaderValue].rawValue().asInstanceOf[String]
  }

  def value():String = {
    asJava.asInstanceOf[JParsedHeaderValue].value().asInstanceOf[String]
  }

  def weight():Float = {
    asJava.asInstanceOf[JParsedHeaderValue].weight().asInstanceOf[Float]
  }

  def parameter(key: String):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JParsedHeaderValue].parameter(key.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  def parameters():scala.collection.mutable.Map[String, String] = {
    collection.mutable.Map(asJava.asInstanceOf[JParsedHeaderValue].parameters().asScala.mapValues(x => x.asInstanceOf[String]).toSeq: _*)
  }

  def isPermitted():Boolean = {
    asJava.asInstanceOf[JParsedHeaderValue].isPermitted().asInstanceOf[Boolean]
  }

  def isMatchedBy(matchTry: ParsedHeaderValue):Boolean = {
    asJava.asInstanceOf[JParsedHeaderValue].isMatchedBy(matchTry.asJava.asInstanceOf[JParsedHeaderValue]).asInstanceOf[Boolean]
  }

  def weightedOrder():Int = {
    asJava.asInstanceOf[JParsedHeaderValue].weightedOrder().asInstanceOf[Int]
  }

//future methods
}
}
