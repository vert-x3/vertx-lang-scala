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

package io.vertx.kafka.client.common;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link io.vertx.kafka.client.common.PartitionInfo}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.kafka.client.common.PartitionInfo} original class using Vert.x codegen.
 */
public class PartitionInfoConverter {

  public static void fromJson(JsonObject json, PartitionInfo obj) {
    if (json.getValue("inSyncReplicas") instanceof JsonArray) {
      java.util.ArrayList<io.vertx.kafka.client.common.Node> list = new java.util.ArrayList<>();
      json.getJsonArray("inSyncReplicas").forEach( item -> {
        if (item instanceof JsonObject)
          list.add(new io.vertx.kafka.client.common.Node((JsonObject)item));
      });
      obj.setInSyncReplicas(list);
    }
    if (json.getValue("leader") instanceof JsonObject) {
      obj.setLeader(new io.vertx.kafka.client.common.Node((JsonObject)json.getValue("leader")));
    }
    if (json.getValue("partition") instanceof Number) {
      obj.setPartition(((Number)json.getValue("partition")).intValue());
    }
    if (json.getValue("replicas") instanceof JsonArray) {
      java.util.ArrayList<io.vertx.kafka.client.common.Node> list = new java.util.ArrayList<>();
      json.getJsonArray("replicas").forEach( item -> {
        if (item instanceof JsonObject)
          list.add(new io.vertx.kafka.client.common.Node((JsonObject)item));
      });
      obj.setReplicas(list);
    }
    if (json.getValue("topic") instanceof String) {
      obj.setTopic((String)json.getValue("topic"));
    }
  }

  public static void toJson(PartitionInfo obj, JsonObject json) {
    if (obj.getInSyncReplicas() != null) {
      JsonArray array = new JsonArray();
      obj.getInSyncReplicas().forEach(item -> array.add(item.toJson()));
      json.put("inSyncReplicas", array);
    }
    if (obj.getLeader() != null) {
      json.put("leader", obj.getLeader().toJson());
    }
    json.put("partition", obj.getPartition());
    if (obj.getReplicas() != null) {
      JsonArray array = new JsonArray();
      obj.getReplicas().forEach(item -> array.add(item.toJson()));
      json.put("replicas", array);
    }
    if (obj.getTopic() != null) {
      json.put("topic", obj.getTopic());
    }
  }
}