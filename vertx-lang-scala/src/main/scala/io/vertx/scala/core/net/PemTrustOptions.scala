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
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}

/**
  * Certificate Authority options configuring certificates based on
  * <i>Privacy-enhanced Electronic Email</i> (PEM) files. The options is configured with a list of
  * validating certificates.
  * 
  * Validating certificates must contain X.509 certificates wrapped in a PEM block:
  *
  * <pre>
  * -----BEGIN CERTIFICATE-----
  * MIIDezCCAmOgAwIBAgIEVmLkwTANBgkqhkiG9w0BAQsFADBuMRAwDgYDVQQGEwdV
  * ...
  * z5+DuODBJUQst141Jmgq8bS543IU/5apcKQeGNxEyQ==
  * -----END CERTIFICATE-----
  * </pre>
  *
  * The certificates can either be loaded by Vert.x from the filesystem:
  * 
  * <pre>
  * HttpServerOptions options = new HttpServerOptions();
  * options.setPemTrustOptions(new PemTrustOptions().addCertPath("/cert.pem"));
  * </pre>
  *
  * Or directly provided as a buffer:
  * 
  *
  * <pre>
  * Buffer cert = vertx.fileSystem().readFileSync("/cert.pem");
  * HttpServerOptions options = new HttpServerOptions();
  * options.setPemTrustOptions(new PemTrustOptions().addCertValue(cert));
  * </pre>
  */

class PemTrustOptions(val asJava: JPemTrustOptions) {

  /**
    * Add a certificate path
    */
  def addCertPath(value:String) = {
    asJava.addCertPath(value)
    this
  }
  def getCertPaths = {
    asJava.getCertPaths()
  }

  /**
    * Add a certificate value
    */
  def addCertValue(value:io.vertx.core.buffer.Buffer) = {
    asJava.addCertValue(value)
    this
  }
  def getCertValues = {
    asJava.getCertValues()
  }
}

object PemTrustOptions {
  
  def apply() = {
    new PemTrustOptions(new JPemTrustOptions(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: JPemTrustOptions) = {
    if(t != null)
      new PemTrustOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):PemTrustOptions = {
    if(json != null)
      new PemTrustOptions(new JPemTrustOptions(json))
    else
      null
  }
}
