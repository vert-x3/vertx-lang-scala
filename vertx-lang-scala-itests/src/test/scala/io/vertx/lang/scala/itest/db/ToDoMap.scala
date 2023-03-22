package io.vertx.lang.scala.itest.db

import io.vertx.lang.scala.itest.domain.ToDo
import scala.concurrent.Future

class ToDoMap(private var map: Map[ID, ToDo] = Map()) extends ToDoDatabase:
  override def load(id: ID): Future[Option[ToDo]] = Future.successful(map.get(id))
  override def loadAll: Future[Map[ID, ToDo]] = Future.successful(map)
  override def save(todo: ToDo): Future[ID] = Future.successful({
    val nextId = map.keys.maxOption.map(_ + 1).getOrElse(ID(1))
    map = map + (nextId -> todo)
    nextId
  })
  override def delete(id: ID): Future[ID] = Future.successful({
    map = map - id
    id
  })
