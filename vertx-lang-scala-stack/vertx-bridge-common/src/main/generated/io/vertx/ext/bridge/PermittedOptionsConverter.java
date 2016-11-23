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

package io.vertx.ext.bridge;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link io.vertx.ext.bridge.PermittedOptions}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.bridge.PermittedOptions} original class using Vert.x codegen.
 */
public class PermittedOptionsConverter {

  public static void fromJson(JsonObject json, PermittedOptions obj) {
    if (json.getValue("address") instanceof String) {
      obj.setAddress((String)json.getValue("address"));
    }
    if (json.getValue("addressRegex") instanceof String) {
      obj.setAddressRegex((String)json.getValue("addressRegex"));
    }
    if (json.getValue("match") instanceof JsonObject) {
      obj.setMatch(((JsonObject)json.getValue("match")).copy());
    }
  }

  public static void toJson(PermittedOptions obj, JsonObject json) {
    if (obj.getAddress() != null) {
      json.put("address", obj.getAddress());
    }
    if (obj.getAddressRegex() != null) {
      json.put("addressRegex", obj.getAddressRegex());
    }
    if (obj.getMatch() != null) {
      json.put("match", obj.getMatch());
    }
  }
}