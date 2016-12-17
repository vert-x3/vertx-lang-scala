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

def asJava = _asJava.asInstanceOf[JBuffer]
//methods returning a future
//cached methods
//fluent methods
  def appendBuffer(buff: Buffer):Buffer = {
    asJava.appendBuffer( )
    this
  }

  def appendBuffer(buff: Buffer,offset: Int,len: Int):Buffer = {
    asJava.appendBuffer( )
    this
  }

  def appendByte(b: Byte):Buffer = {
    asJava.appendByte( )
    this
  }

  def appendUnsignedByte(b: Short):Buffer = {
    asJava.appendUnsignedByte( )
    this
  }

  def appendInt(i: Int):Buffer = {
    asJava.appendInt( )
    this
  }

  def appendIntLE(i: Int):Buffer = {
    asJava.appendIntLE( )
    this
  }

  def appendUnsignedInt(i: Long):Buffer = {
    asJava.appendUnsignedInt( )
    this
  }

  def appendUnsignedIntLE(i: Long):Buffer = {
    asJava.appendUnsignedIntLE( )
    this
  }

  def appendMedium(i: Int):Buffer = {
    asJava.appendMedium( )
    this
  }

  def appendMediumLE(i: Int):Buffer = {
    asJava.appendMediumLE( )
    this
  }

  def appendLong(l: Long):Buffer = {
    asJava.appendLong( )
    this
  }

  def appendLongLE(l: Long):Buffer = {
    asJava.appendLongLE( )
    this
  }

  def appendShort(s: Short):Buffer = {
    asJava.appendShort( )
    this
  }

  def appendShortLE(s: Short):Buffer = {
    asJava.appendShortLE( )
    this
  }

  def appendUnsignedShort(s: Int):Buffer = {
    asJava.appendUnsignedShort( )
    this
  }

  def appendUnsignedShortLE(s: Int):Buffer = {
    asJava.appendUnsignedShortLE( )
    this
  }

  def appendFloat(f: Float):Buffer = {
    asJava.appendFloat( )
    this
  }

  def appendDouble(d: Double):Buffer = {
    asJava.appendDouble( )
    this
  }

  def appendString(str: String,enc: String):Buffer = {
    asJava.appendString( )
    this
  }

  def appendString(str: String):Buffer = {
    asJava.appendString( )
    this
  }

  def setByte(pos: Int,b: Byte):Buffer = {
    asJava.setByte( )
    this
  }

  def setUnsignedByte(pos: Int,b: Short):Buffer = {
    asJava.setUnsignedByte( )
    this
  }

  def setInt(pos: Int,i: Int):Buffer = {
    asJava.setInt( )
    this
  }

  def setIntLE(pos: Int,i: Int):Buffer = {
    asJava.setIntLE( )
    this
  }

  def setUnsignedInt(pos: Int,i: Long):Buffer = {
    asJava.setUnsignedInt( )
    this
  }

  def setUnsignedIntLE(pos: Int,i: Long):Buffer = {
    asJava.setUnsignedIntLE( )
    this
  }

  def setMedium(pos: Int,i: Int):Buffer = {
    asJava.setMedium( )
    this
  }

  def setMediumLE(pos: Int,i: Int):Buffer = {
    asJava.setMediumLE( )
    this
  }

  def setLong(pos: Int,l: Long):Buffer = {
    asJava.setLong( )
    this
  }

  def setLongLE(pos: Int,l: Long):Buffer = {
    asJava.setLongLE( )
    this
  }

  def setDouble(pos: Int,d: Double):Buffer = {
    asJava.setDouble( )
    this
  }

  def setFloat(pos: Int,f: Float):Buffer = {
    asJava.setFloat( )
    this
  }

  def setShort(pos: Int,s: Short):Buffer = {
    asJava.setShort( )
    this
  }

  def setShortLE(pos: Int,s: Short):Buffer = {
    asJava.setShortLE( )
    this
  }

  def setUnsignedShort(pos: Int,s: Int):Buffer = {
    asJava.setUnsignedShort( )
    this
  }

  def setUnsignedShortLE(pos: Int,s: Int):Buffer = {
    asJava.setUnsignedShortLE( )
    this
  }

  def setBuffer(pos: Int,b: Buffer):Buffer = {
    asJava.setBuffer( )
    this
  }

  def setBuffer(pos: Int,b: Buffer,offset: Int,len: Int):Buffer = {
    asJava.setBuffer( )
    this
  }

  def setString(pos: Int,str: String):Buffer = {
    asJava.setString( )
    this
  }

  def setString(pos: Int,str: String,enc: String):Buffer = {
    asJava.setString( )
    this
  }

//basic methods
  def toString():String = {
    asJava.toString( )
  }

  def toString(enc: String):String = {
    asJava.toString( )
  }

  def toJsonObject():io.vertx.core.json.JsonObject = {
    asJava.toJsonObject( )
  }

  def toJsonArray():io.vertx.core.json.JsonArray = {
    asJava.toJsonArray( )
  }

  def getByte(pos: Int):Byte = {
    asJava.getByte( )
  }

  def getUnsignedByte(pos: Int):Short = {
    asJava.getUnsignedByte( )
  }

  def getInt(pos: Int):Int = {
    asJava.getInt( )
  }

  def getIntLE(pos: Int):Int = {
    asJava.getIntLE( )
  }

  def getUnsignedInt(pos: Int):Long = {
    asJava.getUnsignedInt( )
  }

  def getUnsignedIntLE(pos: Int):Long = {
    asJava.getUnsignedIntLE( )
  }

  def getLong(pos: Int):Long = {
    asJava.getLong( )
  }

  def getLongLE(pos: Int):Long = {
    asJava.getLongLE( )
  }

  def getDouble(pos: Int):Double = {
    asJava.getDouble( )
  }

  def getFloat(pos: Int):Float = {
    asJava.getFloat( )
  }

  def getShort(pos: Int):Short = {
    asJava.getShort( )
  }

  def getShortLE(pos: Int):Short = {
    asJava.getShortLE( )
  }

  def getUnsignedShort(pos: Int):Int = {
    asJava.getUnsignedShort( )
  }

  def getUnsignedShortLE(pos: Int):Int = {
    asJava.getUnsignedShortLE( )
  }

  def getMedium(pos: Int):Int = {
    asJava.getMedium( )
  }

  def getMediumLE(pos: Int):Int = {
    asJava.getMediumLE( )
  }

  def getUnsignedMedium(pos: Int):Int = {
    asJava.getUnsignedMedium( )
  }

  def getUnsignedMediumLE(pos: Int):Int = {
    asJava.getUnsignedMediumLE( )
  }

  def getBuffer(start: Int,end: Int):Buffer = {
    asJava.getBuffer( )
  }

  def getString(start: Int,end: Int,enc: String):String = {
    asJava.getString( )
  }

  def getString(start: Int,end: Int):String = {
    asJava.getString( )
  }

  def length():Int = {
    asJava.length( )
  }

  def copy():Buffer = {
    asJava.copy( )
  }

  def slice():Buffer = {
    asJava.slice( )
  }

  def slice(start: Int,end: Int):Buffer = {
    asJava.slice( )
  }

}

object Buffer{
//in object!
//static methods
  def buffer():Buffer = {
    JBuffer.buffer( )
  }

  def buffer(initialSizeHint: Int):Buffer = {
    JBuffer.buffer( )
  }

  def buffer(string: String):Buffer = {
    JBuffer.buffer( )
  }

  def buffer(string: String,enc: String):Buffer = {
    JBuffer.buffer( )
  }

}
