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

import io.vertx.core.file.{OpenOptions => JOpenOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Describes how an [[io.vertx.scala.core.file.AsyncFile]] should be opened.
 */

class OpenOptions(private val _asJava: JOpenOptions) {
  def asJava = _asJava
  /**
   * Whether the file should be opened in append mode. Defaults to `false`.
   */
  def setAppend(value: Boolean) = {
    asJava.setAppend(value)
    this
  }

  def isAppend: Boolean = {
    asJava.isAppend().asInstanceOf[Boolean]
  }

  /**
   * Set whether the file should be created if it does not already exist.
   */
  def setCreate(value: Boolean) = {
    asJava.setCreate(value)
    this
  }

  def isCreate: Boolean = {
    asJava.isCreate().asInstanceOf[Boolean]
  }

  /**
   * Set whether the file should be created and fail if it does exist already.
   */
  def setCreateNew(value: Boolean) = {
    asJava.setCreateNew(value)
    this
  }

  def isCreateNew: Boolean = {
    asJava.isCreateNew().asInstanceOf[Boolean]
  }

  /**
   * Set whether the file should be deleted when it's closed, or the JVM is shutdown.
   */
  def setDeleteOnClose(value: Boolean) = {
    asJava.setDeleteOnClose(value)
    this
  }

  def isDeleteOnClose: Boolean = {
    asJava.isDeleteOnClose().asInstanceOf[Boolean]
  }

  /**
   * Set whether every write to the file's content  ill be written synchronously to the underlying hardware.
   */
  def setDsync(value: Boolean) = {
    asJava.setDsync(value)
    this
  }

  def isDsync: Boolean = {
    asJava.isDsync().asInstanceOf[Boolean]
  }

  /**
   * Set the permissions string
   */
  def setPerms(value: String) = {
    asJava.setPerms(value)
    this
  }

  def getPerms: String = {
    asJava.getPerms().asInstanceOf[String]
  }

  /**
   * Set whether the file is to be opened for reading
   */
  def setRead(value: Boolean) = {
    asJava.setRead(value)
    this
  }

  def isRead: Boolean = {
    asJava.isRead().asInstanceOf[Boolean]
  }

  /**
   * Set whether a hint should be provided that the file to created is sparse
   */
  def setSparse(value: Boolean) = {
    asJava.setSparse(value)
    this
  }

  def isSparse: Boolean = {
    asJava.isSparse().asInstanceOf[Boolean]
  }

  /**
   * Set whether every write to the file's content and meta-data will be written synchronously to the underlying hardware.
   */
  def setSync(value: Boolean) = {
    asJava.setSync(value)
    this
  }

  def isSync: Boolean = {
    asJava.isSync().asInstanceOf[Boolean]
  }

  /**
   * Set whether the file should be truncated to zero length on opening if it exists and is opened for write
   */
  def setTruncateExisting(value: Boolean) = {
    asJava.setTruncateExisting(value)
    this
  }

  def isTruncateExisting: Boolean = {
    asJava.isTruncateExisting().asInstanceOf[Boolean]
  }

  /**
   * Set whether the file is to be opened for writing
   */
  def setWrite(value: Boolean) = {
    asJava.setWrite(value)
    this
  }

  def isWrite: Boolean = {
    asJava.isWrite().asInstanceOf[Boolean]
  }

}


object OpenOptions {

  def apply() = {
    new OpenOptions(new JOpenOptions(emptyObj()))
  }

  def apply(t: JOpenOptions) = {
    if (t != null) {
      new OpenOptions(t)
    } else {
      new OpenOptions(new JOpenOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): OpenOptions = {
    if (json != null) {
      new OpenOptions(new JOpenOptions(json))
    } else {
      new OpenOptions(new JOpenOptions(emptyObj()))
    }
  }
}

