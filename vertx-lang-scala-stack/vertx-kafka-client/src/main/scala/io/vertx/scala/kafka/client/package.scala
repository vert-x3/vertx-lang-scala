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

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core.buffer.Buffer
import scala.collection.JavaConverters._
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


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.kafka.client.consumer.KafkaConsumer[K, V] = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.kafka.client.consumer.KafkaConsumerRecord[K, V] => Unit]): io.vertx.kafka.client.consumer.KafkaConsumer[K, V] = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.kafka.client.consumer.KafkaConsumerRecord[K, V] => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.kafka.client.consumer.KafkaConsumer[K, V] = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }

    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.kafka.client.consumer.KafkaConsumerRecord[K, V]]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like subscribe from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def subscribeFuture(topic: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.subscribe(topic, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like subscribe from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def subscribeFuture(topics: java.util.Set[java.lang.String]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.subscribe(topics, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like assign from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def assignFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.assign(topicPartition, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like assign from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def assignFuture(topicPartitions: java.util.Set[io.vertx.kafka.client.common.TopicPartition]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.assign(topicPartitions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like assignment from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def assignmentFuture(): scala.concurrent.Future[java.util.Set[io.vertx.kafka.client.common.TopicPartition]] = {
      val promise = concurrent.Promise[java.util.Set[io.vertx.kafka.client.common.TopicPartition]]()
      asJava.assignment({a:AsyncResult[java.util.Set[io.vertx.kafka.client.common.TopicPartition]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like unsubscribe from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def unsubscribeFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.unsubscribe({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like subscription from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def subscriptionFuture(): scala.concurrent.Future[java.util.Set[java.lang.String]] = {
      val promise = concurrent.Promise[java.util.Set[java.lang.String]]()
      asJava.subscription({a:AsyncResult[java.util.Set[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like pause from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def pauseFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.pause(topicPartition, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like pause from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def pauseFuture(topicPartitions: java.util.Set[io.vertx.kafka.client.common.TopicPartition]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.pause(topicPartitions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like paused from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def pausedFuture(): scala.concurrent.Future[java.util.Set[io.vertx.kafka.client.common.TopicPartition]] = {
      val promise = concurrent.Promise[java.util.Set[io.vertx.kafka.client.common.TopicPartition]]()
      asJava.paused({a:AsyncResult[java.util.Set[io.vertx.kafka.client.common.TopicPartition]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like resume from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def resumeFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.resume(topicPartition, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like resume from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def resumeFuture(topicPartitions: java.util.Set[io.vertx.kafka.client.common.TopicPartition]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.resume(topicPartitions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like seek from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def seekFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition,offset: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.seek(topicPartition, offset, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like seekToBeginning from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def seekToBeginningFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.seekToBeginning(topicPartition, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like seekToBeginning from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def seekToBeginningFuture(topicPartitions: java.util.Set[io.vertx.kafka.client.common.TopicPartition]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.seekToBeginning(topicPartitions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like seekToEnd from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def seekToEndFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.seekToEnd(topicPartition, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like seekToEnd from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def seekToEndFuture(topicPartitions: java.util.Set[io.vertx.kafka.client.common.TopicPartition]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.seekToEnd(topicPartitions, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like commit from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def commitFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.commit({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like committed from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def committedFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[io.vertx.kafka.client.consumer.OffsetAndMetadata] = {
      val promise = concurrent.Promise[io.vertx.kafka.client.consumer.OffsetAndMetadata]()
      asJava.committed(topicPartition, {a:AsyncResult[io.vertx.kafka.client.consumer.OffsetAndMetadata] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like partitionsFor from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def partitionsForFuture(topic: java.lang.String): scala.concurrent.Future[java.util.List[io.vertx.kafka.client.common.PartitionInfo]] = {
      val promise = concurrent.Promise[java.util.List[io.vertx.kafka.client.common.PartitionInfo]]()
      asJava.partitionsFor(topic, {a:AsyncResult[java.util.List[io.vertx.kafka.client.common.PartitionInfo]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like close from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like position from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def positionFuture(partition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.position(partition, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like offsetsForTimes from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def offsetsForTimesFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition,timestamp: java.lang.Long): scala.concurrent.Future[io.vertx.kafka.client.consumer.OffsetAndTimestamp] = {
      val promise = concurrent.Promise[io.vertx.kafka.client.consumer.OffsetAndTimestamp]()
      asJava.offsetsForTimes(topicPartition, timestamp, {a:AsyncResult[io.vertx.kafka.client.consumer.OffsetAndTimestamp] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like beginningOffsets from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def beginningOffsetsFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.beginningOffsets(topicPartition, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like endOffsets from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def endOffsetsFuture(topicPartition: io.vertx.kafka.client.common.TopicPartition): scala.concurrent.Future[java.lang.Long] = {
      val promise = concurrent.Promise[java.lang.Long]()
      asJava.endOffsets(topicPartition, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like poll from [[io.vertx.kafka.client.consumer.KafkaConsumer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def pollFuture(timeout: java.lang.Long): scala.concurrent.Future[io.vertx.kafka.client.consumer.KafkaConsumerRecords[K, V]] = {
      val promise = concurrent.Promise[io.vertx.kafka.client.consumer.KafkaConsumerRecords[K, V]]()
      asJava.poll(timeout, {a:AsyncResult[io.vertx.kafka.client.consumer.KafkaConsumerRecords[K,V]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }






  object KafkaHeader {
    def header(key: java.lang.String,value: io.vertx.core.buffer.Buffer) = {
      io.vertx.kafka.client.producer.KafkaHeader.header(key, value)
    }
    def header(key: java.lang.String,value: java.lang.String) = {
      io.vertx.kafka.client.producer.KafkaHeader.header(key, value)
    }
  }



  /**
    * Vert.x Kafka producer.
    * 
    * The [[io.vertx.core.streams.WriteStream#write]] provides global control over writing a record.

    */

  implicit class KafkaProducerScala[K, V](val asJava: io.vertx.kafka.client.producer.KafkaProducer[K, V]) extends AnyVal {


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.kafka.client.producer.KafkaProducer[K, V] = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def drainHandler(handler: scala.Option[Void => Unit]): io.vertx.kafka.client.producer.KafkaProducer[K, V] = {
      asJava.drainHandler(handler match {case Some(t) => p:Void => t(p); case None => null})
    }

    def writeFuture(arg0: io.vertx.kafka.client.producer.KafkaProducerRecord[K, V]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.write(arg0, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def endFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.end({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def endFuture(data: io.vertx.kafka.client.producer.KafkaProducerRecord[K, V]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.end(data, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def initTransactionsFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.initTransactions({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def beginTransactionFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.beginTransaction({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def commitTransactionFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.commitTransaction({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def abortTransactionFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.abortTransaction({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like send from [[io.vertx.kafka.client.producer.KafkaProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def sendFuture(record: io.vertx.kafka.client.producer.KafkaProducerRecord[K, V]): scala.concurrent.Future[io.vertx.kafka.client.producer.RecordMetadata] = {
      val promise = concurrent.Promise[io.vertx.kafka.client.producer.RecordMetadata]()
      asJava.send(record, {a:AsyncResult[io.vertx.kafka.client.producer.RecordMetadata] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like partitionsFor from [[io.vertx.kafka.client.producer.KafkaProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def partitionsForFuture(topic: java.lang.String): scala.concurrent.Future[java.util.List[io.vertx.kafka.client.common.PartitionInfo]] = {
      val promise = concurrent.Promise[java.util.List[io.vertx.kafka.client.common.PartitionInfo]]()
      asJava.partitionsFor(topic, {a:AsyncResult[java.util.List[io.vertx.kafka.client.common.PartitionInfo]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like flush from [[io.vertx.kafka.client.producer.KafkaProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def flushFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.flush({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like close from [[io.vertx.kafka.client.producer.KafkaProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like close from [[io.vertx.kafka.client.producer.KafkaProducer]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def closeFuture(timeout: java.lang.Long): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close(timeout, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }


  object KafkaProducerRecord {
    /**
     * Create a concrete instance of a Vert.x producer record     * @param topic the topic this record is being sent to
     * @param key the key (or null if no key is specified)
     * @param value the value
     * @param timestamp the timestamp of this record
     * @param partition the partition to which the record will be sent (or null if no partition was specified)
     * @return Vert.x producer record
     */
    def create[K, V](topic: java.lang.String,key: K,value: V,timestamp: java.lang.Long,partition: java.lang.Integer) = {
      io.vertx.kafka.client.producer.KafkaProducerRecord.create[K, V](topic, key, value, timestamp, partition)
    }
    /**
     * Create a concrete instance of a Vert.x producer record     * @param topic the topic this record is being sent to
     * @param key the key (or null if no key is specified)
     * @param value the value
     * @return Vert.x producer record
     */
    def create[K, V](topic: java.lang.String,key: K,value: V) = {
      io.vertx.kafka.client.producer.KafkaProducerRecord.create[K, V](topic, key, value)
    }
    /**
     * Create a concrete instance of a Vert.x producer record     * @param topic the topic this record is being sent to
     * @param value the value
     * @return Vert.x producer record
     */
    def create[K, V](topic: java.lang.String,value: V) = {
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
