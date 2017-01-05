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
import io.vertx.ext.web.{MIMEHeader => JMIMEHeader}

class MIMEHeader(private val _asJava: Object) 
    extends ParsedHeaderValue {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  override def rawValue():String = {
    asJava.asInstanceOf[JMIMEHeader].rawValue().asInstanceOf[String]
  }

  override def value():String = {
    asJava.asInstanceOf[JMIMEHeader].value().asInstanceOf[String]
  }

  override def weight():Float = {
    asJava.asInstanceOf[JMIMEHeader].weight().asInstanceOf[Float]
  }

  override def parameter(key: String):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JMIMEHeader].parameter(key.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  override def parameters():scala.collection.mutable.Map[String, String] = {
    collection.mutable.Map(asJava.asInstanceOf[JMIMEHeader].parameters().asScala.mapValues(x => x.asInstanceOf[String]).toSeq: _*)
  }

  override def isPermitted():Boolean = {
    asJava.asInstanceOf[JMIMEHeader].isPermitted().asInstanceOf[Boolean]
  }

  override def isMatchedBy(matchTry: ParsedHeaderValue):Boolean = {
    asJava.asInstanceOf[JMIMEHeader].isMatchedBy(matchTry.asJava.asInstanceOf[JParsedHeaderValue]).asInstanceOf[Boolean]
  }

  override def weightedOrder():Int = {
    asJava.asInstanceOf[JMIMEHeader].weightedOrder().asInstanceOf[Int]
  }

  def component():String = {
    asJava.asInstanceOf[JMIMEHeader].component().asInstanceOf[String]
  }

  def subComponent():String = {
    asJava.asInstanceOf[JMIMEHeader].subComponent().asInstanceOf[String]
  }

//future methods
}

  object MIMEHeader{
    def apply(asJava: JMIMEHeader) = new MIMEHeader(asJava)  
  //static methods
  }
