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

package io.vertx.scala.core.json.pointer

import scala.reflect.runtime.universe._
import io.vertx.core.json.pointer.{JsonPointer => JJsonPointer}
import scala.collection.JavaConverters._
import io.vertx.core.json.pointer.{JsonPointerIterator => JJsonPointerIterator}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Implementation of <a href="https://tools.ietf.org/html/rfc6901">RFC6901 Json Pointers</a>.
  */

class JsonPointer(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Append an unescaped `token` to this pointer <br/>
   * Note: If you provide escaped path the behaviour is undefined   * @param token the unescaped reference token
   * @return a reference to this, so the API can be used fluently
   */
  
  def append(token: String): JsonPointer = {
    asJava.asInstanceOf[JJsonPointer].append(token.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Append the `index` as reference token to JsonPointer   * @return a reference to this, so the API can be used fluently
   */
  
  def append(index: Int): JsonPointer = {
    asJava.asInstanceOf[JJsonPointer].append(index.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * Append an unescaped list of `tokens` to JsonPointer <br/>
   * Note: If you provide escaped paths the behaviour is undefined   * @param tokens unescaped reference tokens
   * @return a reference to this, so the API can be used fluently
   */
  
  def append(tokens: scala.collection.mutable.Buffer[String]): JsonPointer = {
    asJava.asInstanceOf[JJsonPointer].append(tokens.map(x => x.asInstanceOf[java.lang.String]).asJava)
    this
  }

  /**
   * Append all tokens of `pointer` to this pointer <br/>
   * Note: The base URI of this pointer will remain untouched   * @param pointer other pointer
   * @return a reference to this, so the API can be used fluently
   */
  
  def append(pointer: JsonPointer): JsonPointer = {
    asJava.asInstanceOf[JJsonPointer].append(pointer.asJava.asInstanceOf[JJsonPointer])
    this
  }

  /**
   * Remove last reference token of this pointer   * @return a reference to this, so the API can be used fluently
   */
  
  def parent(): JsonPointer = {
    asJava.asInstanceOf[JJsonPointer].parent()
    this
  }


  /**
   * Query `objectToQuery` using the provided [[io.vertx.scala.core.json.pointer.JsonPointerIterator]]. <br/>
   * If you need to query Vert.x json data structures, use [[io.vertx.scala.core.json.pointer.JsonPointer#queryJson]]<br/>
   * Note: if this pointer is a root pointer, this function returns the provided object   * @param objectToQuery the object to query
   * @param iterator the json pointer iterator that provides the logic to access to the objectToQuery
   * @return null if pointer points to not existing value, otherwise the requested value
   */
  def query(objectToQuery: AnyRef, iterator: JsonPointerIterator): scala.Option[AnyRef] = {
    scala.Option(toScala[java.lang.Object](asJava.asInstanceOf[JJsonPointer].query(objectToQuery, iterator.asJava.asInstanceOf[JJsonPointerIterator])))
  }

  /**
   * Query `jsonElement`. <br/>
   * Note: if this pointer is a root pointer, this function returns the provided json element   * @param jsonElement the json element to query
   * @return null if pointer points to not existing value, otherwise the requested value
   */
  def queryJson(jsonElement: AnyRef): scala.Option[AnyRef] = {
    scala.Option(toScala[java.lang.Object](asJava.asInstanceOf[JJsonPointer].queryJson(jsonElement)))
  }

  /**
   * Query `jsonElement`. If the query result is null, returns the default.<br/>
   * Note: if this pointer is a root pointer, this function returns the provided object   * @param jsonElement the json element to query
   * @param defaultValue default value if query result is null
   * @return null if pointer points to not existing value, otherwise the requested value
   */
  def queryJsonOrDefault(jsonElement: AnyRef, defaultValue: AnyRef): scala.Option[AnyRef] = {
    scala.Option(toScala[java.lang.Object](asJava.asInstanceOf[JJsonPointer].queryJsonOrDefault(jsonElement, defaultValue)))
  }

  /**
   * Write `newElement` in `jsonElement` using this pointer. The path token "-" is handled as append to end of array.   * @param jsonElement json element to query and write
   * @param newElement json to insert
   * @return a reference to json if the write was completed, a reference to newElement if the pointer is a root pointer, null if the write failed
   */
  def writeJson(jsonElement: AnyRef, newElement: AnyRef): AnyRef = {
    toScala[java.lang.Object](asJava.asInstanceOf[JJsonPointer].writeJson(jsonElement, newElement))
  }

  /**
   * Write `newElement` in `jsonElement` using this pointer. The path token "-" is handled as append to end of array.   * @param jsonElement json to query and write
   * @param newElement json to insert
   * @param createOnMissing create JsonObject when missing a object key or an array index
   * @return a reference to json if the write was completed, a reference to newElement if the pointer is a root pointer, null if the write failed
   */
  def writeJson(jsonElement: AnyRef, newElement: AnyRef, createOnMissing: Boolean): AnyRef = {
    toScala[java.lang.Object](asJava.asInstanceOf[JJsonPointer].writeJson(jsonElement, newElement, createOnMissing.asInstanceOf[java.lang.Boolean]))
  }


  /**
   * Return `true` if the pointer is a root pointer
   */
  def isRootPointer (): Boolean = {
    asJava.asInstanceOf[JJsonPointer].isRootPointer().asInstanceOf[Boolean]
  }

  /**
   * Return `true` if the pointer is local (URI with only fragment)
   */
  def isLocalPointer (): Boolean = {
    asJava.asInstanceOf[JJsonPointer].isLocalPointer().asInstanceOf[Boolean]
  }

  /**
   * Return `true` if this pointer is a parent pointer of `child`.
   * <br/>
   * For instance `"/properties"` pointer is parent pointer of `"/properties/parent"`   */
  def isParent (child: JsonPointer): Boolean = {
    asJava.asInstanceOf[JJsonPointer].isParent(child.asJava.asInstanceOf[JJsonPointer]).asInstanceOf[Boolean]
  }

  /**
   * Build a <a href="https://tools.ietf.org/html/rfc6901#section-5">string representation</a> of the JSON Pointer
   */
  override def toString (): String = {
    asJava.asInstanceOf[JJsonPointer].toString().asInstanceOf[String]
  }

  /**
   * Query `objectToQuery` using the provided [[io.vertx.scala.core.json.pointer.JsonPointerIterator]]. If the query result is null, returns the default. <br/>
   * If you need to query Vert.x json data structures, use [[io.vertx.scala.core.json.pointer.JsonPointer#queryJsonOrDefault]]<br/>
   * Note: if this pointer is a root pointer, this function returns the provided object   * @param objectToQuery the object to query
   * @param iterator the json pointer iterator that provides the logic to access to the objectToQuery
   * @param defaultValue default value if query result is null
   * @return null if pointer points to not existing value, otherwise the requested value
   */
  def queryOrDefault (objectToQuery: AnyRef, iterator: JsonPointerIterator, defaultValue: AnyRef): AnyRef = {
    toScala[java.lang.Object](asJava.asInstanceOf[JJsonPointer].queryOrDefault(objectToQuery, iterator.asJava.asInstanceOf[JJsonPointerIterator], defaultValue))
  }

  /**
   * Query `objectToQuery` tracing each element walked during the query, including the first and the result (if any).<br/>
   * The first element of the list is objectToQuery and the last is the result, or the element before the first null was encountered   * @param objectToQuery the object to query
   * @param iterator the json pointer iterator that provides the logic to access to the objectToQuery
   * @return the stream of walked elements
   */
  def tracedQuery (objectToQuery: AnyRef, iterator: JsonPointerIterator): scala.collection.mutable.Buffer[AnyRef] = {
    asJava.asInstanceOf[JJsonPointer].tracedQuery(objectToQuery, iterator.asJava.asInstanceOf[JJsonPointerIterator]).asScala.map(x => x)
  }

  /**
   * Write `newElement` in `objectToWrite` using this pointer. The path token "-" is handled as append to end of array <br/>
   * If you need to write in Vert.x json data structures, use [[io.vertx.scala.core.json.pointer.JsonPointer#writeJson]] (Object)`<br/>   * @param objectToWrite object to write
   * @param iterator the json pointer iterator that provides the logic to access to the objectToMutate
   * @param newElement object to insert
   * @param createOnMissing create objects when missing a object key or an array index
   * @return a reference to objectToWrite if the write was completed, a reference to newElement if the pointer is a root pointer, null if the write failed
   */
  def write (objectToWrite: AnyRef, iterator: JsonPointerIterator, newElement: AnyRef, createOnMissing: Boolean): AnyRef = {
    toScala[java.lang.Object](asJava.asInstanceOf[JJsonPointer].write(objectToWrite, iterator.asJava.asInstanceOf[JJsonPointerIterator], newElement, createOnMissing.asInstanceOf[java.lang.Boolean]))
  }

  /**
   * Copy a JsonPointer   * @return a copy of this pointer
   */
  def copy (): JsonPointer = {
    JsonPointer(asJava.asInstanceOf[JJsonPointer].copy())
  }


}

object JsonPointer {
  def apply(asJava: JJsonPointer) = new JsonPointer(asJava)

  /**
   * Build an empty JsonPointer   * @return a new empty JsonPointer
   */
  def create(): JsonPointer = {
    JsonPointer(JJsonPointer.create())//2 create
  }

  /**
   * Build a JsonPointer from a json pointer string   * @param pointer the string representing a pointer
   * @return new instance of JsonPointer
   */
  def from(pointer: String): JsonPointer = {
    JsonPointer(JJsonPointer.from(pointer.asInstanceOf[java.lang.String]))//2 from
  }

}
