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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import io.vertx.core.json.JsonArray
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.json.JsonObject

/**
  * Most data is shuffled around inside Vert.x using buffers.
  * 
  * A buffer is a sequence of zero or more bytes that can read from or written to and which expands automatically as
  * necessary to accommodate any bytes written to it. You can perhaps think of a buffer as smart byte array.
  * 
  * Please consult the documentation for more information on buffers.
  */
class Buffer(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
  def appendBuffer(buff: Buffer):Buffer = {
    asJava.asInstanceOf[JBuffer].appendBuffer(buff.asJava.asInstanceOf[JBuffer])
    this
  }

  def appendBuffer(buff: Buffer,offset: Int,len: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendBuffer(buff.asJava.asInstanceOf[JBuffer],offset.asInstanceOf[java.lang.Integer],len.asInstanceOf[java.lang.Integer])
    this
  }

  def appendByte(b: Byte):Buffer = {
    asJava.asInstanceOf[JBuffer].appendByte(b.asInstanceOf[java.lang.Byte])
    this
  }

  def appendUnsignedByte(b: Short):Buffer = {
    asJava.asInstanceOf[JBuffer].appendUnsignedByte(b.asInstanceOf[java.lang.Short])
    this
  }

  def appendInt(i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendInt(i.asInstanceOf[java.lang.Integer])
    this
  }

  def appendIntLE(i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendIntLE(i.asInstanceOf[java.lang.Integer])
    this
  }

  def appendUnsignedInt(i: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].appendUnsignedInt(i.asInstanceOf[java.lang.Long])
    this
  }

  def appendUnsignedIntLE(i: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].appendUnsignedIntLE(i.asInstanceOf[java.lang.Long])
    this
  }

  def appendMedium(i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendMedium(i.asInstanceOf[java.lang.Integer])
    this
  }

  def appendMediumLE(i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendMediumLE(i.asInstanceOf[java.lang.Integer])
    this
  }

  def appendLong(l: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].appendLong(l.asInstanceOf[java.lang.Long])
    this
  }

  def appendLongLE(l: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].appendLongLE(l.asInstanceOf[java.lang.Long])
    this
  }

  def appendShort(s: Short):Buffer = {
    asJava.asInstanceOf[JBuffer].appendShort(s.asInstanceOf[java.lang.Short])
    this
  }

  def appendShortLE(s: Short):Buffer = {
    asJava.asInstanceOf[JBuffer].appendShortLE(s.asInstanceOf[java.lang.Short])
    this
  }

  def appendUnsignedShort(s: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendUnsignedShort(s.asInstanceOf[java.lang.Integer])
    this
  }

  def appendUnsignedShortLE(s: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendUnsignedShortLE(s.asInstanceOf[java.lang.Integer])
    this
  }

  def appendFloat(f: Float):Buffer = {
    asJava.asInstanceOf[JBuffer].appendFloat(f.asInstanceOf[java.lang.Float])
    this
  }

  def appendDouble(d: Double):Buffer = {
    asJava.asInstanceOf[JBuffer].appendDouble(d.asInstanceOf[java.lang.Double])
    this
  }

  def appendString(str: String,enc: String):Buffer = {
    asJava.asInstanceOf[JBuffer].appendString(str.asInstanceOf[java.lang.String],enc.asInstanceOf[java.lang.String])
    this
  }

  def appendString(str: String):Buffer = {
    asJava.asInstanceOf[JBuffer].appendString(str.asInstanceOf[java.lang.String])
    this
  }

  def setByte(pos: Int,b: Byte):Buffer = {
    asJava.asInstanceOf[JBuffer].setByte(pos.asInstanceOf[java.lang.Integer],b.asInstanceOf[java.lang.Byte])
    this
  }

  def setUnsignedByte(pos: Int,b: Short):Buffer = {
    asJava.asInstanceOf[JBuffer].setUnsignedByte(pos.asInstanceOf[java.lang.Integer],b.asInstanceOf[java.lang.Short])
    this
  }

  def setInt(pos: Int,i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setInt(pos.asInstanceOf[java.lang.Integer],i.asInstanceOf[java.lang.Integer])
    this
  }

  def setIntLE(pos: Int,i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setIntLE(pos.asInstanceOf[java.lang.Integer],i.asInstanceOf[java.lang.Integer])
    this
  }

  def setUnsignedInt(pos: Int,i: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].setUnsignedInt(pos.asInstanceOf[java.lang.Integer],i.asInstanceOf[java.lang.Long])
    this
  }

  def setUnsignedIntLE(pos: Int,i: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].setUnsignedIntLE(pos.asInstanceOf[java.lang.Integer],i.asInstanceOf[java.lang.Long])
    this
  }

  def setMedium(pos: Int,i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setMedium(pos.asInstanceOf[java.lang.Integer],i.asInstanceOf[java.lang.Integer])
    this
  }

  def setMediumLE(pos: Int,i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setMediumLE(pos.asInstanceOf[java.lang.Integer],i.asInstanceOf[java.lang.Integer])
    this
  }

  def setLong(pos: Int,l: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].setLong(pos.asInstanceOf[java.lang.Integer],l.asInstanceOf[java.lang.Long])
    this
  }

  def setLongLE(pos: Int,l: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].setLongLE(pos.asInstanceOf[java.lang.Integer],l.asInstanceOf[java.lang.Long])
    this
  }

  def setDouble(pos: Int,d: Double):Buffer = {
    asJava.asInstanceOf[JBuffer].setDouble(pos.asInstanceOf[java.lang.Integer],d.asInstanceOf[java.lang.Double])
    this
  }

  def setFloat(pos: Int,f: Float):Buffer = {
    asJava.asInstanceOf[JBuffer].setFloat(pos.asInstanceOf[java.lang.Integer],f.asInstanceOf[java.lang.Float])
    this
  }

  def setShort(pos: Int,s: Short):Buffer = {
    asJava.asInstanceOf[JBuffer].setShort(pos.asInstanceOf[java.lang.Integer],s.asInstanceOf[java.lang.Short])
    this
  }

  def setShortLE(pos: Int,s: Short):Buffer = {
    asJava.asInstanceOf[JBuffer].setShortLE(pos.asInstanceOf[java.lang.Integer],s.asInstanceOf[java.lang.Short])
    this
  }

  def setUnsignedShort(pos: Int,s: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setUnsignedShort(pos.asInstanceOf[java.lang.Integer],s.asInstanceOf[java.lang.Integer])
    this
  }

  def setUnsignedShortLE(pos: Int,s: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setUnsignedShortLE(pos.asInstanceOf[java.lang.Integer],s.asInstanceOf[java.lang.Integer])
    this
  }

  def setBuffer(pos: Int,b: Buffer):Buffer = {
    asJava.asInstanceOf[JBuffer].setBuffer(pos.asInstanceOf[java.lang.Integer],b.asJava.asInstanceOf[JBuffer])
    this
  }

  def setBuffer(pos: Int,b: Buffer,offset: Int,len: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setBuffer(pos.asInstanceOf[java.lang.Integer],b.asJava.asInstanceOf[JBuffer],offset.asInstanceOf[java.lang.Integer],len.asInstanceOf[java.lang.Integer])
    this
  }

  def setString(pos: Int,str: String):Buffer = {
    asJava.asInstanceOf[JBuffer].setString(pos.asInstanceOf[java.lang.Integer],str.asInstanceOf[java.lang.String])
    this
  }

  def setString(pos: Int,str: String,enc: String):Buffer = {
    asJava.asInstanceOf[JBuffer].setString(pos.asInstanceOf[java.lang.Integer],str.asInstanceOf[java.lang.String],enc.asInstanceOf[java.lang.String])
    this
  }

//default methods
//basic methods
      override def toString():String = {
    asJava.asInstanceOf[JBuffer].toString().asInstanceOf[String]
  }

      def toString(enc: String):String = {
    asJava.asInstanceOf[JBuffer].toString(enc.asInstanceOf[java.lang.String]).asInstanceOf[String]
  }

      def toJsonObject():io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JBuffer].toJsonObject()
  }

      def toJsonArray():io.vertx.core.json.JsonArray = {
    asJava.asInstanceOf[JBuffer].toJsonArray()
  }

      def getByte(pos: Int):Byte = {
    asJava.asInstanceOf[JBuffer].getByte(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Byte]
  }

      def getUnsignedByte(pos: Int):Short = {
    asJava.asInstanceOf[JBuffer].getUnsignedByte(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Short]
  }

      def getInt(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getInt(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Int]
  }

      def getIntLE(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getIntLE(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Int]
  }

      def getUnsignedInt(pos: Int):Long = {
    asJava.asInstanceOf[JBuffer].getUnsignedInt(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Long]
  }

      def getUnsignedIntLE(pos: Int):Long = {
    asJava.asInstanceOf[JBuffer].getUnsignedIntLE(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Long]
  }

      def getLong(pos: Int):Long = {
    asJava.asInstanceOf[JBuffer].getLong(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Long]
  }

      def getLongLE(pos: Int):Long = {
    asJava.asInstanceOf[JBuffer].getLongLE(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Long]
  }

      def getDouble(pos: Int):Double = {
    asJava.asInstanceOf[JBuffer].getDouble(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Double]
  }

      def getFloat(pos: Int):Float = {
    asJava.asInstanceOf[JBuffer].getFloat(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Float]
  }

      def getShort(pos: Int):Short = {
    asJava.asInstanceOf[JBuffer].getShort(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Short]
  }

      def getShortLE(pos: Int):Short = {
    asJava.asInstanceOf[JBuffer].getShortLE(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Short]
  }

      def getUnsignedShort(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getUnsignedShort(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Int]
  }

      def getUnsignedShortLE(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getUnsignedShortLE(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Int]
  }

      def getMedium(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getMedium(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Int]
  }

      def getMediumLE(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getMediumLE(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Int]
  }

      def getUnsignedMedium(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getUnsignedMedium(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Int]
  }

      def getUnsignedMediumLE(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getUnsignedMediumLE(pos.asInstanceOf[java.lang.Integer]).asInstanceOf[Int]
  }

      def getBuffer(start: Int,end: Int):Buffer = {
    Buffer(asJava.asInstanceOf[JBuffer].getBuffer(start.asInstanceOf[java.lang.Integer],end.asInstanceOf[java.lang.Integer]))
  }

      def getString(start: Int,end: Int,enc: String):String = {
    asJava.asInstanceOf[JBuffer].getString(start.asInstanceOf[java.lang.Integer],end.asInstanceOf[java.lang.Integer],enc.asInstanceOf[java.lang.String]).asInstanceOf[String]
  }

      def getString(start: Int,end: Int):String = {
    asJava.asInstanceOf[JBuffer].getString(start.asInstanceOf[java.lang.Integer],end.asInstanceOf[java.lang.Integer]).asInstanceOf[String]
  }

      def length():Int = {
    asJava.asInstanceOf[JBuffer].length().asInstanceOf[Int]
  }

      def copy():Buffer = {
    Buffer(asJava.asInstanceOf[JBuffer].copy())
  }

      def slice():Buffer = {
    Buffer(asJava.asInstanceOf[JBuffer].slice())
  }

      def slice(start: Int,end: Int):Buffer = {
    Buffer(asJava.asInstanceOf[JBuffer].slice(start.asInstanceOf[java.lang.Integer],end.asInstanceOf[java.lang.Integer]))
  }

//future methods
}

  object Buffer{
    def apply(asJava: JBuffer) = new Buffer(asJava)  
  //static methods
    def buffer():Buffer = {
      Buffer(JBuffer.buffer())
    }

    def buffer(initialSizeHint: Int):Buffer = {
      Buffer(JBuffer.buffer(initialSizeHint.asInstanceOf[java.lang.Integer]))
    }

    def buffer(string: String):Buffer = {
      Buffer(JBuffer.buffer(string.asInstanceOf[java.lang.String]))
    }

    def buffer(string: String,enc: String):Buffer = {
      Buffer(JBuffer.buffer(string.asInstanceOf[java.lang.String],enc.asInstanceOf[java.lang.String]))
    }

  }
