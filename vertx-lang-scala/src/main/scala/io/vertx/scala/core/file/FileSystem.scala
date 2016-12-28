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
import io.vertx.lang.scala.Converter._
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
    asJava.asInstanceOf[JFileSystem].copy(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def copyBlocking(from: String,to: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].copyBlocking(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String])
    this
  }

  def copyRecursive(from: String,to: String,recursive: Boolean,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].copyRecursive(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],recursive.asInstanceOf[java.lang.Boolean],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def copyRecursiveBlocking(from: String,to: String,recursive: Boolean):FileSystem = {
    asJava.asInstanceOf[JFileSystem].copyRecursiveBlocking(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],recursive.asInstanceOf[java.lang.Boolean])
    this
  }

  def move(from: String,to: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].move(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def moveBlocking(from: String,to: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].moveBlocking(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String])
    this
  }

  def truncate(path: String,len: Long,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].truncate(path.asInstanceOf[java.lang.String],len.asInstanceOf[java.lang.Long],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def truncateBlocking(path: String,len: Long):FileSystem = {
    asJava.asInstanceOf[JFileSystem].truncateBlocking(path.asInstanceOf[java.lang.String],len.asInstanceOf[java.lang.Long])
    this
  }

  def chmod(path: String,perms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chmod(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def chmodBlocking(path: String,perms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chmodBlocking(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String])
    this
  }

  def chmodRecursive(path: String,perms: String,dirPerms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chmodRecursive(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],dirPerms.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def chmodRecursiveBlocking(path: String,perms: String,dirPerms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chmodRecursiveBlocking(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],dirPerms.asInstanceOf[java.lang.String])
    this
  }

  def chown(path: String,user: scala.Option[String],group: scala.Option[String],handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chown(path.asInstanceOf[java.lang.String],user.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),group.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def chownBlocking(path: String,user: scala.Option[String],group: scala.Option[String]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chownBlocking(path.asInstanceOf[java.lang.String],user.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),group.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null))
    this
  }

  def props(path: String,handler: Handler[AsyncResult[FileProps]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].props(path.asInstanceOf[java.lang.String],{x: AsyncResult[JFileProps] => handler.handle(AsyncResultWrapper[JFileProps,FileProps](x, a => FileProps(a)))})
    this
  }

  def lprops(path: String,handler: Handler[AsyncResult[FileProps]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].lprops(path.asInstanceOf[java.lang.String],{x: AsyncResult[JFileProps] => handler.handle(AsyncResultWrapper[JFileProps,FileProps](x, a => FileProps(a)))})
    this
  }

  def link(link: String,existing: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].link(link.asInstanceOf[java.lang.String],existing.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def linkBlocking(link: String,existing: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].linkBlocking(link.asInstanceOf[java.lang.String],existing.asInstanceOf[java.lang.String])
    this
  }

  def symlink(link: String,existing: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].symlink(link.asInstanceOf[java.lang.String],existing.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def symlinkBlocking(link: String,existing: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].symlinkBlocking(link.asInstanceOf[java.lang.String],existing.asInstanceOf[java.lang.String])
    this
  }

  def unlink(link: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].unlink(link.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def unlinkBlocking(link: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].unlinkBlocking(link.asInstanceOf[java.lang.String])
    this
  }

  def readSymlink(link: String,handler: Handler[AsyncResult[String]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].readSymlink(link.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  def delete(path: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].delete(path.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def deleteBlocking(path: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].deleteBlocking(path.asInstanceOf[java.lang.String])
    this
  }

  def deleteRecursive(path: String,recursive: Boolean,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].deleteRecursive(path.asInstanceOf[java.lang.String],recursive.asInstanceOf[java.lang.Boolean],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def deleteRecursiveBlocking(path: String,recursive: Boolean):FileSystem = {
    asJava.asInstanceOf[JFileSystem].deleteRecursiveBlocking(path.asInstanceOf[java.lang.String],recursive.asInstanceOf[java.lang.Boolean])
    this
  }

  def mkdir(path: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdir(path.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def mkdirBlocking(path: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirBlocking(path.asInstanceOf[java.lang.String])
    this
  }

  def mkdir(path: String,perms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdir(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def mkdirBlocking(path: String,perms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirBlocking(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String])
    this
  }

  def mkdirs(path: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirs(path.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def mkdirsBlocking(path: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirsBlocking(path.asInstanceOf[java.lang.String])
    this
  }

  def mkdirs(path: String,perms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirs(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def mkdirsBlocking(path: String,perms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirsBlocking(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String])
    this
  }

  def readDir(path: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].readDir(path.asInstanceOf[java.lang.String],{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  def readDir(path: String,filter: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].readDir(path.asInstanceOf[java.lang.String],filter.asInstanceOf[java.lang.String],{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  def readFile(path: String,handler: Handler[AsyncResult[Buffer]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].readFile(path.asInstanceOf[java.lang.String],{x: AsyncResult[JBuffer] => handler.handle(AsyncResultWrapper[JBuffer,Buffer](x, a => Buffer(a)))})
    this
  }

  def writeFile(path: String,data: Buffer,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].writeFile(path.asInstanceOf[java.lang.String],data.asJava.asInstanceOf[JBuffer],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def writeFileBlocking(path: String,data: Buffer):FileSystem = {
    asJava.asInstanceOf[JFileSystem].writeFileBlocking(path.asInstanceOf[java.lang.String],data.asJava.asInstanceOf[JBuffer])
    this
  }

  def open(path: String,options: OpenOptions,handler: Handler[AsyncResult[AsyncFile]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].open(path.asInstanceOf[java.lang.String],options.asJava,{x: AsyncResult[JAsyncFile] => handler.handle(AsyncResultWrapper[JAsyncFile,AsyncFile](x, a => AsyncFile(a)))})
    this
  }

  def createFile(path: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].createFile(path.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def createFileBlocking(path: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].createFileBlocking(path.asInstanceOf[java.lang.String])
    this
  }

  def createFile(path: String,perms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].createFile(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def createFileBlocking(path: String,perms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].createFileBlocking(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String])
    this
  }

  def exists(path: String,handler: Handler[AsyncResult[Boolean]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].exists(path.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Boolean] => handler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a.asInstanceOf[Boolean]))})
    this
  }

  def fsProps(path: String,handler: Handler[AsyncResult[FileSystemProps]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].fsProps(path.asInstanceOf[java.lang.String],{x: AsyncResult[JFileSystemProps] => handler.handle(AsyncResultWrapper[JFileSystemProps,FileSystemProps](x, a => FileSystemProps(a)))})
    this
  }

//default methods
//basic methods
  def propsBlocking(path: String):FileProps = {
    FileProps(asJava.asInstanceOf[JFileSystem].propsBlocking(path.asInstanceOf[java.lang.String]))
  }

  def lpropsBlocking(path: String):FileProps = {
    FileProps(asJava.asInstanceOf[JFileSystem].lpropsBlocking(path.asInstanceOf[java.lang.String]))
  }

  def readSymlinkBlocking(link: String):String = {
    asJava.asInstanceOf[JFileSystem].readSymlinkBlocking(link.asInstanceOf[java.lang.String]).asInstanceOf[String]
  }

  def readDirBlocking(path: String):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JFileSystem].readDirBlocking(path.asInstanceOf[java.lang.String]).asScala.map(x => x.asInstanceOf[String])
  }

  def readDirBlocking(path: String,filter: String):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JFileSystem].readDirBlocking(path.asInstanceOf[java.lang.String],filter.asInstanceOf[java.lang.String]).asScala.map(x => x.asInstanceOf[String])
  }

  def readFileBlocking(path: String):Buffer = {
    Buffer(asJava.asInstanceOf[JFileSystem].readFileBlocking(path.asInstanceOf[java.lang.String]))
  }

  def openBlocking(path: String,options: OpenOptions):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JFileSystem].openBlocking(path.asInstanceOf[java.lang.String],options.asJava))
  }

  def existsBlocking(path: String):Boolean = {
    asJava.asInstanceOf[JFileSystem].existsBlocking(path.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }

  def fsPropsBlocking(path: String):FileSystemProps = {
    FileSystemProps(asJava.asInstanceOf[JFileSystem].fsPropsBlocking(path.asInstanceOf[java.lang.String]))
  }

//future methods
def copyFuture(from: String,to: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].copy(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def copyRecursiveFuture(from: String,to: String,recursive: Boolean):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].copyRecursive(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],recursive.asInstanceOf[java.lang.Boolean],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def moveFuture(from: String,to: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].move(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def truncateFuture(path: String,len: Long):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].truncate(path.asInstanceOf[java.lang.String],len.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def chmodFuture(path: String,perms: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].chmod(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def chmodRecursiveFuture(path: String,perms: String,dirPerms: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].chmodRecursive(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],dirPerms.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def chownFuture(path: String,user: scala.Option[String],group: scala.Option[String]):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].chown(path.asInstanceOf[java.lang.String],user.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),group.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def propsFuture(path: String):scala.concurrent.Future[FileProps] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JFileProps, FileProps](x => FileProps(x))
    asJava.asInstanceOf[JFileSystem].props(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def lpropsFuture(path: String):scala.concurrent.Future[FileProps] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JFileProps, FileProps](x => FileProps(x))
    asJava.asInstanceOf[JFileSystem].lprops(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def linkFuture(link: String,existing: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].link(link.asInstanceOf[java.lang.String],existing.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def symlinkFuture(link: String,existing: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].symlink(link.asInstanceOf[java.lang.String],existing.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def unlinkFuture(link: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].unlink(link.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def readSymlinkFuture(link: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JFileSystem].readSymlink(link.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def deleteFuture(path: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].delete(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def deleteRecursiveFuture(path: String,recursive: Boolean):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].deleteRecursive(path.asInstanceOf[java.lang.String],recursive.asInstanceOf[java.lang.Boolean],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def mkdirFuture(path: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].mkdir(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def mkdirFuture(path: String,perms: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].mkdir(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def mkdirsFuture(path: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].mkdirs(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def mkdirsFuture(path: String,perms: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].mkdirs(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def readDirFuture(path: String):scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JFileSystem].readDir(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def readDirFuture(path: String,filter: String):scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JFileSystem].readDir(path.asInstanceOf[java.lang.String],filter.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def readFileFuture(path: String):scala.concurrent.Future[Buffer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JBuffer, Buffer](x => Buffer(x))
    asJava.asInstanceOf[JFileSystem].readFile(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def writeFileFuture(path: String,data: Buffer):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].writeFile(path.asInstanceOf[java.lang.String],data.asJava.asInstanceOf[JBuffer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def openFuture(path: String,options: OpenOptions):scala.concurrent.Future[AsyncFile] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAsyncFile, AsyncFile](x => AsyncFile(x))
    asJava.asInstanceOf[JFileSystem].open(path.asInstanceOf[java.lang.String],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def createFileFuture(path: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].createFile(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def createFileFuture(path: String,perms: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].createFile(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def existsFuture(path: String):scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JFileSystem].exists(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def fsPropsFuture(path: String):scala.concurrent.Future[FileSystemProps] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JFileSystemProps, FileSystemProps](x => FileSystemProps(x))
    asJava.asInstanceOf[JFileSystem].fsProps(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object FileSystem{
    def apply(asJava: JFileSystem) = new FileSystem(asJava)  
  //static methods
  }
