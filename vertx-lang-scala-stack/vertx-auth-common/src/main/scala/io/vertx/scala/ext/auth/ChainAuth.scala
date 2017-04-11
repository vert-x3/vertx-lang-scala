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

package io.vertx.scala.ext.auth

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.ext.auth.{ChainAuth => JChainAuth}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Chain several auth providers as if they were one. This is useful for cases where one want to authenticate across
  * several providers, for example, database and fallback to passwd file.
  */
class ChainAuth(private val _asJava: Object)
    extends AuthProvider(_asJava)  {


  /**
    * Appends a auth provider to the chain.
    * @param other auth provider
    * @return self
    */
  def append(other: AuthProvider): ChainAuth = {
    asJava.asInstanceOf[JChainAuth].append(other.asJava.asInstanceOf[JAuthProvider])
    this
  }

  /**
    * Removes a provider from the chain.
    * @param other provider to remove
    * @return true if provider was removed, false if non existent in the chain.
    */
  def remove(other: AuthProvider): Boolean = {
    asJava.asInstanceOf[JChainAuth].remove(other.asJava.asInstanceOf[JAuthProvider]).asInstanceOf[Boolean]
  }

  /**
    * Clears the chain.
    */
  def clear(): Unit = {
    asJava.asInstanceOf[JChainAuth].clear()
  }

}

object ChainAuth {
  def apply(asJava: JChainAuth) = new ChainAuth(asJava)  
  /**
    * Create a Chainable Auth Provider auth provider
    * @return the auth provider
    */
  def create(): ChainAuth = {
    ChainAuth(JChainAuth.create())
  }

}
