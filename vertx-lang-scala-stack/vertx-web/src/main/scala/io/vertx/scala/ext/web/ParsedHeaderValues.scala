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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{LanguageHeader => JLanguageHeader}
import io.vertx.ext.web.{ParsedHeaderValue => JParsedHeaderValue}
import io.vertx.ext.web.{ParsedHeaderValues => JParsedHeaderValues}
import scala.collection.JavaConverters._
import io.vertx.ext.web.{MIMEHeader => JMIMEHeader}

/**
  * A container with the request's headers that are meaningful enough to be parsed
  * Contains:
  * <ul>
  * <li>Accept -> MIME header, parameters and sortable</li>
  * <li>Accept-Charset -> Parameters and sortable</li>
  * <li>Accept-Encoding -> Parameters and sortable</li>
  * <li>Accept-Language -> Parameters and sortable</li>
  * <li>Content-Type -> MIME header and parameters</li>
  * </ul>
  *
  */
class ParsedHeaderValues(private val _asJava: Object) {

  def asJava = _asJava


  /**
    * @return List of MIME values in the `Accept` header
    */
  def accept(): scala.collection.mutable.Buffer[MIMEHeader] = {
    asJava.asInstanceOf[JParsedHeaderValues].accept().asScala.map(x => MIMEHeader(x))
  }

  /**
    * @return List of charset values in the `Accept-Charset` header
    */
  def acceptCharset(): scala.collection.mutable.Buffer[ParsedHeaderValue] = {
    asJava.asInstanceOf[JParsedHeaderValues].acceptCharset().asScala.map(x => ParsedHeaderValue(x))
  }

  /**
    * @return List of encofing values in the `Accept-Encoding` header
    */
  def acceptEncoding(): scala.collection.mutable.Buffer[ParsedHeaderValue] = {
    asJava.asInstanceOf[JParsedHeaderValues].acceptEncoding().asScala.map(x => ParsedHeaderValue(x))
  }

  /**
    * @return List of languages in the `Accept-Language` header
    */
  def acceptLanguage(): scala.collection.mutable.Buffer[LanguageHeader] = {
    asJava.asInstanceOf[JParsedHeaderValues].acceptLanguage().asScala.map(x => LanguageHeader(x))
  }

  /**
    * @return MIME value in the `Content-Type` header
    */
  def contentType(): MIMEHeader = {
    MIMEHeader(asJava.asInstanceOf[JParsedHeaderValues].contentType())
  }

}

object ParsedHeaderValues {
  def apply(asJava: JParsedHeaderValues) = new ParsedHeaderValues(asJava)  
}
