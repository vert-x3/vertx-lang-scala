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

import scala.reflect.runtime.universe._
import io.vertx.core.dns.{SrvRecord => JSrvRecord}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represent a Service-Record (SRV) which was resolved for a domain.
  */

class SrvRecord(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * Returns the priority for this service record.
   */
  def priority (): Int = {
    asJava.asInstanceOf[JSrvRecord].priority().asInstanceOf[Int]
  }

  /**
   * Returns the weight of this service record.
   */
  def weight (): Int = {
    asJava.asInstanceOf[JSrvRecord].weight().asInstanceOf[Int]
  }

  /**
   * Returns the port the service is running on.
   */
  def port (): Int = {
    asJava.asInstanceOf[JSrvRecord].port().asInstanceOf[Int]
  }

  /**
   * Returns the name for the server being queried.
   */
  def name (): String = {
    asJava.asInstanceOf[JSrvRecord].name().asInstanceOf[String]
  }

  /**
   * Returns the protocol for the service being queried (i.e. "_tcp").
   */
  def protocol (): String = {
    asJava.asInstanceOf[JSrvRecord].protocol().asInstanceOf[String]
  }

  /**
   * Returns the service's name (i.e. "_http").
   */
  def service (): String = {
    asJava.asInstanceOf[JSrvRecord].service().asInstanceOf[String]
  }

  /**
   * Returns the name of the host for the service.
   */
  def target (): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JSrvRecord].target().asInstanceOf[String])
  }


}

object SrvRecord {
  def apply(asJava: JSrvRecord) = new SrvRecord(asJava)
  
}
