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

package io.vertx.scala.redis

import io.vertx.redis.{Script => JScript}
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Container for a script and its sha1 hash.
  */

class Script(private val _asJava: Object) {
  def asJava = _asJava






  def getScript (): String = {
    asJava.asInstanceOf[JScript].getScript().asInstanceOf[String]
  }


  def getSha1 (): String = {
    asJava.asInstanceOf[JScript].getSha1().asInstanceOf[String]
  }


}

object Script {
  def apply(asJava: JScript) = new Script(asJava)
  

  def create(script: String): Script = {
    Script(JScript.create(script.asInstanceOf[java.lang.String]))
  }


  def create(script: String,sha1: String): Script = {
    Script(JScript.create(script.asInstanceOf[java.lang.String], sha1.asInstanceOf[java.lang.String]))
  }

}
