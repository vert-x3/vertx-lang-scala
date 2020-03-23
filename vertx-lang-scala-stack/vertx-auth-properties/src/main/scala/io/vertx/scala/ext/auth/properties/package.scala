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

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core
import io.vertx.ext.auth.authorization
import io.vertx.ext.auth.properties.{PropertyFileAuthorization => JPropertyFileAuthorization}
import io.vertx.ext.auth.authorization.{AuthorizationProvider => JAuthorizationProvider}
import io.vertx.core.{Vertx => JVertx}
package object properties{


  object PropertyFileAuthentication {
    /**
     * Like create from [[io.vertx.ext.auth.properties.PropertyFileAuthentication]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(vertx: io.vertx.core.Vertx, path: java.lang.String) = {
      io.vertx.ext.auth.properties.PropertyFileAuthentication.create(vertx, path)
}  }


  object PropertyFileAuthorization {
    /**
     * Like create from [[io.vertx.ext.auth.properties.PropertyFileAuthorization]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def create(vertx: io.vertx.core.Vertx, path: java.lang.String) = {
      io.vertx.ext.auth.properties.PropertyFileAuthorization.create(vertx, path)
}  }


}
