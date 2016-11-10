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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.web.{ParsedHeaderValues => JParsedHeaderValues}
import io.vertx.ext.web.{ParsedHeaderValue => JParsedHeaderValue}
import io.vertx.ext.web.{MIMEHeader => JMIMEHeader}
import io.vertx.ext.web.{LanguageHeader => JLanguageHeader}

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
class ParsedHeaderValues(private val _asJava: JParsedHeaderValues) {

  def asJava: JParsedHeaderValues = _asJava

  /**
    * @return List of MIME values in the `Accept` header
    */
  def accept(): scala.collection.mutable.Buffer[MIMEHeader] = {
    _asJava.accept().asScala.map(MIMEHeader.apply)
  }

  /**
    * @return List of charset values in the `Accept-Charset` header
    */
  def acceptCharset(): scala.collection.mutable.Buffer[ParsedHeaderValue] = {
    _asJava.acceptCharset().asScala.map(ParsedHeaderValue.apply)
  }

  /**
    * @return List of encofing values in the `Accept-Encoding` header
    */
  def acceptEncoding(): scala.collection.mutable.Buffer[ParsedHeaderValue] = {
    _asJava.acceptEncoding().asScala.map(ParsedHeaderValue.apply)
  }

  /**
    * @return List of languages in the `Accept-Language` header
    */
  def acceptLanguage(): scala.collection.mutable.Buffer[LanguageHeader] = {
    _asJava.acceptLanguage().asScala.map(LanguageHeader.apply)
  }

  /**
    * @return MIME value in the `Content-Type` header
    */
  def contentType(): MIMEHeader = {
    MIMEHeader.apply(_asJava.contentType())
  }

}

object ParsedHeaderValues {

  def apply(_asJava: JParsedHeaderValues): ParsedHeaderValues =
    new ParsedHeaderValues(_asJava)

}
