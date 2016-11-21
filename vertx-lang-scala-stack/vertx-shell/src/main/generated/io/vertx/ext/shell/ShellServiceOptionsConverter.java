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
 * Converter for {@link io.vertx.ext.shell.ShellServiceOptions}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.shell.ShellServiceOptions} original class using Vert.x codegen.
 */
public class ShellServiceOptionsConverter {

  public static void fromJson(JsonObject json, ShellServiceOptions obj) {
    if (json.getValue("httpOptions") instanceof JsonObject) {
      obj.setHttpOptions(new io.vertx.ext.shell.term.HttpTermOptions((JsonObject)json.getValue("httpOptions")));
    }
    if (json.getValue("sshOptions") instanceof JsonObject) {
      obj.setSSHOptions(new io.vertx.ext.shell.term.SSHTermOptions((JsonObject)json.getValue("sshOptions")));
    }
    if (json.getValue("telnetOptions") instanceof JsonObject) {
      obj.setTelnetOptions(new io.vertx.ext.shell.term.TelnetTermOptions((JsonObject)json.getValue("telnetOptions")));
    }
  }

  public static void toJson(ShellServiceOptions obj, JsonObject json) {
  }
}