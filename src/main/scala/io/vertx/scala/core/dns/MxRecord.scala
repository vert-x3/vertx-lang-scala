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
  * Represent a Mail-Exchange-Record (MX) which was resolved for a domain.
  */
class MxRecord(private val _asJava: io.vertx.core.dns.MxRecord) {

  def asJava: io.vertx.core.dns.MxRecord = _asJava

  /**
    * The priority of the MX record.
    */
  def priority(): Int = {
    _asJava.priority()
  }

  /**
    * The name of the MX record
    */
  def name(): String = {
    _asJava.name()
  }

}

object MxRecord {

  def apply(_asJava: io.vertx.core.dns.MxRecord): io.vertx.scala.core.dns.MxRecord =
    new io.vertx.scala.core.dns.MxRecord(_asJava)

}
