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

package io.vertx.amqpbridge;

import io.vertx.core.json.JsonObject;
import io.vertx.core.json.JsonArray;

/**
 * Converter for {@link io.vertx.amqpbridge.AmqpBridgeOptions}.
 *
 * NOTE: This class has been automatically generated from the {@link io.vertx.amqpbridge.AmqpBridgeOptions} original class using Vert.x codegen.
 */
public class AmqpBridgeOptionsConverter {

  public static void fromJson(JsonObject json, AmqpBridgeOptions obj) {
    if (json.getValue("connectTimeout") instanceof Number) {
      obj.setConnectTimeout(((Number)json.getValue("connectTimeout")).intValue());
    }
    if (json.getValue("containerId") instanceof String) {
      obj.setContainerId((String)json.getValue("containerId"));
    }
    if (json.getValue("crlPaths") instanceof JsonArray) {
      json.getJsonArray("crlPaths").forEach(item -> {
        if (item instanceof String)
          obj.addCrlPath((String)item);
      });
    }
    if (json.getValue("crlValues") instanceof JsonArray) {
      json.getJsonArray("crlValues").forEach(item -> {
        if (item instanceof String)
          obj.addCrlValue(io.vertx.core.buffer.Buffer.buffer(java.util.Base64.getDecoder().decode((String)item)));
      });
    }
    if (json.getValue("enabledCipherSuites") instanceof JsonArray) {
      json.getJsonArray("enabledCipherSuites").forEach(item -> {
        if (item instanceof String)
          obj.addEnabledCipherSuite((String)item);
      });
    }
    if (json.getValue("enabledSaslMechanisms") instanceof JsonArray) {
      json.getJsonArray("enabledSaslMechanisms").forEach(item -> {
        if (item instanceof String)
          obj.addEnabledSaslMechanism((String)item);
      });
    }
    if (json.getValue("enabledSecureTransportProtocols") instanceof JsonArray) {
      json.getJsonArray("enabledSecureTransportProtocols").forEach(item -> {
        if (item instanceof String)
          obj.addEnabledSecureTransportProtocol((String)item);
      });
    }
    if (json.getValue("heartbeat") instanceof Number) {
      obj.setHeartbeat(((Number)json.getValue("heartbeat")).intValue());
    }
    if (json.getValue("hostnameVerificationAlgorithm") instanceof String) {
      obj.setHostnameVerificationAlgorithm((String)json.getValue("hostnameVerificationAlgorithm"));
    }
    if (json.getValue("idleTimeout") instanceof Number) {
      obj.setIdleTimeout(((Number)json.getValue("idleTimeout")).intValue());
    }
    if (json.getValue("jdkSslEngineOptions") instanceof JsonObject) {
      obj.setJdkSslEngineOptions(new io.vertx.core.net.JdkSSLEngineOptions((JsonObject)json.getValue("jdkSslEngineOptions")));
    }
    if (json.getValue("keyStoreOptions") instanceof JsonObject) {
      obj.setKeyStoreOptions(new io.vertx.core.net.JksOptions((JsonObject)json.getValue("keyStoreOptions")));
    }
    if (json.getValue("localAddress") instanceof String) {
      obj.setLocalAddress((String)json.getValue("localAddress"));
    }
    if (json.getValue("logActivity") instanceof Boolean) {
      obj.setLogActivity((Boolean)json.getValue("logActivity"));
    }
    if (json.getValue("metricsName") instanceof String) {
      obj.setMetricsName((String)json.getValue("metricsName"));
    }
    if (json.getValue("openSslEngineOptions") instanceof JsonObject) {
      obj.setOpenSslEngineOptions(new io.vertx.core.net.OpenSSLEngineOptions((JsonObject)json.getValue("openSslEngineOptions")));
    }
    if (json.getValue("pemKeyCertOptions") instanceof JsonObject) {
      obj.setPemKeyCertOptions(new io.vertx.core.net.PemKeyCertOptions((JsonObject)json.getValue("pemKeyCertOptions")));
    }
    if (json.getValue("pemTrustOptions") instanceof JsonObject) {
      obj.setPemTrustOptions(new io.vertx.core.net.PemTrustOptions((JsonObject)json.getValue("pemTrustOptions")));
    }
    if (json.getValue("pfxKeyCertOptions") instanceof JsonObject) {
      obj.setPfxKeyCertOptions(new io.vertx.core.net.PfxOptions((JsonObject)json.getValue("pfxKeyCertOptions")));
    }
    if (json.getValue("pfxTrustOptions") instanceof JsonObject) {
      obj.setPfxTrustOptions(new io.vertx.core.net.PfxOptions((JsonObject)json.getValue("pfxTrustOptions")));
    }
    if (json.getValue("proxyOptions") instanceof JsonObject) {
      obj.setProxyOptions(new io.vertx.core.net.ProxyOptions((JsonObject)json.getValue("proxyOptions")));
    }
    if (json.getValue("receiveBufferSize") instanceof Number) {
      obj.setReceiveBufferSize(((Number)json.getValue("receiveBufferSize")).intValue());
    }
    if (json.getValue("reconnectAttempts") instanceof Number) {
      obj.setReconnectAttempts(((Number)json.getValue("reconnectAttempts")).intValue());
    }
    if (json.getValue("reconnectInterval") instanceof Number) {
      obj.setReconnectInterval(((Number)json.getValue("reconnectInterval")).longValue());
    }
    if (json.getValue("replyHandlingSupport") instanceof Boolean) {
      obj.setReplyHandlingSupport((Boolean)json.getValue("replyHandlingSupport"));
    }
    if (json.getValue("reuseAddress") instanceof Boolean) {
      obj.setReuseAddress((Boolean)json.getValue("reuseAddress"));
    }
    if (json.getValue("sendBufferSize") instanceof Number) {
      obj.setSendBufferSize(((Number)json.getValue("sendBufferSize")).intValue());
    }
    if (json.getValue("soLinger") instanceof Number) {
      obj.setSoLinger(((Number)json.getValue("soLinger")).intValue());
    }
    if (json.getValue("ssl") instanceof Boolean) {
      obj.setSsl((Boolean)json.getValue("ssl"));
    }
    if (json.getValue("tcpKeepAlive") instanceof Boolean) {
      obj.setTcpKeepAlive((Boolean)json.getValue("tcpKeepAlive"));
    }
    if (json.getValue("tcpNoDelay") instanceof Boolean) {
      obj.setTcpNoDelay((Boolean)json.getValue("tcpNoDelay"));
    }
    if (json.getValue("trafficClass") instanceof Number) {
      obj.setTrafficClass(((Number)json.getValue("trafficClass")).intValue());
    }
    if (json.getValue("trustAll") instanceof Boolean) {
      obj.setTrustAll((Boolean)json.getValue("trustAll"));
    }
    if (json.getValue("trustStoreOptions") instanceof JsonObject) {
      obj.setTrustStoreOptions(new io.vertx.core.net.JksOptions((JsonObject)json.getValue("trustStoreOptions")));
    }
    if (json.getValue("useAlpn") instanceof Boolean) {
      obj.setUseAlpn((Boolean)json.getValue("useAlpn"));
    }
    if (json.getValue("usePooledBuffers") instanceof Boolean) {
      obj.setUsePooledBuffers((Boolean)json.getValue("usePooledBuffers"));
    }
    if (json.getValue("vhost") instanceof String) {
      obj.setVhost((String)json.getValue("vhost"));
    }
  }

  public static void toJson(AmqpBridgeOptions obj, JsonObject json) {
    json.put("connectTimeout", obj.getConnectTimeout());
    if (obj.getContainerId() != null) {
      json.put("containerId", obj.getContainerId());
    }
    if (obj.getCrlPaths() != null) {
      JsonArray array = new JsonArray();
      obj.getCrlPaths().forEach(item -> array.add(item));
      json.put("crlPaths", array);
    }
    if (obj.getCrlValues() != null) {
      JsonArray array = new JsonArray();
      obj.getCrlValues().forEach(item -> array.add(item.getBytes()));
      json.put("crlValues", array);
    }
    if (obj.getEnabledCipherSuites() != null) {
      JsonArray array = new JsonArray();
      obj.getEnabledCipherSuites().forEach(item -> array.add(item));
      json.put("enabledCipherSuites", array);
    }
    if (obj.getEnabledSaslMechanisms() != null) {
      JsonArray array = new JsonArray();
      obj.getEnabledSaslMechanisms().forEach(item -> array.add(item));
      json.put("enabledSaslMechanisms", array);
    }
    if (obj.getEnabledSecureTransportProtocols() != null) {
      JsonArray array = new JsonArray();
      obj.getEnabledSecureTransportProtocols().forEach(item -> array.add(item));
      json.put("enabledSecureTransportProtocols", array);
    }
    json.put("heartbeat", obj.getHeartbeat());
    if (obj.getHostnameVerificationAlgorithm() != null) {
      json.put("hostnameVerificationAlgorithm", obj.getHostnameVerificationAlgorithm());
    }
    json.put("idleTimeout", obj.getIdleTimeout());
    if (obj.getJdkSslEngineOptions() != null) {
      json.put("jdkSslEngineOptions", obj.getJdkSslEngineOptions().toJson());
    }
    if (obj.getKeyStoreOptions() != null) {
      json.put("keyStoreOptions", obj.getKeyStoreOptions().toJson());
    }
    if (obj.getLocalAddress() != null) {
      json.put("localAddress", obj.getLocalAddress());
    }
    json.put("logActivity", obj.getLogActivity());
    if (obj.getMetricsName() != null) {
      json.put("metricsName", obj.getMetricsName());
    }
    if (obj.getOpenSslEngineOptions() != null) {
      json.put("openSslEngineOptions", obj.getOpenSslEngineOptions().toJson());
    }
    if (obj.getPemKeyCertOptions() != null) {
      json.put("pemKeyCertOptions", obj.getPemKeyCertOptions().toJson());
    }
    if (obj.getPemTrustOptions() != null) {
      json.put("pemTrustOptions", obj.getPemTrustOptions().toJson());
    }
    if (obj.getPfxKeyCertOptions() != null) {
      json.put("pfxKeyCertOptions", obj.getPfxKeyCertOptions().toJson());
    }
    if (obj.getPfxTrustOptions() != null) {
      json.put("pfxTrustOptions", obj.getPfxTrustOptions().toJson());
    }
    if (obj.getProxyOptions() != null) {
      json.put("proxyOptions", obj.getProxyOptions().toJson());
    }
    json.put("receiveBufferSize", obj.getReceiveBufferSize());
    json.put("reconnectAttempts", obj.getReconnectAttempts());
    json.put("reconnectInterval", obj.getReconnectInterval());
    json.put("replyHandlingSupport", obj.isReplyHandlingSupport());
    json.put("reuseAddress", obj.isReuseAddress());
    json.put("sendBufferSize", obj.getSendBufferSize());
    json.put("soLinger", obj.getSoLinger());
    json.put("ssl", obj.isSsl());
    json.put("tcpKeepAlive", obj.isTcpKeepAlive());
    json.put("tcpNoDelay", obj.isTcpNoDelay());
    json.put("trafficClass", obj.getTrafficClass());
    json.put("trustAll", obj.isTrustAll());
    if (obj.getTrustStoreOptions() != null) {
      json.put("trustStoreOptions", obj.getTrustStoreOptions().toJson());
    }
    json.put("useAlpn", obj.isUseAlpn());
    json.put("usePooledBuffers", obj.isUsePooledBuffers());
    if (obj.getVhost() != null) {
      json.put("vhost", obj.getVhost());
    }
  }
}