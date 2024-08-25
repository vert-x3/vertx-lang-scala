package io.vertx.lang.scala.json

import io.vertx.core.json.{JsonArray, JsonObject}

import java.net.URI
import scala.annotation.tailrec
import io.vertx.core.json.pointer.JsonPointer as JJsonPointer

import scala.reflect.ClassTag

/**
 * Implementation of [[https://tools.ietf.org/html/rfc6901 RFC6901 Json Pointers]]. This
 * wraps [[io.vertx.core.json.pointer.JsonPointer]] and makes it behave more Scala-like.
 * @param internal the wrapped Vert.x [[io.vertx.core.json.pointer.JsonPointer]]
 */
final case class JsonPointer(private val internal: JJsonPointer) {

  /**
   * @return `true` if the pointer is a root pointer
   */
  def isRootPointer: Boolean = internal.isRootPointer

  /**
   * @return `true` if the pointer is local (URI with only fragment)
   */
  def isLocalPointer: Boolean = internal.isLocalPointer

  /**
   * @return `true` if this pointer is a parent of the given `child`. For instance,
   *         `"/properties"` pointer is parent pointer of `"/properties/parent"`
   */
  def isParent(child: JsonPointer): Boolean = internal.isParent(child.internal)

  override def toString: String = internal.toString

  /**
   * Build a <a href="https://tools.ietf.org/html/rfc6901#section-6">URI representation</a> of the JSON Pointer
   */
  def toURI: URI = internal.toURI

  /**
   * Return the underlying URI without the fragment
   */
  def getURIWithoutFragment: URI = internal.getURIWithoutFragment

  /**
   * This pointer appended with String tokens.
   *
   * @param tokens the tokens to append which must not contain escaped characters
   */
  def appended(tokens: String*): JsonPointer = {
    @tailrec def append(ptr: JsonPointer, tokens: String*): JsonPointer = tokens.headOption match {
      case Some(token) => append(JsonPointer(ptr.internal.append(token)), tokens.tail *)
      case None        => ptr
    }
    append(JsonPointer(internal.copy()), tokens *)
  }

  /**
   * This JsonPointer with the given index appended as reference token.
   *
   * Note: This function does not mutate this JsonPointer.
   */
  def appended(index: Int): JsonPointer = JsonPointer(internal.copy.append(index))

  /**
   * This JsonPointer with the given other JsonPointer appended.
   *
   * Note: This function does not mutate this JsonPointer.
   */
  def appended(other: JsonPointer): JsonPointer = JsonPointer(internal.copy.append(other.internal))

  /**
   * Evaluates to the parent pointer.
   */
  def parent: JsonPointer = JsonPointer(this.internal.copy.parent)

  /**
   * Query the given `jsonObject`, expecting the result to be of type [[T]].
   *
   * <p>Note: If this pointer is a root pointer ("") and [[T]] is [[JsonObject]], this function returns
   * the provided JSON.</p>
   *
   * <p>Note: JSON numbers will always result in the [[Double]] Scala type. The following JSON to Scala mappings apply:
   * <ul>
   * <li>`true/false` - `Boolean`</li>
   * <li>`number` - `Double`</li>
   * <li>`string` - `String`</li>
   * <li>`array` - [[JsonArray]]</li>
   * <li>`object` - [[JsonObject]]</li>
   * <li>`null` - will always result in `None`</li>
   * </ul>
   * </p>
   *
   * @param jsonObject the JSON to query
   * @tparam T the expected result type of the query
   * @return `Some[T]` if the requested value exists and has the expected type [[T]],
   *         otherwise `None`
   */
  def query[T: ClassTag](jsonObject: JsonObject): Option[T] = internal.queryJson(jsonObject) match {
    case x: T => Some(x)
    case _ => None
  }

  /**
   * Write `newElement` to the given `json` using this pointer. The path token "-" is
   * handled as append to the end of an array.
   *
   * Note: This function does not mutate the given `json`.
   *
   * Note: If this is a root pointer, `newElement` will be returned.
   *
   * @param json            the JSON to write to
   * @param newElement      the new element to write
   * @param createIfMissing creates a new [[JsonObject]] when the parent object key is missing
   * @tparam J either a [[JsonObject]] or a [[JsonArray]]
   * @return `Some[J]` if the write was successful, `None` if not
   */
  def write(json: JsonObject, newElement: Any, createIfMissing: Boolean = false): Option[JsonObject] =
    internal.writeJson(json.copy, newElement, createIfMissing).asInstanceOf[JsonObject] match {
      case o: JsonObject => Some(o)
      case _ => None
    }

  def write(json: JsonArray, newElement: Any, createIfMissing: Boolean): Option[JsonArray] =
    internal.writeJson(json.copy, newElement, createIfMissing).asInstanceOf[JsonArray] match {
      case o: JsonArray => Some(o)
      case _ => None
    }

  def write(json: JsonArray, newElement: Any): Option[JsonArray] = write(json, newElement, false)
}

object JsonPointer {
  /**
   * @return an empty `JsonPointer`
   */
  def apply(): JsonPointer = JsonPointer(io.vertx.core.json.pointer.JsonPointer.create())

  /**
   * Builds a [[JsonPointer]] from a String.
   *
   * @param pointer the String representing a valid JSON pointer
   * @return the [[JsonPointer]]
   * @throws IllegalArgumentException if the given String is not a valid JSON pointer
   */
  def apply(pointer: String): JsonPointer = JsonPointer(io.vertx.core.json.pointer.JsonPointer.from(pointer))

  /**
   * Builds a [[JsonPointer]] from a [[java.net.URI]].
   *
   * @param pointer - the URI representing a valid JSON pointer
   * @return the [[JsonPointer]]
   * @throws IllegalArgumentException if the given URI is not a valid JSON pointer
   */
  def apply(pointer: URI): JsonPointer = JsonPointer(io.vertx.core.json.pointer.JsonPointer.fromURI(pointer))

  /**
   * Same as [[apply apply()]], for compatibility with Vert.x core.
   */
  def create(): JsonPointer = apply()

  /**
   * Same as [[apply apply(pointer)]], for compatibility with Vert.x core.
   *
   * @see [[apply]]
   */
  def from(pointer: String): JsonPointer = apply(pointer)

  /**
   * Builds a [[JsonPointer]] from a String, returning an [[Option]]. This comes
   * in handy in situations when it is unknown if the String contains a valid
   * JSON pointer, e.g. if the String is a variable.
   *
   * @param pointer the String representing a pointer
   * @return [[Some Some(JsonPointer)]] if the given String was valid, else [[None]]
   */
  def fromOption(pointer: String): Option[JsonPointer] = {
    try
      Some(JsonPointer(io.vertx.core.json.pointer.JsonPointer.from(pointer)))
    catch {
      case _: IllegalArgumentException => None
    }
  }

  /**
   * Builds a [[JsonPointer]] from a URI, returning an [[Option]]. This comes
   * in handy in situations when it is unknown if the URI contains a valid
   * JSON pointer, e.g. if the URI is a variable.
   *
   * @param uri the uri representing the JSON pointer
   * @return [[Some Some(JsonPointer)]] if the given URI was valid, else [[None]]
   */
  def fromURIOption(uri: URI): Option[JsonPointer] = {
    try
      Some(JsonPointer(io.vertx.core.json.pointer.JsonPointer.fromURI(uri)))
    catch {
      case _: IllegalArgumentException => None
    }
  }
}

