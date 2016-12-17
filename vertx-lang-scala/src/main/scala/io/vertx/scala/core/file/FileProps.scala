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


/**
  * Represents properties of a file on the file system.
  * 
  */
class FileProps(private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JFileProps]
//methods returning a future
//cached methods
//fluent methods
//basic methods
  def creationTime():Long = {
    asJava.creationTime( )
  }

  def lastAccessTime():Long = {
    asJava.lastAccessTime( )
  }

  def lastModifiedTime():Long = {
    asJava.lastModifiedTime( )
  }

  def isDirectory():Boolean = {
    asJava.isDirectory( )
  }

  def isOther():Boolean = {
    asJava.isOther( )
  }

  def isRegularFile():Boolean = {
    asJava.isRegularFile( )
  }

  def isSymbolicLink():Boolean = {
    asJava.isSymbolicLink( )
  }

  def size():Long = {
    asJava.size( )
  }

}

object FileProps{
//in object!
//static methods
}
