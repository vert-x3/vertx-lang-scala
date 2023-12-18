package io.vertx.lang.scala.json

import java.net.URI

type JJsonPointer = io.vertx.core.json.pointer.JsonPointer

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
  def isParent(child: JJsonPointer): Boolean = internal.isParent(child)

  /**
   * Copy a `JsonPointer`
   */
  def copy(): JsonPointer = JsonPointer(internal.copy())

  override def toString: String = internal.toString

end JsonPointer

object JsonPointer:

  /**
   * @return an empty `JsonPointer`
   */
  def apply(): JsonPointer = create()

  /**
   * Build an empty `JsonPointer`.
   */
  def create(): JsonPointer = JsonPointer(io.vertx.core.json.pointer.JsonPointer.create())

  /**
   * Build a `JsonPointer` from a JSON pointer String.
   *
   * @param pointer the String representing a pointer
   * @return [[Some Some(JsonPointer)]] if the given String was valid, else [[None]]
   */
  def from(pointer: String): Option[JsonPointer] =
    try
      Some(JsonPointer(io.vertx.core.json.pointer.JsonPointer.from(pointer)))
    catch
      case iae: IllegalArgumentException => None

  /**
   * Build a `JsonPointer` from a URI.
   *
   * @param uri the uri representing the JSON pointer
   * @return [[Some Some(JsonPointer)]] if the given URI was valid, else [[None]]
   */
  def fromURI(uri: URI): Option[JsonPointer] =
    try
      Some(JsonPointer(io.vertx.core.json.pointer.JsonPointer.fromURI(uri)))
    catch
      case iae: IllegalArgumentException => None


end JsonPointer

