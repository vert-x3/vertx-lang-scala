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

/** @module vertx-service-discovery-js/http_endpoint */
var utils = require('vertx-js/util/utils');
var WebClient = require('vertx-web-client-js/web_client');
var ServiceDiscovery = require('vertx-service-discovery-js/service_discovery');
var HttpClient = require('vertx-js/http_client');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JHttpEndpoint = Java.type('io.vertx.servicediscovery.types.HttpEndpoint');
var Record = Java.type('io.vertx.servicediscovery.Record');

/**

 @class
*/
var HttpEndpoint = function(j_val) {

  var j_httpEndpoint = j_val;
  var that = this;

  // A reference to the underlying Java delegate
  // NOTE! This is an builder API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_httpEndpoint;
};

HttpEndpoint._jclass = utils.getJavaClass("io.vertx.servicediscovery.types.HttpEndpoint");
HttpEndpoint._jtype = {
  accept: function(obj) {
    return HttpEndpoint._jclass.isInstance(obj._jdel);
  },
  wrap: function(jdel) {
    var obj = Object.create(HttpEndpoint.prototype, {});
    HttpEndpoint.apply(obj, arguments);
    return obj;
  },
  unwrap: function(obj) {
    return obj._jdel;
  }
};
HttpEndpoint._create = function(jdel) {
  var obj = Object.create(HttpEndpoint.prototype, {});
  HttpEndpoint.apply(obj, arguments);
  return obj;
}
/**
 Same as {@link HttpEndpoint#createRecord} but let you configure whether or not the
 service is using <code>https</code>.

 @memberof module:vertx-service-discovery-js/http_endpoint
 @param name {string} the service name 
 @param ssl {boolean} whether or not the service is using HTTPS 
 @param host {string} the host (IP or DNS name), it must be the _public_ IP / name 
 @param port {number} the port, it must be the _public_ port 
 @param root {string} the path of the service, "/" if not set 
 @param metadata {Object} additional metadata 
 @return {Object} the created record
 */
HttpEndpoint.createRecord = function() {
  var __args = arguments;
  if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'string') {
    return utils.convReturnDataObject(JHttpEndpoint["createRecord(java.lang.String,java.lang.String)"](__args[0], __args[1]));
  }else if (__args.length === 4 && typeof __args[0] === 'string' && typeof __args[1] === 'string' && typeof __args[2] ==='number' && typeof __args[3] === 'string') {
    return utils.convReturnDataObject(JHttpEndpoint["createRecord(java.lang.String,java.lang.String,int,java.lang.String)"](__args[0], __args[1], __args[2], __args[3]));
  }else if (__args.length === 5 && typeof __args[0] === 'string' && typeof __args[1] === 'string' && typeof __args[2] ==='number' && typeof __args[3] === 'string' && (typeof __args[4] === 'object' && __args[4] != null)) {
    return utils.convReturnDataObject(JHttpEndpoint["createRecord(java.lang.String,java.lang.String,int,java.lang.String,io.vertx.core.json.JsonObject)"](__args[0], __args[1], __args[2], __args[3], utils.convParamJsonObject(__args[4])));
  }else if (__args.length === 6 && typeof __args[0] === 'string' && typeof __args[1] ==='boolean' && typeof __args[2] === 'string' && typeof __args[3] ==='number' && typeof __args[4] === 'string' && (typeof __args[5] === 'object' && __args[5] != null)) {
    return utils.convReturnDataObject(JHttpEndpoint["createRecord(java.lang.String,boolean,java.lang.String,int,java.lang.String,io.vertx.core.json.JsonObject)"](__args[0], __args[1], __args[2], __args[3], __args[4], utils.convParamJsonObject(__args[5])));
  } else throw new TypeError('function invoked with invalid arguments');
};

/**
 Convenient method that looks for a HTTP endpoint and provides the configured . The async result
 is marked as failed is there are no matching services, or if the lookup fails. This method accepts a
 configuration for the HTTP client.

 @memberof module:vertx-service-discovery-js/http_endpoint
 @param discovery {ServiceDiscovery} The service discovery instance 
 @param filter {todo} The filter 
 @param conf {Object} the configuration of the client 
 @param resultHandler {function} The result handler 
 */
HttpEndpoint.getClient = function() {
  var __args = arguments;
  if (__args.length === 3 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
    JHttpEndpoint["getClient(io.vertx.servicediscovery.ServiceDiscovery,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, utils.convParamJsonObject(__args[1]), function(ar) {
    if (ar.succeeded()) {
      __args[2](utils.convReturnVertxGen(HttpClient, ar.result()), null);
    } else {
      __args[2](null, ar.cause());
    }
  });
  }else if (__args.length === 3 && typeof __args[0] === 'object' && __args[0]._jdel && typeof __args[1] === 'function' && typeof __args[2] === 'function') {
    JHttpEndpoint["getClient(io.vertx.servicediscovery.ServiceDiscovery,java.util.function.Function,io.vertx.core.Handler)"](__args[0]._jdel, function(jVal) {
    var jRet = __args[1](utils.convReturnDataObject(jVal));
    return jRet;
  }, function(ar) {
    if (ar.succeeded()) {
      __args[2](utils.convReturnVertxGen(HttpClient, ar.result()), null);
    } else {
      __args[2](null, ar.cause());
    }
  });
  }else if (__args.length === 4 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
    JHttpEndpoint["getClient(io.vertx.servicediscovery.ServiceDiscovery,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, utils.convParamJsonObject(__args[1]), utils.convParamJsonObject(__args[2]), function(ar) {
    if (ar.succeeded()) {
      __args[3](utils.convReturnVertxGen(HttpClient, ar.result()), null);
    } else {
      __args[3](null, ar.cause());
    }
  });
  }else if (__args.length === 4 && typeof __args[0] === 'object' && __args[0]._jdel && typeof __args[1] === 'function' && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
    JHttpEndpoint["getClient(io.vertx.servicediscovery.ServiceDiscovery,java.util.function.Function,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, function(jVal) {
    var jRet = __args[1](utils.convReturnDataObject(jVal));
    return jRet;
  }, utils.convParamJsonObject(__args[2]), function(ar) {
    if (ar.succeeded()) {
      __args[3](utils.convReturnVertxGen(HttpClient, ar.result()), null);
    } else {
      __args[3](null, ar.cause());
    }
  });
  } else throw new TypeError('function invoked with invalid arguments');
};

/**
 Convenient method that looks for a HTTP endpoint and provides the configured . The async result
 is marked as failed is there are no matching services, or if the lookup fails. This method accepts a
 configuration for the HTTP client.

 @memberof module:vertx-service-discovery-js/http_endpoint
 @param discovery {ServiceDiscovery} The service discovery instance 
 @param filter {todo} The filter 
 @param conf {Object} the configuration of the client 
 @param resultHandler {function} The result handler 
 */
HttpEndpoint.getWebClient = function() {
  var __args = arguments;
  if (__args.length === 3 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
    JHttpEndpoint["getWebClient(io.vertx.servicediscovery.ServiceDiscovery,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, utils.convParamJsonObject(__args[1]), function(ar) {
    if (ar.succeeded()) {
      __args[2](utils.convReturnVertxGen(WebClient, ar.result()), null);
    } else {
      __args[2](null, ar.cause());
    }
  });
  }else if (__args.length === 3 && typeof __args[0] === 'object' && __args[0]._jdel && typeof __args[1] === 'function' && typeof __args[2] === 'function') {
    JHttpEndpoint["getWebClient(io.vertx.servicediscovery.ServiceDiscovery,java.util.function.Function,io.vertx.core.Handler)"](__args[0]._jdel, function(jVal) {
    var jRet = __args[1](utils.convReturnDataObject(jVal));
    return jRet;
  }, function(ar) {
    if (ar.succeeded()) {
      __args[2](utils.convReturnVertxGen(WebClient, ar.result()), null);
    } else {
      __args[2](null, ar.cause());
    }
  });
  }else if (__args.length === 4 && typeof __args[0] === 'object' && __args[0]._jdel && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
    JHttpEndpoint["getWebClient(io.vertx.servicediscovery.ServiceDiscovery,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, utils.convParamJsonObject(__args[1]), utils.convParamJsonObject(__args[2]), function(ar) {
    if (ar.succeeded()) {
      __args[3](utils.convReturnVertxGen(WebClient, ar.result()), null);
    } else {
      __args[3](null, ar.cause());
    }
  });
  }else if (__args.length === 4 && typeof __args[0] === 'object' && __args[0]._jdel && typeof __args[1] === 'function' && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
    JHttpEndpoint["getWebClient(io.vertx.servicediscovery.ServiceDiscovery,java.util.function.Function,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](__args[0]._jdel, function(jVal) {
    var jRet = __args[1](utils.convReturnDataObject(jVal));
    return jRet;
  }, utils.convParamJsonObject(__args[2]), function(ar) {
    if (ar.succeeded()) {
      __args[3](utils.convReturnVertxGen(WebClient, ar.result()), null);
    } else {
      __args[3](null, ar.cause());
    }
  });
  } else throw new TypeError('function invoked with invalid arguments');
};

module.exports = HttpEndpoint;
