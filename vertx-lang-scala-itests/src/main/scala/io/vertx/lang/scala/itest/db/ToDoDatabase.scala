package io.vertx.lang.scala.itest.db

import io.vertx.lang.scala.itest.domain.ToDo
import scala.concurrent.Future

/**
  * A [[ToDo ToDo's]] identifier in the database.
  */
opaque type ID = Long
object ID:
  def apply(id: Long): ID = id
given Ordering[ID] with
  def compare(x: ID, y: ID): Int = x.compare(y)
extension(id: ID)
  def +(other: ID) = ID(id + other)

/**
  * A database abstraction for the ToDo demo application.
  */
trait ToDoDatabase:

  /**
    * Write a [[ToDo]] into the database.
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
    */
  def delete(id: ID): Future[ID]
  