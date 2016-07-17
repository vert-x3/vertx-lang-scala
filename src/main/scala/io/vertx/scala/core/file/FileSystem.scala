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

package io.vertx.scala.core.file;

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.file.OpenOptions
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
class FileSystem(private val _asJava: io.vertx.core.file.FileSystem) {

  def asJava: io.vertx.core.file.FileSystem = _asJava

  /**
    * Copy a file from the path `from` to path `to`, asynchronously.
    * 
    * The copy will fail if the destination already exists.
    * @param from the path to copy from
    * @param to the path to copy to
    * @return the handler that will be called on completion
    */
  def copy(from: String, to: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.copy(from, to, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#copy]]
    */
  def copyBlocking(from: String, to: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.copyBlocking(from, to)
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
    * @return the handler that will be called on completion
    */
  def copyRecursive(from: String, to: String, recursive: Boolean, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.copyRecursive(from, to, recursive, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#copyRecursive]]
    */
  def copyRecursiveBlocking(from: String, to: String, recursive: Boolean): io.vertx.scala.core.file.FileSystem = {
    _asJava.copyRecursiveBlocking(from, to, recursive)
    this
  }

  /**
    * Move a file from the path `from` to path `to`, asynchronously.
    * 
    * The move will fail if the destination already exists.
    * @param from the path to copy from
    * @param to the path to copy to
    * @return the handler that will be called on completion
    */
  def move(from: String, to: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.move(from, to, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#move]]
    */
  def moveBlocking(from: String, to: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.moveBlocking(from, to)
    this
  }

  /**
    * Truncate the file represented by `path` to length `len` in bytes, asynchronously.
    * 
    * The operation will fail if the file does not exist or `len` is less than `zero`.
    * @param path the path to the file
    * @param len the length to truncate it to
    * @return the handler that will be called on completion
    */
  def truncate(path: String, len: Long, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.truncate(path, len, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#truncate]]
    */
  def truncateBlocking(path: String, len: Long): io.vertx.scala.core.file.FileSystem = {
    _asJava.truncateBlocking(path, len)
    this
  }

  /**
    * Change the permissions on the file represented by `path` to `perms`, asynchronously.
    * 
    * The permission String takes the form rwxr-x--- as
    * specified <a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>.
    * @param path the path to the file
    * @param perms the permissions string
    * @return the handler that will be called on completion
    */
  def chmod(path: String, perms: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.chmod(path, perms, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem #chmod(String, String, Handler)]]
    */
  def chmodBlocking(path: String, perms: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.chmodBlocking(path, perms)
    this
  }

  /**
    * Change the permissions on the file represented by `path` to `perms`, asynchronously.
    * The permission String takes the form rwxr-x--- as
    * specified in {<a href="http://download.oracle.com/javase/7/docs/api/java/nio/file/attribute/PosixFilePermissions.html">here</a>}.
    * 
    * If the file is directory then all contents will also have their permissions changed recursively. Any directory permissions will
    * be set to `dirPerms`, whilst any normal file permissions will be set to `perms`.
    * @param path the path to the file
    * @param perms the permissions string
    * @param dirPerms the directory permissions
    * @return the handler that will be called on completion
    */
  def chmodRecursive(path: String, perms: String, dirPerms: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.chmodRecursive(path, perms, dirPerms, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#chmodRecursive]]
    */
  def chmodRecursiveBlocking(path: String, perms: String, dirPerms: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.chmodRecursiveBlocking(path, perms, dirPerms)
    this
  }

  /**
    * Change the ownership on the file represented by `path` to `user` and {code group}, asynchronously.
    * @param path the path to the file
    * @param user the user name, {@code null} will not change the user name
    * @param group the user group, {@code null} will not change the user group name
    * @return the handler that will be called on completion
    */
  def chown(path: String, user: Option[String], group: Option[String], handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.chown(path, user.get, group.get, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of 
    *
    */
  def chownBlocking(path: String, user: Option[String], group: Option[String]): io.vertx.scala.core.file.FileSystem = {
    _asJava.chownBlocking(path, user.get, group.get)
    this
  }

  /**
    * Obtain properties for the file represented by `path`, asynchronously.
    * 
    * If the file is a link, the link will be followed.
    * @param path the path to the file
    * @return the handler that will be called on completion
    */
  def props(path: String, handler: io.vertx.core.AsyncResult[io.vertx.core.file.FileProps] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.props(path, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#props]]
    */
  def propsBlocking(path: String): io.vertx.scala.core.file.FileProps = {
    FileProps.apply(_asJava.propsBlocking(path))
  }

  /**
    * Obtain properties for the link represented by `path`, asynchronously.
    * 
    * The link will not be followed.
    * @param path the path to the file
    * @return the handler that will be called on completion
    */
  def lprops(path: String, handler: io.vertx.core.AsyncResult[io.vertx.core.file.FileProps] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.lprops(path, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#lprops]]
    */
  def lpropsBlocking(path: String): io.vertx.scala.core.file.FileProps = {
    FileProps.apply(_asJava.lpropsBlocking(path))
  }

  /**
    * Create a hard link on the file system from `link` to `existing`, asynchronously.
    * @param link the link
    * @param existing the link destination
    * @return the handler that will be called on completion
    */
  def link(link: String, existing: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.link(link, existing, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#link]]
    */
  def linkBlocking(link: String, existing: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.linkBlocking(link, existing)
    this
  }

  /**
    * Create a symbolic link on the file system from `link` to `existing`, asynchronously.
    * @param link the link
    * @param existing the link destination
    * @return the handler that will be called on completion
    */
  def symlink(link: String, existing: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.symlink(link, existing, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#link]]
    */
  def symlinkBlocking(link: String, existing: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.symlinkBlocking(link, existing)
    this
  }

  /**
    * Unlinks the link on the file system represented by the path `link`, asynchronously.
    * @param link the link
    * @return the handler that will be called on completion
    */
  def unlink(link: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.unlink(link, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#unlink]]
    */
  def unlinkBlocking(link: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.unlinkBlocking(link)
    this
  }

  /**
    * Returns the path representing the file that the symbolic link specified by `link` points to, asynchronously.
    * @param link the link
    * @return the handler that will be called on completion
    */
  def readSymlink(link: String, handler: io.vertx.core.AsyncResult[java.lang.String] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.readSymlink(link, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#readSymlink]]
    */
  def readSymlinkBlocking(link: String): String = {
    _asJava.readSymlinkBlocking(link)
  }

  /**
    * Deletes the file represented by the specified `path`, asynchronously.
    * @param path path to the file
    * @return the handler that will be called on completion
    */
  def delete(path: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.delete(path, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#delete]]
    */
  def deleteBlocking(path: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.deleteBlocking(path)
    this
  }

  /**
    * Deletes the file represented by the specified `path`, asynchronously.
    * 
    * If the path represents a directory and `recursive = true` then the directory and its contents will be
    * deleted recursively.
    * @param path path to the file
    * @param recursive delete recursively?
    * @return the handler that will be called on completion
    */
  def deleteRecursive(path: String, recursive: Boolean, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.deleteRecursive(path, recursive, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#deleteRecursive]]
    */
  def deleteRecursiveBlocking(path: String, recursive: Boolean): io.vertx.scala.core.file.FileSystem = {
    _asJava.deleteRecursiveBlocking(path, recursive)
    this
  }

  /**
    * Create the directory represented by `path`, asynchronously.
    * 
    * The operation will fail if the directory already exists.
    * @param path path to the file
    * @return the handler that will be called on completion
    */
  def mkdir(path: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.mkdir(path, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#mkdir]]
    */
  def mkdirBlocking(path: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.mkdirBlocking(path)
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
    * @return the handler that will be called on completion
    */
  def mkdir(path: String, perms: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.mkdir(path, perms, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#mkdir]]
    */
  def mkdirBlocking(path: String, perms: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.mkdirBlocking(path, perms)
    this
  }

  /**
    * Create the directory represented by `path` and any non existent parents, asynchronously.
    * 
    * The operation will fail if the directory already exists.
    * @param path path to the file
    * @return the handler that will be called on completion
    */
  def mkdirs(path: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.mkdirs(path, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#mkdirs]]
    */
  def mkdirsBlocking(path: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.mkdirsBlocking(path)
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
    * @return the handler that will be called on completion
    */
  def mkdirs(path: String, perms: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.mkdirs(path, perms, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#mkdirs]]
    */
  def mkdirsBlocking(path: String, perms: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.mkdirsBlocking(path, perms)
    this
  }

  /**
    * Read the contents of the directory specified by `path`, asynchronously.
    * 
    * The result is an array of String representing the paths of the files inside the directory.
    * @param path path to the file
    * @return the handler that will be called on completion
    */
  def readDir(path: String, handler: io.vertx.core.AsyncResult[java.util.List[java.lang.String]] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.readDir(path, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#readDir]]
    */
  def readDirBlocking(path: String): List[String] = {
    _asJava.readDirBlocking(path).asScala.map(x => x:String).toList
  }

  /**
    * Read the contents of the directory specified by `path`, asynchronously.
    * 
    * The parameter `filter` is a regular expression. If `filter` is specified then only the paths that
    * match  @{filter}will be returned.
    * 
    * The result is an array of String representing the paths of the files inside the directory.
    * @param path path to the directory
    * @param filter the filter expression
    * @return the handler that will be called on completion
    */
  def readDir(path: String, filter: String, handler: io.vertx.core.AsyncResult[java.util.List[java.lang.String]] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.readDir(path, filter, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#readDir]]
    */
  def readDirBlocking(path: String, filter: String): List[String] = {
    _asJava.readDirBlocking(path, filter).asScala.map(x => x:String).toList
  }

  /**
    * Reads the entire file as represented by the path `path` as a , asynchronously.
    * 
    * Do not user this method to read very large files or you risk running out of available RAM.
    * @param path path to the file
    * @return the handler that will be called on completion
    */
  def readFile(path: String, handler: io.vertx.core.AsyncResult[io.vertx.core.buffer.Buffer] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.readFile(path, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#readFile]]
    */
  def readFileBlocking(path: String): io.vertx.scala.core.buffer.Buffer = {
    Buffer.apply(_asJava.readFileBlocking(path))
  }

  /**
    * Creates the file, and writes the specified `Buffer data` to the file represented by the path `path`,
    * asynchronously.
    * @param path path to the file
    * @return the handler that will be called on completion
    */
  def writeFile(path: String, data: io.vertx.scala.core.buffer.Buffer, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.writeFile(path, data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#writeFile]]
    */
  def writeFileBlocking(path: String, data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.file.FileSystem = {
    _asJava.writeFileBlocking(path, data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  /**
    * Open the file represented by `path`, asynchronously.
    * 
    * The file is opened for both reading and writing. If the file does not already exist it will be created.
    * @param path path to the file
    * @param options options describing how the file should be openedsee <a href="../../../../../../../cheatsheet/OpenOptions.html">OpenOptions</a>
    */
  def open(path: String, options: io.vertx.core.file.OpenOptions, handler: io.vertx.core.AsyncResult[io.vertx.core.file.AsyncFile] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.open(path, options, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#open]]
    */
  def openBlocking(path: String, options: io.vertx.core.file.OpenOptions): io.vertx.scala.core.file.AsyncFile = {
    AsyncFile.apply(_asJava.openBlocking(path, options))
  }

  /**
    * Creates an empty file with the specified `path`, asynchronously.
    * @param path path to the file
    * @return the handler that will be called on completion
    */
  def createFile(path: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.createFile(path, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#createFile]]
    */
  def createFileBlocking(path: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.createFileBlocking(path)
    this
  }

  /**
    * Creates an empty file with the specified `path` and permissions `perms`, asynchronously.
    * @param path path to the file
    * @param perms the permissions string
    * @return the handler that will be called on completion
    */
  def createFile(path: String, perms: String, handler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.createFile(path, perms, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#createFile]]
    */
  def createFileBlocking(path: String, perms: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.createFileBlocking(path, perms)
    this
  }

  /**
    * Determines whether the file as specified by the path `path` exists, asynchronously.
    * @param path path to the file
    * @return the handler that will be called on completion
    */
  def exists(path: String, handler: io.vertx.core.AsyncResult[java.lang.Boolean] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.exists(path, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#exists]]
    */
  def existsBlocking(path: String): Boolean = {
    _asJava.existsBlocking(path)
  }

  /**
    * Returns properties of the file-system being used by the specified `path`, asynchronously.
    * @param path path to anywhere on the filesystem
    * @return the handler that will be called on completion
    */
  def fsProps(path: String, handler: io.vertx.core.AsyncResult[io.vertx.core.file.FileSystemProps] => Unit): io.vertx.scala.core.file.FileSystem = {
    _asJava.fsProps(path, funcToHandler(handler))
    this
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#fsProps]]
    */
  def fsPropsBlocking(path: String): io.vertx.scala.core.file.FileSystemProps = {
    FileSystemProps.apply(_asJava.fsPropsBlocking(path))
  }

}

object FileSystem {

  def apply(_asJava: io.vertx.core.file.FileSystem): io.vertx.scala.core.file.FileSystem =
    new io.vertx.scala.core.file.FileSystem(_asJava)
}
