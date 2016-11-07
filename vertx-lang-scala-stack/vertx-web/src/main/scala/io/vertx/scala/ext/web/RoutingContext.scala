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

package io.vertx.scala.ext.web

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.web.{Route => JRoute}
import io.vertx.ext.web.{Cookie => JCookie}
import io.vertx.ext.web.{Locale => JLocale}
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.scala.core.http.HttpServerRequest
import io.vertx.ext.web.{Session => JSession}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.web.{FileUpload => JFileUpload}
import io.vertx.core.json.JsonArray
import io.vertx.ext.auth.{User => JUser}
import io.vertx.scala.ext.auth.User
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import io.vertx.scala.core.http.HttpServerResponse
import io.vertx.core.http.HttpMethod
import io.vertx.core.json.JsonObject

/**
  * Represents the context for the handling of a request in Vert.x-Web.
  * 
  * A new instance is created for each HTTP request that is received in the
  * [[io.vertx.scala.ext.web.Router#accept]] of the router.
  * 
  * The same instance is passed to any matching request or failure handlers during the routing of the request or
  * failure.
  * 
  * The context provides access to the  and 
  * and allows you to maintain arbitrary data that lives for the lifetime of the context. Contexts are discarded once they
  * have been routed to the handler for the request.
  * 
  * The context also provides access to the [[io.vertx.scala.ext.web.Session]], cookies and body for the request, given the correct handlers
  * in the application.
  */
class RoutingContext(private val _asJava: JRoutingContext) {

  def asJava: JRoutingContext = _asJava

  /**
    * @return the HTTP request object
    */
  def request(): HttpServerRequest = {
    if (cached_0 == null) {
      cached_0=    HttpServerRequest.apply(_asJava.request())
    }
    cached_0
  }

  /**
    * @return the HTTP response object
    */
  def response(): HttpServerResponse = {
    if (cached_1 == null) {
      cached_1=    HttpServerResponse.apply(_asJava.response())
    }
    cached_1
  }

  /**
    * Tell the router to route this context to the next matching route (if any).
    * This method, if called, does not need to be called during the execution of the handler, it can be called
    * some arbitrary time later, if required.
    * 
    * If next is not called for a handler then the handler should make sure it ends the response or no response
    * will be sent.
    */
  def next(): Unit = {
    _asJava.next()
  }

  /**
    * Fail the context with the specified status code.
    * 
    * This will cause the router to route the context to any matching failure handlers for the request. If no failure handlers
    * match a default failure response will be sent.
    * @param statusCode the HTTP status code
    */
  def fail(statusCode: Int): Unit = {
    _asJava.fail(statusCode)
  }

  /**
    * Fail the context with the specified throwable.
    * 
    * This will cause the router to route the context to any matching failure handlers for the request. If no failure handlers
    * match a default failure response with status code 500 will be sent.
    * @param throwable a throwable representing the failure
    */
  def fail(throwable: Throwable): Unit = {
    _asJava.fail(throwable)
  }

  /**
    * Put some arbitrary data in the context. This will be available in any handlers that receive the context.
    * @param key the key for the data
    * @param obj the data
    * @return a reference to this, so the API can be used fluently
    */
  def put(key: String, obj: AnyRef): RoutingContext = {
    _asJava.put(key, obj)
    this
  }

  /**
    * Get some data from the context. The data is available in any handlers that receive the context.
    * @param key the key for the data
    * @return the data
    */
  def get[T](key: String): T = {
    _asJava.get(key)
  }

  /**
    * Remove some data from the context. The data is available in any handlers that receive the context.
    * @param key the key for the data
    * @return the previous data associated with the key
    */
  def remove[T](key: String): T = {
    _asJava.remove(key)
  }

  /**
    * @return the Vert.x instance associated to the initiating [[Router]] for this context
    */
  def vertx(): Vertx = {
    Vertx.apply(_asJava.vertx())
  }

  /**
    * @return the mount point for this router. It will be null for a top level router. For a sub-router it will be the path at which the subrouter was mounted.
    */
  def mountPoint(): scala.Option[String] = {
        scala.Option(_asJava.mountPoint())
  }

  /**
    * @return the current route this context is being routed through.
    */
  def currentRoute(): Route = {
    Route.apply(_asJava.currentRoute())
  }

  /**
    * Return the normalised path for the request.
    * 
    * The normalised path is where the URI path has been decoded, i.e. any unicode or other illegal URL characters that
    * were encoded in the original URL with `%` will be returned to their original form. E.g. `%20` will revert to a space.
    * Also `+` reverts to a space in a query.
    * 
    * The normalised path will also not contain any `..` character sequences to prevent resources being accessed outside
    * of the permitted area.
    * 
    * It's recommended to always use the normalised path as opposed to 
    * if accessing server resources requested by a client.
    * @return the normalised path
    */
  def normalisedPath(): String = {
    _asJava.normalisedPath()
  }

  /**
    * Get the cookie with the specified name. The context must have first been routed to a [[io.vertx.scala.ext.web.handler.CookieHandler]]
    * for this to work.
    * @param name the cookie name
    * @return the cookie
    */
  def getCookie(name: String): scala.Option[Cookie] = {
        scala.Option(Cookie.apply(_asJava.getCookie(name)))
  }

  /**
    * Add a cookie. This will be sent back to the client in the response. The context must have first been routed
    * to a [[io.vertx.scala.ext.web.handler.CookieHandler]] for this to work.
    * @param cookie the cookie
    * @return a reference to this, so the API can be used fluently
    */
  def addCookie(cookie: Cookie): RoutingContext = {
    _asJava.addCookie(cookie.asJava.asInstanceOf[JCookie])
    this
  }

  /**
    * Remove a cookie. The context must have first been routed to a [[io.vertx.scala.ext.web.handler.CookieHandler]]
    * for this to work.
    * @param name the name of the cookie
    * @return the cookie, if it existed, or null
    */
  def removeCookie(name: String): scala.Option[Cookie] = {
        scala.Option(Cookie.apply(_asJava.removeCookie(name)))
  }

  /**
    * @return the number of cookies. The context must have first been routed to a [[io.vertx.scala.ext.web.handler.CookieHandler]] for this to work.
    */
  def cookieCount(): Int = {
    _asJava.cookieCount()
  }

  /**
    * @return a set of all the cookies. The context must have first been routed to a [[io.vertx.scala.ext.web.handler.CookieHandler]] for this to be populated.
    */
  def cookies(): Set[Cookie] = {
    _asJava.cookies().asScala.map(Cookie.apply).toSet
  }

  /**
    * @return the entire HTTP request body as a string, assuming UTF-8 encoding. The context must have first been routed to a [[io.vertx.scala.ext.web.handler.BodyHandler]] for this to be populated.
    */
  def getBodyAsString(): scala.Option[String] = {
        scala.Option(_asJava.getBodyAsString())
  }

  /**
    * Get the entire HTTP request body as a string, assuming the specified encoding. The context must have first been routed to a
    * [[io.vertx.scala.ext.web.handler.BodyHandler]] for this to be populated.
    * @param encoding the encoding, e.g. "UTF-16"
    * @return the body
    */
  def getBodyAsString(encoding: String): scala.Option[String] = {
        scala.Option(_asJava.getBodyAsString(encoding))
  }

  /**
    * @return Get the entire HTTP request body as a [[JsonObject]]. The context must have first been routed to a [[io.vertx.scala.ext.web.handler.BodyHandler]] for this to be populated.
    */
  def getBodyAsJson(): scala.Option[JsonObject] = {
        scala.Option(_asJava.getBodyAsJson())
  }

  /**
    * @return Get the entire HTTP request body as a [[JsonArray]]. The context must have first been routed to a [[io.vertx.scala.ext.web.handler.BodyHandler]] for this to be populated.
    */
  def getBodyAsJsonArray(): scala.Option[JsonArray] = {
        scala.Option(_asJava.getBodyAsJsonArray())
  }

  /**
    * @return Get the entire HTTP request body as a [[Buffer]]. The context must have first been routed to a [[io.vertx.scala.ext.web.handler.BodyHandler]] for this to be populated.
    */
  def getBody(): scala.Option[Buffer] = {
        scala.Option(Buffer.apply(_asJava.getBody()))
  }

  /**
    * @return a set of fileuploads (if any) for the request. The context must have first been routed to a [[io.vertx.scala.ext.web.handler.BodyHandler]] for this to work.
    */
  def fileUploads(): Set[FileUpload] = {
    _asJava.fileUploads().asScala.map(FileUpload.apply).toSet
  }

  /**
    * Get the session. The context must have first been routed to a [[io.vertx.scala.ext.web.handler.SessionHandler]]
    * for this to be populated.
    * Sessions live for a browser session, and are maintained by session cookies.
    * @return the session.
    */
  def session(): scala.Option[Session] = {
        scala.Option(Session.apply(_asJava.session()))
  }

  /**
    * Get the authenticated user (if any). This will usually be injected by an auth handler if authentication if successful.
    * @return the user, or null if the current user is not authenticated.
    */
  def user(): scala.Option[User] = {
        scala.Option(User.apply(_asJava.user()))
  }

  /**
    * If the context is being routed to failure handlers after a failure has been triggered by calling
    * [[io.vertx.scala.ext.web.RoutingContext#fail]] then this will return that throwable. It can be used by failure handlers to render a response,
    * e.g. create a failure response page.
    * @return the throwable used when signalling failure
    */
  def failure(): scala.Option[Throwable] = {
    if (cached_2 == null) {
      cached_2=        scala.Option(_asJava.failure())
    }
    cached_2
  }

  /**
    * If the context is being routed to failure handlers after a failure has been triggered by calling
    * [[io.vertx.scala.ext.web.RoutingContext#fail]]  then this will return that status code.  It can be used by failure handlers to render a response,
    * e.g. create a failure response page.
    *
    * When the status code has not been set yet (it is undefined) its value will be -1.
    * @return the status code used when signalling failure
    */
  def statusCode(): Int = {
    if (cached_3 == null) {
      cached_3=    _asJava.statusCode()
    }
    cached_3
  }

  /**
    * If the route specifies produces matches, e.g. produces `text/html` and `text/plain`, and the `accept` header
    * matches one or more of these then this returns the most acceptable match.
    * @return the most acceptable content type.
    */
  def getAcceptableContentType(): scala.Option[String] = {
        scala.Option(_asJava.getAcceptableContentType())
  }

  /**
    * Add a handler that will be called just before headers are written to the response. This gives you a hook where
    * you can write any extra headers before the response has been written when it will be too late.
    * @param handler the handler
    * @return the id of the handler. This can be used if you later want to remove the handler.
    */
  def addHeadersEndHandler(handler: () => Unit): Int = {
    _asJava.addHeadersEndHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
  }

  /**
    * Remove a headers end handler
    * @param handlerID the id as returned from [[io.vertx.scala.ext.web.RoutingContext#addHeadersEndHandler(Handler)]].
    * @return true if the handler existed and was removed, false otherwise
    */
  def removeHeadersEndHandler(handlerID: Int): Boolean = {
    _asJava.removeHeadersEndHandler(handlerID)
  }

  /**
    * Provides a handler that will be called after the last part of the body is written to the wire.
    * The handler is called asynchronously of when the response has been received by the client.
    * This provides a hook allowing you to do more operations once the request has been sent over the wire
    * such as resource cleanup.
    * @param handler the handler
    * @return the id of the handler. This can be used if you later want to remove the handler.
    */
  def addBodyEndHandler(handler: () => Unit): Int = {
    _asJava.addBodyEndHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
  }

  /**
    * Remove a body end handler
    * @param handlerID the id as returned from [[io.vertx.scala.ext.web.RoutingContext#addBodyEndHandler(Handler)]].
    * @return true if the handler existed and was removed, false otherwise
    */
  def removeBodyEndHandler(handlerID: Int): Boolean = {
    _asJava.removeBodyEndHandler(handlerID)
  }

  /**
    * @return true if the context is being routed to failure handlers.
    */
  def failed(): Boolean = {
    _asJava.failed()
  }

  /**
    * Set the body. Used by the [[io.vertx.scala.ext.web.handler.BodyHandler]]. You will not normally call this method.
    * @param body the body
    */
  def setBody(body: Buffer): Unit = {
    _asJava.setBody(body.asJava.asInstanceOf[JBuffer])
  }

  /**
    * Set the session. Used by the [[io.vertx.scala.ext.web.handler.SessionHandler]]. You will not normally call this method.
    * @param session the session
    */
  def setSession(session: Session): Unit = {
    _asJava.setSession(session.asJava.asInstanceOf[JSession])
  }

  /**
    * Set the user. Usually used by auth handlers to inject a User. You will not normally call this method.
    * @param user the user
    */
  def setUser(user: User): Unit = {
    _asJava.setUser(user.asJava.asInstanceOf[JUser])
  }

  /**
    * Clear the current user object in the context. This usually is used for implementing a log out feature, since the
    * current user is unbounded from the routing context.
    */
  def clearUser(): Unit = {
    _asJava.clearUser()
  }

  /**
    * Set the acceptable content type. Used by
    * @param contentType the content type
    */
  def setAcceptableContentType(contentType: scala.Option[String]): Unit = {
    _asJava.setAcceptableContentType((if (contentType.isDefined) contentType.get else null))
  }

  /**
    * Restarts the current router with a new path and reusing the original method. All path parameters are then parsed
    * and available on the params list.
    * @param path the new http path.
    */
  def reroute(path: String): Unit = {
    _asJava.reroute(path)
  }

  /**
    * Restarts the current router with a new method and path. All path parameters are then parsed and available on the
    * params list.
    * @param method the new http request
    * @param path the new http path.
    */
  def reroute(method: io.vertx.core.http.HttpMethod, path: String): Unit = {
    _asJava.reroute(method, path)
  }

  /**
    * Returns the locales for the current request. The locales are determined from the `accept-languages` header and
    * sorted on quality.
    *
    * When 2 or more entries have the same quality then the order used to return the best match is based on the lowest
    * index on the original list. For example if a user has en-US and en-GB with same quality and this order the best
    * match will be en-US because it was declared as first entry by the client.
    * @return the best matched locale for the request
    */
  def acceptableLocales(): scala.collection.mutable.Buffer[Locale] = {
    if (cached_4 == null) {
      cached_4=    _asJava.acceptableLocales().asScala.map(Locale.apply)
    }
    cached_4
  }

  /**
    * Helper to return the user preferred locale. It is the same action as returning the first element of the acceptable
    * locales.
    * @return the users preferred locale.
    */
  def preferredLocale(): Locale = {
    Locale.apply(_asJava.preferredLocale())
  }

  /**
    * Returns a map of named parameters as defined in path declaration with their actual values
    * @return the map of named parameters
    */
  def pathParams(): Map[String, String] = {
    _asJava.pathParams().asScala.toMap
  }

  /**
    * Gets the value of a single path parameter
    * @param name the name of parameter as defined in path declaration
    * @return the actual value of the parameter or null if it doesn't exist
    */
  def pathParam(name: String): scala.Option[String] = {
        scala.Option(_asJava.pathParam(name))
  }

  private var cached_0: HttpServerRequest = _
  private var cached_1: HttpServerResponse = _
  private var cached_2: scala.Option[Throwable] = _
  private var cached_3: Int = _
  private var cached_4: scala.collection.mutable.Buffer[Locale] = _
}

object RoutingContext {

  def apply(_asJava: JRoutingContext): RoutingContext =
    new RoutingContext(_asJava)

}
