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
    asJava.asInstanceOf[JBuffer].appendBuffer(buff.asJava.asInstanceOf[JBuffer],offset,len)
    this
  }

  def appendByte(b: Byte):Buffer = {
    asJava.asInstanceOf[JBuffer].appendByte(b)
    this
  }

  def appendUnsignedByte(b: Short):Buffer = {
    asJava.asInstanceOf[JBuffer].appendUnsignedByte(b)
    this
  }

  def appendInt(i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendInt(i)
    this
  }

  def appendIntLE(i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendIntLE(i)
    this
  }

  def appendUnsignedInt(i: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].appendUnsignedInt(i)
    this
  }

  def appendUnsignedIntLE(i: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].appendUnsignedIntLE(i)
    this
  }

  def appendMedium(i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendMedium(i)
    this
  }

  def appendMediumLE(i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendMediumLE(i)
    this
  }

  def appendLong(l: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].appendLong(l)
    this
  }

  def appendLongLE(l: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].appendLongLE(l)
    this
  }

  def appendShort(s: Short):Buffer = {
    asJava.asInstanceOf[JBuffer].appendShort(s)
    this
  }

  def appendShortLE(s: Short):Buffer = {
    asJava.asInstanceOf[JBuffer].appendShortLE(s)
    this
  }

  def appendUnsignedShort(s: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendUnsignedShort(s)
    this
  }

  def appendUnsignedShortLE(s: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].appendUnsignedShortLE(s)
    this
  }

  def appendFloat(f: Float):Buffer = {
    asJava.asInstanceOf[JBuffer].appendFloat(f)
    this
  }

  def appendDouble(d: Double):Buffer = {
    asJava.asInstanceOf[JBuffer].appendDouble(d)
    this
  }

  def appendString(str: String,enc: String):Buffer = {
    asJava.asInstanceOf[JBuffer].appendString(str,enc)
    this
  }

  def appendString(str: String):Buffer = {
    asJava.asInstanceOf[JBuffer].appendString(str)
    this
  }

  def setByte(pos: Int,b: Byte):Buffer = {
    asJava.asInstanceOf[JBuffer].setByte(pos,b)
    this
  }

  def setUnsignedByte(pos: Int,b: Short):Buffer = {
    asJava.asInstanceOf[JBuffer].setUnsignedByte(pos,b)
    this
  }

  def setInt(pos: Int,i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setInt(pos,i)
    this
  }

  def setIntLE(pos: Int,i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setIntLE(pos,i)
    this
  }

  def setUnsignedInt(pos: Int,i: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].setUnsignedInt(pos,i)
    this
  }

  def setUnsignedIntLE(pos: Int,i: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].setUnsignedIntLE(pos,i)
    this
  }

  def setMedium(pos: Int,i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setMedium(pos,i)
    this
  }

  def setMediumLE(pos: Int,i: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setMediumLE(pos,i)
    this
  }

  def setLong(pos: Int,l: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].setLong(pos,l)
    this
  }

  def setLongLE(pos: Int,l: Long):Buffer = {
    asJava.asInstanceOf[JBuffer].setLongLE(pos,l)
    this
  }

  def setDouble(pos: Int,d: Double):Buffer = {
    asJava.asInstanceOf[JBuffer].setDouble(pos,d)
    this
  }

  def setFloat(pos: Int,f: Float):Buffer = {
    asJava.asInstanceOf[JBuffer].setFloat(pos,f)
    this
  }

  def setShort(pos: Int,s: Short):Buffer = {
    asJava.asInstanceOf[JBuffer].setShort(pos,s)
    this
  }

  def setShortLE(pos: Int,s: Short):Buffer = {
    asJava.asInstanceOf[JBuffer].setShortLE(pos,s)
    this
  }

  def setUnsignedShort(pos: Int,s: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setUnsignedShort(pos,s)
    this
  }

  def setUnsignedShortLE(pos: Int,s: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setUnsignedShortLE(pos,s)
    this
  }

  def setBuffer(pos: Int,b: Buffer):Buffer = {
    asJava.asInstanceOf[JBuffer].setBuffer(pos,b.asJava.asInstanceOf[JBuffer])
    this
  }

  def setBuffer(pos: Int,b: Buffer,offset: Int,len: Int):Buffer = {
    asJava.asInstanceOf[JBuffer].setBuffer(pos,b.asJava.asInstanceOf[JBuffer],offset,len)
    this
  }

  def setString(pos: Int,str: String):Buffer = {
    asJava.asInstanceOf[JBuffer].setString(pos,str)
    this
  }

  def setString(pos: Int,str: String,enc: String):Buffer = {
    asJava.asInstanceOf[JBuffer].setString(pos,str,enc)
    this
  }

//default methods
//basic methods
  def toString():String = {
    asJava.asInstanceOf[JBuffer].toString()
  }

  def toString(enc: String):String = {
    asJava.asInstanceOf[JBuffer].toString(enc)
  }

  def toJsonObject():io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JBuffer].toJsonObject()
  }

  def toJsonArray():io.vertx.core.json.JsonArray = {
    asJava.asInstanceOf[JBuffer].toJsonArray()
  }

  def getByte(pos: Int):Byte = {
    asJava.asInstanceOf[JBuffer].getByte(pos)
  }

  def getUnsignedByte(pos: Int):Short = {
    asJava.asInstanceOf[JBuffer].getUnsignedByte(pos)
  }

  def getInt(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getInt(pos)
  }

  def getIntLE(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getIntLE(pos)
  }

  def getUnsignedInt(pos: Int):Long = {
    asJava.asInstanceOf[JBuffer].getUnsignedInt(pos)
  }

  def getUnsignedIntLE(pos: Int):Long = {
    asJava.asInstanceOf[JBuffer].getUnsignedIntLE(pos)
  }

  def getLong(pos: Int):Long = {
    asJava.asInstanceOf[JBuffer].getLong(pos)
  }

  def getLongLE(pos: Int):Long = {
    asJava.asInstanceOf[JBuffer].getLongLE(pos)
  }

  def getDouble(pos: Int):Double = {
    asJava.asInstanceOf[JBuffer].getDouble(pos)
  }

  def getFloat(pos: Int):Float = {
    asJava.asInstanceOf[JBuffer].getFloat(pos)
  }

  def getShort(pos: Int):Short = {
    asJava.asInstanceOf[JBuffer].getShort(pos)
  }

  def getShortLE(pos: Int):Short = {
    asJava.asInstanceOf[JBuffer].getShortLE(pos)
  }

  def getUnsignedShort(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getUnsignedShort(pos)
  }

  def getUnsignedShortLE(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getUnsignedShortLE(pos)
  }

  def getMedium(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getMedium(pos)
  }

  def getMediumLE(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getMediumLE(pos)
  }

  def getUnsignedMedium(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getUnsignedMedium(pos)
  }

  def getUnsignedMediumLE(pos: Int):Int = {
    asJava.asInstanceOf[JBuffer].getUnsignedMediumLE(pos)
  }

  def getBuffer(start: Int,end: Int):Buffer = {
    Buffer(asJava.asInstanceOf[JBuffer].getBuffer(start,end))
  }

  def getString(start: Int,end: Int,enc: String):String = {
    asJava.asInstanceOf[JBuffer].getString(start,end,enc)
  }

  def getString(start: Int,end: Int):String = {
    asJava.asInstanceOf[JBuffer].getString(start,end)
  }

  def length():Int = {
    asJava.asInstanceOf[JBuffer].length()
  }

  def copy():Buffer = {
    Buffer(asJava.asInstanceOf[JBuffer].copy())
  }

  def slice():Buffer = {
    Buffer(asJava.asInstanceOf[JBuffer].slice())
  }

  def slice(start: Int,end: Int):Buffer = {
    Buffer(asJava.asInstanceOf[JBuffer].slice(start,end))
  }

}

  object Buffer{
    def apply(asJava: JBuffer) = new Buffer(asJava)  
  //static methods
    def buffer():Buffer = {
      Buffer(JBuffer.buffer())
    }

    def buffer(initialSizeHint: Int):Buffer = {
      Buffer(JBuffer.buffer(initialSizeHint))
    }

    def buffer(string: String):Buffer = {
      Buffer(JBuffer.buffer(string))
    }

    def buffer(string: String,enc: String):Buffer = {
      Buffer(JBuffer.buffer(string,enc))
    }

  }
