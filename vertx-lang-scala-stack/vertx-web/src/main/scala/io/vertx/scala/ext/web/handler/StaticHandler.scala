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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{RoutingContext => JRoutingContext}
import io.vertx.ext.web.handler.{StaticHandler => JStaticHandler}
import io.vertx.scala.ext.web.RoutingContext
import io.vertx.core.Handler

/**
  * A handler for serving static resources from the file system or classpath.
  */
class StaticHandler(private val _asJava: Object) 
    extends io.vertx.core.Handler[RoutingContext] {

  def asJava = _asJava

//cached methods
//fluent methods
  def setAllowRootFileSystemAccess(allowRootFileSystemAccess: Boolean):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setAllowRootFileSystemAccess(allowRootFileSystemAccess.asInstanceOf[java.lang.Boolean])
    this
  }

  def setWebRoot(webRoot: String):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setWebRoot(webRoot.asInstanceOf[java.lang.String])
    this
  }

  def setFilesReadOnly(readOnly: Boolean):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setFilesReadOnly(readOnly.asInstanceOf[java.lang.Boolean])
    this
  }

  def setMaxAgeSeconds(maxAgeSeconds: Long):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setMaxAgeSeconds(maxAgeSeconds.asInstanceOf[java.lang.Long])
    this
  }

  def setCachingEnabled(enabled: Boolean):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setCachingEnabled(enabled.asInstanceOf[java.lang.Boolean])
    this
  }

  def setDirectoryListing(directoryListing: Boolean):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setDirectoryListing(directoryListing.asInstanceOf[java.lang.Boolean])
    this
  }

  def setIncludeHidden(includeHidden: Boolean):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setIncludeHidden(includeHidden.asInstanceOf[java.lang.Boolean])
    this
  }

  def setCacheEntryTimeout(timeout: Long):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setCacheEntryTimeout(timeout.asInstanceOf[java.lang.Long])
    this
  }

  def setIndexPage(indexPage: String):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setIndexPage(indexPage.asInstanceOf[java.lang.String])
    this
  }

  def setMaxCacheSize(maxCacheSize: Int):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setMaxCacheSize(maxCacheSize.asInstanceOf[java.lang.Integer])
    this
  }

  def setAlwaysAsyncFS(alwaysAsyncFS: Boolean):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setAlwaysAsyncFS(alwaysAsyncFS.asInstanceOf[java.lang.Boolean])
    this
  }

  def setEnableFSTuning(enableFSTuning: Boolean):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setEnableFSTuning(enableFSTuning.asInstanceOf[java.lang.Boolean])
    this
  }

  def setMaxAvgServeTimeNs(maxAvgServeTimeNanoSeconds: Long):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setMaxAvgServeTimeNs(maxAvgServeTimeNanoSeconds.asInstanceOf[java.lang.Long])
    this
  }

  def setDirectoryTemplate(directoryTemplate: String):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setDirectoryTemplate(directoryTemplate.asInstanceOf[java.lang.String])
    this
  }

  def setEnableRangeSupport(enableRangeSupport: Boolean):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setEnableRangeSupport(enableRangeSupport.asInstanceOf[java.lang.Boolean])
    this
  }

  def setSendVaryHeader(varyHeader: Boolean):StaticHandler = {
    asJava.asInstanceOf[JStaticHandler].setSendVaryHeader(varyHeader.asInstanceOf[java.lang.Boolean])
    this
  }

//default methods
//basic methods
  override def handle(arg0: RoutingContext):Unit = {
    asJava.asInstanceOf[JStaticHandler].handle(arg0.asJava.asInstanceOf[JRoutingContext])
  }

//future methods
}

  object StaticHandler{
    def apply(asJava: JStaticHandler) = new StaticHandler(asJava)  
  //static methods
    def create():StaticHandler = {
      StaticHandler(JStaticHandler.create())
    }

    def create(root: String):StaticHandler = {
      StaticHandler(JStaticHandler.create(root.asInstanceOf[java.lang.String]))
    }

  }
