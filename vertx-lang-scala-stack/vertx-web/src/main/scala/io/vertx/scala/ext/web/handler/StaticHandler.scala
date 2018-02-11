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

package io.vertx.scala.ext.web.handler

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{Http2PushMapping => JHttp2PushMapping}
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.web.handler.{StaticHandler => JStaticHandler}
import io.vertx.scala.ext.web.Http2PushMapping
import io.vertx.scala.ext.web.RoutingContext
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * A handler for serving static resources from the file system or classpath.
  */
class StaticHandler(private val _asJava: Object)
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava


  /**
    * Enable/Disable access to the root of the filesystem
    * @param allowRootFileSystemAccess whether root access is allowed
    * @return a reference to this, so the API can be used fluently
    */
  def setAllowRootFileSystemAccess(allowRootFileSystemAccess: Boolean): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setAllowRootFileSystemAccess(allowRootFileSystemAccess.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Set the web root
    * @param webRoot the web root
    * @return a reference to this, so the API can be used fluently
    */
  def setWebRoot(webRoot: String): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setWebRoot(webRoot.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set whether files are read-only and will never change
    * @param readOnly whether files are read-only
    * @return a reference to this, so the API can be used fluently
    */
  def setFilesReadOnly(readOnly: Boolean): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setFilesReadOnly(readOnly.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Set value for max age in caching headers
    * @param maxAgeSeconds maximum time for browser to cache, in seconds
    * @return a reference to this, so the API can be used fluently
    */
  def setMaxAgeSeconds(maxAgeSeconds: Long): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setMaxAgeSeconds(maxAgeSeconds.asInstanceOf[java.lang.Long])
    this
  }

  /**
    * Set whether cache header handling is enabled
    * @param enabled true if enabled
    * @return a reference to this, so the API can be used fluently
    */
  def setCachingEnabled(enabled: Boolean): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setCachingEnabled(enabled.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Set whether directory listing is enabled
    * @param directoryListing true if enabled
    * @return a reference to this, so the API can be used fluently
    */
  def setDirectoryListing(directoryListing: Boolean): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setDirectoryListing(directoryListing.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Set whether hidden files should be served
    * @param includeHidden true if hidden files should be served
    * @return a reference to this, so the API can be used fluently
    */
  def setIncludeHidden(includeHidden: Boolean): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setIncludeHidden(includeHidden.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Set the server cache entry timeout when caching is enabled
    * @param timeout the timeout, in ms
    * @return a reference to this, so the API can be used fluently
    */
  def setCacheEntryTimeout(timeout: Long): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setCacheEntryTimeout(timeout.asInstanceOf[java.lang.Long])
    this
  }

  /**
    * Set the index page
    * @param indexPage the index page
    * @return a reference to this, so the API can be used fluently
    */
  def setIndexPage(indexPage: String): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setIndexPage(indexPage.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set the max cache size, when caching is enabled
    * @param maxCacheSize the max cache size
    * @return a reference to this, so the API can be used fluently
    */
  def setMaxCacheSize(maxCacheSize: Int): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setMaxCacheSize(maxCacheSize.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Set the file mapping for http2push and link preload
    * @param http2PushMappings the mapping for http2 push
    * @return a reference to this, so the API can be used fluently
    */
  def setHttp2PushMapping(http2PushMappings: scala.collection.mutable.Buffer[Http2PushMapping]): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setHttp2PushMapping(http2PushMappings.map(x => x.asJava).asJava)
    this
  }

  /**
    * Set whether async filesystem access should always be used
    * @param alwaysAsyncFS true for always async FS access
    * @return a reference to this, so the API can be used fluently
    */
  def setAlwaysAsyncFS(alwaysAsyncFS: Boolean): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setAlwaysAsyncFS(alwaysAsyncFS.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Set whether async/sync filesystem tuning should enabled
    * @param enableFSTuning true to enabled FS tuning
    * @return a reference to this, so the API can be used fluently
    */
  def setEnableFSTuning(enableFSTuning: Boolean): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setEnableFSTuning(enableFSTuning.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Set the max serve time in ns, above which serves are considered slow
    * @param maxAvgServeTimeNanoSeconds max serve time, in ns
    * @return a reference to this, so the API can be used fluently
    */
  def setMaxAvgServeTimeNs(maxAvgServeTimeNanoSeconds: Long): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setMaxAvgServeTimeNs(maxAvgServeTimeNanoSeconds.asInstanceOf[java.lang.Long])
    this
  }

  /**
    * Set the directory template to be used when directory listing
    * @param directoryTemplate the directory template
    * @return a reference to this, so the API can be used fluently
    */
  def setDirectoryTemplate(directoryTemplate: String): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setDirectoryTemplate(directoryTemplate.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set whether range requests (resumable downloads; media streaming) should be enabled.
    * @param enableRangeSupport true to enable range support
    * @return a reference to this, so the API can be used fluently
    */
  def setEnableRangeSupport(enableRangeSupport: Boolean): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setEnableRangeSupport(enableRangeSupport.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Set whether vary header should be sent with response.
    * @param varyHeader true to sent vary header
    * @return a reference to this, so the API can be used fluently
    */
  def setSendVaryHeader(varyHeader: Boolean): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setSendVaryHeader(varyHeader.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Set the default content encoding for text related files. This allows overriding the system settings default value.
    * @param contentEncoding the desired content encoding e.g.: "UTF-8"
    * @return a reference to this, so the API can be used fluently
    */
  def setDefaultContentEncoding(contentEncoding: String): StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setDefaultContentEncoding(contentEncoding.asInstanceOf[java.lang.String])
    this
  }

  override def handle(arg0: RoutingContext): Unit = {
    asJava.asInstanceOf[JStaticHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

}

object StaticHandler {
  def apply(asJava: JStaticHandler) = new StaticHandler(asJava)  
  /**
    * Create a handler using defaults
    * @return the handler
    */
  def create(): StaticHandler = {
    StaticHandler(JStaticHandler.create())
  }

  /**
    * Create a handler, specifying web-root
    * @param root the web-root
    * @return the handler
    */
  def create(root: String): StaticHandler = {
    StaticHandler(JStaticHandler.create(root.asInstanceOf[java.lang.String]))
  }

}
