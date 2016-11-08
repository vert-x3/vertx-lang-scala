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
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer

/**
  * Key store options configuring a private key and its certificate based on
  * <i>Privacy-enhanced Electronic Email</i> (PEM) files.
  * 
  *
  * The key file must contain a <b>non encrypted</b> private key in <b>PKCS8</b> format wrapped in a PEM
  * block, for example:
  * 
  *
  * <pre>
  * -----BEGIN PRIVATE KEY-----
  * MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDV6zPk5WqLwS0a
  * ...
  * K5xBhtm1AhdnZjx5KfW3BecE
  * -----END PRIVATE KEY-----
  * </pre>
  *
  * The certificate file must contain an X.509 certificate wrapped in a PEM block, for example:
  * 
  *
  * <pre>
  * -----BEGIN CERTIFICATE-----
  * MIIDezCCAmOgAwIBAgIEZOI/3TANBgkqhkiG9w0BAQsFADBuMRAwDgYDVQQGEwdV
  * ...
  * +tmLSvYS39O2nqIzzAUfztkYnUlZmB0l/mKkVqbGJA==
  * -----END CERTIFICATE-----
  * </pre>
  *
  * The key and certificate can either be loaded by Vert.x from the filesystem:
  * 
  * <pre>
  * HttpServerOptions options = new HttpServerOptions();
  * options.setPemKeyCertOptions(new PemKeyCertOptions().setKeyPath("/mykey.pem").setCertPath("/mycert.pem"));
  * </pre>
  *
  * Or directly provided as a buffer:
  *
  * <pre>
  * Buffer key = vertx.fileSystem().readFileSync("/mykey.pem");
  * Buffer cert = vertx.fileSystem().readFileSync("/mycert.pem");
  * options.setPemKeyCertOptions(new PemKeyCertOptions().setKeyValue(key).setCertValue(cert));
  * </pre>
  */

class PemKeyCertOptions(val asJava: JPemKeyCertOptions) {

  /**
    * Set the path to the certificate
    */
  def setCertPath(value: String) = {
    asJava.setCertPath(value)
    this
  }
  def getCertPath = {
    asJava.getCertPath()
  }

  /**
    * Set the certificate as a buffer
    */
  def setCertValue(value: Buffer) = {
    asJava.setCertValue(value.asJava)
    this
  }
  def getCertValue = {
    asJava.getCertValue()
  }

  /**
    * Set the path to the key file
    */
  def setKeyPath(value: String) = {
    asJava.setKeyPath(value)
    this
  }
  def getKeyPath = {
    asJava.getKeyPath()
  }

  /**
    * Set the key a a buffer
    */
  def setKeyValue(value: Buffer) = {
    asJava.setKeyValue(value.asJava)
    this
  }
  def getKeyValue = {
    asJava.getKeyValue()
  }
}

object PemKeyCertOptions {
  
  def apply() = {
    new PemKeyCertOptions(new JPemKeyCertOptions(emptyObj()))
  }
  
  def apply(t: JPemKeyCertOptions) = {
    if(t != null)
      new PemKeyCertOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):PemKeyCertOptions = {
    if(json != null)
      new PemKeyCertOptions(new JPemKeyCertOptions(json))
    else
      null
  }
}
