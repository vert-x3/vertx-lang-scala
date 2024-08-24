package io.vertx.lang.scala.itest

import io.vertx.lang.scala.itest.domain.ToDo
import scala.language.implicitConversions

package object db {
  /**
   * A [[ToDo ToDo's]] identifier in the database.
   */
  type ID = Long

  implicit class IDOps(id: ID) {
    def +(other: ID): ID = ID(id + other)
  }

  implicit val ordering: Ordering[ID] = (x: ID, y: ID) => x compare y

  object ID {
    def apply(id: Long): ID = id
  }

  val READ_ADDRESS: String = "todo.db.read"
  val SAVE_ADDRESS: String = "todo.db.write"
  val DELETE_ADDRESS: String = "todo.db.delete"
  val ACTION_HEADER: String = "action"
  val ID_HEADER: String = "id"
  val LOAD_ALL_ACTION: String = "loadAll"
  val LOAD_BY_ID_ACTION: String = "loadById"
  val SAVE_ACTION: String = "save"
  val DELETE_ACTION: String = "delete"
}
