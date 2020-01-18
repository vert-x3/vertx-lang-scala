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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.Pipe
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.Buffer
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.core.parsetools.{RecordParser => JRecordParser}
import io.vertx.lang.scala.HandlerOps._

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

class RecordParser(private val _asJava: Object) extends ReadStream[io.vertx.core.buffer.Buffer] with io.vertx.core.Handler[io.vertx.core.buffer.Buffer] {
  def asJava = _asJava



  /**
   * Set the maximum allowed size for a record when using the delimited mode.
   * The delimiter itself does not count for the record size.
   * 
   * If a record is longer than specified, an IllegalStateException will be thrown.   * @param size the maximum record size
   * @return a reference to this, so the API can be used fluently
   */
  
  def maxRecordSize(size: Int): RecordParser = {
    asJava.asInstanceOf[JRecordParser].maxRecordSize(size.asInstanceOf[java.lang.Integer])
    this
  }


  override 
  def exceptionHandler(handler: Handler[Throwable]): RecordParser = {
    asJava.asInstanceOf[JRecordParser].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }


  override 
  def handler(handler: Handler[io.vertx.core.buffer.Buffer]): RecordParser = {
    asJava.asInstanceOf[JRecordParser].handler((if (handler == null) null else new io.vertx.core.Handler[Buffer]{def handle(x: Buffer) {handler.handle(x)}}))
    this
  }


  override 
  def pause(): RecordParser = {
    asJava.asInstanceOf[JRecordParser].pause()
    this
  }


  override 
  def fetch(amount: Long): RecordParser = {
    asJava.asInstanceOf[JRecordParser].fetch(amount.asInstanceOf[java.lang.Long])
    this
  }


  override 
  def resume(): RecordParser = {
    asJava.asInstanceOf[JRecordParser].resume()
    this
  }


  override 
  def endHandler(endHandler: Handler[Unit]): RecordParser = {
    asJava.asInstanceOf[JRecordParser].endHandler((if (endHandler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {endHandler.handle(x)}}))
    this
  }


  /**
   * Pause this stream and return a  to transfer the elements of this stream to a destination .
   * <p/>
   * The stream will be resumed when the pipe will be wired to a `WriteStream`.   * @return a pipe
   */
  override def pipe(): Pipe[io.vertx.core.buffer.Buffer] = {
    Pipe[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JRecordParser].pipe())
  }

  /**
   * Like [[io.vertx.scala.core.streams.ReadStream#pipeTo]] but with no completion handler.
   */
  override def pipeTo(dst: WriteStream[io.vertx.core.buffer.Buffer]): Unit = {
    asJava.asInstanceOf[JRecordParser].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]])
  }

  /**
   * Pipe this `ReadStream` to the `WriteStream`.
   * 
   * Elements emitted by this stream will be written to the write stream until this stream ends or fails.
   * 
   * Once this stream has ended or failed, the write stream will be ended and the `handler` will be
   * called with the result.   * @param dst the destination write stream
   */
  override def pipeTo(dst: WriteStream[io.vertx.core.buffer.Buffer], handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRecordParser].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }



  def setOutput (output: Handler[io.vertx.core.buffer.Buffer]): Unit = {
    asJava.asInstanceOf[JRecordParser].setOutput((if (output == null) null else new io.vertx.core.Handler[Buffer]{def handle(x: Buffer) {output.handle(x)}}))
  }

  /**
   * Flip the parser into delimited mode, and where the delimiter can be represented
   * by the String `delim` encoded in latin-1 . Don't use this if your String contains other than latin-1 characters.
   * 
   * This method can be called multiple times with different values of delim while data is being parsed.   * @param delim the new delimeter
   */
  def delimitedMode (delim: String): Unit = {
    asJava.asInstanceOf[JRecordParser].delimitedMode(delim.asInstanceOf[java.lang.String])
  }

  /**
   * Flip the parser into delimited mode, and where the delimiter can be represented
   * by the delimiter `delim`.
   * 
   * This method can be called multiple times with different values of delim while data is being parsed.   * @param delim the new delimiter
   */
  def delimitedMode (delim: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JRecordParser].delimitedMode(delim)
  }

  /**
   * Flip the parser into fixed size mode, where the record size is specified by `size` in bytes.
   * 
   * This method can be called multiple times with different values of size while data is being parsed.   * @param size the new record size
   */
  def fixedSizeMode (size: Int): Unit = {
    asJava.asInstanceOf[JRecordParser].fixedSizeMode(size.asInstanceOf[java.lang.Integer])
  }

  /**
   * This method is called to provide the parser with data.   * @param buffer a chunk of data
   */
  def handle (buffer: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JRecordParser].handle(buffer)
  }


 /**
  * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def pipeToFuture (dst: WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRecordParser].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object RecordParser {
  def apply(asJava: JRecordParser) = new RecordParser(asJava)

  /**
   * Like [[io.vertx.scala.core.parsetools.RecordParser#newDelimited]] but set the `output` that will receive whole records
   * which have been parsed.   * @param delim the initial delimiter string
   * @param output handler that will receive the output
   */
  def newDelimited(delim: String,output: Handler[io.vertx.core.buffer.Buffer]): RecordParser = {
    RecordParser(JRecordParser.newDelimited(delim.asInstanceOf[java.lang.String], (if (output == null) null else new io.vertx.core.Handler[Buffer]{def handle(x: Buffer) {output.handle(x)}})))//2 newDelimited
  }

  /**
   * Like [[io.vertx.scala.core.parsetools.RecordParser#newDelimited]] but wraps the `stream`. The `stream` handlers will be set/unset
   * when the [[io.vertx.scala.core.parsetools.RecordParser#handler]] is set.
   * <p/>
   * The `pause()`/`resume()` operations are propagated to the `stream`.   * @param delim the initial delimiter string
   * @param stream the wrapped stream
   */
  def newDelimited(delim: String,stream: ReadStream[io.vertx.core.buffer.Buffer]): RecordParser = {
    RecordParser(JRecordParser.newDelimited(delim.asInstanceOf[java.lang.String], stream.asJava.asInstanceOf[JReadStream[Buffer]]))//2 newDelimited
  }

  /**
   * Create a new `RecordParser` instance, initially in delimited mode, and where the delimiter can be represented
   * by the String `` delim endcoded in latin-1 . Don't use this if your String contains other than latin-1 characters.
   * 
   * `output` Will receive whole records which have been parsed.   * @param delim the initial delimiter string
   */
  def newDelimited(delim: String): RecordParser = {
    RecordParser(JRecordParser.newDelimited(delim.asInstanceOf[java.lang.String]))//2 newDelimited
  }

  /**
   * Create a new `RecordParser` instance, initially in delimited mode, and where the delimiter can be represented
   * by the `Buffer` delim.
   *    * @param delim the initial delimiter buffer
   */
  def newDelimited(delim: io.vertx.core.buffer.Buffer): RecordParser = {
    RecordParser(JRecordParser.newDelimited(delim))//2 newDelimited
  }

  /**
   * Like [[io.vertx.scala.core.parsetools.RecordParser#newDelimited]] but set the `output` that will receive whole records
   * which have been parsed.   * @param delim the initial delimiter buffer
   * @param output handler that will receive the output
   */
  def newDelimited(delim: io.vertx.core.buffer.Buffer,output: Handler[io.vertx.core.buffer.Buffer]): RecordParser = {
    RecordParser(JRecordParser.newDelimited(delim, (if (output == null) null else new io.vertx.core.Handler[Buffer]{def handle(x: Buffer) {output.handle(x)}})))//2 newDelimited
  }

  /**
   * Like [[io.vertx.scala.core.parsetools.RecordParser#newDelimited]] but wraps the `stream`. The `stream` handlers will be set/unset
   * when the [[io.vertx.scala.core.parsetools.RecordParser#handler]] is set.
   * <p/>
   * The `pause()`/`resume()` operations are propagated to the `stream`.   * @param delim the initial delimiter buffer
   * @param stream the wrapped stream
   */
  def newDelimited(delim: io.vertx.core.buffer.Buffer,stream: ReadStream[io.vertx.core.buffer.Buffer]): RecordParser = {
    RecordParser(JRecordParser.newDelimited(delim, stream.asJava.asInstanceOf[JReadStream[Buffer]]))//2 newDelimited
  }

  /**
   * Create a new `RecordParser` instance, initially in fixed size mode, and where the record size is specified
   * by the `size` parameter.
   * 
   * `output` Will receive whole records which have been parsed.   * @param size the initial record size
   */
  def newFixed(size: Int): RecordParser = {
    RecordParser(JRecordParser.newFixed(size.asInstanceOf[java.lang.Integer]))//2 newFixed
  }

  /**
   * Like [[io.vertx.scala.core.parsetools.RecordParser#newFixed]] but set the `output` that will receive whole records
   * which have been parsed.   * @param size the initial record size
   * @param output handler that will receive the output
   */
  def newFixed(size: Int,output: Handler[io.vertx.core.buffer.Buffer]): RecordParser = {
    RecordParser(JRecordParser.newFixed(size.asInstanceOf[java.lang.Integer], (if (output == null) null else new io.vertx.core.Handler[Buffer]{def handle(x: Buffer) {output.handle(x)}})))//2 newFixed
  }

  /**
   * Like [[io.vertx.scala.core.parsetools.RecordParser#newFixed]] but wraps the `stream`. The `stream` handlers will be set/unset
   * when the [[io.vertx.scala.core.parsetools.RecordParser#handler]] is set.
   * <p/>
   * The `pause()`/`resume()` operations are propagated to the `stream`.   * @param size the initial record size
   * @param stream the wrapped stream
   */
  def newFixed(size: Int,stream: ReadStream[io.vertx.core.buffer.Buffer]): RecordParser = {
    RecordParser(JRecordParser.newFixed(size.asInstanceOf[java.lang.Integer], stream.asJava.asInstanceOf[JReadStream[Buffer]]))//2 newFixed
  }

}
