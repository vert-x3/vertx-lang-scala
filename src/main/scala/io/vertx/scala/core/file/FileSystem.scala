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

import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.file.OpenOptions
import scala.util.Try
import io.vertx.core.Handler

class FileSystem(private val _asJava: io.vertx.core.file.FileSystem) {

  def asJava: java.lang.Object = _asJava

  def copy(from: String, to: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.copy(from, to, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def copyBlocking(from: String, to: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.copyBlocking(from, to)
    this
  }

  def copyRecursive(from: String, to: String, recursive: Boolean)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.copyRecursive(from, to, recursive, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def copyRecursiveBlocking(from: String, to: String, recursive: Boolean): io.vertx.scala.core.file.FileSystem = {
    _asJava.copyRecursiveBlocking(from, to, recursive)
    this
  }

  def move(from: String, to: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.move(from, to, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def moveBlocking(from: String, to: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.moveBlocking(from, to)
    this
  }

  def truncate(path: String, len: Long)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.truncate(path, len, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def truncateBlocking(path: String, len: Long): io.vertx.scala.core.file.FileSystem = {
    _asJava.truncateBlocking(path, len)
    this
  }

  def chmod(path: String, perms: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.chmod(path, perms, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def chmodBlocking(path: String, perms: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.chmodBlocking(path, perms)
    this
  }

  def chmodRecursive(path: String, perms: String, dirPerms: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.chmodRecursive(path, perms, dirPerms, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def chmodRecursiveBlocking(path: String, perms: String, dirPerms: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.chmodRecursiveBlocking(path, perms, dirPerms)
    this
  }

  def chown(path: String, user: String, group: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.chown(path, user, group, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def chownBlocking(path: String, user: String, group: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.chownBlocking(path, user, group)
    this
  }

  def props(path: String)(handler: Try[io.vertx.scala.core.file.FileProps] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.props(path, funcToMappedAsyncResultHandler(FileProps.apply)(handler))
    this
  }

  def propsBlocking(path: String): io.vertx.scala.core.file.FileProps = {
    FileProps.apply(_asJava.propsBlocking(path))
  }

  def lprops(path: String)(handler: Try[io.vertx.scala.core.file.FileProps] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.lprops(path, funcToMappedAsyncResultHandler(FileProps.apply)(handler))
    this
  }

  def lpropsBlocking(path: String): io.vertx.scala.core.file.FileProps = {
    FileProps.apply(_asJava.lpropsBlocking(path))
  }

  def link(link: String, existing: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.link(link, existing, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def linkBlocking(link: String, existing: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.linkBlocking(link, existing)
    this
  }

  def symlink(link: String, existing: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.symlink(link, existing, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def symlinkBlocking(link: String, existing: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.symlinkBlocking(link, existing)
    this
  }

  def unlink(link: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.unlink(link, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def unlinkBlocking(link: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.unlinkBlocking(link)
    this
  }

  def readSymlink(link: String)(handler: Try[String] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.readSymlink(link, funcToAsyncResultHandler[java.lang.String](handler))
    this
  }

  def readSymlinkBlocking(link: String): String = {
    _asJava.readSymlinkBlocking(link)
  }

  def delete(path: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.delete(path, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def deleteBlocking(path: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.deleteBlocking(path)
    this
  }

  def deleteRecursive(path: String, recursive: Boolean)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.deleteRecursive(path, recursive, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def deleteRecursiveBlocking(path: String, recursive: Boolean): io.vertx.scala.core.file.FileSystem = {
    _asJava.deleteRecursiveBlocking(path, recursive)
    this
  }

  def mkdir(path: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.mkdir(path, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def mkdirBlocking(path: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.mkdirBlocking(path)
    this
  }

  def mkdir(path: String, perms: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.mkdir(path, perms, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def mkdirBlocking(path: String, perms: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.mkdirBlocking(path, perms)
    this
  }

  def mkdirs(path: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.mkdirs(path, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def mkdirsBlocking(path: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.mkdirsBlocking(path)
    this
  }

  def mkdirs(path: String, perms: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.mkdirs(path, perms, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def mkdirsBlocking(path: String, perms: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.mkdirsBlocking(path, perms)
    this
  }

  def readDir(path: String)(handler: Try[List[String]] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.readDir(path, funcToMappedAsyncResultHandler[java.util.List[java.lang.String], List[String]](x => x.asScala.toList)(handler))
    this
  }

  def readDirBlocking(path: String): List[String] = {
    import scala.collection.JavaConverters._
    _asJava.readDirBlocking(path).asScala.map(x => x:String).toList
  }

  def readDir(path: String, filter: String)(handler: Try[List[String]] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.readDir(path, filter, funcToMappedAsyncResultHandler[java.util.List[java.lang.String], List[String]](x => x.asScala.toList)(handler))
    this
  }

  def readDirBlocking(path: String, filter: String): List[String] = {
    import scala.collection.JavaConverters._
    _asJava.readDirBlocking(path, filter).asScala.map(x => x:String).toList
  }

  def readFile(path: String)(handler: Try[io.vertx.scala.core.buffer.Buffer] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.readFile(path, funcToMappedAsyncResultHandler(Buffer.apply)(handler))
    this
  }

  def readFileBlocking(path: String): io.vertx.scala.core.buffer.Buffer = {
    Buffer.apply(_asJava.readFileBlocking(path))
  }

  def writeFile(path: String, data: io.vertx.scala.core.buffer.Buffer)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.writeFile(path, data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def writeFileBlocking(path: String, data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.file.FileSystem = {
    _asJava.writeFileBlocking(path, data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def open(path: String, options: io.vertx.core.file.OpenOptions)(handler: Try[io.vertx.scala.core.file.AsyncFile] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.open(path, options, funcToMappedAsyncResultHandler(AsyncFile.apply)(handler))
    this
  }

  def openBlocking(path: String, options: io.vertx.core.file.OpenOptions): io.vertx.scala.core.file.AsyncFile = {
    AsyncFile.apply(_asJava.openBlocking(path, options))
  }

  def createFile(path: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.createFile(path, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def createFileBlocking(path: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.createFileBlocking(path)
    this
  }

  def createFile(path: String, perms: String)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.createFile(path, perms, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def createFileBlocking(path: String, perms: String): io.vertx.scala.core.file.FileSystem = {
    _asJava.createFileBlocking(path, perms)
    this
  }

  def exists(path: String)(handler: Try[Boolean] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.exists(path, funcToMappedAsyncResultHandler[java.lang.Boolean, Boolean](x => x)(handler))
    this
  }

  def existsBlocking(path: String): Boolean = {
    _asJava.existsBlocking(path)
  }

  def fsProps(path: String)(handler: Try[io.vertx.scala.core.file.FileSystemProps] => Unit): io.vertx.scala.core.file.FileSystem = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.fsProps(path, funcToMappedAsyncResultHandler(FileSystemProps.apply)(handler))
    this
  }

  def fsPropsBlocking(path: String): io.vertx.scala.core.file.FileSystemProps = {
    FileSystemProps.apply(_asJava.fsPropsBlocking(path))
  }

}

object FileSystem {

  def apply(_asJava: io.vertx.core.file.FileSystem): io.vertx.scala.core.file.FileSystem =
    new io.vertx.scala.core.file.FileSystem(_asJava)
}
