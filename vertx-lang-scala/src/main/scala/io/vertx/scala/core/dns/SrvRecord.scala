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

package io.vertx.scala.core.dns

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.core.dns.{SrvRecord => JSrvRecord}

/**
  * Represent a Service-Record (SRV) which was resolved for a domain.
  */
class SrvRecord(private val _asJava: Object, private val _useTypeTags:Boolean = false) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def priority():Int = {
    asJava.asInstanceOf[JSrvRecord].priority().asInstanceOf[Int]
  }

  def weight():Int = {
    asJava.asInstanceOf[JSrvRecord].weight().asInstanceOf[Int]
  }

  def port():Int = {
    asJava.asInstanceOf[JSrvRecord].port().asInstanceOf[Int]
  }

  def name():String = {
    asJava.asInstanceOf[JSrvRecord].name().asInstanceOf[String]
  }

  def protocol():String = {
    asJava.asInstanceOf[JSrvRecord].protocol().asInstanceOf[String]
  }

  def service():String = {
    asJava.asInstanceOf[JSrvRecord].service().asInstanceOf[String]
  }

  def target():scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JSrvRecord].target().asInstanceOf[String])
  }

//future methods
}

  object SrvRecord{
    def apply(asJava: Object, useTypeTags:Boolean = false) = new SrvRecord(asJava, useTypeTags)  
  //static methods
  }
