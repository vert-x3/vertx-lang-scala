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

package io.vertx.scala.codegen.testmodel

import scala.reflect.runtime.universe._
import io.vertx.codegen.testmodel.{SuperInterface1 => JSuperInterface1}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**

  */

class SuperInterface1(private val _asJava: Object) {
  def asJava = _asJava






  def superMethodWithBasicParams (b: Byte, s: Short, i: Int, l: Long, f: Float, d: Double, bool: Boolean, ch: Char, str: String): Unit = {
    asJava.asInstanceOf[JSuperInterface1].superMethodWithBasicParams(b.asInstanceOf[java.lang.Byte], s.asInstanceOf[java.lang.Short], i.asInstanceOf[java.lang.Integer], l.asInstanceOf[java.lang.Long], f.asInstanceOf[java.lang.Float], d.asInstanceOf[java.lang.Double], bool.asInstanceOf[java.lang.Boolean], ch.asInstanceOf[java.lang.Character], str.asInstanceOf[java.lang.String])
  }


  def superMethodOverloadedBySubclass (): Int = {
    asJava.asInstanceOf[JSuperInterface1].superMethodOverloadedBySubclass().asInstanceOf[Int]
  }


}

object SuperInterface1 {
  def apply(asJava: JSuperInterface1) = new SuperInterface1(asJava)

}
