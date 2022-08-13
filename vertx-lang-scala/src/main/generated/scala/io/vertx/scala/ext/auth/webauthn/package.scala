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


package io.vertx.scala.ext.auth

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.auth.webauthn.{RelyingParty => JRelyingParty}
package object webauthn{


  type AttestationCertificates = io.vertx.ext.auth.webauthn.AttestationCertificates
  object AttestationCertificates {
    def apply() = new AttestationCertificates()
    def apply(json: JsonObject) = new AttestationCertificates(json)
    def apply( alg: io.vertx.ext.auth.webauthn.PublicKeyCredential = null, x5c: scala.collection.immutable.List[java.lang.String] = null): AttestationCertificates = {
      val ret = new AttestationCertificates(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (alg != null) ret.setAlg(alg) 
      if (x5c != null) ret.setX5c(x5c.asJava) 
      ret
    }
  }



  type Authenticator = io.vertx.ext.auth.webauthn.Authenticator
  object Authenticator {
    def apply() = new Authenticator()
    def apply(json: JsonObject) = new Authenticator(json)
    def apply( aaguid: java.lang.String = null, attestationCertificates: io.vertx.ext.auth.webauthn.AttestationCertificates = null, counter: java.lang.Long = null, credID: java.lang.String = null, fmt: java.lang.String = null, publicKey: java.lang.String = null, `type`: java.lang.String = null, userName: java.lang.String = null): Authenticator = {
      val ret = new Authenticator(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (aaguid != null) ret.setAaguid(aaguid) 
      if (attestationCertificates != null) ret.setAttestationCertificates(attestationCertificates) 
      if (counter != null) ret.setCounter(counter) 
      if (credID != null) ret.setCredID(credID) 
      if (fmt != null) ret.setFmt(fmt) 
      if (publicKey != null) ret.setPublicKey(publicKey) 
      if (`type` != null) ret.setType(`type`) 
      if (userName != null) ret.setUserName(userName) 
      ret
    }
  }



  type RelyingParty = io.vertx.ext.auth.webauthn.RelyingParty
  object RelyingParty {
    def apply() = new RelyingParty()
    def apply(json: JsonObject) = new RelyingParty(json)
    def apply( icon: java.lang.String = null, id: java.lang.String = null, name: java.lang.String = null): RelyingParty = {
      val ret = new RelyingParty(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (icon != null) ret.setIcon(icon) 
      if (id != null) ret.setId(id) 
      if (name != null) ret.setName(name) 
      ret
    }
  }



  type WebAuthnCredentials = io.vertx.ext.auth.webauthn.WebAuthnCredentials
  object WebAuthnCredentials {
    def apply() = new WebAuthnCredentials()
    def apply(json: JsonObject) = new WebAuthnCredentials(json)
    def apply( challenge: java.lang.String = null, domain: java.lang.String = null, origin: java.lang.String = null, username: java.lang.String = null, webauthn: io.vertx.core.json.JsonObject = null): WebAuthnCredentials = {
      val ret = new WebAuthnCredentials(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (challenge != null) ret.setChallenge(challenge) 
      if (domain != null) ret.setDomain(domain) 
      if (origin != null) ret.setOrigin(origin) 
      if (username != null) ret.setUsername(username) 
      if (webauthn != null) ret.setWebauthn(webauthn) 
      ret
    }
  }



  type WebAuthnOptions = io.vertx.ext.auth.webauthn.WebAuthnOptions
  object WebAuthnOptions {
    def apply() = new WebAuthnOptions()
    def apply(json: JsonObject) = new WebAuthnOptions(json)
    def apply( attestation: io.vertx.ext.auth.webauthn.Attestation = null, authenticatorAttachment: io.vertx.ext.auth.webauthn.AuthenticatorAttachment = null, challengeLength: java.lang.Integer = null, extensions: io.vertx.core.json.JsonObject = null, pubKeyCredParams: scala.collection.immutable.List[io.vertx.ext.auth.webauthn.PublicKeyCredential] = null, relyingParty: io.vertx.ext.auth.webauthn.RelyingParty = null, requireResidentKey: java.lang.Boolean = null, rootCertificates: scala.collection.immutable.Map[String,java.lang.String] = null, rootCrls: scala.collection.immutable.List[java.lang.String] = null, timeoutInMilliseconds: java.lang.Long = null, transports: scala.collection.immutable.List[io.vertx.ext.auth.webauthn.AuthenticatorTransport] = null, userVerification: io.vertx.ext.auth.webauthn.UserVerification = null): WebAuthnOptions = {
      val ret = new WebAuthnOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (attestation != null) ret.setAttestation(attestation) 
      if (authenticatorAttachment != null) ret.setAuthenticatorAttachment(authenticatorAttachment) 
      if (challengeLength != null) ret.setChallengeLength(challengeLength) 
      if (extensions != null) ret.setExtensions(extensions) 
      if (pubKeyCredParams != null) ret.setPubKeyCredParams(pubKeyCredParams.asJava) 
      if (relyingParty != null) ret.setRelyingParty(relyingParty) 
      if (requireResidentKey != null) ret.setRequireResidentKey(requireResidentKey) 
      if (rootCertificates != null) ret.setRootCertificates(rootCertificates.asJava) 
      if (rootCrls != null) ret.setRootCrls(rootCrls.asJava) 
      if (timeoutInMilliseconds != null) ret.setTimeoutInMilliseconds(timeoutInMilliseconds) 
      if (transports != null) ret.setTransports(transports.asJava) 
      if (userVerification != null) ret.setUserVerification(userVerification) 
      ret
    }
  }



}
