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

import io.vertx.core.file.{FileProps => JFileProps}

/**
  * Represents properties of a file on the file system.
  * 
  */
class FileProps(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//basic methods
  def creationTime():Long = {
    asJava.asInstanceOf[JFileProps].creationTime()
  }

  def lastAccessTime():Long = {
    asJava.asInstanceOf[JFileProps].lastAccessTime()
  }

  def lastModifiedTime():Long = {
    asJava.asInstanceOf[JFileProps].lastModifiedTime()
  }

  def isDirectory():Boolean = {
    asJava.asInstanceOf[JFileProps].isDirectory()
  }

  def isOther():Boolean = {
    asJava.asInstanceOf[JFileProps].isOther()
  }

  def isRegularFile():Boolean = {
    asJava.asInstanceOf[JFileProps].isRegularFile()
  }

  def isSymbolicLink():Boolean = {
    asJava.asInstanceOf[JFileProps].isSymbolicLink()
  }

  def size():Long = {
    asJava.asInstanceOf[JFileProps].size()
  }

}

  object FileProps{
    def apply(asJava: JFileProps) = new FileProps(asJava)  
  //static methods
  }
