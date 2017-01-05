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
import io.vertx.ext.web.{Locale => JLocale}
import io.vertx.ext.web.{LanguageHeader => JLanguageHeader}
import io.vertx.ext.web.{ParsedHeaderValue => JParsedHeaderValue}
import scala.collection.JavaConverters._

/**
  * A parsed language header.
  * Delivers a more direct access to the individual elements of the header it represents
  */
class LanguageHeader(private val _asJava: Object) 
    extends ParsedHeaderValue 
    with Locale(_asJava) {


//cached methods
//fluent methods
//default methods
//basic methods
  override def rawValue():String = {
    asJava.asInstanceOf[JLanguageHeader].rawValue().asInstanceOf[String]
  }

  override def value():String = {
    asJava.asInstanceOf[JLanguageHeader].value().asInstanceOf[String]
  }

  override def weight():Float = {
    asJava.asInstanceOf[JLanguageHeader].weight().asInstanceOf[Float]
  }

  override def parameter(key: String):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JLanguageHeader].parameter(key.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  override def parameters():scala.collection.mutable.Map[String, String] = {
    collection.mutable.Map(asJava.asInstanceOf[JLanguageHeader].parameters().asScala.mapValues(x => x.asInstanceOf[String]).toSeq: _*)
  }

  override def isPermitted():Boolean = {
    asJava.asInstanceOf[JLanguageHeader].isPermitted().asInstanceOf[Boolean]
  }

  override def isMatchedBy(matchTry: ParsedHeaderValue):Boolean = {
    asJava.asInstanceOf[JLanguageHeader].isMatchedBy(matchTry.asJava.asInstanceOf[JParsedHeaderValue]).asInstanceOf[Boolean]
  }

  override def weightedOrder():Int = {
    asJava.asInstanceOf[JLanguageHeader].weightedOrder().asInstanceOf[Int]
  }

  def tag():String = {
    asJava.asInstanceOf[JLanguageHeader].tag().asInstanceOf[String]
  }

  def subtag():scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JLanguageHeader].subtag().asInstanceOf[String])
  }

  def subtag(level: Int):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JLanguageHeader].subtag(level.asInstanceOf[java.lang.Integer]).asInstanceOf[String])
  }

  def subtagCount():Int = {
    asJava.asInstanceOf[JLanguageHeader].subtagCount().asInstanceOf[Int]
  }

//future methods
}

  object LanguageHeader{
    def apply(asJava: JLanguageHeader) = new LanguageHeader(asJava)  
  //static methods
  }
