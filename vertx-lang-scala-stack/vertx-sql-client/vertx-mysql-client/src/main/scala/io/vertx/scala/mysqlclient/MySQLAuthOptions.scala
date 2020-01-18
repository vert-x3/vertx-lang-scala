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

package io.vertx.scala.mysqlclient

import io.vertx.core.buffer.Buffer
import io.vertx.mysqlclient.{MySQLAuthOptions => JMySQLAuthOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Authentication options for MySQL authentication which can be used for CHANGE_USER command.

 */

class MySQLAuthOptions(private val _asJava: JMySQLAuthOptions) {
  def asJava = _asJava
  /**
   * Set the charset for the connection.
   */
  def setCharset(value: String) = {
    asJava.setCharset(value)
    this
  }

  def getCharset: String = {
    asJava.getCharset().asInstanceOf[String]
  }

  /**
   * Set the collation for the connection.
   */
  def setCollation(value: String) = {
    asJava.setCollation(value)
    this
  }

  def getCollation: String = {
    asJava.getCollation().asInstanceOf[String]
  }

  /**
   * Specify the default database for the re-authentication.
   */
  def setDatabase(value: String) = {
    asJava.setDatabase(value)
    this
  }

  def getDatabase: String = {
    asJava.getDatabase().asInstanceOf[String]
  }

  /**
   * Specify the user password to be used for the authentication.
   */
  def setPassword(value: String) = {
    asJava.setPassword(value)
    this
  }

  def getPassword: String = {
    asJava.getPassword().asInstanceOf[String]
  }

  /**
   * Set connection attributes which will be sent to server at the re-authentication.
   */
  def setProperties(value: Map[String, String]) = {
    asJava.setProperties(value.asJava)
    this
  }

  def getProperties: scala.collection.mutable.Map[String, String] = {
    collection.mutable.Map(asJava.getProperties().asScala.mapValues(x => x.asInstanceOf[String]).toSeq: _*)
  }

  /**
   * Set the path of server RSA public key which is mostly used for encrypting password under insecure connections when performing authentication.
   */
  def setServerRsaPublicKeyPath(value: String) = {
    asJava.setServerRsaPublicKeyPath(value)
    this
  }

  def getServerRsaPublicKeyPath: String = {
    asJava.getServerRsaPublicKeyPath().asInstanceOf[String]
  }

  /**
   * Set the value of server RSA public key which is mostly used for encrypting password under insecure connections when performing authentication.
   */
  def setServerRsaPublicKeyValue(value: io.vertx.core.buffer.Buffer) = {
    asJava.setServerRsaPublicKeyValue(value)
    this
  }

  def getServerRsaPublicKeyValue: io.vertx.core.buffer.Buffer = {
    asJava.getServerRsaPublicKeyValue()
  }

  /**
   * Specify the user account to be used for the authentication.
   */
  def setUser(value: String) = {
    asJava.setUser(value)
    this
  }

  def getUser: String = {
    asJava.getUser().asInstanceOf[String]
  }

}


object MySQLAuthOptions {

  def apply() = {
    new MySQLAuthOptions(new JMySQLAuthOptions(emptyObj()))
  }

  def apply(t: JMySQLAuthOptions) = {
    if (t != null) {
      new MySQLAuthOptions(t)
    } else {
      new MySQLAuthOptions(new JMySQLAuthOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): MySQLAuthOptions = {
    if (json != null) {
      new MySQLAuthOptions(new JMySQLAuthOptions(json))
    } else {
      new MySQLAuthOptions(new JMySQLAuthOptions(emptyObj()))
    }
  }
}

