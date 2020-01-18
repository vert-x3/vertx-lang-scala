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

import io.vertx.core.file.{CopyOptions => JCopyOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Describes the copy (and move) options.
 */

class CopyOptions(private val _asJava: JCopyOptions) {
  def asJava = _asJava
  /**
   * Whether move should be performed as an atomic filesystem operation. Defaults to `false`.
   */
  def setAtomicMove(value: Boolean) = {
    asJava.setAtomicMove(value)
    this
  }

  def isAtomicMove: Boolean = {
    asJava.isAtomicMove().asInstanceOf[Boolean]
  }

  /**
   * Whether the file attributes should be copied. Defaults to `false`.
   */
  def setCopyAttributes(value: Boolean) = {
    asJava.setCopyAttributes(value)
    this
  }

  def isCopyAttributes: Boolean = {
    asJava.isCopyAttributes().asInstanceOf[Boolean]
  }

  /**
   * Whether symbolic links should not be followed during copy or move operations. Defaults to `false`.
   */
  def setNofollowLinks(value: Boolean) = {
    asJava.setNofollowLinks(value)
    this
  }

  def isNofollowLinks: Boolean = {
    asJava.isNofollowLinks().asInstanceOf[Boolean]
  }

  /**
   * Whether an existing file, empty directory, or link should be replaced. Defaults to `false`.
   */
  def setReplaceExisting(value: Boolean) = {
    asJava.setReplaceExisting(value)
    this
  }

  def isReplaceExisting: Boolean = {
    asJava.isReplaceExisting().asInstanceOf[Boolean]
  }

}


object CopyOptions {

  def apply() = {
    new CopyOptions(new JCopyOptions(emptyObj()))
  }

  def apply(t: JCopyOptions) = {
    if (t != null) {
      new CopyOptions(t)
    } else {
      new CopyOptions(new JCopyOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): CopyOptions = {
    if (json != null) {
      new CopyOptions(new JCopyOptions(json))
    } else {
      new CopyOptions(new JCopyOptions(emptyObj()))
    }
  }
}

