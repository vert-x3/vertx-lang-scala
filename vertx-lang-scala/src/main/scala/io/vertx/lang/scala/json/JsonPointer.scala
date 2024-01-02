package io.vertx.lang.scala.json

import java.net.URI
import scala.annotation.tailrec
import scala.reflect.Typeable

private type JJsonPointer = io.vertx.core.json.pointer.JsonPointer

final case class JsonPointer(private val internal: JJsonPointer):

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

  /**
   * Copy a `JsonPointer`
   */
  def copy: JsonPointer = JsonPointer(internal.copy())

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
  def appended(tokens: String*): JsonPointer =
    @tailrec def append(ptr: JsonPointer, tokens: String*): JsonPointer = tokens.headOption match
      case Some(token) => append(JsonPointer(ptr.internal.append(token)), tokens.tail *)
      case None        => ptr

    append(this.copy, tokens *)

  /**
   * This JsonPointer with the given index appended as reference token.
   */
  def appended(index: Int): JsonPointer = JsonPointer(internal.copy.append(index))

  /**
   * This JsonPointer with the given other JsonPointer appended.
   */
  def appended(other: JsonPointer): JsonPointer = JsonPointer(internal.copy.append(other.internal))

  /**
   * Evaluates to the parent pointer.
   */
  def parent: JsonPointer = JsonPointer(this.internal.copy.parent)

  /**
   * Query the given `jsonObject`, expecting the result to be of type [[T]].
   *
   * Note: If this pointer is a root pointer ("") and [[T]] is [[JsonObject]], this function returns the provided JSON.
   *
   * Note: JSON numbers will always result in the [[Double]] Scala type. The following JSON to Scala mappings apply:
   *
   * - `true/false` - `Boolean`
   * - `number` - `Double`
   * - `string` - `String`
   * - `array` - [[JsonArray]]
   * - `object` - [[JsonObject]]
   * - `null` - will always result in `None`
   *
   * @param jsonObject the JSON to query
   * @tparam T the expected result type of the query
   * @return `Some[T]` if the requested value exists **and** has the expected type [[T]],
   *         otherwise `None`
   */
  def query[T: Typeable](jsonObject: JsonObject): Option[T] = internal.queryJson(jsonObject) match
    case x: T => Some(x)
    case _    => None

end JsonPointer

object JsonPointer:

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
  def fromOption(pointer: String): Option[JsonPointer] =
    try
      Some(JsonPointer(io.vertx.core.json.pointer.JsonPointer.from(pointer)))
    catch
      case iae: IllegalArgumentException => None

  /**
   * Builds a [[JsonPointer]] from a URI, returning an [[Option]]. This comes
   * in handy in situations when it is unknown if the URI contains a valid
   * JSON pointer, e.g. if the URI is a variable.
   *
   * @param uri the uri representing the JSON pointer
   * @return [[Some Some(JsonPointer)]] if the given URI was valid, else [[None]]
   */
  def fromURIOption(uri: URI): Option[JsonPointer] =
    try
      Some(JsonPointer(io.vertx.core.json.pointer.JsonPointer.fromURI(uri)))
    catch
      case iae: IllegalArgumentException => None

end JsonPointer

