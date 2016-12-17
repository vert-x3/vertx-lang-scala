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


/**
  * Represent a Service-Record (SRV) which was resolved for a domain.
  */
class SrvRecord(private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JSrvRecord]
//methods returning a future
//cached methods
//fluent methods
//basic methods
  def priority():Int = {
    asJava.priority( )
  }

  def weight():Int = {
    asJava.weight( )
  }

  def port():Int = {
    asJava.port( )
  }

  def name():String = {
    asJava.name( )
  }

  def protocol():String = {
    asJava.protocol( )
  }

  def service():String = {
    asJava.service( )
  }

  def target():String = {
    asJava.target( )
  }

}

object SrvRecord{
//in object!
//static methods
}
