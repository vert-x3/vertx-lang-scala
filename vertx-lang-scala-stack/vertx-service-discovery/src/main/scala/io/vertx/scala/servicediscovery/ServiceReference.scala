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

package io.vertx.scala.servicediscovery

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.servicediscovery.{ServiceReference => JServiceReference}
import io.vertx.servicediscovery.{Record => JRecord}

/**
  * Once a consumer has chosen a service, it builds a [[io.vertx.scala.servicediscovery.ServiceReference]] managing the binding with the chosen
  * service provider.
  * 
  * The reference lets the consumer:
  * * access the service (via a proxy or a client) with the [[io.vertx.scala.servicediscovery.ServiceReference#get]] method
  * * release the reference - so the binding between the consumer and the provider is removed
  */
class ServiceReference(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0:Record = _

  /**
    * @return the service record.see <a href="../../../../../../cheatsheet/Record.html">Record</a>
    */
  def record():Record = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JServiceReference].record()
      cached_0 = Record(tmp)
    }
    cached_0
  }

  /**
    * Gets the object to access the service. It can be a proxy, a client or whatever object. The type depends on the
    * service type and the server itself.
    * @return the object to access the service
    */
  def get[T:TypeTag]():T = {
    toScala[T](asJava.asInstanceOf[JServiceReference].get[Object]())
  }

  /**
    * Gets the service object if already retrieved. It won't try to acquire the service object if not retrieved yet.
    * @return the object, `null` if not yet retrieved
    */
  def cached[T:TypeTag]():T = {
    toScala[T](asJava.asInstanceOf[JServiceReference].cached[Object]())
  }

  /**
    * Releases the reference. Once released, the consumer must not use the reference anymore.
    * This method must be idempotent and defensive, as multiple call may happen.
    */
  def release():Unit = {
    asJava.asInstanceOf[JServiceReference].release()
  }

}

object ServiceReference{
  def apply(asJava: JServiceReference) = new ServiceReference(asJava)  
}
