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

package io.vertx.scala.core.net

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._
import io.vertx.lang.scala.json.Json._
import io.vertx.core.net.{JksOptions => JJksOptions}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}

/**
  * Key or trust store options configuring private key and/or certificates based on Java Keystore files.
  * 
  * When used as a key store, it should point to a store containing a private key and its certificate.
  * When used as a trust store, it should point to a store containing a list of trusted certificates.
  * 
  * The store can either be loaded by Vert.x from the filesystem:
  * 
  * <pre>
  * HttpServerOptions options = HttpServerOptions.httpServerOptions();
  * options.setKeyStore(new JKSOptions().setPath("/mykeystore.jks").setPassword("foo"));
  * </pre>
  *
  * Or directly provided as a buffer:
  * 
  *
  * <pre>
  * Buffer store = vertx.fileSystem().readFileSync("/mykeystore.jks");
  * options.setKeyStore(new JKSOptions().setValue(store).setPassword("foo"));
  * </pre>
  */

class JksOptions(val asJava: JJksOptions) {

  /**
    * Set the password for the key store
    */
  def setPassword(value: String) = {
    asJava.setPassword(value)
    this
  }
  def getPassword = {
    asJava.getPassword()
  }

  /**
    * Set the path to the key store
    */
  def setPath(value: String) = {
    asJava.setPath(value)
    this
  }
  def getPath = {
    asJava.getPath()
  }

  /**
    * Set the key store as a buffer
    */
  def setValue(value: JBuffer) = {
    asJava.setValue(value)
    this
  }
  def getValue = {
    asJava.getValue()
  }
}

object JksOptions {
  
  def apply() = {
    new JksOptions(new JJksOptions(emptyObj()))
  }
  
  def apply(t: JJksOptions) = {
    if(t != null)
      new JksOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):JksOptions = {
    if(json != null)
      new JksOptions(new JJksOptions(json))
    else
      null
  }
}
