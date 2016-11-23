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

/** @module vertx-service-discovery-js/redis_data_source */
var utils = require('vertx-js/util/utils');
var RedisClient = require('vertx-redis-js/redis_client');
var ServiceDiscovery = require('vertx-service-discovery-js/service_discovery');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JRedisDataSource = io.vertx.servicediscovery.types.RedisDataSource;
var Record = io.vertx.servicediscovery.Record;

/**
 Service type for Redis data source.

 @class
*/
var RedisDataSource = function(j_val) {

  var j_redisDataSource = j_val;
  var that = this;

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_redisDataSource;
};

RedisDataSource._jclass = utils.getJavaClass("io.vertx.servicediscovery.types.RedisDataSource");
RedisDataSource._jtype = {
  accept: function(obj) {
    return RedisDataSource._jclass.isInstance(obj._jdel);
  },
  wrap: function(jdel) {
    var obj = Object.create(RedisDataSource.prototype, {});
    RedisDataSource.apply(obj, arguments);
    return obj;
  },
  unwrap: function(obj) {
    return obj._jdel;
  }
};
RedisDataSource._create = function(jdel) {
  var obj = Object.create(RedisDataSource.prototype, {});
  RedisDataSource.apply(obj, arguments);
  return obj;
}
/**
 Convenient method to create a record for a Redis data source.

 @memberof module:vertx-service-discovery-js/redis_data_source
 @param name {string} the service name 
 @param location {Object} the location of the service (e.g. url, port...) 
 @param metadata {Object} additional metadata 
 @return {Object} the created record
 */
RedisDataSource.createRecord = function(name, location, metadata) {
  var __args = arguments;
  if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null)) {
    return utils.convReturnDataObject(JRedisDataSource["createRecord(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject)"](name, utils.convParamJsonObject(location), utils.convParamJsonObject(metadata)));
  } else throw new TypeError('function invoked with invalid arguments');
};

/**
 Convenient method that looks for a Redis data source and provides the configured {@link RedisClient}.
 The async result is marked as failed is there are no matching services, or if the lookup fails.

 @memberof module:vertx-service-discovery-js/redis_data_source
 @param discovery {ServiceDiscovery} The service discovery instance 
 @param filter {Object} The filter, optional 
 @param consumerConfiguration {Object} The additional consumer configuration 
 @param resultHandler {function} The result handler 
 */
RedisDataSource.getRedisClient = function() {
  var __args = arguments;
  if (__args.length === 3 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
    JRedisDataSource["getRedisClient(io.vertx.servicediscovery.ServiceDiscovery,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, utils.convParamJsonObject(__args[1]), function(ar) {
    if (ar.succeeded()) {
      __args[2](utils.convReturnVertxGen(RedisClient, ar.result()), null);
    } else {
      __args[2](null, ar.cause());
    }
  });
  }else if (__args.length === 4 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
    JRedisDataSource["getRedisClient(io.vertx.servicediscovery.ServiceDiscovery,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, utils.convParamJsonObject(__args[1]), utils.convParamJsonObject(__args[2]), function(ar) {
    if (ar.succeeded()) {
      __args[3](utils.convReturnVertxGen(RedisClient, ar.result()), null);
    } else {
      __args[3](null, ar.cause());
    }
  });
  } else throw new TypeError('function invoked with invalid arguments');
};

module.exports = RedisDataSource;