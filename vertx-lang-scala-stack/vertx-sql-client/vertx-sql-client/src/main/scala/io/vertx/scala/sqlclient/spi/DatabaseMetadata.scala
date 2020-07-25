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

package io.vertx.scala.sqlclient.spi

import scala.reflect.runtime.universe._
import io.vertx.sqlclient.spi.{DatabaseMetadata => JDatabaseMetadata}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Contains static metadata about the backend database server 

  */

class DatabaseMetadata(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * @return The product name of the backend database server
   */
  def productName (): String = {
    asJava.asInstanceOf[JDatabaseMetadata].productName().asInstanceOf[String]
  }

  /**
   * @return The full version string for the backend database server. This may be useful for for parsing more subtle aspects of the version string. For simple information like database major and minor version, use #majorVersion() and #minorVersion() instead.
   */
  def fullVersion (): String = {
    asJava.asInstanceOf[JDatabaseMetadata].fullVersion().asInstanceOf[String]
  }

  /**
   * @return The major version of the backend database server
   */
  def majorVersion (): Int = {
    asJava.asInstanceOf[JDatabaseMetadata].majorVersion().asInstanceOf[Int]
  }

  /**
   * @return The minor version of the backend database server
   */
  def minorVersion (): Int = {
    asJava.asInstanceOf[JDatabaseMetadata].minorVersion().asInstanceOf[Int]
  }


}

object DatabaseMetadata {
  def apply(asJava: JDatabaseMetadata) = new DatabaseMetadata(asJava)

}
