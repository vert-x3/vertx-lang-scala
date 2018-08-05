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

import scala.reflect.runtime.universe._
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * The address of a socket, an inet socket address or a domain socket address.
  * <p/>
  * Use [[io.vertx.scala.core.net.SocketAddress#inetSocketAddress]] to create an inet socket address and [[io.vertx.scala.core.net.SocketAddress#domainSocketAddress]]
  * to create a domain socket address
  */

class SocketAddress(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * @return the address host or `null` for a domain socket
   */
  def host (): String = {
    asJava.asInstanceOf[JSocketAddress].host().asInstanceOf[String]
  }

  /**
   * @return the address port or `-1` for a domain socket
   */
  def port (): Int = {
    asJava.asInstanceOf[JSocketAddress].port().asInstanceOf[Int]
  }

  /**
   * @return the address path or `null` for a inet socket
   */
  def path (): String = {
    asJava.asInstanceOf[JSocketAddress].path().asInstanceOf[String]
  }


}

object SocketAddress {
  def apply(asJava: JSocketAddress) = new SocketAddress(asJava)
  
  /**
   * Create a inet socket address, `host` must be non `null` and `port` must be between `0`
   * and `65536`.   * @param port the address port
   * @param host the address host
   * @return the created socket address
   */
  def inetSocketAddress(port: Int,host: String): SocketAddress = {
    SocketAddress(JSocketAddress.inetSocketAddress(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String]))
  }

  /**
   * Create a domain socket address.   * @param path the address path
   * @return the created socket address
   */
  def domainSocketAddress(path: String): SocketAddress = {
    SocketAddress(JSocketAddress.domainSocketAddress(path.asInstanceOf[java.lang.String]))
  }

}
