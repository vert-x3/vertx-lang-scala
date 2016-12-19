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
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.file.{FileSystem => JFileSystem}
import io.vertx.core.file.{FileSystemProps => JFileSystemProps}
import io.vertx.core.file.{AsyncFile => JAsyncFile}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.AsyncResult
import io.vertx.core.file.{FileProps => JFileProps}
import scala.collection.JavaConverters._
import io.vertx.core.Handler

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

  def asJava = _asJava

//cached methods
//fluent methods
  def copy(from: String,to: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].copy(from,to,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def copyBlocking(from: String,to: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].copyBlocking(from,to)
    this
  }

  def copyRecursive(from: String,to: String,recursive: Boolean,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].copyRecursive(from,to,recursive,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def copyRecursiveBlocking(from: String,to: String,recursive: Boolean):FileSystem = {
    asJava.asInstanceOf[JFileSystem].copyRecursiveBlocking(from,to,recursive)
    this
  }

  def move(from: String,to: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].move(from,to,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def moveBlocking(from: String,to: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].moveBlocking(from,to)
    this
  }

  def truncate(path: String,len: Long,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].truncate(path,len,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def truncateBlocking(path: String,len: Long):FileSystem = {
    asJava.asInstanceOf[JFileSystem].truncateBlocking(path,len)
    this
  }

  def chmod(path: String,perms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chmod(path,perms,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def chmodBlocking(path: String,perms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chmodBlocking(path,perms)
    this
  }

  def chmodRecursive(path: String,perms: String,dirPerms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chmodRecursive(path,perms,dirPerms,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def chmodRecursiveBlocking(path: String,perms: String,dirPerms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chmodRecursiveBlocking(path,perms,dirPerms)
    this
  }

  def chown(path: String,user: String,group: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chown(path,user,group,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def chownBlocking(path: String,user: String,group: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chownBlocking(path,user,group)
    this
  }

  def props(path: String,handler: Handler[AsyncResult[FileProps]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].props(path,{x: AsyncResult[JFileProps] => handler.handle(AsyncResultWrapper[JFileProps,FileProps](x, a => FileProps(a)))})
    this
  }

  def lprops(path: String,handler: Handler[AsyncResult[FileProps]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].lprops(path,{x: AsyncResult[JFileProps] => handler.handle(AsyncResultWrapper[JFileProps,FileProps](x, a => FileProps(a)))})
    this
  }

  def link(link: String,existing: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].link(link,existing,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def linkBlocking(link: String,existing: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].linkBlocking(link,existing)
    this
  }

  def symlink(link: String,existing: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].symlink(link,existing,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def symlinkBlocking(link: String,existing: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].symlinkBlocking(link,existing)
    this
  }

  def unlink(link: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].unlink(link,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def unlinkBlocking(link: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].unlinkBlocking(link)
    this
  }

  def readSymlink(link: String,handler: Handler[AsyncResult[String]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].readSymlink(link,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a))})
    this
  }

  def delete(path: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].delete(path,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def deleteBlocking(path: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].deleteBlocking(path)
    this
  }

  def deleteRecursive(path: String,recursive: Boolean,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].deleteRecursive(path,recursive,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def deleteRecursiveBlocking(path: String,recursive: Boolean):FileSystem = {
    asJava.asInstanceOf[JFileSystem].deleteRecursiveBlocking(path,recursive)
    this
  }

  def mkdir(path: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdir(path,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def mkdirBlocking(path: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirBlocking(path)
    this
  }

  def mkdir(path: String,perms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdir(path,perms,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def mkdirBlocking(path: String,perms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirBlocking(path,perms)
    this
  }

  def mkdirs(path: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirs(path,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def mkdirsBlocking(path: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirsBlocking(path)
    this
  }

  def mkdirs(path: String,perms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirs(path,perms,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def mkdirsBlocking(path: String,perms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirsBlocking(path,perms)
    this
  }

  def readDir(path: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].readDir(path,{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x)))})
    this
  }

  def readDir(path: String,filter: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].readDir(path,filter,{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x)))})
    this
  }

  def readFile(path: String,handler: Handler[AsyncResult[Buffer]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].readFile(path,{x: AsyncResult[JBuffer] => handler.handle(AsyncResultWrapper[JBuffer,Buffer](x, a => Buffer(a)))})
    this
  }

  def writeFile(path: String,data: Buffer,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].writeFile(path,data.asJava.asInstanceOf[JBuffer],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def writeFileBlocking(path: String,data: Buffer):FileSystem = {
    asJava.asInstanceOf[JFileSystem].writeFileBlocking(path,data.asJava.asInstanceOf[JBuffer])
    this
  }

  def open(path: String,options: OpenOptions,handler: Handler[AsyncResult[AsyncFile]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].open(path,options.asJava,{x: AsyncResult[JAsyncFile] => handler.handle(AsyncResultWrapper[JAsyncFile,AsyncFile](x, a => AsyncFile(a)))})
    this
  }

  def createFile(path: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].createFile(path,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def createFileBlocking(path: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].createFileBlocking(path)
    this
  }

  def createFile(path: String,perms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].createFile(path,perms,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def createFileBlocking(path: String,perms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].createFileBlocking(path,perms)
    this
  }

  def exists(path: String,handler: Handler[AsyncResult[Boolean]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].exists(path,{x: AsyncResult[java.lang.Boolean] => handler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a))})
    this
  }

  def fsProps(path: String,handler: Handler[AsyncResult[FileSystemProps]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].fsProps(path,{x: AsyncResult[JFileSystemProps] => handler.handle(AsyncResultWrapper[JFileSystemProps,FileSystemProps](x, a => FileSystemProps(a)))})
    this
  }

//basic methods
  def propsBlocking(path: String):FileProps = {
    FileProps(asJava.asInstanceOf[JFileSystem].propsBlocking(path))
  }

  def lpropsBlocking(path: String):FileProps = {
    FileProps(asJava.asInstanceOf[JFileSystem].lpropsBlocking(path))
  }

  def readSymlinkBlocking(link: String):String = {
    asJava.asInstanceOf[JFileSystem].readSymlinkBlocking(link)
  }

  def readDirBlocking(path: String):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JFileSystem].readDirBlocking(path).asScala.map(x => x)
  }

  def readDirBlocking(path: String,filter: String):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JFileSystem].readDirBlocking(path,filter).asScala.map(x => x)
  }

  def readFileBlocking(path: String):Buffer = {
    Buffer(asJava.asInstanceOf[JFileSystem].readFileBlocking(path))
  }

  def openBlocking(path: String,options: OpenOptions):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JFileSystem].openBlocking(path,options.asJava))
  }

  def existsBlocking(path: String):Boolean = {
    asJava.asInstanceOf[JFileSystem].existsBlocking(path)
  }

  def fsPropsBlocking(path: String):FileSystemProps = {
    FileSystemProps(asJava.asInstanceOf[JFileSystem].fsPropsBlocking(path))
  }

}

  object FileSystem{
    def apply(asJava: JFileSystem) = new FileSystem(asJava)  
  //static methods
  }
