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

package io.vertx.scala.kafka.client.producer

import io.vertx.lang.scala.AsyncResultWrapper
import scala.reflect.runtime.universe._
import io.vertx.kafka.client.producer.{KafkaProducer => JKafkaProducer}
import scala.collection.JavaConverters._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.kafka.client.common.PartitionInfo
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.WriteStream
import io.vertx.kafka.client.common.{PartitionInfo => JPartitionInfo}
import io.vertx.kafka.client.producer.{RecordMetadata => JRecordMetadata}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.kafka.client.producer.{KafkaProducerRecord => JKafkaProducerRecord}
import io.vertx.lang.scala.HandlerOps._

/**
  * Vert.x Kafka producer.
  * 
  * The  provides global control over writing a record.

  */

class KafkaProducer[K: TypeTag, V: TypeTag](private val _asJava: Object) extends WriteStream[KafkaProducerRecord[K, V]] {
  def asJava = _asJava




  override 
  def exceptionHandler(handler: Handler[Throwable]): KafkaProducer[K, V] = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }


  override 
  def write(kafkaProducerRecord: KafkaProducerRecord[K, V]): KafkaProducer[K, V] = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].write(kafkaProducerRecord.asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]])
    this
  }


  override 
  def setWriteQueueMaxSize(i: Int): KafkaProducer[K, V] = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].setWriteQueueMaxSize(i.asInstanceOf[java.lang.Integer])
    this
  }


  override 
  def drainHandler(handler: Handler[Unit]): KafkaProducer[K, V] = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].drainHandler({x: Void => handler.handle(x)})
    this
  }


  override 
  def write(data: KafkaProducerRecord[K, V], handler: Handler[AsyncResult[Unit]]): KafkaProducer[K, V] = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].write(data.asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]], {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Asynchronously write a record to a topic   * @param record record to write
   * @return current KafkaWriteStream instance
   */
  
  def send(record: KafkaProducerRecord[K, V]): KafkaProducer[K, V] = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].send(record.asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]])
    this
  }

  /**
   * Asynchronously write a record to a topic   * @param record record to write
   * @param handler handler called on operation completed
   * @return current KafkaWriteStream instance
   */
  
  def send(record: KafkaProducerRecord[K, V], handler: Handler[AsyncResult[RecordMetadata]]): KafkaProducer[K, V] = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].send(record.asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]], {x: AsyncResult[JRecordMetadata] => handler.handle(AsyncResultWrapper[JRecordMetadata, RecordMetadata](x, a => RecordMetadata(a)))})
    this
  }

  /**
   * Get the partition metadata for the give topic.   * @param topic topic partition for which getting partitions info
   * @param handler handler called on operation completed
   * @return current KafkaProducer instance
   */
  
  def partitionsFor(topic: String, handler: Handler[AsyncResult[scala.collection.mutable.Buffer[PartitionInfo]]]): KafkaProducer[K, V] = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].partitionsFor(topic.asInstanceOf[java.lang.String], {x: AsyncResult[java.util.List[JPartitionInfo]] => handler.handle(AsyncResultWrapper[java.util.List[JPartitionInfo], scala.collection.mutable.Buffer[PartitionInfo]](x, a => a.asScala.map(x => PartitionInfo(x))))})
    this
  }

  /**
   * Invoking this method makes all buffered records immediately available to write   * @param completionHandler handler called on operation completed
   * @return current KafkaProducer instance
   */
  
  def flush(completionHandler: Handler[Unit]): KafkaProducer[K, V] = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].flush({x: Void => completionHandler.handle(x)})
    this
  }



  override def end(data: KafkaProducerRecord[K, V]): Unit = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].end(data.asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]])
  }


  override def end(data: KafkaProducerRecord[K, V], handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].end(data.asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]], {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }



  override def end (): Unit = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].end()
  }


  override def end (arg0: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].end({x: AsyncResult[Void] => arg0.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }


  override def writeQueueFull (): Boolean = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].writeQueueFull().asInstanceOf[Boolean]
  }

  /**
   * Close the producer
   */
  def close (): Unit = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].close()
  }

  /**
   * Close the producer   * @param completionHandler handler called on operation completed
   */
  def close (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].close({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Close the producer   * @param timeout timeout to wait for closing
   * @param completionHandler handler called on operation completed
   */
  def close (timeout: Long, completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].close(timeout.asInstanceOf[java.lang.Long], {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }



  override def endFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].end(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def endFuture (data: KafkaProducerRecord[K, V]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].end(data.asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def writeFuture (data: KafkaProducerRecord[K, V]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].write(data.asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFuture (record: KafkaProducerRecord[K, V]): scala.concurrent.Future[RecordMetadata] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRecordMetadata, RecordMetadata](x => RecordMetadata(x))
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].send(record.asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[partitionsFor]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def partitionsForFuture (topic: String): scala.concurrent.Future[scala.collection.mutable.Buffer[PartitionInfo]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JPartitionInfo], scala.collection.mutable.Buffer[PartitionInfo]](x => x.asScala.map(x => PartitionInfo(x)))
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].partitionsFor(topic.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (timeout: Long): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaProducer[Object, Object]].close(timeout.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object KafkaProducer {
  def apply[K: TypeTag, V: TypeTag](asJava: JKafkaProducer[_, _]) = new KafkaProducer[K, V](asJava)
  
  /**
   * Get or create a KafkaProducer instance which shares its stream with any other KafkaProducer created with the same `name`   * @param vertx Vert.x instance to use
   * @param name the producer name to identify it
   * @param config Kafka producer configuration
   * @return an instance of the KafkaProducer
   */
  def createShared[K: TypeTag, V: TypeTag](vertx: Vertx,name: String,config: scala.collection.mutable.Map[String, String]): KafkaProducer[K, V] = {
    KafkaProducer[K, V](JKafkaProducer.createShared[Object, Object](vertx.asJava.asInstanceOf[JVertx], name.asInstanceOf[java.lang.String], config.mapValues(x => x.asInstanceOf[java.lang.String]).asJava))
  }

  /**
   * Get or create a KafkaProducer instance which shares its stream with any other KafkaProducer created with the same `name`   * @param vertx Vert.x instance to use
   * @param name the producer name to identify it
   * @param config Kafka producer configuration
   * @param keyType class type for the key serialization
   * @param valueType class type for the value serialization
   * @return an instance of the KafkaProducer
   */
  def createShared[K: TypeTag, V: TypeTag](vertx: Vertx,name: String,config: scala.collection.mutable.Map[String, String],keyType: Class[K],valueType: Class[V]): KafkaProducer[K, V] = {
    KafkaProducer[K, V](JKafkaProducer.createShared[Object, Object](vertx.asJava.asInstanceOf[JVertx], name.asInstanceOf[java.lang.String], config.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, toJavaClass(keyType), toJavaClass(valueType)))
  }

  /**
   * Create a new KafkaProducer instance   * @param vertx Vert.x instance to use
   * @param config Kafka producer configuration
   * @return an instance of the KafkaProducer
   */
  def create[K: TypeTag, V: TypeTag](vertx: Vertx,config: scala.collection.mutable.Map[String, String]): KafkaProducer[K, V] = {
    KafkaProducer[K, V](JKafkaProducer.create[Object, Object](vertx.asJava.asInstanceOf[JVertx], config.mapValues(x => x.asInstanceOf[java.lang.String]).asJava))
  }

  /**
   * Create a new KafkaProducer instance   * @param vertx Vert.x instance to use
   * @param config Kafka producer configuration
   * @param keyType class type for the key serialization
   * @param valueType class type for the value serialization
   * @return an instance of the KafkaProducer
   */
  def create[K: TypeTag, V: TypeTag](vertx: Vertx,config: scala.collection.mutable.Map[String, String],keyType: Class[K],valueType: Class[V]): KafkaProducer[K, V] = {
    KafkaProducer[K, V](JKafkaProducer.create[Object, Object](vertx.asJava.asInstanceOf[JVertx], config.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, toJavaClass(keyType), toJavaClass(valueType)))
  }

}
