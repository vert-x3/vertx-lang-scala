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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.core.file.{FileSystemProps => JFileSystemProps}

/**
  * Represents properties of the file system.
  */
class FileSystemProps(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def totalSpace():Long = {
    asJava.asInstanceOf[JFileSystemProps].totalSpace()
  }

  def unallocatedSpace():Long = {
    asJava.asInstanceOf[JFileSystemProps].unallocatedSpace()
  }

  def usableSpace():Long = {
    asJava.asInstanceOf[JFileSystemProps].usableSpace()
  }

}

  object FileSystemProps{
    def apply(asJava: JFileSystemProps) = new FileSystemProps(asJava)  
  //static methods
  }
