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

package io.vertx.scala.core.http

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.Pipe
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.lang.scala.HandlerOps._

/**
  * Base WebSocket implementation.
  * 
  * It implements both  and  so it can be used with
  * [[io.vertx.scala.core.streams.Pipe]] to pipe data with flow control.
  */

trait WebSocketBase extends ReadStream[io.vertx.core.buffer.Buffer]with WriteStream[io.vertx.core.buffer.Buffer] {
  def asJava: java.lang.Object

    /**
   * Same as [[io.vertx.scala.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
   */
override def end ( t: io.vertx.core.buffer.Buffer): Unit    /**
   * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.WebSocketBase#setWriteQueueMaxSize]]   * @return true if write queue is full
   */
override def writeQueueFull ( ): Boolean    /**
   * Pause this stream and return a  to transfer the elements of this stream to a destination .
   * <p/>
   * The stream will be resumed when the pipe will be wired to a `WriteStream`.   * @return a pipe
   */
override def pipe ( ): Pipe[io.vertx.core.buffer.Buffer]    /**
   * Like [[io.vertx.scala.core.streams.ReadStream#pipeTo]] but with no completion handler.
   */
override def pipeTo ( dst: WriteStream[io.vertx.core.buffer.Buffer]): Unit    /**
   * Pipe this `ReadStream` to the `WriteStream`.
   * 
   * Elements emitted by this stream will be written to the write stream until this stream ends or fails.
   * 
   * Once this stream has ended or failed, the write stream will be ended and the `handler` will be
   * called with the result.   * @param dst the destination write stream
   */
override def pipeTo ( dst: WriteStream[io.vertx.core.buffer.Buffer], handler: Handler[AsyncResult[Unit]]): Unit  
override def exceptionHandler ( handler: Handler[Throwable]): WebSocketBase  
override def handler ( handler: Handler[io.vertx.core.buffer.Buffer]): WebSocketBase  
override def pause ( ): WebSocketBase  
override def resume ( ): WebSocketBase  
override def fetch ( amount: Long): WebSocketBase  
override def endHandler ( endHandler: Handler[Unit]): WebSocketBase  
override def write ( data: io.vertx.core.buffer.Buffer): WebSocketBase  
override def setWriteQueueMaxSize ( maxSize: Int): WebSocketBase  
override def drainHandler ( handler: Handler[Unit]): WebSocketBase    /**
   * When a `WebSocket` is created it automatically registers an event handler with the event bus - the ID of that
   * handler is given by this method.
   * 
   * Given this ID, a different event loop can send a binary frame to that event handler using the event bus and
   * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
   * allows you to write data to other WebSockets which are owned by different event loops.   * @return the binary handler id
   */
def binaryHandlerID ( ): String    /**
   * When a `WebSocket` is created it automatically registers an event handler with the eventbus, the ID of that
   * handler is given by `textHandlerID`.
   * 
   * Given this ID, a different event loop can send a text frame to that event handler using the event bus and
   * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
   * allows you to write data to other WebSockets which are owned by different event loops.
   */
def textHandlerID ( ): String    /**
   * Returns the WebSocket sub protocol selected by the WebSocket handshake.
   * <p/>
   * On the server, the value will be `null` when the handler receives the websocket callback as the
   * handshake will not be completed yet.
   */
def subProtocol ( ): String    /**
   * Write a WebSocket frame to the connection   * @param frame the frame to write
   * @return a reference to this, so the API can be used fluently
   */
def writeFrame ( frame: WebSocketFrame): WebSocketBase    /**
   * Write a final WebSocket text frame to the connection   * @param text The text to write
   * @return a reference to this, so the API can be used fluently
   */
def writeFinalTextFrame ( text: String): WebSocketBase    /**
   * Write a final WebSocket binary frame to the connection   * @param data The data to write
   * @return a reference to this, so the API can be used fluently
   */
def writeFinalBinaryFrame ( data: io.vertx.core.buffer.Buffer): WebSocketBase    /**
   * Writes a (potentially large) piece of binary data to the connection. This data might be written as multiple frames
   * if it exceeds the maximum WebSocket frame size.   * @param data the data to write
   * @return a reference to this, so the API can be used fluently
   */
def writeBinaryMessage ( data: io.vertx.core.buffer.Buffer): WebSocketBase    /**
   * Writes a (potentially large) piece of text data to the connection. This data might be written as multiple frames
   * if it exceeds the maximum WebSocket frame size.   * @param text the data to write
   * @return a reference to this, so the API can be used fluently
   */
def writeTextMessage ( text: String): WebSocketBase    /**
   * Writes a ping frame to the connection. This will be written in a single frame. Ping frames may be at most 125 bytes (octets).
   * 
   * This method should not be used to write application data and should only be used for implementing a keep alive or
   * to ensure the client is still responsive, see RFC 6455 Section <a href="https://tools.ietf.org/html/rfc6455#section-5.5.2">section 5.5.2</a>.
   * 
   * There is no handler for ping frames because RFC 6455  clearly
   * states that the only response to a ping frame is a pong frame with identical contents.   * @param data the data to write, may be at most 125 bytes
   * @return a reference to this, so the API can be used fluently
   */
def writePing ( data: io.vertx.core.buffer.Buffer): WebSocketBase    /**
   * Writes a pong frame to the connection. This will be written in a single frame. Pong frames may be at most 125 bytes (octets).
   * 
   * This method should not be used to write application data and should only be used for implementing a keep alive or
   * to ensure the client is still responsive, see RFC 6455 <a href="https://tools.ietf.org/html/rfc6455#section-5.5.2">section 5.5.2</a>.
   * 
   * There is no need to manually write a pong frame, as the server and client both handle responding to a ping from with a pong from
   * automatically and this is exposed to users. RFC 6455 <a href="https://tools.ietf.org/html/rfc6455#section-5.5.3">section 5.5.3</a> states that pongs may be sent unsolicited in order
   * to implement a one way heartbeat.   * @param data the data to write, may be at most 125 bytes
   * @return a reference to this, so the API can be used fluently
   */
def writePong ( data: io.vertx.core.buffer.Buffer): WebSocketBase    /**
   * Set a close handler. This will be called when the WebSocket is closed.
   * <p/>
   * After this callback, no more messages are expected.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
def closeHandler ( handler: Handler[Unit]): WebSocketBase    /**
   * Set a frame handler on the connection. This handler will be called when frames are read on the connection.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
def frameHandler ( handler: Handler[WebSocketFrame]): WebSocketBase    /**
   * Set a text message handler on the connection. This handler will be called similar to the
   * , but the buffer will be converted to a String first   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
def textMessageHandler ( handler: Handler[String]): WebSocketBase    /**
   * Set a binary message handler on the connection. This handler serves a similar purpose to [[io.vertx.scala.core.http.WebSocketBase#handler]]
   * except that if a message comes into the socket in multiple frames, the data from the frames will be aggregated
   * into a single buffer before calling the handler (using [[io.vertx.scala.core.http.WebSocketFrame#isFinal]] to find the boundaries).   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
def binaryMessageHandler ( handler: Handler[io.vertx.core.buffer.Buffer]): WebSocketBase    /**
   * Set a pong frame handler on the connection.  This handler will be invoked every time a pong frame is received
   * on the server, and can be used by both clients and servers since the RFC 6455 <a href="https://tools.ietf.org/html/rfc6455#section-5.5.2">section 5.5.2</a> and <a href="https://tools.ietf.org/html/rfc6455#section-5.5.3">section 5.5.3</a> do not
   * specify whether the client or server sends a ping.
   * 
   * Pong frames may be at most 125 bytes (octets).
   * 
   * There is no ping handler since ping frames should immediately be responded to with a pong frame with identical content
   * 
   * Pong frames may be received unsolicited.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
def pongHandler ( handler: Handler[io.vertx.core.buffer.Buffer]): WebSocketBase    /**
   * Calls [[io.vertx.scala.core.http.WebSocketBase#close]]
   */
override def end ( ): Unit    /**
   * Close the WebSocket sending the default close frame.
   * <p/>
   * No more messages can be sent.
   */
def close ( ): Unit    /**
   * Close the WebSocket sending a close frame with specified status code. You can give a look at various close payloads
   * here: RFC6455 <a href="https://tools.ietf.org/html/rfc6455#section-7.4.1">section 7.4.1</a>
   * <p/>
   * No more messages can be sent.   * @param statusCode Status code
   */
def close ( statusCode: Short): Unit    /**
   * Close sending a close frame with specified status code and reason. You can give a look at various close payloads
   * here: RFC6455 <a href="https://tools.ietf.org/html/rfc6455#section-7.4.1">section 7.4.1</a>
   * <p/>
   * No more messages can be sent.   * @param statusCode Status code
   * @param reason reason of closure
   */
def close ( statusCode: Short, reason: scala.Option[String]): Unit    /**
   * @return the remote address for this socket
   */
def remoteAddress ( ): SocketAddress    /**
   * @return the local address for this socket
   */
def localAddress ( ): SocketAddress    /**
   * @return true if this io.vertx.scala.core.http.HttpConnection is encrypted via SSL/TLS.
   */
def isSsl ( ): Boolean

   /**
  * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
override def pipeToFuture ( dst: WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit]
}

object WebSocketBase {
  def apply(asJava: JWebSocketBase): WebSocketBase = new WebSocketBaseImpl(asJava)
    private class WebSocketBaseImpl(private val _asJava: Object) extends WebSocketBase {
  def asJava = _asJava
  private var cached_0: Option[SocketAddress] = None
  private var cached_1: Option[SocketAddress] = None


  /**
   * @return the remote address for this socket
   */
  def remoteAddress(): SocketAddress = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JWebSocketBase].remoteAddress()
      cached_0 = Some(SocketAddress(tmp))
    }
    cached_0.get
  }

  /**
   * @return the local address for this socket
   */
  def localAddress(): SocketAddress = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JWebSocketBase].localAddress()
      cached_1 = Some(SocketAddress(tmp))
    }
    cached_1.get
  }



  override 
  def exceptionHandler(handler: Handler[Throwable]): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }


  override 
  def handler(handler: Handler[io.vertx.core.buffer.Buffer]): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].handler({x: Buffer => handler.handle(x)})
    this
  }


  override 
  def pause(): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].pause()
    this
  }


  override 
  def resume(): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].resume()
    this
  }


  override 
  def fetch(amount: Long): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].fetch(amount.asInstanceOf[java.lang.Long])
    this
  }


  override 
  def endHandler(endHandler: Handler[Unit]): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].endHandler({x: Void => endHandler.handle(x)})
    this
  }


  override 
  def write(data: io.vertx.core.buffer.Buffer): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].write(data)
    this
  }


  override 
  def setWriteQueueMaxSize(maxSize: Int): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }


  override 
  def drainHandler(handler: Handler[Unit]): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].drainHandler({x: Void => handler.handle(x)})
    this
  }

  /**
   * Write a WebSocket frame to the connection   * @param frame the frame to write
   * @return a reference to this, so the API can be used fluently
   */
  
  def writeFrame(frame: WebSocketFrame): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeFrame(frame.asJava.asInstanceOf[JWebSocketFrame])
    this
  }

  /**
   * Write a final WebSocket text frame to the connection   * @param text The text to write
   * @return a reference to this, so the API can be used fluently
   */
  
  def writeFinalTextFrame(text: String): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeFinalTextFrame(text.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Write a final WebSocket binary frame to the connection   * @param data The data to write
   * @return a reference to this, so the API can be used fluently
   */
  
  def writeFinalBinaryFrame(data: io.vertx.core.buffer.Buffer): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeFinalBinaryFrame(data)
    this
  }

  /**
   * Writes a (potentially large) piece of binary data to the connection. This data might be written as multiple frames
   * if it exceeds the maximum WebSocket frame size.   * @param data the data to write
   * @return a reference to this, so the API can be used fluently
   */
  
  def writeBinaryMessage(data: io.vertx.core.buffer.Buffer): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeBinaryMessage(data)
    this
  }

  /**
   * Writes a (potentially large) piece of text data to the connection. This data might be written as multiple frames
   * if it exceeds the maximum WebSocket frame size.   * @param text the data to write
   * @return a reference to this, so the API can be used fluently
   */
  
  def writeTextMessage(text: String): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeTextMessage(text.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Writes a ping frame to the connection. This will be written in a single frame. Ping frames may be at most 125 bytes (octets).
   * 
   * This method should not be used to write application data and should only be used for implementing a keep alive or
   * to ensure the client is still responsive, see RFC 6455 Section <a href="https://tools.ietf.org/html/rfc6455#section-5.5.2">section 5.5.2</a>.
   * 
   * There is no handler for ping frames because RFC 6455  clearly
   * states that the only response to a ping frame is a pong frame with identical contents.   * @param data the data to write, may be at most 125 bytes
   * @return a reference to this, so the API can be used fluently
   */
  
  def writePing(data: io.vertx.core.buffer.Buffer): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writePing(data)
    this
  }

  /**
   * Writes a pong frame to the connection. This will be written in a single frame. Pong frames may be at most 125 bytes (octets).
   * 
   * This method should not be used to write application data and should only be used for implementing a keep alive or
   * to ensure the client is still responsive, see RFC 6455 <a href="https://tools.ietf.org/html/rfc6455#section-5.5.2">section 5.5.2</a>.
   * 
   * There is no need to manually write a pong frame, as the server and client both handle responding to a ping from with a pong from
   * automatically and this is exposed to users. RFC 6455 <a href="https://tools.ietf.org/html/rfc6455#section-5.5.3">section 5.5.3</a> states that pongs may be sent unsolicited in order
   * to implement a one way heartbeat.   * @param data the data to write, may be at most 125 bytes
   * @return a reference to this, so the API can be used fluently
   */
  
  def writePong(data: io.vertx.core.buffer.Buffer): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writePong(data)
    this
  }

  /**
   * Set a close handler. This will be called when the WebSocket is closed.
   * <p/>
   * After this callback, no more messages are expected.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def closeHandler(handler: Handler[Unit]): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].closeHandler({x: Void => handler.handle(x)})
    this
  }

  /**
   * Set a frame handler on the connection. This handler will be called when frames are read on the connection.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def frameHandler(handler: Handler[WebSocketFrame]): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].frameHandler({x: JWebSocketFrame => handler.handle(WebSocketFrame(x))})
    this
  }

  /**
   * Set a text message handler on the connection. This handler will be called similar to the
   * , but the buffer will be converted to a String first   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def textMessageHandler(handler: Handler[String]): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].textMessageHandler({x: java.lang.String => handler.handle(x.asInstanceOf[String])})
    this
  }

  /**
   * Set a binary message handler on the connection. This handler serves a similar purpose to [[io.vertx.scala.core.http.WebSocketBase#handler]]
   * except that if a message comes into the socket in multiple frames, the data from the frames will be aggregated
   * into a single buffer before calling the handler (using [[io.vertx.scala.core.http.WebSocketFrame#isFinal]] to find the boundaries).   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def binaryMessageHandler(handler: Handler[io.vertx.core.buffer.Buffer]): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].binaryMessageHandler({x: Buffer => handler.handle(x)})
    this
  }

  /**
   * Set a pong frame handler on the connection.  This handler will be invoked every time a pong frame is received
   * on the server, and can be used by both clients and servers since the RFC 6455 <a href="https://tools.ietf.org/html/rfc6455#section-5.5.2">section 5.5.2</a> and <a href="https://tools.ietf.org/html/rfc6455#section-5.5.3">section 5.5.3</a> do not
   * specify whether the client or server sends a ping.
   * 
   * Pong frames may be at most 125 bytes (octets).
   * 
   * There is no ping handler since ping frames should immediately be responded to with a pong frame with identical content
   * 
   * Pong frames may be received unsolicited.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def pongHandler(handler: Handler[io.vertx.core.buffer.Buffer]): WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].pongHandler({x: Buffer => handler.handle(x)})
    this
  }


  /**
   * Same as [[io.vertx.scala.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
   */
  override def end(t: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JWebSocketBase].end(t)
  }

  /**
   * Pause this stream and return a  to transfer the elements of this stream to a destination .
   * <p/>
   * The stream will be resumed when the pipe will be wired to a `WriteStream`.   * @return a pipe
   */
  override def pipe(): Pipe[io.vertx.core.buffer.Buffer] = {
    Pipe[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebSocketBase].pipe())
  }

  /**
   * Like [[io.vertx.scala.core.streams.ReadStream#pipeTo]] but with no completion handler.
   */
  override def pipeTo(dst: WriteStream[io.vertx.core.buffer.Buffer]): Unit = {
    asJava.asInstanceOf[JWebSocketBase].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]])
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
    asJava.asInstanceOf[JWebSocketBase].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]], {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }


  /**
   * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.WebSocketBase#setWriteQueueMaxSize]]   * @return true if write queue is full
   */
  override def writeQueueFull (): Boolean = {
    asJava.asInstanceOf[JWebSocketBase].writeQueueFull().asInstanceOf[Boolean]
  }

  /**
   * When a `WebSocket` is created it automatically registers an event handler with the event bus - the ID of that
   * handler is given by this method.
   * 
   * Given this ID, a different event loop can send a binary frame to that event handler using the event bus and
   * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
   * allows you to write data to other WebSockets which are owned by different event loops.   * @return the binary handler id
   */
  def binaryHandlerID (): String = {
    asJava.asInstanceOf[JWebSocketBase].binaryHandlerID().asInstanceOf[String]
  }

  /**
   * When a `WebSocket` is created it automatically registers an event handler with the eventbus, the ID of that
   * handler is given by `textHandlerID`.
   * 
   * Given this ID, a different event loop can send a text frame to that event handler using the event bus and
   * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
   * allows you to write data to other WebSockets which are owned by different event loops.
   */
  def textHandlerID (): String = {
    asJava.asInstanceOf[JWebSocketBase].textHandlerID().asInstanceOf[String]
  }

  /**
   * Returns the WebSocket sub protocol selected by the WebSocket handshake.
   * <p/>
   * On the server, the value will be `null` when the handler receives the websocket callback as the
   * handshake will not be completed yet.
   */
  def subProtocol (): String = {
    asJava.asInstanceOf[JWebSocketBase].subProtocol().asInstanceOf[String]
  }

  /**
   * Calls [[io.vertx.scala.core.http.WebSocketBase#close]]
   */
  override def end (): Unit = {
    asJava.asInstanceOf[JWebSocketBase].end()
  }

  /**
   * Close the WebSocket sending the default close frame.
   * <p/>
   * No more messages can be sent.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JWebSocketBase].close()
  }

  /**
   * Close the WebSocket sending a close frame with specified status code. You can give a look at various close payloads
   * here: RFC6455 <a href="https://tools.ietf.org/html/rfc6455#section-7.4.1">section 7.4.1</a>
   * <p/>
   * No more messages can be sent.   * @param statusCode Status code
   */
  def close (statusCode: Short): Unit = {
    asJava.asInstanceOf[JWebSocketBase].close(statusCode.asInstanceOf[java.lang.Short])
  }

  /**
   * Close sending a close frame with specified status code and reason. You can give a look at various close payloads
   * here: RFC6455 <a href="https://tools.ietf.org/html/rfc6455#section-7.4.1">section 7.4.1</a>
   * <p/>
   * No more messages can be sent.   * @param statusCode Status code
   * @param reason reason of closure
   */
  def close (statusCode: Short, reason: scala.Option[String]): Unit = {
    asJava.asInstanceOf[JWebSocketBase].close(statusCode.asInstanceOf[java.lang.Short], reason.map(x => x.asInstanceOf[java.lang.String]).orNull)
  }

  /**
   * @return true if this io.vertx.scala.core.http.HttpConnection is encrypted via SSL/TLS.
   */
  def isSsl (): Boolean = {
    asJava.asInstanceOf[JWebSocketBase].isSsl().asInstanceOf[Boolean]
  }


 /**
  * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def pipeToFuture (dst: WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JWebSocketBase].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}
}
