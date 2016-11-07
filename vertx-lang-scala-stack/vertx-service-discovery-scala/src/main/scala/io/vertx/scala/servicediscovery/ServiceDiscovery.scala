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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.servicediscovery.{ServiceDiscovery => JServiceDiscovery}
import io.vertx.servicediscovery.{ServiceReference => JServiceReference}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.scala.servicediscovery.Record
import java.util.function.{Function => JFunction}
import io.vertx.servicediscovery.spi.{ServiceImporter => JServiceImporter}
import io.vertx.scala.servicediscovery.spi.ServiceImporter
import io.vertx.servicediscovery.{ServiceDiscoveryOptions => JServiceDiscoveryOptions}
import io.vertx.scala.servicediscovery.ServiceDiscoveryOptions
import io.vertx.core.json.JsonObject
import io.vertx.servicediscovery.spi.{ServiceExporter => JServiceExporter}
import io.vertx.scala.servicediscovery.spi.ServiceExporter

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
class ServiceDiscovery(private val _asJava: JServiceDiscovery) {

  def asJava: JServiceDiscovery = _asJava

  /**
    * Gets a service reference from the given record.
    * @param record the chosen recordsee <a href="../../../../../../cheatsheet/Record.html">Record</a>
    * @return the service reference, that allows retrieving the service object. Once called the service reference is cached, and need to be released.
    */
  def getReference(record: Record): ServiceReference = {
    ServiceReference.apply(_asJava.getReference(record.asJava))
  }

  /**
    * Gets a service reference from the given record, the reference is configured with the given json object.
    * @param record the chosen recordsee <a href="../../../../../../cheatsheet/Record.html">Record</a>
    * @param configuration the configuration
    * @return the service reference, that allows retrieving the service object. Once called the service reference is cached, and need to be released.
    */
  def getReferenceWithConfiguration(record: Record, configuration: JsonObject): ServiceReference = {
    ServiceReference.apply(_asJava.getReferenceWithConfiguration(record.asJava, configuration))
  }

  /**
    * Releases the service reference.
    * @param reference the reference to release, must not be `null`
    * @return whether or not the reference has been released.
    */
  def release(reference: ServiceReference): Boolean = {
    _asJava.release(reference.asJava.asInstanceOf[JServiceReference])
  }

  /**
    * Registers a discovery service importer. Importers let you integrate other discovery technologies in this service
    * discovery.
    * @param importer the service importer
    * @param configuration the optional configuration
    * @return the current [[ServiceDiscovery]]
    */
  def registerServiceImporter(importer: ServiceImporter, configuration: JsonObject): ServiceDiscovery = {
    ServiceDiscovery.apply(_asJava.registerServiceImporter(importer.asJava.asInstanceOf[JServiceImporter], configuration))
  }

  /**
    * Registers a discovery service importer. Importers let you integrate other discovery technologies in this service
    * discovery.
    * @param importer the service importer
    * @param configuration the optional configuration
    * @return future call when the importer has finished its initialization and initial imports
    */
  def registerServiceImporterFuture(importer: ServiceImporter, configuration: JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    ServiceDiscovery.apply(_asJava.registerServiceImporter(importer.asJava.asInstanceOf[JServiceImporter], configuration, promiseAndHandler._1))
    promiseAndHandler._2.future
  }

  /**
    * Registers a discovery bridge. Exporters let you integrate other discovery technologies in this service
    * discovery.
    * @param exporter the service exporter
    * @param configuration the optional configuration
    * @return the current [[ServiceDiscovery]]
    */
  def registerServiceExporter(exporter: ServiceExporter, configuration: JsonObject): ServiceDiscovery = {
    ServiceDiscovery.apply(_asJava.registerServiceExporter(exporter.asJava.asInstanceOf[JServiceExporter], configuration))
  }

  /**
    * Registers a discovery bridge. Exporters let you integrate other discovery technologies in this service
    * discovery.
    * @param exporter the service exporter
    * @param configuration the optional configuration
    * @return future notified when the exporter has been correctly initialized.
    */
  def registerServiceExporterFuture(exporter: ServiceExporter, configuration: JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    ServiceDiscovery.apply(_asJava.registerServiceExporter(exporter.asJava.asInstanceOf[JServiceExporter], configuration, promiseAndHandler._1))
    promiseAndHandler._2.future
  }

  /**
    * Closes the service discovery
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Publishes a record.
    * @param record the recordsee <a href="../../../../../../cheatsheet/Record.html">Record</a>
    * @return future called when the operation has completed (successfully or not). In case of success, the passed record has a registration id required to modify and un-register the service.
    */
  def publishFuture(record: Record): concurrent.Future[Record] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecord,Record]((x => io.vertx.scala.servicediscovery.Record(x)))
    _asJava.publish(record.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Un-publishes a record.
    * @param id the registration id
    * @return future called when the operation has completed (successfully or not).
    */
  def unpublishFuture(id: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.unpublish(id, promiseAndHandler._1)
    promiseAndHandler._2.future
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
    * @return future called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has no result.
    */
  def getRecordFuture(filter: JsonObject): concurrent.Future[Record] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecord,Record]((x => io.vertx.scala.servicediscovery.Record(x)))
    _asJava.getRecord(filter, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Lookups for a single record.
    * 
    * The filter is a  taking a <a href="../../../../../../cheatsheet/Record.html">Record</a> as argument and returning a boolean. You should see it
    * as an `accept` method of a filter. This method return a record passing the filter.
    * 
    * This method only looks for records with a `UP` status.
    * @param filter the filter, must not be `null`. To return all records, use a function accepting all records
    * @return the result future called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has no result.
    */
  def getRecordFuture(filter: JRecord => java.lang.Boolean): concurrent.Future[Record] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecord,Record]((x => io.vertx.scala.servicediscovery.Record(x)))
    _asJava.getRecord(asJavaFunction(filter), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Lookups for a single record.
    * 
    * The filter is a  taking a <a href="../../../../../../cheatsheet/Record.html">Record</a> as argument and returning a boolean. You should see it
    * as an `accept` method of a filter. This method return a record passing the filter.
    * 
    * Unlike [[io.vertx.scala.servicediscovery.ServiceDiscovery#getRecord]], this method may accept records with a `OUT OF SERVICE`
    * status, if the `includeOutOfService` parameter is set to `true`.
    * @param filter the filter, must not be `null`. To return all records, use a function accepting all records
    * @param includeOutOfService whether or not the filter accepts `OUT OF SERVICE` records
    * @return the result future called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has no result.
    */
  def getRecordFuture(filter: JRecord => java.lang.Boolean, includeOutOfService: Boolean): concurrent.Future[Record] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecord,Record]((x => io.vertx.scala.servicediscovery.Record(x)))
    _asJava.getRecord(asJavaFunction(filter), includeOutOfService, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Lookups for a set of records. Unlike [[io.vertx.scala.servicediscovery.ServiceDiscovery#getRecord]], this method returns all matching
    * records.
    * @param filter the filter - see [[#getRecord(JsonObject, Handler)]]
    * @return future called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has an empty list as result.
    */
  def getRecordsFuture(filter: JsonObject): concurrent.Future[scala.collection.mutable.Buffer[Record]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.servicediscovery.Record],scala.collection.mutable.Buffer[Record]]((x => if (x == null) null else x.asScala.map(x => Record(x))))
    _asJava.getRecords(filter, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Lookups for a set of records. Unlike [[io.vertx.scala.servicediscovery.ServiceDiscovery#getRecord]], this method returns all matching
    * records.
    * 
    * The filter is a  taking a <a href="../../../../../../cheatsheet/Record.html">Record</a> as argument and returning a boolean. You should see it
    * as an `accept` method of a filter. This method return a record passing the filter.
    * 
    * This method only looks for records with a `UP` status.
    * @param filter the filter, must not be `null`. To return all records, use a function accepting all records
    * @return future called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has an empty list as result.
    */
  def getRecordsFuture(filter: JRecord => java.lang.Boolean): concurrent.Future[scala.collection.mutable.Buffer[Record]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.servicediscovery.Record],scala.collection.mutable.Buffer[Record]]((x => if (x == null) null else x.asScala.map(x => Record(x))))
    _asJava.getRecords(asJavaFunction(filter), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Lookups for a set of records. Unlike [[io.vertx.scala.servicediscovery.ServiceDiscovery#getRecord]], this method returns all matching
    * records.
    * 
    * The filter is a  taking a <a href="../../../../../../cheatsheet/Record.html">Record</a> as argument and returning a boolean. You should see it
    * as an `accept` method of a filter. This method return a record passing the filter.
    * 
    * Unlike [[io.vertx.scala.servicediscovery.ServiceDiscovery#getRecords]], this method may accept records with a `OUT OF SERVICE`
    * status, if the `includeOutOfService` parameter is set to `true`.
    * @param filter the filter, must not be `null`. To return all records, use a function accepting all records
    * @param includeOutOfService whether or not the filter accepts `OUT OF SERVICE` records
    * @return future called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has an empty list as result.
    */
  def getRecordsFuture(filter: JRecord => java.lang.Boolean, includeOutOfService: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Record]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.servicediscovery.Record],scala.collection.mutable.Buffer[Record]]((x => if (x == null) null else x.asScala.map(x => Record(x))))
    _asJava.getRecords(asJavaFunction(filter), includeOutOfService, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Updates the given record. The record must has been published, and has it's registration id set.
    * @param record the updated recordsee <a href="../../../../../../cheatsheet/Record.html">Record</a>
    * @return future called when the lookup has been completed.
    */
  def updateFuture(record: Record): concurrent.Future[Record] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecord,Record]((x => io.vertx.scala.servicediscovery.Record(x)))
    _asJava.update(record.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * @return the set of service references retrieved by this service discovery.
    */
  def bindings(): Set[ServiceReference] = {
    _asJava.bindings().asScala.map(ServiceReference.apply).toSet
  }

  /**
    * @return the discovery options. Modifying the returned object would not update the discovery service configuration. This object should be considered as read-only.see <a href="../../../../../../cheatsheet/ServiceDiscoveryOptions.html">ServiceDiscoveryOptions</a>
    */
  def options(): ServiceDiscoveryOptions = {
    ServiceDiscoveryOptions(_asJava.options())
  }

}

object ServiceDiscovery {

  def apply(_asJava: JServiceDiscovery): ServiceDiscovery =
    new ServiceDiscovery(_asJava)

  def create(vertx: Vertx, options: ServiceDiscoveryOptions): ServiceDiscovery = {
    ServiceDiscovery.apply(io.vertx.servicediscovery.ServiceDiscovery.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  def create(vertx: Vertx): ServiceDiscovery = {
    ServiceDiscovery.apply(io.vertx.servicediscovery.ServiceDiscovery.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  def releaseServiceObject(discovery: ServiceDiscovery, svcObject: AnyRef): Unit = {
    io.vertx.servicediscovery.ServiceDiscovery.releaseServiceObject(discovery.asJava.asInstanceOf[JServiceDiscovery], svcObject)
  }

}
