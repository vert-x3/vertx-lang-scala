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

package io.vertx.scala.ext.consul

import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.ext.consul.{BlockingQueryOptions => JBlockingQueryOptions}

/**
 * Options used to perform blocking query that used to wait for a potential change using long polling.
 */

class BlockingQueryOptions(private val _asJava: JBlockingQueryOptions) {
  def asJava = _asJava
  /**
   * Set index indicating that the client wishes to wait for any changes subsequent to that index.
   */
  def setIndex(value: Long) = {
    asJava.setIndex(value)
    this
  }

  def getIndex: Long = {
    asJava.getIndex().asInstanceOf[Long]
  }

  /**
   * Specifying a maximum duration for the blocking request. This is limited to 10 minutes.
   * If not set, the wait time defaults to 5 minutes. This value can be specified in the form of "10s" or "5m"
   * (i.e., 10 seconds or 5 minutes, respectively).
   */
  def setWait(value: String) = {
    asJava.setWait(value)
    this
  }

  def getWait: String = {
    asJava.getWait().asInstanceOf[String]
  }

}


object BlockingQueryOptions {
  
  def apply() = {
    new BlockingQueryOptions(new JBlockingQueryOptions(emptyObj()))
  }
  
  def apply(t: JBlockingQueryOptions) = {
    if (t != null) {
      new BlockingQueryOptions(t)
    } else {
      new BlockingQueryOptions(new JBlockingQueryOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): BlockingQueryOptions = {
    if (json != null) {
      new BlockingQueryOptions(new JBlockingQueryOptions(json))
    } else {
      new BlockingQueryOptions(new JBlockingQueryOptions(emptyObj()))
    }
  }
}

