package io.vertx.lang.scala.pump

import java.util.ArrayList

import io.vertx.core.Handler
import io.vertx.scala.core.streams.WriteStream

/**
  * Created by jochen on 13.07.16.
  */
class ScalaFakeWriteStream[T] extends WriteStream[T] {



  override def asJava: AnyRef = ???

  override def end(t: T): Unit = ???

  var maxSize:Int = _
  var received = new ArrayList[T]()
  var drainHandler: () => Unit = _

  def clearReceived(): Unit = {
    val callDrain = writeQueueFull()
    received = new ArrayList()
    if (callDrain && drainHandler != null) {
      drainHandler(null)
    }
  }

  def setWriteQueueMaxSize(maxSize: Int) = {
    this.maxSize = maxSize
    this
  }

  override def writeQueueFull() = {
    received.size() >= maxSize
  }

  override def drainHandler(handler: () => Unit) = {
    drainHandler = handler
    this
  }

  override def write(data: T) = {
    received.add(data)
    this
  }

  override def exceptionHandler(handler: Throwable => Unit ) = {
    this
  }

  override def end() {}
}
