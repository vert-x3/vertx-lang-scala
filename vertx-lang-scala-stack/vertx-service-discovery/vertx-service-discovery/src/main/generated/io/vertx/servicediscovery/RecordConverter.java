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

package io.vertx.servicediscovery;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link io.vertx.servicediscovery.Record}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.servicediscovery.Record} original class using Vert.x codegen.
 */
public class RecordConverter {

  public static void fromJson(JsonObject json, Record obj) {
    if (json.getValue("location") instanceof JsonObject) {
      obj.setLocation(((JsonObject)json.getValue("location")).copy());
    }
    if (json.getValue("metadata") instanceof JsonObject) {
      obj.setMetadata(((JsonObject)json.getValue("metadata")).copy());
    }
    if (json.getValue("name") instanceof String) {
      obj.setName((String)json.getValue("name"));
    }
    if (json.getValue("registration") instanceof String) {
      obj.setRegistration((String)json.getValue("registration"));
    }
    if (json.getValue("status") instanceof String) {
      obj.setStatus(io.vertx.servicediscovery.Status.valueOf((String)json.getValue("status")));
    }
    if (json.getValue("type") instanceof String) {
      obj.setType((String)json.getValue("type"));
    }
  }

  public static void toJson(Record obj, JsonObject json) {
    if (obj.getLocation() != null) {
      json.put("location", obj.getLocation());
    }
    if (obj.getMetadata() != null) {
      json.put("metadata", obj.getMetadata());
    }
    if (obj.getName() != null) {
      json.put("name", obj.getName());
    }
    if (obj.getRegistration() != null) {
      json.put("registration", obj.getRegistration());
    }
    if (obj.getStatus() != null) {
      json.put("status", obj.getStatus().name());
    }
    if (obj.getType() != null) {
      json.put("type", obj.getType());
    }
  }
}