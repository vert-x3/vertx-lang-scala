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

import io.vertx.core
import io.vertx.core.Handler

import scala.concurrent.Promise
import scala.language.implicitConversions

/**
  * Conversions between handlers and functions
  *
  * @author <a href="mailto:jochen@codepitbull.de">Jochen Mader</a
  */
object HandlerOps {

  /**
    * Safely convert from Java type to Scala type.
    *
    * @param conversion function to convert from Java to Scala
    * @tparam J incoming Java type
    * @tparam S outgoing Scala type
    * @return
    */
  def handlerForAsyncResultWithConversion[J, S](conversion: J => S): (Handler[core.AsyncResult[J]], Promise[S]) = {
    val promise = Promise[S]()
    val handler: Handler[core.AsyncResult[J]] = (event: core.AsyncResult[J]) => {
      if (event.failed())
        promise.failure(event.cause())
      else {
        try {
          promise.success(conversion(event.result()))
        }
        catch {
          case npe: NullPointerException => promise.failure(npe)
        }
      }
    }
    (handler, promise)
  }
}
