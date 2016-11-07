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

package io.vertx.scala.ext.mail

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.mail.{MailConfig => JMailConfig}

/**
  * represents the configuration of a mail service with mail server hostname,
  * port, security options, login options and login/password
  */

class MailConfig(val asJava: JMailConfig) {

  /**
    * set if sending allows rcpt errors
    * 
    * if true, the mail will be sent to the recipients that the server accepted, if any
    * 
    */
  def setAllowRcptErrors(value: Boolean) = {
    asJava.setAllowRcptErrors(value)
    this
  }
  def isAllowRcptErrors = {
    asJava.isAllowRcptErrors()
  }

  /**
    * set string of allowed auth methods.
    * if set only these methods will be used
    * if the server supports them. If null or empty all supported methods may be
    * used
    */
  def setAuthMethods(value: String) = {
    asJava.setAuthMethods(value)
    this
  }
  def getAuthMethods = {
    asJava.getAuthMethods()
  }

  /**
    * set if ESMTP should be tried as first command (EHLO)
    * 
    * rfc 1869 states that clients should always attempt EHLO as first command to determine if ESMTP
    * is supported, if this returns an error code, HELO is tried to use old SMTP.
    * If there is a server that does not support EHLO and does not give an error code back, the connection
    * should be closed and retried with HELO. We do not do that and rather support turning off ESMTP with a
    * setting. The odds of this actually happening are very small since the client will not connect to arbitrary
    * smtp hosts on the internet. Since the client knows that is connects to a host that doesn't support ESMTP/EHLO
    * in that way, the property has to be set to false.
    * 
    */
  def setDisableEsmtp(value: Boolean) = {
    asJava.setDisableEsmtp(value)
    this
  }
  def isDisableEsmtp = {
    asJava.isDisableEsmtp()
  }

  /**
    * Set the hostname of the smtp server.
    */
  def setHostname(value: String) = {
    asJava.setHostname(value)
    this
  }
  def getHostname = {
    asJava.getHostname()
  }

  /**
    * set if connection pool is enabled
    * default is true
    * 
    * if the connection pooling is disabled, the max number of sockets is enforced nevertheless
    * 
    */
  def setKeepAlive(value: Boolean) = {
    asJava.setKeepAlive(value)
    this
  }
  def isKeepAlive = {
    asJava.isKeepAlive()
  }

  /**
    * get the key store filename to be used when opening SMTP connections
    * 
    * if not set, an options object will be created based on other settings (ssl
    * and trustAll)
    */
  def setKeyStore(value: String) = {
    asJava.setKeyStore(value)
    this
  }
  def getKeyStore = {
    asJava.getKeyStore()
  }

  /**
    * get the key store password to be used when opening SMTP connections
    */
  def setKeyStorePassword(value: String) = {
    asJava.setKeyStorePassword(value)
    this
  }
  def getKeyStorePassword = {
    asJava.getKeyStorePassword()
  }

  /**
    * Set the login mode for the connection.
    * 
    * Either DISABLED, OPTIONAL or REQUIRED
    */
  def setLogin(value: io.vertx.ext.mail.LoginOption) = {
    asJava.setLogin(value)
    this
  }
  def getLogin = {
    asJava.getLogin()
  }

  /**
    * set the max allowed number of open connections to the mail server
    * if not set the default is 10
    */
  def setMaxPoolSize(value: Int) = {
    asJava.setMaxPoolSize(value)
    this
  }
  def getMaxPoolSize = {
    asJava.getMaxPoolSize()
  }

  /**
    * set the hostname to be used for HELO/EHLO and the Message-ID
    */
  def setOwnHostname(value: String) = {
    asJava.setOwnHostname(value)
    this
  }
  def getOwnHostname = {
    asJava.getOwnHostname()
  }

  /**
    * Set the password for the login.
    */
  def setPassword(value: String) = {
    asJava.setPassword(value)
    this
  }
  def getPassword = {
    asJava.getPassword()
  }

  /**
    * Set the port of the smtp server.
    */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort = {
    asJava.getPort()
  }

  /**
    * Set the sslOnConnect mode for the connection.
    */
  def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }
  def isSsl = {
    asJava.isSsl()
  }

  /**
    * Set the tls security mode for the connection.
    * 
    * Either NONE, OPTIONAL or REQUIRED
    */
  def setStarttls(value: io.vertx.ext.mail.StartTLSOptions) = {
    asJava.setStarttls(value)
    this
  }
  def getStarttls = {
    asJava.getStarttls()
  }

  /**
    * set whether to trust all certificates on ssl connect the option is also
    * applied to STARTTLS operation
    */
  def setTrustAll(value: Boolean) = {
    asJava.setTrustAll(value)
    this
  }
  def isTrustAll = {
    asJava.isTrustAll()
  }

  /**
    * Set the username for the login.
    */
  def setUsername(value: String) = {
    asJava.setUsername(value)
    this
  }
  def getUsername = {
    asJava.getUsername()
  }
}

object MailConfig {
  
  def apply() = {
    new MailConfig(new JMailConfig(emptyObj()))
  }
  
  def apply(t: JMailConfig) = {
    if(t != null)
      new MailConfig(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):MailConfig = {
    if(json != null)
      new MailConfig(new JMailConfig(json))
    else
      null
  }
}
