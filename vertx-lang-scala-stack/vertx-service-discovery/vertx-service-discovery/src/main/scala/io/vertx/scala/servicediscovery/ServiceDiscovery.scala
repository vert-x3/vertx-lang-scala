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

package io.vertx.scala.servicediscovery

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.servicediscovery.{ServiceDiscoveryOptions => JServiceDiscoveryOptions}
import io.vertx.servicediscovery.spi.{ServiceImporter => JServiceImporter}
import io.vertx.scala.servicediscovery.spi.ServiceExporter
import scala.collection.JavaConverters._
import io.vertx.servicediscovery.spi.{ServiceExporter => JServiceExporter}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.servicediscovery.{ServiceReference => JServiceReference}
import io.vertx.servicediscovery.{ServiceDiscovery => JServiceDiscovery}
import io.vertx.scala.servicediscovery.spi.ServiceImporter
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Service Discovery main entry point.
  * 
  * The service discovery is an infrastructure that let you publish and find `services`. A `service` is a discoverable
  * functionality. It can be qualified by its type, metadata, and location. So a `service` can be a database, a
  * service proxy, a HTTP endpoint. It does not have to be a vert.x entity, but can be anything. Each service is
  * described by a <a href="../../../../../../cheatsheet/Record.html">Record</a>.
  * 
  * The service discovery implements the interactions defined in the service-oriented computing. And to some extend,
  * also provides the dynamic service-oriented computing interaction. So, application can react to arrival and
  * departure of services.
  * 
  * A service provider can:
  * 
  * * publish a service record
  * * un-publish a published record
  * * update the status of a published service (down, out of service...)
  * 
  * A service consumer can:
  * 
  * * lookup for services
  * * bind to a selected service (it gets a [[io.vertx.scala.servicediscovery.ServiceReference]]) and use it
  * * release the service once the consumer is done with it
  * * listen for arrival, departure and modification of services.
  * 
  * Consumer would 1) lookup for service record matching their need, 2) retrieve the [[io.vertx.scala.servicediscovery.ServiceReference]] that give access
  * to the service, 3) get a service object to access the service, 4) release the service object once done.
  * 
  * A state above, the central piece of information shared by the providers and consumers are <a href="../../../../../../cheatsheet/Record.html">Record</a>.
  * 
  * Providers and consumers must create their own [[io.vertx.scala.servicediscovery.ServiceDiscovery]] instance. These instances are collaborating
  * in background (distributed structure) to keep the set of services in sync.
  */
class ServiceDiscovery(private val _asJava: Object) {

  def asJava = _asJava


  /**
    * Gets a service reference from the given record.
    * @param record the chosen recordsee <a href="../../../../../../cheatsheet/Record.html">Record</a>
    * @return the service reference, that allows retrieving the service object. Once called the service reference is cached, and need to be released.
    */
  def getReference(record: Record): ServiceReference = {
    ServiceReference(asJava.asInstanceOf[JServiceDiscovery].getReference(record.asJava))
  }

  /**
    * Gets a service reference from the given record, the reference is configured with the given json object.
    * @param record the chosen recordsee <a href="../../../../../../cheatsheet/Record.html">Record</a>
    * @param configuration the configuration
    * @return the service reference, that allows retrieving the service object. Once called the service reference is cached, and need to be released.
    */
  def getReferenceWithConfiguration(record: Record, configuration: io.vertx.core.json.JsonObject): ServiceReference = {
    ServiceReference(asJava.asInstanceOf[JServiceDiscovery].getReferenceWithConfiguration(record.asJava, configuration))
  }

  /**
    * Releases the service reference.
    * @param reference the reference to release, must not be `null`
    * @return whether or not the reference has been released.
    */
  def release(reference: ServiceReference): Boolean = {
    asJava.asInstanceOf[JServiceDiscovery].release(reference.asJava.asInstanceOf[JServiceReference]).asInstanceOf[Boolean]
  }

  /**
    * Registers a discovery service importer. Importers let you integrate other discovery technologies in this service
    * discovery.
    * @param importer the service importer
    * @param configuration the optional configuration
    * @return the current ServiceDiscovery
    */
  def registerServiceImporter(importer: ServiceImporter, configuration: io.vertx.core.json.JsonObject): ServiceDiscovery = {
    ServiceDiscovery(asJava.asInstanceOf[JServiceDiscovery].registerServiceImporter(importer.asJava.asInstanceOf[JServiceImporter], configuration))
  }

  /**
    * Registers a discovery service importer. Importers let you integrate other discovery technologies in this service
    * discovery.
    * @param importer the service importer
    * @param configuration the optional configuration
    * @param completionHandler handler call when the importer has finished its initialization and initial imports
    * @return the current ServiceDiscovery
    */
  def registerServiceImporter(importer: ServiceImporter, configuration: io.vertx.core.json.JsonObject, completionHandler: Handler[AsyncResult[Unit]]): ServiceDiscovery = {
    ServiceDiscovery(asJava.asInstanceOf[JServiceDiscovery].registerServiceImporter(importer.asJava.asInstanceOf[JServiceImporter], configuration, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}))
  }

  /**
    * Registers a discovery bridge. Exporters let you integrate other discovery technologies in this service
    * discovery.
    * @param exporter the service exporter
    * @param configuration the optional configuration
    * @return the current ServiceDiscovery
    */
  def registerServiceExporter(exporter: ServiceExporter, configuration: io.vertx.core.json.JsonObject): ServiceDiscovery = {
    ServiceDiscovery(asJava.asInstanceOf[JServiceDiscovery].registerServiceExporter(exporter.asJava.asInstanceOf[JServiceExporter], configuration))
  }

  /**
    * Registers a discovery bridge. Exporters let you integrate other discovery technologies in this service
    * discovery.
    * @param exporter the service exporter
    * @param configuration the optional configuration
    * @param completionHandler handler notified when the exporter has been correctly initialized.
    * @return the current ServiceDiscovery
    */
  def registerServiceExporter(exporter: ServiceExporter, configuration: io.vertx.core.json.JsonObject, completionHandler: Handler[AsyncResult[Unit]]): ServiceDiscovery = {
    ServiceDiscovery(asJava.asInstanceOf[JServiceDiscovery].registerServiceExporter(exporter.asJava.asInstanceOf[JServiceExporter], configuration, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}))
  }

  /**
    * Closes the service discovery
    */
  def close(): Unit = {
    asJava.asInstanceOf[JServiceDiscovery].close()
  }

  /**
    * Publishes a record.
    * @param record the recordsee <a href="../../../../../../cheatsheet/Record.html">Record</a>
    * @param resultHandler handler called when the operation has completed (successfully or not). In case of success, the passed record has a registration id required to modify and un-register the service.
    */
  def publish(record: Record, resultHandler: Handler[AsyncResult[Record]]): Unit = {
    asJava.asInstanceOf[JServiceDiscovery].publish(record.asJava, {x: AsyncResult[JRecord] => resultHandler.handle(AsyncResultWrapper[JRecord, Record](x, a => Record(a)))})
  }

  /**
    * Un-publishes a record.
    * @param id the registration id
    * @param resultHandler handler called when the operation has completed (successfully or not).
    */
  def unpublish(id: String, resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JServiceDiscovery].unpublish(id.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Lookups for a single record.
    * 
    * Filters are expressed using a Json object. Each entry of the given filter will be checked against the record.
    * All entry must match exactly the record. The entry can use the special "*" value to denotes a requirement on the
    * key, but not on the value.
    * 
    * Let's take some example:
    * <pre>
    *   { "name" = "a" ` => matches records with name set fo "a"
    *   { "color" = "*" ` => matches records with "color" set
    *   { "color" = "red" ` => only matches records with "color" set to "red"
    *   { "color" = "red", "name" = "a"` => only matches records with name set to "a", and color set to "red"
    * </pre>
    * 
    * If the filter is not set (`null` or empty), it accepts all records.
    * 
    * This method returns the first matching record.
    * @param filter the filter.
    * @param resultHandler handler called when the lookup has been completed. When there are no matching record, the operation succeeds, but the async result has no result (`null`).
    */
  def getRecord(filter: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Record]]): Unit = {
    asJava.asInstanceOf[JServiceDiscovery].getRecord(filter, {x: AsyncResult[JRecord] => resultHandler.handle(AsyncResultWrapper[JRecord, Record](x, a => Record(a)))})
  }

  /**
    * Lookups for a single record.
    * 
    * The filter is a  taking a <a href="../../../../../../cheatsheet/Record.html">Record</a> as argument and returning a boolean. You should see it
    * as an `accept` method of a filter. This method return a record passing the filter.
    * 
    * This method only looks for records with a `UP` status.
    * @param filter the filter, must not be `null`. To return all records, use a function accepting all records
    * @param resultHandler the result handler called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has no result.
    */
  def getRecord(filter: Record => Boolean, resultHandler: Handler[AsyncResult[Record]]): Unit = {
    asJava.asInstanceOf[JServiceDiscovery].getRecord({x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]}, {x: AsyncResult[JRecord] => resultHandler.handle(AsyncResultWrapper[JRecord, Record](x, a => Record(a)))})
  }

  /**
    * Lookups for a single record.
    * 
    * The filter is a  taking a <a href="../../../../../../cheatsheet/Record.html">Record</a> as argument and returning a boolean. You should see it
    * as an `accept` method of a filter. This method return a record passing the filter.
    * 
    * Unlike [[io.vertx.scala.servicediscovery.ServiceDiscovery#getRecordFuture]], this method may accept records with a `OUT OF SERVICE`
    * status, if the `includeOutOfService` parameter is set to `true`.
    * @param filter the filter, must not be `null`. To return all records, use a function accepting all records
    * @param includeOutOfService whether or not the filter accepts `OUT OF SERVICE` records
    * @param resultHandler the result handler called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has no result.
    */
  def getRecord(filter: Record => Boolean, includeOutOfService: Boolean, resultHandler: Handler[AsyncResult[Record]]): Unit = {
    asJava.asInstanceOf[JServiceDiscovery].getRecord({x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]}, includeOutOfService.asInstanceOf[java.lang.Boolean], {x: AsyncResult[JRecord] => resultHandler.handle(AsyncResultWrapper[JRecord, Record](x, a => Record(a)))})
  }

  /**
    * Lookups for a set of records. Unlike [[io.vertx.scala.servicediscovery.ServiceDiscovery#getRecordFuture]], this method returns all matching
    * records.
    * @param filter the filter - see #getRecord(JsonObject, Handler)
    * @param resultHandler handler called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has an empty list as result.
    */
  def getRecords(filter: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[Record]]]): Unit = {
    asJava.asInstanceOf[JServiceDiscovery].getRecords(filter, {x: AsyncResult[java.util.List[JRecord]] => resultHandler.handle(AsyncResultWrapper[java.util.List[JRecord], scala.collection.mutable.Buffer[Record]](x, a => a.asScala.map(x => Record(x))))})
  }

  /**
    * Lookups for a set of records. Unlike [[io.vertx.scala.servicediscovery.ServiceDiscovery#getRecordFuture]], this method returns all matching
    * records.
    * 
    * The filter is a  taking a <a href="../../../../../../cheatsheet/Record.html">Record</a> as argument and returning a boolean. You should see it
    * as an `accept` method of a filter. This method return a record passing the filter.
    * 
    * This method only looks for records with a `UP` status.
    * @param filter the filter, must not be `null`. To return all records, use a function accepting all records
    * @param resultHandler handler called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has an empty list as result.
    */
  def getRecords(filter: Record => Boolean, resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[Record]]]): Unit = {
    asJava.asInstanceOf[JServiceDiscovery].getRecords({x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]}, {x: AsyncResult[java.util.List[JRecord]] => resultHandler.handle(AsyncResultWrapper[java.util.List[JRecord], scala.collection.mutable.Buffer[Record]](x, a => a.asScala.map(x => Record(x))))})
  }

  /**
    * Lookups for a set of records. Unlike [[io.vertx.scala.servicediscovery.ServiceDiscovery#getRecordFuture]], this method returns all matching
    * records.
    * 
    * The filter is a  taking a <a href="../../../../../../cheatsheet/Record.html">Record</a> as argument and returning a boolean. You should see it
    * as an `accept` method of a filter. This method return a record passing the filter.
    * 
    * Unlike [[io.vertx.scala.servicediscovery.ServiceDiscovery#getRecordsFuture]], this method may accept records with a `OUT OF SERVICE`
    * status, if the `includeOutOfService` parameter is set to `true`.
    * @param filter the filter, must not be `null`. To return all records, use a function accepting all records
    * @param includeOutOfService whether or not the filter accepts `OUT OF SERVICE` records
    * @param resultHandler handler called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has an empty list as result.
    */
  def getRecords(filter: Record => Boolean, includeOutOfService: Boolean, resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[Record]]]): Unit = {
    asJava.asInstanceOf[JServiceDiscovery].getRecords({x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]}, includeOutOfService.asInstanceOf[java.lang.Boolean], {x: AsyncResult[java.util.List[JRecord]] => resultHandler.handle(AsyncResultWrapper[java.util.List[JRecord], scala.collection.mutable.Buffer[Record]](x, a => a.asScala.map(x => Record(x))))})
  }

  /**
    * Updates the given record. The record must has been published, and has it's registration id set.
    * @param record the updated recordsee <a href="../../../../../../cheatsheet/Record.html">Record</a>
    * @param resultHandler handler called when the lookup has been completed.
    */
  def update(record: Record, resultHandler: Handler[AsyncResult[Record]]): Unit = {
    asJava.asInstanceOf[JServiceDiscovery].update(record.asJava, {x: AsyncResult[JRecord] => resultHandler.handle(AsyncResultWrapper[JRecord, Record](x, a => Record(a)))})
  }

  /**
    * @return the set of service references retrieved by this service discovery.
    */
  def bindings(): scala.collection.mutable.Set[ServiceReference] = {
    asJava.asInstanceOf[JServiceDiscovery].bindings().asScala.map(x => ServiceReference(x))
  }

  /**
    * @return the discovery options. Modifying the returned object would not update the discovery service configuration. This object should be considered as read-only.see <a href="../../../../../../cheatsheet/ServiceDiscoveryOptions.html">ServiceDiscoveryOptions</a>
    */
  def options(): ServiceDiscoveryOptions = {
    ServiceDiscoveryOptions(asJava.asInstanceOf[JServiceDiscovery].options())
  }

 /**
   * Like [[registerServiceImporter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def registerServiceImporterFuture(importer: ServiceImporter, configuration: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JServiceDiscovery].registerServiceImporter(importer.asJava.asInstanceOf[JServiceImporter], configuration, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[registerServiceExporter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def registerServiceExporterFuture(exporter: ServiceExporter, configuration: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JServiceDiscovery].registerServiceExporter(exporter.asJava.asInstanceOf[JServiceExporter], configuration, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[publish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def publishFuture(record: Record): scala.concurrent.Future[Record] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecord, Record](x => Record(x))
    asJava.asInstanceOf[JServiceDiscovery].publish(record.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[unpublish]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def unpublishFuture(id: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JServiceDiscovery].unpublish(id.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[getRecord]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getRecordFuture(filter: io.vertx.core.json.JsonObject): scala.concurrent.Future[Record] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecord, Record](x => Record(x))
    asJava.asInstanceOf[JServiceDiscovery].getRecord(filter, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[getRecord]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getRecordFuture(filter: Record => Boolean): scala.concurrent.Future[Record] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecord, Record](x => Record(x))
    asJava.asInstanceOf[JServiceDiscovery].getRecord({x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]}, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[getRecord]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getRecordFuture(filter: Record => Boolean, includeOutOfService: Boolean): scala.concurrent.Future[Record] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecord, Record](x => Record(x))
    asJava.asInstanceOf[JServiceDiscovery].getRecord({x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]}, includeOutOfService.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[getRecords]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getRecordsFuture(filter: io.vertx.core.json.JsonObject): scala.concurrent.Future[scala.collection.mutable.Buffer[Record]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JRecord], scala.collection.mutable.Buffer[Record]](x => x.asScala.map(x => Record(x)))
    asJava.asInstanceOf[JServiceDiscovery].getRecords(filter, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[getRecords]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getRecordsFuture(filter: Record => Boolean): scala.concurrent.Future[scala.collection.mutable.Buffer[Record]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JRecord], scala.collection.mutable.Buffer[Record]](x => x.asScala.map(x => Record(x)))
    asJava.asInstanceOf[JServiceDiscovery].getRecords({x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]}, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[getRecords]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getRecordsFuture(filter: Record => Boolean, includeOutOfService: Boolean): scala.concurrent.Future[scala.collection.mutable.Buffer[Record]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JRecord], scala.collection.mutable.Buffer[Record]](x => x.asScala.map(x => Record(x)))
    asJava.asInstanceOf[JServiceDiscovery].getRecords({x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]}, includeOutOfService.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[update]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def updateFuture(record: Record): scala.concurrent.Future[Record] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecord, Record](x => Record(x))
    asJava.asInstanceOf[JServiceDiscovery].update(record.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object ServiceDiscovery {
  def apply(asJava: JServiceDiscovery) = new ServiceDiscovery(asJava)  
  /**
    * Creates an instance of [[io.vertx.scala.servicediscovery.ServiceDiscovery]].
    * @param vertx the vert.x instance
    * @param options the discovery optionssee <a href="../../../../../../cheatsheet/ServiceDiscoveryOptions.html">ServiceDiscoveryOptions</a>
    * @return the created service discovery instance.
    */
  def create(vertx: Vertx, options: ServiceDiscoveryOptions): ServiceDiscovery = {
    ServiceDiscovery(JServiceDiscovery.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  /**
    * Creates a new instance of [[io.vertx.scala.servicediscovery.ServiceDiscovery]] using the default configuration.
    * @param vertx the vert.x instance
    * @return the created instance
    */
  def create(vertx: Vertx): ServiceDiscovery = {
    ServiceDiscovery(JServiceDiscovery.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Creates an instance of [[io.vertx.scala.servicediscovery.ServiceDiscovery]].
    * @param vertx the vert.x instance
    * @param options the discovery optionssee <a href="../../../../../../cheatsheet/ServiceDiscoveryOptions.html">ServiceDiscoveryOptions</a>
    * @param completionHandler completion handler called when the service discovery has been initialized. This includes the initialization of the service importer registered from the SPI.
    * @return the created instance, should not be used to retrieve services before the invocation of the completion handler.
    */
  def create(vertx: Vertx, options: ServiceDiscoveryOptions, completionHandler: Handler[ServiceDiscovery]): ServiceDiscovery = {
    ServiceDiscovery(JServiceDiscovery.create(vertx.asJava.asInstanceOf[JVertx], options.asJava, {x: JServiceDiscovery => completionHandler.handle(ServiceDiscovery(x))}))
  }

  /**
    * Creates a new instance of [[io.vertx.scala.servicediscovery.ServiceDiscovery]] using the default configuration.
    * @param vertx the vert.x instance
    * @param completionHandler completion handler called when the service discovery has been initialized. This includes the initialization of the service importer registered from the SPI.
    * @return the created instance, should not be used to retrieve services before the invocation of the completion handler.
    */
  def create(vertx: Vertx, completionHandler: Handler[ServiceDiscovery]): ServiceDiscovery = {
    ServiceDiscovery(JServiceDiscovery.create(vertx.asJava.asInstanceOf[JVertx], {x: JServiceDiscovery => completionHandler.handle(ServiceDiscovery(x))}))
  }

  /**
    * Release the service object retrieved using `get` methods from the service type interface.
    * It searches for the reference associated with the given object and release it.
    * @param discovery the service discovery
    * @param svcObject the service object
    */
  def releaseServiceObject(discovery: ServiceDiscovery, svcObject: AnyRef): Unit = {
    JServiceDiscovery.releaseServiceObject(discovery.asJava.asInstanceOf[JServiceDiscovery], svcObject)
  }

}
