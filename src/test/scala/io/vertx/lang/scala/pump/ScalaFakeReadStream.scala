package io.vertx.lang.scala.pump

import io.vertx.core.Handler
import io.vertx.scala.core.streams.ReadStream

/**
  * Created by jochen on 13.07.16.
  */
class ScalaFakeReadStream[T] extends ReadStream[T] {


  override def asJava: AnyRef = ???

  var dataHandler:T => Unit = _
  var paused:Boolean = _
  var pauseCount:Int = 0
  var resumeCount:Int = 0

  def addData(data:T) = {
    if (dataHandler != null) {
      dataHandler(data)
    }
  }

  override def handler(handler: T => Unit): ScalaFakeReadStream[T] = {
    this.dataHandler = handler
    this
  }

  override def pause(): ScalaFakeReadStream[T] = {
    paused = true
    pauseCount += 1
    this
  }

  def pause(doneHandler: Handler[Void]): ScalaFakeReadStream[T] = {
    pause()
    doneHandler.handle(null)
    this
  }

  override def resume(): ScalaFakeReadStream[T] = {
    paused = false
    resumeCount += 1
    this
  }

  def resume(doneHandler: Handler[Void]): ScalaFakeReadStream[T] = {
    resume()
    doneHandler.handle(null)
    this
  }

  override def exceptionHandler(handler: Throwable => Unit ): ScalaFakeReadStream[T] = {
    this
  }

  override def endHandler(endHandler: () => Unit): ScalaFakeReadStream[T] = {
    this
  }
}
