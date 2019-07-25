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

package io.vertx.scala.pgclient.data

import io.vertx.pgclient.data.{Interval => JInterval}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Postgres Interval is date and time based
 * such as 120 years 3 months 332 days 20 hours 20 minutes 20.999999 seconds
 */

class Interval(private val _asJava: JInterval) {
  def asJava = _asJava
  def setDays(value: Int) = {
    asJava.setDays(value)
    this
  }

  def getDays: Int = {
    asJava.getDays().asInstanceOf[Int]
  }

  def setHours(value: Int) = {
    asJava.setHours(value)
    this
  }

  def getHours: Int = {
    asJava.getHours().asInstanceOf[Int]
  }

  def setMicroseconds(value: Int) = {
    asJava.setMicroseconds(value)
    this
  }

  def getMicroseconds: Int = {
    asJava.getMicroseconds().asInstanceOf[Int]
  }

  def setMinutes(value: Int) = {
    asJava.setMinutes(value)
    this
  }

  def getMinutes: Int = {
    asJava.getMinutes().asInstanceOf[Int]
  }

  def setMonths(value: Int) = {
    asJava.setMonths(value)
    this
  }

  def getMonths: Int = {
    asJava.getMonths().asInstanceOf[Int]
  }

  def setSeconds(value: Int) = {
    asJava.setSeconds(value)
    this
  }

  def getSeconds: Int = {
    asJava.getSeconds().asInstanceOf[Int]
  }

  def setYears(value: Int) = {
    asJava.setYears(value)
    this
  }

  def getYears: Int = {
    asJava.getYears().asInstanceOf[Int]
  }

}


object Interval {
  
  def apply() = {
    new Interval(new JInterval(emptyObj()))
  }
  
  def apply(t: JInterval) = {
    if (t != null) {
      new Interval(t)
    } else {
      new Interval(new JInterval(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): Interval = {
    if (json != null) {
      new Interval(new JInterval(json))
    } else {
      new Interval(new JInterval(emptyObj()))
    }
  }
}

