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
import io.vertx.core
import io.vertx.ext.consul.{TxnRequest => JTxnRequest}
import io.vertx.ext.consul.{AclToken => JAclToken}
import io.vertx.ext.consul.{CheckOptions => JCheckOptions}
import io.vertx.ext.consul.{ConsulClientOptions => JConsulClientOptions}
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
import io.vertx.core.{Future => JFuture}
import io.vertx.ext.consul.{Session => JSession}
import io.vertx.core.Handler
import io.vertx.ext.consul.{KeyValue => JKeyValue}
import io.vertx.ext.consul.{BlockingQueryOptions => JBlockingQueryOptions}

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




  /**
    * A Vert.x service used to interact with Consul.
    */

  implicit class ConsulClientScala(val asJava: io.vertx.ext.consul.ConsulClient) extends AnyVal {

    /**
     * Like [[agentInfo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def agentInfoFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]()
      asJava.agentInfo({a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[coordinateNodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def coordinateNodesFuture(): scala.concurrent.Future[io.vertx.ext.consul.CoordinateList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.CoordinateList]()
      asJava.coordinateNodes({a:AsyncResult[io.vertx.ext.consul.CoordinateList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[coordinateNodesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def coordinateNodesWithOptionsFuture(options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.CoordinateList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.CoordinateList]()
      asJava.coordinateNodesWithOptions(options, {a:AsyncResult[io.vertx.ext.consul.CoordinateList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[coordinateDatacenters]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def coordinateDatacentersFuture(): scala.concurrent.Future[java.util.List[io.vertx.ext.consul.DcCoordinates]] = {
      val promise = concurrent.Promise[java.util.List[io.vertx.ext.consul.DcCoordinates]]()
      asJava.coordinateDatacenters({a:AsyncResult[java.util.List[io.vertx.ext.consul.DcCoordinates]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getKeys]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getKeysFuture(keyPrefix: java.lang.String): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = concurrent.Promise[java.util.List[java.lang.String]]()
      asJava.getKeys(keyPrefix, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getKeysWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getKeysWithOptionsFuture(keyPrefix: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = concurrent.Promise[java.util.List[java.lang.String]]()
      asJava.getKeysWithOptions(keyPrefix, options, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getValue]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getValueFuture(key: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.KeyValue] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.KeyValue]()
      asJava.getValue(key, {a:AsyncResult[io.vertx.ext.consul.KeyValue] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getValueWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getValueWithOptionsFuture(key: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.KeyValue] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.KeyValue]()
      asJava.getValueWithOptions(key, options, {a:AsyncResult[io.vertx.ext.consul.KeyValue] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deleteValue]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteValueFuture(key: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.deleteValue(key, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getValues]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getValuesFuture(keyPrefix: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.KeyValueList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.KeyValueList]()
      asJava.getValues(keyPrefix, {a:AsyncResult[io.vertx.ext.consul.KeyValueList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getValuesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getValuesWithOptionsFuture(keyPrefix: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.KeyValueList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.KeyValueList]()
      asJava.getValuesWithOptions(keyPrefix, options, {a:AsyncResult[io.vertx.ext.consul.KeyValueList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deleteValues]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteValuesFuture(keyPrefix: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.deleteValues(keyPrefix, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[putValue]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putValueFuture(key: java.lang.String,value: java.lang.String): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.putValue(key, value, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[putValueWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def putValueWithOptionsFuture(key: java.lang.String,value: java.lang.String,options: io.vertx.ext.consul.KeyValueOptions): scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.putValueWithOptions(key, value, options, {a:AsyncResult[java.lang.Boolean] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[transaction]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def transactionFuture(request: io.vertx.ext.consul.TxnRequest): scala.concurrent.Future[io.vertx.ext.consul.TxnResponse] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.TxnResponse]()
      asJava.transaction(request, {a:AsyncResult[io.vertx.ext.consul.TxnResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createAclToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createAclTokenFuture(token: io.vertx.ext.consul.AclToken): scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createAclToken(token, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[updateAclToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def updateAclTokenFuture(token: io.vertx.ext.consul.AclToken): scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.updateAclToken(token, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[cloneAclToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def cloneAclTokenFuture(id: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.cloneAclToken(id, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listAclTokens]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listAclTokensFuture(): scala.concurrent.Future[java.util.List[io.vertx.ext.consul.AclToken]] = {
      val promise = concurrent.Promise[java.util.List[io.vertx.ext.consul.AclToken]]()
      asJava.listAclTokens({a:AsyncResult[java.util.List[io.vertx.ext.consul.AclToken]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[infoAclToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def infoAclTokenFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.AclToken] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.AclToken]()
      asJava.infoAclToken(id, {a:AsyncResult[io.vertx.ext.consul.AclToken] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[destroyAclToken]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def destroyAclTokenFuture(id: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.destroyAclToken(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[fireEvent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def fireEventFuture(name: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.Event] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.Event]()
      asJava.fireEvent(name, {a:AsyncResult[io.vertx.ext.consul.Event] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[fireEventWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def fireEventWithOptionsFuture(name: java.lang.String,options: io.vertx.ext.consul.EventOptions): scala.concurrent.Future[io.vertx.ext.consul.Event] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.Event]()
      asJava.fireEventWithOptions(name, options, {a:AsyncResult[io.vertx.ext.consul.Event] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listEvents]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listEventsFuture(): scala.concurrent.Future[io.vertx.ext.consul.EventList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.EventList]()
      asJava.listEvents({a:AsyncResult[io.vertx.ext.consul.EventList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listEventsWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listEventsWithOptionsFuture(options: io.vertx.ext.consul.EventListOptions): scala.concurrent.Future[io.vertx.ext.consul.EventList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.EventList]()
      asJava.listEventsWithOptions(options, {a:AsyncResult[io.vertx.ext.consul.EventList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[registerService]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def registerServiceFuture(serviceOptions: io.vertx.ext.consul.ServiceOptions): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.registerService(serviceOptions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[maintenanceService]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def maintenanceServiceFuture(maintenanceOptions: io.vertx.ext.consul.MaintenanceOptions): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.maintenanceService(maintenanceOptions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deregisterService]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deregisterServiceFuture(id: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.deregisterService(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[catalogServiceNodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def catalogServiceNodesFuture(service: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogServiceNodes(service, {a:AsyncResult[io.vertx.ext.consul.ServiceList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[catalogServiceNodesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def catalogServiceNodesWithOptionsFuture(service: java.lang.String,options: io.vertx.ext.consul.ServiceQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogServiceNodesWithOptions(service, options, {a:AsyncResult[io.vertx.ext.consul.ServiceList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[catalogDatacenters]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def catalogDatacentersFuture(): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = concurrent.Promise[java.util.List[java.lang.String]]()
      asJava.catalogDatacenters({a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[catalogNodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def catalogNodesFuture(): scala.concurrent.Future[io.vertx.ext.consul.NodeList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.NodeList]()
      asJava.catalogNodes({a:AsyncResult[io.vertx.ext.consul.NodeList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[catalogNodesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def catalogNodesWithOptionsFuture(options: io.vertx.ext.consul.NodeQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.NodeList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.NodeList]()
      asJava.catalogNodesWithOptions(options, {a:AsyncResult[io.vertx.ext.consul.NodeList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[healthChecks]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def healthChecksFuture(service: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.CheckList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.CheckList]()
      asJava.healthChecks(service, {a:AsyncResult[io.vertx.ext.consul.CheckList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[healthChecksWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def healthChecksWithOptionsFuture(service: java.lang.String,options: io.vertx.ext.consul.CheckQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.CheckList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.CheckList]()
      asJava.healthChecksWithOptions(service, options, {a:AsyncResult[io.vertx.ext.consul.CheckList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[healthState]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def healthStateFuture(healthState: io.vertx.ext.consul.HealthState): scala.concurrent.Future[io.vertx.ext.consul.CheckList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.CheckList]()
      asJava.healthState(healthState, {a:AsyncResult[io.vertx.ext.consul.CheckList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[healthStateWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def healthStateWithOptionsFuture(healthState: io.vertx.ext.consul.HealthState,options: io.vertx.ext.consul.CheckQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.CheckList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.CheckList]()
      asJava.healthStateWithOptions(healthState, options, {a:AsyncResult[io.vertx.ext.consul.CheckList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[healthServiceNodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def healthServiceNodesFuture(service: java.lang.String,passing: java.lang.Boolean): scala.concurrent.Future[io.vertx.ext.consul.ServiceEntryList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceEntryList]()
      asJava.healthServiceNodes(service, passing, {a:AsyncResult[io.vertx.ext.consul.ServiceEntryList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[healthServiceNodesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def healthServiceNodesWithOptionsFuture(service: java.lang.String,passing: java.lang.Boolean,options: io.vertx.ext.consul.ServiceQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.ServiceEntryList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceEntryList]()
      asJava.healthServiceNodesWithOptions(service, passing, options, {a:AsyncResult[io.vertx.ext.consul.ServiceEntryList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[catalogServices]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def catalogServicesFuture(): scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogServices({a:AsyncResult[io.vertx.ext.consul.ServiceList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[catalogServicesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def catalogServicesWithOptionsFuture(options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogServicesWithOptions(options, {a:AsyncResult[io.vertx.ext.consul.ServiceList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[catalogNodeServices]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def catalogNodeServicesFuture(node: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogNodeServices(node, {a:AsyncResult[io.vertx.ext.consul.ServiceList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[catalogNodeServicesWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def catalogNodeServicesWithOptionsFuture(node: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogNodeServicesWithOptions(node, options, {a:AsyncResult[io.vertx.ext.consul.ServiceList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[localServices]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def localServicesFuture(): scala.concurrent.Future[java.util.List[io.vertx.ext.consul.Service]] = {
      val promise = concurrent.Promise[java.util.List[io.vertx.ext.consul.Service]]()
      asJava.localServices({a:AsyncResult[java.util.List[io.vertx.ext.consul.Service]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[localChecks]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def localChecksFuture(): scala.concurrent.Future[java.util.List[io.vertx.ext.consul.Check]] = {
      val promise = concurrent.Promise[java.util.List[io.vertx.ext.consul.Check]]()
      asJava.localChecks({a:AsyncResult[java.util.List[io.vertx.ext.consul.Check]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[registerCheck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def registerCheckFuture(checkOptions: io.vertx.ext.consul.CheckOptions): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.registerCheck(checkOptions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deregisterCheck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deregisterCheckFuture(checkId: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.deregisterCheck(checkId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[passCheck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def passCheckFuture(checkId: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.passCheck(checkId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[passCheckWithNote]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def passCheckWithNoteFuture(checkId: java.lang.String,note: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.passCheckWithNote(checkId, note, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[warnCheck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def warnCheckFuture(checkId: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.warnCheck(checkId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[warnCheckWithNote]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def warnCheckWithNoteFuture(checkId: java.lang.String,note: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.warnCheckWithNote(checkId, note, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[failCheck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def failCheckFuture(checkId: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.failCheck(checkId, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[failCheckWithNote]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def failCheckWithNoteFuture(checkId: java.lang.String,note: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.failCheckWithNote(checkId, note, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[updateCheck]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def updateCheckFuture(checkId: java.lang.String,status: io.vertx.ext.consul.CheckStatus): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.updateCheck(checkId, status, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[updateCheckWithNote]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def updateCheckWithNoteFuture(checkId: java.lang.String,status: io.vertx.ext.consul.CheckStatus,note: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.updateCheckWithNote(checkId, status, note, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[leaderStatus]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def leaderStatusFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.leaderStatus({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[peersStatus]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def peersStatusFuture(): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = concurrent.Promise[java.util.List[java.lang.String]]()
      asJava.peersStatus({a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createSession]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createSessionFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createSession({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createSessionWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createSessionWithOptionsFuture(options: io.vertx.ext.consul.SessionOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createSessionWithOptions(options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[infoSession]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def infoSessionFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.Session] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.Session]()
      asJava.infoSession(id, {a:AsyncResult[io.vertx.ext.consul.Session] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[infoSessionWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def infoSessionWithOptionsFuture(id: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.Session] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.Session]()
      asJava.infoSessionWithOptions(id, options, {a:AsyncResult[io.vertx.ext.consul.Session] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[renewSession]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def renewSessionFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.Session] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.Session]()
      asJava.renewSession(id, {a:AsyncResult[io.vertx.ext.consul.Session] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listSessions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listSessionsFuture(): scala.concurrent.Future[io.vertx.ext.consul.SessionList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.SessionList]()
      asJava.listSessions({a:AsyncResult[io.vertx.ext.consul.SessionList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listSessionsWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listSessionsWithOptionsFuture(options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.SessionList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.SessionList]()
      asJava.listSessionsWithOptions(options, {a:AsyncResult[io.vertx.ext.consul.SessionList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listNodeSessions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listNodeSessionsFuture(nodeId: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.SessionList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.SessionList]()
      asJava.listNodeSessions(nodeId, {a:AsyncResult[io.vertx.ext.consul.SessionList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listNodeSessionsWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listNodeSessionsWithOptionsFuture(nodeId: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions): scala.concurrent.Future[io.vertx.ext.consul.SessionList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.SessionList]()
      asJava.listNodeSessionsWithOptions(nodeId, options, {a:AsyncResult[io.vertx.ext.consul.SessionList] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[destroySession]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def destroySessionFuture(id: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.destroySession(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createPreparedQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createPreparedQueryFuture(definition: io.vertx.ext.consul.PreparedQueryDefinition): scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createPreparedQuery(definition, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getPreparedQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getPreparedQueryFuture(id: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.PreparedQueryDefinition] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.PreparedQueryDefinition]()
      asJava.getPreparedQuery(id, {a:AsyncResult[io.vertx.ext.consul.PreparedQueryDefinition] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getAllPreparedQueries]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getAllPreparedQueriesFuture(): scala.concurrent.Future[java.util.List[io.vertx.ext.consul.PreparedQueryDefinition]] = {
      val promise = concurrent.Promise[java.util.List[io.vertx.ext.consul.PreparedQueryDefinition]]()
      asJava.getAllPreparedQueries({a:AsyncResult[java.util.List[io.vertx.ext.consul.PreparedQueryDefinition]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[updatePreparedQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def updatePreparedQueryFuture(definition: io.vertx.ext.consul.PreparedQueryDefinition): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.updatePreparedQuery(definition, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deletePreparedQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deletePreparedQueryFuture(id: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.deletePreparedQuery(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[executePreparedQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def executePreparedQueryFuture(query: java.lang.String): scala.concurrent.Future[io.vertx.ext.consul.PreparedQueryExecuteResponse] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.PreparedQueryExecuteResponse]()
      asJava.executePreparedQuery(query, {a:AsyncResult[io.vertx.ext.consul.PreparedQueryExecuteResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[executePreparedQueryWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def executePreparedQueryWithOptionsFuture(query: java.lang.String,options: io.vertx.ext.consul.PreparedQueryExecuteOptions): scala.concurrent.Future[io.vertx.ext.consul.PreparedQueryExecuteResponse] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.PreparedQueryExecuteResponse]()
      asJava.executePreparedQueryWithOptions(query, options, {a:AsyncResult[io.vertx.ext.consul.PreparedQueryExecuteResponse] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

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



  object Watch {
    /**
     * Like [[key]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def key(key: java.lang.String,vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.consul.Watch.key(key, vertx)
    }
    /**
     * Like [[key]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def key(key: java.lang.String,vertx: io.vertx.core.Vertx,options: io.vertx.ext.consul.ConsulClientOptions) = {
      io.vertx.ext.consul.Watch.key(key, vertx, options)
    }
    /**
     * Like [[keyPrefix]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def keyPrefix(keyPrefix: java.lang.String,vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.consul.Watch.keyPrefix(keyPrefix, vertx)
    }
    /**
     * Like [[keyPrefix]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def keyPrefix(keyPrefix: java.lang.String,vertx: io.vertx.core.Vertx,options: io.vertx.ext.consul.ConsulClientOptions) = {
      io.vertx.ext.consul.Watch.keyPrefix(keyPrefix, vertx, options)
    }
    /**
     * Like [[services]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def services(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.consul.Watch.services(vertx)
    }
    /**
     * Like [[services]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def services(vertx: io.vertx.core.Vertx,options: io.vertx.ext.consul.ConsulClientOptions) = {
      io.vertx.ext.consul.Watch.services(vertx, options)
    }
    /**
     * Like [[service]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def service(service: java.lang.String,vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.consul.Watch.service(service, vertx)
    }
    /**
     * Like [[service]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def service(service: java.lang.String,vertx: io.vertx.core.Vertx,options: io.vertx.ext.consul.ConsulClientOptions) = {
      io.vertx.ext.consul.Watch.service(service, vertx, options)
    }
    /**
     * Like [[events]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def events(event: java.lang.String,vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.consul.Watch.events(event, vertx)
    }
    /**
     * Like [[events]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def events(event: java.lang.String,vertx: io.vertx.core.Vertx,options: io.vertx.ext.consul.ConsulClientOptions) = {
      io.vertx.ext.consul.Watch.events(event, vertx, options)
    }
    /**
     * Like [[nodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def nodes(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.consul.Watch.nodes(vertx)
    }
    /**
     * Like [[nodes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def nodes(vertx: io.vertx.core.Vertx,options: io.vertx.ext.consul.ConsulClientOptions) = {
      io.vertx.ext.consul.Watch.nodes(vertx, options)
    }
  }




}
