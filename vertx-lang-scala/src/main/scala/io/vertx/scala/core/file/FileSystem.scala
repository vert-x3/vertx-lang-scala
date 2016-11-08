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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.file.{FileSystem => JFileSystem}
import io.vertx.core.file.{AsyncFile => JAsyncFile}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.file.{OpenOptions => JOpenOptions}
import io.vertx.scala.core.file.OpenOptions
import io.vertx.core.file.{FileSystemProps => JFileSystemProps}
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
class FileSystem(private val _asJava: JFileSystem) {

  def asJava: JFileSystem = _asJava

  /**
    * Copy a file from the path `from` to path `to`, asynchronously.
    * 
    * The copy will fail if the destination already exists.
    * @param from the path to copy from
    * @param to the path to copy to
    * @return the future that will be called on completion
    */
  def copyFuture(from: String, to: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.copy(from, to, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#copy]]
    */
  def copyBlocking(from: String, to: String): FileSystem = {
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
    * @return the future that will be called on completion
    */
  def copyRecursiveFuture(from: String, to: String, recursive: Boolean): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.copyRecursive(from, to, recursive, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#copyRecursive]]
    */
  def copyRecursiveBlocking(from: String, to: String, recursive: Boolean): FileSystem = {
    _asJava.copyRecursiveBlocking(from, to, recursive)
    this
  }

  /**
    * Move a file from the path `from` to path `to`, asynchronously.
    * 
    * The move will fail if the destination already exists.
    * @param from the path to copy from
    * @param to the path to copy to
    * @return the future that will be called on completion
    */
  def moveFuture(from: String, to: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.move(from, to, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#move]]
    */
  def moveBlocking(from: String, to: String): FileSystem = {
    _asJava.moveBlocking(from, to)
    this
  }

  /**
    * Truncate the file represented by `path` to length `len` in bytes, asynchronously.
    * 
    * The operation will fail if the file does not exist or `len` is less than `zero`.
    * @param path the path to the file
    * @param len the length to truncate it to
    * @return the future that will be called on completion
    */
  def truncateFuture(path: String, len: Long): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.truncate(path, len, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#truncate]]
    */
  def truncateBlocking(path: String, len: Long): FileSystem = {
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
    * @return the future that will be called on completion
    */
  def chmodFuture(path: String, perms: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.chmod(path, perms, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem #chmod(String, String, Handler)]]
    */
  def chmodBlocking(path: String, perms: String): FileSystem = {
    _asJava.chmodBlocking(path, perms)
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
    * @return the future that will be called on completion
    */
  def chmodRecursiveFuture(path: String, perms: String, dirPerms: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.chmodRecursive(path, perms, dirPerms, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#chmodRecursive]]
    */
  def chmodRecursiveBlocking(path: String, perms: String, dirPerms: String): FileSystem = {
    _asJava.chmodRecursiveBlocking(path, perms, dirPerms)
    this
  }

  /**
    * Change the ownership on the file represented by `path` to `user` and {code group`, asynchronously.
    * @param path the path to the file
    * @param user the user name, `null` will not change the user name
    * @param group the user group, `null` will not change the user group name
    * @return the future that will be called on completion
    */
  def chownFuture(path: String, user: scala.Option[String], group: scala.Option[String]): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.chown(path, (if (user.isDefined) user.get else null), (if (group.isDefined) group.get else null), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of 
    *
    */
  def chownBlocking(path: String, user: scala.Option[String], group: scala.Option[String]): FileSystem = {
    _asJava.chownBlocking(path, (if (user.isDefined) user.get else null), (if (group.isDefined) group.get else null))
    this
  }

  /**
    * Obtain properties for the file represented by `path`, asynchronously.
    * 
    * If the file is a link, the link will be followed.
    * @param path the path to the file
    * @return the future that will be called on completion
    */
  def propsFuture(path: String): concurrent.Future[FileProps] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JFileProps,FileProps]((x => if (x == null) null else FileProps.apply(x)))
    _asJava.props(path, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#props]]
    */
  def propsBlocking(path: String): FileProps = {
    FileProps.apply(_asJava.propsBlocking(path))
  }

  /**
    * Obtain properties for the link represented by `path`, asynchronously.
    * 
    * The link will not be followed.
    * @param path the path to the file
    * @return the future that will be called on completion
    */
  def lpropsFuture(path: String): concurrent.Future[FileProps] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JFileProps,FileProps]((x => if (x == null) null else FileProps.apply(x)))
    _asJava.lprops(path, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#lprops]]
    */
  def lpropsBlocking(path: String): FileProps = {
    FileProps.apply(_asJava.lpropsBlocking(path))
  }

  /**
    * Create a hard link on the file system from `link` to `existing`, asynchronously.
    * @param link the link
    * @param existing the link destination
    * @return the future that will be called on completion
    */
  def linkFuture(link: String, existing: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.link(link, existing, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#link]]
    */
  def linkBlocking(link: String, existing: String): FileSystem = {
    _asJava.linkBlocking(link, existing)
    this
  }

  /**
    * Create a symbolic link on the file system from `link` to `existing`, asynchronously.
    * @param link the link
    * @param existing the link destination
    * @return the future that will be called on completion
    */
  def symlinkFuture(link: String, existing: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.symlink(link, existing, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#link]]
    */
  def symlinkBlocking(link: String, existing: String): FileSystem = {
    _asJava.symlinkBlocking(link, existing)
    this
  }

  /**
    * Unlinks the link on the file system represented by the path `link`, asynchronously.
    * @param link the link
    * @return the future that will be called on completion
    */
  def unlinkFuture(link: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.unlink(link, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#unlink]]
    */
  def unlinkBlocking(link: String): FileSystem = {
    _asJava.unlinkBlocking(link)
    this
  }

  /**
    * Returns the path representing the file that the symbolic link specified by `link` points to, asynchronously.
    * @param link the link
    * @return the future that will be called on completion
    */
  def readSymlinkFuture(link: String): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.readSymlink(link, promiseAndHandler._1)
    promiseAndHandler._2.future
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
    * @return the future that will be called on completion
    */
  def deleteFuture(path: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.delete(path, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#delete]]
    */
  def deleteBlocking(path: String): FileSystem = {
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
    * @return the future that will be called on completion
    */
  def deleteRecursiveFuture(path: String, recursive: Boolean): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.deleteRecursive(path, recursive, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#deleteRecursive]]
    */
  def deleteRecursiveBlocking(path: String, recursive: Boolean): FileSystem = {
    _asJava.deleteRecursiveBlocking(path, recursive)
    this
  }

  /**
    * Create the directory represented by `path`, asynchronously.
    * 
    * The operation will fail if the directory already exists.
    * @param path path to the file
    * @return the future that will be called on completion
    */
  def mkdirFuture(path: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.mkdir(path, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#mkdir]]
    */
  def mkdirBlocking(path: String): FileSystem = {
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
    * @return the future that will be called on completion
    */
  def mkdirFuture(path: String, perms: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.mkdir(path, perms, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#mkdir]]
    */
  def mkdirBlocking(path: String, perms: String): FileSystem = {
    _asJava.mkdirBlocking(path, perms)
    this
  }

  /**
    * Create the directory represented by `path` and any non existent parents, asynchronously.
    * 
    * The operation will fail if the directory already exists.
    * @param path path to the file
    * @return the future that will be called on completion
    */
  def mkdirsFuture(path: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.mkdirs(path, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#mkdirs]]
    */
  def mkdirsBlocking(path: String): FileSystem = {
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
    * @return the future that will be called on completion
    */
  def mkdirsFuture(path: String, perms: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.mkdirs(path, perms, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#mkdirs]]
    */
  def mkdirsBlocking(path: String, perms: String): FileSystem = {
    _asJava.mkdirsBlocking(path, perms)
    this
  }

  /**
    * Read the contents of the directory specified by `path`, asynchronously.
    * 
    * The result is an array of String representing the paths of the files inside the directory.
    * @param path path to the file
    * @return the future that will be called on completion
    */
  def readDirFuture(path: String): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asScala))
    _asJava.readDir(path, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#readDir]]
    */
  def readDirBlocking(path: String): scala.collection.mutable.Buffer[String] = {
    _asJava.readDirBlocking(path).asScala.map(x => x:String)
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
  def readDirFuture(path: String, filter: String): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asScala))
    _asJava.readDir(path, filter, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#readDir]]
    */
  def readDirBlocking(path: String, filter: String): scala.collection.mutable.Buffer[String] = {
    _asJava.readDirBlocking(path, filter).asScala.map(x => x:String)
  }

  /**
    * Reads the entire file as represented by the path `path` as a , asynchronously.
    * 
    * Do not user this method to read very large files or you risk running out of available RAM.
    * @param path path to the file
    * @return the future that will be called on completion
    */
  def readFileFuture(path: String): concurrent.Future[Buffer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JBuffer,Buffer]((x => if (x == null) null else Buffer.apply(x)))
    _asJava.readFile(path, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#readFile]]
    */
  def readFileBlocking(path: String): Buffer = {
    Buffer.apply(_asJava.readFileBlocking(path))
  }

  /**
    * Creates the file, and writes the specified `Buffer data` to the file represented by the path `path`,
    * asynchronously.
    * @param path path to the file
    * @return the future that will be called on completion
    */
  def writeFileFuture(path: String, data: Buffer): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.writeFile(path, data.asJava.asInstanceOf[JBuffer], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#writeFile]]
    */
  def writeFileBlocking(path: String, data: Buffer): FileSystem = {
    _asJava.writeFileBlocking(path, data.asJava.asInstanceOf[JBuffer])
    this
  }

  /**
    * Open the file represented by `path`, asynchronously.
    * 
    * The file is opened for both reading and writing. If the file does not already exist it will be created.
    * @param path path to the file
    * @param options options describing how the file should be openedsee <a href="../../../../../../../cheatsheet/OpenOptions.html">OpenOptions</a>
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def openFuture(path: String, options: OpenOptions): concurrent.Future[AsyncFile] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAsyncFile,AsyncFile]((x => if (x == null) null else AsyncFile.apply(x)))
    _asJava.open(path, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#open]]
    */
  def openBlocking(path: String, options: OpenOptions): AsyncFile = {
    AsyncFile.apply(_asJava.openBlocking(path, options.asJava))
  }

  /**
    * Creates an empty file with the specified `path`, asynchronously.
    * @param path path to the file
    * @return the future that will be called on completion
    */
  def createFileFuture(path: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.createFile(path, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#createFile]]
    */
  def createFileBlocking(path: String): FileSystem = {
    _asJava.createFileBlocking(path)
    this
  }

  /**
    * Creates an empty file with the specified `path` and permissions `perms`, asynchronously.
    * @param path path to the file
    * @param perms the permissions string
    * @return the future that will be called on completion
    */
  def createFileFuture(path: String, perms: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.createFile(path, perms, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#createFile]]
    */
  def createFileBlocking(path: String, perms: String): FileSystem = {
    _asJava.createFileBlocking(path, perms)
    this
  }

  /**
    * Determines whether the file as specified by the path `path` exists, asynchronously.
    * @param path path to the file
    * @return the future that will be called on completion
    */
  def existsFuture(path: String): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean,Boolean]((x => x))
    _asJava.exists(path, promiseAndHandler._1)
    promiseAndHandler._2.future
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
    * @return the future that will be called on completion
    */
  def fsPropsFuture(path: String): concurrent.Future[FileSystemProps] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JFileSystemProps,FileSystemProps]((x => if (x == null) null else FileSystemProps.apply(x)))
    _asJava.fsProps(path, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Blocking version of [[io.vertx.scala.core.file.FileSystem#fsProps]]
    */
  def fsPropsBlocking(path: String): FileSystemProps = {
    FileSystemProps.apply(_asJava.fsPropsBlocking(path))
  }

}

object FileSystem {

  def apply(_asJava: JFileSystem): FileSystem =
    new FileSystem(_asJava)

}
