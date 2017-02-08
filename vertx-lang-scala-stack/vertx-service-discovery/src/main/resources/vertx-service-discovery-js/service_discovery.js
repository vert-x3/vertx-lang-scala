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

/** @module vertx-service-discovery-js/service_discovery */
var utils = require('vertx-js/util/utils');
var ServiceReference = require('vertx-service-discovery-js/service_reference');
var Vertx = require('vertx-js/vertx');
var ServiceImporter = require('vertx-service-discovery-js/service_importer');
var ServiceExporter = require('vertx-service-discovery-js/service_exporter');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JServiceDiscovery = Java.type('io.vertx.servicediscovery.ServiceDiscovery');
var ServiceDiscoveryOptions = Java.type('io.vertx.servicediscovery.ServiceDiscoveryOptions');
var Record = Java.type('io.vertx.servicediscovery.Record');

/**
 Service Discovery main entry point.
 <p>
 The service discovery is an infrastructure that let you publish and find `services`. A `service` is a discoverable
 functionality. It can be qualified by its type, metadata, and location. So a `service` can be a database, a
 service proxy, a HTTP endpoint. It does not have to be a vert.x entity, but can be anything. Each service is
 @class
*/
var ServiceDiscovery = function(j_val) {

  var j_serviceDiscovery = j_val;
  var that = this;

  /**
   Gets a service reference from the given record.

   @public
   @param record {Object} the chosen record 
   @return {ServiceReference} the service reference, that allows retrieving the service object. Once called the service reference is cached, and need to be released.
   */
  this.getReference = function(record) {
    var __args = arguments;
    if (__args.length === 1 && (typeof __args[0] === 'object' && __args[0] != null)) {
      return utils.convReturnVertxGen(ServiceReference, j_serviceDiscovery["getReference(io.vertx.servicediscovery.Record)"](record != null ? new Record(new JsonObject(Java.asJSONCompatible(record))) : null));
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Gets a service reference from the given record, the reference is configured with the given json object.

   @public
   @param record {Object} the chosen record 
   @param configuration {Object} the configuration 
   @return {ServiceReference} the service reference, that allows retrieving the service object. Once called the service reference is cached, and need to be released.
   */
  this.getReferenceWithConfiguration = function(record, configuration) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && (typeof __args[1] === 'object' && __args[1] != null)) {
      return utils.convReturnVertxGen(ServiceReference, j_serviceDiscovery["getReferenceWithConfiguration(io.vertx.servicediscovery.Record,io.vertx.core.json.JsonObject)"](record != null ? new Record(new JsonObject(Java.asJSONCompatible(record))) : null, utils.convParamJsonObject(configuration)));
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Releases the service reference.

   @public
   @param reference {ServiceReference} the reference to release, must not be <code>null</code> 
   @return {boolean} whether or not the reference has been released.
   */
  this.release = function(reference) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'object' && __args[0]._jdel) {
      return j_serviceDiscovery["release(io.vertx.servicediscovery.ServiceReference)"](reference._jdel);
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Registers a discovery service importer. Importers let you integrate other discovery technologies in this service
   discovery.

   @public
   @param importer {ServiceImporter} the service importer 
   @param configuration {Object} the optional configuration 
   @param completionHandler {function} handler call when the importer has finished its initialization and initial imports 
   @return {ServiceDiscovery} the current {@link ServiceDiscovery}
   */
  this.registerServiceImporter = function() {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null)) {
      return utils.convReturnVertxGen(ServiceDiscovery, j_serviceDiscovery["registerServiceImporter(io.vertx.servicediscovery.spi.ServiceImporter,io.vertx.core.json.JsonObject)"](__args[0]._jdel, utils.convParamJsonObject(__args[1])));
    }  else if (__args.length === 3 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      return utils.convReturnVertxGen(ServiceDiscovery, j_serviceDiscovery["registerServiceImporter(io.vertx.servicediscovery.spi.ServiceImporter,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, utils.convParamJsonObject(__args[1]), function(ar) {
      if (ar.succeeded()) {
        __args[2](null, null);
      } else {
        __args[2](null, ar.cause());
      }
    }));
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Registers a discovery bridge. Exporters let you integrate other discovery technologies in this service
   discovery.

   @public
   @param exporter {ServiceExporter} the service exporter 
   @param configuration {Object} the optional configuration 
   @param completionHandler {function} handler notified when the exporter has been correctly initialized. 
   @return {ServiceDiscovery} the current {@link ServiceDiscovery}
   */
  this.registerServiceExporter = function() {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null)) {
      return utils.convReturnVertxGen(ServiceDiscovery, j_serviceDiscovery["registerServiceExporter(io.vertx.servicediscovery.spi.ServiceExporter,io.vertx.core.json.JsonObject)"](__args[0]._jdel, utils.convParamJsonObject(__args[1])));
    }  else if (__args.length === 3 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      return utils.convReturnVertxGen(ServiceDiscovery, j_serviceDiscovery["registerServiceExporter(io.vertx.servicediscovery.spi.ServiceExporter,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, utils.convParamJsonObject(__args[1]), function(ar) {
      if (ar.succeeded()) {
        __args[2](null, null);
      } else {
        __args[2](null, ar.cause());
      }
    }));
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Closes the service discovery

   @public

   */
  this.close = function() {
    var __args = arguments;
    if (__args.length === 0) {
      j_serviceDiscovery["close()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Publishes a record.

   @public
   @param record {Object} the record 
   @param resultHandler {function} handler called when the operation has completed (successfully or not). In case of success, the passed record has a registration id required to modify and un-register the service. 
   */
  this.publish = function(record, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_serviceDiscovery["publish(io.vertx.servicediscovery.Record,io.vertx.core.Handler)"](record != null ? new Record(new JsonObject(Java.asJSONCompatible(record))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Un-publishes a record.

   @public
   @param id {string} the registration id 
   @param resultHandler {function} handler called when the operation has completed (successfully or not). 
   */
  this.unpublish = function(id, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
      j_serviceDiscovery["unpublish(java.lang.String,io.vertx.core.Handler)"](id, function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Lookups for a single record.
   <p>
   The filter is a  taking a <a href="../../dataobjects.html#Record">Record</a> as argument and returning a boolean. You should see it
   as an <code>accept</code> method of a filter. This method return a record passing the filter.
   <p>
   Unlike {@link ServiceDiscovery#getRecord}, this method may accept records with a <code>OUT OF SERVICE</code>
   status, if the <code>includeOutOfService</code> parameter is set to <code>true</code>.

   @public
   @param filter {todo} the filter, must not be <code>null</code>. To return all records, use a function accepting all records 
   @param includeOutOfService {boolean} whether or not the filter accepts <code>OUT OF SERVICE</code> records 
   @param resultHandler {function} the result handler called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has no result. 
   */
  this.getRecord = function() {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_serviceDiscovery["getRecord(io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](utils.convParamJsonObject(__args[0]), function(ar) {
      if (ar.succeeded()) {
        __args[1](utils.convReturnDataObject(ar.result()), null);
      } else {
        __args[1](null, ar.cause());
      }
    });
    }  else if (__args.length === 2 && typeof __args[0] === 'function' && typeof __args[1] === 'function') {
      j_serviceDiscovery["getRecord(java.util.function.Function,io.vertx.core.Handler)"](function(jVal) {
      var jRet = __args[0](utils.convReturnDataObject(jVal));
      return jRet;
    }, function(ar) {
      if (ar.succeeded()) {
        __args[1](utils.convReturnDataObject(ar.result()), null);
      } else {
        __args[1](null, ar.cause());
      }
    });
    }  else if (__args.length === 3 && typeof __args[0] === 'function' && typeof __args[1] ==='boolean' && typeof __args[2] === 'function') {
      j_serviceDiscovery["getRecord(java.util.function.Function,boolean,io.vertx.core.Handler)"](function(jVal) {
      var jRet = __args[0](utils.convReturnDataObject(jVal));
      return jRet;
    }, __args[1], function(ar) {
      if (ar.succeeded()) {
        __args[2](utils.convReturnDataObject(ar.result()), null);
      } else {
        __args[2](null, ar.cause());
      }
    });
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Lookups for a set of records. Unlike {@link ServiceDiscovery#getRecord}, this method returns all matching
   records.
   <p>
   The filter is a  taking a <a href="../../dataobjects.html#Record">Record</a> as argument and returning a boolean. You should see it
   as an <code>accept</code> method of a filter. This method return a record passing the filter.
   <p>
   Unlike {@link ServiceDiscovery#getRecords}, this method may accept records with a <code>OUT OF SERVICE</code>
   status, if the <code>includeOutOfService</code> parameter is set to <code>true</code>.

   @public
   @param filter {todo} the filter, must not be <code>null</code>. To return all records, use a function accepting all records 
   @param includeOutOfService {boolean} whether or not the filter accepts <code>OUT OF SERVICE</code> records 
   @param resultHandler {function} handler called when the lookup has been completed. When there are no matching record, the operation succeed, but the async result has an empty list as result. 
   */
  this.getRecords = function() {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_serviceDiscovery["getRecords(io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](utils.convParamJsonObject(__args[0]), function(ar) {
      if (ar.succeeded()) {
        __args[1](utils.convReturnListSetDataObject(ar.result()), null);
      } else {
        __args[1](null, ar.cause());
      }
    });
    }  else if (__args.length === 2 && typeof __args[0] === 'function' && typeof __args[1] === 'function') {
      j_serviceDiscovery["getRecords(java.util.function.Function,io.vertx.core.Handler)"](function(jVal) {
      var jRet = __args[0](utils.convReturnDataObject(jVal));
      return jRet;
    }, function(ar) {
      if (ar.succeeded()) {
        __args[1](utils.convReturnListSetDataObject(ar.result()), null);
      } else {
        __args[1](null, ar.cause());
      }
    });
    }  else if (__args.length === 3 && typeof __args[0] === 'function' && typeof __args[1] ==='boolean' && typeof __args[2] === 'function') {
      j_serviceDiscovery["getRecords(java.util.function.Function,boolean,io.vertx.core.Handler)"](function(jVal) {
      var jRet = __args[0](utils.convReturnDataObject(jVal));
      return jRet;
    }, __args[1], function(ar) {
      if (ar.succeeded()) {
        __args[2](utils.convReturnListSetDataObject(ar.result()), null);
      } else {
        __args[2](null, ar.cause());
      }
    });
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**
   Updates the given record. The record must has been published, and has it's registration id set.

   @public
   @param record {Object} the updated record 
   @param resultHandler {function} handler called when the lookup has been completed. 
   */
  this.update = function(record, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_serviceDiscovery["update(io.vertx.servicediscovery.Record,io.vertx.core.Handler)"](record != null ? new Record(new JsonObject(Java.asJSONCompatible(record))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {Array.<ServiceReference>} the set of service references retrieved by this service discovery.
   */
  this.bindings = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return utils.convReturnListSetVertxGen(j_serviceDiscovery["bindings()"](), ServiceReference);
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   @return {Object} the discovery options. Modifying the returned object would not update the discovery service configuration. This object should be considered as read-only.
   */
  this.options = function() {
    var __args = arguments;
    if (__args.length === 0) {
      return utils.convReturnDataObject(j_serviceDiscovery["options()"]());
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_serviceDiscovery;
};

ServiceDiscovery._jclass = utils.getJavaClass("io.vertx.servicediscovery.ServiceDiscovery");
ServiceDiscovery._jtype = {
  accept: function(obj) {
    return ServiceDiscovery._jclass.isInstance(obj._jdel);
  },
  wrap: function(jdel) {
    var obj = Object.create(ServiceDiscovery.prototype, {});
    ServiceDiscovery.apply(obj, arguments);
    return obj;
  },
  unwrap: function(obj) {
    return obj._jdel;
  }
};
ServiceDiscovery._create = function(jdel) {
  var obj = Object.create(ServiceDiscovery.prototype, {});
  ServiceDiscovery.apply(obj, arguments);
  return obj;
}
/**
 Creates an instance of {@link ServiceDiscovery}.

 @memberof module:vertx-service-discovery-js/service_discovery
 @param vertx {Vertx} the vert.x instance 
 @param options {Object} the discovery options 
 @param completionHandler {function} completion handler called when the service discovery has been initialized. This includes the initialization of the service importer registered from the SPI. 
 @return {ServiceDiscovery} the created instance, should not be used to retrieve services before the invocation of the completion handler.
 */
ServiceDiscovery.create = function() {
  var __args = arguments;
  if (__args.length === 1 && typeof __args[0] === 'object' && __args[0]._jdel) {
    return utils.convReturnVertxGen(ServiceDiscovery, JServiceDiscovery["create(io.vertx.core.Vertx)"](__args[0]._jdel));
  }else if (__args.length === 2 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null)) {
    return utils.convReturnVertxGen(ServiceDiscovery, JServiceDiscovery["create(io.vertx.core.Vertx,io.vertx.servicediscovery.ServiceDiscoveryOptions)"](__args[0]._jdel, __args[1] != null ? new ServiceDiscoveryOptions(new JsonObject(Java.asJSONCompatible(__args[1]))) : null));
  }else if (__args.length === 2 && typeof __args[0] === 'object' && __args[0]._jdel && typeof __args[1] === 'function') {
    return utils.convReturnVertxGen(ServiceDiscovery, JServiceDiscovery["create(io.vertx.core.Vertx,io.vertx.core.Handler)"](__args[0]._jdel, function(jVal) {
    __args[1](utils.convReturnVertxGen(ServiceDiscovery, jVal));
  }));
  }else if (__args.length === 3 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
    return utils.convReturnVertxGen(ServiceDiscovery, JServiceDiscovery["create(io.vertx.core.Vertx,io.vertx.servicediscovery.ServiceDiscoveryOptions,io.vertx.core.Handler)"](__args[0]._jdel, __args[1] != null ? new ServiceDiscoveryOptions(new JsonObject(Java.asJSONCompatible(__args[1]))) : null, function(jVal) {
    __args[2](utils.convReturnVertxGen(ServiceDiscovery, jVal));
  }));
  } else throw new TypeError('function invoked with invalid arguments');
};

/**
 Release the service object retrieved using <code>get</code> methods from the service type interface.
 It searches for the reference associated with the given object and release it.

 @memberof module:vertx-service-discovery-js/service_discovery
 @param discovery {ServiceDiscovery} the service discovery 
 @param svcObject {Object} the service object 
 */
ServiceDiscovery.releaseServiceObject = function(discovery, svcObject) {
  var __args = arguments;
  if (__args.length === 2 && typeof __args[0] === 'object' && __args[0]._jdel && typeof __args[1] !== 'function') {
    JServiceDiscovery["releaseServiceObject(io.vertx.servicediscovery.ServiceDiscovery,java.lang.Object)"](discovery._jdel, utils.convParamTypeUnknown(svcObject));
  } else throw new TypeError('function invoked with invalid arguments');
};

module.exports = ServiceDiscovery;