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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler

/**
  * A handler for serving static resources from the file system or classpath.
  */
class StaticHandler(private val _asJava: io.vertx.ext.web.handler.StaticHandler) {

  def asJava: io.vertx.ext.web.handler.StaticHandler = _asJava

  def handle(arg0: io.vertx.scala.ext.web.RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext])
  }

  /**
    * Enable/Disable access to the root of the filesystem
    * @param allowRootFileSystemAccess whether root access is allowed
    * @return a reference to this, so the API can be used fluently
    */
  def setAllowRootFileSystemAccess(allowRootFileSystemAccess: Boolean): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setAllowRootFileSystemAccess(allowRootFileSystemAccess)
    this
  }

  /**
    * Set the web root
    * @param webRoot the web root
    * @return a reference to this, so the API can be used fluently
    */
  def setWebRoot(webRoot: String): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setWebRoot(webRoot)
    this
  }

  /**
    * Set whether files are read-only and will never change
    * @param readOnly whether files are read-only
    * @return a reference to this, so the API can be used fluently
    */
  def setFilesReadOnly(readOnly: Boolean): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setFilesReadOnly(readOnly)
    this
  }

  /**
    * Set value for max age in caching headers
    * @param maxAgeSeconds maximum time for browser to cache, in seconds
    * @return a reference to this, so the API can be used fluently
    */
  def setMaxAgeSeconds(maxAgeSeconds: Long): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setMaxAgeSeconds(maxAgeSeconds)
    this
  }

  /**
    * Set whether cache header handling is enabled
    * @param enabled true if enabled
    * @return a reference to this, so the API can be used fluently
    */
  def setCachingEnabled(enabled: Boolean): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setCachingEnabled(enabled)
    this
  }

  /**
    * Set whether directory listing is enabled
    * @param directoryListing true if enabled
    * @return a reference to this, so the API can be used fluently
    */
  def setDirectoryListing(directoryListing: Boolean): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setDirectoryListing(directoryListing)
    this
  }

  /**
    * Set whether hidden files should be served
    * @param includeHidden true if hidden files should be served
    * @return a reference to this, so the API can be used fluently
    */
  def setIncludeHidden(includeHidden: Boolean): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setIncludeHidden(includeHidden)
    this
  }

  /**
    * Set the server cache entry timeout when caching is enabled
    * @param timeout the timeout, in ms
    * @return a reference to this, so the API can be used fluently
    */
  def setCacheEntryTimeout(timeout: Long): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setCacheEntryTimeout(timeout)
    this
  }

  /**
    * Set the index page
    * @param indexPage the index page
    * @return a reference to this, so the API can be used fluently
    */
  def setIndexPage(indexPage: String): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setIndexPage(indexPage)
    this
  }

  /**
    * Set the max cache size, when caching is enabled
    * @param maxCacheSize the max cache size
    * @return a reference to this, so the API can be used fluently
    */
  def setMaxCacheSize(maxCacheSize: Int): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setMaxCacheSize(maxCacheSize)
    this
  }

  /**
    * Set whether async filesystem access should always be used
    * @param alwaysAsyncFS true for always async FS access
    * @return a reference to this, so the API can be used fluently
    */
  def setAlwaysAsyncFS(alwaysAsyncFS: Boolean): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setAlwaysAsyncFS(alwaysAsyncFS)
    this
  }

  /**
    * Set whether async/sync filesystem tuning should enabled
    * @param enableFSTuning true to enabled FS tuning
    * @return a reference to this, so the API can be used fluently
    */
  def setEnableFSTuning(enableFSTuning: Boolean): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setEnableFSTuning(enableFSTuning)
    this
  }

  /**
    * Set the max serve time in ns, above which serves are considered slow
    * @param maxAvgServeTimeNanoSeconds max serve time, in ns
    * @return a reference to this, so the API can be used fluently
    */
  def setMaxAvgServeTimeNs(maxAvgServeTimeNanoSeconds: Long): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setMaxAvgServeTimeNs(maxAvgServeTimeNanoSeconds)
    this
  }

  /**
    * Set the directory template to be used when directory listing
    * @param directoryTemplate the directory template
    * @return a reference to this, so the API can be used fluently
    */
  def setDirectoryTemplate(directoryTemplate: String): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setDirectoryTemplate(directoryTemplate)
    this
  }

  /**
    * Set whether range requests (resumable downloads; media streaming) should be enabled.
    * @param enableRangeSupport true to enable range support
    * @return a reference to this, so the API can be used fluently
    */
  def setEnableRangeSupport(enableRangeSupport: Boolean): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setEnableRangeSupport(enableRangeSupport)
    this
  }

  /**
    * Set whether vary header should be sent with response.
    * @param varyHeader true to sent vary header
    * @return a reference to this, so the API can be used fluently
    */
  def setSendVaryHeader(varyHeader: Boolean): io.vertx.scala.ext.web.handler.StaticHandler = {
    _asJava.setSendVaryHeader(varyHeader)
    this
  }

}

object StaticHandler {

  def apply(_asJava: io.vertx.ext.web.handler.StaticHandler): io.vertx.scala.ext.web.handler.StaticHandler =
    new io.vertx.scala.ext.web.handler.StaticHandler(_asJava)

  def create(): io.vertx.scala.ext.web.handler.StaticHandler = {
    StaticHandler.apply(io.vertx.ext.web.handler.StaticHandler.create())
  }

  def create(root: String): io.vertx.scala.ext.web.handler.StaticHandler = {
    StaticHandler.apply(io.vertx.ext.web.handler.StaticHandler.create(root))
  }

}
