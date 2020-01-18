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
import io.vertx.ext.consul.{ConsulService => JConsulService}
import scala.reflect.runtime.universe._
import io.vertx.ext.consul.{TxnRequest => JTxnRequest}
import io.vertx.ext.consul.{AclToken => JAclToken}
import io.vertx.ext.consul.{CheckOptions => JCheckOptions}
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


class ConsulService(private val _asJava: Object) extends ConsulClient (_asJava) {





  override 
  def agentInfo(resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].agentInfo((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JsonObject]]{def handle(x: AsyncResult[JsonObject]) {resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))}}))
    this
  }


  override 
  def coordinateNodes(resultHandler: Handler[AsyncResult[CoordinateList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].coordinateNodes((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JCoordinateList]]{def handle(x: AsyncResult[JCoordinateList]) {resultHandler.handle(AsyncResultWrapper[JCoordinateList, CoordinateList](x, a => CoordinateList(a)))}}))
    this
  }


  override 
  def coordinateNodesWithOptions(options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[CoordinateList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].coordinateNodesWithOptions(options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JCoordinateList]]{def handle(x: AsyncResult[JCoordinateList]) {resultHandler.handle(AsyncResultWrapper[JCoordinateList, CoordinateList](x, a => CoordinateList(a)))}}))
    this
  }


  override 
  def coordinateDatacenters(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[DcCoordinates]]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].coordinateDatacenters((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JDcCoordinates]]]{def handle(x: AsyncResult[java.util.List[JDcCoordinates]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[JDcCoordinates], scala.collection.mutable.Buffer[DcCoordinates]](x, a => a.asScala.map(x => DcCoordinates(x))))}}))
    this
  }


  override 
  def getKeys(keyPrefix: String, resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].getKeys(keyPrefix.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }


  override 
  def getKeysWithOptions(keyPrefix: String, options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].getKeysWithOptions(keyPrefix.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }


  override 
  def getValue(key: String, resultHandler: Handler[AsyncResult[KeyValue]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].getValue(key.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JKeyValue]]{def handle(x: AsyncResult[JKeyValue]) {resultHandler.handle(AsyncResultWrapper[JKeyValue, KeyValue](x, a => KeyValue(a)))}}))
    this
  }


  override 
  def getValueWithOptions(key: String, options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[KeyValue]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].getValueWithOptions(key.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JKeyValue]]{def handle(x: AsyncResult[JKeyValue]) {resultHandler.handle(AsyncResultWrapper[JKeyValue, KeyValue](x, a => KeyValue(a)))}}))
    this
  }


  override 
  def deleteValue(key: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].deleteValue(key.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def getValues(keyPrefix: String, resultHandler: Handler[AsyncResult[KeyValueList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].getValues(keyPrefix.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JKeyValueList]]{def handle(x: AsyncResult[JKeyValueList]) {resultHandler.handle(AsyncResultWrapper[JKeyValueList, KeyValueList](x, a => KeyValueList(a)))}}))
    this
  }


  override 
  def getValuesWithOptions(keyPrefix: String, options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[KeyValueList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].getValuesWithOptions(keyPrefix.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JKeyValueList]]{def handle(x: AsyncResult[JKeyValueList]) {resultHandler.handle(AsyncResultWrapper[JKeyValueList, KeyValueList](x, a => KeyValueList(a)))}}))
    this
  }


  override 
  def deleteValues(keyPrefix: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].deleteValues(keyPrefix.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def putValue(key: String, value: String, resultHandler: Handler[AsyncResult[Boolean]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].putValue(key.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.Boolean]]{def handle(x: AsyncResult[java.lang.Boolean]) {resultHandler.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))}}))
    this
  }


  override 
  def putValueWithOptions(key: String, value: String, options: KeyValueOptions, resultHandler: Handler[AsyncResult[Boolean]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].putValueWithOptions(key.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.Boolean]]{def handle(x: AsyncResult[java.lang.Boolean]) {resultHandler.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))}}))
    this
  }


  override 
  def transaction(request: TxnRequest, resultHandler: Handler[AsyncResult[TxnResponse]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].transaction(request.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JTxnResponse]]{def handle(x: AsyncResult[JTxnResponse]) {resultHandler.handle(AsyncResultWrapper[JTxnResponse, TxnResponse](x, a => TxnResponse(a)))}}))
    this
  }


  override 
  def createAclToken(token: AclToken, idHandler: Handler[AsyncResult[String]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].createAclToken(token.asJava, (if (idHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {idHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }


  override 
  def updateAclToken(token: AclToken, idHandler: Handler[AsyncResult[String]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].updateAclToken(token.asJava, (if (idHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {idHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }


  override 
  def cloneAclToken(id: String, idHandler: Handler[AsyncResult[String]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].cloneAclToken(id.asInstanceOf[java.lang.String], (if (idHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {idHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }


  override 
  def listAclTokens(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[AclToken]]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].listAclTokens((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JAclToken]]]{def handle(x: AsyncResult[java.util.List[JAclToken]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[JAclToken], scala.collection.mutable.Buffer[AclToken]](x, a => a.asScala.map(x => AclToken(x))))}}))
    this
  }


  override 
  def infoAclToken(id: String, tokenHandler: Handler[AsyncResult[AclToken]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].infoAclToken(id.asInstanceOf[java.lang.String], (if (tokenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JAclToken]]{def handle(x: AsyncResult[JAclToken]) {tokenHandler.handle(AsyncResultWrapper[JAclToken, AclToken](x, a => AclToken(a)))}}))
    this
  }


  override 
  def destroyAclToken(id: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].destroyAclToken(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def fireEvent(name: String, resultHandler: Handler[AsyncResult[Event]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].fireEvent(name.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JEvent]]{def handle(x: AsyncResult[JEvent]) {resultHandler.handle(AsyncResultWrapper[JEvent, Event](x, a => Event(a)))}}))
    this
  }


  override 
  def fireEventWithOptions(name: String, options: EventOptions, resultHandler: Handler[AsyncResult[Event]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].fireEventWithOptions(name.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JEvent]]{def handle(x: AsyncResult[JEvent]) {resultHandler.handle(AsyncResultWrapper[JEvent, Event](x, a => Event(a)))}}))
    this
  }


  override 
  def listEvents(resultHandler: Handler[AsyncResult[EventList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].listEvents((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JEventList]]{def handle(x: AsyncResult[JEventList]) {resultHandler.handle(AsyncResultWrapper[JEventList, EventList](x, a => EventList(a)))}}))
    this
  }


  override 
  def listEventsWithOptions(options: EventListOptions, resultHandler: Handler[AsyncResult[EventList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].listEventsWithOptions(options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JEventList]]{def handle(x: AsyncResult[JEventList]) {resultHandler.handle(AsyncResultWrapper[JEventList, EventList](x, a => EventList(a)))}}))
    this
  }


  override 
  def registerService(serviceOptions: ServiceOptions, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].registerService(serviceOptions.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def maintenanceService(maintenanceOptions: MaintenanceOptions, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].maintenanceService(maintenanceOptions.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def deregisterService(id: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].deregisterService(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def healthChecks(service: String, resultHandler: Handler[AsyncResult[CheckList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].healthChecks(service.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JCheckList]]{def handle(x: AsyncResult[JCheckList]) {resultHandler.handle(AsyncResultWrapper[JCheckList, CheckList](x, a => CheckList(a)))}}))
    this
  }


  override 
  def healthChecksWithOptions(service: String, options: CheckQueryOptions, resultHandler: Handler[AsyncResult[CheckList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].healthChecksWithOptions(service.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JCheckList]]{def handle(x: AsyncResult[JCheckList]) {resultHandler.handle(AsyncResultWrapper[JCheckList, CheckList](x, a => CheckList(a)))}}))
    this
  }


  override 
  def healthState(healthState: io.vertx.ext.consul.HealthState, handler: Handler[AsyncResult[CheckList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].healthState(healthState, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JCheckList]]{def handle(x: AsyncResult[JCheckList]) {handler.handle(AsyncResultWrapper[JCheckList, CheckList](x, a => CheckList(a)))}}))
    this
  }


  override 
  def healthStateWithOptions(healthState: io.vertx.ext.consul.HealthState, checkQueryOptions: CheckQueryOptions, handler: Handler[AsyncResult[CheckList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].healthStateWithOptions(healthState, checkQueryOptions.asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JCheckList]]{def handle(x: AsyncResult[JCheckList]) {handler.handle(AsyncResultWrapper[JCheckList, CheckList](x, a => CheckList(a)))}}))
    this
  }


  override 
  def healthServiceNodes(service: String, passing: Boolean, resultHandler: Handler[AsyncResult[ServiceEntryList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].healthServiceNodes(service.asInstanceOf[java.lang.String], passing.asInstanceOf[java.lang.Boolean], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceEntryList]]{def handle(x: AsyncResult[JServiceEntryList]) {resultHandler.handle(AsyncResultWrapper[JServiceEntryList, ServiceEntryList](x, a => ServiceEntryList(a)))}}))
    this
  }


  override 
  def healthServiceNodesWithOptions(service: String, passing: Boolean, options: ServiceQueryOptions, resultHandler: Handler[AsyncResult[ServiceEntryList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].healthServiceNodesWithOptions(service.asInstanceOf[java.lang.String], passing.asInstanceOf[java.lang.Boolean], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceEntryList]]{def handle(x: AsyncResult[JServiceEntryList]) {resultHandler.handle(AsyncResultWrapper[JServiceEntryList, ServiceEntryList](x, a => ServiceEntryList(a)))}}))
    this
  }


  override 
  def catalogServiceNodes(service: String, resultHandler: Handler[AsyncResult[ServiceList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].catalogServiceNodes(service.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceList]]{def handle(x: AsyncResult[JServiceList]) {resultHandler.handle(AsyncResultWrapper[JServiceList, ServiceList](x, a => ServiceList(a)))}}))
    this
  }


  override 
  def catalogServiceNodesWithOptions(service: String, options: ServiceQueryOptions, resultHandler: Handler[AsyncResult[ServiceList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].catalogServiceNodesWithOptions(service.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceList]]{def handle(x: AsyncResult[JServiceList]) {resultHandler.handle(AsyncResultWrapper[JServiceList, ServiceList](x, a => ServiceList(a)))}}))
    this
  }


  override 
  def catalogDatacenters(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].catalogDatacenters((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }


  override 
  def catalogNodes(resultHandler: Handler[AsyncResult[NodeList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].catalogNodes((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JNodeList]]{def handle(x: AsyncResult[JNodeList]) {resultHandler.handle(AsyncResultWrapper[JNodeList, NodeList](x, a => NodeList(a)))}}))
    this
  }


  override 
  def catalogNodesWithOptions(options: NodeQueryOptions, resultHandler: Handler[AsyncResult[NodeList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].catalogNodesWithOptions(options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JNodeList]]{def handle(x: AsyncResult[JNodeList]) {resultHandler.handle(AsyncResultWrapper[JNodeList, NodeList](x, a => NodeList(a)))}}))
    this
  }


  override 
  def catalogServices(resultHandler: Handler[AsyncResult[ServiceList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].catalogServices((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceList]]{def handle(x: AsyncResult[JServiceList]) {resultHandler.handle(AsyncResultWrapper[JServiceList, ServiceList](x, a => ServiceList(a)))}}))
    this
  }


  override 
  def catalogServicesWithOptions(options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[ServiceList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].catalogServicesWithOptions(options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceList]]{def handle(x: AsyncResult[JServiceList]) {resultHandler.handle(AsyncResultWrapper[JServiceList, ServiceList](x, a => ServiceList(a)))}}))
    this
  }


  override 
  def localServices(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[Service]]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].localServices((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JService]]]{def handle(x: AsyncResult[java.util.List[JService]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[JService], scala.collection.mutable.Buffer[Service]](x, a => a.asScala.map(x => Service(x))))}}))
    this
  }


  override 
  def catalogNodeServices(node: String, resultHandler: Handler[AsyncResult[ServiceList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].catalogNodeServices(node.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceList]]{def handle(x: AsyncResult[JServiceList]) {resultHandler.handle(AsyncResultWrapper[JServiceList, ServiceList](x, a => ServiceList(a)))}}))
    this
  }


  override 
  def catalogNodeServicesWithOptions(node: String, options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[ServiceList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].catalogNodeServicesWithOptions(node.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JServiceList]]{def handle(x: AsyncResult[JServiceList]) {resultHandler.handle(AsyncResultWrapper[JServiceList, ServiceList](x, a => ServiceList(a)))}}))
    this
  }


  override 
  def localChecks(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[Check]]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].localChecks((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JCheck]]]{def handle(x: AsyncResult[java.util.List[JCheck]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[JCheck], scala.collection.mutable.Buffer[Check]](x, a => a.asScala.map(x => Check(x))))}}))
    this
  }


  override 
  def registerCheck(checkOptions: CheckOptions, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].registerCheck(checkOptions.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def deregisterCheck(checkId: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].deregisterCheck(checkId.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def passCheck(checkId: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].passCheck(checkId.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def passCheckWithNote(checkId: String, note: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].passCheckWithNote(checkId.asInstanceOf[java.lang.String], note.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def warnCheck(checkId: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].warnCheck(checkId.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def warnCheckWithNote(checkId: String, note: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].warnCheckWithNote(checkId.asInstanceOf[java.lang.String], note.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def failCheck(checkId: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].failCheck(checkId.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def failCheckWithNote(checkId: String, note: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].failCheckWithNote(checkId.asInstanceOf[java.lang.String], note.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def updateCheck(checkId: String, status: io.vertx.ext.consul.CheckStatus, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].updateCheck(checkId.asInstanceOf[java.lang.String], status, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def updateCheckWithNote(checkId: String, status: io.vertx.ext.consul.CheckStatus, note: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].updateCheckWithNote(checkId.asInstanceOf[java.lang.String], status, note.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def leaderStatus(resultHandler: Handler[AsyncResult[String]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].leaderStatus((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {resultHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }


  override 
  def peersStatus(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].peersStatus((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.String]]]{def handle(x: AsyncResult[java.util.List[java.lang.String]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
    this
  }


  override 
  def createSession(idHandler: Handler[AsyncResult[String]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].createSession((if (idHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {idHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }


  override 
  def createSessionWithOptions(options: SessionOptions, idHandler: Handler[AsyncResult[String]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].createSessionWithOptions(options.asJava, (if (idHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {idHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }


  override 
  def infoSession(id: String, resultHandler: Handler[AsyncResult[Session]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].infoSession(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSession]]{def handle(x: AsyncResult[JSession]) {resultHandler.handle(AsyncResultWrapper[JSession, Session](x, a => Session(a)))}}))
    this
  }


  override 
  def infoSessionWithOptions(id: String, options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[Session]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].infoSessionWithOptions(id.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSession]]{def handle(x: AsyncResult[JSession]) {resultHandler.handle(AsyncResultWrapper[JSession, Session](x, a => Session(a)))}}))
    this
  }


  override 
  def renewSession(id: String, resultHandler: Handler[AsyncResult[Session]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].renewSession(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSession]]{def handle(x: AsyncResult[JSession]) {resultHandler.handle(AsyncResultWrapper[JSession, Session](x, a => Session(a)))}}))
    this
  }


  override 
  def listSessions(resultHandler: Handler[AsyncResult[SessionList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].listSessions((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSessionList]]{def handle(x: AsyncResult[JSessionList]) {resultHandler.handle(AsyncResultWrapper[JSessionList, SessionList](x, a => SessionList(a)))}}))
    this
  }


  override 
  def listSessionsWithOptions(options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[SessionList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].listSessionsWithOptions(options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSessionList]]{def handle(x: AsyncResult[JSessionList]) {resultHandler.handle(AsyncResultWrapper[JSessionList, SessionList](x, a => SessionList(a)))}}))
    this
  }


  override 
  def listNodeSessions(nodeId: String, resultHandler: Handler[AsyncResult[SessionList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].listNodeSessions(nodeId.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSessionList]]{def handle(x: AsyncResult[JSessionList]) {resultHandler.handle(AsyncResultWrapper[JSessionList, SessionList](x, a => SessionList(a)))}}))
    this
  }


  override 
  def listNodeSessionsWithOptions(nodeId: String, options: BlockingQueryOptions, resultHandler: Handler[AsyncResult[SessionList]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].listNodeSessionsWithOptions(nodeId.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JSessionList]]{def handle(x: AsyncResult[JSessionList]) {resultHandler.handle(AsyncResultWrapper[JSessionList, SessionList](x, a => SessionList(a)))}}))
    this
  }


  override 
  def destroySession(id: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].destroySession(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def createPreparedQuery(definition: PreparedQueryDefinition, resultHandler: Handler[AsyncResult[String]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].createPreparedQuery(definition.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {resultHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }


  override 
  def getPreparedQuery(id: String, resultHandler: Handler[AsyncResult[PreparedQueryDefinition]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].getPreparedQuery(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JPreparedQueryDefinition]]{def handle(x: AsyncResult[JPreparedQueryDefinition]) {resultHandler.handle(AsyncResultWrapper[JPreparedQueryDefinition, PreparedQueryDefinition](x, a => PreparedQueryDefinition(a)))}}))
    this
  }


  override 
  def getAllPreparedQueries(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[PreparedQueryDefinition]]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].getAllPreparedQueries((if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JPreparedQueryDefinition]]]{def handle(x: AsyncResult[java.util.List[JPreparedQueryDefinition]]) {resultHandler.handle(AsyncResultWrapper[java.util.List[JPreparedQueryDefinition], scala.collection.mutable.Buffer[PreparedQueryDefinition]](x, a => a.asScala.map(x => PreparedQueryDefinition(x))))}}))
    this
  }


  override 
  def updatePreparedQuery(definition: PreparedQueryDefinition, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].updatePreparedQuery(definition.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def deletePreparedQuery(id: String, resultHandler: Handler[AsyncResult[Unit]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].deletePreparedQuery(id.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def executePreparedQuery(query: String, resultHandler: Handler[AsyncResult[PreparedQueryExecuteResponse]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].executePreparedQuery(query.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JPreparedQueryExecuteResponse]]{def handle(x: AsyncResult[JPreparedQueryExecuteResponse]) {resultHandler.handle(AsyncResultWrapper[JPreparedQueryExecuteResponse, PreparedQueryExecuteResponse](x, a => PreparedQueryExecuteResponse(a)))}}))
    this
  }


  override 
  def executePreparedQueryWithOptions(query: String, options: PreparedQueryExecuteOptions, resultHandler: Handler[AsyncResult[PreparedQueryExecuteResponse]]): ConsulService = {
    asJava.asInstanceOf[JConsulService].executePreparedQueryWithOptions(query.asInstanceOf[java.lang.String], options.asJava, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JPreparedQueryExecuteResponse]]{def handle(x: AsyncResult[JPreparedQueryExecuteResponse]) {resultHandler.handle(AsyncResultWrapper[JPreparedQueryExecuteResponse, PreparedQueryExecuteResponse](x, a => PreparedQueryExecuteResponse(a)))}}))
    this
  }




  override def close (): Unit = {
    asJava.asInstanceOf[JConsulService].close()
  }



  override def agentInfoFuture (): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JConsulService].agentInfo(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def coordinateNodesFuture (): scala.concurrent.Future[CoordinateList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCoordinateList, CoordinateList](x => CoordinateList(x))
    asJava.asInstanceOf[JConsulService].coordinateNodes(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def coordinateNodesWithOptionsFuture (options: BlockingQueryOptions): scala.concurrent.Future[CoordinateList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCoordinateList, CoordinateList](x => CoordinateList(x))
    asJava.asInstanceOf[JConsulService].coordinateNodesWithOptions(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def coordinateDatacentersFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[DcCoordinates]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JDcCoordinates], scala.collection.mutable.Buffer[DcCoordinates]](x => x.asScala.map(x => DcCoordinates(x)))
    asJava.asInstanceOf[JConsulService].coordinateDatacenters(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def getKeysFuture (keyPrefix: String): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JConsulService].getKeys(keyPrefix.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def getKeysWithOptionsFuture (keyPrefix: String, options: BlockingQueryOptions): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JConsulService].getKeysWithOptions(keyPrefix.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def getValueFuture (key: String): scala.concurrent.Future[KeyValue] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JKeyValue, KeyValue](x => KeyValue(x))
    asJava.asInstanceOf[JConsulService].getValue(key.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def getValueWithOptionsFuture (key: String, options: BlockingQueryOptions): scala.concurrent.Future[KeyValue] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JKeyValue, KeyValue](x => KeyValue(x))
    asJava.asInstanceOf[JConsulService].getValueWithOptions(key.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def deleteValueFuture (key: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].deleteValue(key.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def getValuesFuture (keyPrefix: String): scala.concurrent.Future[KeyValueList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JKeyValueList, KeyValueList](x => KeyValueList(x))
    asJava.asInstanceOf[JConsulService].getValues(keyPrefix.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def getValuesWithOptionsFuture (keyPrefix: String, options: BlockingQueryOptions): scala.concurrent.Future[KeyValueList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JKeyValueList, KeyValueList](x => KeyValueList(x))
    asJava.asInstanceOf[JConsulService].getValuesWithOptions(keyPrefix.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def deleteValuesFuture (keyPrefix: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].deleteValues(keyPrefix.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def putValueFuture (key: String, value: String): scala.concurrent.Future[Boolean] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JConsulService].putValue(key.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def putValueWithOptionsFuture (key: String, value: String, options: KeyValueOptions): scala.concurrent.Future[Boolean] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JConsulService].putValueWithOptions(key.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def transactionFuture (request: TxnRequest): scala.concurrent.Future[TxnResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JTxnResponse, TxnResponse](x => TxnResponse(x))
    asJava.asInstanceOf[JConsulService].transaction(request.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def createAclTokenFuture (token: AclToken): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulService].createAclToken(token.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def updateAclTokenFuture (token: AclToken): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulService].updateAclToken(token.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def cloneAclTokenFuture (id: String): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulService].cloneAclToken(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def listAclTokensFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[AclToken]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JAclToken], scala.collection.mutable.Buffer[AclToken]](x => x.asScala.map(x => AclToken(x)))
    asJava.asInstanceOf[JConsulService].listAclTokens(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def infoAclTokenFuture (id: String): scala.concurrent.Future[AclToken] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAclToken, AclToken](x => AclToken(x))
    asJava.asInstanceOf[JConsulService].infoAclToken(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def destroyAclTokenFuture (id: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].destroyAclToken(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def fireEventFuture (name: String): scala.concurrent.Future[Event] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JEvent, Event](x => Event(x))
    asJava.asInstanceOf[JConsulService].fireEvent(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def fireEventWithOptionsFuture (name: String, options: EventOptions): scala.concurrent.Future[Event] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JEvent, Event](x => Event(x))
    asJava.asInstanceOf[JConsulService].fireEventWithOptions(name.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def listEventsFuture (): scala.concurrent.Future[EventList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JEventList, EventList](x => EventList(x))
    asJava.asInstanceOf[JConsulService].listEvents(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def listEventsWithOptionsFuture (options: EventListOptions): scala.concurrent.Future[EventList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JEventList, EventList](x => EventList(x))
    asJava.asInstanceOf[JConsulService].listEventsWithOptions(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def registerServiceFuture (serviceOptions: ServiceOptions): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].registerService(serviceOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def maintenanceServiceFuture (maintenanceOptions: MaintenanceOptions): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].maintenanceService(maintenanceOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def deregisterServiceFuture (id: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].deregisterService(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def healthChecksFuture (service: String): scala.concurrent.Future[CheckList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCheckList, CheckList](x => CheckList(x))
    asJava.asInstanceOf[JConsulService].healthChecks(service.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def healthChecksWithOptionsFuture (service: String, options: CheckQueryOptions): scala.concurrent.Future[CheckList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCheckList, CheckList](x => CheckList(x))
    asJava.asInstanceOf[JConsulService].healthChecksWithOptions(service.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def healthStateFuture (healthState: io.vertx.ext.consul.HealthState): scala.concurrent.Future[CheckList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCheckList, CheckList](x => CheckList(x))
    asJava.asInstanceOf[JConsulService].healthState(healthState, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def healthStateWithOptionsFuture (healthState: io.vertx.ext.consul.HealthState, checkQueryOptions: CheckQueryOptions): scala.concurrent.Future[CheckList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCheckList, CheckList](x => CheckList(x))
    asJava.asInstanceOf[JConsulService].healthStateWithOptions(healthState, checkQueryOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def healthServiceNodesFuture (service: String, passing: Boolean): scala.concurrent.Future[ServiceEntryList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceEntryList, ServiceEntryList](x => ServiceEntryList(x))
    asJava.asInstanceOf[JConsulService].healthServiceNodes(service.asInstanceOf[java.lang.String], passing.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def healthServiceNodesWithOptionsFuture (service: String, passing: Boolean, options: ServiceQueryOptions): scala.concurrent.Future[ServiceEntryList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceEntryList, ServiceEntryList](x => ServiceEntryList(x))
    asJava.asInstanceOf[JConsulService].healthServiceNodesWithOptions(service.asInstanceOf[java.lang.String], passing.asInstanceOf[java.lang.Boolean], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def catalogServiceNodesFuture (service: String): scala.concurrent.Future[ServiceList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceList, ServiceList](x => ServiceList(x))
    asJava.asInstanceOf[JConsulService].catalogServiceNodes(service.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def catalogServiceNodesWithOptionsFuture (service: String, options: ServiceQueryOptions): scala.concurrent.Future[ServiceList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceList, ServiceList](x => ServiceList(x))
    asJava.asInstanceOf[JConsulService].catalogServiceNodesWithOptions(service.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def catalogDatacentersFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JConsulService].catalogDatacenters(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def catalogNodesFuture (): scala.concurrent.Future[NodeList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNodeList, NodeList](x => NodeList(x))
    asJava.asInstanceOf[JConsulService].catalogNodes(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def catalogNodesWithOptionsFuture (options: NodeQueryOptions): scala.concurrent.Future[NodeList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNodeList, NodeList](x => NodeList(x))
    asJava.asInstanceOf[JConsulService].catalogNodesWithOptions(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def catalogServicesFuture (): scala.concurrent.Future[ServiceList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceList, ServiceList](x => ServiceList(x))
    asJava.asInstanceOf[JConsulService].catalogServices(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def catalogServicesWithOptionsFuture (options: BlockingQueryOptions): scala.concurrent.Future[ServiceList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceList, ServiceList](x => ServiceList(x))
    asJava.asInstanceOf[JConsulService].catalogServicesWithOptions(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def localServicesFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[Service]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JService], scala.collection.mutable.Buffer[Service]](x => x.asScala.map(x => Service(x)))
    asJava.asInstanceOf[JConsulService].localServices(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def catalogNodeServicesFuture (node: String): scala.concurrent.Future[ServiceList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceList, ServiceList](x => ServiceList(x))
    asJava.asInstanceOf[JConsulService].catalogNodeServices(node.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def catalogNodeServicesWithOptionsFuture (node: String, options: BlockingQueryOptions): scala.concurrent.Future[ServiceList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JServiceList, ServiceList](x => ServiceList(x))
    asJava.asInstanceOf[JConsulService].catalogNodeServicesWithOptions(node.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def localChecksFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[Check]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JCheck], scala.collection.mutable.Buffer[Check]](x => x.asScala.map(x => Check(x)))
    asJava.asInstanceOf[JConsulService].localChecks(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def registerCheckFuture (checkOptions: CheckOptions): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].registerCheck(checkOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def deregisterCheckFuture (checkId: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].deregisterCheck(checkId.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def passCheckFuture (checkId: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].passCheck(checkId.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def passCheckWithNoteFuture (checkId: String, note: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].passCheckWithNote(checkId.asInstanceOf[java.lang.String], note.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def warnCheckFuture (checkId: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].warnCheck(checkId.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def warnCheckWithNoteFuture (checkId: String, note: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].warnCheckWithNote(checkId.asInstanceOf[java.lang.String], note.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def failCheckFuture (checkId: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].failCheck(checkId.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def failCheckWithNoteFuture (checkId: String, note: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].failCheckWithNote(checkId.asInstanceOf[java.lang.String], note.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def updateCheckFuture (checkId: String, status: io.vertx.ext.consul.CheckStatus): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].updateCheck(checkId.asInstanceOf[java.lang.String], status, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def updateCheckWithNoteFuture (checkId: String, status: io.vertx.ext.consul.CheckStatus, note: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].updateCheckWithNote(checkId.asInstanceOf[java.lang.String], status, note.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def leaderStatusFuture (): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulService].leaderStatus(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def peersStatusFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JConsulService].peersStatus(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def createSessionFuture (): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulService].createSession(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def createSessionWithOptionsFuture (options: SessionOptions): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulService].createSessionWithOptions(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def infoSessionFuture (id: String): scala.concurrent.Future[Session] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSession, Session](x => Session(x))
    asJava.asInstanceOf[JConsulService].infoSession(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def infoSessionWithOptionsFuture (id: String, options: BlockingQueryOptions): scala.concurrent.Future[Session] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSession, Session](x => Session(x))
    asJava.asInstanceOf[JConsulService].infoSessionWithOptions(id.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def renewSessionFuture (id: String): scala.concurrent.Future[Session] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSession, Session](x => Session(x))
    asJava.asInstanceOf[JConsulService].renewSession(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def listSessionsFuture (): scala.concurrent.Future[SessionList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSessionList, SessionList](x => SessionList(x))
    asJava.asInstanceOf[JConsulService].listSessions(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def listSessionsWithOptionsFuture (options: BlockingQueryOptions): scala.concurrent.Future[SessionList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSessionList, SessionList](x => SessionList(x))
    asJava.asInstanceOf[JConsulService].listSessionsWithOptions(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def listNodeSessionsFuture (nodeId: String): scala.concurrent.Future[SessionList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSessionList, SessionList](x => SessionList(x))
    asJava.asInstanceOf[JConsulService].listNodeSessions(nodeId.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def listNodeSessionsWithOptionsFuture (nodeId: String, options: BlockingQueryOptions): scala.concurrent.Future[SessionList] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSessionList, SessionList](x => SessionList(x))
    asJava.asInstanceOf[JConsulService].listNodeSessionsWithOptions(nodeId.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def destroySessionFuture (id: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].destroySession(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def createPreparedQueryFuture (definition: PreparedQueryDefinition): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JConsulService].createPreparedQuery(definition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def getPreparedQueryFuture (id: String): scala.concurrent.Future[PreparedQueryDefinition] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JPreparedQueryDefinition, PreparedQueryDefinition](x => PreparedQueryDefinition(x))
    asJava.asInstanceOf[JConsulService].getPreparedQuery(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def getAllPreparedQueriesFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[PreparedQueryDefinition]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JPreparedQueryDefinition], scala.collection.mutable.Buffer[PreparedQueryDefinition]](x => x.asScala.map(x => PreparedQueryDefinition(x)))
    asJava.asInstanceOf[JConsulService].getAllPreparedQueries(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def updatePreparedQueryFuture (definition: PreparedQueryDefinition): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].updatePreparedQuery(definition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def deletePreparedQueryFuture (id: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JConsulService].deletePreparedQuery(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def executePreparedQueryFuture (query: String): scala.concurrent.Future[PreparedQueryExecuteResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JPreparedQueryExecuteResponse, PreparedQueryExecuteResponse](x => PreparedQueryExecuteResponse(x))
    asJava.asInstanceOf[JConsulService].executePreparedQuery(query.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def executePreparedQueryWithOptionsFuture (query: String, options: PreparedQueryExecuteOptions): scala.concurrent.Future[PreparedQueryExecuteResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JPreparedQueryExecuteResponse, PreparedQueryExecuteResponse](x => PreparedQueryExecuteResponse(x))
    asJava.asInstanceOf[JConsulService].executePreparedQueryWithOptions(query.asInstanceOf[java.lang.String], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object ConsulService {
  def apply(asJava: JConsulService) = new ConsulService(asJava)

  /**
   * Create a proxy to a service that is deployed somewhere on the event bus   * @param vertx the Vert.x instance
   * @param address the address the service is listening on on the event bus
   * @return the service
   */
  def createEventBusProxy(vertx: Vertx,address: String): ConsulService = {
    ConsulService(JConsulService.createEventBusProxy(vertx.asJava.asInstanceOf[JVertx], address.asInstanceOf[java.lang.String]))//2 createEventBusProxy
  }

}
