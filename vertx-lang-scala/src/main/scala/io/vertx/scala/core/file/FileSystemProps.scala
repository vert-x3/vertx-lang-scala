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

import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.file.{FileSystemProps => JFileSystemProps}

/**
  * Represents properties of the file system.
  */
class FileSystemProps(private val _asJava: Object) {

  def asJava: Object = _asJava

  /**
    * @return The total space on the file system, in bytes
    */
  def totalSpace(): Long = {
    asJava.asInstanceOf[JFileSystemProps].totalSpace()
  }

  /**
    * @return The total un-allocated space on the file system, in bytes
    */
  def unallocatedSpace(): Long = {
    asJava.asInstanceOf[JFileSystemProps].unallocatedSpace()
  }

  /**
    * @return The total usable space on the file system, in bytes
    */
  def usableSpace(): Long = {
    asJava.asInstanceOf[JFileSystemProps].usableSpace()
  }

}

object FileSystemProps {

  def apply(_asJava: Object): FileSystemProps =
    new FileSystemProps(_asJava)

}
