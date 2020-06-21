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

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.web
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.auth.authorization.{Authorization => JAuthorization}
import io.vertx.ext.auth.authorization
import io.vertx.ext.web.handler.{AuthorizationHandler => JAuthorizationHandler}
import io.vertx.core.Handler
import io.vertx.ext.auth.authorization.{AuthorizationProvider => JAuthorizationProvider}
package object web{



  /**
    * Base interface for auth handlers.
    * 
    * An auth handler allows your application to provide authentication/authorization support.
    * 
    * Auth handler requires a [[io.vertx.ext.web.handler.SessionHandler]] to be on the routing chain before it.
    */

  implicit class AuthHandlerScala(val asJava: io.vertx.ext.web.handler.AuthHandler) extends AnyVal {


    /**
     * Like parseCredentials from [[io.vertx.ext.web.handler.AuthHandler]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def parseCredentialsFuture(context: io.vertx.ext.web.RoutingContext) : scala.concurrent.Future[io.vertx.ext.auth.authentication.Credentials] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.authentication.Credentials]/*io.vertx.ext.auth.authentication.Credentials API*/()
      asJava.parseCredentials(context, new Handler[AsyncResult[io.vertx.ext.auth.authentication.Credentials]] { override def handle(event: AsyncResult[io.vertx.ext.auth.authentication.Credentials]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like authorize from [[io.vertx.ext.web.handler.AuthHandler]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def authorizeFuture(user: io.vertx.ext.auth.User) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.authorize(user, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Add a set of required authorities for this auth handler     * @param authorities the set of authorities
     * @return a reference to this, so the API can be used fluently
     */
  def addAuthorities(authorities: scala.collection.mutable.Set[java.lang.String]) = {
      asJava.addAuthorities(authorities.asJava)
  }

  }




  /**
    * Base interface for auth handlers.
    * 
    * An auth handler allows your application to provide authentication/authorization support.
    * 
    * Auth handler requires a [[io.vertx.ext.web.handler.SessionHandler]] to be on the routing chain before it.
    */

  implicit class AuthenticationHandlerScala(val asJava: io.vertx.ext.web.handler.AuthenticationHandler) extends AnyVal {


    /**
     * Like parseCredentials from [[io.vertx.ext.web.handler.AuthenticationHandler]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def parseCredentialsFuture(context: io.vertx.ext.web.RoutingContext) : scala.concurrent.Future[io.vertx.ext.auth.authentication.Credentials] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.authentication.Credentials]/*io.vertx.ext.auth.authentication.Credentials API*/()
      asJava.parseCredentials(context, new Handler[AsyncResult[io.vertx.ext.auth.authentication.Credentials]] { override def handle(event: AsyncResult[io.vertx.ext.auth.authentication.Credentials]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object AuthorizationHandler {
    /**
     * create the the handler that will check the specified authorization
     * Note that to check several authorizations, you can specify a sub-interface such as [[io.vertx.ext.auth.authorization.AndAuthorization]] or [[io.vertx.ext.auth.authorization.OrAuthorization]]     * @param authorization the authorization to attest.
     * @return fluent self.
     */
  def create(authorization: io.vertx.ext.auth.authorization.Authorization) = {
      io.vertx.ext.web.handler.AuthorizationHandler.create(authorization)
  }
  }



  /**
    * An auth handler that provides HTTP Basic Authentication support.
    */

  implicit class BasicAuthHandlerScala(val asJava: io.vertx.ext.web.handler.BasicAuthHandler) extends AnyVal {


    /**
     * Like parseCredentials from [[io.vertx.ext.web.handler.BasicAuthHandler]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def parseCredentialsFuture(context: io.vertx.ext.web.RoutingContext) : scala.concurrent.Future[io.vertx.ext.auth.authentication.Credentials] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.authentication.Credentials]/*io.vertx.ext.auth.authentication.Credentials API*/()
      asJava.parseCredentials(context, new Handler[AsyncResult[io.vertx.ext.auth.authentication.Credentials]] { override def handle(event: AsyncResult[io.vertx.ext.auth.authentication.Credentials]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object BodyHandler {
    /**
     * Create a body handler with defaults     * @return the body handler
     */
  def create() = {
      io.vertx.ext.web.handler.BodyHandler.create()
  }

    /**
     * Create a body handler setting if it should handle file uploads     * @param handleFileUploads true if files upload should be handled
     * @return the body handler
     */
  def create(handleFileUploads: java.lang.Boolean) = {
      io.vertx.ext.web.handler.BodyHandler.create(handleFileUploads)
  }

    /**
     * Create a body handler and use the given upload directory.     * @param uploadDirectory the uploads directory
     * @return the body handler
     */
  def create(uploadDirectory: java.lang.String) = {
      io.vertx.ext.web.handler.BodyHandler.create(uploadDirectory)
  }
  }




  object CSRFHandler {
    /**
     * Instantiate a new CSRFHandlerImpl with a secret
     * 
     * <pre>
     * CSRFHandler.create("s3cr37")
     * </pre>     * @param secret server secret to sign the token.
     */
  def create(vertx: io.vertx.core.Vertx, secret: java.lang.String) = {
      io.vertx.ext.web.handler.CSRFHandler.create(vertx, secret)
  }
  }



  /**
    * An auth handler that chains to a sequence of handlers.
    */

  implicit class ChainAuthHandlerScala(val asJava: io.vertx.ext.web.handler.ChainAuthHandler) extends AnyVal {


    /**
     * Like parseCredentials from [[io.vertx.ext.web.handler.ChainAuthHandler]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def parseCredentialsFuture(context: io.vertx.ext.web.RoutingContext) : scala.concurrent.Future[io.vertx.ext.auth.authentication.Credentials] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.authentication.Credentials]/*io.vertx.ext.auth.authentication.Credentials API*/()
      asJava.parseCredentials(context, new Handler[AsyncResult[io.vertx.ext.auth.authentication.Credentials]] { override def handle(event: AsyncResult[io.vertx.ext.auth.authentication.Credentials]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object ClusteredSessionStore {
    /**
     * Create a session store     * @param vertx the Vert.x instance
     * @param sessionMapName the session map name
     * @return the session store
     */
  def create(vertx: io.vertx.core.Vertx, sessionMapName: java.lang.String) = {
      io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx, sessionMapName)
  }

    /**
     * Create a session store.<p/>
     *
     * The retry timeout value, configures how long the session handler will retry to get a session from the store
     * when it is not found.     * @param vertx the Vert.x instance
     * @param sessionMapName the session map name
     * @param retryTimeout the store retry timeout, in ms
     * @return the session store
     */
  def create(vertx: io.vertx.core.Vertx, sessionMapName: java.lang.String, retryTimeout: java.lang.Long) = {
      io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx, sessionMapName, retryTimeout)
  }

    /**
     * Create a session store     * @param vertx the Vert.x instance
     * @return the session store
     */
  def create(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx)
  }

    /**
     * Create a session store.<p/>
     *
     * The retry timeout value, configures how long the session handler will retry to get a session from the store
     * when it is not found.     * @param vertx the Vert.x instance
     * @param retryTimeout the store retry timeout, in ms
     * @return the session store
     */
  def create(vertx: io.vertx.core.Vertx, retryTimeout: java.lang.Long) = {
      io.vertx.ext.web.sstore.ClusteredSessionStore.create(vertx, retryTimeout)
  }
  }


  object CorsHandler {
    /**
     * Create a CORS handler     * @param allowedOriginPattern the allowed origin pattern
     * @return the handler
     */
  def create(allowedOriginPattern: java.lang.String) = {
      io.vertx.ext.web.handler.CorsHandler.create(allowedOriginPattern)
  }
  }



  /**
    * An auth handler that provides HTTP Basic Authentication support.
    */

  implicit class DigestAuthHandlerScala(val asJava: io.vertx.ext.web.handler.DigestAuthHandler) extends AnyVal {


    /**
     * Like parseCredentials from [[io.vertx.ext.web.handler.DigestAuthHandler]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def parseCredentialsFuture(context: io.vertx.ext.web.RoutingContext) : scala.concurrent.Future[io.vertx.ext.auth.authentication.Credentials] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.authentication.Credentials]/*io.vertx.ext.auth.authentication.Credentials API*/()
      asJava.parseCredentials(context, new Handler[AsyncResult[io.vertx.ext.auth.authentication.Credentials]] { override def handle(event: AsyncResult[io.vertx.ext.auth.authentication.Credentials]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object ErrorHandler {
    /**
     * Create an error handler using defaults     * @return the handler
     */
  def create() = {
      io.vertx.ext.web.handler.ErrorHandler.create()
  }

    /**
     * Create an error handler     * @param errorTemplateName the error template name - will be looked up from the classpath
     * @param displayExceptionDetails true if exception details should be displayed
     * @return the handler
     */
  def create(errorTemplateName: java.lang.String, displayExceptionDetails: java.lang.Boolean) = {
      io.vertx.ext.web.handler.ErrorHandler.create(errorTemplateName, displayExceptionDetails)
  }

    /**
     * Create an error handler     * @param displayExceptionDetails true if exception details should be displayed
     * @return the handler
     */
  def create(displayExceptionDetails: java.lang.Boolean) = {
      io.vertx.ext.web.handler.ErrorHandler.create(displayExceptionDetails)
  }

    /**
     * Create an error handler     * @param errorTemplateName the error template name - will be looked up from the classpath
     * @return the handler
     */
  def create(errorTemplateName: java.lang.String) = {
      io.vertx.ext.web.handler.ErrorHandler.create(errorTemplateName)
  }
  }


  object FaviconHandler {
    /**
     * Create a handler with defaults     * @return the handler
     */
  def create() = {
      io.vertx.ext.web.handler.FaviconHandler.create()
  }

    /**
     * Create a handler attempting to load favicon file from the specified path     * @param path the path
     * @return the handler
     */
  def create(path: java.lang.String) = {
      io.vertx.ext.web.handler.FaviconHandler.create(path)
  }

    /**
     * Create a handler attempting to load favicon file from the specified path, and with the specified max cache time     * @param path the path
     * @param maxAgeSeconds max how long the file will be cached by browser, in seconds
     * @return the handler
     */
  def create(path: java.lang.String, maxAgeSeconds: java.lang.Long) = {
      io.vertx.ext.web.handler.FaviconHandler.create(path, maxAgeSeconds)
  }

    /**
     * Create a handler with the specified max cache time     * @param maxAgeSeconds max how long the file will be cached by browser, in seconds
     * @return the handler
     */
  def create(maxAgeSeconds: java.lang.Long) = {
      io.vertx.ext.web.handler.FaviconHandler.create(maxAgeSeconds)
  }
  }




  object FormLoginHandler {
    /**
     * Create a handler     * @param authProvider the auth service to use
     * @return the handler
     */
  def create(authProvider: io.vertx.ext.auth.authentication.AuthenticationProvider) = {
      io.vertx.ext.web.handler.FormLoginHandler.create(authProvider)
  }

    /**
     * Create a handler     * @param authProvider the auth service to use
     * @param usernameParam the value of the form attribute which will contain the username
     * @param passwordParam the value of the form attribute which will contain the password
     * @param returnURLParam the value of the session attribute which will contain the return url
     * @param directLoggedInOKURL a url to redirect to if the user logs in directly at the url of the form login handler without being redirected here first
     * @return the handler
     */
  def create(authProvider: io.vertx.ext.auth.authentication.AuthenticationProvider, usernameParam: java.lang.String, passwordParam: java.lang.String, returnURLParam: java.lang.String, directLoggedInOKURL: java.lang.String) = {
      io.vertx.ext.web.handler.FormLoginHandler.create(authProvider, usernameParam, passwordParam, returnURLParam, directLoggedInOKURL)
  }
  }


  object HSTSHandler {
    /**
     * Creates a new instance that shall consider the configuration for sub domains.     * @param maxAge max age to attribute to the header
     * @param includeSubDomains consider sub domains when adding the header
     * @return an instance.
     */
  def create(maxAge: java.lang.Long, includeSubDomains: java.lang.Boolean) = {
      io.vertx.ext.web.handler.HSTSHandler.create(maxAge, includeSubDomains)
  }

    /**
     * Creates a new instance that shall consider the configuration for sub domains.     * @param includeSubDomains consider sub domains when adding the header
     * @return an instance.
     */
  def create(includeSubDomains: java.lang.Boolean) = {
      io.vertx.ext.web.handler.HSTSHandler.create(includeSubDomains)
  }

    /**
     * Creates a new instance that does not consider the configuration for sub domains.
     * Using the default max age.     * @return an instance.
     */
  def create() = {
      io.vertx.ext.web.handler.HSTSHandler.create()
  }
  }


  type Http2PushMapping = io.vertx.ext.web.Http2PushMapping
  object Http2PushMapping {
    def apply() = new Http2PushMapping()
    def apply(json: JsonObject) = new Http2PushMapping(json)
  }




  /**
    * An auth handler that provides JWT Authentication support.
    */

  implicit class JWTAuthHandlerScala(val asJava: io.vertx.ext.web.handler.JWTAuthHandler) extends AnyVal {


    /**
     * Like parseCredentials from [[io.vertx.ext.web.handler.JWTAuthHandler]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def parseCredentialsFuture(context: io.vertx.ext.web.RoutingContext) : scala.concurrent.Future[io.vertx.ext.auth.authentication.Credentials] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.authentication.Credentials]/*io.vertx.ext.auth.authentication.Credentials API*/()
      asJava.parseCredentials(context, new Handler[AsyncResult[io.vertx.ext.auth.authentication.Credentials]] { override def handle(event: AsyncResult[io.vertx.ext.auth.authentication.Credentials]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }





  object LocalSessionStore {
    /**
     * Create a session store     * @param vertx the Vert.x instance
     * @return the session store
     */
  def create(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.web.sstore.LocalSessionStore.create(vertx)
  }

    /**
     * Create a session store     * @param vertx the Vert.x instance
     * @param sessionMapName name for map used to store sessions
     * @return the session store
     */
  def create(vertx: io.vertx.core.Vertx, sessionMapName: java.lang.String) = {
      io.vertx.ext.web.sstore.LocalSessionStore.create(vertx, sessionMapName)
  }

    /**
     * Create a session store     * @param vertx the Vert.x instance
     * @param sessionMapName name for map used to store sessions
     * @param reaperInterval how often, in ms, to check for expired sessions
     * @return the session store
     */
  def create(vertx: io.vertx.core.Vertx, sessionMapName: java.lang.String, reaperInterval: java.lang.Long) = {
      io.vertx.ext.web.sstore.LocalSessionStore.create(vertx, sessionMapName, reaperInterval)
  }
  }


  object LoggerHandler {
    /**
     * Create a handler with default format     * @return the handler
     */
  def create() = {
      io.vertx.ext.web.handler.LoggerHandler.create()
  }

    /**
     * Create a handler with he specified format     * @param format the format
     * @return the handler
     */
  def create(format: io.vertx.ext.web.handler.LoggerFormat) = {
      io.vertx.ext.web.handler.LoggerHandler.create(format)
  }

    /**
     * Create a handler with he specified format     * @param immediate true if logging should occur as soon as request arrives
     * @param format the format
     * @return the handler
     */
  def create(immediate: java.lang.Boolean, format: io.vertx.ext.web.handler.LoggerFormat) = {
      io.vertx.ext.web.handler.LoggerHandler.create(immediate, format)
  }
  }




  object MethodOverrideHandler {
    /**
     * Create a X-HTTP-METHOD-OVERRIDE handler with safe downgrade of methods     * @return the X-HTTP-METHOD-OVERRIDE handler
     */
  def create() = {
      io.vertx.ext.web.handler.MethodOverrideHandler.create()
  }

    /**
     * Create a X-HTTP-METHOD-OVERRIDE handler     * @param useSafeDowngrade if set to true, the method overriding will not happen if the overridden method is more idempotent or safer than the overriding method.
     * @return the X-HTTP-METHOD-OVERRIDE handler
     */
  def create(useSafeDowngrade: java.lang.Boolean) = {
      io.vertx.ext.web.handler.MethodOverrideHandler.create(useSafeDowngrade)
  }
  }


  object MultiTenantHandler {
    /**
     * Create a MultiTenant handler that will extract the tenant id from a given header name.     * @param header the header to lookup (e.g.: "X-Tenant")
     * @return the new handler.
     */
  def create(header: java.lang.String) = {
      io.vertx.ext.web.handler.MultiTenantHandler.create(header)
  }

    /**
     * Create a MultiTenant handler using a custom tenant extraction function.     * @param tenantExtractor the function that extracts the tenant id from the request
     * @return the new handler.
     */
  def create(tenantExtractor: io.vertx.ext.web.RoutingContext => java.lang.String) = {
      io.vertx.ext.web.handler.MultiTenantHandler.create({x: io.vertx.ext.web.RoutingContext => tenantExtractor(x)})
  }

    /**
     * Create a MultiTenant handler using a custom tenant extraction function.     * @param tenantExtractor the function that extracts the tenant id from the request
     * @param contextKey the custom key to store the tenant id in the context
     * @return the new handler.
     */
  def create(tenantExtractor: io.vertx.ext.web.RoutingContext => java.lang.String, contextKey: java.lang.String) = {
      io.vertx.ext.web.handler.MultiTenantHandler.create({x: io.vertx.ext.web.RoutingContext => tenantExtractor(x)}, contextKey)
  }
  }



  /**
    * An auth handler that provides OAuth2 Authentication support. This handler is suitable for AuthCode flows.
    */

  implicit class OAuth2AuthHandlerScala(val asJava: io.vertx.ext.web.handler.OAuth2AuthHandler) extends AnyVal {


    /**
     * Like parseCredentials from [[io.vertx.ext.web.handler.OAuth2AuthHandler]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def parseCredentialsFuture(context: io.vertx.ext.web.RoutingContext) : scala.concurrent.Future[io.vertx.ext.auth.authentication.Credentials] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.authentication.Credentials]/*io.vertx.ext.auth.authentication.Credentials API*/()
      asJava.parseCredentials(context, new Handler[AsyncResult[io.vertx.ext.auth.authentication.Credentials]] { override def handle(event: AsyncResult[io.vertx.ext.auth.authentication.Credentials]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }








  /**
    * An auth handler that's used to handle auth by redirecting user to a custom login page.
    */

  implicit class RedirectAuthHandlerScala(val asJava: io.vertx.ext.web.handler.RedirectAuthHandler) extends AnyVal {


    /**
     * Like parseCredentials from [[io.vertx.ext.web.handler.RedirectAuthHandler]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def parseCredentialsFuture(context: io.vertx.ext.web.RoutingContext) : scala.concurrent.Future[io.vertx.ext.auth.authentication.Credentials] = {
      val promise = concurrent.Promise[io.vertx.ext.auth.authentication.Credentials]/*io.vertx.ext.auth.authentication.Credentials API*/()
      asJava.parseCredentials(context, new Handler[AsyncResult[io.vertx.ext.auth.authentication.Credentials]] { override def handle(event: AsyncResult[io.vertx.ext.auth.authentication.Credentials]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object ResponseContentTypeHandler {
    /**
     * Create a response content type handler.     * @return the response content type handler
     */
  def create() = {
      io.vertx.ext.web.handler.ResponseContentTypeHandler.create()
  }

    /**
     * Create a response content type handler with a custom disable flag.     * @return the response content type handler
     */
  def create(disableFlag: java.lang.String) = {
      io.vertx.ext.web.handler.ResponseContentTypeHandler.create(disableFlag)
  }
  }


  object ResponseTimeHandler {
    /**
     * Create a handler     * @return the handler
     */
  def create() = {
      io.vertx.ext.web.handler.ResponseTimeHandler.create()
  }
  }




  object Router {
    /**
     * Create a router     * @param vertx the Vert.x instance
     * @return the router
     */
  def router(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.web.Router.router(vertx)
  }
  }



  /**
    * Represents the context for the handling of a request in Vert.x-Web.
    * 
    * A new instance is created for each HTTP request that is received in the
    * [[io.vertx.core.Handler#handle]] of the router.
    * 
    * The same instance is passed to any matching request or failure handlers during the routing of the request or
    * failure.
    * 
    * The context provides access to the  and 
    * and allows you to maintain arbitrary data that lives for the lifetime of the context. Contexts are discarded once they
    * have been routed to the handler for the request.
    * 
    * The context also provides access to the [[io.vertx.ext.web.Session]], cookies and body for the request, given the correct handlers
    * in the application.
    * 
    * If you use the internal error handler
    */

  implicit class RoutingContextScala(val asJava: io.vertx.ext.web.RoutingContext) extends AnyVal {

    /**
     * Put some arbitrary data in the context. This will be available in any handlers that receive the context.     * @param key the key for the data
     * @param obj the data
     * @return a reference to this, so the API can be used fluently
     */
  def put(key: java.lang.String, obj: AnyRef) = {
      asJava.put(key, obj)
  }

    /**
     * Like mountPoint from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def mountPointOption() = {
      scala.Option(asJava.mountPoint())
  }

    /**
     * Like getCookie from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getCookieOption(name: java.lang.String) = {
      scala.Option(asJava.getCookie(name))
  }

    /**
     * Like removeCookie from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def removeCookieOption(name: java.lang.String) = {
      scala.Option(asJava.removeCookie(name))
  }

    /**
     * Like removeCookie from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def removeCookieOption(name: java.lang.String, invalidate: java.lang.Boolean) = {
      scala.Option(asJava.removeCookie(name, invalidate))
  }

    /**
     * Like getBodyAsString from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getBodyAsStringOption() = {
      scala.Option(asJava.getBodyAsString())
  }

    /**
     * Like getBodyAsString from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getBodyAsStringOption(encoding: java.lang.String) = {
      scala.Option(asJava.getBodyAsString(encoding))
  }

    /**
     * Like getBodyAsJson from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getBodyAsJsonOption() = {
      scala.Option(asJava.getBodyAsJson())
  }

    /**
     * Like getBodyAsJsonArray from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getBodyAsJsonArrayOption() = {
      scala.Option(asJava.getBodyAsJsonArray())
  }

    /**
     * Like getBody from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getBodyOption() = {
      scala.Option(asJava.getBody())
  }

    /**
     * Like session from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sessionOption() = {
      scala.Option(asJava.session())
  }

    /**
     * Like user from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def userOption() = {
      scala.Option(asJava.user())
  }

    /**
     * Like failure from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def failureOption() = {
      scala.Option(asJava.failure())
  }

    /**
     * Like getAcceptableContentType from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getAcceptableContentTypeOption() = {
      scala.Option(asJava.getAcceptableContentType())
  }

    /**
     * Set the acceptable content type. Used by     * @param contentType the content type
     */
  def setAcceptableContentType(contentType: scala.Option[java.lang.String]) = {
      asJava.setAcceptableContentType(contentType.getOrElse(null))
  }

    /**
     * Like pathParam from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pathParamOption(name: java.lang.String) = {
      scala.Option(asJava.pathParam(name))
  }

    /**
     * Encode an Object to JSON and end the request.
     * The method will apply the correct content type to the response,
     * perform the encoding and end.     * @param json the json
     * @return a future to handle the end of the request
     */
  def json(json: AnyRef) = {
      asJava.json(json)
  }

    /**
     * Like addEndHandler from [[io.vertx.ext.web.RoutingContext]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def addEndFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.addEndHandler(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }






  /**
    * A handler that maintains a [[io.vertx.ext.web.Session]] for each browser
    * session.
    * 
    * It looks up the session for each request based on a session cookie which
    * contains a session ID. It stores the session when the response is ended in
    * the session store.
    * 
    * The session is available on the routing context with
    * .
    */

  implicit class SessionHandlerScala(val asJava: io.vertx.ext.web.handler.SessionHandler) extends AnyVal {


    /**
     * Like flush from [[io.vertx.ext.web.handler.SessionHandler]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def flushFuture(ctx: io.vertx.ext.web.RoutingContext) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.flush(ctx, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * A session store is used to store sessions for an Vert.x-Web web app
    */

  implicit class SessionStoreScala(val asJava: io.vertx.ext.web.sstore.SessionStore) extends AnyVal {


    /**
     * Like get from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getFuture(cookieValue: java.lang.String) : scala.concurrent.Future[io.vertx.ext.web.Session] = {
      val promise = concurrent.Promise[io.vertx.ext.web.Session]/*io.vertx.ext.web.Session API*/()
      asJava.get(cookieValue, new Handler[AsyncResult[io.vertx.ext.web.Session]] { override def handle(event: AsyncResult[io.vertx.ext.web.Session]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like delete from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteFuture(id: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.delete(id, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like put from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def putFuture(session: io.vertx.ext.web.Session) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.put(session, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like clear from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def clearFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.clear(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like size from [[io.vertx.ext.web.sstore.SessionStore]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sizeFuture() : scala.concurrent.Future[java.lang.Integer] = {
      val promise = concurrent.Promise[java.lang.Integer]/*java.lang.Integer BOXED_PRIMITIVE*/()
      asJava.size(new Handler[AsyncResult[java.lang.Integer]] { override def handle(event: AsyncResult[java.lang.Integer]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type SockJSBridgeOptions = io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions
  object SockJSBridgeOptions {
    def apply() = new SockJSBridgeOptions()
    def apply(json: JsonObject) = new SockJSBridgeOptions(json)
  }



  object SockJSHandler {
    /**
     * Create a SockJS handler     * @param vertx the Vert.x instance
     * @return the handler
     */
  def create(vertx: io.vertx.core.Vertx) = {
      io.vertx.ext.web.handler.sockjs.SockJSHandler.create(vertx)
  }

    /**
     * Create a SockJS handler     * @param vertx the Vert.x instance
     * @param options options to configure the handler see <a href="../../../../../../../../../cheatsheet/SockJSHandlerOptions.html">SockJSHandlerOptions</a>
     * @return the handler
     */
  def create(vertx: io.vertx.core.Vertx, options: io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions) = {
      io.vertx.ext.web.handler.sockjs.SockJSHandler.create(vertx, options)
  }
  }


  type SockJSHandlerOptions = io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions
  object SockJSHandlerOptions {
    def apply() = new SockJSHandlerOptions()
    def apply(json: JsonObject) = new SockJSHandlerOptions(json)
  }




  /**
    *
    * You interact with SockJS clients through instances of SockJS socket.
    * 
    * The API is very similar to [[io.vertx.core.http.WebSocket]].
    * It implements both  and 
    * so it can be used with
    * [[io.vertx.core.streams.Pump]] to pump data with flow control.
    */

  implicit class SockJSSocketScala(val asJava: io.vertx.ext.web.handler.sockjs.SockJSSocket) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def handler(handler: scala.Option[io.vertx.core.buffer.Buffer => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]]).getOrElse(null))
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def drainHandler(handler: scala.Option[Void => Unit]) = {
      asJava.drainHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

    /**
     * Like webSession from [[io.vertx.ext.web.handler.sockjs.SockJSSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def webSessionOption() = {
      scala.Option(asJava.webSession())
  }

    /**
     * Like webUser from [[io.vertx.ext.web.handler.sockjs.SockJSSocket]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def webUserOption() = {
      scala.Option(asJava.webUser())
  }

  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def endFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.end(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def endFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.end(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def writeFuture(data: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.write(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def writeFuture(data: io.vertx.core.buffer.Buffer) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.write(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object StaticHandler {
    /**
     * Create a handler using defaults     * @return the handler
     */
  def create() = {
      io.vertx.ext.web.handler.StaticHandler.create()
  }

    /**
     * Create a handler, specifying web-root     * @param root the web-root
     * @return the handler
     */
  def create(root: java.lang.String) = {
      io.vertx.ext.web.handler.StaticHandler.create(root)
  }
  }


  object TemplateHandler {
    /**
     * Create a handler     * @param engine the template engine
     * @return the handler
     */
  def create(engine: io.vertx.ext.web.common.template.TemplateEngine) = {
      io.vertx.ext.web.handler.TemplateHandler.create(engine)
  }

    /**
     * Create a handler     * @param engine the template engine
     * @param templateDirectory the template directory where templates will be looked for
     * @param contentType the content type header to be used in the response
     * @return the handler
     */
  def create(engine: io.vertx.ext.web.common.template.TemplateEngine, templateDirectory: java.lang.String, contentType: java.lang.String) = {
      io.vertx.ext.web.handler.TemplateHandler.create(engine, templateDirectory, contentType)
  }
  }


  object TimeoutHandler {
    /**
     * Create a handler     * @return the handler
     */
  def create() = {
      io.vertx.ext.web.handler.TimeoutHandler.create()
  }

    /**
     * Create a handler     * @param timeout the timeout, in ms
     * @return the handler
     */
  def create(timeout: java.lang.Long) = {
      io.vertx.ext.web.handler.TimeoutHandler.create(timeout)
  }

    /**
     * Create a handler     * @param timeout the timeout, in ms
     * @return the handler
     */
  def create(timeout: java.lang.Long, errorCode: java.lang.Integer) = {
      io.vertx.ext.web.handler.TimeoutHandler.create(timeout, errorCode)
  }
  }


  object VirtualHostHandler {
    /**
     * Create a handler     * @return the handler
     */
  def create(hostname: java.lang.String, handler: io.vertx.ext.web.RoutingContext => Unit) = {
      io.vertx.ext.web.handler.VirtualHostHandler.create(hostname, handler.asInstanceOf[io.vertx.core.Handler[io.vertx.ext.web.RoutingContext]])
  }
  }


  object WebAuthnHandler {
    /**
     * Create a WebAuthN auth handler. This handler expects at least the response callback to be installed.     * @return the auth handler
     */
  def create(webAuthn: io.vertx.ext.auth.webauthn.WebAuthn) = {
      io.vertx.ext.web.handler.WebAuthnHandler.create(webAuthn)
  }
  }


}
