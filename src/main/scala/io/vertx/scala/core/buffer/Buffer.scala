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

package io.vertx.scala.core.buffer;

import io.vertx.core.shareddata.impl.ClusterSerializable

class Buffer(private val _asJava: io.vertx.core.buffer.Buffer) {

  def asJava: java.lang.Object = _asJava

  def toString(enc: String): String = {
    _asJava.toString(enc)
  }

  def getByte(pos: Int): Byte = {
    _asJava.getByte(pos)
  }

  def getInt(pos: Int): Int = {
    _asJava.getInt(pos)
  }

  def getLong(pos: Int): Long = {
    _asJava.getLong(pos)
  }

  def getDouble(pos: Int): Double = {
    _asJava.getDouble(pos)
  }

  def getFloat(pos: Int): Float = {
    _asJava.getFloat(pos)
  }

  def getShort(pos: Int): Short = {
    _asJava.getShort(pos)
  }

  def getBuffer(start: Int, end: Int): io.vertx.scala.core.buffer.Buffer = {
    Buffer.apply(_asJava.getBuffer(start, end))
  }

  def getString(start: Int, end: Int, enc: String): String = {
    _asJava.getString(start, end, enc)
  }

  def getString(start: Int, end: Int): String = {
    _asJava.getString(start, end)
  }

  def appendBuffer(buff: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.buffer.Buffer = {
    _asJava.appendBuffer(buff.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def appendBuffer(buff: io.vertx.scala.core.buffer.Buffer, offset: Int, len: Int): io.vertx.scala.core.buffer.Buffer = {
    _asJava.appendBuffer(buff.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], offset, len)
    this
  }

  def appendByte(b: Byte): io.vertx.scala.core.buffer.Buffer = {
    _asJava.appendByte(b)
    this
  }

  def appendInt(i: Int): io.vertx.scala.core.buffer.Buffer = {
    _asJava.appendInt(i)
    this
  }

  def appendLong(l: Long): io.vertx.scala.core.buffer.Buffer = {
    _asJava.appendLong(l)
    this
  }

  def appendShort(s: Short): io.vertx.scala.core.buffer.Buffer = {
    _asJava.appendShort(s)
    this
  }

  def appendFloat(f: Float): io.vertx.scala.core.buffer.Buffer = {
    _asJava.appendFloat(f)
    this
  }

  def appendDouble(d: Double): io.vertx.scala.core.buffer.Buffer = {
    _asJava.appendDouble(d)
    this
  }

  def appendString(str: String, enc: String): io.vertx.scala.core.buffer.Buffer = {
    _asJava.appendString(str, enc)
    this
  }

  def appendString(str: String): io.vertx.scala.core.buffer.Buffer = {
    _asJava.appendString(str)
    this
  }

  def setByte(pos: Int, b: Byte): io.vertx.scala.core.buffer.Buffer = {
    _asJava.setByte(pos, b)
    this
  }

  def setInt(pos: Int, i: Int): io.vertx.scala.core.buffer.Buffer = {
    _asJava.setInt(pos, i)
    this
  }

  def setLong(pos: Int, l: Long): io.vertx.scala.core.buffer.Buffer = {
    _asJava.setLong(pos, l)
    this
  }

  def setDouble(pos: Int, d: Double): io.vertx.scala.core.buffer.Buffer = {
    _asJava.setDouble(pos, d)
    this
  }

  def setFloat(pos: Int, f: Float): io.vertx.scala.core.buffer.Buffer = {
    _asJava.setFloat(pos, f)
    this
  }

  def setShort(pos: Int, s: Short): io.vertx.scala.core.buffer.Buffer = {
    _asJava.setShort(pos, s)
    this
  }

  def setBuffer(pos: Int, b: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.buffer.Buffer = {
    _asJava.setBuffer(pos, b.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def setBuffer(pos: Int, b: io.vertx.scala.core.buffer.Buffer, offset: Int, len: Int): io.vertx.scala.core.buffer.Buffer = {
    _asJava.setBuffer(pos, b.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], offset, len)
    this
  }

  def setString(pos: Int, str: String): io.vertx.scala.core.buffer.Buffer = {
    _asJava.setString(pos, str)
    this
  }

  def setString(pos: Int, str: String, enc: String): io.vertx.scala.core.buffer.Buffer = {
    _asJava.setString(pos, str, enc)
    this
  }

  def length(): Int = {
    _asJava.length()
  }

  def copy(): io.vertx.scala.core.buffer.Buffer = {
    Buffer.apply(_asJava.copy())
  }

  def slice(): io.vertx.scala.core.buffer.Buffer = {
    Buffer.apply(_asJava.slice())
  }

  def slice(start: Int, end: Int): io.vertx.scala.core.buffer.Buffer = {
    Buffer.apply(_asJava.slice(start, end))
  }

}

object Buffer {

  def apply(_asJava: io.vertx.core.buffer.Buffer): io.vertx.scala.core.buffer.Buffer =
    new io.vertx.scala.core.buffer.Buffer(_asJava)
  
    def buffer(): io.vertx.scala.core.buffer.Buffer = {
      Buffer.apply(io.vertx.core.buffer.Buffer.buffer())
    }
  
    def buffer(initialSizeHint: Int): io.vertx.scala.core.buffer.Buffer = {
      Buffer.apply(io.vertx.core.buffer.Buffer.buffer(initialSizeHint))
    }
  
    def buffer(string: String): io.vertx.scala.core.buffer.Buffer = {
      Buffer.apply(io.vertx.core.buffer.Buffer.buffer(string))
    }
  
    def buffer(string: String, enc: String): io.vertx.scala.core.buffer.Buffer = {
      Buffer.apply(io.vertx.core.buffer.Buffer.buffer(string, enc))
    }
}
