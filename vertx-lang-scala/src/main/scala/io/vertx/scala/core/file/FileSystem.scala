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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.file.{OpenOptions => JOpenOptions}
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.file.{FileSystem => JFileSystem}
import io.vertx.core.file.{FileSystemProps => JFileSystemProps}
import io.vertx.core.buffer.Buffer
import io.vertx.core.file.{AsyncFile => JAsyncFile}
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

  /**
    * Copy a file from the path `from` to path `to`, asynchronously.
    * 
    * The copy will fail if the destination already exists.
    * @param from the path to copy from
    * @param to the path to copy to
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def copy(from: String,to: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].copy(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#copyFuture]]
    */
//java.lang.String
//java.lang.String
  def copyBlocking(from: String,to: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].copyBlocking(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Copy a file from the path `from` to path `to`, asynchronously.
    * 
    * If `recursive` is `true` and `from` represents a directory, then the directory and its contents
    * will be copied recursively to the destination `to`.
    * 
    * The copy will fail if the destination if the destination already exists.
    * @param from the path to copy from
    * @param to the path to copy to
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//boolean
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def copyRecursive(from: String,to: String,recursive: Boolean,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].copyRecursive(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],recursive.asInstanceOf[java.lang.Boolean],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#copyRecursiveFuture]]
    */
//java.lang.String
//java.lang.String
//boolean
  def copyRecursiveBlocking(from: String,to: String,recursive: Boolean):FileSystem = {
    asJava.asInstanceOf[JFileSystem].copyRecursiveBlocking(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],recursive.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Move a file from the path `from` to path `to`, asynchronously.
    * 
    * The move will fail if the destination already exists.
    * @param from the path to copy from
    * @param to the path to copy to
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def move(from: String,to: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].move(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#moveFuture]]
    */
//java.lang.String
//java.lang.String
  def moveBlocking(from: String,to: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].moveBlocking(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Truncate the file represented by `path` to length `len` in bytes, asynchronously.
    * 
    * The operation will fail if the file does not exist or `len` is less than `zero`.
    * @param path the path to the file
    * @param len the length to truncate it to
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//long
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def truncate(path: String,len: Long,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].truncate(path.asInstanceOf[java.lang.String],len.asInstanceOf[java.lang.Long],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#truncateFuture]]
    */
//java.lang.String
//long
  def truncateBlocking(path: String,len: Long):FileSystem = {
    asJava.asInstanceOf[JFileSystem].truncateBlocking(path.asInstanceOf[java.lang.String],len.asInstanceOf[java.lang.Long])
    this
  }

  /**
    * Change the permissions on the file represented by `path` to `perms`, asynchronously.
    * 
    * The permission String takes the form rwxr-x--- as
    * specified <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
    * @param path the path to the file
    * @param perms the permissions string
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def chmod(path: String,perms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chmod(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem]]
    */
//java.lang.String
//java.lang.String
  def chmodBlocking(path: String,perms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chmodBlocking(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Change the permissions on the file represented by `path` to `perms`, asynchronously.
    * The permission String takes the form rwxr-x--- as
    * specified in {<a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>`.
    * 
    * If the file is directory then all contents will also have their permissions changed recursively. Any directory permissions will
    * be set to `dirPerms`, whilst any normal file permissions will be set to `perms`.
    * @param path the path to the file
    * @param perms the permissions string
    * @param dirPerms the directory permissions
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def chmodRecursive(path: String,perms: String,dirPerms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chmodRecursive(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],dirPerms.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#chmodRecursiveFuture]]
    */
//java.lang.String
//java.lang.String
//java.lang.String
  def chmodRecursiveBlocking(path: String,perms: String,dirPerms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chmodRecursiveBlocking(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],dirPerms.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Change the ownership on the file represented by `path` to `user` and {code group`, asynchronously.
    * @param path the path to the file
    * @param user the user name, `null` will not change the user name
    * @param group the user group, `null` will not change the user group name
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def chown(path: String,user: scala.Option[String],group: scala.Option[String],handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chown(path.asInstanceOf[java.lang.String],user.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),group.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of 
    *
    */
//java.lang.String
//java.lang.String
//java.lang.String
  def chownBlocking(path: String,user: scala.Option[String],group: scala.Option[String]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].chownBlocking(path.asInstanceOf[java.lang.String],user.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),group.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null))
    this
  }

  /**
    * Obtain properties for the file represented by `path`, asynchronously.
    * 
    * If the file is a link, the link will be followed.
    * @param path the path to the file
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.file.FileProps>>
  def props(path: String,handler: Handler[AsyncResult[FileProps]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].props(path.asInstanceOf[java.lang.String],{x: AsyncResult[JFileProps] => handler.handle(AsyncResultWrapper[JFileProps,FileProps](x, a => FileProps(a)))})
    this
  }

  /**
    * Obtain properties for the link represented by `path`, asynchronously.
    * 
    * The link will not be followed.
    * @param path the path to the file
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.file.FileProps>>
  def lprops(path: String,handler: Handler[AsyncResult[FileProps]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].lprops(path.asInstanceOf[java.lang.String],{x: AsyncResult[JFileProps] => handler.handle(AsyncResultWrapper[JFileProps,FileProps](x, a => FileProps(a)))})
    this
  }

  /**
    * Create a hard link on the file system from `link` to `existing`, asynchronously.
    * @param link the link
    * @param existing the link destination
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def link(link: String,existing: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].link(link.asInstanceOf[java.lang.String],existing.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#linkFuture]]
    */
//java.lang.String
//java.lang.String
  def linkBlocking(link: String,existing: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].linkBlocking(link.asInstanceOf[java.lang.String],existing.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Create a symbolic link on the file system from `link` to `existing`, asynchronously.
    * @param link the link
    * @param existing the link destination
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def symlink(link: String,existing: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].symlink(link.asInstanceOf[java.lang.String],existing.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#linkFuture]]
    */
//java.lang.String
//java.lang.String
  def symlinkBlocking(link: String,existing: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].symlinkBlocking(link.asInstanceOf[java.lang.String],existing.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Unlinks the link on the file system represented by the path `link`, asynchronously.
    * @param link the link
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def unlink(link: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].unlink(link.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#unlinkFuture]]
    */
//java.lang.String
  def unlinkBlocking(link: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].unlinkBlocking(link.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Returns the path representing the file that the symbolic link specified by `link` points to, asynchronously.
    * @param link the link
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.String>>
  def readSymlink(link: String,handler: Handler[AsyncResult[String]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].readSymlink(link.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Deletes the file represented by the specified `path`, asynchronously.
    * @param path path to the file
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def delete(path: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].delete(path.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#deleteFuture]]
    */
//java.lang.String
  def deleteBlocking(path: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].deleteBlocking(path.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Deletes the file represented by the specified `path`, asynchronously.
    * 
    * If the path represents a directory and `recursive = true` then the directory and its contents will be
    * deleted recursively.
    * @param path path to the file
    * @param recursive delete recursively?
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//boolean
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def deleteRecursive(path: String,recursive: Boolean,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].deleteRecursive(path.asInstanceOf[java.lang.String],recursive.asInstanceOf[java.lang.Boolean],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#deleteRecursiveFuture]]
    */
//java.lang.String
//boolean
  def deleteRecursiveBlocking(path: String,recursive: Boolean):FileSystem = {
    asJava.asInstanceOf[JFileSystem].deleteRecursiveBlocking(path.asInstanceOf[java.lang.String],recursive.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
    * Create the directory represented by `path`, asynchronously.
    * 
    * The operation will fail if the directory already exists.
    * @param path path to the file
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def mkdir(path: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdir(path.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#mkdirFuture]]
    */
//java.lang.String
  def mkdirBlocking(path: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirBlocking(path.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Create the directory represented by `path`, asynchronously.
    * 
    * The new directory will be created with permissions as specified by `perms`.
    * 
    * The permission String takes the form rwxr-x--- as specified
    * in <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
    * 
    * The operation will fail if the directory already exists.
    * @param path path to the file
    * @param perms the permissions string
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def mkdir(path: String,perms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdir(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#mkdirFuture]]
    */
//java.lang.String
//java.lang.String
  def mkdirBlocking(path: String,perms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirBlocking(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Create the directory represented by `path` and any non existent parents, asynchronously.
    * 
    * The operation will fail if the directory already exists.
    * @param path path to the file
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def mkdirs(path: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirs(path.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#mkdirsFuture]]
    */
//java.lang.String
  def mkdirsBlocking(path: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirsBlocking(path.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Create the directory represented by `path` and any non existent parents, asynchronously.
    * 
    * The new directory will be created with permissions as specified by `perms`.
    * 
    * The permission String takes the form rwxr-x--- as specified
    * in <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
    * 
    * The operation will fail if the directory already exists.
    * @param path path to the file
    * @param perms the permissions string
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def mkdirs(path: String,perms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirs(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#mkdirsFuture]]
    */
//java.lang.String
//java.lang.String
  def mkdirsBlocking(path: String,perms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].mkdirsBlocking(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Read the contents of the directory specified by `path`, asynchronously.
    * 
    * The result is an array of String representing the paths of the files inside the directory.
    * @param path path to the file
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<java.lang.String>>>
  def readDir(path: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].readDir(path.asInstanceOf[java.lang.String],{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  /**
    * Read the contents of the directory specified by `path`, asynchronously.
    * 
    * The parameter `filter` is a regular expression. If `filter` is specified then only the paths that
    * match  @{filter`will be returned.
    * 
    * The result is an array of String representing the paths of the files inside the directory.
    * @param path path to the directory
    * @param filter the filter expression
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<java.lang.String>>>
  def readDir(path: String,filter: String,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].readDir(path.asInstanceOf[java.lang.String],filter.asInstanceOf[java.lang.String],{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  /**
    * Reads the entire file as represented by the path `path` as a , asynchronously.
    * 
    * Do not user this method to read very large files or you risk running out of available RAM.
    * @param path path to the file
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.buffer.Buffer>>
  def readFile(path: String,handler: Handler[AsyncResult[io.vertx.core.buffer.Buffer]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].readFile(path.asInstanceOf[java.lang.String],{x: AsyncResult[Buffer] => handler.handle(AsyncResultWrapper[Buffer,io.vertx.core.buffer.Buffer](x, a => a))})
    this
  }

  /**
    * Creates the file, and writes the specified `Buffer data` to the file represented by the path `path`,
    * asynchronously.
    * @param path path to the file
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.buffer.Buffer
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def writeFile(path: String,data: io.vertx.core.buffer.Buffer,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].writeFile(path.asInstanceOf[java.lang.String],data,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#writeFileFuture]]
    */
//java.lang.String
//io.vertx.core.buffer.Buffer
  def writeFileBlocking(path: String,data: io.vertx.core.buffer.Buffer):FileSystem = {
    asJava.asInstanceOf[JFileSystem].writeFileBlocking(path.asInstanceOf[java.lang.String],data)
    this
  }

  /**
    * Open the file represented by `path`, asynchronously.
    * 
    * The file is opened for both reading and writing. If the file does not already exist it will be created.
    * @param path path to the file
    * @param options options describing how the file should be openedsee <a href="../../../../../../../cheatsheet/OpenOptions.html">OpenOptions</a>
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.file.OpenOptions
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.file.AsyncFile>>
  def open(path: String,options: OpenOptions,handler: Handler[AsyncResult[AsyncFile]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].open(path.asInstanceOf[java.lang.String],options.asJava,{x: AsyncResult[JAsyncFile] => handler.handle(AsyncResultWrapper[JAsyncFile,AsyncFile](x, a => AsyncFile(a)))})
    this
  }

  /**
    * Creates an empty file with the specified `path`, asynchronously.
    * @param path path to the file
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def createFile(path: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].createFile(path.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#createFileFuture]]
    */
//java.lang.String
  def createFileBlocking(path: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].createFileBlocking(path.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Creates an empty file with the specified `path` and permissions `perms`, asynchronously.
    * @param path path to the file
    * @param perms the permissions string
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def createFile(path: String,perms: String,handler: Handler[AsyncResult[Unit]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].createFile(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#createFileFuture]]
    */
//java.lang.String
//java.lang.String
  def createFileBlocking(path: String,perms: String):FileSystem = {
    asJava.asInstanceOf[JFileSystem].createFileBlocking(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Determines whether the file as specified by the path `path` exists, asynchronously.
    * @param path path to the file
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Boolean>>
  def exists(path: String,handler: Handler[AsyncResult[Boolean]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].exists(path.asInstanceOf[java.lang.String],{x: AsyncResult[java.lang.Boolean] => handler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a.asInstanceOf[Boolean]))})
    this
  }

  /**
    * Returns properties of the file-system being used by the specified `path`, asynchronously.
    * @param path path to anywhere on the filesystem
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.file.FileSystemProps>>
  def fsProps(path: String,handler: Handler[AsyncResult[FileSystemProps]]):FileSystem = {
    asJava.asInstanceOf[JFileSystem].fsProps(path.asInstanceOf[java.lang.String],{x: AsyncResult[JFileSystemProps] => handler.handle(AsyncResultWrapper[JFileSystemProps,FileSystemProps](x, a => FileSystemProps(a)))})
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#propsFuture]]
    */
  def propsBlocking(path: String):FileProps = {
    FileProps(asJava.asInstanceOf[JFileSystem].propsBlocking(path.asInstanceOf[java.lang.String]))
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#lpropsFuture]]
    */
  def lpropsBlocking(path: String):FileProps = {
    FileProps(asJava.asInstanceOf[JFileSystem].lpropsBlocking(path.asInstanceOf[java.lang.String]))
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#readSymlinkFuture]]
    */
  def readSymlinkBlocking(link: String):String = {
    asJava.asInstanceOf[JFileSystem].readSymlinkBlocking(link.asInstanceOf[java.lang.String]).asInstanceOf[String]
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#readDirFuture]]
    */
  def readDirBlocking(path: String):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JFileSystem].readDirBlocking(path.asInstanceOf[java.lang.String]).asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#readDirFuture]]
    */
  def readDirBlocking(path: String,filter: String):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JFileSystem].readDirBlocking(path.asInstanceOf[java.lang.String],filter.asInstanceOf[java.lang.String]).asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#readFileFuture]]
    */
  def readFileBlocking(path: String):io.vertx.core.buffer.Buffer = {
    asJava.asInstanceOf[JFileSystem].readFileBlocking(path.asInstanceOf[java.lang.String])
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#openFuture]]
    */
  def openBlocking(path: String,options: OpenOptions):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JFileSystem].openBlocking(path.asInstanceOf[java.lang.String],options.asJava))
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#existsFuture]]
    */
  def existsBlocking(path: String):Boolean = {
    asJava.asInstanceOf[JFileSystem].existsBlocking(path.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#fsPropsFuture]]
    */
  def fsPropsBlocking(path: String):FileSystemProps = {
    FileSystemProps(asJava.asInstanceOf[JFileSystem].fsPropsBlocking(path.asInstanceOf[java.lang.String]))
  }

 /**
   * Copy a file from the path `from` to path `to`, asynchronously.
   * 
   * The copy will fail if the destination already exists.
   * @param from the path to copy from
   * @param to the path to copy to
   * @return the future that will be called on completion
   */
    def copyFuture(from: String,to: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].copy(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Copy a file from the path `from` to path `to`, asynchronously.
   * 
   * If `recursive` is `true` and `from` represents a directory, then the directory and its contents
   * will be copied recursively to the destination `to`.
   * 
   * The copy will fail if the destination if the destination already exists.
   * @param from the path to copy from
   * @param to the path to copy to
   * @return the future that will be called on completion
   */
    def copyRecursiveFuture(from: String,to: String,recursive: Boolean):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].copyRecursive(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],recursive.asInstanceOf[java.lang.Boolean],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Move a file from the path `from` to path `to`, asynchronously.
   * 
   * The move will fail if the destination already exists.
   * @param from the path to copy from
   * @param to the path to copy to
   * @return the future that will be called on completion
   */
    def moveFuture(from: String,to: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].move(from.asInstanceOf[java.lang.String],to.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Truncate the file represented by `path` to length `len` in bytes, asynchronously.
   * 
   * The operation will fail if the file does not exist or `len` is less than `zero`.
   * @param path the path to the file
   * @param len the length to truncate it to
   * @return the future that will be called on completion
   */
    def truncateFuture(path: String,len: Long):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].truncate(path.asInstanceOf[java.lang.String],len.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Change the permissions on the file represented by `path` to `perms`, asynchronously.
   * 
   * The permission String takes the form rwxr-x--- as
   * specified <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
   * @param path the path to the file
   * @param perms the permissions string
   * @return the future that will be called on completion
   */
    def chmodFuture(path: String,perms: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].chmod(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Change the permissions on the file represented by `path` to `perms`, asynchronously.
   * The permission String takes the form rwxr-x--- as
   * specified in {<a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>`.
   * 
   * If the file is directory then all contents will also have their permissions changed recursively. Any directory permissions will
   * be set to `dirPerms`, whilst any normal file permissions will be set to `perms`.
   * @param path the path to the file
   * @param perms the permissions string
   * @param dirPerms the directory permissions
   * @return the future that will be called on completion
   */
    def chmodRecursiveFuture(path: String,perms: String,dirPerms: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].chmodRecursive(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],dirPerms.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Change the ownership on the file represented by `path` to `user` and {code group`, asynchronously.
   * @param path the path to the file
   * @param user the user name, `null` will not change the user name
   * @param group the user group, `null` will not change the user group name
   * @return the future that will be called on completion
   */
    def chownFuture(path: String,user: scala.Option[String],group: scala.Option[String]):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].chown(path.asInstanceOf[java.lang.String],user.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),group.map(x => x.asInstanceOf[java.lang.String]).getOrElse(null),promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Obtain properties for the file represented by `path`, asynchronously.
   * 
   * If the file is a link, the link will be followed.
   * @param path the path to the file
   * @return the future that will be called on completion
   */
    def propsFuture(path: String):scala.concurrent.Future[FileProps] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JFileProps, FileProps](x => FileProps(x))
    asJava.asInstanceOf[JFileSystem].props(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Obtain properties for the link represented by `path`, asynchronously.
   * 
   * The link will not be followed.
   * @param path the path to the file
   * @return the future that will be called on completion
   */
    def lpropsFuture(path: String):scala.concurrent.Future[FileProps] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JFileProps, FileProps](x => FileProps(x))
    asJava.asInstanceOf[JFileSystem].lprops(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Create a hard link on the file system from `link` to `existing`, asynchronously.
   * @param link the link
   * @param existing the link destination
   * @return the future that will be called on completion
   */
    def linkFuture(link: String,existing: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].link(link.asInstanceOf[java.lang.String],existing.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Create a symbolic link on the file system from `link` to `existing`, asynchronously.
   * @param link the link
   * @param existing the link destination
   * @return the future that will be called on completion
   */
    def symlinkFuture(link: String,existing: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].symlink(link.asInstanceOf[java.lang.String],existing.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Unlinks the link on the file system represented by the path `link`, asynchronously.
   * @param link the link
   * @return the future that will be called on completion
   */
    def unlinkFuture(link: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].unlink(link.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Returns the path representing the file that the symbolic link specified by `link` points to, asynchronously.
   * @param link the link
   * @return the future that will be called on completion
   */
    def readSymlinkFuture(link: String):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JFileSystem].readSymlink(link.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Deletes the file represented by the specified `path`, asynchronously.
   * @param path path to the file
   * @return the future that will be called on completion
   */
    def deleteFuture(path: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].delete(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Deletes the file represented by the specified `path`, asynchronously.
   * 
   * If the path represents a directory and `recursive = true` then the directory and its contents will be
   * deleted recursively.
   * @param path path to the file
   * @param recursive delete recursively?
   * @return the future that will be called on completion
   */
    def deleteRecursiveFuture(path: String,recursive: Boolean):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].deleteRecursive(path.asInstanceOf[java.lang.String],recursive.asInstanceOf[java.lang.Boolean],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Create the directory represented by `path`, asynchronously.
   * 
   * The operation will fail if the directory already exists.
   * @param path path to the file
   * @return the future that will be called on completion
   */
    def mkdirFuture(path: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].mkdir(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Create the directory represented by `path`, asynchronously.
   * 
   * The new directory will be created with permissions as specified by `perms`.
   * 
   * The permission String takes the form rwxr-x--- as specified
   * in <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
   * 
   * The operation will fail if the directory already exists.
   * @param path path to the file
   * @param perms the permissions string
   * @return the future that will be called on completion
   */
    def mkdirFuture(path: String,perms: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].mkdir(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Create the directory represented by `path` and any non existent parents, asynchronously.
   * 
   * The operation will fail if the directory already exists.
   * @param path path to the file
   * @return the future that will be called on completion
   */
    def mkdirsFuture(path: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].mkdirs(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Create the directory represented by `path` and any non existent parents, asynchronously.
   * 
   * The new directory will be created with permissions as specified by `perms`.
   * 
   * The permission String takes the form rwxr-x--- as specified
   * in <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
   * 
   * The operation will fail if the directory already exists.
   * @param path path to the file
   * @param perms the permissions string
   * @return the future that will be called on completion
   */
    def mkdirsFuture(path: String,perms: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].mkdirs(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Read the contents of the directory specified by `path`, asynchronously.
   * 
   * The result is an array of String representing the paths of the files inside the directory.
   * @param path path to the file
   * @return the future that will be called on completion
   */
    def readDirFuture(path: String):scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JFileSystem].readDir(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Read the contents of the directory specified by `path`, asynchronously.
   * 
   * The parameter `filter` is a regular expression. If `filter` is specified then only the paths that
   * match  @{filter`will be returned.
   * 
   * The result is an array of String representing the paths of the files inside the directory.
   * @param path path to the directory
   * @param filter the filter expression
   * @return the future that will be called on completion
   */
    def readDirFuture(path: String,filter: String):scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JFileSystem].readDir(path.asInstanceOf[java.lang.String],filter.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Reads the entire file as represented by the path `path` as a , asynchronously.
   * 
   * Do not user this method to read very large files or you risk running out of available RAM.
   * @param path path to the file
   * @return the future that will be called on completion
   */
    def readFileFuture(path: String):scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Buffer, io.vertx.core.buffer.Buffer](x => x)
    asJava.asInstanceOf[JFileSystem].readFile(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Creates the file, and writes the specified `Buffer data` to the file represented by the path `path`,
   * asynchronously.
   * @param path path to the file
   * @return the future that will be called on completion
   */
    def writeFileFuture(path: String,data: io.vertx.core.buffer.Buffer):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].writeFile(path.asInstanceOf[java.lang.String],data,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Open the file represented by `path`, asynchronously.
   * 
   * The file is opened for both reading and writing. If the file does not already exist it will be created.
   * @param path path to the file
   * @param options options describing how the file should be openedsee <a href="../../../../../../../cheatsheet/OpenOptions.html">OpenOptions</a>
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER   */
    def openFuture(path: String,options: OpenOptions):scala.concurrent.Future[AsyncFile] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAsyncFile, AsyncFile](x => AsyncFile(x))
    asJava.asInstanceOf[JFileSystem].open(path.asInstanceOf[java.lang.String],options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Creates an empty file with the specified `path`, asynchronously.
   * @param path path to the file
   * @return the future that will be called on completion
   */
    def createFileFuture(path: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].createFile(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Creates an empty file with the specified `path` and permissions `perms`, asynchronously.
   * @param path path to the file
   * @param perms the permissions string
   * @return the future that will be called on completion
   */
    def createFileFuture(path: String,perms: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JFileSystem].createFile(path.asInstanceOf[java.lang.String],perms.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Determines whether the file as specified by the path `path` exists, asynchronously.
   * @param path path to the file
   * @return the future that will be called on completion
   */
    def existsFuture(path: String):scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JFileSystem].exists(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Returns properties of the file-system being used by the specified `path`, asynchronously.
   * @param path path to anywhere on the filesystem
   * @return the future that will be called on completion
   */
    def fsPropsFuture(path: String):scala.concurrent.Future[FileSystemProps] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JFileSystemProps, FileSystemProps](x => FileSystemProps(x))
    asJava.asInstanceOf[JFileSystem].fsProps(path.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object FileSystem{
  def apply(asJava: JFileSystem) = new FileSystem(asJava)  
}
