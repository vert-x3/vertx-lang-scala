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

package io.vertx.scala.core.buffer

import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.json.JsonArray
import io.vertx.core.json.JsonObject

/**
  * Most data is shuffled around inside Vert.x using buffers.
  * 
  * A buffer is a sequence of zero or more bytes that can read from or written to and which expands automatically as
  * necessary to accommodate any bytes written to it. You can perhaps think of a buffer as smart byte array.
  * 
  * Please consult the documentation for more information on buffers.
  */
class Buffer(private val _asJava: JBuffer) {

  def asJava: JBuffer = _asJava

  /**
    * Returns a `String` representation of the Buffer with the `UTF-8`encoding
    */
  override def toString(): String = {
    asJava.toString()
  }

  /**
    * Returns a `String` representation of the Buffer with the encoding specified by `enc`
    */
  def toString(enc: String): String = {
    asJava.toString(enc)
  }

  /**
    * Returns a Json object representation of the Buffer
    */
  def toJsonObject(): JsonObject = {
    asJava.toJsonObject()
  }

  /**
    * Returns a Json array representation of the Buffer
    */
  def toJsonArray(): JsonArray = {
    asJava.toJsonArray()
  }

  /**
    * Returns the `byte` at position `pos` in the Buffer.
    */
  def getByte(pos: Int): Byte = {
    asJava.getByte(pos)
  }

  /**
    * Returns the unsigned `byte` at position `pos` in the Buffer, as a `short`.
    */
  def getUnsignedByte(pos: Int): Short = {
    asJava.getUnsignedByte(pos)
  }

  /**
    * Returns the `int` at position `pos` in the Buffer.
    */
  def getInt(pos: Int): Int = {
    asJava.getInt(pos)
  }

  /**
    * Gets a 32-bit integer at the specified absolute `index` in this buffer with Little Endian Byte Order.
    */
  def getIntLE(pos: Int): Int = {
    asJava.getIntLE(pos)
  }

  /**
    * Returns the unsigned `int` at position `pos` in the Buffer, as a `long`.
    */
  def getUnsignedInt(pos: Int): Long = {
    asJava.getUnsignedInt(pos)
  }

  /**
    * Returns the unsigned `int` at position `pos` in the Buffer, as a `long` in Little Endian Byte Order.
    */
  def getUnsignedIntLE(pos: Int): Long = {
    asJava.getUnsignedIntLE(pos)
  }

  /**
    * Returns the `long` at position `pos` in the Buffer.
    */
  def getLong(pos: Int): Long = {
    asJava.getLong(pos)
  }

  /**
    * Gets a 64-bit long integer at the specified absolute `index` in this buffer in Little Endian Byte Order.
    */
  def getLongLE(pos: Int): Long = {
    asJava.getLongLE(pos)
  }

  /**
    * Returns the `double` at position `pos` in the Buffer.
    */
  def getDouble(pos: Int): Double = {
    asJava.getDouble(pos)
  }

  /**
    * Returns the `float` at position `pos` in the Buffer.
    */
  def getFloat(pos: Int): Float = {
    asJava.getFloat(pos)
  }

  /**
    * Returns the `short` at position `pos` in the Buffer.
    */
  def getShort(pos: Int): Short = {
    asJava.getShort(pos)
  }

  /**
    * Gets a 16-bit short integer at the specified absolute `index` in this buffer in Little Endian Byte Order.
    */
  def getShortLE(pos: Int): Short = {
    asJava.getShortLE(pos)
  }

  /**
    * Returns the unsigned `short` at position `pos` in the Buffer, as an `int`.
    */
  def getUnsignedShort(pos: Int): Int = {
    asJava.getUnsignedShort(pos)
  }

  /**
    * Gets an unsigned 16-bit short integer at the specified absolute `index` in this buffer in Little Endian Byte Order.
    */
  def getUnsignedShortLE(pos: Int): Int = {
    asJava.getUnsignedShortLE(pos)
  }

  /**
    * Gets a 24-bit medium integer at the specified absolute `index` in this buffer.
    */
  def getMedium(pos: Int): Int = {
    asJava.getMedium(pos)
  }

  /**
    * Gets a 24-bit medium integer at the specified absolute `index` in this buffer in the Little Endian Byte Order.
    */
  def getMediumLE(pos: Int): Int = {
    asJava.getMediumLE(pos)
  }

  /**
    * Gets an unsigned 24-bit medium integer at the specified absolute `index` in this buffer.
    */
  def getUnsignedMedium(pos: Int): Int = {
    asJava.getUnsignedMedium(pos)
  }

  /**
    * Gets an unsigned 24-bit medium integer at the specified absolute `index` in this buffer in Little Endian Byte Order.
    */
  def getUnsignedMediumLE(pos: Int): Int = {
    asJava.getUnsignedMediumLE(pos)
  }

  /**
    * Returns a copy of a sub-sequence the Buffer as a [[io.vertx.scala.core.buffer.Buffer]] starting at position `start`
    * and ending at position `end - 1`
    */
  def getBuffer(start: Int, end: Int): Buffer = {
    Buffer.apply(asJava.getBuffer(start, end))
  }

  /**
    * Returns a copy of a sub-sequence the Buffer as a `String` starting at position `start`
    * and ending at position `end - 1` interpreted as a String in the specified encoding
    */
  def getString(start: Int, end: Int, enc: String): String = {
    asJava.getString(start, end, enc)
  }

  /**
    * Returns a copy of a sub-sequence the Buffer as a `String` starting at position `start`
    * and ending at position `end - 1` interpreted as a String in UTF-8 encoding
    */
  def getString(start: Int, end: Int): String = {
    asJava.getString(start, end)
  }

  /**
    * Appends the specified `Buffer` to the end of this Buffer. The buffer will expand as necessary to accommodate
    * any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendBuffer(buff: Buffer): Buffer = {
    asJava.appendBuffer(buff.asJava.asInstanceOf[JBuffer])
    this
  }

  /**
    * Appends the specified `Buffer` starting at the `offset` using `len` to the end of this Buffer. The buffer will expand as necessary to accommodate
    * any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendBuffer(buff: Buffer, offset: Int, len: Int): Buffer = {
    asJava.appendBuffer(buff.asJava.asInstanceOf[JBuffer], offset, len)
    this
  }

  /**
    * Appends the specified `byte` to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendByte(b: Byte): Buffer = {
    asJava.appendByte(b)
    this
  }

  /**
    * Appends the specified unsigned `byte` to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendUnsignedByte(b: Short): Buffer = {
    asJava.appendUnsignedByte(b)
    this
  }

  /**
    * Appends the specified `int` to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendInt(i: Int): Buffer = {
    asJava.appendInt(i)
    this
  }

  /**
    * Appends the specified `int` to the end of the Buffer in the Little Endian Byte Order. The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendIntLE(i: Int): Buffer = {
    asJava.appendIntLE(i)
    this
  }

  /**
    * Appends the specified unsigned `int` to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendUnsignedInt(i: Long): Buffer = {
    asJava.appendUnsignedInt(i)
    this
  }

  /**
    * Appends the specified unsigned `int` to the end of the Buffer in the Little Endian Byte Order. The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendUnsignedIntLE(i: Long): Buffer = {
    asJava.appendUnsignedIntLE(i)
    this
  }

  /**
    * Appends the specified 24bit `int` to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendMedium(i: Int): Buffer = {
    asJava.appendMedium(i)
    this
  }

  /**
    * Appends the specified 24bit `int` to the end of the Buffer in the Little Endian Byte Order. The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendMediumLE(i: Int): Buffer = {
    asJava.appendMediumLE(i)
    this
  }

  /**
    * Appends the specified `long` to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendLong(l: Long): Buffer = {
    asJava.appendLong(l)
    this
  }

  /**
    * Appends the specified `long` to the end of the Buffer in the Little Endian Byte Order. The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendLongLE(l: Long): Buffer = {
    asJava.appendLongLE(l)
    this
  }

  /**
    * Appends the specified `short` to the end of the Buffer.The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendShort(s: Short): Buffer = {
    asJava.appendShort(s)
    this
  }

  /**
    * Appends the specified `short` to the end of the Buffer in the Little Endian Byte Order.The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendShortLE(s: Short): Buffer = {
    asJava.appendShortLE(s)
    this
  }

  /**
    * Appends the specified unsigned `short` to the end of the Buffer.The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendUnsignedShort(s: Int): Buffer = {
    asJava.appendUnsignedShort(s)
    this
  }

  /**
    * Appends the specified unsigned `short` to the end of the Buffer in the Little Endian Byte Order.The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendUnsignedShortLE(s: Int): Buffer = {
    asJava.appendUnsignedShortLE(s)
    this
  }

  /**
    * Appends the specified `float` to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendFloat(f: Float): Buffer = {
    asJava.appendFloat(f)
    this
  }

  /**
    * Appends the specified `double` to the end of the Buffer. The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendDouble(d: Double): Buffer = {
    asJava.appendDouble(d)
    this
  }

  /**
    * Appends the specified `String` to the end of the Buffer with the encoding as specified by `enc`.
    * The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together.
    */
  def appendString(str: String, enc: String): Buffer = {
    asJava.appendString(str, enc)
    this
  }

  /**
    * Appends the specified `String str` to the end of the Buffer with UTF-8 encoding.
    * The buffer will expand as necessary to accommodate any bytes written.
    * Returns a reference to `this` so multiple operations can be appended together
    */
  def appendString(str: String): Buffer = {
    asJava.appendString(str)
    this
  }

  /**
    * Sets the `byte` at position `pos` in the Buffer to the value `b`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setByte(pos: Int, b: Byte): Buffer = {
    asJava.setByte(pos, b)
    this
  }

  /**
    * Sets the unsigned `byte` at position `pos` in the Buffer to the value `b`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setUnsignedByte(pos: Int, b: Short): Buffer = {
    asJava.setUnsignedByte(pos, b)
    this
  }

  /**
    * Sets the `int` at position `pos` in the Buffer to the value `i`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setInt(pos: Int, i: Int): Buffer = {
    asJava.setInt(pos, i)
    this
  }

  /**
    * Sets the `int` at position `pos` in the Buffer to the value `i` in the Little Endian Byte Order.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setIntLE(pos: Int, i: Int): Buffer = {
    asJava.setIntLE(pos, i)
    this
  }

  /**
    * Sets the unsigned `int` at position `pos` in the Buffer to the value `i`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setUnsignedInt(pos: Int, i: Long): Buffer = {
    asJava.setUnsignedInt(pos, i)
    this
  }

  /**
    * Sets the unsigned `int` at position `pos` in the Buffer to the value `i` in the Little Endian Byte Order.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setUnsignedIntLE(pos: Int, i: Long): Buffer = {
    asJava.setUnsignedIntLE(pos, i)
    this
  }

  /**
    * Sets the 24bit `int` at position `pos` in the Buffer to the value `i`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setMedium(pos: Int, i: Int): Buffer = {
    asJava.setMedium(pos, i)
    this
  }

  /**
    * Sets the 24bit `int` at position `pos` in the Buffer to the value `i`. in the Little Endian Byte Order
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setMediumLE(pos: Int, i: Int): Buffer = {
    asJava.setMediumLE(pos, i)
    this
  }

  /**
    * Sets the `long` at position `pos` in the Buffer to the value `l`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setLong(pos: Int, l: Long): Buffer = {
    asJava.setLong(pos, l)
    this
  }

  /**
    * Sets the `long` at position `pos` in the Buffer to the value `l` in the Little Endian Byte Order.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setLongLE(pos: Int, l: Long): Buffer = {
    asJava.setLongLE(pos, l)
    this
  }

  /**
    * Sets the `double` at position `pos` in the Buffer to the value `d`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setDouble(pos: Int, d: Double): Buffer = {
    asJava.setDouble(pos, d)
    this
  }

  /**
    * Sets the `float` at position `pos` in the Buffer to the value `f`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setFloat(pos: Int, f: Float): Buffer = {
    asJava.setFloat(pos, f)
    this
  }

  /**
    * Sets the `short` at position `pos` in the Buffer to the value `s`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setShort(pos: Int, s: Short): Buffer = {
    asJava.setShort(pos, s)
    this
  }

  /**
    * Sets the `short` at position `pos` in the Buffer to the value `s` in the Little Endian Byte Order.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setShortLE(pos: Int, s: Short): Buffer = {
    asJava.setShortLE(pos, s)
    this
  }

  /**
    * Sets the unsigned `short` at position `pos` in the Buffer to the value `s`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setUnsignedShort(pos: Int, s: Int): Buffer = {
    asJava.setUnsignedShort(pos, s)
    this
  }

  /**
    * Sets the unsigned `short` at position `pos` in the Buffer to the value `s` in the Little Endian Byte Order.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setUnsignedShortLE(pos: Int, s: Int): Buffer = {
    asJava.setUnsignedShortLE(pos, s)
    this
  }

  /**
    * Sets the bytes at position `pos` in the Buffer to the bytes represented by the `Buffer b`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setBuffer(pos: Int, b: Buffer): Buffer = {
    asJava.setBuffer(pos, b.asJava.asInstanceOf[JBuffer])
    this
  }

  /**
    * Sets the bytes at position `pos` in the Buffer to the bytes represented by the `Buffer b` on the given `offset` and `len`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setBuffer(pos: Int, b: Buffer, offset: Int, len: Int): Buffer = {
    asJava.setBuffer(pos, b.asJava.asInstanceOf[JBuffer], offset, len)
    this
  }

  /**
    * Sets the bytes at position `pos` in the Buffer to the value of `str` encoded in UTF-8.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setString(pos: Int, str: String): Buffer = {
    asJava.setString(pos, str)
    this
  }

  /**
    * Sets the bytes at position `pos` in the Buffer to the value of `str` encoded in encoding `enc`.
    * The buffer will expand as necessary to accommodate any value written.
    */
  def setString(pos: Int, str: String, enc: String): Buffer = {
    asJava.setString(pos, str, enc)
    this
  }

  /**
    * Returns the length of the buffer, measured in bytes.
    * All positions are indexed from zero.
    */
  def length(): Int = {
    asJava.length()
  }

  /**
    * Returns a copy of the entire Buffer.
    */
  def copy(): Buffer = {
    Buffer.apply(asJava.copy())
  }

  /**
    * Returns a slice of this buffer. Modifying the content
    * of the returned buffer or this buffer affects each other's content
    * while they maintain separate indexes and marks.
    */
  def slice(): Buffer = {
    Buffer.apply(asJava.slice())
  }

  /**
    * Returns a slice of this buffer. Modifying the content
    * of the returned buffer or this buffer affects each other's content
    * while they maintain separate indexes and marks.
    */
  def slice(start: Int, end: Int): Buffer = {
    Buffer.apply(asJava.slice(start, end))
  }

}

object Buffer {

  def apply(_asJava: JBuffer): Buffer =
    new Buffer(_asJava)

  def buffer(): Buffer = {
    Buffer.apply(io.vertx.core.buffer.Buffer.buffer())
  }

  def buffer(initialSizeHint: Int): Buffer = {
    Buffer.apply(io.vertx.core.buffer.Buffer.buffer(initialSizeHint))
  }

  def buffer(string: String): Buffer = {
    Buffer.apply(io.vertx.core.buffer.Buffer.buffer(string))
  }

  def buffer(string: String, enc: String): Buffer = {
    Buffer.apply(io.vertx.core.buffer.Buffer.buffer(string, enc))
  }

}
