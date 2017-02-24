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

package io.vertx.scala.kafka.client.consumer

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.kafka.client.common.{TopicPartition => JTopicPartition}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.kafka.client.common.PartitionInfo
import io.vertx.kafka.client.consumer.{KafkaConsumer => JKafkaConsumer}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.kafka.client.consumer.{OffsetAndMetadata => JOffsetAndMetadata}
import io.vertx.kafka.client.common.{PartitionInfo => JPartitionInfo}
import io.vertx.core.AsyncResult
import io.vertx.kafka.client.consumer.{KafkaConsumerRecord => JKafkaConsumerRecord}
import io.vertx.core.Handler
import io.vertx.scala.kafka.client.common.TopicPartition

/**
  * Vert.x Kafka consumer.
  * 
  * You receive Kafka records by providing a [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#handler]]. As messages arrive the handler
  * will be called with the records.
  * 
  * The [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#pause]] and [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#resume]] provides global control over reading the records from the consumer.
  * 
  * The [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#pause]] and [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#resume]] provides finer grained control over reading records
  * for specific Topic/Partition, these are Kafka's specific operations.
  */
class KafkaConsumer[K: TypeTag, V: TypeTag](private val _asJava: Object)
    extends  ReadStream[KafkaConsumerRecord[K, V]] {

  def asJava = _asJava

  override def exceptionHandler(handler: Handler[Throwable]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[KafkaConsumerRecord[K, V]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].handler({x: JKafkaConsumerRecord[Object, Object] => handler.handle(KafkaConsumerRecord[K, V](x))})
    this
  }

  override def pause(): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause()
    this
  }

  override def resume(): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  /**
    * Subscribe to the given topic to get dynamically assigned partitions.
    * @param topic topic to subscribe to
    * @return current KafkaConsumer instance
    */
  def subscribe(topic: String): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscribe(topic.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Subscribe to the given list of topics to get dynamically assigned partitions.
    * @param topics topics to subscribe to
    * @return current KafkaConsumer instance
    */
  def subscribe(topics: scala.collection.mutable.Set[String]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscribe(topics.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
    * Subscribe to the given topic to get dynamically assigned partitions.
    * @param topic topic to subscribe to
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def subscribe(topic: String, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscribe(topic.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Subscribe to the given list of topics to get dynamically assigned partitions.
    * @param topics topics to subscribe to
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def subscribe(topics: scala.collection.mutable.Set[String], completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscribe(topics.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Manually assign a partition to this consumer.
    * @param topicPartition partition which want assignedsee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @return current KafkaConsumer instance
    */
  def assign(topicPartition: TopicPartition): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assign(topicPartition.asJava)
    this
  }

  /**
    * Manually assign a list of partition to this consumer.
    * @param topicPartitions partitions which want assigned
    * @return current KafkaConsumer instance
    */
  def assign(topicPartitions: scala.collection.mutable.Set[TopicPartition]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assign(topicPartitions.map(x => x.asJava).asJava)
    this
  }

  /**
    * Manually assign a partition to this consumer.
    * @param topicPartition partition which want assignedsee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def assign(topicPartition: TopicPartition, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assign(topicPartition.asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Manually assign a list of partition to this consumer.
    * @param topicPartitions partitions which want assigned
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def assign(topicPartitions: scala.collection.mutable.Set[TopicPartition], completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assign(topicPartitions.map(x => x.asJava).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Get the set of partitions currently assigned to this consumer.
    * @param handler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def assignment(handler: Handler[AsyncResult[scala.collection.mutable.Set[TopicPartition]]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assignment({x: AsyncResult[java.util.Set[JTopicPartition]] => handler.handle(AsyncResultWrapper[java.util.Set[JTopicPartition], scala.collection.mutable.Set[TopicPartition]](x, a => a.asScala.map(x => TopicPartition(x))))})
    this
  }

  /**
    * Unsubscribe from topics currently subscribed with subscribe.
    * @return current KafkaConsumer instance
    */
  def unsubscribe(): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].unsubscribe()
    this
  }

  /**
    * Unsubscribe from topics currently subscribed with subscribe.
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def unsubscribe(completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].unsubscribe({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Get the current subscription.
    * @param handler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def subscription(handler: Handler[AsyncResult[scala.collection.mutable.Set[String]]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscription({x: AsyncResult[java.util.Set[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.String], scala.collection.mutable.Set[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  /**
    * Suspend fetching from the requested partition.
    * @param topicPartition topic partition from which suspend fetchingsee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @return current KafkaConsumer instance
    */
  def pause(topicPartition: TopicPartition): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause(topicPartition.asJava)
    this
  }

  /**
    * Suspend fetching from the requested partitions.
    * @param topicPartitions topic partition from which suspend fetching
    * @return current KafkaConsumer instance
    */
  def pause(topicPartitions: scala.collection.mutable.Set[TopicPartition]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause(topicPartitions.map(x => x.asJava).asJava)
    this
  }

  /**
    * Suspend fetching from the requested partition.
    * @param topicPartition topic partition from which suspend fetchingsee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def pause(topicPartition: TopicPartition, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause(topicPartition.asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Suspend fetching from the requested partitions.
    * @param topicPartitions topic partition from which suspend fetching
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def pause(topicPartitions: scala.collection.mutable.Set[TopicPartition], completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause(topicPartitions.map(x => x.asJava).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Resume specified partition which have been paused with pause.
    * @param topicPartition topic partition from which resume fetchingsee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @return current KafkaConsumer instance
    */
  def resume(topicPartition: TopicPartition): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume(topicPartition.asJava)
    this
  }

  /**
    * Resume specified partitions which have been paused with pause.
    * @param topicPartitions topic partition from which resume fetching
    * @return current KafkaConsumer instance
    */
  def resume(topicPartitions: scala.collection.mutable.Set[TopicPartition]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume(topicPartitions.map(x => x.asJava).asJava)
    this
  }

  /**
    * Resume specified partition which have been paused with pause.
    * @param topicPartition topic partition from which resume fetchingsee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def resume(topicPartition: TopicPartition, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume(topicPartition.asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Resume specified partitions which have been paused with pause.
    * @param topicPartitions topic partition from which resume fetching
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def resume(topicPartitions: scala.collection.mutable.Set[TopicPartition], completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume(topicPartitions.map(x => x.asJava).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Set the handler called when topic partitions are revoked to the consumer
    * @param handler handler called on revoked topic partitions
    * @return current KafkaConsumer instance
    */
  def partitionsRevokedHandler(handler: Handler[scala.collection.mutable.Set[TopicPartition]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].partitionsRevokedHandler({x: java.util.Set[JTopicPartition] => handler.handle(x.asScala.map(x => TopicPartition(x)))})
    this
  }

  /**
    * Set the handler called when topic partitions are assigned to the consumer
    * @param handler handler called on assigned topic partitions
    * @return current KafkaConsumer instance
    */
  def partitionsAssignedHandler(handler: Handler[scala.collection.mutable.Set[TopicPartition]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].partitionsAssignedHandler({x: java.util.Set[JTopicPartition] => handler.handle(x.asScala.map(x => TopicPartition(x)))})
    this
  }

  /**
    * Overrides the fetch offsets that the consumer will use on the next poll.
    * @param topicPartition topic partition for which seeksee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @param offset offset to seek inside the topic partition
    * @return current KafkaConsumer instance
    */
  def seek(topicPartition: TopicPartition, offset: Long): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seek(topicPartition.asJava, offset.asInstanceOf[java.lang.Long])
    this
  }

  /**
    * Overrides the fetch offsets that the consumer will use on the next poll.
    * @param topicPartition topic partition for which seeksee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @param offset offset to seek inside the topic partition
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def seek(topicPartition: TopicPartition, offset: Long, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seek(topicPartition.asJava, offset.asInstanceOf[java.lang.Long], {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Seek to the first offset for each of the given partition.
    * @param topicPartition topic partition for which seeksee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @return current KafkaConsumer instance
    */
  def seekToBeginning(topicPartition: TopicPartition): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToBeginning(topicPartition.asJava)
    this
  }

  /**
    * Seek to the first offset for each of the given partitions.
    * @param topicPartitions topic partition for which seek
    * @return current KafkaConsumer instance
    */
  def seekToBeginning(topicPartitions: scala.collection.mutable.Set[TopicPartition]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToBeginning(topicPartitions.map(x => x.asJava).asJava)
    this
  }

  /**
    * Seek to the first offset for each of the given partition.
    * @param topicPartition topic partition for which seeksee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def seekToBeginning(topicPartition: TopicPartition, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToBeginning(topicPartition.asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Seek to the first offset for each of the given partitions.
    * @param topicPartitions topic partition for which seek
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def seekToBeginning(topicPartitions: scala.collection.mutable.Set[TopicPartition], completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToBeginning(topicPartitions.map(x => x.asJava).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Seek to the last offset for each of the given partition.
    * @param topicPartition topic partition for which seeksee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @return current KafkaConsumer instance
    */
  def seekToEnd(topicPartition: TopicPartition): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToEnd(topicPartition.asJava)
    this
  }

  /**
    * Seek to the last offset for each of the given partitions.
    * @param topicPartitions topic partition for which seek
    * @return current KafkaConsumer instance
    */
  def seekToEnd(topicPartitions: scala.collection.mutable.Set[TopicPartition]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToEnd(topicPartitions.map(x => x.asJava).asJava)
    this
  }

  /**
    * Seek to the last offset for each of the given partition.
    * @param topicPartition topic partition for which seeksee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def seekToEnd(topicPartition: TopicPartition, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToEnd(topicPartition.asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Seek to the last offset for each of the given partitions.
    * @param topicPartitions topic partition for which seek
    * @param completionHandler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def seekToEnd(topicPartitions: scala.collection.mutable.Set[TopicPartition], completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToEnd(topicPartitions.map(x => x.asJava).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Get metadata about the partitions for a given topic.
    * @param topic topic partition for which getting partitions info
    * @param handler handler called on operation completed
    * @return current KafkaConsumer instance
    */
  def partitionsFor(topic: String, handler: Handler[AsyncResult[scala.collection.mutable.Buffer[PartitionInfo]]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].partitionsFor(topic.asInstanceOf[java.lang.String], {x: AsyncResult[java.util.List[JPartitionInfo]] => handler.handle(AsyncResultWrapper[java.util.List[JPartitionInfo], scala.collection.mutable.Buffer[PartitionInfo]](x, a => a.asScala.map(x => PartitionInfo(x))))})
    this
  }

  /**
    * Close the consumer
    */
  def close(): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].close()
  }

  /**
    * Get the set of partitions that were previously paused by a call to pause(Set).
    * @param handler handler called on operation completed
    */
  def paused(handler: Handler[AsyncResult[scala.collection.mutable.Set[TopicPartition]]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].paused({x: AsyncResult[java.util.Set[JTopicPartition]] => handler.handle(AsyncResultWrapper[java.util.Set[JTopicPartition], scala.collection.mutable.Set[TopicPartition]](x, a => a.asScala.map(x => TopicPartition(x))))})
  }

  /**
    * Commit current offsets for all the subscribed list of topics and partition.
    */
  def commit(): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].commit()
  }

  /**
    * Commit current offsets for all the subscribed list of topics and partition.
    * @param completionHandler handler called on operation completed
    */
  def commit(completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].commit({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Get the last committed offset for the given partition (whether the commit happened by this process or another).
    * @param topicPartition topic partition for getting last committed offsetsee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @param handler handler called on operation completed
    */
  def committed(topicPartition: TopicPartition, handler: Handler[AsyncResult[OffsetAndMetadata]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].committed(topicPartition.asJava, {x: AsyncResult[JOffsetAndMetadata] => handler.handle(AsyncResultWrapper[JOffsetAndMetadata, OffsetAndMetadata](x, a => OffsetAndMetadata(a)))})
  }

  /**
    * Close the consumer
    * @param completionHandler handler called on operation completed
    */
  def close(completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].close({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Get the offset of the next record that will be fetched (if a record with that offset exists).
    * @param partition The partition to get the position forsee <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
    * @param handler handler called on operation completed
    */
  def position(partition: TopicPartition, handler: Handler[AsyncResult[Long]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].position(partition.asJava, {x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long, Long](x, a => a.asInstanceOf[Long]))})
  }

 /**
   * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def subscribeFuture(topic: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscribe(topic.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def subscribeFuture(topics: scala.collection.mutable.Set[String]): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscribe(topics.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[assign]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def assignFuture(topicPartition: TopicPartition): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assign(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[assign]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def assignFuture(topicPartitions: scala.collection.mutable.Set[TopicPartition]): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assign(topicPartitions.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[assignment]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def assignmentFuture(): scala.concurrent.Future[scala.collection.mutable.Set[TopicPartition]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[JTopicPartition], scala.collection.mutable.Set[TopicPartition]](x => x.asScala.map(x => TopicPartition(x)))
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assignment(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[unsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def unsubscribeFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].unsubscribe(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[subscription]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def subscriptionFuture(): scala.concurrent.Future[scala.collection.mutable.Set[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[java.lang.String], scala.collection.mutable.Set[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscription(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[pause]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def pauseFuture(topicPartition: TopicPartition): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[pause]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def pauseFuture(topicPartitions: scala.collection.mutable.Set[TopicPartition]): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause(topicPartitions.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[paused]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def pausedFuture(): scala.concurrent.Future[scala.collection.mutable.Set[TopicPartition]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[JTopicPartition], scala.collection.mutable.Set[TopicPartition]](x => x.asScala.map(x => TopicPartition(x)))
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].paused(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[resume]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resumeFuture(topicPartition: TopicPartition): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[resume]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def resumeFuture(topicPartitions: scala.collection.mutable.Set[TopicPartition]): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume(topicPartitions.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[seek]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def seekFuture(topicPartition: TopicPartition, offset: Long): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seek(topicPartition.asJava, offset.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[seekToBeginning]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def seekToBeginningFuture(topicPartition: TopicPartition): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToBeginning(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[seekToBeginning]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def seekToBeginningFuture(topicPartitions: scala.collection.mutable.Set[TopicPartition]): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToBeginning(topicPartitions.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[seekToEnd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def seekToEndFuture(topicPartition: TopicPartition): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToEnd(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[seekToEnd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def seekToEndFuture(topicPartitions: scala.collection.mutable.Set[TopicPartition]): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToEnd(topicPartitions.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[commit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def commitFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].commit(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[committed]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def committedFuture(topicPartition: TopicPartition): scala.concurrent.Future[OffsetAndMetadata] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JOffsetAndMetadata, OffsetAndMetadata](x => OffsetAndMetadata(x))
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].committed(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[partitionsFor]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def partitionsForFuture(topic: String): scala.concurrent.Future[scala.collection.mutable.Buffer[PartitionInfo]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JPartitionInfo], scala.collection.mutable.Buffer[PartitionInfo]](x => x.asScala.map(x => PartitionInfo(x)))
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].partitionsFor(topic.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def closeFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[position]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def positionFuture(partition: TopicPartition): scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].position(partition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object KafkaConsumer {
  def apply[K: TypeTag, V: TypeTag](asJava: JKafkaConsumer[_, _]) = new KafkaConsumer[K, V](asJava)  
  /**
    * Create a new KafkaConsumer instance
    * @param vertx Vert.x instance to use
    * @param config Kafka producer configuration
    * @return an instance of the KafkaConsumer
    */
  def create[K: TypeTag, V: TypeTag](vertx: Vertx, config: scala.collection.mutable.Map[String, String]): KafkaConsumer[K, V] = {
    KafkaConsumer[K, V](JKafkaConsumer.create[Object, Object](vertx.asJava.asInstanceOf[JVertx], config.mapValues(x => x.asInstanceOf[java.lang.String]).asJava))
  }

  /**
    * Create a new KafkaConsumer instance
    * @param vertx Vert.x instance to use
    * @param config Kafka consumer configuration
    * @param keyType class type for the key deserialization
    * @param valueType class type for the value deserialization
    * @return an instance of the KafkaConsumer
    */
  def create[K: TypeTag, V: TypeTag](vertx: Vertx, config: scala.collection.mutable.Map[String, String], keyType: Class[K], valueType: Class[V]): KafkaConsumer[K, V] = {
    KafkaConsumer[K, V](JKafkaConsumer.create[Object, Object](vertx.asJava.asInstanceOf[JVertx], config.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, toJavaClass(keyType), toJavaClass(valueType)))
  }

}
