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

package io.vertx.ext.shell;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link io.vertx.ext.shell.ShellServerOptions}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.shell.ShellServerOptions} original class using Vert.x codegen.
 */
public class ShellServerOptionsConverter {

  public static void fromJson(JsonObject json, ShellServerOptions obj) {
    if (json.getValue("reaperInterval") instanceof Number) {
      obj.setReaperInterval(((Number)json.getValue("reaperInterval")).longValue());
    }
    if (json.getValue("sessionTimeout") instanceof Number) {
      obj.setSessionTimeout(((Number)json.getValue("sessionTimeout")).longValue());
    }
    if (json.getValue("welcomeMessage") instanceof String) {
      obj.setWelcomeMessage((String)json.getValue("welcomeMessage"));
    }
  }

  public static void toJson(ShellServerOptions obj, JsonObject json) {
    json.put("reaperInterval", obj.getReaperInterval());
    json.put("sessionTimeout", obj.getSessionTimeout());
    if (obj.getWelcomeMessage() != null) {
      json.put("welcomeMessage", obj.getWelcomeMessage());
    }
  }
}