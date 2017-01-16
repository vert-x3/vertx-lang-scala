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

/** @module vertx-service-discovery-js/jdbc_data_source */
var utils = require('vertx-js/util/utils');
var JDBCClient = require('vertx-jdbc-js/jdbc_client');
var ServiceDiscovery = require('vertx-service-discovery-js/service_discovery');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JJDBCDataSource = io.vertx.servicediscovery.types.JDBCDataSource;
var Record = io.vertx.servicediscovery.Record;

/**

 @class
*/
var JDBCDataSource = function(j_val) {

  var j_jDBCDataSource = j_val;
  var that = this;

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_jDBCDataSource;
};

JDBCDataSource._jclass = utils.getJavaClass("io.vertx.servicediscovery.types.JDBCDataSource");
JDBCDataSource._jtype = {
  accept: function(obj) {
    return JDBCDataSource._jclass.isInstance(obj._jdel);
  },
  wrap: function(jdel) {
    var obj = Object.create(JDBCDataSource.prototype, {});
    JDBCDataSource.apply(obj, arguments);
    return obj;
  },
  unwrap: function(obj) {
    return obj._jdel;
  }
};
JDBCDataSource._create = function(jdel) {
  var obj = Object.create(JDBCDataSource.prototype, {});
  JDBCDataSource.apply(obj, arguments);
  return obj;
}
/**

 @memberof module:vertx-service-discovery-js/jdbc_data_source
 @param name {string} 
 @param location {Object} 
 @param metadata {Object} 
 @return {Object}
 */
JDBCDataSource.createRecord = function(name, location, metadata) {
  var __args = arguments;
  if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null)) {
    return utils.convReturnDataObject(JJDBCDataSource["createRecord(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject)"](name, utils.convParamJsonObject(location), utils.convParamJsonObject(metadata)));
  } else throw new TypeError('function invoked with invalid arguments');
};

/**
 Convenient method that looks for a JDBC datasource source and provides the configured {@link JDBCClient}. The
 async result is marked as failed is there are no matching services, or if the lookup fails.

 @memberof module:vertx-service-discovery-js/jdbc_data_source
 @param discovery {ServiceDiscovery} The service discovery instance 
 @param filter {todo} The filter, must not be <code>null</code> 
 @param consumerConfiguration {Object} the consumer configuration 
 @param resultHandler {function} the result handler 
 */
JDBCDataSource.getJDBCClient = function() {
  var __args = arguments;
  if (__args.length === 3 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
    JJDBCDataSource["getJDBCClient(io.vertx.servicediscovery.ServiceDiscovery,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, utils.convParamJsonObject(__args[1]), function(ar) {
    if (ar.succeeded()) {
      __args[2](utils.convReturnVertxGen(JDBCClient, ar.result()), null);
    } else {
      __args[2](null, ar.cause());
    }
  });
  }else if (__args.length === 3 && typeof __args[0] === 'object' && __args[0]._jdel && typeof __args[1] === 'function' && typeof __args[2] === 'function') {
    JJDBCDataSource["getJDBCClient(io.vertx.servicediscovery.ServiceDiscovery,java.util.function.Function,io.vertx.core.Handler)"](__args[0]._jdel, function(jVal) {
    var jRet = __args[1](utils.convReturnDataObject(jVal));
    return jRet;
  }, function(ar) {
    if (ar.succeeded()) {
      __args[2](utils.convReturnVertxGen(JDBCClient, ar.result()), null);
    } else {
      __args[2](null, ar.cause());
    }
  });
  }else if (__args.length === 4 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
    JJDBCDataSource["getJDBCClient(io.vertx.servicediscovery.ServiceDiscovery,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, utils.convParamJsonObject(__args[1]), utils.convParamJsonObject(__args[2]), function(ar) {
    if (ar.succeeded()) {
      __args[3](utils.convReturnVertxGen(JDBCClient, ar.result()), null);
    } else {
      __args[3](null, ar.cause());
    }
  });
  }else if (__args.length === 4 && typeof __args[0] === 'object' && __args[0]._jdel && typeof __args[1] === 'function' && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
    JJDBCDataSource["getJDBCClient(io.vertx.servicediscovery.ServiceDiscovery,java.util.function.Function,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, function(jVal) {
    var jRet = __args[1](utils.convReturnDataObject(jVal));
    return jRet;
  }, utils.convParamJsonObject(__args[2]), function(ar) {
    if (ar.succeeded()) {
      __args[3](utils.convReturnVertxGen(JDBCClient, ar.result()), null);
    } else {
      __args[3](null, ar.cause());
    }
  });
  } else throw new TypeError('function invoked with invalid arguments');
};

module.exports = JDBCDataSource;