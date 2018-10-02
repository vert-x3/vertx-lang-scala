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
  * An implementation of [[io.vertx.core.AsyncResult]] that is used to convert a result of a Java-version into the Scala-variant.
  *
  * @author <a href="mailto:jochen@codepitbull.de">Jochen Mader</a>
  */
class AsyncResultWrapper[J,S](val _java: io.vertx.core.AsyncResult[J], val converter: J => S) extends io.vertx.core.AsyncResult[S]{

  lazy val result:S = converter(_java.result())

  override def cause(): Throwable = _java.cause()

  override def succeeded(): Boolean = _java.succeeded()

  override def failed(): Boolean = _java.failed()
}

object AsyncResultWrapper {
  def apply[J,S](asyncResult: io.vertx.core.AsyncResult[J], converter: J => S): io.vertx.core.AsyncResult[S] =
    new AsyncResultWrapper(asyncResult, converter)
}
