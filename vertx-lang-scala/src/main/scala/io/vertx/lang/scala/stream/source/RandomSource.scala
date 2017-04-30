package io.vertx.lang.scala.stream.source

import java.util.concurrent.atomic.AtomicLong

import io.vertx.lang.scala.stream.api.Source

import scala.util.Random

class RandomSource() extends Source[Long]{

  val tokens = new AtomicLong(0)

  val thr = new Thread() {
    val generator = new Random()
    override def run(): Unit = {
      while(!isInterrupted) {
        if(tokens.get() > 0) {
          sink.next(generator.nextLong())
          tokens.decrementAndGet()
        }
        Thread.sleep(100)
      }
    }
  }
  thr.start()

  override def cancel(): Unit = {
    tokens.set(0)
    thr.interrupt()
  }

  override def request(nr: Long): Unit = tokens.addAndGet(nr)

}

object RandomSource {
  def apply(): RandomSource = new RandomSource()
}
