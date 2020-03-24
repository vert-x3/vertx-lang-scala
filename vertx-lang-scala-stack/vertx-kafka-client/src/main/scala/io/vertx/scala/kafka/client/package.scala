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


package io.vertx.scala.kafka

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core.buffer.Buffer
import io.vertx.kafka.client.producer.{KafkaHeader => JKafkaHeader}
import io.vertx.kafka.client.producer.{KafkaProducerRecord => JKafkaProducerRecord}
package object client{


  type ConfigResource = io.vertx.kafka.client.common.ConfigResource
  object ConfigResource {
    def apply() = new ConfigResource()
    def apply(json: JsonObject) = new ConfigResource(json)
  }




  /**
    * Vert.x Kafka consumer.
    * 
    * You receive Kafka records by providing a [[io.vertx.kafka.client.consumer.KafkaConsumer#handler]]. As messages arrive the handler
    * will be called with the records.
    * 
    * The [[io.vertx.kafka.client.consumer.KafkaConsumer#pause]] and [[io.vertx.kafka.client.consumer.KafkaConsumer#resume]] provides global control over reading the records from the consumer.
    * 
    * The [[io.vertx.kafka.client.consumer.KafkaConsumer#pause]] and [[io.vertx.kafka.client.consumer.KafkaConsumer#resume]] provides finer grained control over reading records
    * for specific Topic/Partition, these are Kafka's specific operations.

    */

  implicit class KafkaConsumerScala[K, V](val asJava: io.vertx.kafka.client.consumer.KafkaConsumer[K, V]) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
  }

  def handler(handler: scala.Option[io.vertx.kafka.client.consumer.KafkaConsumerRecord[K, V] => Unit]) = {
      asJava.handler(handler.asInstanceOf[io.vertx.core.Handler[io.vertx.kafka.client.consumer.KafkaConsumerRecord[K,V]]])
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
  }

  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.kafka.client.consumer.KafkaConsumerRecord[K, V]]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like subscribe from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def subscribeFuture(topic: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.subscribe(topic, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like subscribe from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def subscribeFuture(topics: scala.collection.mutable.Set[java.lang.String]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.subscribe(topics.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like assign from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def assignFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.assign(topicPartition, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like assign from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def assignFuture(topicPartitions: scala.collection.mutable.Set[io.vertx.kafka.client.common.TopicPartition]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.assign(topicPartitions.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like assignment from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def assignmentFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.kafka.client.common.TopicPartition]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.kafka.client.common.TopicPartition]]()
      asJava.assignment(new Handler[AsyncResult[java.util.Set[io.vertx.kafka.client.common.TopicPartition]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.kafka.client.common.TopicPartition]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like unsubscribe from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def unsubscribeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.unsubscribe(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like subscription from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def subscriptionFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.String]]()
      asJava.subscription(new Handler[AsyncResult[java.util.Set[java.lang.String]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like pause from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pauseFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pause(topicPartition, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like pause from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pauseFuture(topicPartitions: scala.collection.mutable.Set[io.vertx.kafka.client.common.TopicPartition]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.pause(topicPartitions.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like paused from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pausedFuture() : scala.concurrent.Future[scala.collection.mutable.Set[io.vertx.kafka.client.common.TopicPartition]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[io.vertx.kafka.client.common.TopicPartition]]()
      asJava.paused(new Handler[AsyncResult[java.util.Set[io.vertx.kafka.client.common.TopicPartition]]] { override def handle(event: AsyncResult[java.util.Set[io.vertx.kafka.client.common.TopicPartition]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like resume from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def resumeFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.resume(topicPartition, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like resume from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def resumeFuture(topicPartitions: scala.collection.mutable.Set[io.vertx.kafka.client.common.TopicPartition]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.resume(topicPartitions.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like seek from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def seekFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition,offset: java.lang.Long) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.seek(topicPartition, offset, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like seekToBeginning from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def seekToBeginningFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.seekToBeginning(topicPartition, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like seekToBeginning from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def seekToBeginningFuture(topicPartitions: scala.collection.mutable.Set[io.vertx.kafka.client.common.TopicPartition]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.seekToBeginning(topicPartitions.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like seekToEnd from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def seekToEndFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.seekToEnd(topicPartition, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like seekToEnd from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def seekToEndFuture(topicPartitions: scala.collection.mutable.Set[io.vertx.kafka.client.common.TopicPartition]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.seekToEnd(topicPartitions.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like commit from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def commitFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.commit(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like committed from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def committedFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition) : scala.concurrent.Future[io.vertx.kafka.client.consumer.OffsetAndMetadata] = {
      val promise = concurrent.Promise[io.vertx.kafka.client.consumer.OffsetAndMetadata]()
      asJava.committed(topicPartition, new Handler[AsyncResult[io.vertx.kafka.client.consumer.OffsetAndMetadata]] { override def handle(event: AsyncResult[io.vertx.kafka.client.consumer.OffsetAndMetadata]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like partitionsFor from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def partitionsForFuture(topic: java.lang.String) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.kafka.client.common.PartitionInfo]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.kafka.client.common.PartitionInfo]]()
      asJava.partitionsFor(topic, new Handler[AsyncResult[java.util.List[io.vertx.kafka.client.common.PartitionInfo]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.kafka.client.common.PartitionInfo]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like position from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def positionFuture(partition: io.vertx.kafka.client.common.TopicPartition) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.position(partition, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like offsetsForTimes from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def offsetsForTimesFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition,timestamp: java.lang.Long) : scala.concurrent.Future[io.vertx.kafka.client.consumer.OffsetAndTimestamp] = {
      val promise = concurrent.Promise[io.vertx.kafka.client.consumer.OffsetAndTimestamp]()
      asJava.offsetsForTimes(topicPartition, timestamp, new Handler[AsyncResult[io.vertx.kafka.client.consumer.OffsetAndTimestamp]] { override def handle(event: AsyncResult[io.vertx.kafka.client.consumer.OffsetAndTimestamp]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like beginningOffsets from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def beginningOffsetsFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.beginningOffsets(topicPartition, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like endOffsets from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def endOffsetsFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition) : scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.endOffsets(topicPartition, new Handler[AsyncResult[java.lang.Long]] { override def handle(event: AsyncResult[java.lang.Long]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like poll from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def pollFuture(timeout: java.lang.Long) : scala.concurrent.Future[io.vertx.kafka.client.consumer.KafkaConsumerRecords[K, V]] = {
      val promise = concurrent.Promise[io.vertx.kafka.client.consumer.KafkaConsumerRecords[K, V]]()
      asJava.poll(timeout, new Handler[AsyncResult[io.vertx.kafka.client.consumer.KafkaConsumerRecords[K,V]]] { override def handle(event: AsyncResult[io.vertx.kafka.client.consumer.KafkaConsumerRecords[K,V]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  }







  object KafkaHeader {
  def header(key: java.lang.String, value: io.vertx.core.buffer.Buffer) = {
      io.vertx.kafka.client.producer.KafkaHeader.header(key, value)
  }

  def header(key: java.lang.String, value: java.lang.String) = {
      io.vertx.kafka.client.producer.KafkaHeader.header(key, value)
  }
  }



  /**
    * Vert.x Kafka producer.
    * 
    * The [[io.vertx.core.streams.WriteStream#write]] provides global control over writing a record.

    */

  implicit class KafkaProducerScala[K, V](val asJava: io.vertx.kafka.client.producer.KafkaProducer[K, V]) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
  }

  def drainHandler(handler: scala.Option[Void => Unit]) = {
      asJava.drainHandler(handler.asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
  }

  def writeFuture(arg0: io.vertx.kafka.client.producer.KafkaProducerRecord[K, V]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.write(arg0, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def endFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def endFuture(data: io.vertx.kafka.client.producer.KafkaProducerRecord[K, V]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.end(data, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def initTransactionsFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.initTransactions(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def beginTransactionFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.beginTransaction(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def commitTransactionFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.commitTransaction(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  def abortTransactionFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.abortTransaction(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like send from [[io.vertx.kafka.client.producer.KafkaProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def sendFuture(record: io.vertx.kafka.client.producer.KafkaProducerRecord[K, V]) : scala.concurrent.Future[io.vertx.kafka.client.producer.RecordMetadata] = {
      val promise = concurrent.Promise[io.vertx.kafka.client.producer.RecordMetadata]()
      asJava.send(record, new Handler[AsyncResult[io.vertx.kafka.client.producer.RecordMetadata]] { override def handle(event: AsyncResult[io.vertx.kafka.client.producer.RecordMetadata]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like partitionsFor from [[io.vertx.kafka.client.producer.KafkaProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def partitionsForFuture(topic: java.lang.String) : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.kafka.client.common.PartitionInfo]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.kafka.client.common.PartitionInfo]]()
      asJava.partitionsFor(topic, new Handler[AsyncResult[java.util.List[io.vertx.kafka.client.common.PartitionInfo]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.kafka.client.common.PartitionInfo]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like flush from [[io.vertx.kafka.client.producer.KafkaProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def flushFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.flush(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.kafka.client.producer.KafkaProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.kafka.client.producer.KafkaProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture(timeout: java.lang.Long) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.close(timeout, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

  }



  object KafkaProducerRecord {
    /**
     * Like create from [[io.vertx.kafka.client.producer.KafkaProducerRecord]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create[K, V](topic: java.lang.String, key: K, value: V, timestamp: java.lang.Long, partition: java.lang.Integer) = {
      io.vertx.kafka.client.producer.KafkaProducerRecord.create[K, V](topic, key, value, timestamp, partition)
  }

    /**
     * Like create from [[io.vertx.kafka.client.producer.KafkaProducerRecord]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create[K, V](topic: java.lang.String, key: K, value: V) = {
      io.vertx.kafka.client.producer.KafkaProducerRecord.create[K, V](topic, key, value)
  }

    /**
     * Like create from [[io.vertx.kafka.client.producer.KafkaProducerRecord]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def create[K, V](topic: java.lang.String, value: V) = {
      io.vertx.kafka.client.producer.KafkaProducerRecord.create[K, V](topic, value)
  }
  }


  type Node = io.vertx.kafka.client.common.Node
  object Node {
    def apply() = new Node()
    def apply(json: JsonObject) = new Node(json)
  }



  type OffsetAndMetadata = io.vertx.kafka.client.consumer.OffsetAndMetadata
  object OffsetAndMetadata {
    def apply() = new OffsetAndMetadata()
    def apply(json: JsonObject) = new OffsetAndMetadata(json)
  }



  type OffsetAndTimestamp = io.vertx.kafka.client.consumer.OffsetAndTimestamp
  object OffsetAndTimestamp {
    def apply() = new OffsetAndTimestamp()
    def apply(json: JsonObject) = new OffsetAndTimestamp(json)
  }



  type PartitionInfo = io.vertx.kafka.client.common.PartitionInfo
  object PartitionInfo {
    def apply() = new PartitionInfo()
    def apply(json: JsonObject) = new PartitionInfo(json)
  }



  type RecordMetadata = io.vertx.kafka.client.producer.RecordMetadata
  object RecordMetadata {
    def apply() = new RecordMetadata()
    def apply(json: JsonObject) = new RecordMetadata(json)
  }



  type TopicPartition = io.vertx.kafka.client.common.TopicPartition
  object TopicPartition {
    def apply() = new TopicPartition()
    def apply(json: JsonObject) = new TopicPartition(json)
  }



  type TopicPartitionInfo = io.vertx.kafka.client.common.TopicPartitionInfo
  object TopicPartitionInfo {
    def apply() = new TopicPartitionInfo()
    def apply(json: JsonObject) = new TopicPartitionInfo(json)
  }



}
