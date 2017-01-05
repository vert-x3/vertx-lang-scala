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

/**
  */
class Locale(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def language():String = {
    asJava.asInstanceOf[JLocale].language().asInstanceOf[String]
  }

  def country():String = {
    asJava.asInstanceOf[JLocale].country().asInstanceOf[String]
  }

  def variant():String = {
    asJava.asInstanceOf[JLocale].variant().asInstanceOf[String]
  }

//future methods
}

  object Locale{
    def apply(asJava: JLocale) = new Locale(asJava)  
  //static methods
    def create():Locale = {
      Locale(JLocale.create())
    }

    def create(language: String):Locale = {
      Locale(JLocale.create(language.asInstanceOf[java.lang.String]))
    }

    def create(language: String,country: String):Locale = {
      Locale(JLocale.create(language.asInstanceOf[java.lang.String],country.asInstanceOf[java.lang.String]))
    }

    def create(language: String,country: String,variant: String):Locale = {
      Locale(JLocale.create(language.asInstanceOf[java.lang.String],country.asInstanceOf[java.lang.String],variant.asInstanceOf[java.lang.String]))
    }

  }
