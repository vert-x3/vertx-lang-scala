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

import io.vertx.core.file.{FileSystemOptions => JFileSystemOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Vert.x file system base configuration, this class can be extended by provider implementations to configure
 * those specific implementations.

 */

class FileSystemOptions(private val _asJava: JFileSystemOptions) {
  def asJava = _asJava
  /**
   * When vert.x cannot find the file on the filesystem it tries to resolve the
   * file from the class path when this is set to `true`.
   */
  def setClassPathResolvingEnabled(value: Boolean) = {
    asJava.setClassPathResolvingEnabled(value)
    this
  }

  def isClassPathResolvingEnabled: Boolean = {
    asJava.isClassPathResolvingEnabled().asInstanceOf[Boolean]
  }

  /**
   * Set to `true` to cache files on the real file system
   * when the filesystem performs class path resolving.
   */
  def setFileCachingEnabled(value: Boolean) = {
    asJava.setFileCachingEnabled(value)
    this
  }

  def isFileCachingEnabled: Boolean = {
    asJava.isFileCachingEnabled().asInstanceOf[Boolean]
  }

}


object FileSystemOptions {
  
  def apply() = {
    new FileSystemOptions(new JFileSystemOptions(emptyObj()))
  }
  
  def apply(t: JFileSystemOptions) = {
    if (t != null) {
      new FileSystemOptions(t)
    } else {
      new FileSystemOptions(new JFileSystemOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): FileSystemOptions = {
    if (json != null) {
      new FileSystemOptions(new JFileSystemOptions(json))
    } else {
      new FileSystemOptions(new JFileSystemOptions(emptyObj()))
    }
  }
}

