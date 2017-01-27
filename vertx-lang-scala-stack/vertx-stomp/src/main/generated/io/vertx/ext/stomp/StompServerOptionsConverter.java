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
 * Converter for {@link io.vertx.ext.stomp.StompServerOptions}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.stomp.StompServerOptions} original class using Vert.x codegen.
 */
public class StompServerOptionsConverter {

  public static void fromJson(JsonObject json, StompServerOptions obj) {
    if (json.getValue("heartbeat") instanceof JsonObject) {
      obj.setHeartbeat(((JsonObject)json.getValue("heartbeat")).copy());
    }
    if (json.getValue("maxBodyLength") instanceof Number) {
      obj.setMaxBodyLength(((Number)json.getValue("maxBodyLength")).intValue());
    }
    if (json.getValue("maxFrameInTransaction") instanceof Number) {
      obj.setMaxFrameInTransaction(((Number)json.getValue("maxFrameInTransaction")).intValue());
    }
    if (json.getValue("maxHeaderLength") instanceof Number) {
      obj.setMaxHeaderLength(((Number)json.getValue("maxHeaderLength")).intValue());
    }
    if (json.getValue("maxHeaders") instanceof Number) {
      obj.setMaxHeaders(((Number)json.getValue("maxHeaders")).intValue());
    }
    if (json.getValue("maxSubscriptionsByClient") instanceof Number) {
      obj.setMaxSubscriptionsByClient(((Number)json.getValue("maxSubscriptionsByClient")).intValue());
    }
    if (json.getValue("secured") instanceof Boolean) {
      obj.setSecured((Boolean)json.getValue("secured"));
    }
    if (json.getValue("sendErrorOnNoSubscriptions") instanceof Boolean) {
      obj.setSendErrorOnNoSubscriptions((Boolean)json.getValue("sendErrorOnNoSubscriptions"));
    }
    if (json.getValue("supportedVersions") instanceof JsonArray) {
      java.util.ArrayList<java.lang.String> list = new java.util.ArrayList<>();
      json.getJsonArray("supportedVersions").forEach( item -> {
        if (item instanceof String)
          list.add((String)item);
      });
      obj.setSupportedVersions(list);
    }
    if (json.getValue("timeFactor") instanceof Number) {
      obj.setTimeFactor(((Number)json.getValue("timeFactor")).intValue());
    }
    if (json.getValue("trailingLine") instanceof Boolean) {
      obj.setTrailingLine((Boolean)json.getValue("trailingLine"));
    }
    if (json.getValue("transactionChunkSize") instanceof Number) {
      obj.setTransactionChunkSize(((Number)json.getValue("transactionChunkSize")).intValue());
    }
    if (json.getValue("websocketBridge") instanceof Boolean) {
      obj.setWebsocketBridge((Boolean)json.getValue("websocketBridge"));
    }
    if (json.getValue("websocketPath") instanceof String) {
      obj.setWebsocketPath((String)json.getValue("websocketPath"));
    }
  }

  public static void toJson(StompServerOptions obj, JsonObject json) {
    if (obj.getHeartbeat() != null) {
      json.put("heartbeat", obj.getHeartbeat());
    }
    json.put("maxBodyLength", obj.getMaxBodyLength());
    json.put("maxFrameInTransaction", obj.getMaxFrameInTransaction());
    json.put("maxHeaderLength", obj.getMaxHeaderLength());
    json.put("maxHeaders", obj.getMaxHeaders());
    json.put("maxSubscriptionsByClient", obj.getMaxSubscriptionsByClient());
    json.put("secured", obj.isSecured());
    json.put("sendErrorOnNoSubscriptions", obj.isSendErrorOnNoSubscriptions());
    if (obj.getSupportedVersions() != null) {
      JsonArray array = new JsonArray();
      obj.getSupportedVersions().forEach(item -> array.add(item));
      json.put("supportedVersions", array);
    }
    json.put("timeFactor", obj.getTimeFactor());
    json.put("trailingLine", obj.isTrailingLine());
    json.put("transactionChunkSize", obj.getTransactionChunkSize());
    json.put("websocketBridge", obj.isWebsocketBridge());
    if (obj.getWebsocketPath() != null) {
      json.put("websocketPath", obj.getWebsocketPath());
    }
  }
}