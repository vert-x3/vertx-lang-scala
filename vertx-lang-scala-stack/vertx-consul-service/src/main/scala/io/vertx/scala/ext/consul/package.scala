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

import io.vertx.ext.consul.HealthState
import io.vertx.ext.consul.{KeyValueOptions => JKeyValueOptions}
import io.vertx.ext.consul.{PreparedQueryExecuteOptions => JPreparedQueryExecuteOptions}
import io.vertx.ext.consul.{ConsulService => JConsulService}
import io.vertx.core
import io.vertx.ext.consul.{TxnRequest => JTxnRequest}
import io.vertx.ext.consul.{AclToken => JAclToken}
import io.vertx.ext.consul.{CheckOptions => JCheckOptions}
import io.vertx.ext.consul.{Service => JService}
import io.vertx.ext.consul.{DcCoordinates => JDcCoordinates}
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
import io.vertx.ext.consul.{PreparedQueryExecuteResponse => JPreparedQueryExecuteResponse}
import io.vertx.ext.consul.{ServiceEntryList => JServiceEntryList}
import io.vertx.ext.consul.{KeyValueList => JKeyValueList}
import io.vertx.ext.consul.{Event => JEvent}
import io.vertx.ext.consul.{Session => JSession}
import io.vertx.core.Handler
import io.vertx.ext.consul.{KeyValue => JKeyValue}
import io.vertx.ext.consul.{BlockingQueryOptions => JBlockingQueryOptions}

package object consul{



  implicit class ConsulServiceScala(val asJava: io.vertx.ext.consul.ConsulService) extends AnyVal {

    def agentInfoFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.agentInfo({a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def coordinateNodesFuture(): scala.concurrent.Future[io.vertx.ext.consul.CoordinateList] = {
      val promise = Promise[io.vertx.ext.consul.CoordinateList]()
      asJava.coordinateNodes({a:AsyncResult[io.vertx.ext.consul.CoordinateList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def coordinateNodesWithOptionsFuture(options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.CoordinateList] = {
      val promise = Promise[io.vertx.ext.consul.CoordinateList]()
      asJava.coordinateNodesWithOptions(options, {a:AsyncResult[io.vertx.ext.consul.CoordinateList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def coordinateDatacentersFuture(): scala.concurrent.Future[java.util.List[io.vertx.ext.consul.DcCoordinates]] = {
      val promise = Promise[java.util.List[io.vertx.ext.consul.DcCoordinates]]()
      asJava.coordinateDatacenters({a:AsyncResult[java.util.List[io.vertx.ext.consul.DcCoordinates]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getKeysFuture(keyPrefix: java.lang.String): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.getKeys(keyPrefix, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getKeysWithOptionsFuture(keyPrefix: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.getKeysWithOptions(keyPrefix, options, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getValueFuture(key: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.KeyValue] = {
      val promise = Promise[io.vertx.ext.consul.KeyValue]()
      asJava.getValue(key, {a:AsyncResult[io.vertx.ext.consul.KeyValue] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getValueWithOptionsFuture(key: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.KeyValue] = {
      val promise = Promise[io.vertx.ext.consul.KeyValue]()
      asJava.getValueWithOptions(key, options, {a:AsyncResult[io.vertx.ext.consul.KeyValue] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def deleteValueFuture(key: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.deleteValue(key, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getValuesFuture(keyPrefix: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.KeyValueList] = {
      val promise = Promise[io.vertx.ext.consul.KeyValueList]()
      asJava.getValues(keyPrefix, {a:AsyncResult[io.vertx.ext.consul.KeyValueList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getValuesWithOptionsFuture(keyPrefix: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.KeyValueList] = {
      val promise = Promise[io.vertx.ext.consul.KeyValueList]()
      asJava.getValuesWithOptions(keyPrefix, options, {a:AsyncResult[io.vertx.ext.consul.KeyValueList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def deleteValuesFuture(keyPrefix: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.deleteValues(keyPrefix, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def putValueFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.putValue(key, value, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def putValueWithOptionsFuture(key: java.lang.String,value: java.lang.String,options: io.vertx.ext.consul.KeyValueOptions): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = Promise[java.lang.Boolean]()
      asJava.putValueWithOptions(key, value, options, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def transactionFuture(request: io.vertx.ext.consul.TxnRequest): scala.concurrent.Future[io.vertx.ext.consul.TxnResponse] = {
      val promise = Promise[io.vertx.ext.consul.TxnResponse]()
      asJava.transaction(request, {a:AsyncResult[io.vertx.ext.consul.TxnResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def createAclTokenFuture(token: io.vertx.ext.consul.AclToken): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.createAclToken(token, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def updateAclTokenFuture(token: io.vertx.ext.consul.AclToken): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.updateAclToken(token, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def cloneAclTokenFuture(id: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.cloneAclToken(id, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def listAclTokensFuture(): scala.concurrent.Future[java.util.List[io.vertx.ext.consul.AclToken]] = {
      val promise = Promise[java.util.List[io.vertx.ext.consul.AclToken]]()
      asJava.listAclTokens({a:AsyncResult[java.util.List[io.vertx.ext.consul.AclToken]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def infoAclTokenFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.AclToken] = {
      val promise = Promise[io.vertx.ext.consul.AclToken]()
      asJava.infoAclToken(id, {a:AsyncResult[io.vertx.ext.consul.AclToken] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def destroyAclTokenFuture(id: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.destroyAclToken(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def fireEventFuture(name: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.Event] = {
      val promise = Promise[io.vertx.ext.consul.Event]()
      asJava.fireEvent(name, {a:AsyncResult[io.vertx.ext.consul.Event] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def fireEventWithOptionsFuture(name: java.lang.String,options: io.vertx.ext.consul.EventOptions): scala.concurrent.Future[io.vertx.ext.consul.Event] = {
      val promise = Promise[io.vertx.ext.consul.Event]()
      asJava.fireEventWithOptions(name, options, {a:AsyncResult[io.vertx.ext.consul.Event] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def listEventsFuture(): scala.concurrent.Future[io.vertx.ext.consul.EventList] = {
      val promise = Promise[io.vertx.ext.consul.EventList]()
      asJava.listEvents({a:AsyncResult[io.vertx.ext.consul.EventList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def listEventsWithOptionsFuture(options: io.vertx.ext.consul.EventListOptions): scala.concurrent.Future[io.vertx.ext.consul.EventList] = {
      val promise = Promise[io.vertx.ext.consul.EventList]()
      asJava.listEventsWithOptions(options, {a:AsyncResult[io.vertx.ext.consul.EventList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def registerServiceFuture(serviceOptions: io.vertx.ext.consul.ServiceOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.registerService(serviceOptions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def maintenanceServiceFuture(maintenanceOptions: io.vertx.ext.consul.MaintenanceOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.maintenanceService(maintenanceOptions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def deregisterServiceFuture(id: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.deregisterService(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def healthChecksFuture(service: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.CheckList] = {
      val promise = Promise[io.vertx.ext.consul.CheckList]()
      asJava.healthChecks(service, {a:AsyncResult[io.vertx.ext.consul.CheckList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def healthChecksWithOptionsFuture(service: java.lang.String,options: io.vertx.ext.consul.CheckQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.CheckList] = {
      val promise = Promise[io.vertx.ext.consul.CheckList]()
      asJava.healthChecksWithOptions(service, options, {a:AsyncResult[io.vertx.ext.consul.CheckList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def healthStateFuture(healthState: io.vertx.ext.consul.HealthState): scala.concurrent.Future[io.vertx.ext.consul.CheckList] = {
      val promise = Promise[io.vertx.ext.consul.CheckList]()
      asJava.healthState(healthState, {a:AsyncResult[io.vertx.ext.consul.CheckList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def healthStateWithOptionsFuture(healthState: io.vertx.ext.consul.HealthState,checkQueryOptions: io.vertx.ext.consul.CheckQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.CheckList] = {
      val promise = Promise[io.vertx.ext.consul.CheckList]()
      asJava.healthStateWithOptions(healthState, checkQueryOptions, {a:AsyncResult[io.vertx.ext.consul.CheckList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def healthServiceNodesFuture(service: java.lang.String,passing: java.lang.Boolean): scala.concurrent.Future[io.vertx.ext.consul.ServiceEntryList] = {
      val promise = Promise[io.vertx.ext.consul.ServiceEntryList]()
      asJava.healthServiceNodes(service, passing, {a:AsyncResult[io.vertx.ext.consul.ServiceEntryList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def healthServiceNodesWithOptionsFuture(service: java.lang.String,passing: java.lang.Boolean,options: io.vertx.ext.consul.ServiceQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.ServiceEntryList] = {
      val promise = Promise[io.vertx.ext.consul.ServiceEntryList]()
      asJava.healthServiceNodesWithOptions(service, passing, options, {a:AsyncResult[io.vertx.ext.consul.ServiceEntryList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def catalogServiceNodesFuture(service: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogServiceNodes(service, {a:AsyncResult[io.vertx.ext.consul.ServiceList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def catalogServiceNodesWithOptionsFuture(service: java.lang.String,options: io.vertx.ext.consul.ServiceQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogServiceNodesWithOptions(service, options, {a:AsyncResult[io.vertx.ext.consul.ServiceList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def catalogDatacentersFuture(): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.catalogDatacenters({a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def catalogNodesFuture(): scala.concurrent.Future[io.vertx.ext.consul.NodeList] = {
      val promise = Promise[io.vertx.ext.consul.NodeList]()
      asJava.catalogNodes({a:AsyncResult[io.vertx.ext.consul.NodeList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def catalogNodesWithOptionsFuture(options: io.vertx.ext.consul.NodeQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.NodeList] = {
      val promise = Promise[io.vertx.ext.consul.NodeList]()
      asJava.catalogNodesWithOptions(options, {a:AsyncResult[io.vertx.ext.consul.NodeList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def catalogServicesFuture(): scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogServices({a:AsyncResult[io.vertx.ext.consul.ServiceList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def catalogServicesWithOptionsFuture(options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogServicesWithOptions(options, {a:AsyncResult[io.vertx.ext.consul.ServiceList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def localServicesFuture(): scala.concurrent.Future[java.util.List[io.vertx.ext.consul.Service]] = {
      val promise = Promise[java.util.List[io.vertx.ext.consul.Service]]()
      asJava.localServices({a:AsyncResult[java.util.List[io.vertx.ext.consul.Service]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def catalogNodeServicesFuture(node: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogNodeServices(node, {a:AsyncResult[io.vertx.ext.consul.ServiceList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def catalogNodeServicesWithOptionsFuture(node: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogNodeServicesWithOptions(node, options, {a:AsyncResult[io.vertx.ext.consul.ServiceList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def localChecksFuture(): scala.concurrent.Future[java.util.List[io.vertx.ext.consul.Check]] = {
      val promise = Promise[java.util.List[io.vertx.ext.consul.Check]]()
      asJava.localChecks({a:AsyncResult[java.util.List[io.vertx.ext.consul.Check]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def registerCheckFuture(checkOptions: io.vertx.ext.consul.CheckOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.registerCheck(checkOptions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def deregisterCheckFuture(checkId: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.deregisterCheck(checkId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def passCheckFuture(checkId: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.passCheck(checkId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def passCheckWithNoteFuture(checkId: java.lang.String,note: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.passCheckWithNote(checkId, note, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def warnCheckFuture(checkId: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.warnCheck(checkId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def warnCheckWithNoteFuture(checkId: java.lang.String,note: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.warnCheckWithNote(checkId, note, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def failCheckFuture(checkId: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.failCheck(checkId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def failCheckWithNoteFuture(checkId: java.lang.String,note: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.failCheckWithNote(checkId, note, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def updateCheckFuture(checkId: java.lang.String,status: io.vertx.ext.consul.CheckStatus): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.updateCheck(checkId, status, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def updateCheckWithNoteFuture(checkId: java.lang.String,status: io.vertx.ext.consul.CheckStatus,note: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.updateCheckWithNote(checkId, status, note, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def leaderStatusFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.leaderStatus({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def peersStatusFuture(): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.peersStatus({a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def createSessionFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.createSession({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def createSessionWithOptionsFuture(options: io.vertx.ext.consul.SessionOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.createSessionWithOptions(options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def infoSessionFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.Session] = {
      val promise = Promise[io.vertx.ext.consul.Session]()
      asJava.infoSession(id, {a:AsyncResult[io.vertx.ext.consul.Session] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def infoSessionWithOptionsFuture(id: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.Session] = {
      val promise = Promise[io.vertx.ext.consul.Session]()
      asJava.infoSessionWithOptions(id, options, {a:AsyncResult[io.vertx.ext.consul.Session] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def renewSessionFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.Session] = {
      val promise = Promise[io.vertx.ext.consul.Session]()
      asJava.renewSession(id, {a:AsyncResult[io.vertx.ext.consul.Session] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def listSessionsFuture(): scala.concurrent.Future[io.vertx.ext.consul.SessionList] = {
      val promise = Promise[io.vertx.ext.consul.SessionList]()
      asJava.listSessions({a:AsyncResult[io.vertx.ext.consul.SessionList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def listSessionsWithOptionsFuture(options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.SessionList] = {
      val promise = Promise[io.vertx.ext.consul.SessionList]()
      asJava.listSessionsWithOptions(options, {a:AsyncResult[io.vertx.ext.consul.SessionList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def listNodeSessionsFuture(nodeId: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.SessionList] = {
      val promise = Promise[io.vertx.ext.consul.SessionList]()
      asJava.listNodeSessions(nodeId, {a:AsyncResult[io.vertx.ext.consul.SessionList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def listNodeSessionsWithOptionsFuture(nodeId: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.SessionList] = {
      val promise = Promise[io.vertx.ext.consul.SessionList]()
      asJava.listNodeSessionsWithOptions(nodeId, options, {a:AsyncResult[io.vertx.ext.consul.SessionList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def destroySessionFuture(id: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.destroySession(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def createPreparedQueryFuture(definition: io.vertx.ext.consul.PreparedQueryDefinition): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.createPreparedQuery(definition, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getPreparedQueryFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.PreparedQueryDefinition] = {
      val promise = Promise[io.vertx.ext.consul.PreparedQueryDefinition]()
      asJava.getPreparedQuery(id, {a:AsyncResult[io.vertx.ext.consul.PreparedQueryDefinition] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getAllPreparedQueriesFuture(): scala.concurrent.Future[java.util.List[io.vertx.ext.consul.PreparedQueryDefinition]] = {
      val promise = Promise[java.util.List[io.vertx.ext.consul.PreparedQueryDefinition]]()
      asJava.getAllPreparedQueries({a:AsyncResult[java.util.List[io.vertx.ext.consul.PreparedQueryDefinition]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def updatePreparedQueryFuture(definition: io.vertx.ext.consul.PreparedQueryDefinition): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.updatePreparedQuery(definition, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def deletePreparedQueryFuture(id: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.deletePreparedQuery(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def executePreparedQueryFuture(query: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.PreparedQueryExecuteResponse] = {
      val promise = Promise[io.vertx.ext.consul.PreparedQueryExecuteResponse]()
      asJava.executePreparedQuery(query, {a:AsyncResult[io.vertx.ext.consul.PreparedQueryExecuteResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def executePreparedQueryWithOptionsFuture(query: java.lang.String,options: io.vertx.ext.consul.PreparedQueryExecuteOptions): scala.concurrent.Future[io.vertx.ext.consul.PreparedQueryExecuteResponse] = {
      val promise = Promise[io.vertx.ext.consul.PreparedQueryExecuteResponse]()
      asJava.executePreparedQueryWithOptions(query, options, {a:AsyncResult[io.vertx.ext.consul.PreparedQueryExecuteResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

}
