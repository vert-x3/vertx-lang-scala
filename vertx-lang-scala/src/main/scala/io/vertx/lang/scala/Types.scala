/*
 * Copyright (c) 2011-2016 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *     The Eclipse Public License is available at
 *     http://www.eclipse.org/legal/epl-v10.html
 *
 *     The Apache License v2.0 is available at
 *     http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.lang.scala

import io.vertx.core.json.{JsonArray, JsonObject}

/**
  * Type definitions for commonly used types.
  *
  * @author <a href="mailto:jochen@codepitbull.de">Jochen Mader</a
  */
object Types {
  type StringAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[String]]
  type BooleanAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Boolean]]
  type CharAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Char]]
  type ByteAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Byte]]
  type IntAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Int]]
  type ShortAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Short]]
  type LongAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Long]]
  type FloatAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Float]]
  type DoubleAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[Double]]
  type JsonObjectAsyncMsg= io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[JsonObject]]
  type JsonArrayAsyncMsg = io.vertx.core.AsyncResult[io.vertx.scala.core.eventbus.Message[JsonArray]]
}
