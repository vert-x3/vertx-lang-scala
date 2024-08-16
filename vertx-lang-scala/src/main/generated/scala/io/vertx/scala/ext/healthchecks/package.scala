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

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.healthchecks.{Status => JStatus}
import io.vertx.core.json.JsonObject
package object healthchecks{


  type CheckResult = io.vertx.ext.healthchecks.CheckResult
  object CheckResult {
    def apply() = new CheckResult()
    def apply( checks: scala.collection.immutable.List[io.vertx.ext.healthchecks.CheckResult] = null, data: io.vertx.core.json.JsonObject = null, id: java.lang.String = null, status: io.vertx.ext.healthchecks.Status = null, up: java.lang.Boolean = null): CheckResult = {
      val ret = new CheckResult()
      if (checks != null) ret.setChecks(checks.asJava) 
      if (id != null) ret.setId(id) 
      if (status != null) ret.setStatus(status) 
      ret
    }
  }



  type Status = io.vertx.ext.healthchecks.Status
  object Status {
    def apply() = new Status()
    def apply(json: JsonObject) = new Status(json)
    def apply( data: io.vertx.core.json.JsonObject = null, ok: java.lang.Boolean = null, procedureInError: java.lang.Boolean = null): Status = {
      val ret = new Status(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (data != null) ret.setData(data) 
      if (ok != null) ret.setOk(ok) 
      if (procedureInError != null) ret.setProcedureInError(procedureInError) 
      ret
    }
  }



}
