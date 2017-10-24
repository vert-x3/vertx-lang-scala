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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.net.{SelfSignedCertificate => JSelfSignedCertificate}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}

/**
  * A self-signed certificate helper for testing and development purposes.
  * 
  * While it helps for testing and development, it should never ever be used in production settings.
  */
class SelfSignedCertificate(private val _asJava: Object) {

  def asJava = _asJava


  /**
    * Provides the [[io.vertx.scala.core.net.KeyCertOptions]] RSA private key file in PEM format corresponding to the [[io.vertx.scala.core.net.SelfSignedCertificate#privateKeyPath]]
    * @return a PemKeyCertOptions based on the generated certificate.see <a href="../../../../../../../cheatsheet/PemKeyCertOptions.html">PemKeyCertOptions</a>
    */
  def keyCertOptions(): PemKeyCertOptions = {
    PemKeyCertOptions(asJava.asInstanceOf[JSelfSignedCertificate].keyCertOptions())
  }

  /**
    * Provides the [[io.vertx.scala.core.net.TrustOptions]] X.509 certificate file in PEM format corresponding to the [[io.vertx.scala.core.net.SelfSignedCertificate#certificatePath]]
    * @return a PemTrustOptions based on the generated certificate.see <a href="../../../../../../../cheatsheet/PemTrustOptions.html">PemTrustOptions</a>
    */
  def trustOptions(): PemTrustOptions = {
    PemTrustOptions(asJava.asInstanceOf[JSelfSignedCertificate].trustOptions())
  }

  /**
    * Filesystem path to the RSA private key file in PEM format
    * @return the absolute path to the private key.
    */
  def privateKeyPath(): String = {
    asJava.asInstanceOf[JSelfSignedCertificate].privateKeyPath().asInstanceOf[String]
  }

  /**
    * Filesystem path to the X.509 certificate file in PEM format .
    * @return the absolute path to the certificate.
    */
  def certificatePath(): String = {
    asJava.asInstanceOf[JSelfSignedCertificate].certificatePath().asInstanceOf[String]
  }

  /**
    * Delete the private key and certificate files.
    */
  def delete(): Unit = {
    asJava.asInstanceOf[JSelfSignedCertificate].delete()
  }

}

object SelfSignedCertificate {
  def apply(asJava: JSelfSignedCertificate) = new SelfSignedCertificate(asJava)  
  /**
    * Create a new `SelfSignedCertificate` instance.
    * @return a new instance.
    */
  def create(): SelfSignedCertificate = {
    SelfSignedCertificate(JSelfSignedCertificate.create())
  }

  /**
    * Create a new `SelfSignedCertificate` instance with a fully-qualified domain name,
    * @param fqdn a fully qualified domain name.
    * @return a new instance.
    */
  def create(fqdn: String): SelfSignedCertificate = {
    SelfSignedCertificate(JSelfSignedCertificate.create(fqdn.asInstanceOf[java.lang.String]))
  }

}
