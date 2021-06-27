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


package io.vertx.scala.ext

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.shell.term.{SSHTermOptions => JSSHTermOptions}
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net
import io.vertx.core.net.{JksOptions => JJksOptions}
package object shell{


  type HttpTermOptions = io.vertx.ext.shell.term.HttpTermOptions
  object HttpTermOptions {
    def apply() = new HttpTermOptions()
    def apply(json: JsonObject) = new HttpTermOptions(json)
  }



  type SSHTermOptions = io.vertx.ext.shell.term.SSHTermOptions
  object SSHTermOptions {
    def apply() = new SSHTermOptions()
    def apply(json: JsonObject) = new SSHTermOptions(json)
  }



  type ShellServerOptions = io.vertx.ext.shell.ShellServerOptions
  object ShellServerOptions {
    def apply() = new ShellServerOptions()
    def apply(json: JsonObject) = new ShellServerOptions(json)
  }



  type ShellServiceOptions = io.vertx.ext.shell.ShellServiceOptions
  object ShellServiceOptions {
    def apply() = new ShellServiceOptions()
    def apply(json: JsonObject) = new ShellServiceOptions(json)
  }



  type TelnetTermOptions = io.vertx.ext.shell.term.TelnetTermOptions
  object TelnetTermOptions {
    def apply() = new TelnetTermOptions()
    def apply(json: JsonObject) = new TelnetTermOptions(json)
  }



}
