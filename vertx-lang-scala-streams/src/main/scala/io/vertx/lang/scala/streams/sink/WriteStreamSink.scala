package io.vertx.lang.scala.streams.sink

import io.vertx.lang.scala.streams.api.SimpleSink
import io.vertx.scala.core.streams.WriteStream

import scala.collection.mutable

/**
  * This [[io.vertx.lang.scala.streams.api.Sink]]-implementation takes a [[WriteStream]] for processing incoming events.
  * The Vert.x-API produces these in many places (including the Event Bus).
  *
  * @param ws the Stream to start from
  * @param _batchSize size of batches that should be processed
  * @tparam I type of incoming events
  */
class WriteStreamSink[I](ws: WriteStream[I], _batchSize: Long = 10) extends SimpleSink[I]{

  private var paused = false
  private val overflow = mutable.Queue[I]()

  override def batchSize: Long = 10

  override def next(event: I): Unit = {
    if(!ws.writeQueueFull())
      ws.write(event)
    else {
      if(!paused) {
        paused = true
        ws.drainHandler(_ => drain())
      }
      overflow += event
    }
  }

  def drain(): Unit = {
    while(!ws.writeQueueFull()) {
      ws.write(overflow.dequeue())
    }
    if(ws.writeQueueFull()) {
      ws.drainHandler(_ => drain())
    }
    else {
      subscription.request(batchSize)
    }
  }
}
