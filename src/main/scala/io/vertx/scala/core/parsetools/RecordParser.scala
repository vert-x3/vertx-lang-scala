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

package io.vertx.scala.core.parsetools

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.Handler

/**
  * A helper class which allows you to easily parse protocols which are delimited by a sequence of bytes, or fixed
  * size records.
  * 
  * Instances of this class take as input [[io.vertx.scala.core.buffer.Buffer]] instances containing raw bytes,
  * and output records.
  * 
  * For example, if I had a simple ASCII text protocol delimited by '\n' and the input was the following:
  * 
  * <pre>
  * buffer1:HELLO\nHOW ARE Y
  * buffer2:OU?\nI AM
  * buffer3: DOING OK
  * buffer4:\n
  * </pre>
  * Then the output would be:
  * <pre>
  * buffer1:HELLO
  * buffer2:HOW ARE YOU?
  * buffer3:I AM DOING OK
  * </pre>
  * Instances of this class can be changed between delimited mode and fixed size record mode on the fly as
  * individual records are read, this allows you to parse protocols where, for example, the first 5 records might
  * all be fixed size (of potentially different sizes), followed by some delimited records, followed by more fixed
  * size records.
  * 
  * Instances of this class can't currently be used for protocols where the text is encoded with something other than
  * a 1-1 byte-char mapping.
  * 
  * Please see the documentation for more information.
  */
class RecordParser(private val _asJava: io.vertx.core.parsetools.RecordParser) {

  def asJava: io.vertx.core.parsetools.RecordParser = _asJava

  def setOutput(output: io.vertx.scala.core.buffer.Buffer => Unit): Unit = {
    _asJava.setOutput(funcToMappedHandler(Buffer.apply)(output))
  }

  /**
    * Flip the parser into delimited mode, and where the delimiter can be represented
    * by the String `delim` encoded in latin-1 . Don't use this if your String contains other than latin-1 characters.
    * 
    * This method can be called multiple times with different values of delim while data is being parsed.
    * @param delim the new delimeter
    */
  def delimitedMode(delim: String): Unit = {
    _asJava.delimitedMode(delim)
  }

  /**
    * Flip the parser into delimited mode, and where the delimiter can be represented
    * by the delimiter `delim`.
    * 
    * This method can be called multiple times with different values of delim while data is being parsed.
    * @param delim the new delimiter
    */
  def delimitedMode(delim: io.vertx.scala.core.buffer.Buffer): Unit = {
    _asJava.delimitedMode(delim.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
  }

  /**
    * Flip the parser into fixed size mode, where the record size is specified by `size` in bytes.
    * 
    * This method can be called multiple times with different values of size while data is being parsed.
    * @param size the new record size
    */
  def fixedSizeMode(size: Int): Unit = {
    _asJava.fixedSizeMode(size)
  }

  /**
    * This method is called to provide the parser with data.
    * @param buffer a chunk of data
    */
  def handle(buffer: io.vertx.scala.core.buffer.Buffer): Unit = {
    _asJava.handle(buffer.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
  }

}

object RecordParser {

  def apply(_asJava: io.vertx.core.parsetools.RecordParser): io.vertx.scala.core.parsetools.RecordParser =
    new io.vertx.scala.core.parsetools.RecordParser(_asJava)

  def newDelimited(delim: String, output: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.parsetools.RecordParser = {
    RecordParser.apply(io.vertx.core.parsetools.RecordParser.newDelimited(delim, funcToMappedHandler(Buffer.apply)(output)))
  }

  def newDelimited(delim: io.vertx.scala.core.buffer.Buffer, output: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.parsetools.RecordParser = {
    RecordParser.apply(io.vertx.core.parsetools.RecordParser.newDelimited(delim.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], funcToMappedHandler(Buffer.apply)(output)))
  }

  def newFixed(size: Int, output: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.parsetools.RecordParser = {
    RecordParser.apply(io.vertx.core.parsetools.RecordParser.newFixed(size, funcToMappedHandler(Buffer.apply)(output)))
  }

}
