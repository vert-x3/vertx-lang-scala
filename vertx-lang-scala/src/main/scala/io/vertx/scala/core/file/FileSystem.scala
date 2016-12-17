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

import io.vertx.scala.core.file.AsyncFile
import io.vertx.core.file.{AsyncFile => JAsyncFile}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.file.OpenOptions
import io.vertx.core.file.{OpenOptions => JOpenOptions}
import io.vertx.core.file.{FileSystem => JFileSystem}
import io.vertx.scala.core.file.FileSystemProps
import io.vertx.core.file.{FileSystemProps => JFileSystemProps}
import io.vertx.scala.core.file.FileProps
import io.vertx.core.file.{FileProps => JFileProps}

/**
  * Contains a broad set of operations for manipulating files on the file system.
  * 
  * A (potential) blocking and non blocking version of each operation is provided.
  * 
  * The non blocking versions take a handler which is called when the operation completes or an error occurs.
  * 
  * The blocking versions are named `xxxBlocking` and return the results, or throw exceptions directly.
  * In many cases, depending on the operating system and file system some of the potentially blocking operations
  * can return quickly, which is why we provide them, but it's highly recommended that you test how long they take to
  * return in your particular application before using them on an event loop.
  * 
  * Please consult the documentation for more information on file system support.
  */
class FileSystem(private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JFileSystem]
//methods returning a future
//cached methods
//fluent methods
  def copy(from: String,to: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.copy( )
    this
  }

  def copyBlocking(from: String,to: String):FileSystem = {
    asJava.copyBlocking( )
    this
  }

  def copyRecursive(from: String,to: String,recursive: Boolean,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.copyRecursive( )
    this
  }

  def copyRecursiveBlocking(from: String,to: String,recursive: Boolean):FileSystem = {
    asJava.copyRecursiveBlocking( )
    this
  }

  def move(from: String,to: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.move( )
    this
  }

  def moveBlocking(from: String,to: String):FileSystem = {
    asJava.moveBlocking( )
    this
  }

  def truncate(path: String,len: Long,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.truncate( )
    this
  }

  def truncateBlocking(path: String,len: Long):FileSystem = {
    asJava.truncateBlocking( )
    this
  }

  def chmod(path: String,perms: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.chmod( )
    this
  }

  def chmodBlocking(path: String,perms: String):FileSystem = {
    asJava.chmodBlocking( )
    this
  }

  def chmodRecursive(path: String,perms: String,dirPerms: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.chmodRecursive( )
    this
  }

  def chmodRecursiveBlocking(path: String,perms: String,dirPerms: String):FileSystem = {
    asJava.chmodRecursiveBlocking( )
    this
  }

  def chown(path: String,user: String,group: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.chown( )
    this
  }

  def chownBlocking(path: String,user: String,group: String):FileSystem = {
    asJava.chownBlocking( )
    this
  }

  def props(path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[FileProps]]):FileSystem = {
    asJava.props( )
    this
  }

  def lprops(path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[FileProps]]):FileSystem = {
    asJava.lprops( )
    this
  }

  def link(link: String,existing: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.link( )
    this
  }

  def linkBlocking(link: String,existing: String):FileSystem = {
    asJava.linkBlocking( )
    this
  }

  def symlink(link: String,existing: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.symlink( )
    this
  }

  def symlinkBlocking(link: String,existing: String):FileSystem = {
    asJava.symlinkBlocking( )
    this
  }

  def unlink(link: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.unlink( )
    this
  }

  def unlinkBlocking(link: String):FileSystem = {
    asJava.unlinkBlocking( )
    this
  }

  def readSymlink(link: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[String]]):FileSystem = {
    asJava.readSymlink( )
    this
  }

  def delete(path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.delete( )
    this
  }

  def deleteBlocking(path: String):FileSystem = {
    asJava.deleteBlocking( )
    this
  }

  def deleteRecursive(path: String,recursive: Boolean,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.deleteRecursive( )
    this
  }

  def deleteRecursiveBlocking(path: String,recursive: Boolean):FileSystem = {
    asJava.deleteRecursiveBlocking( )
    this
  }

  def mkdir(path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.mkdir( )
    this
  }

  def mkdirBlocking(path: String):FileSystem = {
    asJava.mkdirBlocking( )
    this
  }

  def mkdir(path: String,perms: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.mkdir( )
    this
  }

  def mkdirBlocking(path: String,perms: String):FileSystem = {
    asJava.mkdirBlocking( )
    this
  }

  def mkdirs(path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.mkdirs( )
    this
  }

  def mkdirsBlocking(path: String):FileSystem = {
    asJava.mkdirsBlocking( )
    this
  }

  def mkdirs(path: String,perms: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.mkdirs( )
    this
  }

  def mkdirsBlocking(path: String,perms: String):FileSystem = {
    asJava.mkdirsBlocking( )
    this
  }

  def readDir(path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[scala.collection.mutable.Buffer[String]]]):FileSystem = {
    asJava.readDir( )
    this
  }

  def readDir(path: String,filter: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[scala.collection.mutable.Buffer[String]]]):FileSystem = {
    asJava.readDir( )
    this
  }

  def readFile(path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Buffer]]):FileSystem = {
    asJava.readFile( )
    this
  }

  def writeFile(path: String,data: Buffer,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.writeFile( )
    this
  }

  def writeFileBlocking(path: String,data: Buffer):FileSystem = {
    asJava.writeFileBlocking( )
    this
  }

  def open(path: String,options: OpenOptions,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[AsyncFile]]):FileSystem = {
    asJava.open( )
    this
  }

  def createFile(path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.createFile( )
    this
  }

  def createFileBlocking(path: String):FileSystem = {
    asJava.createFileBlocking( )
    this
  }

  def createFile(path: String,perms: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):FileSystem = {
    asJava.createFile( )
    this
  }

  def createFileBlocking(path: String,perms: String):FileSystem = {
    asJava.createFileBlocking( )
    this
  }

  def exists(path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Boolean]]):FileSystem = {
    asJava.exists( )
    this
  }

  def fsProps(path: String,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[FileSystemProps]]):FileSystem = {
    asJava.fsProps( )
    this
  }

//basic methods
  def propsBlocking(path: String):FileProps = {
    asJava.propsBlocking( )
  }

  def lpropsBlocking(path: String):FileProps = {
    asJava.lpropsBlocking( )
  }

  def readSymlinkBlocking(link: String):String = {
    asJava.readSymlinkBlocking( )
  }

  def readDirBlocking(path: String):scala.collection.mutable.Buffer[String] = {
    asJava.readDirBlocking( )
  }

  def readDirBlocking(path: String,filter: String):scala.collection.mutable.Buffer[String] = {
    asJava.readDirBlocking( )
  }

  def readFileBlocking(path: String):Buffer = {
    asJava.readFileBlocking( )
  }

  def openBlocking(path: String,options: OpenOptions):AsyncFile = {
    asJava.openBlocking( )
  }

  def existsBlocking(path: String):Boolean = {
    asJava.existsBlocking( )
  }

  def fsPropsBlocking(path: String):FileSystemProps = {
    asJava.fsPropsBlocking( )
  }

}

object FileSystem{
//in object!
//static methods
}
