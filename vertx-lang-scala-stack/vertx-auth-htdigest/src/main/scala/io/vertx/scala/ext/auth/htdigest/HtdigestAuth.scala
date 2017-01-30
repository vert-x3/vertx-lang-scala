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

package io.vertx.scala.ext.auth.htdigest

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.ext.auth.AuthProvider
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{AuthProvider => JAuthProvider}
import io.vertx.ext.auth.htdigest.{HtdigestAuth => JHtdigestAuth}
import io.vertx.ext.auth.{User => JUser}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * An extension of AuthProvider which is using .htdigest file as store
  */
class HtdigestAuth(private val _asJava: Object)
    extends AuthProvider(_asJava)  {


  /**
    * Return the currently used realm
    * @return the realm
    */
  def realm(): String = {
    asJava.asInstanceOf[JHtdigestAuth].realm().asInstanceOf[String]
  }

}

object HtdigestAuth{
  def apply(asJava: JHtdigestAuth) = new HtdigestAuth(asJava)  
  /**
    * Creates an instance of HtdigestAuth.
    * @return the created instance of HtdigestAuths
    */
  def create(vertx: Vertx): HtdigestAuth = {
    HtdigestAuth(JHtdigestAuth.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Creates an instance of HtdigestAuth by using the given htfile file.
    * @param htfile the existing htfile.
    * @return the created instance of HtdigestAuths
    */
  def create(vertx: Vertx,htfile: String): HtdigestAuth = {
    HtdigestAuth(JHtdigestAuth.create(vertx.asJava.asInstanceOf[JVertx],htfile.asInstanceOf[java.lang.String]))
  }

}
