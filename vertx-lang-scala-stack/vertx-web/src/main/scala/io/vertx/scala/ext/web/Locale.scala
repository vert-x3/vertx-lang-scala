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
import io.vertx.ext.web.{Locale => JLocale}

class Locale(private val _asJava: JLocale) {

  def asJava: JLocale = _asJava

  /**
    * Returns the language as reported by the HTTP client.
    * @return language
    */
  def language(): String = {
    _asJava.language()
  }

  /**
    * Returns the country as reported by the HTTP client.
    * @return variant
    */
  def country(): String = {
    _asJava.country()
  }

  /**
    * Returns the variant as reported by the HTTP client.
    * @return variant
    */
  def variant(): String = {
    _asJava.variant()
  }

}

object Locale {

  def apply(_asJava: JLocale): Locale =
    new Locale(_asJava)

  def create(): Locale = {
    Locale.apply(io.vertx.ext.web.Locale.create())
  }

  def create(language: String): Locale = {
    Locale.apply(io.vertx.ext.web.Locale.create(language))
  }

  def create(language: String, country: String): Locale = {
    Locale.apply(io.vertx.ext.web.Locale.create(language, country))
  }

  def create(language: String, country: String, variant: String): Locale = {
    Locale.apply(io.vertx.ext.web.Locale.create(language, country, variant))
  }

}
