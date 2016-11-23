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

package io.vertx.scala.ext.web

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.web.{MIMEHeader => JMIMEHeader}
import io.vertx.ext.web.{ParsedHeaderValue => JParsedHeaderValue}

class MIMEHeader(private val _asJava: JMIMEHeader) 
    extends ParsedHeaderValue {

  def asJava: JMIMEHeader = _asJava

  /**
    * Contains the raw value that was received from the user agent 
    */
  def rawValue(): String = {
    _asJava.rawValue()
  }

  /**
    * Holds the unparsed value of the header.<br>
    * For the most part, this is the content before the semi-colon (";")
    */
  def value(): String = {
    _asJava.value()
  }

  /**
    * Holds the weight specified in the "q" parameter of the header.<br>
    * If the parameter is not specified, 1.0 is assumed according to 
    * <a href="https://tools.ietf.org/html/rfc7231#section-5.3.1">rfc7231</a>
    * @return 
    */
  def weight(): Float = {
    _asJava.weight()
  }

  /**
    * The value of the parameter specified by this key. Each is one of 3 things:
    * <ol>
    * <li>null &lt;- That key was not specified</li>
    * <li>ParsedHeaderValue.EMPTY (tested using ==) &lt;- The value was not specified</li>
    * <li>[Other] <- The value of the parameter</li>
    * </ol>
    * <b>Note:</b> The <code>q</code> parameter is never present.
    * @return 
    */
  def parameter(key: String): scala.Option[String] = {
    scala.Option(_asJava.parameter(key))
  }

  /**
    * The parameters specified in this header value.
    * <b>Note:</b> The <code>q</code> parameter is never present.
    * @return Unmodifiable Map of parameters of this header value
    */
  def parameters(): Map[String, String] = {
    _asJava.parameters().asScala.toMap
  }

  /**
    * Is this an allowed operation as specified by the corresponding header?
    * @return 
    */
  def isPermitted(): Boolean = {
    _asJava.isPermitted()
  }

  /**
    * Test if this header is matched by matchTry header 
    * @param matchTry The header to be matched from
    * @return true if this header represents a subset of matchTry, otherwise, false
    */
  def isMatchedBy(matchTry: ParsedHeaderValue): Boolean = {
    _asJava.isMatchedBy(matchTry.asJava.asInstanceOf[JParsedHeaderValue])
  }

  /**
    * An integer that represents the absolute order position of this header
    */
  def weightedOrder(): Int = {
    _asJava.weightedOrder()
  }

  /**
    * Gets the parsed component part of the MIME. This is the string between the beginning and the first @{code '/'`
    * of the MIME
    * @return The component of the MIME this represents
    */
  def component(): String = {
    _asJava.component()
  }

  /**
    * Gets the parsed subcomponent part of the MIME. This is the string between the first @{code '/'` and the
    * @return The subcomponent of the MIME this represents
    */
  def subComponent(): String = {
    _asJava.subComponent()
  }

}

object MIMEHeader {

  def apply(_asJava: JMIMEHeader): MIMEHeader =
    new MIMEHeader(_asJava)

}
