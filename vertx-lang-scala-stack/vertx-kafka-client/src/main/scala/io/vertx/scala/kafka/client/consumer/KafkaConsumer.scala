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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.kafka.client.common.{TopicPartition => JTopicPartition}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.kafka.client.common.PartitionInfo
import io.vertx.lang.scala.Converter._
import io.vertx.kafka.client.consumer.{KafkaConsumer => JKafkaConsumer}
import io.vertx.kafka.client.consumer.{OffsetAndTimestamp => JOffsetAndTimestamp}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.kafka.client.consumer.{KafkaConsumerRecords => JKafkaConsumerRecords}
import io.vertx.kafka.client.consumer.{OffsetAndMetadata => JOffsetAndMetadata}
import io.vertx.kafka.client.common.{PartitionInfo => JPartitionInfo}
import io.vertx.core.AsyncResult
import io.vertx.kafka.client.consumer.{KafkaConsumerRecord => JKafkaConsumerRecord}
import io.vertx.core.Handler
import io.vertx.scala.kafka.client.common.TopicPartition
import io.vertx.lang.scala.HandlerOps._

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

class KafkaConsumer[K: TypeTag, V: TypeTag](private val _asJava: Object) extends ReadStream[KafkaConsumerRecord[K, V]] {
  def asJava = _asJava




  override 
  def exceptionHandler(handler: Handler[Throwable]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }


  override 
  def handler(handler: Handler[KafkaConsumerRecord[K, V]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].handler({x: JKafkaConsumerRecord[Object, Object] => handler.handle(KafkaConsumerRecord[K, V](x))})
    this
  }


  override 
  def pause(): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause()
    this
  }


  override 
  def resume(): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume()
    this
  }


  override 
  def endHandler(endHandler: Handler[Unit]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  /**
   * Subscribe to the given topic to get dynamically assigned partitions.   * @param topic topic to subscribe to
   * @return current KafkaConsumer instance
   */
  
  def subscribe(topic: String): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscribe(topic.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Subscribe to the given list of topics to get dynamically assigned partitions.   * @param topics topics to subscribe to
   * @return current KafkaConsumer instance
   */
  
  def subscribe(topics: scala.collection.mutable.Set[String]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscribe(topics.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
   * Subscribe to the given topic to get dynamically assigned partitions.
   * 
   * Due to internal buffering of messages, when changing the subscribed topic
   * the old topic may remain in effect
   * (as observed by the  record handler`)
   * until some time <em>after</em> the given `completionHandler`
   * is called. In contrast, the once the given `completionHandler`
   * is called the [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#batchHandler]] will only see messages
   * consistent with the new topic.   * @param topic topic to subscribe to
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def subscribe(topic: String, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscribe(topic.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Subscribe to the given list of topics to get dynamically assigned partitions.
   * 
   * Due to internal buffering of messages, when changing the subscribed topics
   * the old set of topics may remain in effect
   * (as observed by the  record handler`)
   * until some time <em>after</em> the given `completionHandler`
   * is called. In contrast, the once the given `completionHandler`
   * is called the [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#batchHandler]] will only see messages
   * consistent with the new set of topics.   * @param topics topics to subscribe to
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def subscribe(topics: scala.collection.mutable.Set[String], completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscribe(topics.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Manually assign a partition to this consumer.   * @param topicPartition partition which want assigned see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @return current KafkaConsumer instance
   */
  
  def assign(topicPartition: TopicPartition): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assign(topicPartition.asJava)
    this
  }

  /**
   * Manually assign a list of partition to this consumer.   * @param topicPartitions partitions which want assigned
   * @return current KafkaConsumer instance
   */
  
  def assign(topicPartitions: scala.collection.mutable.Set[TopicPartition]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assign(topicPartitions.map(x => x.asJava).asJava)
    this
  }

  /**
   * Manually assign a partition to this consumer.
   * 
   * Due to internal buffering of messages, when reassigning
   * the old partition may remain in effect
   * (as observed by the  record handler)`
   * until some time <em>after</em> the given `completionHandler`
   * is called. In contrast, the once the given `completionHandler`
   * is called the [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#batchHandler]] will only see messages
   * consistent with the new partition.   * @param topicPartition partition which want assigned see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def assign(topicPartition: TopicPartition, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assign(topicPartition.asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Manually assign a list of partition to this consumer.
   * 
   * Due to internal buffering of messages, when reassigning
   * the old set of partitions may remain in effect
   * (as observed by the  record handler)`
   * until some time <em>after</em> the given `completionHandler`
   * is called. In contrast, the once the given `completionHandler`
   * is called the [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#batchHandler]] will only see messages
   * consistent with the new set of partitions.   * @param topicPartitions partitions which want assigned
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def assign(topicPartitions: scala.collection.mutable.Set[TopicPartition], completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assign(topicPartitions.map(x => x.asJava).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Get the set of partitions currently assigned to this consumer.   * @param handler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def assignment(handler: Handler[AsyncResult[scala.collection.mutable.Set[TopicPartition]]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assignment({x: AsyncResult[java.util.Set[JTopicPartition]] => handler.handle(AsyncResultWrapper[java.util.Set[JTopicPartition], scala.collection.mutable.Set[TopicPartition]](x, a => a.asScala.map(x => TopicPartition(x))))})
    this
  }

  /**
   * Unsubscribe from topics currently subscribed with subscribe.   * @return current KafkaConsumer instance
   */
  
  def unsubscribe(): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].unsubscribe()
    this
  }

  /**
   * Unsubscribe from topics currently subscribed with subscribe.   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def unsubscribe(completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].unsubscribe({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Get the current subscription.   * @param handler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def subscription(handler: Handler[AsyncResult[scala.collection.mutable.Set[String]]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscription({x: AsyncResult[java.util.Set[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.String], scala.collection.mutable.Set[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  /**
   * Suspend fetching from the requested partition.   * @param topicPartition topic partition from which suspend fetching see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @return current KafkaConsumer instance
   */
  
  def pause(topicPartition: TopicPartition): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause(topicPartition.asJava)
    this
  }

  /**
   * Suspend fetching from the requested partitions.   * @param topicPartitions topic partition from which suspend fetching
   * @return current KafkaConsumer instance
   */
  
  def pause(topicPartitions: scala.collection.mutable.Set[TopicPartition]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause(topicPartitions.map(x => x.asJava).asJava)
    this
  }

  /**
   * Suspend fetching from the requested partition.
   * 
   * Due to internal buffering of messages,
   * the  will
   * continue to observe messages from the given `topicPartition`
   * until some time <em>after</em> the given `completionHandler`
   * is called. In contrast, the once the given `completionHandler`
   * is called the [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#batchHandler]] will not see messages
   * from the given `topicPartition`.   * @param topicPartition topic partition from which suspend fetching see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def pause(topicPartition: TopicPartition, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause(topicPartition.asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Suspend fetching from the requested partitions.
   * 
   * Due to internal buffering of messages,
   * the  will
   * continue to observe messages from the given `topicPartitions`
   * until some time <em>after</em> the given `completionHandler`
   * is called. In contrast, the once the given `completionHandler`
   * is called the [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#batchHandler]] will not see messages
   * from the given `topicPartitions`.   * @param topicPartitions topic partition from which suspend fetching
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def pause(topicPartitions: scala.collection.mutable.Set[TopicPartition], completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause(topicPartitions.map(x => x.asJava).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Resume specified partition which have been paused with pause.   * @param topicPartition topic partition from which resume fetching see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @return current KafkaConsumer instance
   */
  
  def resume(topicPartition: TopicPartition): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume(topicPartition.asJava)
    this
  }

  /**
   * Resume specified partitions which have been paused with pause.   * @param topicPartitions topic partition from which resume fetching
   * @return current KafkaConsumer instance
   */
  
  def resume(topicPartitions: scala.collection.mutable.Set[TopicPartition]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume(topicPartitions.map(x => x.asJava).asJava)
    this
  }

  /**
   * Resume specified partition which have been paused with pause.   * @param topicPartition topic partition from which resume fetching see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def resume(topicPartition: TopicPartition, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume(topicPartition.asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Resume specified partitions which have been paused with pause.   * @param topicPartitions topic partition from which resume fetching
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def resume(topicPartitions: scala.collection.mutable.Set[TopicPartition], completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume(topicPartitions.map(x => x.asJava).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Set the handler called when topic partitions are revoked to the consumer   * @param handler handler called on revoked topic partitions
   * @return current KafkaConsumer instance
   */
  
  def partitionsRevokedHandler(handler: Handler[scala.collection.mutable.Set[TopicPartition]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].partitionsRevokedHandler({x: java.util.Set[JTopicPartition] => handler.handle(x.asScala.map(x => TopicPartition(x)))})
    this
  }

  /**
   * Set the handler called when topic partitions are assigned to the consumer   * @param handler handler called on assigned topic partitions
   * @return current KafkaConsumer instance
   */
  
  def partitionsAssignedHandler(handler: Handler[scala.collection.mutable.Set[TopicPartition]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].partitionsAssignedHandler({x: java.util.Set[JTopicPartition] => handler.handle(x.asScala.map(x => TopicPartition(x)))})
    this
  }

  /**
   * Overrides the fetch offsets that the consumer will use on the next poll.   * @param topicPartition topic partition for which seek see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @param offset offset to seek inside the topic partition
   * @return current KafkaConsumer instance
   */
  
  def seek(topicPartition: TopicPartition, offset: Long): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seek(topicPartition.asJava, offset.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Overrides the fetch offsets that the consumer will use on the next poll.
   * 
   * Due to internal buffering of messages,
   * the  will
   * continue to observe messages fetched with respect to the old offset
   * until some time <em>after</em> the given `completionHandler`
   * is called. In contrast, the once the given `completionHandler`
   * is called the [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#batchHandler]] will only see messages
   * consistent with the new offset.   * @param topicPartition topic partition for which seek see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @param offset offset to seek inside the topic partition
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def seek(topicPartition: TopicPartition, offset: Long, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seek(topicPartition.asJava, offset.asInstanceOf[java.lang.Long], {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Seek to the first offset for each of the given partition.   * @param topicPartition topic partition for which seek see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @return current KafkaConsumer instance
   */
  
  def seekToBeginning(topicPartition: TopicPartition): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToBeginning(topicPartition.asJava)
    this
  }

  /**
   * Seek to the first offset for each of the given partitions.   * @param topicPartitions topic partition for which seek
   * @return current KafkaConsumer instance
   */
  
  def seekToBeginning(topicPartitions: scala.collection.mutable.Set[TopicPartition]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToBeginning(topicPartitions.map(x => x.asJava).asJava)
    this
  }

  /**
   * Seek to the first offset for each of the given partition.
   * 
   * Due to internal buffering of messages,
   * the  will
   * continue to observe messages fetched with respect to the old offset
   * until some time <em>after</em> the given `completionHandler`
   * is called. In contrast, the once the given `completionHandler`
   * is called the [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#batchHandler]] will only see messages
   * consistent with the new offset.   * @param topicPartition topic partition for which seek see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def seekToBeginning(topicPartition: TopicPartition, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToBeginning(topicPartition.asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Seek to the first offset for each of the given partitions.
   * 
   * Due to internal buffering of messages,
   * the  will
   * continue to observe messages fetched with respect to the old offset
   * until some time <em>after</em> the given `completionHandler`
   * is called. In contrast, the once the given `completionHandler`
   * is called the [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#batchHandler]] will only see messages
   * consistent with the new offset.   * @param topicPartitions topic partition for which seek
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def seekToBeginning(topicPartitions: scala.collection.mutable.Set[TopicPartition], completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToBeginning(topicPartitions.map(x => x.asJava).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Seek to the last offset for each of the given partition.   * @param topicPartition topic partition for which seek see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @return current KafkaConsumer instance
   */
  
  def seekToEnd(topicPartition: TopicPartition): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToEnd(topicPartition.asJava)
    this
  }

  /**
   * Seek to the last offset for each of the given partitions.   * @param topicPartitions topic partition for which seek
   * @return current KafkaConsumer instance
   */
  
  def seekToEnd(topicPartitions: scala.collection.mutable.Set[TopicPartition]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToEnd(topicPartitions.map(x => x.asJava).asJava)
    this
  }

  /**
   * Seek to the last offset for each of the given partition.
   * 
   * Due to internal buffering of messages,
   * the  will
   * continue to observe messages fetched with respect to the old offset
   * until some time <em>after</em> the given `completionHandler`
   * is called. In contrast, the once the given `completionHandler`
   * is called the [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#batchHandler]] will only see messages
   * consistent with the new offset.   * @param topicPartition topic partition for which seek see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def seekToEnd(topicPartition: TopicPartition, completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToEnd(topicPartition.asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Seek to the last offset for each of the given partitions.
   * 
   * Due to internal buffering of messages,
   * the  will
   * continue to observe messages fetched with respect to the old offset
   * until some time <em>after</em> the given `completionHandler`
   * is called. In contrast, the once the given `completionHandler`
   * is called the [[io.vertx.scala.kafka.client.consumer.KafkaConsumer#batchHandler]] will only see messages
   * consistent with the new offset.   * @param topicPartitions topic partition for which seek
   * @param completionHandler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def seekToEnd(topicPartitions: scala.collection.mutable.Set[TopicPartition], completionHandler: Handler[AsyncResult[Unit]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToEnd(topicPartitions.map(x => x.asJava).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Get metadata about the partitions for a given topic.   * @param topic topic partition for which getting partitions info
   * @param handler handler called on operation completed
   * @return current KafkaConsumer instance
   */
  
  def partitionsFor(topic: String, handler: Handler[AsyncResult[scala.collection.mutable.Buffer[PartitionInfo]]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].partitionsFor(topic.asInstanceOf[java.lang.String], {x: AsyncResult[java.util.List[JPartitionInfo]] => handler.handle(AsyncResultWrapper[java.util.List[JPartitionInfo], scala.collection.mutable.Buffer[PartitionInfo]](x, a => a.asScala.map(x => PartitionInfo(x))))})
    this
  }

  /**
   * Set the handler to be used when batches of messages are fetched
   * from the Kafka server. Batch handlers need to take care not to block
   * the event loop when dealing with large batches. It is better to process
   * records individually using the [[io.vertx.scala.kafka.client.consumer.KafkaConsumer]].   * @param handler handler called when batches of messages are fetched
   * @return current KafkaConsumer instance
   */
  
  def batchHandler(handler: Handler[KafkaConsumerRecords[K, V]]): KafkaConsumer[K, V] = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].batchHandler({x: JKafkaConsumerRecords[Object, Object] => handler.handle(KafkaConsumerRecords[K, V](x))})
    this
  }


  /**
   * Close the consumer
   */
  def close(): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].close()
  }


  /**
   * Get the set of partitions that were previously paused by a call to pause(Set).   * @param handler handler called on operation completed
   */
  def paused (handler: Handler[AsyncResult[scala.collection.mutable.Set[TopicPartition]]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].paused({x: AsyncResult[java.util.Set[JTopicPartition]] => handler.handle(AsyncResultWrapper[java.util.Set[JTopicPartition], scala.collection.mutable.Set[TopicPartition]](x, a => a.asScala.map(x => TopicPartition(x))))})
  }

  /**
   * Commit current offsets for all the subscribed list of topics and partition.
   */
  def commit (): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].commit()
  }

  /**
   * Commit current offsets for all the subscribed list of topics and partition.   * @param completionHandler handler called on operation completed
   */
  def commit (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].commit({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Get the last committed offset for the given partition (whether the commit happened by this process or another).   * @param topicPartition topic partition for getting last committed offset see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @param handler handler called on operation completed
   */
  def committed (topicPartition: TopicPartition, handler: Handler[AsyncResult[OffsetAndMetadata]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].committed(topicPartition.asJava, {x: AsyncResult[JOffsetAndMetadata] => handler.handle(AsyncResultWrapper[JOffsetAndMetadata, OffsetAndMetadata](x, a => OffsetAndMetadata(a)))})
  }

  /**
   * Close the consumer   * @param completionHandler handler called on operation completed
   */
  def close (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].close({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Get the offset of the next record that will be fetched (if a record with that offset exists).   * @param partition The partition to get the position for see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @param handler handler called on operation completed
   */
  def position (partition: TopicPartition, handler: Handler[AsyncResult[Long]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].position(partition.asJava, {x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long, Long](x, a => a.asInstanceOf[Long]))})
  }

  /**
   * Look up the offset for the given partition by timestamp. Note: the result might be null in case
   * for the given timestamp no offset can be found -- e.g., when the timestamp refers to the future   * @param topicPartition TopicPartition to query. see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @param timestamp Timestamp to be used in the query.
   * @param handler handler called on operation completed
   */
  def offsetsForTimes (topicPartition: TopicPartition, timestamp: Long, handler: Handler[AsyncResult[OffsetAndTimestamp]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].offsetsForTimes(topicPartition.asJava, timestamp.asInstanceOf[java.lang.Long], {x: AsyncResult[JOffsetAndTimestamp] => handler.handle(AsyncResultWrapper[JOffsetAndTimestamp, OffsetAndTimestamp](x, a => OffsetAndTimestamp(a)))})
  }

  /**
   * Get the first offset for the given partitions.   * @param topicPartition the partition to get the earliest offset. see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @param handler handler called on operation completed. Returns the earliest available offset for the given partition
   */
  def beginningOffsets (topicPartition: TopicPartition, handler: Handler[AsyncResult[Long]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].beginningOffsets(topicPartition.asJava, {x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long, Long](x, a => a.asInstanceOf[Long]))})
  }

  /**
   * Get the last offset for the given partition. The last offset of a partition is the offset
   * of the upcoming message, i.e. the offset of the last available message + 1.   * @param topicPartition the partition to get the end offset. see <a href="../../../../../../../../cheatsheet/TopicPartition.html">TopicPartition</a>
   * @param handler handler called on operation completed. The end offset for the given partition.
   */
  def endOffsets (topicPartition: TopicPartition, handler: Handler[AsyncResult[Long]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].endOffsets(topicPartition.asJava, {x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long, Long](x, a => a.asInstanceOf[Long]))})
  }

  /**
   * Sets the poll timeout (in ms) for the underlying native Kafka Consumer. Defaults to 1000.
   * Setting timeout to a lower value results in a more 'responsive' client, because it will block for a shorter period
   * if no data is available in the assigned partition and therefore allows subsequent actions to be executed with a shorter
   * delay. At the same time, the client will poll more frequently and thus will potentially create a higher load on the Kafka Broker.   * @param timeout The time, in milliseconds, spent waiting in poll if data is not available in the buffer. If 0, returns immediately with any records that are available currently in the native Kafka consumer's buffer, else returns empty. Must not be negative.
   */
  def pollTimeout (timeout: Long): KafkaConsumer[K, V] = {
    KafkaConsumer[K, V](asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pollTimeout(timeout.asInstanceOf[java.lang.Long]))
  }

  /**
   * Executes a poll for getting messages from Kafka   * @param timeout The time, in milliseconds, spent waiting in poll if data is not available in the buffer. If 0, returns immediately with any records that are available currently in the native Kafka consumer's buffer, else returns empty. Must not be negative.
   * @param handler handler called after the poll with batch of records (can be empty).
   */
  def poll (timeout: Long, handler: Handler[AsyncResult[KafkaConsumerRecords[K, V]]]): Unit = {
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].poll(timeout.asInstanceOf[java.lang.Long], {x: AsyncResult[JKafkaConsumerRecords[Object, Object]] => handler.handle(AsyncResultWrapper[JKafkaConsumerRecords[Object, Object], KafkaConsumerRecords[K, V]](x, a => KafkaConsumerRecords[K, V](a)))})
  }


 /**
  * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def subscribeFuture (topic: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscribe(topic.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[subscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def subscribeFuture (topics: scala.collection.mutable.Set[String]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscribe(topics.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[assign]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def assignFuture (topicPartition: TopicPartition): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assign(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[assign]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def assignFuture (topicPartitions: scala.collection.mutable.Set[TopicPartition]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assign(topicPartitions.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[assignment]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def assignmentFuture (): scala.concurrent.Future[scala.collection.mutable.Set[TopicPartition]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[JTopicPartition], scala.collection.mutable.Set[TopicPartition]](x => x.asScala.map(x => TopicPartition(x)))
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].assignment(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[unsubscribe]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def unsubscribeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].unsubscribe(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[subscription]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def subscriptionFuture (): scala.concurrent.Future[scala.collection.mutable.Set[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[java.lang.String], scala.collection.mutable.Set[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].subscription(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[pause]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pauseFuture (topicPartition: TopicPartition): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[pause]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pauseFuture (topicPartitions: scala.collection.mutable.Set[TopicPartition]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].pause(topicPartitions.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[paused]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pausedFuture (): scala.concurrent.Future[scala.collection.mutable.Set[TopicPartition]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[JTopicPartition], scala.collection.mutable.Set[TopicPartition]](x => x.asScala.map(x => TopicPartition(x)))
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].paused(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[resume]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def resumeFuture (topicPartition: TopicPartition): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[resume]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def resumeFuture (topicPartitions: scala.collection.mutable.Set[TopicPartition]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].resume(topicPartitions.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[seek]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def seekFuture (topicPartition: TopicPartition, offset: Long): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seek(topicPartition.asJava, offset.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[seekToBeginning]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def seekToBeginningFuture (topicPartition: TopicPartition): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToBeginning(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[seekToBeginning]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def seekToBeginningFuture (topicPartitions: scala.collection.mutable.Set[TopicPartition]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToBeginning(topicPartitions.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[seekToEnd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def seekToEndFuture (topicPartition: TopicPartition): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToEnd(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[seekToEnd]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def seekToEndFuture (topicPartitions: scala.collection.mutable.Set[TopicPartition]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].seekToEnd(topicPartitions.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[commit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def commitFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].commit(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[committed]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def committedFuture (topicPartition: TopicPartition): scala.concurrent.Future[OffsetAndMetadata] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JOffsetAndMetadata, OffsetAndMetadata](x => OffsetAndMetadata(x))
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].committed(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[partitionsFor]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def partitionsForFuture (topic: String): scala.concurrent.Future[scala.collection.mutable.Buffer[PartitionInfo]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JPartitionInfo], scala.collection.mutable.Buffer[PartitionInfo]](x => x.asScala.map(x => PartitionInfo(x)))
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].partitionsFor(topic.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[position]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def positionFuture (partition: TopicPartition): scala.concurrent.Future[Long] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].position(partition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[offsetsForTimes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def offsetsForTimesFuture (topicPartition: TopicPartition, timestamp: Long): scala.concurrent.Future[OffsetAndTimestamp] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JOffsetAndTimestamp, OffsetAndTimestamp](x => OffsetAndTimestamp(x))
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].offsetsForTimes(topicPartition.asJava, timestamp.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[beginningOffsets]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def beginningOffsetsFuture (topicPartition: TopicPartition): scala.concurrent.Future[Long] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].beginningOffsets(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[endOffsets]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def endOffsetsFuture (topicPartition: TopicPartition): scala.concurrent.Future[Long] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].endOffsets(topicPartition.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[poll]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pollFuture (timeout: Long): scala.concurrent.Future[KafkaConsumerRecords[K, V]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JKafkaConsumerRecords[Object, Object], KafkaConsumerRecords[K, V]](x => KafkaConsumerRecords[K, V](x))
    asJava.asInstanceOf[JKafkaConsumer[Object, Object]].poll(timeout.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object KafkaConsumer {
  def apply[K: TypeTag, V: TypeTag](asJava: JKafkaConsumer[_, _]) = new KafkaConsumer[K, V](asJava)
  
  /**
   * Create a new KafkaConsumer instance   * @param vertx Vert.x instance to use
   * @param config Kafka consumer configuration
   * @return an instance of the KafkaConsumer
   */
  def create[K: TypeTag, V: TypeTag](vertx: Vertx,config: scala.collection.mutable.Map[String, String]): KafkaConsumer[K, V] = {
    KafkaConsumer[K, V](JKafkaConsumer.create[Object, Object](vertx.asJava.asInstanceOf[JVertx], config.mapValues(x => x.asInstanceOf[java.lang.String]).asJava))
  }

  /**
   * Create a new KafkaConsumer instance   * @param vertx Vert.x instance to use
   * @param config Kafka consumer configuration
   * @param keyType class type for the key deserialization
   * @param valueType class type for the value deserialization
   * @return an instance of the KafkaConsumer
   */
  def create[K: TypeTag, V: TypeTag](vertx: Vertx,config: scala.collection.mutable.Map[String, String],keyType: Class[K],valueType: Class[V]): KafkaConsumer[K, V] = {
    KafkaConsumer[K, V](JKafkaConsumer.create[Object, Object](vertx.asJava.asInstanceOf[JVertx], config.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, toJavaClass(keyType), toJavaClass(valueType)))
  }

}
