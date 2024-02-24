package io.vertx.lang.scala.itest.db.jdbc

import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import io.vertx.lang.scala.itest.db.{ID, ToDoDatabase}
import io.vertx.lang.scala.itest.db.jdbc.ToDoDatabaseVertxJdbc.*
import io.vertx.lang.scala.itest.domain.ToDo
import io.vertx.lang.scala.itest.domain.ToDo.{Date, Note, Time, Title}
import io.vertx.sqlclient.{Pool, Row, RowSet, Tuple}

import java.time.{LocalDate, LocalTime}
import scala.annotation.tailrec
import scala.concurrent.{ExecutionContext, Future}
import scala.jdk.CollectionConverters.*
import scala.language.implicitConversions

class ToDoDatabaseJdbc(pool: Pool)(using ExecutionContext) extends ToDoDatabase:

  override def load(id: ID): Future[Option[ToDo]] =
    for {
      maybeTodo <- pool
        .preparedQuery(s"SELECT $TODO_ID, $TITLE, $NOTES, $DUE_DATE, $DUE_TIME FROM $TODO WHERE $TODO_ID = ?")
        .mapping(row => toIdAndToDo(row)._2)
        .execute(Tuple.of(id))
        .map(_.asScala.headOption)
    } yield maybeTodo

  override def loadAll: Future[Map[ID, ToDo]] =
    for {
      todos <- pool
        .query(s"SELECT $TODO_ID, $TITLE, $NOTES, $DUE_DATE, $DUE_TIME FROM $TODO")
        .mapping(toIdAndToDo)
        .execute()
        .map(_.iterator.asScala.toList.toMap)
    } yield todos

  override def save(todo: ToDo): Future[ID] = pool.withTransaction { conn =>
    for {
      id <- conn
        .preparedQuery(s"SELECT nextval('todo_id_seq') AS ID")
        .execute()
        .map(_.asScala.head.getLong("ID"))
      _  <- conn
        .preparedQuery(s"INSERT INTO $TODO ($TODO_ID, $TITLE, $NOTES, $DUE_DATE, $DUE_TIME) VALUES ($id, ?, ?, ?, ?)")
        .execute(asVertxTuple(todo))
    } yield ID(id)
  }

  override def delete(id: ID): Future[Boolean] =
    for {
      affectedRows <- pool
        .preparedQuery(s"DELETE FROM $TODO WHERE $TODO_ID = ?")
        .execute(Tuple.of(id))
        .map(_.rowCount)
      success = affectedRows == 1
    } yield success

object ToDoDatabaseVertxJdbc:
  val TODO_ID: String  = "ID"
  val TITLE: String    = "TITLE"
  val NOTES: String    = "NOTES"
  val DUE_DATE: String = "DUE_DATE"
  val DUE_TIME: String = "DUE_TIME"
  val TODO             = "TODO"

  def toIdAndToDo(row: Row): (ID, ToDo) =
    // id and title must be there
    val id           = ID(row.getLong(TODO_ID))
    val title        = row.getString(TITLE)
    val maybeNotes   = Option(row.getString(NOTES))
    val maybeDueDate = Option(row.getLocalDate(DUE_DATE))
    val maybeDueTime = Option(row.getLocalTime(DUE_TIME))
    id -> ToDo(Title(title), maybeNotes, maybeDueDate, maybeDueTime)

  def asVertxTuple(todo: ToDo): Tuple =
    val (title, notes, date, time) = asTuple(todo)
    Tuple.of(title, notes, date, time)

  type ToDoTuple = (String, String, LocalDate, LocalTime)
  @tailrec def asTuple(todo: ToDo, acc: ToDoTuple = (null, null, null, null)): ToDoTuple = todo match
    case Title(title)     => acc.copy(_1 = title)
    case Note(note, todo) => asTuple(todo, acc.copy(_2 = note))
    case Date(date, todo) => asTuple(todo, acc.copy(_3 = date))
    case Time(time, todo) => asTuple(todo, acc.copy(_4 = time))
