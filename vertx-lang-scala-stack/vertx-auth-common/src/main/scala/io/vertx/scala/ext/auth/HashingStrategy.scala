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

import io.vertx.ext.auth.{HashingStrategy => JHashingStrategy}
import io.vertx.ext.auth.{HashingAlgorithm => JHashingAlgorithm}
import scala.reflect.runtime.universe._
import scala.collection.JavaConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Hashing Strategy manager.
  *
  * This class will load system provided hashing strategies and algorithms.
  */

class HashingStrategy(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Put or replace an algorithm into the list of system loaded algorithms.   * @param id the algorithm id
   * @param algorithm the implementation
   * @return self
   */
  
  def put(id: String, algorithm: HashingAlgorithm): HashingStrategy = {
    asJava.asInstanceOf[JHashingStrategy].put(id.asInstanceOf[java.lang.String], algorithm.asJava.asInstanceOf[JHashingAlgorithm])
    this
  }



  /**
   * Hashes a password.   * @param id the algorithm id
   * @param params the algorithm specific paramters
   * @param salt the given salt
   * @param password the given password
   * @return the hashed string
   */
  def hash (id: String, params: scala.collection.mutable.Map[String, String], salt: String, password: String): String = {
    asJava.asInstanceOf[JHashingStrategy].hash(id.asInstanceOf[java.lang.String], params.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, salt.asInstanceOf[java.lang.String], password.asInstanceOf[java.lang.String]).asInstanceOf[String]
  }

  /**
   * Time constant password check. Regardless of the check, this algorithm executes the same number of
   * checks regardless of the correctly number of characters   * @param hash the hash to verify
   * @param password the password to test against
   * @return boolean
   */
  def verify (hash: String, password: String): Boolean = {
    asJava.asInstanceOf[JHashingStrategy].verify(hash.asInstanceOf[java.lang.String], password.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }

  /**
   * Get an algorithm interface by its Id   * @param id the algorithm id
   * @return the algorithm
   */
  def get (id: String): HashingAlgorithm = {
    HashingAlgorithm(asJava.asInstanceOf[JHashingStrategy].get(id.asInstanceOf[java.lang.String]))
  }


}

object HashingStrategy {
  def apply(asJava: JHashingStrategy) = new HashingStrategy(asJava)

  /**
   * Factory method to load the algorithms from the system   * @return a Hashing Strategy capable of hashing using the available algorithms
   */
  def load(): HashingStrategy = {
    HashingStrategy(JHashingStrategy.load())//2 load
  }

}
