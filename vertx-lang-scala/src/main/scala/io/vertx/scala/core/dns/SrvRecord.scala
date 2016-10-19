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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._

/**
  * Represent a Service-Record (SRV) which was resolved for a domain.
  */
class SrvRecord(private val _asJava: io.vertx.core.dns.SrvRecord) {

  def asJava: io.vertx.core.dns.SrvRecord = _asJava

  /**
    * Returns the priority for this service record.
    */
  def priority(): Int = {
    _asJava.priority()
  }

  /**
    * Returns the weight of this service record.
    */
  def weight(): Int = {
    _asJava.weight()
  }

  /**
    * Returns the port the service is running on.
    */
  def port(): Int = {
    _asJava.port()
  }

  /**
    * Returns the name for the server being queried.
    */
  def name(): String = {
    _asJava.name()
  }

  /**
    * Returns the protocol for the service being queried (i.e. "_tcp").
    */
  def protocol(): String = {
    _asJava.protocol()
  }

  /**
    * Returns the service's name (i.e. "_http").
    */
  def service(): String = {
    _asJava.service()
  }

  /**
    * Returns the name of the host for the service.
    */
  def target(): scala.Option[String] = {
        scala.Option(_asJava.target())
  }

}

object SrvRecord {

  def apply(_asJava: io.vertx.core.dns.SrvRecord): io.vertx.scala.core.dns.SrvRecord =
    new io.vertx.scala.core.dns.SrvRecord(_asJava)

}
