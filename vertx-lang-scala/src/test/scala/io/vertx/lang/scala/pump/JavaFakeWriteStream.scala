package io.vertx.lang.scala.pump

import java.util.ArrayList

import io.vertx.core.{AsyncResult, Handler, Promise}
import io.vertx.core.streams.WriteStream

/**
  * @author <a href="mailto:jochen@codepitbull.de">Jochen Mader</a
  */
class JavaFakeWriteStream[T] extends WriteStream[T] {

  var maxSize:Int = _
  var received = new ArrayList[T]()
  var drainHandler: Handler[Void] = _

  def clearReceived(): Unit = {
    val callDrain = writeQueueFull()
    received = new ArrayList()
    if (callDrain && drainHandler != null) {
      drainHandler.handle(null)
    }
  }

  def setWriteQueueMaxSize(maxSize: Int) = {
    this.maxSize = maxSize
    this
  }

  override def writeQueueFull() = {
    received.size() >= maxSize
  }

  override def drainHandler(handler: Handler[Void]) = {
    drainHandler = handler
    this
  }

  override def write(data: T) = {
    received.add(data)
    val promise = Promise.promise[Void]
    promise.complete()
    promise.future
  }

  override def exceptionHandler(handler: Handler[Throwable] ) = {
    this
  }

  override def write(data: T, handler: Handler[AsyncResult[Void]]): Unit = throw new RuntimeException("Not implemented")

  override def end(handler: Handler[AsyncResult[Void]]): Unit = throw new RuntimeException("Not implemented")


  override def end() = {
    val promise = Promise.promise[Void]
    promise.complete()
    promise.future
  }
}
