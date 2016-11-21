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
 * Converter for {@link io.vertx.ext.shell.term.HttpTermOptions}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.ext.shell.term.HttpTermOptions} original class using Vert.x codegen.
 */
public class HttpTermOptionsConverter {

  public static void fromJson(JsonObject json, HttpTermOptions obj) {
    if (json.getValue("charset") instanceof String) {
      obj.setCharset((String)json.getValue("charset"));
    }
    if (json.getValue("intputrc") instanceof String) {
      obj.setIntputrc((String)json.getValue("intputrc"));
    }
    if (json.getValue("shellHtmlResource") instanceof String) {
      obj.setShellHtmlResource(io.vertx.core.buffer.Buffer.buffer(java.util.Base64.getDecoder().decode((String)json.getValue("shellHtmlResource"))));
    }
    if (json.getValue("sockJSHandlerOptions") instanceof JsonObject) {
      obj.setSockJSHandlerOptions(new io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions((JsonObject)json.getValue("sockJSHandlerOptions")));
    }
    if (json.getValue("sockJSPath") instanceof String) {
      obj.setSockJSPath((String)json.getValue("sockJSPath"));
    }
    if (json.getValue("termJsResource") instanceof String) {
      obj.setTermJsResource(io.vertx.core.buffer.Buffer.buffer(java.util.Base64.getDecoder().decode((String)json.getValue("termJsResource"))));
    }
    if (json.getValue("vertsShellJsResource") instanceof String) {
      obj.setVertsShellJsResource(io.vertx.core.buffer.Buffer.buffer(java.util.Base64.getDecoder().decode((String)json.getValue("vertsShellJsResource"))));
    }
  }

  public static void toJson(HttpTermOptions obj, JsonObject json) {
    if (obj.getCharset() != null) {
      json.put("charset", obj.getCharset());
    }
    if (obj.getIntputrc() != null) {
      json.put("intputrc", obj.getIntputrc());
    }
    if (obj.getShellHtmlResource() != null) {
      json.put("shellHtmlResource", obj.getShellHtmlResource().getBytes());
    }
    if (obj.getSockJSPath() != null) {
      json.put("sockJSPath", obj.getSockJSPath());
    }
    if (obj.getTermJsResource() != null) {
      json.put("termJsResource", obj.getTermJsResource().getBytes());
    }
    if (obj.getVertsShellJsResource() != null) {
      json.put("vertsShellJsResource", obj.getVertsShellJsResource().getBytes());
    }
  }
}