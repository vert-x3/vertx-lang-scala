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

/** @module vertx-service-discovery-js/message_source */
var utils = require('vertx-js/util/utils');
var ServiceDiscovery = require('vertx-service-discovery-js/service_discovery');
var MessageConsumer = require('vertx-js/message_consumer');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JMessageSource = Java.type('io.vertx.servicediscovery.types.MessageSource');
var Record = Java.type('io.vertx.servicediscovery.Record');

/**
 Service type for data producer. Providers are publishing data to a specific event bus address.

 @class
*/
var MessageSource = function(j_val) {

  var j_messageSource = j_val;
  var that = this;

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_messageSource;
};

MessageSource._jclass = utils.getJavaClass("io.vertx.servicediscovery.types.MessageSource");
MessageSource._jtype = {
  accept: function(obj) {
    return MessageSource._jclass.isInstance(obj._jdel);
  },
  wrap: function(jdel) {
    var obj = Object.create(MessageSource.prototype, {});
    MessageSource.apply(obj, arguments);
    return obj;
  },
  unwrap: function(obj) {
    return obj._jdel;
  }
};
MessageSource._create = function(jdel) {
  var obj = Object.create(MessageSource.prototype, {});
  MessageSource.apply(obj, arguments);
  return obj;
}
/**
 Create a record representing a data producer.

 @memberof module:vertx-service-discovery-js/message_source
 @param name {string} the name of the service 
 @param address {string} the address on which the data is sent 
 @param type {string} the type of payload (fully qualified name of the class) 
 @param metadata {Object} additional metadata 
 @return {Object} the created record
 */
MessageSource.createRecord = function() {
  var __args = arguments;
  if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'string') {
    return utils.convReturnDataObject(JMessageSource["createRecord(java.lang.String,java.lang.String)"](__args[0], __args[1]));
  }else if (__args.length === 3 && typeof __args[0] === 'string' && typeof __args[1] === 'string' && typeof __args[2] === 'string') {
    return utils.convReturnDataObject(JMessageSource["createRecord(java.lang.String,java.lang.String,java.lang.String)"](__args[0], __args[1], __args[2]));
  }else if (__args.length === 4 && typeof __args[0] === 'string' && typeof __args[1] === 'string' && typeof __args[2] === 'string' && (typeof __args[3] === 'object' && __args[3] != null)) {
    return utils.convReturnDataObject(JMessageSource["createRecord(java.lang.String,java.lang.String,java.lang.String,io.vertx.core.json.JsonObject)"](__args[0], __args[1], __args[2], utils.convParamJsonObject(__args[3])));
  } else throw new TypeError('function invoked with invalid arguments');
};

/**
 Convenient method that looks for a message source and provides the configured . The
 async result is marked as failed is there are no matching services, or if the lookup fails.

 @memberof module:vertx-service-discovery-js/message_source
 @param discovery {ServiceDiscovery} The service discovery instance 
 @param filter {todo} The filter, must not be <code>null</code> 
 @param resultHandler {function} The result handler 
 */
MessageSource.getConsumer = function() {
  var __args = arguments;
  if (__args.length === 3 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
    JMessageSource["getConsumer(io.vertx.servicediscovery.ServiceDiscovery,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, utils.convParamJsonObject(__args[1]), function(ar) {
    if (ar.succeeded()) {
      __args[2](utils.convReturnVertxGen(MessageConsumer, ar.result(), undefined), null);
    } else {
      __args[2](null, ar.cause());
    }
  });
  }else if (__args.length === 3 && typeof __args[0] === 'object' && __args[0]._jdel && typeof __args[1] === 'function' && typeof __args[2] === 'function') {
    JMessageSource["getConsumer(io.vertx.servicediscovery.ServiceDiscovery,java.util.function.Function,io.vertx.core.Handler)"](__args[0]._jdel, function(jVal) {
    var jRet = __args[1](utils.convReturnDataObject(jVal));
    return jRet;
  }, function(ar) {
    if (ar.succeeded()) {
      __args[2](utils.convReturnVertxGen(MessageConsumer, ar.result(), undefined), null);
    } else {
      __args[2](null, ar.cause());
    }
  });
  } else throw new TypeError('function invoked with invalid arguments');
};

module.exports = MessageSource;