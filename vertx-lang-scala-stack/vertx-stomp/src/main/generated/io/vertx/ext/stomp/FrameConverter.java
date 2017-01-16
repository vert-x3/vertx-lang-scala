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

package io.vertx.ext.stomp;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link io.vertx.ext.stomp.Frame}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.stomp.Frame} original class using Vert.x codegen.
 */
public class FrameConverter {

  public static void fromJson(JsonObject json, Frame obj) {
    if (json.getValue("body") instanceof String) {
      obj.setBody(io.vertx.core.buffer.Buffer.buffer(java.util.Base64.getDecoder().decode((String)json.getValue("body"))));
    }
    if (json.getValue("command") instanceof String) {
      obj.setCommand(io.vertx.ext.stomp.Frame.Command.valueOf((String)json.getValue("command")));
    }
    if (json.getValue("destination") instanceof String) {
      obj.setDestination((String)json.getValue("destination"));
    }
    if (json.getValue("headers") instanceof JsonObject) {
      json.getJsonObject("headers").forEach(entry -> {
        if (entry.getValue() instanceof String)
          obj.addHeader(entry.getKey(), (String)entry.getValue());
      });
    }
    if (json.getValue("id") instanceof String) {
      obj.setId((String)json.getValue("id"));
    }
    if (json.getValue("transaction") instanceof String) {
      obj.setTransaction((String)json.getValue("transaction"));
    }
  }

  public static void toJson(Frame obj, JsonObject json) {
    if (obj.getAck() != null) {
      json.put("ack", obj.getAck());
    }
    if (obj.getBody() != null) {
      json.put("body", obj.getBody().getBytes());
    }
    if (obj.getBodyAsString() != null) {
      json.put("bodyAsString", obj.getBodyAsString());
    }
    if (obj.getCommand() != null) {
      json.put("command", obj.getCommand().name());
    }
    if (obj.getDestination() != null) {
      json.put("destination", obj.getDestination());
    }
    if (obj.getHeaders() != null) {
      JsonObject map = new JsonObject();
      obj.getHeaders().forEach((key,value) -> map.put(key, value));
      json.put("headers", map);
    }
    if (obj.getId() != null) {
      json.put("id", obj.getId());
    }
    if (obj.getReceipt() != null) {
      json.put("receipt", obj.getReceipt());
    }
    if (obj.getTransaction() != null) {
      json.put("transaction", obj.getTransaction());
    }
  }
}