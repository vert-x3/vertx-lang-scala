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
  def setCreate(value:Boolean) = {
    asJava.setCreate(value)
    this
  }
  def isCreate = {
    asJava.isCreate()
  }
  def setCreateNew(value:Boolean) = {
    asJava.setCreateNew(value)
    this
  }
  def isCreateNew = {
    asJava.isCreateNew()
  }
  def setDeleteOnClose(value:Boolean) = {
    asJava.setDeleteOnClose(value)
    this
  }
  def isDeleteOnClose = {
    asJava.isDeleteOnClose()
  }
  def setDsync(value:Boolean) = {
    asJava.setDsync(value)
    this
  }
  def isDsync = {
    asJava.isDsync()
  }
  def setPerms(value:String) = {
    asJava.setPerms(value)
    this
  }
  def getPerms = {
    asJava.getPerms()
  }
  def setRead(value:Boolean) = {
    asJava.setRead(value)
    this
  }
  def isRead = {
    asJava.isRead()
  }
  def setSparse(value:Boolean) = {
    asJava.setSparse(value)
    this
  }
  def isSparse = {
    asJava.isSparse()
  }
  def setSync(value:Boolean) = {
    asJava.setSync(value)
    this
  }
  def isSync = {
    asJava.isSync()
  }
  def setTruncateExisting(value:Boolean) = {
    asJava.setTruncateExisting(value)
    this
  }
  def isTruncateExisting = {
    asJava.isTruncateExisting()
  }
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
