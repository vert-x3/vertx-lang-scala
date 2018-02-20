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

package io.vertx.scala.proton

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.proton.{ProtonLinkOptions => JProtonLinkOptions}

/**
  * Options for configuring link attributes.
  */
class ProtonLinkOptions(private val _asJava: JProtonLinkOptions) {

  def asJava = _asJava
  def setLinkName(value: String) = {
    asJava.setLinkName(value)
    this
  }
  def getLinkName: String = {
    asJava.getLinkName().asInstanceOf[String]
  }
}

object ProtonLinkOptions {
  
  def apply() = {
    new ProtonLinkOptions(new JProtonLinkOptions(emptyObj()))
  }
  
  def apply(t: JProtonLinkOptions) = {
    if (t != null) {
      new ProtonLinkOptions(t)
    } else {
      new ProtonLinkOptions(new JProtonLinkOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): ProtonLinkOptions = {
    if (json != null) {
      new ProtonLinkOptions(new JProtonLinkOptions(json))
    } else {
      new ProtonLinkOptions(new JProtonLinkOptions(emptyObj()))
    }
  }
}
