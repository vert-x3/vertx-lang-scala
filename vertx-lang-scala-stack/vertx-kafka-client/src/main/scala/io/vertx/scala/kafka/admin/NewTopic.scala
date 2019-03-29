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

package io.vertx.scala.kafka.admin

import io.vertx.core.json.JsonObject
import io.vertx.kafka.admin.{NewTopic => JNewTopic}
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * A new topic to be created

 */

class NewTopic(private val _asJava: JNewTopic) {
  def asJava = _asJava
  /**
   * Set the configuration for the new topic or null if no configs ever specified
   */
  def setConfig(value: Map[String, String]) = {
    asJava.setConfig(value.asJava)
    this
  }

  def getConfig: scala.collection.mutable.Map[String, String] = {
    collection.mutable.Map(asJava.getConfig().asScala.mapValues(x => x.asInstanceOf[String]).toSeq: _*)
  }

  /**
   * Set the name of the topic to be created
   */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }

  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
   * Set the number of partitions for the new topic or -1 if a replica assignment has been specified
   */
  def setNumPartitions(value: Int) = {
    asJava.setNumPartitions(value)
    this
  }

  def getNumPartitions: Int = {
    asJava.getNumPartitions().asInstanceOf[Int]
  }

  /**
   * Set the replication factor for the new topic or -1 if a replica assignment has been specified
   */
  def setReplicationFactor(value: Short) = {
    asJava.setReplicationFactor(value)
    this
  }

  def getReplicationFactor: Short = {
    asJava.getReplicationFactor().asInstanceOf[Short]
  }

}


object NewTopic {
  
  def apply() = {
    new NewTopic(new JNewTopic(emptyObj()))
  }
  
  def apply(t: JNewTopic) = {
    if (t != null) {
      new NewTopic(t)
    } else {
      new NewTopic(new JNewTopic(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): NewTopic = {
    if (json != null) {
      new NewTopic(new JNewTopic(json))
    } else {
      new NewTopic(new JNewTopic(emptyObj()))
    }
  }
}

