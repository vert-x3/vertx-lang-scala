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

package io.vertx.servicediscovery.types;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link io.vertx.servicediscovery.types.HttpLocation}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.servicediscovery.types.HttpLocation} original class using Vert.x codegen.
 */
public class HttpLocationConverter {

  public static void fromJson(JsonObject json, HttpLocation obj) {
    if (json.getValue("endpoint") instanceof String) {
      obj.setEndpoint((String)json.getValue("endpoint"));
    }
    if (json.getValue("host") instanceof String) {
      obj.setHost((String)json.getValue("host"));
    }
    if (json.getValue("port") instanceof Number) {
      obj.setPort(((Number)json.getValue("port")).intValue());
    }
    if (json.getValue("root") instanceof String) {
      obj.setRoot((String)json.getValue("root"));
    }
    if (json.getValue("ssl") instanceof Boolean) {
      obj.setSsl((Boolean)json.getValue("ssl"));
    }
  }

  public static void toJson(HttpLocation obj, JsonObject json) {
    if (obj.getEndpoint() != null) {
      json.put("endpoint", obj.getEndpoint());
    }
    if (obj.getHost() != null) {
      json.put("host", obj.getHost());
    }
    json.put("port", obj.getPort());
    if (obj.getRoot() != null) {
      json.put("root", obj.getRoot());
    }
    json.put("ssl", obj.isSsl());
  }
}