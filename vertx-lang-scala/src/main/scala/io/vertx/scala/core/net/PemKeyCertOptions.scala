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

import io.vertx.core.buffer.Buffer
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import scala.collection.JavaConverters._

/**
 * Key store options configuring a list of private key and its certificate based on
 * <i>Privacy-enhanced Electronic Email</i> (PEM) files.
 * 
 *
 * A key file must contain a <b>non encrypted</b> private key in <b>PKCS8</b> format wrapped in a PEM
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
 * Or contain a <b>non encrypted</b> private key in <b>PKCS1</b> format wrapped in a PEM
 * block, for example:
 * 
 *
 * <pre>
 * -----BEGIN RSA PRIVATE KEY-----
 * MIIEowIBAAKCAQEAlO4gbHeFb/fmbUF/tOJfNPJumJUEqgzAzx8MBXv9Acyw9IRa
 * ...
 * zJ14Yd+t2fsLYVs2H0gxaA4DW6neCzgY3eKpSU0EBHUCFSXp/1+/
 * -----END RSA PRIVATE KEY-----
 * </pre>
 *
 * A certificate file must contain an X.509 certificate wrapped in a PEM block, for example:
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
 * Keys and certificates can either be loaded by Vert.x from the filesystem:
 * 
 * <pre>
 * HttpServerOptions options = new HttpServerOptions();
 * options.setPemKeyCertOptions(new PemKeyCertOptions().setKeyPath("/mykey.pem").setCertPath("/mycert.pem"));
 * </pre>
 *
 * Or directly provided as a buffer:
 *
 * <pre>
 * Buffer key = vertx.fileSystem().readFileBlocking("/mykey.pem");
 * Buffer cert = vertx.fileSystem().readFileBlocking("/mycert.pem");
 * options.setPemKeyCertOptions(new PemKeyCertOptions().setKeyValue(key).setCertValue(cert));
 * </pre>
 *
 * Several key/certificate pairs can be used:
 * 
 * <pre>
 * HttpServerOptions options = new HttpServerOptions();
 * options.setPemKeyCertOptions(new PemKeyCertOptions()
 *    .addKeyPath("/mykey1.pem").addCertPath("/mycert1.pem")
 *    .addKeyPath("/mykey2.pem").addCertPath("/mycert2.pem"));
 * </pre>
 */

class PemKeyCertOptions(private val _asJava: JPemKeyCertOptions) {
  def asJava = _asJava
  /**
   * Set the path of the first certificate, replacing the previous certificates paths
   */
  def setCertPath(value: String) = {
    asJava.setCertPath(value)
    this
  }

  /**
   * Set all the paths to the certificates files
   */
  def setCertPaths(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setCertPaths(value.asJava)
    this
  }

  def getCertPaths: scala.collection.mutable.Buffer[String] = {
    asJava.getCertPaths().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Set the first certificate as a buffer, replacing the previous certificates buffers
   */
  def setCertValue(value: io.vertx.core.buffer.Buffer) = {
    asJava.setCertValue(value)
    this
  }

  /**
   * Set all the certificates as a list of buffer
   */
  def setCertValues(value: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer]) = {
    asJava.setCertValues(value.asJava)
    this
  }

  def getCertValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
    asJava.getCertValues().asScala.map(x => x)
  }

  /**
   * Set the path of the first key file, replacing the keys paths
   */
  def setKeyPath(value: String) = {
    asJava.setKeyPath(value)
    this
  }

  /**
   * Set all the paths to the keys files
   */
  def setKeyPaths(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setKeyPaths(value.asJava)
    this
  }

  def getKeyPaths: scala.collection.mutable.Buffer[String] = {
    asJava.getKeyPaths().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Set the first key a a buffer, replacing the previous keys buffers
   */
  def setKeyValue(value: io.vertx.core.buffer.Buffer) = {
    asJava.setKeyValue(value)
    this
  }

  /**
   * Set all the keys as a list of buffer
   */
  def setKeyValues(value: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer]) = {
    asJava.setKeyValues(value.asJava)
    this
  }

  def getKeyValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
    asJava.getKeyValues().asScala.map(x => x)
  }

}


object PemKeyCertOptions {

  def apply() = {
    new PemKeyCertOptions(new JPemKeyCertOptions(emptyObj()))
  }

  def apply(t: JPemKeyCertOptions) = {
    if (t != null) {
      new PemKeyCertOptions(t)
    } else {
      new PemKeyCertOptions(new JPemKeyCertOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): PemKeyCertOptions = {
    if (json != null) {
      new PemKeyCertOptions(new JPemKeyCertOptions(json))
    } else {
      new PemKeyCertOptions(new JPemKeyCertOptions(emptyObj()))
    }
  }
}

