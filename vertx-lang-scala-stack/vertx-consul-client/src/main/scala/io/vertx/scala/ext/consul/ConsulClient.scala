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

package io.vertx.scala.ext.consul

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.consul.HealthState
import io.vertx.ext.consul.{KeyValueOptions => JKeyValueOptions}
import io.vertx.ext.consul.{PreparedQueryExecuteOptions => JPreparedQueryExecuteOptions}
import scala.reflect.runtime.universe._
import io.vertx.ext.consul.{TxnRequest => JTxnRequest}
import io.vertx.ext.consul.{AclToken => JAclToken}
import io.vertx.ext.consul.{CheckOptions => JCheckOptions}
import io.vertx.ext.consul.{ConsulClientOptions => JConsulClientOptions}
import io.vertx.ext.consul.{Service => JService}
import io.vertx.ext.consul.{DcCoordinates => JDcCoordinates}
import io.vertx.scala.core.Vertx
import io.vertx.ext.consul.{CoordinateList => JCoordinateList}
import io.vertx.ext.consul.{EventList => JEventList}
import io.vertx.ext.consul.{Check => JCheck}
import io.vertx.ext.consul.{ServiceList => JServiceList}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.ext.consul.{ServiceQueryOptions => JServiceQueryOptions}
import io.vertx.ext.consul.{ConsulClient => JConsulClient}
import io.vertx.ext.consul.{CheckQueryOptions => JCheckQueryOptions}
import io.vertx.ext.consul.{MaintenanceOptions => JMaintenanceOptions}
import io.vertx.ext.consul.{CheckList => JCheckList}
import io.vertx.ext.consul.CheckStatus
import io.vertx.ext.consul.{TxnResponse => JTxnResponse}
import io.vertx.ext.consul.{SessionOptions => JSessionOptions}
import io.vertx.ext.consul.{NodeList => JNodeList}
import io.vertx.ext.consul.{NodeQueryOptions => JNodeQueryOptions}
import scala.collection.JavaConverters._
import io.vertx.ext.consul.{EventListOptions => JEventListOptions}
import io.vertx.ext.consul.{SessionList => JSessionList}
import io.vertx.ext.consul.{EventOptions => JEventOptions}
import io.vertx.ext.consul.{PreparedQueryDefinition => JPreparedQueryDefinition}
import io.vertx.ext.consul.{ServiceOptions => JServiceOptions}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.ext.consul.{PreparedQueryExecuteResponse => JPreparedQueryExecuteResponse}
import io.vertx.ext.consul.{ServiceEntryList => JServiceEntryList}
import io.vertx.ext.consul.{KeyValueList => JKeyValueList}
import io.vertx.ext.consul.{Event => JEvent}
import io.vertx.ext.consul.{Session => JSession}
import io.vertx.core.Handler
import io.vertx.ext.consul.{KeyValue => JKeyValue}
import io.vertx.ext.consul.{BlockingQueryOptions => JBlockingQueryOptions}
import io.vertx.lang.scala.HandlerOps._

/**
  * A Vert.x service used to interact with Consul.
  */

class ConsulClient(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Returns the configuration and member information of the local agent   * @param resultHandler will be provided with the configuration and member information of the local agent
   * @return reference to this, for fluency
   */
  
  def agentInfo(resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].agentInfo((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JsonObject]]{def handle(x: AsyncResult[JsonObject]) {resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))}}))
    this
  }

  /**
   * Returns the LAN network coordinates for all nodes in a given DC   * @param resultHandler will be provided with network coordinates of nodes in datacenter
   * @return reference to this, for fluency
   */
  
  def coordinateNodes(resultHandler: Handler[AsyncResult[CoordinateList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].coordinateNodes((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JCoordinateList]]{def handle(x: AsyncResult[JCoordinateList]) {resultHandler.handle(AsyncResultWrapper[JCoordinateList, CoordinateList](x, a => CoordinateList(a)))}}))
    this
  }

  /**
   * Returns the LAN network coordinates for all nodes in a given DC
   * This is blocking query unlike [[io.vertx.scala.ext.consul.ConsulClient#coordinateNodes]]   * @param options the blocking options see <a href="../../../../../../../cheatsheet/BlockingQueryOptions.html">BlockingQueryOptions</a>
   * @param resultHandler will be provided with network coordinates of nodes in datacenter
   * @return reference to this, for fluency
   */
  
  def coordinateNodesWithOptions(options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[CoordinateList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].coordinateNodesWithOptions(options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JCoordinateList]]{def handle(x: AsyncResult[JCoordinateList]) {resultHandler.handle(AsyncResultWrapper[JCoordinateList, CoordinateList](x, a => CoordinateList(a)))}}))
    this
  }

  /**
   * Returns the WAN network coordinates for all Consul servers, organized by DCs   * @param resultHandler will be provided with network coordinates for all Consul servers
   * @return reference to this, for fluency
   */
  
  def coordinateDatacenters(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[DcCoordinates]]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].coordinateDatacenters((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JDcCoordinates]]]{def handle(x: AsyncResult[java.util.List[JDcCoordinates]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[JDcCoordinates], scala.collection.mutable.Buffer[DcCoordinates]](x, a => a.asScala.map(x => DcCoordinates(x))))}}))
    this
  }

  /**
   * Returns the list of keys that corresponding to the specified key prefix.   * @param keyPrefix the prefix
   * @param resultHandler will be provided with keys list
   * @return reference to this, for fluency
   */
  
  def getKeys(keyPrefix: String, resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].getKeys(keyPrefix.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }

  /**
   * Returns the list of keys that corresponding to the specified key prefix.   * @param keyPrefix the prefix
   * @param options the blocking options see <a href="../../../../../../../cheatsheet/BlockingQueryOptions.html">BlockingQueryOptions</a>
   * @param resultHandler will be provided with keys list
   * @return reference to this, for fluency
   */
  
  def getKeysWithOptions(keyPrefix: String, options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].getKeysWithOptions(keyPrefix.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }

  /**
   * Returns key/value pair that corresponding to the specified key.
   * An empty <a href="../../../../../../../cheatsheet/KeyValue.html">KeyValue</a> object will be returned if no such key is found.   * @param key the key
   * @param resultHandler will be provided with key/value pair
   * @return reference to this, for fluency
   */
  
  def getValue(key: String, resultHandler: Handler[AsyncResult[KeyValue]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].getValue(key.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JKeyValue]]{def handle(x: AsyncResult[JKeyValue]) {resultHandler.handle(AsyncResultWrapper[JKeyValue, KeyValue](x, a => KeyValue(a)))}}))
    this
  }

  /**
   * Returns key/value pair that corresponding to the specified key.
   * An empty <a href="../../../../../../../cheatsheet/KeyValue.html">KeyValue</a> object will be returned if no such key is found.
   * This is blocking query unlike [[io.vertx.scala.ext.consul.ConsulClient#getValue]]   * @param key the key
   * @param options the blocking options see <a href="../../../../../../../cheatsheet/BlockingQueryOptions.html">BlockingQueryOptions</a>
   * @param resultHandler will be provided with key/value pair
   * @return reference to this, for fluency
   */
  
  def getValueWithOptions(key: String, options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[KeyValue]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].getValueWithOptions(key.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JKeyValue]]{def handle(x: AsyncResult[JKeyValue]) {resultHandler.handle(AsyncResultWrapper[JKeyValue, KeyValue](x, a => KeyValue(a)))}}))
    this
  }

  /**
   * Remove the key/value pair that corresponding to the specified key   * @param key the key
   * @param resultHandler will be called on complete
   * @return reference to this, for fluency
   */
  
  def deleteValue(key: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].deleteValue(key.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Returns the list of key/value pairs that corresponding to the specified key prefix.
   * An empty <a href="../../../../../../../cheatsheet/KeyValueList.html">KeyValueList</a> object will be returned if no such key prefix is found.   * @param keyPrefix the prefix
   * @param resultHandler will be provided with list of key/value pairs
   * @return reference to this, for fluency
   */
  
  def getValues(keyPrefix: String, resultHandler: Handler[AsyncResult[KeyValueList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].getValues(keyPrefix.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JKeyValueList]]{def handle(x: AsyncResult[JKeyValueList]) {resultHandler.handle(AsyncResultWrapper[JKeyValueList, KeyValueList](x, a => KeyValueList(a)))}}))
    this
  }

  /**
   * Returns the list of key/value pairs that corresponding to the specified key prefix.
   * An empty <a href="../../../../../../../cheatsheet/KeyValueList.html">KeyValueList</a> object will be returned if no such key prefix is found.
   * This is blocking query unlike [[io.vertx.scala.ext.consul.ConsulClient#getValues]]   * @param keyPrefix the prefix
   * @param options the blocking options see <a href="../../../../../../../cheatsheet/BlockingQueryOptions.html">BlockingQueryOptions</a>
   * @param resultHandler will be provided with list of key/value pairs
   * @return reference to this, for fluency
   */
  
  def getValuesWithOptions(keyPrefix: String, options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[KeyValueList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].getValuesWithOptions(keyPrefix.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JKeyValueList]]{def handle(x: AsyncResult[JKeyValueList]) {resultHandler.handle(AsyncResultWrapper[JKeyValueList, KeyValueList](x, a => KeyValueList(a)))}}))
    this
  }

  /**
   * Removes all the key/value pair that corresponding to the specified key prefix   * @param keyPrefix the prefix
   * @param resultHandler will be called on complete
   * @return reference to this, for fluency
   */
  
  def deleteValues(keyPrefix: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].deleteValues(keyPrefix.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Adds specified key/value pair   * @param key the key
   * @param value the value
   * @param resultHandler will be provided with success of operation
   * @return reference to this, for fluency
   */
  
  def putValue(key: String, value: String, resultHandler: Handler[AsyncResult[Boolean]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].putValue(key.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.Boolean]]{def handle(x: AsyncResult[java.lang.Boolean]) {resultHandler.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))}}))
    this
  }

  /**
   * @param key the key
   * @param value the value
   * @param options options used to push pair see <a href="../../../../../../../cheatsheet/KeyValueOptions.html">KeyValueOptions</a>
   * @param resultHandler will be provided with success of operation
   * @return reference to this, for fluency
   */
  
  def putValueWithOptions(key: String, value: String, options: KeyValueOptions, resultHandler: Handler[AsyncResult[Boolean]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].putValueWithOptions(key.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.Boolean]]{def handle(x: AsyncResult[java.lang.Boolean]) {resultHandler.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))}}))
    this
  }

  /**
   * Manages multiple operations inside a single, atomic transaction.   * @param request transaction request see <a href="../../../../../../../cheatsheet/TxnRequest.html">TxnRequest</a>
   * @param resultHandler will be provided with result of transaction
   * @return reference to this, for fluency
   */
  
  def transaction(request: TxnRequest, resultHandler: Handler[AsyncResult[TxnResponse]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].transaction(request.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JTxnResponse]]{def handle(x: AsyncResult[JTxnResponse]) {resultHandler.handle(AsyncResultWrapper[JTxnResponse, TxnResponse](x, a => TxnResponse(a)))}}))
    this
  }

  /**
   * Create new Acl token   * @param token properties of the token see <a href="../../../../../../../cheatsheet/AclToken.html">AclToken</a>
   * @param idHandler will be provided with ID of created token
   * @return reference to this, for fluency
   */
  
  def createAclToken(token: AclToken, idHandler: Handler[AsyncResult[String]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].createAclToken(token.asJava, (if (idHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {idHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }

  /**
   * Update Acl token   * @param token properties of the token to be updated see <a href="../../../../../../../cheatsheet/AclToken.html">AclToken</a>
   * @param idHandler will be provided with ID of updated
   * @return reference to this, for fluency
   */
  
  def updateAclToken(token: AclToken, idHandler: Handler[AsyncResult[String]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].updateAclToken(token.asJava, (if (idHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {idHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }

  /**
   * Clone Acl token   * @param id the ID of token to be cloned
   * @param idHandler will be provided with ID of cloned token
   * @return reference to this, for fluency
   */
  
  def cloneAclToken(id: String, idHandler: Handler[AsyncResult[String]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].cloneAclToken(id.asInstanceOf[java.lang.String], (if (idHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {idHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }

  /**
   * Get list of Acl token   * @param resultHandler will be provided with list of tokens
   * @return reference to this, for fluency
   */
  
  def listAclTokens(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[AclToken]]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].listAclTokens((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JAclToken]]]{def handle(x: AsyncResult[java.util.List[JAclToken]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[JAclToken], scala.collection.mutable.Buffer[AclToken]](x, a => a.asScala.map(x => AclToken(x))))}}))
    this
  }

  /**
   * Get info of Acl token   * @param id the ID of token
   * @param tokenHandler will be provided with token
   * @return reference to this, for fluency
   */
  
  def infoAclToken(id: String, tokenHandler: Handler[AsyncResult[AclToken]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].infoAclToken(id.asInstanceOf[java.lang.String], (if (tokenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JAclToken]]{def handle(x: AsyncResult[JAclToken]) {tokenHandler.handle(AsyncResultWrapper[JAclToken, AclToken](x, a => AclToken(a)))}}))
    this
  }

  /**
   * Destroy Acl token   * @param id the ID of token
   * @param resultHandler will be called on complete
   * @return reference to this, for fluency
   */
  
  def destroyAclToken(id: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].destroyAclToken(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Fires a new user event   * @param name name of event
   * @param resultHandler will be provided with properties of event
   * @return reference to this, for fluency
   */
  
  def fireEvent(name: String, resultHandler: Handler[AsyncResult[Event]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].fireEvent(name.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JEvent]]{def handle(x: AsyncResult[JEvent]) {resultHandler.handle(AsyncResultWrapper[JEvent, Event](x, a => Event(a)))}}))
    this
  }

  /**
   * Fires a new user event   * @param name name of event
   * @param options options used to create event see <a href="../../../../../../../cheatsheet/EventOptions.html">EventOptions</a>
   * @param resultHandler will be provided with properties of event
   * @return reference to this, for fluency
   */
  
  def fireEventWithOptions(name: String, options: EventOptions, resultHandler: Handler[AsyncResult[Event]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].fireEventWithOptions(name.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JEvent]]{def handle(x: AsyncResult[JEvent]) {resultHandler.handle(AsyncResultWrapper[JEvent, Event](x, a => Event(a)))}}))
    this
  }

  /**
   * Returns the most recent events known by the agent   * @param resultHandler will be provided with list of events
   * @return reference to this, for fluency
   */
  
  def listEvents(resultHandler: Handler[AsyncResult[EventList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].listEvents((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JEventList]]{def handle(x: AsyncResult[JEventList]) {resultHandler.handle(AsyncResultWrapper[JEventList, EventList](x, a => EventList(a)))}}))
    this
  }

  /**
   * Returns the most recent events known by the agent.
   * This is blocking query unlike [[io.vertx.scala.ext.consul.ConsulClient#listEvents]]. However, the semantics of this endpoint
   * are slightly different. Most blocking queries provide a monotonic index and block until a newer index is available.
   * This can be supported as a consequence of the total ordering of the consensus protocol. With gossip,
   * there is no ordering, and instead `X-Consul-Index` maps to the newest event that matches the query.
   * 
   * In practice, this means the index is only useful when used against a single agent and has no meaning globally.
   * Because Consul defines the index as being opaque, clients should not be expecting a natural ordering either.   * @param options the blocking options see <a href="../../../../../../../cheatsheet/EventListOptions.html">EventListOptions</a>
   * @param resultHandler will be provided with list of events
   * @return reference to this, for fluency
   */
  
  def listEventsWithOptions(options: EventListOptions, resultHandler: Handler[AsyncResult[EventList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].listEventsWithOptions(options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JEventList]]{def handle(x: AsyncResult[JEventList]) {resultHandler.handle(AsyncResultWrapper[JEventList, EventList](x, a => EventList(a)))}}))
    this
  }

  /**
   * Adds a new service, with an optional health check, to the local agent.   * @param serviceOptions the options of new service see <a href="../../../../../../../cheatsheet/ServiceOptions.html">ServiceOptions</a>
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def registerService(serviceOptions: ServiceOptions, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].registerService(serviceOptions.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Places a given service into "maintenance mode"   * @param maintenanceOptions the maintenance options see <a href="../../../../../../../cheatsheet/MaintenanceOptions.html">MaintenanceOptions</a>
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def maintenanceService(maintenanceOptions: MaintenanceOptions, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].maintenanceService(maintenanceOptions.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Remove a service from the local agent. The agent will take care of deregistering the service with the Catalog.
   * If there is an associated check, that is also deregistered.   * @param id the ID of service
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def deregisterService(id: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].deregisterService(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Returns the nodes providing a service   * @param service name of service
   * @param resultHandler will be provided with list of nodes providing given service
   * @return reference to this, for fluency
   */
  
  def catalogServiceNodes(service: String, resultHandler: Handler[AsyncResult[ServiceList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].catalogServiceNodes(service.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceList]]{def handle(x: AsyncResult[JServiceList]) {resultHandler.handle(AsyncResultWrapper[JServiceList, ServiceList](x, a => ServiceList(a)))}}))
    this
  }

  /**
   * Returns the nodes providing a service   * @param service name of service
   * @param options options used to request services see <a href="../../../../../../../cheatsheet/ServiceQueryOptions.html">ServiceQueryOptions</a>
   * @param resultHandler will be provided with list of nodes providing given service
   * @return reference to this, for fluency
   */
  
  def catalogServiceNodesWithOptions(service: String, options: ServiceQueryOptions, resultHandler: Handler[AsyncResult[ServiceList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].catalogServiceNodesWithOptions(service.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceList]]{def handle(x: AsyncResult[JServiceList]) {resultHandler.handle(AsyncResultWrapper[JServiceList, ServiceList](x, a => ServiceList(a)))}}))
    this
  }

  /**
   * Return all the datacenters that are known by the Consul server   * @param resultHandler will be provided with list of datacenters
   * @return reference to this, for fluency
   */
  
  def catalogDatacenters(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].catalogDatacenters((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }

  /**
   * Returns the nodes registered in a datacenter   * @param resultHandler will be provided with list of nodes
   * @return reference to this, for fluency
   */
  
  def catalogNodes(resultHandler: Handler[AsyncResult[NodeList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].catalogNodes((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JNodeList]]{def handle(x: AsyncResult[JNodeList]) {resultHandler.handle(AsyncResultWrapper[JNodeList, NodeList](x, a => NodeList(a)))}}))
    this
  }

  /**
   * Returns the nodes registered in a datacenter   * @param options options used to request nodes see <a href="../../../../../../../cheatsheet/NodeQueryOptions.html">NodeQueryOptions</a>
   * @param resultHandler will be provided with list of nodes
   * @return reference to this, for fluency
   */
  
  def catalogNodesWithOptions(options: NodeQueryOptions, resultHandler: Handler[AsyncResult[NodeList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].catalogNodesWithOptions(options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JNodeList]]{def handle(x: AsyncResult[JNodeList]) {resultHandler.handle(AsyncResultWrapper[JNodeList, NodeList](x, a => NodeList(a)))}}))
    this
  }

  /**
   * Returns the checks associated with the service   * @param service the service name
   * @param resultHandler will be provided with list of checks
   * @return reference to this, for fluency
   */
  
  def healthChecks(service: String, resultHandler: Handler[AsyncResult[CheckList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].healthChecks(service.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JCheckList]]{def handle(x: AsyncResult[JCheckList]) {resultHandler.handle(AsyncResultWrapper[JCheckList, CheckList](x, a => CheckList(a)))}}))
    this
  }

  /**
   * Returns the checks associated with the service   * @param service the service name
   * @param options options used to request checks see <a href="../../../../../../../cheatsheet/CheckQueryOptions.html">CheckQueryOptions</a>
   * @param resultHandler will be provided with list of checks
   * @return reference to this, for fluency
   */
  
  def healthChecksWithOptions(service: String, options: CheckQueryOptions, resultHandler: Handler[AsyncResult[CheckList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].healthChecksWithOptions(service.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JCheckList]]{def handle(x: AsyncResult[JCheckList]) {resultHandler.handle(AsyncResultWrapper[JCheckList, CheckList](x, a => CheckList(a)))}}))
    this
  }

  /**
   * Returns the checks in the specified status   * @param healthState the health state
   * @param resultHandler will be provided with list of checks
   * @return reference to this, for fluency
   */
  
  def healthState(healthState: io.vertx.ext.consul.HealthState, resultHandler: Handler[AsyncResult[CheckList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].healthState(healthState, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JCheckList]]{def handle(x: AsyncResult[JCheckList]) {resultHandler.handle(AsyncResultWrapper[JCheckList, CheckList](x, a => CheckList(a)))}}))
    this
  }

  /**
   * Returns the checks in the specified status   * @param healthState the health state
   * @param options options used to request checks see <a href="../../../../../../../cheatsheet/CheckQueryOptions.html">CheckQueryOptions</a>
   * @param resultHandler will be provided with list of checks
   * @return reference to this, for fluency
   */
  
  def healthStateWithOptions(healthState: io.vertx.ext.consul.HealthState, options: CheckQueryOptions, resultHandler: Handler[AsyncResult[CheckList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].healthStateWithOptions(healthState, options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JCheckList]]{def handle(x: AsyncResult[JCheckList]) {resultHandler.handle(AsyncResultWrapper[JCheckList, CheckList](x, a => CheckList(a)))}}))
    this
  }

  /**
   * Returns the nodes providing the service. This endpoint is very similar to the [[io.vertx.scala.ext.consul.ConsulClient#catalogServiceNodes]] endpoint;
   * however, this endpoint automatically returns the status of the associated health check as well as any system level health checks.   * @param service the service name
   * @param passing if true, filter results to only nodes with all checks in the passing state
   * @param resultHandler will be provided with list of services
   * @return reference to this, for fluency
   */
  
  def healthServiceNodes(service: String, passing: Boolean, resultHandler: Handler[AsyncResult[ServiceEntryList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].healthServiceNodes(service.asInstanceOf[java.lang.String], passing.asInstanceOf[java.lang.Boolean], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceEntryList]]{def handle(x: AsyncResult[JServiceEntryList]) {resultHandler.handle(AsyncResultWrapper[JServiceEntryList, ServiceEntryList](x, a => ServiceEntryList(a)))}}))
    this
  }

  /**
   * Returns the nodes providing the service. This endpoint is very similar to the [[io.vertx.scala.ext.consul.ConsulClient#catalogServiceNodesWithOptions]] endpoint;
   * however, this endpoint automatically returns the status of the associated health check as well as any system level health checks.   * @param service the service name
   * @param passing if true, filter results to only nodes with all checks in the passing state
   * @param options options used to request services see <a href="../../../../../../../cheatsheet/ServiceQueryOptions.html">ServiceQueryOptions</a>
   * @param resultHandler will be provided with list of services
   * @return reference to this, for fluency
   */
  
  def healthServiceNodesWithOptions(service: String, passing: Boolean, options: ServiceQueryOptions, resultHandler: Handler[AsyncResult[ServiceEntryList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].healthServiceNodesWithOptions(service.asInstanceOf[java.lang.String], passing.asInstanceOf[java.lang.Boolean], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceEntryList]]{def handle(x: AsyncResult[JServiceEntryList]) {resultHandler.handle(AsyncResultWrapper[JServiceEntryList, ServiceEntryList](x, a => ServiceEntryList(a)))}}))
    this
  }

  /**
   * Returns the services registered in a datacenter   * @param resultHandler will be provided with list of services
   * @return reference to this, for fluency
   */
  
  def catalogServices(resultHandler: Handler[AsyncResult[ServiceList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].catalogServices((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceList]]{def handle(x: AsyncResult[JServiceList]) {resultHandler.handle(AsyncResultWrapper[JServiceList, ServiceList](x, a => ServiceList(a)))}}))
    this
  }

  /**
   * Returns the services registered in a datacenter
   * This is blocking query unlike [[io.vertx.scala.ext.consul.ConsulClient#catalogServices]]   * @param options the blocking options see <a href="../../../../../../../cheatsheet/BlockingQueryOptions.html">BlockingQueryOptions</a>
   * @param resultHandler will be provided with list of services
   * @return reference to this, for fluency
   */
  
  def catalogServicesWithOptions(options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[ServiceList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].catalogServicesWithOptions(options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceList]]{def handle(x: AsyncResult[JServiceList]) {resultHandler.handle(AsyncResultWrapper[JServiceList, ServiceList](x, a => ServiceList(a)))}}))
    this
  }

  /**
   * Returns the node's registered services   * @param node node name
   * @param resultHandler will be provided with list of services
   * @return reference to this, for fluency
   */
  
  def catalogNodeServices(node: String, resultHandler: Handler[AsyncResult[ServiceList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].catalogNodeServices(node.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceList]]{def handle(x: AsyncResult[JServiceList]) {resultHandler.handle(AsyncResultWrapper[JServiceList, ServiceList](x, a => ServiceList(a)))}}))
    this
  }

  /**
   * Returns the node's registered services
   * This is blocking query unlike [[io.vertx.scala.ext.consul.ConsulClient#catalogNodeServices]]   * @param node node name
   * @param options the blocking options see <a href="../../../../../../../cheatsheet/BlockingQueryOptions.html">BlockingQueryOptions</a>
   * @param resultHandler will be provided with list of services
   * @return reference to this, for fluency
   */
  
  def catalogNodeServicesWithOptions(node: String, options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[ServiceList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].catalogNodeServicesWithOptions(node.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceList]]{def handle(x: AsyncResult[JServiceList]) {resultHandler.handle(AsyncResultWrapper[JServiceList, ServiceList](x, a => ServiceList(a)))}}))
    this
  }

  /**
   * Returns list of services registered with the local agent.   * @param resultHandler will be provided with list of services
   * @return reference to this, for fluency
   */
  
  def localServices(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[Service]]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].localServices((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JService]]]{def handle(x: AsyncResult[java.util.List[JService]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[JService], scala.collection.mutable.Buffer[Service]](x, a => a.asScala.map(x => Service(x))))}}))
    this
  }

  /**
   * Return all the checks that are registered with the local agent.   * @param resultHandler will be provided with list of checks
   * @return reference to this, for fluency
   */
  
  def localChecks(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[Check]]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].localChecks((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JCheck]]]{def handle(x: AsyncResult[java.util.List[JCheck]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[JCheck], scala.collection.mutable.Buffer[Check]](x, a => a.asScala.map(x => Check(x))))}}))
    this
  }

  /**
   * Add a new check to the local agent. The agent is responsible for managing the status of the check
   * and keeping the Catalog in sync.   * @param checkOptions options used to register new check see <a href="../../../../../../../cheatsheet/CheckOptions.html">CheckOptions</a>
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def registerCheck(checkOptions: CheckOptions, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].registerCheck(checkOptions.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Remove a check from the local agent. The agent will take care of deregistering the check from the Catalog.   * @param checkId the ID of check
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def deregisterCheck(checkId: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].deregisterCheck(checkId.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Set status of the check to "passing". Used with a check that is of the TTL type. The TTL clock will be reset.   * @param checkId the ID of check
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def passCheck(checkId: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].passCheck(checkId.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Set status of the check to "passing". Used with a check that is of the TTL type. The TTL clock will be reset.   * @param checkId the ID of check
   * @param note specifies a human-readable message. This will be passed through to the check's `Output` field.
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def passCheckWithNote(checkId: String, note: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].passCheckWithNote(checkId.asInstanceOf[java.lang.String], note.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Set status of the check to "warning". Used with a check that is of the TTL type. The TTL clock will be reset.   * @param checkId the ID of check
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def warnCheck(checkId: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].warnCheck(checkId.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Set status of the check to "warning". Used with a check that is of the TTL type. The TTL clock will be reset.   * @param checkId the ID of check
   * @param note specifies a human-readable message. This will be passed through to the check's `Output` field.
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def warnCheckWithNote(checkId: String, note: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].warnCheckWithNote(checkId.asInstanceOf[java.lang.String], note.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Set status of the check to "critical". Used with a check that is of the TTL type. The TTL clock will be reset.   * @param checkId the ID of check
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def failCheck(checkId: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].failCheck(checkId.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Set status of the check to "critical". Used with a check that is of the TTL type. The TTL clock will be reset.   * @param checkId the ID of check
   * @param note specifies a human-readable message. This will be passed through to the check's `Output` field.
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def failCheckWithNote(checkId: String, note: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].failCheckWithNote(checkId.asInstanceOf[java.lang.String], note.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Set status of the check to given status. Used with a check that is of the TTL type. The TTL clock will be reset.   * @param checkId the ID of check
   * @param status new status of check
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def updateCheck(checkId: String, status: io.vertx.ext.consul.CheckStatus, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].updateCheck(checkId.asInstanceOf[java.lang.String], status, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Set status of the check to given status. Used with a check that is of the TTL type. The TTL clock will be reset.   * @param checkId the ID of check
   * @param status new status of check
   * @param note specifies a human-readable message. This will be passed through to the check's `Output` field.
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def updateCheckWithNote(checkId: String, status: io.vertx.ext.consul.CheckStatus, note: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].updateCheckWithNote(checkId.asInstanceOf[java.lang.String], status, note.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Get the Raft leader for the datacenter in which the agent is running.
   * It returns an address in format "<code>10.1.10.12:8300</code>"   * @param resultHandler will be provided with address of cluster leader
   * @return reference to this, for fluency
   */
  
  def leaderStatus(resultHandler: Handler[AsyncResult[String]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].leaderStatus((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {resultHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }

  /**
   * Retrieves the Raft peers for the datacenter in which the the agent is running.
   * It returns a list of addresses "<code>10.1.10.12:8300</code>", "<code>10.1.10.13:8300</code>"   * @param resultHandler will be provided with list of peers
   * @return reference to this, for fluency
   */
  
  def peersStatus(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].peersStatus((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }

  /**
   * Initialize a new session   * @param idHandler will be provided with ID of new session
   * @return reference to this, for fluency
   */
  
  def createSession(idHandler: Handler[AsyncResult[String]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].createSession((if (idHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {idHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }

  /**
   * Initialize a new session   * @param options options used to create session see <a href="../../../../../../../cheatsheet/SessionOptions.html">SessionOptions</a>
   * @param idHandler will be provided with ID of new session
   * @return reference to this, for fluency
   */
  
  def createSessionWithOptions(options: SessionOptions, idHandler: Handler[AsyncResult[String]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].createSessionWithOptions(options.asJava, (if (idHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {idHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }

  /**
   * Returns the requested session information   * @param id the ID of requested session
   * @param resultHandler will be provided with info of requested session
   * @return reference to this, for fluency
   */
  
  def infoSession(id: String, resultHandler: Handler[AsyncResult[Session]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].infoSession(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSession]]{def handle(x: AsyncResult[JSession]) {resultHandler.handle(AsyncResultWrapper[JSession, Session](x, a => Session(a)))}}))
    this
  }

  /**
   * Returns the requested session information
   * This is blocking query unlike [[io.vertx.scala.ext.consul.ConsulClient#infoSession]]   * @param id the ID of requested session
   * @param options the blocking options see <a href="../../../../../../../cheatsheet/BlockingQueryOptions.html">BlockingQueryOptions</a>
   * @param resultHandler will be provided with info of requested session
   * @return reference to this, for fluency
   */
  
  def infoSessionWithOptions(id: String, options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[Session]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].infoSessionWithOptions(id.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSession]]{def handle(x: AsyncResult[JSession]) {resultHandler.handle(AsyncResultWrapper[JSession, Session](x, a => Session(a)))}}))
    this
  }

  /**
   * Renews the given session. This is used with sessions that have a TTL, and it extends the expiration by the TTL   * @param id the ID of session that should be renewed
   * @param resultHandler will be provided with info of renewed session
   * @return reference to this, for fluency
   */
  
  def renewSession(id: String, resultHandler: Handler[AsyncResult[Session]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].renewSession(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSession]]{def handle(x: AsyncResult[JSession]) {resultHandler.handle(AsyncResultWrapper[JSession, Session](x, a => Session(a)))}}))
    this
  }

  /**
   * Returns the active sessions   * @param resultHandler will be provided with list of sessions
   * @return reference to this, for fluency
   */
  
  def listSessions(resultHandler: Handler[AsyncResult[SessionList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].listSessions((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSessionList]]{def handle(x: AsyncResult[JSessionList]) {resultHandler.handle(AsyncResultWrapper[JSessionList, SessionList](x, a => SessionList(a)))}}))
    this
  }

  /**
   * Returns the active sessions
   * This is blocking query unlike [[io.vertx.scala.ext.consul.ConsulClient#listSessions]]   * @param options the blocking options see <a href="../../../../../../../cheatsheet/BlockingQueryOptions.html">BlockingQueryOptions</a>
   * @param resultHandler will be provided with list of sessions
   * @return reference to this, for fluency
   */
  
  def listSessionsWithOptions(options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[SessionList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].listSessionsWithOptions(options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSessionList]]{def handle(x: AsyncResult[JSessionList]) {resultHandler.handle(AsyncResultWrapper[JSessionList, SessionList](x, a => SessionList(a)))}}))
    this
  }

  /**
   * Returns the active sessions for a given node   * @param nodeId the ID of node
   * @param resultHandler will be provided with list of sessions
   * @return reference to this, for fluency
   */
  
  def listNodeSessions(nodeId: String, resultHandler: Handler[AsyncResult[SessionList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].listNodeSessions(nodeId.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSessionList]]{def handle(x: AsyncResult[JSessionList]) {resultHandler.handle(AsyncResultWrapper[JSessionList, SessionList](x, a => SessionList(a)))}}))
    this
  }

  /**
   * Returns the active sessions for a given node
   * This is blocking query unlike [[io.vertx.scala.ext.consul.ConsulClient#listNodeSessions]]   * @param nodeId the ID of node
   * @param options the blocking options see <a href="../../../../../../../cheatsheet/BlockingQueryOptions.html">BlockingQueryOptions</a>
   * @param resultHandler will be provided with list of sessions
   * @return reference to this, for fluency
   */
  
  def listNodeSessionsWithOptions(nodeId: String, options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[SessionList]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].listNodeSessionsWithOptions(nodeId.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSessionList]]{def handle(x: AsyncResult[JSessionList]) {resultHandler.handle(AsyncResultWrapper[JSessionList, SessionList](x, a => SessionList(a)))}}))
    this
  }

  /**
   * Destroys the given session   * @param id the ID of session
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def destroySession(id: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].destroySession(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * @param definition definition of the prepare query see <a href="../../../../../../../cheatsheet/PreparedQueryDefinition.html">PreparedQueryDefinition</a>
   * @param resultHandler will be provided with id of created prepare query
   * @return reference to this, for fluency
   */
  
  def createPreparedQuery(definition: PreparedQueryDefinition, resultHandler: Handler[AsyncResult[String]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].createPreparedQuery(definition.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {resultHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }

  /**
   * Returns an existing prepared query   * @param id the id of the query to read
   * @param resultHandler will be provided with definition of the prepare query
   * @return reference to this, for fluency
   */
  
  def getPreparedQuery(id: String, resultHandler: Handler[AsyncResult[PreparedQueryDefinition]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].getPreparedQuery(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JPreparedQueryDefinition]]{def handle(x: AsyncResult[JPreparedQueryDefinition]) {resultHandler.handle(AsyncResultWrapper[JPreparedQueryDefinition, PreparedQueryDefinition](x, a => PreparedQueryDefinition(a)))}}))
    this
  }

  /**
   * Returns a list of all prepared queries.   * @param resultHandler will be provided with list of definitions of the all prepare queries
   * @return reference to this, for fluency
   */
  
  def getAllPreparedQueries(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[PreparedQueryDefinition]]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].getAllPreparedQueries((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JPreparedQueryDefinition]]]{def handle(x: AsyncResult[java.util.List[JPreparedQueryDefinition]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[JPreparedQueryDefinition], scala.collection.mutable.Buffer[PreparedQueryDefinition]](x, a => a.asScala.map(x => PreparedQueryDefinition(x))))}}))
    this
  }

  /**
   * @param definition definition of the prepare query see <a href="../../../../../../../cheatsheet/PreparedQueryDefinition.html">PreparedQueryDefinition</a>
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def updatePreparedQuery(definition: PreparedQueryDefinition, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].updatePreparedQuery(definition.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Deletes an existing prepared query   * @param id the id of the query to delete
   * @param resultHandler will be called when complete
   * @return reference to this, for fluency
   */
  
  def deletePreparedQuery(id: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].deletePreparedQuery(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Executes an existing prepared query.   * @param query the ID of the query to execute. This can also be the name of an existing prepared query, or a name that matches a prefix name for a prepared query template.
   * @param resultHandler will be provided with response
   * @return reference to this, for fluency
   */
  
  def executePreparedQuery(query: String, resultHandler: Handler[AsyncResult[PreparedQueryExecuteResponse]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].executePreparedQuery(query.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JPreparedQueryExecuteResponse]]{def handle(x: AsyncResult[JPreparedQueryExecuteResponse]) {resultHandler.handle(AsyncResultWrapper[JPreparedQueryExecuteResponse, PreparedQueryExecuteResponse](x, a => PreparedQueryExecuteResponse(a)))}}))
    this
  }

  /**
   * Executes an existing prepared query.   * @param query the ID of the query to execute. This can also be the name of an existing prepared query, or a name that matches a prefix name for a prepared query template.
   * @param options the options used to execute prepared query see <a href="../../../../../../../cheatsheet/PreparedQueryExecuteOptions.html">PreparedQueryExecuteOptions</a>
   * @param resultHandler will be provided with response
   * @return reference to this, for fluency
   */
  
  def executePreparedQueryWithOptions(query: String, options: PreparedQueryExecuteOptions, resultHandler: Handler[AsyncResult[PreparedQueryExecuteResponse]]): ConsulClient = {
    asJava.asInstanceOf[JConsulClient].executePreparedQueryWithOptions(query.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JPreparedQueryExecuteResponse]]{def handle(x: AsyncResult[JPreparedQueryExecuteResponse]) {resultHandler.handle(AsyncResultWrapper[JPreparedQueryExecuteResponse, PreparedQueryExecuteResponse](x, a => PreparedQueryExecuteResponse(a)))}}))
    this
  }



  /**
   * Close the client and release its resources
   */
  def close (): Unit = {
    asJava.asInstanceOf[JConsulClient].close()
  }


 /**
  * Like [[agentInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def agentInfoFuture (): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JConsulClient].agentInfo(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[coordinateNodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def coordinateNodesFuture (): scala.concurrent.Future[CoordinateList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCoordinateList, CoordinateList](x => CoordinateList(x))
    asJava.asInstanceOf[JConsulClient].coordinateNodes(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[coordinateNodesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def coordinateNodesWithOptionsFuture (options: BlockingQueryOptions): scala.concurrent.Future[CoordinateList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCoordinateList, CoordinateList](x => CoordinateList(x))
    asJava.asInstanceOf[JConsulClient].coordinateNodesWithOptions(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[coordinateDatacenters]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def coordinateDatacentersFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[DcCoordinates]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JDcCoordinates], scala.collection.mutable.Buffer[DcCoordinates]](x => x.asScala.map(x => DcCoordinates(x)))
    asJava.asInstanceOf[JConsulClient].coordinateDatacenters(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getKeys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getKeysFuture (keyPrefix: String): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JConsulClient].getKeys(keyPrefix.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getKeysWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getKeysWithOptionsFuture (keyPrefix: String, options: BlockingQueryOptions): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JConsulClient].getKeysWithOptions(keyPrefix.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getValue]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getValueFuture (key: String): scala.concurrent.Future[KeyValue] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JKeyValue, KeyValue](x => KeyValue(x))
    asJava.asInstanceOf[JConsulClient].getValue(key.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getValueWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getValueWithOptionsFuture (key: String, options: BlockingQueryOptions): scala.concurrent.Future[KeyValue] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JKeyValue, KeyValue](x => KeyValue(x))
    asJava.asInstanceOf[JConsulClient].getValueWithOptions(key.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[deleteValue]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deleteValueFuture (key: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].deleteValue(key.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getValues]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getValuesFuture (keyPrefix: String): scala.concurrent.Future[KeyValueList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JKeyValueList, KeyValueList](x => KeyValueList(x))
    asJava.asInstanceOf[JConsulClient].getValues(keyPrefix.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getValuesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getValuesWithOptionsFuture (keyPrefix: String, options: BlockingQueryOptions): scala.concurrent.Future[KeyValueList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JKeyValueList, KeyValueList](x => KeyValueList(x))
    asJava.asInstanceOf[JConsulClient].getValuesWithOptions(keyPrefix.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[deleteValues]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deleteValuesFuture (keyPrefix: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].deleteValues(keyPrefix.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[putValue]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def putValueFuture (key: String, value: String): scala.concurrent.Future[Boolean] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JConsulClient].putValue(key.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[putValueWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def putValueWithOptionsFuture (key: String, value: String, options: KeyValueOptions): scala.concurrent.Future[Boolean] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JConsulClient].putValueWithOptions(key.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[transaction]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def transactionFuture (request: TxnRequest): scala.concurrent.Future[TxnResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JTxnResponse, TxnResponse](x => TxnResponse(x))
    asJava.asInstanceOf[JConsulClient].transaction(request.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[createAclToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def createAclTokenFuture (token: AclToken): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulClient].createAclToken(token.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[updateAclToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def updateAclTokenFuture (token: AclToken): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulClient].updateAclToken(token.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[cloneAclToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def cloneAclTokenFuture (id: String): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulClient].cloneAclToken(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listAclTokens]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listAclTokensFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[AclToken]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JAclToken], scala.collection.mutable.Buffer[AclToken]](x => x.asScala.map(x => AclToken(x)))
    asJava.asInstanceOf[JConsulClient].listAclTokens(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[infoAclToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def infoAclTokenFuture (id: String): scala.concurrent.Future[AclToken] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAclToken, AclToken](x => AclToken(x))
    asJava.asInstanceOf[JConsulClient].infoAclToken(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[destroyAclToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def destroyAclTokenFuture (id: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].destroyAclToken(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[fireEvent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def fireEventFuture (name: String): scala.concurrent.Future[Event] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JEvent, Event](x => Event(x))
    asJava.asInstanceOf[JConsulClient].fireEvent(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[fireEventWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def fireEventWithOptionsFuture (name: String, options: EventOptions): scala.concurrent.Future[Event] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JEvent, Event](x => Event(x))
    asJava.asInstanceOf[JConsulClient].fireEventWithOptions(name.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listEvents]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listEventsFuture (): scala.concurrent.Future[EventList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JEventList, EventList](x => EventList(x))
    asJava.asInstanceOf[JConsulClient].listEvents(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listEventsWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listEventsWithOptionsFuture (options: EventListOptions): scala.concurrent.Future[EventList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JEventList, EventList](x => EventList(x))
    asJava.asInstanceOf[JConsulClient].listEventsWithOptions(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[registerService]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def registerServiceFuture (serviceOptions: ServiceOptions): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].registerService(serviceOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[maintenanceService]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def maintenanceServiceFuture (maintenanceOptions: MaintenanceOptions): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].maintenanceService(maintenanceOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[deregisterService]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deregisterServiceFuture (id: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].deregisterService(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[catalogServiceNodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def catalogServiceNodesFuture (service: String): scala.concurrent.Future[ServiceList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceList, ServiceList](x => ServiceList(x))
    asJava.asInstanceOf[JConsulClient].catalogServiceNodes(service.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[catalogServiceNodesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def catalogServiceNodesWithOptionsFuture (service: String, options: ServiceQueryOptions): scala.concurrent.Future[ServiceList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceList, ServiceList](x => ServiceList(x))
    asJava.asInstanceOf[JConsulClient].catalogServiceNodesWithOptions(service.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[catalogDatacenters]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def catalogDatacentersFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JConsulClient].catalogDatacenters(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[catalogNodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def catalogNodesFuture (): scala.concurrent.Future[NodeList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNodeList, NodeList](x => NodeList(x))
    asJava.asInstanceOf[JConsulClient].catalogNodes(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[catalogNodesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def catalogNodesWithOptionsFuture (options: NodeQueryOptions): scala.concurrent.Future[NodeList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNodeList, NodeList](x => NodeList(x))
    asJava.asInstanceOf[JConsulClient].catalogNodesWithOptions(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[healthChecks]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def healthChecksFuture (service: String): scala.concurrent.Future[CheckList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCheckList, CheckList](x => CheckList(x))
    asJava.asInstanceOf[JConsulClient].healthChecks(service.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[healthChecksWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def healthChecksWithOptionsFuture (service: String, options: CheckQueryOptions): scala.concurrent.Future[CheckList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCheckList, CheckList](x => CheckList(x))
    asJava.asInstanceOf[JConsulClient].healthChecksWithOptions(service.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[healthState]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def healthStateFuture (healthState: io.vertx.ext.consul.HealthState): scala.concurrent.Future[CheckList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCheckList, CheckList](x => CheckList(x))
    asJava.asInstanceOf[JConsulClient].healthState(healthState, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[healthStateWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def healthStateWithOptionsFuture (healthState: io.vertx.ext.consul.HealthState, options: CheckQueryOptions): scala.concurrent.Future[CheckList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCheckList, CheckList](x => CheckList(x))
    asJava.asInstanceOf[JConsulClient].healthStateWithOptions(healthState, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[healthServiceNodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def healthServiceNodesFuture (service: String, passing: Boolean): scala.concurrent.Future[ServiceEntryList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceEntryList, ServiceEntryList](x => ServiceEntryList(x))
    asJava.asInstanceOf[JConsulClient].healthServiceNodes(service.asInstanceOf[java.lang.String], passing.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[healthServiceNodesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def healthServiceNodesWithOptionsFuture (service: String, passing: Boolean, options: ServiceQueryOptions): scala.concurrent.Future[ServiceEntryList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceEntryList, ServiceEntryList](x => ServiceEntryList(x))
    asJava.asInstanceOf[JConsulClient].healthServiceNodesWithOptions(service.asInstanceOf[java.lang.String], passing.asInstanceOf[java.lang.Boolean], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[catalogServices]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def catalogServicesFuture (): scala.concurrent.Future[ServiceList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceList, ServiceList](x => ServiceList(x))
    asJava.asInstanceOf[JConsulClient].catalogServices(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[catalogServicesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def catalogServicesWithOptionsFuture (options: BlockingQueryOptions): scala.concurrent.Future[ServiceList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceList, ServiceList](x => ServiceList(x))
    asJava.asInstanceOf[JConsulClient].catalogServicesWithOptions(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[catalogNodeServices]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def catalogNodeServicesFuture (node: String): scala.concurrent.Future[ServiceList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceList, ServiceList](x => ServiceList(x))
    asJava.asInstanceOf[JConsulClient].catalogNodeServices(node.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[catalogNodeServicesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def catalogNodeServicesWithOptionsFuture (node: String, options: BlockingQueryOptions): scala.concurrent.Future[ServiceList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceList, ServiceList](x => ServiceList(x))
    asJava.asInstanceOf[JConsulClient].catalogNodeServicesWithOptions(node.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[localServices]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def localServicesFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[Service]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JService], scala.collection.mutable.Buffer[Service]](x => x.asScala.map(x => Service(x)))
    asJava.asInstanceOf[JConsulClient].localServices(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[localChecks]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def localChecksFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[Check]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JCheck], scala.collection.mutable.Buffer[Check]](x => x.asScala.map(x => Check(x)))
    asJava.asInstanceOf[JConsulClient].localChecks(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[registerCheck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def registerCheckFuture (checkOptions: CheckOptions): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].registerCheck(checkOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[deregisterCheck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deregisterCheckFuture (checkId: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].deregisterCheck(checkId.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[passCheck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def passCheckFuture (checkId: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].passCheck(checkId.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[passCheckWithNote]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def passCheckWithNoteFuture (checkId: String, note: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].passCheckWithNote(checkId.asInstanceOf[java.lang.String], note.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[warnCheck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def warnCheckFuture (checkId: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].warnCheck(checkId.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[warnCheckWithNote]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def warnCheckWithNoteFuture (checkId: String, note: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].warnCheckWithNote(checkId.asInstanceOf[java.lang.String], note.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[failCheck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def failCheckFuture (checkId: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].failCheck(checkId.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[failCheckWithNote]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def failCheckWithNoteFuture (checkId: String, note: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].failCheckWithNote(checkId.asInstanceOf[java.lang.String], note.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[updateCheck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def updateCheckFuture (checkId: String, status: io.vertx.ext.consul.CheckStatus): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].updateCheck(checkId.asInstanceOf[java.lang.String], status, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[updateCheckWithNote]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def updateCheckWithNoteFuture (checkId: String, status: io.vertx.ext.consul.CheckStatus, note: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].updateCheckWithNote(checkId.asInstanceOf[java.lang.String], status, note.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[leaderStatus]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def leaderStatusFuture (): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulClient].leaderStatus(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[peersStatus]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def peersStatusFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JConsulClient].peersStatus(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[createSession]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def createSessionFuture (): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulClient].createSession(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[createSessionWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def createSessionWithOptionsFuture (options: SessionOptions): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulClient].createSessionWithOptions(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[infoSession]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def infoSessionFuture (id: String): scala.concurrent.Future[Session] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSession, Session](x => Session(x))
    asJava.asInstanceOf[JConsulClient].infoSession(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[infoSessionWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def infoSessionWithOptionsFuture (id: String, options: BlockingQueryOptions): scala.concurrent.Future[Session] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSession, Session](x => Session(x))
    asJava.asInstanceOf[JConsulClient].infoSessionWithOptions(id.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[renewSession]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def renewSessionFuture (id: String): scala.concurrent.Future[Session] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSession, Session](x => Session(x))
    asJava.asInstanceOf[JConsulClient].renewSession(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listSessions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listSessionsFuture (): scala.concurrent.Future[SessionList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSessionList, SessionList](x => SessionList(x))
    asJava.asInstanceOf[JConsulClient].listSessions(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listSessionsWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listSessionsWithOptionsFuture (options: BlockingQueryOptions): scala.concurrent.Future[SessionList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSessionList, SessionList](x => SessionList(x))
    asJava.asInstanceOf[JConsulClient].listSessionsWithOptions(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listNodeSessions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listNodeSessionsFuture (nodeId: String): scala.concurrent.Future[SessionList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSessionList, SessionList](x => SessionList(x))
    asJava.asInstanceOf[JConsulClient].listNodeSessions(nodeId.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listNodeSessionsWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listNodeSessionsWithOptionsFuture (nodeId: String, options: BlockingQueryOptions): scala.concurrent.Future[SessionList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSessionList, SessionList](x => SessionList(x))
    asJava.asInstanceOf[JConsulClient].listNodeSessionsWithOptions(nodeId.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[destroySession]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def destroySessionFuture (id: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].destroySession(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[createPreparedQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def createPreparedQueryFuture (definition: PreparedQueryDefinition): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulClient].createPreparedQuery(definition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getPreparedQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getPreparedQueryFuture (id: String): scala.concurrent.Future[PreparedQueryDefinition] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JPreparedQueryDefinition, PreparedQueryDefinition](x => PreparedQueryDefinition(x))
    asJava.asInstanceOf[JConsulClient].getPreparedQuery(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getAllPreparedQueries]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getAllPreparedQueriesFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[PreparedQueryDefinition]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JPreparedQueryDefinition], scala.collection.mutable.Buffer[PreparedQueryDefinition]](x => x.asScala.map(x => PreparedQueryDefinition(x)))
    asJava.asInstanceOf[JConsulClient].getAllPreparedQueries(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[updatePreparedQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def updatePreparedQueryFuture (definition: PreparedQueryDefinition): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].updatePreparedQuery(definition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[deletePreparedQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deletePreparedQueryFuture (id: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulClient].deletePreparedQuery(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[executePreparedQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def executePreparedQueryFuture (query: String): scala.concurrent.Future[PreparedQueryExecuteResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JPreparedQueryExecuteResponse, PreparedQueryExecuteResponse](x => PreparedQueryExecuteResponse(x))
    asJava.asInstanceOf[JConsulClient].executePreparedQuery(query.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[executePreparedQueryWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def executePreparedQueryWithOptionsFuture (query: String, options: PreparedQueryExecuteOptions): scala.concurrent.Future[PreparedQueryExecuteResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JPreparedQueryExecuteResponse, PreparedQueryExecuteResponse](x => PreparedQueryExecuteResponse(x))
    asJava.asInstanceOf[JConsulClient].executePreparedQueryWithOptions(query.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object ConsulClient {
  def apply(asJava: JConsulClient) = new ConsulClient(asJava)
  
  /**
   * Create a Consul client with default options.   * @param vertx the Vert.x instance
   * @return the client
   */
  def create(vertx: Vertx): ConsulClient = {
    ConsulClient(JConsulClient.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
   * Create a Consul client.   * @param vertx the Vert.x instance
   * @param options the options see <a href="../../../../../../../cheatsheet/ConsulClientOptions.html">ConsulClientOptions</a>
   * @return the client
   */
  def create(vertx: Vertx,options: ConsulClientOptions): ConsulClient = {
    ConsulClient(JConsulClient.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

}
