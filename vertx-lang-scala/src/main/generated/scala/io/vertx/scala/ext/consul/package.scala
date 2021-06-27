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

import io.vertx.ext.consul.{NodeQueryOptions => JNodeQueryOptions}
package object consul{


  type AclToken = io.vertx.ext.consul.AclToken
  object AclToken {
    def apply() = new AclToken()
    def apply(json: JsonObject) = new AclToken(json)
  }



  type BlockingQueryOptions = io.vertx.ext.consul.BlockingQueryOptions
  object BlockingQueryOptions {
    def apply() = new BlockingQueryOptions()
    def apply(json: JsonObject) = new BlockingQueryOptions(json)
  }



  type Check = io.vertx.ext.consul.Check
  object Check {
    def apply() = new Check()
    def apply(json: JsonObject) = new Check(json)
  }



  type CheckList = io.vertx.ext.consul.CheckList
  object CheckList {
    def apply() = new CheckList()
    def apply(json: JsonObject) = new CheckList(json)
  }



  type CheckOptions = io.vertx.ext.consul.CheckOptions
  object CheckOptions {
    def apply() = new CheckOptions()
    def apply(json: JsonObject) = new CheckOptions(json)
  }



  type CheckQueryOptions = io.vertx.ext.consul.CheckQueryOptions
  object CheckQueryOptions {
    def apply() = new CheckQueryOptions()
    def apply(json: JsonObject) = new CheckQueryOptions(json)
  }



  type ConsulClientOptions = io.vertx.ext.consul.ConsulClientOptions
  object ConsulClientOptions {
    def apply() = new ConsulClientOptions()
    def apply(json: JsonObject) = new ConsulClientOptions(json)
  }



  type Coordinate = io.vertx.ext.consul.Coordinate
  object Coordinate {
    def apply() = new Coordinate()
    def apply(json: JsonObject) = new Coordinate(json)
  }



  type CoordinateList = io.vertx.ext.consul.CoordinateList
  object CoordinateList {
    def apply() = new CoordinateList()
    def apply(json: JsonObject) = new CoordinateList(json)
  }



  type DcCoordinates = io.vertx.ext.consul.DcCoordinates
  object DcCoordinates {
    def apply() = new DcCoordinates()
    def apply(json: JsonObject) = new DcCoordinates(json)
  }



  type Event = io.vertx.ext.consul.Event
  object Event {
    def apply() = new Event()
    def apply(json: JsonObject) = new Event(json)
  }



  type EventList = io.vertx.ext.consul.EventList
  object EventList {
    def apply() = new EventList()
    def apply(json: JsonObject) = new EventList(json)
  }



  type EventListOptions = io.vertx.ext.consul.EventListOptions
  object EventListOptions {
    def apply() = new EventListOptions()
    def apply(json: JsonObject) = new EventListOptions(json)
  }



  type EventOptions = io.vertx.ext.consul.EventOptions
  object EventOptions {
    def apply() = new EventOptions()
    def apply(json: JsonObject) = new EventOptions(json)
  }



  type KeyValue = io.vertx.ext.consul.KeyValue
  object KeyValue {
    def apply() = new KeyValue()
    def apply(json: JsonObject) = new KeyValue(json)
  }



  type KeyValueList = io.vertx.ext.consul.KeyValueList
  object KeyValueList {
    def apply() = new KeyValueList()
    def apply(json: JsonObject) = new KeyValueList(json)
  }



  type KeyValueOptions = io.vertx.ext.consul.KeyValueOptions
  object KeyValueOptions {
    def apply() = new KeyValueOptions()
    def apply(json: JsonObject) = new KeyValueOptions(json)
  }



  type MaintenanceOptions = io.vertx.ext.consul.MaintenanceOptions
  object MaintenanceOptions {
    def apply() = new MaintenanceOptions()
    def apply(json: JsonObject) = new MaintenanceOptions(json)
  }



  type Node = io.vertx.ext.consul.Node
  object Node {
    def apply() = new Node()
    def apply(json: JsonObject) = new Node(json)
  }



  type NodeList = io.vertx.ext.consul.NodeList
  object NodeList {
    def apply() = new NodeList()
    def apply(json: JsonObject) = new NodeList(json)
  }



  type NodeQueryOptions = io.vertx.ext.consul.NodeQueryOptions
  object NodeQueryOptions {
    def apply() = new NodeQueryOptions()
    def apply(json: JsonObject) = new NodeQueryOptions(json)
  }



  type PreparedQueryDefinition = io.vertx.ext.consul.PreparedQueryDefinition
  object PreparedQueryDefinition {
    def apply() = new PreparedQueryDefinition()
    def apply(json: JsonObject) = new PreparedQueryDefinition(json)
  }



  type PreparedQueryExecuteOptions = io.vertx.ext.consul.PreparedQueryExecuteOptions
  object PreparedQueryExecuteOptions {
    def apply() = new PreparedQueryExecuteOptions()
    def apply(json: JsonObject) = new PreparedQueryExecuteOptions(json)
  }



  type PreparedQueryExecuteResponse = io.vertx.ext.consul.PreparedQueryExecuteResponse
  object PreparedQueryExecuteResponse {
    def apply() = new PreparedQueryExecuteResponse()
    def apply(json: JsonObject) = new PreparedQueryExecuteResponse(json)
  }



  type Service = io.vertx.ext.consul.Service
  object Service {
    def apply() = new Service()
    def apply(json: JsonObject) = new Service(json)
  }



  type ServiceEntry = io.vertx.ext.consul.ServiceEntry
  object ServiceEntry {
    def apply() = new ServiceEntry()
    def apply(json: JsonObject) = new ServiceEntry(json)
  }



  type ServiceEntryList = io.vertx.ext.consul.ServiceEntryList
  object ServiceEntryList {
    def apply() = new ServiceEntryList()
    def apply(json: JsonObject) = new ServiceEntryList(json)
  }



  type ServiceList = io.vertx.ext.consul.ServiceList
  object ServiceList {
    def apply() = new ServiceList()
    def apply(json: JsonObject) = new ServiceList(json)
  }



  type ServiceOptions = io.vertx.ext.consul.ServiceOptions
  object ServiceOptions {
    def apply() = new ServiceOptions()
    def apply(json: JsonObject) = new ServiceOptions(json)
  }



  type ServiceQueryOptions = io.vertx.ext.consul.ServiceQueryOptions
  object ServiceQueryOptions {
    def apply() = new ServiceQueryOptions()
    def apply(json: JsonObject) = new ServiceQueryOptions(json)
  }



  type Session = io.vertx.ext.consul.Session
  object Session {
    def apply() = new Session()
    def apply(json: JsonObject) = new Session(json)
  }



  type SessionList = io.vertx.ext.consul.SessionList
  object SessionList {
    def apply() = new SessionList()
    def apply(json: JsonObject) = new SessionList(json)
  }



  type SessionOptions = io.vertx.ext.consul.SessionOptions
  object SessionOptions {
    def apply() = new SessionOptions()
    def apply(json: JsonObject) = new SessionOptions(json)
  }



  type TxnError = io.vertx.ext.consul.TxnError
  object TxnError {
    def apply() = new TxnError()
    def apply(json: JsonObject) = new TxnError(json)
  }



  type TxnKVOperation = io.vertx.ext.consul.TxnKVOperation
  object TxnKVOperation {
    def apply() = new TxnKVOperation()
    def apply(json: JsonObject) = new TxnKVOperation(json)
  }



  type TxnRequest = io.vertx.ext.consul.TxnRequest
  object TxnRequest {
    def apply() = new TxnRequest()
    def apply(json: JsonObject) = new TxnRequest(json)
  }



  type TxnResponse = io.vertx.ext.consul.TxnResponse
  object TxnResponse {
    def apply() = new TxnResponse()
    def apply(json: JsonObject) = new TxnResponse(json)
  }



}
