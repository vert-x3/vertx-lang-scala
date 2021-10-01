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


package io.vertx.scala.ext.web.handler

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.web.handler.graphql.{GraphQLHandlerOptions => JGraphQLHandlerOptions}
package object graphql{


  type ApolloWSOptions = io.vertx.ext.web.handler.graphql.ApolloWSOptions
  object ApolloWSOptions {
    def apply() = new ApolloWSOptions()
    def apply(json: JsonObject) = new ApolloWSOptions(json)
    def apply( keepAlive: java.lang.Long = null): ApolloWSOptions = {
      val ret = new ApolloWSOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (keepAlive != null) ret.setKeepAlive(keepAlive) 
      ret
    }
  }



  type GraphQLHandlerOptions = io.vertx.ext.web.handler.graphql.GraphQLHandlerOptions
  object GraphQLHandlerOptions {
    def apply() = new GraphQLHandlerOptions()
    def apply(json: JsonObject) = new GraphQLHandlerOptions(json)
    def apply( requestBatchingEnabled: java.lang.Boolean = null, requestMultipartEnabled: java.lang.Boolean = null): GraphQLHandlerOptions = {
      val ret = new GraphQLHandlerOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (requestBatchingEnabled != null) ret.setRequestBatchingEnabled(requestBatchingEnabled) 
      if (requestMultipartEnabled != null) ret.setRequestMultipartEnabled(requestMultipartEnabled) 
      ret
    }
  }



  type GraphQLWSOptions = io.vertx.ext.web.handler.graphql.ws.GraphQLWSOptions
  object GraphQLWSOptions {
    def apply() = new GraphQLWSOptions()
    def apply(json: JsonObject) = new GraphQLWSOptions(json)
    def apply( connectionInitWaitTimeout: java.lang.Long = null): GraphQLWSOptions = {
      val ret = new GraphQLWSOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (connectionInitWaitTimeout != null) ret.setConnectionInitWaitTimeout(connectionInitWaitTimeout) 
      ret
    }
  }



  type GraphiQLHandlerOptions = io.vertx.ext.web.handler.graphql.GraphiQLHandlerOptions
  object GraphiQLHandlerOptions {
    def apply() = new GraphiQLHandlerOptions()
    def apply(json: JsonObject) = new GraphiQLHandlerOptions(json)
    def apply( enabled: java.lang.Boolean = null, graphQLUri: java.lang.String = null, headers: scala.collection.immutable.Map[String,java.lang.String] = null, query: java.lang.String = null, variables: io.vertx.core.json.JsonObject = null): GraphiQLHandlerOptions = {
      val ret = new GraphiQLHandlerOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (enabled != null) ret.setEnabled(enabled) 
      if (graphQLUri != null) ret.setGraphQLUri(graphQLUri) 
      if (headers != null) ret.setHeaders(headers.asJava) 
      if (query != null) ret.setQuery(query) 
      if (variables != null) ret.setVariables(variables) 
      ret
    }
  }



}
