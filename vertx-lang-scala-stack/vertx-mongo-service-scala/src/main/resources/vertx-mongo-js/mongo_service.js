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

/** @module vertx-mongo-js/mongo_service */
var utils = require('vertx-js/util/utils');
var Vertx = require('vertx-js/vertx');
var MongoClient = require('vertx-mongo-js/mongo_client');

var io = Packages.io;
var JsonObject = io.vertx.core.json.JsonObject;
var JMongoService = io.vertx.ext.mongo.MongoService;
var MongoClientDeleteResult = io.vertx.ext.mongo.MongoClientDeleteResult;
var IndexOptions = io.vertx.ext.mongo.IndexOptions;
var FindOptions = io.vertx.ext.mongo.FindOptions;
var MongoClientUpdateResult = io.vertx.ext.mongo.MongoClientUpdateResult;
var UpdateOptions = io.vertx.ext.mongo.UpdateOptions;

/**

 @class
*/
var MongoService = function(j_val) {

  var j_mongoService = j_val;
  var that = this;
  MongoClient.call(this, j_val);

  /**

   @public
   @param collection {string} 
   @param document {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.save = function(collection, document, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      j_mongoService["save(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(document), function(ar) {
      if (ar.succeeded()) {
        resultHandler(ar.result(), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param document {Object} 
   @param writeOption {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.saveWithOptions = function(collection, document, writeOption, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_mongoService["saveWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.WriteOption,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(document), io.vertx.ext.mongo.WriteOption.valueOf(writeOption), function(ar) {
      if (ar.succeeded()) {
        resultHandler(ar.result(), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param document {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.insert = function(collection, document, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      j_mongoService["insert(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(document), function(ar) {
      if (ar.succeeded()) {
        resultHandler(ar.result(), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param document {Object} 
   @param writeOption {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.insertWithOptions = function(collection, document, writeOption, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_mongoService["insertWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.WriteOption,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(document), io.vertx.ext.mongo.WriteOption.valueOf(writeOption), function(ar) {
      if (ar.succeeded()) {
        resultHandler(ar.result(), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param update {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.update = function(collection, query, update, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
      j_mongoService["update(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(update), function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param update {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.updateCollection = function(collection, query, update, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
      j_mongoService["updateCollection(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(update), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param update {Object} 
   @param options {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.updateWithOptions = function(collection, query, update, options, resultHandler) {
    var __args = arguments;
    if (__args.length === 5 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && (typeof __args[3] === 'object' && __args[3] != null) && typeof __args[4] === 'function') {
      j_mongoService["updateWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.UpdateOptions,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(update), options != null ? new UpdateOptions(new JsonObject(JSON.stringify(options))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param update {Object} 
   @param options {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.updateCollectionWithOptions = function(collection, query, update, options, resultHandler) {
    var __args = arguments;
    if (__args.length === 5 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && (typeof __args[3] === 'object' && __args[3] != null) && typeof __args[4] === 'function') {
      j_mongoService["updateCollectionWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.UpdateOptions,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(update), options != null ? new UpdateOptions(new JsonObject(JSON.stringify(options))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param replace {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.replace = function(collection, query, replace, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
      j_mongoService["replace(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(replace), function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param replace {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.replaceDocuments = function(collection, query, replace, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
      j_mongoService["replaceDocuments(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(replace), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param replace {Object} 
   @param options {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.replaceWithOptions = function(collection, query, replace, options, resultHandler) {
    var __args = arguments;
    if (__args.length === 5 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && (typeof __args[3] === 'object' && __args[3] != null) && typeof __args[4] === 'function') {
      j_mongoService["replaceWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.UpdateOptions,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(replace), options != null ? new UpdateOptions(new JsonObject(JSON.stringify(options))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param replace {Object} 
   @param options {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.replaceDocumentsWithOptions = function(collection, query, replace, options, resultHandler) {
    var __args = arguments;
    if (__args.length === 5 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && (typeof __args[3] === 'object' && __args[3] != null) && typeof __args[4] === 'function') {
      j_mongoService["replaceDocumentsWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.UpdateOptions,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(replace), options != null ? new UpdateOptions(new JsonObject(JSON.stringify(options))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.find = function(collection, query, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      j_mongoService["find(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnListSetJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.findBatch = function(collection, query, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      j_mongoService["findBatch(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param options {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.findWithOptions = function(collection, query, options, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
      j_mongoService["findWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.FindOptions,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), options != null ? new FindOptions(new JsonObject(JSON.stringify(options))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnListSetJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param options {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.findBatchWithOptions = function(collection, query, options, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
      j_mongoService["findBatchWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.FindOptions,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), options != null ? new FindOptions(new JsonObject(JSON.stringify(options))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param fields {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.findOne = function(collection, query, fields, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
      j_mongoService["findOne(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(fields), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param update {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.findOneAndUpdate = function(collection, query, update, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
      j_mongoService["findOneAndUpdate(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(update), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param update {Object} 
   @param findOptions {Object} 
   @param updateOptions {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.findOneAndUpdateWithOptions = function(collection, query, update, findOptions, updateOptions, resultHandler) {
    var __args = arguments;
    if (__args.length === 6 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && (typeof __args[3] === 'object' && __args[3] != null) && (typeof __args[4] === 'object' && __args[4] != null) && typeof __args[5] === 'function') {
      j_mongoService["findOneAndUpdateWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.FindOptions,io.vertx.ext.mongo.UpdateOptions,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(update), findOptions != null ? new FindOptions(new JsonObject(JSON.stringify(findOptions))) : null, updateOptions != null ? new UpdateOptions(new JsonObject(JSON.stringify(updateOptions))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param replace {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.findOneAndReplace = function(collection, query, replace, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
      j_mongoService["findOneAndReplace(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(replace), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param update {Object} 
   @param findOptions {Object} 
   @param updateOptions {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.findOneAndReplaceWithOptions = function(collection, query, update, findOptions, updateOptions, resultHandler) {
    var __args = arguments;
    if (__args.length === 6 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && (typeof __args[3] === 'object' && __args[3] != null) && (typeof __args[4] === 'object' && __args[4] != null) && typeof __args[5] === 'function') {
      j_mongoService["findOneAndReplaceWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.FindOptions,io.vertx.ext.mongo.UpdateOptions,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), utils.convParamJsonObject(update), findOptions != null ? new FindOptions(new JsonObject(JSON.stringify(findOptions))) : null, updateOptions != null ? new UpdateOptions(new JsonObject(JSON.stringify(updateOptions))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.findOneAndDelete = function(collection, query, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      j_mongoService["findOneAndDelete(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param findOptions {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.findOneAndDeleteWithOptions = function(collection, query, findOptions, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
      j_mongoService["findOneAndDeleteWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.FindOptions,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), findOptions != null ? new FindOptions(new JsonObject(JSON.stringify(findOptions))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.count = function(collection, query, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      j_mongoService["count(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnLong(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.remove = function(collection, query, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      j_mongoService["remove(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.removeDocuments = function(collection, query, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      j_mongoService["removeDocuments(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param writeOption {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.removeWithOptions = function(collection, query, writeOption, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_mongoService["removeWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.WriteOption,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), io.vertx.ext.mongo.WriteOption.valueOf(writeOption), function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param writeOption {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.removeDocumentsWithOptions = function(collection, query, writeOption, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_mongoService["removeDocumentsWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.WriteOption,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), io.vertx.ext.mongo.WriteOption.valueOf(writeOption), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.removeOne = function(collection, query, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      j_mongoService["removeOne(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.removeDocument = function(collection, query, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      j_mongoService["removeDocument(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param writeOption {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.removeOneWithOptions = function(collection, query, writeOption, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_mongoService["removeOneWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.WriteOption,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), io.vertx.ext.mongo.WriteOption.valueOf(writeOption), function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param query {Object} 
   @param writeOption {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.removeDocumentWithOptions = function(collection, query, writeOption, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_mongoService["removeDocumentWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.WriteOption,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(query), io.vertx.ext.mongo.WriteOption.valueOf(writeOption), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnDataObject(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collectionName {string} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.createCollection = function(collectionName, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
      j_mongoService["createCollection(java.lang.String,io.vertx.core.Handler)"](collectionName, function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.getCollections = function(resultHandler) {
    var __args = arguments;
    if (__args.length === 1 && typeof __args[0] === 'function') {
      j_mongoService["getCollections(io.vertx.core.Handler)"](function(ar) {
      if (ar.succeeded()) {
        resultHandler(ar.result(), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.dropCollection = function(collection, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
      j_mongoService["dropCollection(java.lang.String,io.vertx.core.Handler)"](collection, function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param key {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.createIndex = function(collection, key, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      j_mongoService["createIndex(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(key), function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param key {Object} 
   @param options {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.createIndexWithOptions = function(collection, key, options, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && (typeof __args[2] === 'object' && __args[2] != null) && typeof __args[3] === 'function') {
      j_mongoService["createIndexWithOptions(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.ext.mongo.IndexOptions,io.vertx.core.Handler)"](collection, utils.convParamJsonObject(key), options != null ? new IndexOptions(new JsonObject(JSON.stringify(options))) : null, function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.listIndexes = function(collection, resultHandler) {
    var __args = arguments;
    if (__args.length === 2 && typeof __args[0] === 'string' && typeof __args[1] === 'function') {
      j_mongoService["listIndexes(java.lang.String,io.vertx.core.Handler)"](collection, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param indexName {string} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.dropIndex = function(collection, indexName, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && typeof __args[1] === 'string' && typeof __args[2] === 'function') {
      j_mongoService["dropIndex(java.lang.String,java.lang.String,io.vertx.core.Handler)"](collection, indexName, function(ar) {
      if (ar.succeeded()) {
        resultHandler(null, null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param commandName {string} 
   @param command {Object} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.runCommand = function(commandName, command, resultHandler) {
    var __args = arguments;
    if (__args.length === 3 && typeof __args[0] === 'string' && (typeof __args[1] === 'object' && __args[1] != null) && typeof __args[2] === 'function') {
      j_mongoService["runCommand(java.lang.String,io.vertx.core.json.JsonObject,io.vertx.core.Handler)"](commandName, utils.convParamJsonObject(command), function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param fieldName {string} 
   @param resultClassname {string} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.distinct = function(collection, fieldName, resultClassname, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && typeof __args[1] === 'string' && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_mongoService["distinct(java.lang.String,java.lang.String,java.lang.String,io.vertx.core.Handler)"](collection, fieldName, resultClassname, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public
   @param collection {string} 
   @param fieldName {string} 
   @param resultClassname {string} 
   @param resultHandler {function} 
   @return {MongoService}
   */
  this.distinctBatch = function(collection, fieldName, resultClassname, resultHandler) {
    var __args = arguments;
    if (__args.length === 4 && typeof __args[0] === 'string' && typeof __args[1] === 'string' && typeof __args[2] === 'string' && typeof __args[3] === 'function') {
      j_mongoService["distinctBatch(java.lang.String,java.lang.String,java.lang.String,io.vertx.core.Handler)"](collection, fieldName, resultClassname, function(ar) {
      if (ar.succeeded()) {
        resultHandler(utils.convReturnJson(ar.result()), null);
      } else {
        resultHandler(null, ar.cause());
      }
    });
      return that;
    } else throw new TypeError('function invoked with invalid arguments');
  };

  /**

   @public

   */
  this.close = function() {
    var __args = arguments;
    if (__args.length === 0) {
      j_mongoService["close()"]();
    } else throw new TypeError('function invoked with invalid arguments');
  };

  // A reference to the underlying Java delegate
  // NOTE! This is an internal API and must not be used in user code.
  // If you rely on this property your code is likely to break if we change it / remove it without warning.
  this._jdel = j_mongoService;
};

/**
 Create a proxy to a service that is deployed somewhere on the event bus

 @memberof module:vertx-mongo-js/mongo_service
 @param vertx {Vertx} the Vert.x instance 
 @param address {string} the address the service is listening on on the event bus 
 @return {MongoService} the service
 */
MongoService.createEventBusProxy = function(vertx, address) {
  var __args = arguments;
  if (__args.length === 2 && typeof __args[0] === 'object' && __args[0]._jdel && typeof __args[1] === 'string') {
    return utils.convReturnVertxGen(JMongoService["createEventBusProxy(io.vertx.core.Vertx,java.lang.String)"](vertx._jdel, address), MongoService);
  } else throw new TypeError('function invoked with invalid arguments');
};

// We export the Constructor function
module.exports = MongoService;