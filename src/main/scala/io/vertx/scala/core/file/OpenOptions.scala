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

package io.vertx.scala.core.file

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Describes how an [[io.vertx.scala.core.file.AsyncFile]] should be opened.
  */

class OpenOptions(val asJava: io.vertx.core.file.OpenOptions) {

  /**
    * Set whether the file should be created if it does not already exist.
    */
  def setCreate(value:Boolean) = {
    asJava.setCreate(value)
    this
  }
  def isCreate = {
    asJava.isCreate()
  }

  /**
    * Set whether the file should be created and fail if it does exist already.
    */
  def setCreateNew(value:Boolean) = {
    asJava.setCreateNew(value)
    this
  }
  def isCreateNew = {
    asJava.isCreateNew()
  }

  /**
    * Set whether the file should be deleted when it's closed, or the JVM is shutdown.
    */
  def setDeleteOnClose(value:Boolean) = {
    asJava.setDeleteOnClose(value)
    this
  }
  def isDeleteOnClose = {
    asJava.isDeleteOnClose()
  }

  /**
    * Set whether every write to the file's content  ill be written synchronously to the underlying hardware.
    */
  def setDsync(value:Boolean) = {
    asJava.setDsync(value)
    this
  }
  def isDsync = {
    asJava.isDsync()
  }

  /**
    * Set the permissions string
    */
  def setPerms(value:String) = {
    asJava.setPerms(value)
    this
  }
  def getPerms = {
    asJava.getPerms()
  }

  /**
    * Set whether the file is to be opened for reading
    */
  def setRead(value:Boolean) = {
    asJava.setRead(value)
    this
  }
  def isRead = {
    asJava.isRead()
  }

  /**
    * Set whether a hint should be provided that the file to created is sparse
    */
  def setSparse(value:Boolean) = {
    asJava.setSparse(value)
    this
  }
  def isSparse = {
    asJava.isSparse()
  }

  /**
    * Set whether every write to the file's content and meta-data will be written synchronously to the underlying hardware.
    */
  def setSync(value:Boolean) = {
    asJava.setSync(value)
    this
  }
  def isSync = {
    asJava.isSync()
  }

  /**
    * Set whether the file should be truncated to zero length on opening if it exists and is opened for write
    */
  def setTruncateExisting(value:Boolean) = {
    asJava.setTruncateExisting(value)
    this
  }
  def isTruncateExisting = {
    asJava.isTruncateExisting()
  }

  /**
    * Set whether the file is to be opened for writing
    */
  def setWrite(value:Boolean) = {
    asJava.setWrite(value)
    this
  }
  def isWrite = {
    asJava.isWrite()
  }
}

object OpenOptions {
  type OpenOptionsJava = io.vertx.core.file.OpenOptions
  
  def apply() = {
    new OpenOptions(new OpenOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: OpenOptionsJava) = {
    if(t != null)
      new OpenOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):OpenOptions = {
    if(json != null)
      new OpenOptions(new OpenOptionsJava(json))
    else
      null
  }
}
