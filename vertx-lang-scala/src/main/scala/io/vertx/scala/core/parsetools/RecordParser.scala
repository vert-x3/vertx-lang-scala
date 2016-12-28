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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.Handler
import io.vertx.core.parsetools.{RecordParser => JRecordParser}

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
class RecordParser(private val _asJava: Object) 
    extends io.vertx.core.Handler[Buffer] {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
      def setOutput(output: Handler[Buffer]):Unit = {
    asJava.asInstanceOf[JRecordParser].setOutput({x: JBuffer => output.handle(Buffer(x))})
  }

      def delimitedMode(delim: String):Unit = {
    asJava.asInstanceOf[JRecordParser].delimitedMode(delim.asInstanceOf[java.lang.String])
  }

      def delimitedMode(delim: Buffer):Unit = {
    asJava.asInstanceOf[JRecordParser].delimitedMode(delim.asJava.asInstanceOf[JBuffer])
  }

      def fixedSizeMode(size: Int):Unit = {
    asJava.asInstanceOf[JRecordParser].fixedSizeMode(size.asInstanceOf[java.lang.Integer])
  }

      def handle(buffer: Buffer):Unit = {
    asJava.asInstanceOf[JRecordParser].handle(buffer.asJava.asInstanceOf[JBuffer])
  }

//future methods
}

  object RecordParser{
    def apply(asJava: JRecordParser) = new RecordParser(asJava)  
  //static methods
    def newDelimited(delim: String,output: Handler[Buffer]):RecordParser = {
      RecordParser(JRecordParser.newDelimited(delim.asInstanceOf[java.lang.String],{x: JBuffer => output.handle(Buffer(x))}))
    }

    def newDelimited(delim: Buffer,output: Handler[Buffer]):RecordParser = {
      RecordParser(JRecordParser.newDelimited(delim.asJava.asInstanceOf[JBuffer],{x: JBuffer => output.handle(Buffer(x))}))
    }

    def newFixed(size: Int,output: Handler[Buffer]):RecordParser = {
      RecordParser(JRecordParser.newFixed(size.asInstanceOf[java.lang.Integer],{x: JBuffer => output.handle(Buffer(x))}))
    }

  }
