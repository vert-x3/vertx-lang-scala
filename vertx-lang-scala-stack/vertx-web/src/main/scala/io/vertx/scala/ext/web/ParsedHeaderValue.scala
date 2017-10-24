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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.{ParsedHeaderValue => JParsedHeaderValue}
import scala.collection.JavaConverters._

trait ParsedHeaderValue {

  def asJava: java.lang.Object

  /**
    * Contains the raw value that was received from the user agent
    */
  def rawValue(): String

  /**
    * Holds the unparsed value of the header.<br>
    * For the most part, this is the content before the semi-colon (";")
    */
  def value(): String

  /**
    * Holds the weight specified in the "q" parameter of the header.<br>
    * If the parameter is not specified, 1.0 is assumed according to
    * <a href="https://tools.ietf.org/html/rfc7231#section-5.3.1">rfc7231</a>
    * @return 
    */
  def weight(): Float

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
  def parameter(key: String): scala.Option[String]

  /**
    * The parameters specified in this header value.
    * <b>Note:</b> The <code>q</code> parameter is never present.
    * @return Unmodifiable Map of parameters of this header value
    */
  def parameters(): scala.collection.mutable.Map[String, String]

  /**
    * Is this an allowed operation as specified by the corresponding header?
    * @return 
    */
  def isPermitted(): Boolean

  /**
    * Test if this header is matched by matchTry header
    * @param matchTry The header to be matched from
    * @return true if this header represents a subset of matchTry, otherwise, false
    */
  def isMatchedBy(matchTry: ParsedHeaderValue): Boolean

  /**
    * An integer that represents the absolute order position of this header
    */
  def weightedOrder(): Int

}

object ParsedHeaderValue {
  def apply(asJava: JParsedHeaderValue): ParsedHeaderValue = new ParsedHeaderValueImpl(asJava)
    private class ParsedHeaderValueImpl(private val _asJava: Object) extends ParsedHeaderValue {

      def asJava = _asJava


  /**
    * Contains the raw value that was received from the user agent
    */
  def rawValue(): String = {
    asJava.asInstanceOf[JParsedHeaderValue].rawValue().asInstanceOf[String]
  }

  /**
    * Holds the unparsed value of the header.<br>
    * For the most part, this is the content before the semi-colon (";")
    */
  def value(): String = {
    asJava.asInstanceOf[JParsedHeaderValue].value().asInstanceOf[String]
  }

  /**
    * Holds the weight specified in the "q" parameter of the header.<br>
    * If the parameter is not specified, 1.0 is assumed according to
    * <a href="https://tools.ietf.org/html/rfc7231#section-5.3.1">rfc7231</a>
    * @return 
    */
  def weight(): Float = {
    asJava.asInstanceOf[JParsedHeaderValue].weight().asInstanceOf[Float]
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
    scala.Option(asJava.asInstanceOf[JParsedHeaderValue].parameter(key.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  /**
    * The parameters specified in this header value.
    * <b>Note:</b> The <code>q</code> parameter is never present.
    * @return Unmodifiable Map of parameters of this header value
    */
  def parameters(): scala.collection.mutable.Map[String, String] = {
    collection.mutable.Map(asJava.asInstanceOf[JParsedHeaderValue].parameters().asScala.mapValues(x => x.asInstanceOf[String]).toSeq: _*)
  }

  /**
    * Is this an allowed operation as specified by the corresponding header?
    * @return 
    */
  def isPermitted(): Boolean = {
    asJava.asInstanceOf[JParsedHeaderValue].isPermitted().asInstanceOf[Boolean]
  }

  /**
    * Test if this header is matched by matchTry header
    * @param matchTry The header to be matched from
    * @return true if this header represents a subset of matchTry, otherwise, false
    */
  def isMatchedBy(matchTry: ParsedHeaderValue): Boolean = {
    asJava.asInstanceOf[JParsedHeaderValue].isMatchedBy(matchTry.asJava.asInstanceOf[JParsedHeaderValue]).asInstanceOf[Boolean]
  }

  /**
    * An integer that represents the absolute order position of this header
    */
  def weightedOrder(): Int = {
    asJava.asInstanceOf[JParsedHeaderValue].weightedOrder().asInstanceOf[Int]
  }

}
}
