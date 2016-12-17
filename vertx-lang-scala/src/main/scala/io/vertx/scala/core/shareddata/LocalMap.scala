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

package io.vertx.scala.core.shareddata


/**
  * Local maps can be used to share data safely in a single Vert.x instance.
  * 
  * The map only allows immutable keys and values in the map, OR certain mutable objects such as [[io.vertx.scala.core.buffer.Buffer]]
  * instances which will be copied when they are added to the map.
  * 
  * This ensures there is no shared access to mutable state from different threads (e.g. different event loops) in the
  * Vert.x instance, and means you don't have to protect access to that state using synchronization or locks.
  */
class LocalMap[K,V](private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JLocalMap]
//methods returning a future
//cached methods
//fluent methods
//basic methods
  def get(key: K):V = {
    asJava.get( )
  }

  def put(key: K,value: V):V = {
    asJava.put( )
  }

  def remove(key: K):V = {
    asJava.remove( )
  }

  def clear():Unit = {
    asJava.clear( )
  }

  def size():Int = {
    asJava.size( )
  }

  def isEmpty():Boolean = {
    asJava.isEmpty( )
  }

  def putIfAbsent(key: K,value: V):V = {
    asJava.putIfAbsent( )
  }

  def removeIfPresent(key: K,value: V):Boolean = {
    asJava.removeIfPresent( )
  }

  def replaceIfPresent(key: K,oldValue: V,newValue: V):Boolean = {
    asJava.replaceIfPresent( )
  }

  def replace(key: K,value: V):V = {
    asJava.replace( )
  }

  def close():Unit = {
    asJava.close( )
  }

}

object LocalMap{
//in object!
//static methods
}
