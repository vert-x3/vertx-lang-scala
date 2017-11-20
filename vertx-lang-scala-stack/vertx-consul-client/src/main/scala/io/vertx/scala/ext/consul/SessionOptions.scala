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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.ext.consul.{SessionOptions => JSessionOptions}

/**
  * Options used to create session.
  */
class SessionOptions(private val _asJava: JSessionOptions) {

  def asJava = _asJava

  /**
    * Set the behavior when a session is invalidated. The release behavior is the default if none is specified.
    */
  def setBehavior(value: io.vertx.ext.consul.SessionBehavior) = {
    asJava.setBehavior(value)
    this
  }
  def getBehavior: io.vertx.ext.consul.SessionBehavior = {
    asJava.getBehavior()
  }

  /**
    * Set a list of associated health checks. It is highly recommended that,
    * if you override this list, you include the default "serfHealth"
    */
  def setChecks(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setChecks(value.asJava)
    this
  }
  def getChecks: scala.collection.mutable.Buffer[String] = {
    asJava.getChecks().asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * Set the lock-delay period.
    */
  def setLockDelay(value: Long) = {
    asJava.setLockDelay(value)
    this
  }
  def getLockDelay: Long = {
    asJava.getLockDelay().asInstanceOf[Long]
  }

  /**
    * Set the human-readable name for the Session
    */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }
  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
    * Set the node to which the session will be assigned
    */
  def setNode(value: String) = {
    asJava.setNode(value)
    this
  }
  def getNode: String = {
    asJava.getNode().asInstanceOf[String]
  }

  /**
    * Set the TTL interval. When TTL interval expires without being renewed, the session has expired
    * and an invalidation is triggered. If specified, it must be between 10s and 86400s currently.
    */
  def setTtl(value: Long) = {
    asJava.setTtl(value)
    this
  }
  def getTtl: Long = {
    asJava.getTtl().asInstanceOf[Long]
  }
}

object SessionOptions {
  
  def apply() = {
    new SessionOptions(new JSessionOptions(emptyObj()))
  }
  
  def apply(t: JSessionOptions) = {
    if (t != null) {
      new SessionOptions(t)
    } else {
      new SessionOptions(new JSessionOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): SessionOptions = {
    if (json != null) {
      new SessionOptions(new JSessionOptions(json))
    } else {
      new SessionOptions(new JSessionOptions(emptyObj()))
    }
  }
}
