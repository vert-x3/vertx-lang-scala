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

package io.vertx.scala.ext.stomp

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.stomp.{Acknowledgement => JAcknowledgement}
import io.vertx.ext.stomp.{Frame => JFrame}
import io.vertx.scala.ext.stomp.Frame

/**
  * Structure passed to acknowledgement handler called when a `ACK` or `NACK` frame is received. The handler
  * receives an instance of [[io.vertx.scala.ext.stomp.Acknowledgement]] with the subscription <a href="../../../../../../../cheatsheet/Frame.html">Frame</a> and the impacted messages. The
  * list of messages depends on the type of acknowledgment used by the subscription.
  * <p/>
  * Subscriptions using the `client` mode receives all messages that were waiting for acknowledgment that were
  * sent before the acknowledged messages. The list also contains the acknowledged message. This is a cumulative
  * acknowledgement. Subscriptions using the `client-individual` mode receives a singleton list containing only
  * the acknowledged message.
  */
class Acknowledgement(private val _asJava: JAcknowledgement) {

  def asJava: JAcknowledgement = _asJava

  /**
    * @return the subscription framesee <a href="../../../../../../../cheatsheet/Frame.html">Frame</a>
    */
  def subscription(): Frame = {
    Frame(_asJava.subscription())
  }

  /**
    * @return the list of frames that have been acknowledged / not-acknowledged. The content of the list depends on the type of subscription.
    */
  def frames(): scala.collection.mutable.Buffer[Frame] = {
    _asJava.frames().asScala.map(x => Frame(x))
  }

}

object Acknowledgement {

  def apply(_asJava: JAcknowledgement): Acknowledgement =
    new Acknowledgement(_asJava)

}
