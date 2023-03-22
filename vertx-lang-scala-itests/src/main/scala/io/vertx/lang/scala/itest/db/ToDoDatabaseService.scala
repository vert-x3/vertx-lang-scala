package io.vertx.lang.scala.itest.db

import io.vertx.core.eventbus.Message
import io.vertx.lang.scala.ScalaVerticle
import io.vertx.lang.scala.itest.domain.ToDo
import io.vertx.scala.core.JsonObject

import scala.concurrent.Future
import scala.concurrent.Promise

class ToDoDatabaseService(db: ToDoDatabase) extends ScalaVerticle:

  override def start(promise: Promise[Unit]): Unit = 
    vertx.eventBus.consumer(READ_ADDRESS).handler(handleRead)
    vertx.eventBus.consumer[ToDo](SAVE_ADDRESS).handler(handleWrite)
    vertx.eventBus.consumer(DELETE_ADDRESS).handler(handleDelete)
    promise.success(())


  def handleRead(msg: Message[JsonObject]): Unit = msg.headers.get(ACTION_HEADER) match
    case LOAD_ALL_ACTION   => for {
        allToDos <- db.loadAll
      } yield msg.reply(allToDos)
    case LOAD_BY_ID_ACTION => 
      (for {
        idStr  <- Option(msg.headers.get(ID_HEADER))
        idLong <- idStr.toLongOption
      } yield ID(idLong)) match
        case None     => msg.reply(None)
        case Some(id) => for {
          todoOption <- db.load(id)
        } yield msg.reply(todoOption)
      
  def handleWrite(msg: Message[ToDo]): Unit = for {
    id <- db.save(msg.body)
  } yield msg.reply(id)

  def handleDelete(msg: Message[JsonObject]): Unit = 
    (for {
      idStr  <- Option(msg.headers.get(ID_HEADER))
      idLong <- idStr.toLongOption
    } yield ID(idLong)) match
      case None     => msg.reply(None)
      case Some(id) => for {
        id <- db.delete(id)
      } yield msg.reply(id)
    

object ToDoDatabaseService:
  val READ_ADDRESS: String = "todo.db.read"
  val SAVE_ADDRESS: String = "todo.db.write"
  val DELETE_ADDRESS: String = "todo.db.delete"
  val ACTION_HEADER: String = "action"
  val ID_HEADER: String = "id"
  val LOAD_ALL_ACTION: String = "loadAll"
  val LOAD_BY_ID_ACTION: String = "loadById"
  val SAVE_ACTION: String = "save"
  val DELETE_ACTION: String = "delete"

export ToDoDatabaseService.*