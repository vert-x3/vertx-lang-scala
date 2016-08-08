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

class OpenOptions(val java: io.vertx.core.file.OpenOptions) {
          def setCreate(value:Boolean) = {
          java.setCreate(value)
          this
  }
            def isCreate = {
    java.isCreate()
  }
            def setCreateNew(value:Boolean) = {
          java.setCreateNew(value)
          this
  }
            def isCreateNew = {
    java.isCreateNew()
  }
            def setDeleteOnClose(value:Boolean) = {
          java.setDeleteOnClose(value)
          this
  }
            def isDeleteOnClose = {
    java.isDeleteOnClose()
  }
            def setDsync(value:Boolean) = {
          java.setDsync(value)
          this
  }
            def isDsync = {
    java.isDsync()
  }
            def setPerms(value:String) = {
          java.setPerms(value)
          this
  }
            def getPerms = {
    java.getPerms()
  }
            def setRead(value:Boolean) = {
          java.setRead(value)
          this
  }
            def isRead = {
    java.isRead()
  }
            def setSparse(value:Boolean) = {
          java.setSparse(value)
          this
  }
            def isSparse = {
    java.isSparse()
  }
            def setSync(value:Boolean) = {
          java.setSync(value)
          this
  }
            def isSync = {
    java.isSync()
  }
            def setTruncateExisting(value:Boolean) = {
          java.setTruncateExisting(value)
          this
  }
            def isTruncateExisting = {
    java.isTruncateExisting()
  }
            def setWrite(value:Boolean) = {
          java.setWrite(value)
          this
  }
            def isWrite = {
    java.isWrite()
  }
  }
object OpenOptions {
  type OpenOptionsJava = io.vertx.core.file.OpenOptions
  def fromJson(json: JsonObject):OpenOptions = {
    new OpenOptions(new OpenOptionsJava(json))
  }
}
