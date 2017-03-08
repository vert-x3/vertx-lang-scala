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

package io.vertx.config;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link io.vertx.config.ConfigRetrieverOptions}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.config.ConfigRetrieverOptions} original class using Vert.x codegen.
 */
public class ConfigRetrieverOptionsConverter {

  public static void fromJson(JsonObject json, ConfigRetrieverOptions obj) {
    if (json.getValue("scanPeriod") instanceof Number) {
      obj.setScanPeriod(((Number)json.getValue("scanPeriod")).longValue());
    }
    if (json.getValue("stores") instanceof JsonArray) {
      json.getJsonArray("stores").forEach(item -> {
        if (item instanceof JsonObject)
          obj.addStore(new io.vertx.config.ConfigStoreOptions((JsonObject)item));
      });
    }
  }

  public static void toJson(ConfigRetrieverOptions obj, JsonObject json) {
    json.put("scanPeriod", obj.getScanPeriod());
    if (obj.getStores() != null) {
      JsonArray array = new JsonArray();
      obj.getStores().forEach(item -> array.add(item.toJson()));
      json.put("stores", array);
    }
  }
}