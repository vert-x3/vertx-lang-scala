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


package io.vertx.scala.ext

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.mail.{MailMessage => JMailMessage}
package object mail{


  type DKIMSignOptions = io.vertx.ext.mail.DKIMSignOptions
  object DKIMSignOptions {
    def apply() = new DKIMSignOptions()
    def apply(json: JsonObject) = new DKIMSignOptions(json)
    def apply( auid: java.lang.String = null, bodyCanonAlgo: io.vertx.ext.mail.CanonicalizationAlgorithm = null, bodyLimit: java.lang.Integer = null, copiedHeaders: scala.collection.immutable.List[java.lang.String] = null, expireTime: java.lang.Long = null, headerCanonAlgo: io.vertx.ext.mail.CanonicalizationAlgorithm = null, privateKey: java.lang.String = null, privateKeyPath: java.lang.String = null, sdid: java.lang.String = null, selector: java.lang.String = null, signAlgo: io.vertx.ext.mail.DKIMSignAlgorithm = null, signatureTimestamp: java.lang.Boolean = null, signedHeaders: scala.collection.immutable.List[java.lang.String] = null): DKIMSignOptions = {
      val ret = new DKIMSignOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (auid != null) ret.setAuid(auid) 
      if (bodyCanonAlgo != null) ret.setBodyCanonAlgo(bodyCanonAlgo) 
      if (bodyLimit != null) ret.setBodyLimit(bodyLimit) 
      if (copiedHeaders != null) ret.setCopiedHeaders(copiedHeaders.asJava) 
      if (expireTime != null) ret.setExpireTime(expireTime) 
      if (headerCanonAlgo != null) ret.setHeaderCanonAlgo(headerCanonAlgo) 
      if (privateKey != null) ret.setPrivateKey(privateKey) 
      if (privateKeyPath != null) ret.setPrivateKeyPath(privateKeyPath) 
      if (sdid != null) ret.setSdid(sdid) 
      if (selector != null) ret.setSelector(selector) 
      if (signAlgo != null) ret.setSignAlgo(signAlgo) 
      if (signatureTimestamp != null) ret.setSignatureTimestamp(signatureTimestamp) 
      if (signedHeaders != null) ret.setSignedHeaders(signedHeaders.asJava) 
      ret
    }
  }



  type MailConfig = io.vertx.ext.mail.MailConfig
  object MailConfig {
    def apply() = new MailConfig()
    def apply(json: JsonObject) = new MailConfig(json)
    def apply(str: String) = new MailConfig(str)
    def apply( allowRcptErrors: java.lang.Boolean = null, applicationLayerProtocols: scala.collection.immutable.List[java.lang.String] = null, authMethods: java.lang.String = null, connectTimeout: java.lang.Integer = null, disableEsmtp: java.lang.Boolean = null, dkimSignOption: io.vertx.ext.mail.DKIMSignOptions = null, dkimSignOptions: scala.collection.immutable.List[io.vertx.ext.mail.DKIMSignOptions] = null, enableDKIM: java.lang.Boolean = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, hostname: java.lang.String = null, hostnameVerificationAlgorithm: java.lang.String = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keepAlive: java.lang.Boolean = null, keepAliveTimeout: java.lang.Integer = null, keepAliveTimeoutUnit: java.util.concurrent.TimeUnit = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStore: java.lang.String = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, keyStorePassword: java.lang.String = null, localAddress: java.lang.String = null, logActivity: java.lang.Boolean = null, login: io.vertx.ext.mail.LoginOption = null, maxPoolSize: java.lang.Integer = null, metricsName: java.lang.String = null, multiPartOnly: java.lang.Boolean = null, nonProxyHosts: scala.collection.immutable.List[java.lang.String] = null, ntDomain: java.lang.String = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, ownHostname: java.lang.String = null, password: java.lang.String = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, pipelining: java.lang.Boolean = null, poolCleanerPeriod: java.lang.Integer = null, poolCleanerPeriodUnit: java.util.concurrent.TimeUnit = null, port: java.lang.Integer = null, proxyOptions: io.vertx.core.net.ProxyOptions = null, readIdleTimeout: java.lang.Integer = null, receiveBufferSize: java.lang.Integer = null, reconnectAttempts: java.lang.Integer = null, reconnectInterval: java.lang.Long = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, starttls: io.vertx.ext.mail.StartTLSOptions = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, trafficClass: java.lang.Integer = null, trustAll: java.lang.Boolean = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, useAlpn: java.lang.Boolean = null, userAgent: java.lang.String = null, username: java.lang.String = null, workstation: java.lang.String = null, writeIdleTimeout: java.lang.Integer = null): MailConfig = {
      val ret = new MailConfig(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (allowRcptErrors != null) ret.setAllowRcptErrors(allowRcptErrors) 
      if (applicationLayerProtocols != null) ret.setApplicationLayerProtocols(applicationLayerProtocols.asJava) 
      if (authMethods != null) ret.setAuthMethods(authMethods) 
      if (connectTimeout != null) ret.setConnectTimeout(connectTimeout) 
      if (disableEsmtp != null) ret.setDisableEsmtp(disableEsmtp) 
      if (dkimSignOption != null) ret.setDKIMSignOption(dkimSignOption) 
      if (dkimSignOptions != null) ret.setDKIMSignOptions(dkimSignOptions.asJava) 
      if (enableDKIM != null) ret.setEnableDKIM(enableDKIM) 
      if (enabledSecureTransportProtocols != null) ret.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.asJava) 
      if (hostname != null) ret.setHostname(hostname) 
      if (hostnameVerificationAlgorithm != null) ret.setHostnameVerificationAlgorithm(hostnameVerificationAlgorithm) 
      if (idleTimeout != null) ret.setIdleTimeout(idleTimeout) 
      if (idleTimeoutUnit != null) ret.setIdleTimeoutUnit(idleTimeoutUnit) 
      if (jdkSslEngineOptions != null) ret.setJdkSslEngineOptions(jdkSslEngineOptions) 
      if (keepAlive != null) ret.setKeepAlive(keepAlive) 
      if (keepAliveTimeout != null) ret.setKeepAliveTimeout(keepAliveTimeout) 
      if (keepAliveTimeoutUnit != null) ret.setKeepAliveTimeoutUnit(keepAliveTimeoutUnit) 
      if (keyCertOptions != null) ret.setKeyCertOptions(keyCertOptions) 
      if (keyStore != null) ret.setKeyStore(keyStore) 
      if (keyStoreOptions != null) ret.setKeyStoreOptions(keyStoreOptions) 
      if (keyStorePassword != null) ret.setKeyStorePassword(keyStorePassword) 
      if (localAddress != null) ret.setLocalAddress(localAddress) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (login != null) ret.setLogin(login) 
      if (maxPoolSize != null) ret.setMaxPoolSize(maxPoolSize) 
      if (metricsName != null) ret.setMetricsName(metricsName) 
      if (multiPartOnly != null) ret.setMultiPartOnly(multiPartOnly) 
      if (nonProxyHosts != null) ret.setNonProxyHosts(nonProxyHosts.asJava) 
      if (ntDomain != null) ret.setNtDomain(ntDomain) 
      if (openSslEngineOptions != null) ret.setOpenSslEngineOptions(openSslEngineOptions) 
      if (ownHostname != null) ret.setOwnHostname(ownHostname) 
      if (password != null) ret.setPassword(password) 
      if (pemKeyCertOptions != null) ret.setPemKeyCertOptions(pemKeyCertOptions) 
      if (pemTrustOptions != null) ret.setPemTrustOptions(pemTrustOptions) 
      if (pfxKeyCertOptions != null) ret.setPfxKeyCertOptions(pfxKeyCertOptions) 
      if (pfxTrustOptions != null) ret.setPfxTrustOptions(pfxTrustOptions) 
      if (pipelining != null) ret.setPipelining(pipelining) 
      if (poolCleanerPeriod != null) ret.setPoolCleanerPeriod(poolCleanerPeriod) 
      if (poolCleanerPeriodUnit != null) ret.setPoolCleanerPeriodUnit(poolCleanerPeriodUnit) 
      if (port != null) ret.setPort(port) 
      if (proxyOptions != null) ret.setProxyOptions(proxyOptions) 
      if (readIdleTimeout != null) ret.setReadIdleTimeout(readIdleTimeout) 
      if (receiveBufferSize != null) ret.setReceiveBufferSize(receiveBufferSize) 
      if (reconnectAttempts != null) ret.setReconnectAttempts(reconnectAttempts) 
      if (reconnectInterval != null) ret.setReconnectInterval(reconnectInterval) 
      if (reuseAddress != null) ret.setReuseAddress(reuseAddress) 
      if (reusePort != null) ret.setReusePort(reusePort) 
      if (sendBufferSize != null) ret.setSendBufferSize(sendBufferSize) 
      if (soLinger != null) ret.setSoLinger(soLinger) 
      if (ssl != null) ret.setSsl(ssl) 
      if (sslEngineOptions != null) ret.setSslEngineOptions(sslEngineOptions) 
      if (sslHandshakeTimeout != null) ret.setSslHandshakeTimeout(sslHandshakeTimeout) 
      if (sslHandshakeTimeoutUnit != null) ret.setSslHandshakeTimeoutUnit(sslHandshakeTimeoutUnit) 
      if (starttls != null) ret.setStarttls(starttls) 
      if (tcpCork != null) ret.setTcpCork(tcpCork) 
      if (tcpFastOpen != null) ret.setTcpFastOpen(tcpFastOpen) 
      if (tcpKeepAlive != null) ret.setTcpKeepAlive(tcpKeepAlive) 
      if (tcpNoDelay != null) ret.setTcpNoDelay(tcpNoDelay) 
      if (tcpQuickAck != null) ret.setTcpQuickAck(tcpQuickAck) 
      if (trafficClass != null) ret.setTrafficClass(trafficClass) 
      if (trustAll != null) ret.setTrustAll(trustAll) 
      if (trustOptions != null) ret.setTrustOptions(trustOptions) 
      if (trustStoreOptions != null) ret.setTrustStoreOptions(trustStoreOptions) 
      if (useAlpn != null) ret.setUseAlpn(useAlpn) 
      if (userAgent != null) ret.setUserAgent(userAgent) 
      if (username != null) ret.setUsername(username) 
      if (workstation != null) ret.setWorkstation(workstation) 
      if (writeIdleTimeout != null) ret.setWriteIdleTimeout(writeIdleTimeout) 
      ret
    }
  }



  type MailMessage = io.vertx.ext.mail.MailMessage
  object MailMessage {
    def apply() = new MailMessage()
    def apply(json: JsonObject) = new MailMessage(json)
    def apply( attachment: scala.collection.immutable.List[io.vertx.ext.mail.MailAttachment] = null, bcc: scala.collection.immutable.List[java.lang.String] = null, bounceAddress: java.lang.String = null, cc: scala.collection.immutable.List[java.lang.String] = null, fixedHeaders: java.lang.Boolean = null, from: java.lang.String = null, html: java.lang.String = null, inlineAttachment: scala.collection.immutable.List[io.vertx.ext.mail.MailAttachment] = null, subject: java.lang.String = null, text: java.lang.String = null, to: scala.collection.immutable.List[java.lang.String] = null): MailMessage = {
      val ret = new MailMessage(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (attachment != null) ret.setAttachment(attachment.asJava) 
      if (bcc != null) ret.setBcc(bcc.asJava) 
      if (bounceAddress != null) ret.setBounceAddress(bounceAddress) 
      if (cc != null) ret.setCc(cc.asJava) 
      if (fixedHeaders != null) ret.setFixedHeaders(fixedHeaders) 
      if (from != null) ret.setFrom(from) 
      if (html != null) ret.setHtml(html) 
      if (inlineAttachment != null) ret.setInlineAttachment(inlineAttachment.asJava) 
      if (subject != null) ret.setSubject(subject) 
      if (text != null) ret.setText(text) 
      if (to != null) ret.setTo(to.asJava) 
      ret
    }
  }



  type MailResult = io.vertx.ext.mail.MailResult
  object MailResult {
    def apply() = new MailResult()
    def apply(json: JsonObject) = new MailResult(json)
    def apply( messageID: java.lang.String = null, recipients: scala.collection.immutable.List[java.lang.String] = null): MailResult = {
      val ret = new MailResult(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (messageID != null) ret.setMessageID(messageID) 
      if (recipients != null) ret.setRecipients(recipients.asJava) 
      ret
    }
  }



}
