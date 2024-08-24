package io.vertx.lang.scala.itest.db

import io.vertx.core.eventbus.Message
import io.vertx.lang.scala.ScalaVerticle
import io.vertx.lang.scala.itest.domain.ToDo
import io.vertx.scala.core.JsonObject

import scala.concurrent.Promise
import scala.util.{Failure, Success, Try}

class ToDoDatabaseService(db: ToDoDatabase) extends ScalaVerticle {

  override def start(promise: Promise[Unit]): Unit = {
    vertx.eventBus.consumer(READ_ADDRESS).handler(handleRead)
    vertx.eventBus.consumer[ToDo](SAVE_ADDRESS).handler(handleWrite)
    vertx.eventBus.consumer(DELETE_ADDRESS).handler(handleDelete)
    promise.success(())
  }

  implicit class StringToLong(s: String) {
    def toLongOption: Option[Long] = Try(s.toLong).toOption
  }

  def handleRead(msg: Message[JsonObject]): Unit = msg.headers.get(ACTION_HEADER) match {

    case LOAD_ALL_ACTION => for {
        allToDos <- db.loadAll
      } yield msg.reply(allToDos)
    case LOAD_BY_ID_ACTION =>
      (for {
        idStr <- Option(msg.headers.get(ID_HEADER))
        idLong <- idStr.toLongOption
      } yield ID(idLong)) match {
        case None => msg.reply(None)
        case Some(id) => for {
          todoOption <- db.load(id)
        } yield msg.reply(todoOption)
      }
  }

  def handleWrite(msg: Message[ToDo]): Unit = for {
    id <- db.save(msg.body)
  } yield msg.reply(id)

  def handleDelete(msg: Message[JsonObject]): Unit =
    Option(msg.headers.get(ID_HEADER)).flatMap(_.toLongOption) match {
      case None => msg.reply(false)
      case Some(id)
      => db.delete(ID(id)).andThen {
        case Failure(exception) => msg.reply(false)
        case Success(isDeleted) => msg.reply(isDeleted)
      }
    }
}
