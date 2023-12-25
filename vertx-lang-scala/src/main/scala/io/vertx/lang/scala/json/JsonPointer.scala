package io.vertx.lang.scala.json

import java.net.URI

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
  def copy(): JsonPointer = JsonPointer(internal.copy())

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
   * Append an unescaped token to this pointer
   *
   * @param token the unescaped reference token
   * @return a reference to this, so the API can be used fluently
   */
  def append(token: String): JsonPointer = JsonPointer(internal.append(token))

end JsonPointer

object JsonPointer:

  /**
   * @return an empty `JsonPointer`
   */
  def apply(): JsonPointer = JsonPointer(io.vertx.core.json.pointer.JsonPointer.create())

  /**
   * Builds a [[JsonPointer]] from a String.
   * @param pointer the String representing a valid JSON pointer
   * @return the [[JsonPointer]]
   * @throws IllegalArgumentException if the given String is not a valid JSON pointer
   */
  def apply(pointer: String): JsonPointer = JsonPointer(io.vertx.core.json.pointer.JsonPointer.from(pointer))

  /**
   * Builds a [[JsonPointer]] from a [[java.net.URI]].
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

