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

package io.vertx.scala.ext.auth

import io.vertx.ext.auth.{HashingAlgorithm => JHashingAlgorithm}
import scala.reflect.runtime.universe._
import scala.collection.JavaConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Hashing Algorithm. A common interface to interact with any system provided algorithms.
  */

class HashingAlgorithm(private val _asJava: Object) {
  def asJava = _asJava




  /**
   * return the list of param names required for this algorithm.   * @return set of param names.
   */
  def params(): scala.collection.mutable.Set[String] = {
    asJava.asInstanceOf[JHashingAlgorithm].params().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Should the encoded string use the default separator to split fields.   * @return true by default.
   */
  def needsSeparator(): Boolean = {
    asJava.asInstanceOf[JHashingAlgorithm].needsSeparator().asInstanceOf[Boolean]
  }


  /**
   * return the symbolic name for the algorithm   * @return short id e.g.: sha512.
   */
  def id (): String = {
    asJava.asInstanceOf[JHashingAlgorithm].id().asInstanceOf[String]
  }


}

object HashingAlgorithm {
  def apply(asJava: JHashingAlgorithm) = new HashingAlgorithm(asJava)

}
