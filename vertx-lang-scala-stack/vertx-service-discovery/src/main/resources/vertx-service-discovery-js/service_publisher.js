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

/** @module vertx-service-discovery-js/service_publisher */
var utils = require('vertx-js/util/utils');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JServicePublisher = Java.type('io.vertx.servicediscovery.spi.ServicePublisher');
var Record = Java.type('io.vertx.servicediscovery.Record');

/**
 The publisher is used by the importer to publish or unpublish records.

 @class
*/
var ServicePublisher = function(j_val) {

  var j_servicePublisher = j_val;
  var that = this;

  /**
   Publishes a record.

   @public
   @param record {Object} the record 
   @param resultHandler {function} handler called when the operation has completed (successfully or not). In case of success, the passed record has a registration id required to modify and un-register the service. 
   */
  this.publish = function(record, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && (typeof __args[0] === 'object' && __args[0] != null) && typeof __args[1] === 'function') {
      j_servicePublisher["publish(io.vertx.servicediscovery.Record,io.vertx.core.Handler)"](record != null ? new Record(new JsonObject(Java.asJSONCompatible(record))) : null, function(ar) {
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
      j_servicePublisher["unpublish(java.lang.String,io.vertx.core.Handler)"](id, function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_servicePublisher;
};

ServicePublisher._jclass = utils.getJavaClass("io.vertx.servicediscovery.spi.ServicePublisher");
ServicePublisher._jtype = {
  accept: function(obj) {
    return ServicePublisher._jclass.isInstance(obj._jdel);
  },
  wrap: function(jdel) {
    var obj = Object.create(ServicePublisher.prototype, {});
    ServicePublisher.apply(obj, arguments);
    return obj;
  },
  unwrap: function(obj) {
    return obj._jdel;
  }
};
ServicePublisher._create = function(jdel) {
  var obj = Object.create(ServicePublisher.prototype, {});
  ServicePublisher.apply(obj, arguments);
  return obj;
}
module.exports = ServicePublisher;