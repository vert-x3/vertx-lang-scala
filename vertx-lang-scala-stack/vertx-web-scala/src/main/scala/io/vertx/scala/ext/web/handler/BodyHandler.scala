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
  * A handler which gathers the entire request body and sets it on the .
  * 
  * It also handles HTTP file uploads and can be used to limit body sizes.
  */
class BodyHandler(private val _asJava: io.vertx.ext.web.handler.BodyHandler) {

  def asJava: io.vertx.ext.web.handler.BodyHandler = _asJava

  def handle(arg0: io.vertx.scala.ext.web.RoutingContext): Unit = {
    _asJava.handle(arg0.asJava.asInstanceOf[io.vertx.ext.web.RoutingContext])
  }

  /**
    * Set the maximum body size -1 means unlimited
    * @param bodyLimit the max size
    * @return reference to this for fluency
    */
  def setBodyLimit(bodyLimit: Long): io.vertx.scala.ext.web.handler.BodyHandler = {
    _asJava.setBodyLimit(bodyLimit)
    this
  }

  /**
    * Set the uploads directory to use
    * @param uploadsDirectory the uploads directory
    * @return reference to this for fluency
    */
  def setUploadsDirectory(uploadsDirectory: String): io.vertx.scala.ext.web.handler.BodyHandler = {
    _asJava.setUploadsDirectory(uploadsDirectory)
    this
  }

  /**
    * Set whether form attributes will be added to the request parameters
    * @param mergeFormAttributes true if they should be merged
    * @return reference to this for fluency
    */
  def setMergeFormAttributes(mergeFormAttributes: Boolean): io.vertx.scala.ext.web.handler.BodyHandler = {
    _asJava.setMergeFormAttributes(mergeFormAttributes)
    this
  }

  /**
    * Set whether uploaded files should be removed after handling the request
    * @param deleteUploadedFilesOnEnd true if uploaded files should be removed after handling the request
    * @return reference to this for fluency
    */
  def setDeleteUploadedFilesOnEnd(deleteUploadedFilesOnEnd: Boolean): io.vertx.scala.ext.web.handler.BodyHandler = {
    _asJava.setDeleteUploadedFilesOnEnd(deleteUploadedFilesOnEnd)
    this
  }

}

object BodyHandler {

  def apply(_asJava: io.vertx.ext.web.handler.BodyHandler): io.vertx.scala.ext.web.handler.BodyHandler =
    new io.vertx.scala.ext.web.handler.BodyHandler(_asJava)

  def create(): io.vertx.scala.ext.web.handler.BodyHandler = {
    BodyHandler.apply(io.vertx.ext.web.handler.BodyHandler.create())
  }

  def create(uploadDirectory: String): io.vertx.scala.ext.web.handler.BodyHandler = {
    BodyHandler.apply(io.vertx.ext.web.handler.BodyHandler.create(uploadDirectory))
  }

}
