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

/**
  * Implementation of @see [[io.vertx.core.AsyncResult]]
  */
class ScalaAsyncResult[T](_result:T, _cause:Throwable) extends io.vertx.core.AsyncResult[T]{

  override def result(): T = _result

  override def cause(): Throwable = _cause

  override def succeeded(): Boolean = _result != null

  override def failed(): Boolean = _cause != null
}

object ScalaAsyncResult{
  def apply[T](result: T = null, cause: Throwable = null): ScalaAsyncResult[T] = new ScalaAsyncResult(result, cause)
}
