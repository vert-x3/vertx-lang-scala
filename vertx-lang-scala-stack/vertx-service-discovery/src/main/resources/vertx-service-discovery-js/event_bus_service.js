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

/** @module vertx-service-discovery-js/event_bus_service */
var utils = require('vertx-js/util/utils');
var ServiceDiscovery = require('vertx-service-discovery-js/service_discovery');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JEventBusService = Java.type('io.vertx.servicediscovery.types.EventBusService');
var Record = Java.type('io.vertx.servicediscovery.Record');

/**

 @class
*/
var EventBusService = function(j_val) {

  var j_eventBusService = j_val;
  var that = this;

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_eventBusService;
};

EventBusService._jclass = utils.getJavaClass("io.vertx.servicediscovery.types.EventBusService");
EventBusService._jtype = {
  accept: function(obj) {
    return EventBusService._jclass.isInstance(obj._jdel);
  },
  wrap: function(jdel) {
    var obj = Object.create(EventBusService.prototype, {});
    EventBusService.apply(obj, arguments);
    return obj;
  },
  unwrap: function(obj) {
    return obj._jdel;
  }
};
EventBusService._create = function(jdel) {
  var obj = Object.create(EventBusService.prototype, {});
  EventBusService.apply(obj, arguments);
  return obj;
}
/**
 Sugar method to creates a record for this type.
 <p>
 The java interface is added to the metadata in the `service.interface` key.

 @memberof module:vertx-service-discovery-js/event_bus_service
 @param name {string} the name of the service. 
 @param address {string} the event bus address on which the service available 
 @param itf {string} the Java interface (name) 
 @param metadata {Object} the metadata 
 @return {Object} the created record
 */
EventBusService.createRecord = function() {
  var __args = arguments;
  if (__args.length === 3 && typeof __args[0] === 'string' && typeof __args[1] === 'string' && typeof __args[2] === 'string') {
    return utils.convReturnDataObject(JEventBusService["createRecord(java.lang.String,java.lang.String,java.lang.String)"](__args[0], __args[1], __args[2]));
  }else if (__args.length === 4 && typeof __args[0] === 'string' && typeof __args[1] === 'string' && typeof __args[2] === 'string' && (typeof __args[3] === 'object' && __args[3] != null)) {
    return utils.convReturnDataObject(JEventBusService["createRecord(java.lang.String,java.lang.String,java.lang.String,io.vertx.core.json.JsonObject)"](__args[0], __args[1], __args[2], utils.convParamJsonObject(__args[3])));
  } else throw new TypeError('function invoked with invalid arguments');
};

/**
 Lookup for a service record and if found, retrieve it and return the service object (used to consume the service).
 This is a convenient method to avoid explicit lookup and then retrieval of the service. This method requires to
 have the <code>clientClass</code> set with the expected set of client. This is important for usages not using Java so
 you can pass the expected type.

 @memberof module:vertx-service-discovery-js/event_bus_service
 @param discovery {ServiceDiscovery} the service discovery 
 @param filter {todo} the filter 
 @param clientClass {todo} the client class 
 @param resultHandler {function} the result handler 
 @return {Object} <code>null</code> - do not use
 */
EventBusService.getServiceProxy = function(discovery, filter, clientClass, resultHandler) {
  var __args = arguments;
  if (__args.length === 4 && typeof __args[0] === 'object' && __args[0]._jdel && typeof __args[1] === 'function' && typeof __args[2] === 'function' && typeof __args[3] === 'function') {
    return utils.get_jtype(__args[2]).wrap(JEventBusService["getServiceProxy(io.vertx.servicediscovery.ServiceDiscovery,java.util.function.Function,java.lang.Class,io.vertx.core.Handler)"](discovery._jdel, function(jVal) {
    var jRet = filter(utils.convReturnDataObject(jVal));
    return jRet;
  }, utils.get_jclass(clientClass), function(ar) {
    if (ar.succeeded()) {
      resultHandler(utils.get_jtype(__args[2]).wrap(ar.result()), null);
    } else {
      resultHandler(null, ar.cause());
    }
  }));
  } else throw new TypeError('function invoked with invalid arguments');
};

/**
 Lookup for a service record and if found, retrieve it and return the service object (used to consume the service).
 This is a convenient method to avoid explicit lookup and then retrieval of the service. This method requires to
 have the <code>clientClass</code> set with the expected set of client. This is important for usages not using Java so
 you can pass the expected type.

 @memberof module:vertx-service-discovery-js/event_bus_service
 @param discovery {ServiceDiscovery} the service discovery 
 @param filter {Object} the filter as json object 
 @param clientClass {todo} the client class 
 @param resultHandler {function} the result handler 
 @return {Object} <code>null</code> - do not use
 */
EventBusService.getServiceProxyWithJsonFilter = function(discovery, filter, clientClass, resultHandler) {
  var __args = arguments;
  if (__args.length === 4 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function' && typeof __args[3] === 'function') {
    return utils.get_jtype(__args[2]).wrap(JEventBusService["getServiceProxyWithJsonFilter(io.vertx.servicediscovery.ServiceDiscovery,io.vertx.core.json.JsonObject,java.lang.Class,io.vertx.core.Handler)"](discovery._jdel, utils.convParamJsonObject(filter), utils.get_jclass(clientClass), function(ar) {
    if (ar.succeeded()) {
      resultHandler(utils.get_jtype(__args[2]).wrap(ar.result()), null);
    } else {
      resultHandler(null, ar.cause());
    }
  }));
  } else throw new TypeError('function invoked with invalid arguments');
};

module.exports = EventBusService;