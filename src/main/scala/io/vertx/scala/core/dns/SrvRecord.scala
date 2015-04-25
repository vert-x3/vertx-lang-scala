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

package io.vertx.scala.core.dns;


class SrvRecord(private val _asJava: io.vertx.core.dns.SrvRecord) {

  def asJava: java.lang.Object = _asJava

  def priority(): Int = {
    _asJava.priority()
  }

  def weight(): Int = {
    _asJava.weight()
  }

  def port(): Int = {
    _asJava.port()
  }

  def name(): String = {
    _asJava.name()
  }

  def protocol(): String = {
    _asJava.protocol()
  }

  def service(): String = {
    _asJava.service()
  }

  def target(): String = {
    _asJava.target()
  }

}

object SrvRecord {

  def apply(_asJava: io.vertx.core.dns.SrvRecord): io.vertx.scala.core.dns.SrvRecord =
    new io.vertx.scala.core.dns.SrvRecord(_asJava)
}
