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
     * Like agentInfo from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def agentInfoFuture() : scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonObject]()
      asJava.agentInfo(new Handler[AsyncResult[io.vertx.core.json.JsonObject]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonObject]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like coordinateNodes from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def coordinateNodesFuture() : scala.concurrent.Future[io.vertx.ext.consul.CoordinateList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.CoordinateList]()
      asJava.coordinateNodes(new Handler[AsyncResult[io.vertx.ext.consul.CoordinateList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.CoordinateList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like coordinateNodesWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def coordinateNodesWithOptionsFuture(options: io.vertx.ext.consul.BlockingQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.CoordinateList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.CoordinateList]()
      asJava.coordinateNodesWithOptions(options, new Handler[AsyncResult[io.vertx.ext.consul.CoordinateList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.CoordinateList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like coordinateDatacenters from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def coordinateDatacentersFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.ext.consul.DcCoordinates]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.ext.consul.DcCoordinates]]()
      asJava.coordinateDatacenters(new Handler[AsyncResult[java.util.List[io.vertx.ext.consul.DcCoordinates]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.ext.consul.DcCoordinates]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
    /**
     * Like getKeys from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getKeysFuture(keyPrefix: java.lang.String) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.getKeys(keyPrefix, new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
    /**
     * Like getKeysWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getKeysWithOptionsFuture(keyPrefix: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.getKeysWithOptions(keyPrefix, options, new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
    /**
     * Like getValue from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getValueFuture(key: java.lang.String) : scala.concurrent.Future[io.vertx.ext.consul.KeyValue] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.KeyValue]()
      asJava.getValue(key, new Handler[AsyncResult[io.vertx.ext.consul.KeyValue]] { override def handle(event: AsyncResult[io.vertx.ext.consul.KeyValue]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like getValueWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getValueWithOptionsFuture(key: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.KeyValue] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.KeyValue]()
      asJava.getValueWithOptions(key, options, new Handler[AsyncResult[io.vertx.ext.consul.KeyValue]] { override def handle(event: AsyncResult[io.vertx.ext.consul.KeyValue]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like deleteValue from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def deleteValueFuture(key: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.deleteValue(key, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like getValues from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getValuesFuture(keyPrefix: java.lang.String) : scala.concurrent.Future[io.vertx.ext.consul.KeyValueList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.KeyValueList]()
      asJava.getValues(keyPrefix, new Handler[AsyncResult[io.vertx.ext.consul.KeyValueList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.KeyValueList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like getValuesWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getValuesWithOptionsFuture(keyPrefix: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.KeyValueList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.KeyValueList]()
      asJava.getValuesWithOptions(keyPrefix, options, new Handler[AsyncResult[io.vertx.ext.consul.KeyValueList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.KeyValueList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like deleteValues from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def deleteValuesFuture(keyPrefix: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.deleteValues(keyPrefix, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like putValue from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def putValueFuture(key: java.lang.String,value: java.lang.String) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.putValue(key, value, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like putValueWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def putValueWithOptionsFuture(key: java.lang.String,value: java.lang.String,options: io.vertx.ext.consul.KeyValueOptions) : scala.concurrent.Future[java.lang.Boolean] = {
      val promise = concurrent.Promise[java.lang.Boolean]()
      asJava.putValueWithOptions(key, value, options, new Handler[AsyncResult[java.lang.Boolean]] { override def handle(event: AsyncResult[java.lang.Boolean]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like transaction from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def transactionFuture(request: io.vertx.ext.consul.TxnRequest) : scala.concurrent.Future[io.vertx.ext.consul.TxnResponse] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.TxnResponse]()
      asJava.transaction(request, new Handler[AsyncResult[io.vertx.ext.consul.TxnResponse]] { override def handle(event: AsyncResult[io.vertx.ext.consul.TxnResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like createAclToken from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def createAclTokenFuture(token: io.vertx.ext.consul.AclToken) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createAclToken(token, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like updateAclToken from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def updateAclTokenFuture(token: io.vertx.ext.consul.AclToken) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.updateAclToken(token, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like cloneAclToken from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def cloneAclTokenFuture(id: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.cloneAclToken(id, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like listAclTokens from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listAclTokensFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.ext.consul.AclToken]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.ext.consul.AclToken]]()
      asJava.listAclTokens(new Handler[AsyncResult[java.util.List[io.vertx.ext.consul.AclToken]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.ext.consul.AclToken]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
    /**
     * Like infoAclToken from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def infoAclTokenFuture(id: java.lang.String) : scala.concurrent.Future[io.vertx.ext.consul.AclToken] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.AclToken]()
      asJava.infoAclToken(id, new Handler[AsyncResult[io.vertx.ext.consul.AclToken]] { override def handle(event: AsyncResult[io.vertx.ext.consul.AclToken]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like destroyAclToken from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def destroyAclTokenFuture(id: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.destroyAclToken(id, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like fireEvent from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def fireEventFuture(name: java.lang.String) : scala.concurrent.Future[io.vertx.ext.consul.Event] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.Event]()
      asJava.fireEvent(name, new Handler[AsyncResult[io.vertx.ext.consul.Event]] { override def handle(event: AsyncResult[io.vertx.ext.consul.Event]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like fireEventWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def fireEventWithOptionsFuture(name: java.lang.String,options: io.vertx.ext.consul.EventOptions) : scala.concurrent.Future[io.vertx.ext.consul.Event] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.Event]()
      asJava.fireEventWithOptions(name, options, new Handler[AsyncResult[io.vertx.ext.consul.Event]] { override def handle(event: AsyncResult[io.vertx.ext.consul.Event]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like listEvents from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listEventsFuture() : scala.concurrent.Future[io.vertx.ext.consul.EventList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.EventList]()
      asJava.listEvents(new Handler[AsyncResult[io.vertx.ext.consul.EventList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.EventList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like listEventsWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listEventsWithOptionsFuture(options: io.vertx.ext.consul.EventListOptions) : scala.concurrent.Future[io.vertx.ext.consul.EventList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.EventList]()
      asJava.listEventsWithOptions(options, new Handler[AsyncResult[io.vertx.ext.consul.EventList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.EventList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like registerService from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def registerServiceFuture(serviceOptions: io.vertx.ext.consul.ServiceOptions) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.registerService(serviceOptions, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like maintenanceService from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def maintenanceServiceFuture(maintenanceOptions: io.vertx.ext.consul.MaintenanceOptions) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.maintenanceService(maintenanceOptions, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like deregisterService from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def deregisterServiceFuture(id: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.deregisterService(id, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like catalogServiceNodes from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def catalogServiceNodesFuture(service: java.lang.String) : scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogServiceNodes(service, new Handler[AsyncResult[io.vertx.ext.consul.ServiceList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.ServiceList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like catalogServiceNodesWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def catalogServiceNodesWithOptionsFuture(service: java.lang.String,options: io.vertx.ext.consul.ServiceQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogServiceNodesWithOptions(service, options, new Handler[AsyncResult[io.vertx.ext.consul.ServiceList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.ServiceList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like catalogDatacenters from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def catalogDatacentersFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.catalogDatacenters(new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
    /**
     * Like catalogNodes from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def catalogNodesFuture() : scala.concurrent.Future[io.vertx.ext.consul.NodeList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.NodeList]()
      asJava.catalogNodes(new Handler[AsyncResult[io.vertx.ext.consul.NodeList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.NodeList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like catalogNodesWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def catalogNodesWithOptionsFuture(options: io.vertx.ext.consul.NodeQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.NodeList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.NodeList]()
      asJava.catalogNodesWithOptions(options, new Handler[AsyncResult[io.vertx.ext.consul.NodeList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.NodeList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like healthChecks from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def healthChecksFuture(service: java.lang.String) : scala.concurrent.Future[io.vertx.ext.consul.CheckList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.CheckList]()
      asJava.healthChecks(service, new Handler[AsyncResult[io.vertx.ext.consul.CheckList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.CheckList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like healthChecksWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def healthChecksWithOptionsFuture(service: java.lang.String,options: io.vertx.ext.consul.CheckQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.CheckList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.CheckList]()
      asJava.healthChecksWithOptions(service, options, new Handler[AsyncResult[io.vertx.ext.consul.CheckList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.CheckList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like healthState from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def healthStateFuture(healthState: io.vertx.ext.consul.HealthState) : scala.concurrent.Future[io.vertx.ext.consul.CheckList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.CheckList]()
      asJava.healthState(healthState, new Handler[AsyncResult[io.vertx.ext.consul.CheckList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.CheckList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like healthStateWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def healthStateWithOptionsFuture(healthState: io.vertx.ext.consul.HealthState,options: io.vertx.ext.consul.CheckQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.CheckList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.CheckList]()
      asJava.healthStateWithOptions(healthState, options, new Handler[AsyncResult[io.vertx.ext.consul.CheckList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.CheckList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like healthServiceNodes from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def healthServiceNodesFuture(service: java.lang.String,passing: java.lang.Boolean) : scala.concurrent.Future[io.vertx.ext.consul.ServiceEntryList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceEntryList]()
      asJava.healthServiceNodes(service, passing, new Handler[AsyncResult[io.vertx.ext.consul.ServiceEntryList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.ServiceEntryList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like healthServiceNodesWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def healthServiceNodesWithOptionsFuture(service: java.lang.String,passing: java.lang.Boolean,options: io.vertx.ext.consul.ServiceQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.ServiceEntryList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceEntryList]()
      asJava.healthServiceNodesWithOptions(service, passing, options, new Handler[AsyncResult[io.vertx.ext.consul.ServiceEntryList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.ServiceEntryList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like catalogServices from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def catalogServicesFuture() : scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogServices(new Handler[AsyncResult[io.vertx.ext.consul.ServiceList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.ServiceList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like catalogServicesWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def catalogServicesWithOptionsFuture(options: io.vertx.ext.consul.BlockingQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogServicesWithOptions(options, new Handler[AsyncResult[io.vertx.ext.consul.ServiceList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.ServiceList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like catalogNodeServices from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def catalogNodeServicesFuture(node: java.lang.String) : scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogNodeServices(node, new Handler[AsyncResult[io.vertx.ext.consul.ServiceList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.ServiceList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like catalogNodeServicesWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def catalogNodeServicesWithOptionsFuture(node: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.ServiceList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.ServiceList]()
      asJava.catalogNodeServicesWithOptions(node, options, new Handler[AsyncResult[io.vertx.ext.consul.ServiceList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.ServiceList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like localServices from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def localServicesFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.ext.consul.Service]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.ext.consul.Service]]()
      asJava.localServices(new Handler[AsyncResult[java.util.List[io.vertx.ext.consul.Service]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.ext.consul.Service]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
    /**
     * Like localChecks from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def localChecksFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.ext.consul.Check]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.ext.consul.Check]]()
      asJava.localChecks(new Handler[AsyncResult[java.util.List[io.vertx.ext.consul.Check]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.ext.consul.Check]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
    /**
     * Like registerCheck from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def registerCheckFuture(checkOptions: io.vertx.ext.consul.CheckOptions) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.registerCheck(checkOptions, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like deregisterCheck from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def deregisterCheckFuture(checkId: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.deregisterCheck(checkId, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like passCheck from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def passCheckFuture(checkId: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.passCheck(checkId, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like passCheckWithNote from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def passCheckWithNoteFuture(checkId: java.lang.String,note: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.passCheckWithNote(checkId, note, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like warnCheck from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def warnCheckFuture(checkId: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.warnCheck(checkId, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like warnCheckWithNote from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def warnCheckWithNoteFuture(checkId: java.lang.String,note: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.warnCheckWithNote(checkId, note, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like failCheck from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def failCheckFuture(checkId: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.failCheck(checkId, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like failCheckWithNote from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def failCheckWithNoteFuture(checkId: java.lang.String,note: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.failCheckWithNote(checkId, note, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like updateCheck from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def updateCheckFuture(checkId: java.lang.String,status: io.vertx.ext.consul.CheckStatus) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.updateCheck(checkId, status, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like updateCheckWithNote from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def updateCheckWithNoteFuture(checkId: java.lang.String,status: io.vertx.ext.consul.CheckStatus,note: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.updateCheckWithNote(checkId, status, note, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like leaderStatus from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def leaderStatusFuture() : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.leaderStatus(new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like peersStatus from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def peersStatusFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.String]]()
      asJava.peersStatus(new Handler[AsyncResult[java.util.List[java.lang.String]]] { override def handle(event: AsyncResult[java.util.List[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
    /**
     * Like createSession from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def createSessionFuture() : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createSession(new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like createSessionWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def createSessionWithOptionsFuture(options: io.vertx.ext.consul.SessionOptions) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createSessionWithOptions(options, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like infoSession from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def infoSessionFuture(id: java.lang.String) : scala.concurrent.Future[io.vertx.ext.consul.Session] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.Session]()
      asJava.infoSession(id, new Handler[AsyncResult[io.vertx.ext.consul.Session]] { override def handle(event: AsyncResult[io.vertx.ext.consul.Session]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like infoSessionWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def infoSessionWithOptionsFuture(id: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.Session] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.Session]()
      asJava.infoSessionWithOptions(id, options, new Handler[AsyncResult[io.vertx.ext.consul.Session]] { override def handle(event: AsyncResult[io.vertx.ext.consul.Session]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like renewSession from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def renewSessionFuture(id: java.lang.String) : scala.concurrent.Future[io.vertx.ext.consul.Session] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.Session]()
      asJava.renewSession(id, new Handler[AsyncResult[io.vertx.ext.consul.Session]] { override def handle(event: AsyncResult[io.vertx.ext.consul.Session]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like listSessions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listSessionsFuture() : scala.concurrent.Future[io.vertx.ext.consul.SessionList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.SessionList]()
      asJava.listSessions(new Handler[AsyncResult[io.vertx.ext.consul.SessionList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.SessionList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like listSessionsWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listSessionsWithOptionsFuture(options: io.vertx.ext.consul.BlockingQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.SessionList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.SessionList]()
      asJava.listSessionsWithOptions(options, new Handler[AsyncResult[io.vertx.ext.consul.SessionList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.SessionList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like listNodeSessions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listNodeSessionsFuture(nodeId: java.lang.String) : scala.concurrent.Future[io.vertx.ext.consul.SessionList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.SessionList]()
      asJava.listNodeSessions(nodeId, new Handler[AsyncResult[io.vertx.ext.consul.SessionList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.SessionList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like listNodeSessionsWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def listNodeSessionsWithOptionsFuture(nodeId: java.lang.String,options: io.vertx.ext.consul.BlockingQueryOptions) : scala.concurrent.Future[io.vertx.ext.consul.SessionList] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.SessionList]()
      asJava.listNodeSessionsWithOptions(nodeId, options, new Handler[AsyncResult[io.vertx.ext.consul.SessionList]] { override def handle(event: AsyncResult[io.vertx.ext.consul.SessionList]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like destroySession from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def destroySessionFuture(id: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.destroySession(id, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like createPreparedQuery from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def createPreparedQueryFuture(definition: io.vertx.ext.consul.PreparedQueryDefinition) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.createPreparedQuery(definition, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like getPreparedQuery from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getPreparedQueryFuture(id: java.lang.String) : scala.concurrent.Future[io.vertx.ext.consul.PreparedQueryDefinition] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.PreparedQueryDefinition]()
      asJava.getPreparedQuery(id, new Handler[AsyncResult[io.vertx.ext.consul.PreparedQueryDefinition]] { override def handle(event: AsyncResult[io.vertx.ext.consul.PreparedQueryDefinition]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like getAllPreparedQueries from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getAllPreparedQueriesFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.ext.consul.PreparedQueryDefinition]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.ext.consul.PreparedQueryDefinition]]()
      asJava.getAllPreparedQueries(new Handler[AsyncResult[java.util.List[io.vertx.ext.consul.PreparedQueryDefinition]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.ext.consul.PreparedQueryDefinition]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
    /**
     * Like updatePreparedQuery from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def updatePreparedQueryFuture(definition: io.vertx.ext.consul.PreparedQueryDefinition) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.updatePreparedQuery(definition, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like deletePreparedQuery from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def deletePreparedQueryFuture(id: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.deletePreparedQuery(id, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like executePreparedQuery from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def executePreparedQueryFuture(query: java.lang.String) : scala.concurrent.Future[io.vertx.ext.consul.PreparedQueryExecuteResponse] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.PreparedQueryExecuteResponse]()
      asJava.executePreparedQuery(query, new Handler[AsyncResult[io.vertx.ext.consul.PreparedQueryExecuteResponse]] { override def handle(event: AsyncResult[io.vertx.ext.consul.PreparedQueryExecuteResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like executePreparedQueryWithOptions from [[io.vertx.ext.consul.ConsulClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def executePreparedQueryWithOptionsFuture(query: java.lang.String,options: io.vertx.ext.consul.PreparedQueryExecuteOptions) : scala.concurrent.Future[io.vertx.ext.consul.PreparedQueryExecuteResponse] = {
      val promise = concurrent.Promise[io.vertx.ext.consul.PreparedQueryExecuteResponse]()
      asJava.executePreparedQueryWithOptions(query, options, new Handler[AsyncResult[io.vertx.ext.consul.PreparedQueryExecuteResponse]] { override def handle(event: AsyncResult[io.vertx.ext.consul.PreparedQueryExecuteResponse]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }




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
     * Like key from [[io.vertx.ext.consul.Watch]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def key(key: java.lang.String,vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.consul.Watch.key(key, vertx)
}
    /**
     * Like key from [[io.vertx.ext.consul.Watch]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def key(key: java.lang.String,vertx: io.vertx.core.Vertx,options: io.vertx.ext.consul.ConsulClientOptions) = {
      io.vertx.ext.consul.Watch.key(key, vertx, options)
}
    /**
     * Like keyPrefix from [[io.vertx.ext.consul.Watch]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def keyPrefix(keyPrefix: java.lang.String,vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.consul.Watch.keyPrefix(keyPrefix, vertx)
}
    /**
     * Like keyPrefix from [[io.vertx.ext.consul.Watch]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def keyPrefix(keyPrefix: java.lang.String,vertx: io.vertx.core.Vertx,options: io.vertx.ext.consul.ConsulClientOptions) = {
      io.vertx.ext.consul.Watch.keyPrefix(keyPrefix, vertx, options)
}
    /**
     * Like services from [[io.vertx.ext.consul.Watch]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def services(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.consul.Watch.services(vertx)
}
    /**
     * Like services from [[io.vertx.ext.consul.Watch]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def services(vertx: io.vertx.core.Vertx,options: io.vertx.ext.consul.ConsulClientOptions) = {
      io.vertx.ext.consul.Watch.services(vertx, options)
}
    /**
     * Like service from [[io.vertx.ext.consul.Watch]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def service(service: java.lang.String,vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.consul.Watch.service(service, vertx)
}
    /**
     * Like service from [[io.vertx.ext.consul.Watch]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def service(service: java.lang.String,vertx: io.vertx.core.Vertx,options: io.vertx.ext.consul.ConsulClientOptions) = {
      io.vertx.ext.consul.Watch.service(service, vertx, options)
}
    /**
     * Like events from [[io.vertx.ext.consul.Watch]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def events(event: java.lang.String,vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.consul.Watch.events(event, vertx)
}
    /**
     * Like events from [[io.vertx.ext.consul.Watch]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def events(event: java.lang.String,vertx: io.vertx.core.Vertx,options: io.vertx.ext.consul.ConsulClientOptions) = {
      io.vertx.ext.consul.Watch.events(event, vertx, options)
}
    /**
     * Like nodes from [[io.vertx.ext.consul.Watch]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def nodes(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.consul.Watch.nodes(vertx)
}
    /**
     * Like nodes from [[io.vertx.ext.consul.Watch]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def nodes(vertx: io.vertx.core.Vertx,options: io.vertx.ext.consul.ConsulClientOptions) = {
      io.vertx.ext.consul.Watch.nodes(vertx, options)
}  }





}

