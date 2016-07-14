package io.vertx.lang.scala.pump

import io.vertx.core.Handler
import io.vertx.core.streams.ReadStream

/**
  * Created by jochen on 13.07.16.
  */
class JavaFakeReadStream[T] extends ReadStream[T] {

  var dataHandler:Handler[T] = _
  var paused:Boolean = false
  var pauseCount:Int = 0
  var resumeCount:Int = 0

  def addData(data:T) = {
    if (dataHandler != null) {
      dataHandler.handle(data)
    }
  }

  override def handler(handler: Handler[T]): JavaFakeReadStream[T] = {
    this.dataHandler = handler
    this
  }

  override def pause(): JavaFakeReadStream[T] = {
    paused = true
    pauseCount += 1
    this
  }

  def pause(doneHandler: Handler[Void]): JavaFakeReadStream[T] = {
    pause()
    doneHandler.handle(null)
    this
  }

  override def resume(): JavaFakeReadStream[T] = {
    paused = false
    resumeCount += 1
    this
  }

  def resume(doneHandler: Handler[Void]): JavaFakeReadStream[T] = {
    resume()
    doneHandler.handle(null)
    this
  }

  override def exceptionHandler(handler: Handler[Throwable] ): JavaFakeReadStream[T] = {
    this
  }

  override def endHandler(endHandler: Handler[Void]): JavaFakeReadStream[T] = {
    this
  }
}
