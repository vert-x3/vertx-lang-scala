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

package io.vertx.ext.shell.term;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link io.vertx.ext.shell.term.TelnetTermOptions}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.shell.term.TelnetTermOptions} original class using Vert.x codegen.
 */
public class TelnetTermOptionsConverter {

  public static void fromJson(JsonObject json, TelnetTermOptions obj) {
    if (json.getValue("charset") instanceof String) {
      obj.setCharset((String)json.getValue("charset"));
    }
    if (json.getValue("inBinary") instanceof Boolean) {
      obj.setInBinary((Boolean)json.getValue("inBinary"));
    }
    if (json.getValue("intputrc") instanceof String) {
      obj.setIntputrc((String)json.getValue("intputrc"));
    }
    if (json.getValue("outBinary") instanceof Boolean) {
      obj.setOutBinary((Boolean)json.getValue("outBinary"));
    }
  }

  public static void toJson(TelnetTermOptions obj, JsonObject json) {
    if (obj.getCharset() != null) {
      json.put("charset", obj.getCharset());
    }
    json.put("inBinary", obj.getInBinary());
    if (obj.getIntputrc() != null) {
      json.put("intputrc", obj.getIntputrc());
    }
    json.put("outBinary", obj.getOutBinary());
  }
}