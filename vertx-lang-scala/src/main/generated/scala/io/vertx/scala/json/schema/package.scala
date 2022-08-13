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


package io.vertx.scala.json

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.json.schema.{SchemaRouterOptions => JSchemaRouterOptions}
package object schema{


  type JsonSchemaOptions = io.vertx.json.schema.JsonSchemaOptions
  object JsonSchemaOptions {
    def apply() = new JsonSchemaOptions()
    def apply(json: JsonObject) = new JsonSchemaOptions(json)
    def apply( baseUri: java.lang.String = null, draft: io.vertx.json.schema.Draft = null, outputFormat: io.vertx.json.schema.OutputFormat = null): JsonSchemaOptions = {
      val ret = new JsonSchemaOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (baseUri != null) ret.setBaseUri(baseUri) 
      if (draft != null) ret.setDraft(draft) 
      if (outputFormat != null) ret.setOutputFormat(outputFormat) 
      ret
    }
  }



  type OutputUnit = io.vertx.json.schema.OutputUnit
  object OutputUnit {
    def apply() = new OutputUnit()
    def apply(json: JsonObject) = new OutputUnit(json)
    def apply( annotations: scala.collection.immutable.List[io.vertx.json.schema.OutputUnit] = null, error: java.lang.String = null, errors: scala.collection.immutable.List[io.vertx.json.schema.OutputUnit] = null, instanceLocation: java.lang.String = null, keyword: java.lang.String = null, keywordLocation: java.lang.String = null, valid: java.lang.Boolean = null): OutputUnit = {
      val ret = new OutputUnit(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (annotations != null) ret.setAnnotations(annotations.asJava) 
      if (error != null) ret.setError(error) 
      if (errors != null) ret.setErrors(errors.asJava) 
      if (instanceLocation != null) ret.setInstanceLocation(instanceLocation) 
      if (keyword != null) ret.setKeyword(keyword) 
      if (keywordLocation != null) ret.setKeywordLocation(keywordLocation) 
      if (valid != null) ret.setValid(valid) 
      ret
    }
  }



  type SchemaRouterOptions = io.vertx.json.schema.SchemaRouterOptions
  object SchemaRouterOptions {
    def apply() = new SchemaRouterOptions()
    def apply(json: JsonObject) = new SchemaRouterOptions(json)

  }



}
