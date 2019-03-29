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

package io.vertx.scala.redis.client

import io.vertx.redis.client.{Response => JResponse}
import io.vertx.core.buffer.Buffer
import scala.reflect.runtime.universe._
import scala.collection.JavaConverters._
import io.vertx.redis.client.ResponseType
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * The response received from the REDIS server. Redis responses can have several representations:
  *
  * <ul>
  *     <li>simple string - C string</li>
  *     <li>integer - 64bit integer value</li>
  *     <li>bulk - byte array</li>
  *     <li>multi - list</li>
  * </ul>
  *
  * Due to the dynamic nature the response object will try to cast the received response to the desired type. A special
  * case should be noted that multi responses are also handled by the response object as it implements the iterable
  * interface. So in this case constructs like for loops on the response will give you access to the underlying elements.
  */

class Response(private val _asJava: Object) {
  def asJava = _asJava




  /**
   * Get this response as a Long.   * @return long value.
   */
  def toLong(): Long = {
    asJava.asInstanceOf[JResponse].toLong().asInstanceOf[Long]
  }

  /**
   * Get this response as a Integer.   * @return int value.
   */
  def toInteger(): Int = {
    asJava.asInstanceOf[JResponse].toInteger().asInstanceOf[Int]
  }

  /**
   * Get this response as a Short.   * @return short value.
   */
  def toShort(): Short = {
    asJava.asInstanceOf[JResponse].toShort().asInstanceOf[Short]
  }

  /**
   * Get this response as a Byte.   * @return byte value.
   */
  def toByte(): Byte = {
    asJava.asInstanceOf[JResponse].toByte().asInstanceOf[Byte]
  }

  /**
   * Get this response as a Boolean.   * @return boolean value.
   */
  def toBoolean(): Boolean = {
    asJava.asInstanceOf[JResponse].toBoolean().asInstanceOf[Boolean]
  }

  /**
   * Get this response as Buffer.   * @return buffer value.
   */
  def toBuffer(): io.vertx.core.buffer.Buffer = {
    asJava.asInstanceOf[JResponse].toBuffer()
  }

  /**
   * Get this multi response value at a numerical index.   * @param index the required index.
   * @return Response value.
   */
  def get(index: Int): Response = {
    Response(asJava.asInstanceOf[JResponse].get(index.asInstanceOf[java.lang.Integer]))
  }

  /**
   * Get this multi response value at a string key. Note that REDIS does not support strings as keys but by convention
   * it encodes hashes in lists where index i is the key, and index i+1 is the value.   * @param key the required key.
   * @return Response value.
   */
  def get(key: String): Response = {
    Response(asJava.asInstanceOf[JResponse].get(key.asInstanceOf[java.lang.String]))
  }

  /**
   * Get this multi response keys from a hash. Note that REDIS does not support strings as keys but by convention
   * it encodes hashes in lists where index i is the key, and index i+1 is the value.   * @return the set of keys.
   */
  def getKeys(): scala.collection.mutable.Set[String] = {
    asJava.asInstanceOf[JResponse].getKeys().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Get this size of this multi response.   * @return the size of the multi.
   */
  def size(): Int = {
    asJava.asInstanceOf[JResponse].size().asInstanceOf[Int]
  }


  /**
   * The response return type.   * @return the type.
   */
  def `type` (): io.vertx.redis.client.ResponseType = {
    asJava.asInstanceOf[JResponse].`type`()
  }

  /**
   * Get this response as a String.   * @return string value
   */
  override def toString (): String = {
    asJava.asInstanceOf[JResponse].toString().asInstanceOf[String]
  }


}

object Response {
  def apply(asJava: JResponse) = new Response(asJava)
  
}
