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

package io.vertx.scala.ext.auth.jdbc

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.json.JsonArray
import io.vertx.ext.auth.jdbc.{JDBCHashStrategy => JJDBCHashStrategy}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}

/**
  * Determines how the hashing is computed in the implementation
  *
  * You can implement this to provide a different hashing strategy to the default.
  */
class JDBCHashStrategy(private val _asJava: Object) {

  def asJava = _asJava


  /**
    * Compute a random salt.
    * @return a non null salt value
    */
  def generateSalt(): String = {
    asJava.asInstanceOf[JJDBCHashStrategy].generateSalt().asInstanceOf[String]
  }

  /**
    * Compute the hashed password given the unhashed password and the salt
    * @param password the unhashed password
    * @param salt the salt
    * @param version the nonce version to use
    * @return the hashed password
    */
  def computeHash(password: String, salt: String, version: Int): String = {
    asJava.asInstanceOf[JJDBCHashStrategy].computeHash(password.asInstanceOf[java.lang.String], salt.asInstanceOf[java.lang.String], version.asInstanceOf[java.lang.Integer]).asInstanceOf[String]
  }

  /**
    * Retrieve the hashed password from the result of the authentication query
    * @param row the row
    * @return the hashed password
    */
  def getHashedStoredPwd(row: io.vertx.core.json.JsonArray): String = {
    asJava.asInstanceOf[JJDBCHashStrategy].getHashedStoredPwd(row).asInstanceOf[String]
  }

  /**
    * Retrieve the salt from the result of the authentication query
    * @param row the row
    * @return the salt
    */
  def getSalt(row: io.vertx.core.json.JsonArray): String = {
    asJava.asInstanceOf[JJDBCHashStrategy].getSalt(row).asInstanceOf[String]
  }

  /**
    * Sets a ordered list of nonces where each position corresponds to a version.
    *
    * The nonces are supposed not to be stored in the underlying jdbc storage but to
    * be provided as a application configuration. The idea is to add one extra variable
    * to the hash function in order to make breaking the passwords using rainbow tables
    * or precomputed hashes harder. Leaving the attacker only with the brute force
    * approach.
    *
    * Nonces are dependent on the implementation. E.g.: for the SHA512 they are extra salt
    * used during the hashing, for the PBKDF2 they map the number of iterations the algorithm
    * should take
    * @param nonces a json array.
    */
  def setNonces(nonces: io.vertx.core.json.JsonArray): Unit = {
    asJava.asInstanceOf[JJDBCHashStrategy].setNonces(nonces)
  }

}

object JDBCHashStrategy {
  def apply(asJava: JJDBCHashStrategy) = new JDBCHashStrategy(asJava)  
  /**
    * This is the current backwards compatible hashing implementation, new applications should prefer the
    * PBKDF2 implementation, unless the tradeoff between security and CPU usage is an option.
    * @param vertx the vert.x instance
    * @return the implementation.
    */
  def createSHA512(vertx: Vertx): JDBCHashStrategy = {
    JDBCHashStrategy(JJDBCHashStrategy.createSHA512(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Implements a Hashing Strategy as per https://www.owasp.org/index.php/Password_Storage_Cheat_Sheet (2018-01-17).
    *
    * New deployments should use this strategy instead of the default one (which was the previous OWASP recommendation).
    *
    * The work factor can be updated by using the nonces json array.
    * @param vertx the vert.x instance
    * @return the implementation.
    */
  def createPBKDF2(vertx: Vertx): JDBCHashStrategy = {
    JDBCHashStrategy(JJDBCHashStrategy.createPBKDF2(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Time constant string comparision to avoid timming attacks.
    * @param hasha hash a to compare
    * @param hashb hash b to compare
    * @return true if equal
    */
  def isEqual(hasha: String, hashb: String): Boolean = {
    JJDBCHashStrategy.isEqual(hasha.asInstanceOf[java.lang.String], hashb.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }

}
