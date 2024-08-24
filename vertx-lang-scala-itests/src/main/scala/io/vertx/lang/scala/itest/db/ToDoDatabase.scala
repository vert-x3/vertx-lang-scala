package io.vertx.lang.scala.itest.db

import io.vertx.lang.scala.itest.domain.ToDo
import scala.concurrent.Future
import scala.concurrent.ExecutionContext

/**
  * A database abstraction for the ToDo demo application.
  */
trait ToDoDatabase {

  /**
   * Write a [[ToDo]] into the database.
   *
   * @return the [[ID identifier]] of the ToDo persisted
   */
  def save(todo: ToDo): Future[ID]

  /**
   * Load a [[ToDo]], identified by `id`, from the database.
   */
  def load(id: ID): Future[Option[ToDo]]

  /**
   * Load all [[ToDo ToDos]] from the database.
   */
  def loadAll: Future[Map[ID, ToDo]]

  /**
   * Delete a [[ToDo]], identified by `id`, from the database.
   *
   * @return `true` if and only if the [[ToDo]] was deleted
   */
  def delete(id: ID): Future[Boolean]
}
