package io.vertx.lang.scala.itest.db.jdbc

import io.vertx.lang.scala.itest.db.ToDoDatabase
import io.vertx.jdbcclient.JDBCPool
import io.vertx.lang.scala.itest.domain.ToDo
import io.vertx.lang.scala.itest.domain.ToDo._
import scala.concurrent.Future
import io.vertx.sqlclient.{Row, SqlConnection, Tuple}
import scala.language.implicitConversions
import io.vertx.lang.scala.conv.{VertxFuture, vertxFutureToScalaFuture}

import scala.collection.convert.ImplicitConversions._
import io.vertx.lang.scala.itest.db.jdbc.ToDoDatabaseVertxJdbc._

import java.time.LocalDate
import java.time.LocalTime
import scala.annotation.tailrec
import io.vertx.lang.scala.itest.db.ID
import io.vertx.lang.scala.tupleOf
import io.vertx.lang.scala._

import scala.concurrent.ExecutionContext
import io.vertx.lang.scala.itest.db.jdbc.ToDoDatabaseVertxJdbc.asVertxTuple

class ToDoDatabaseJdbc(pool: JDBCPool)(implicit ec: ExecutionContext) extends ToDoDatabase {

  //implicit def scalaAsJavaFunction[I, O](f: (I) => O): function.Function[I, O] = asJavaFunction(f)

  override def load(id: ID): Future[Option[ToDo]] =
    pool.preparedQuery(s"SELECT $TODO_ID, $TITLE, $NOTES, $DUE_DATE, $DUE_TIME FROM $TODO WHERE $TODO_ID = ?")
       .mapping(row => toIdAndToDo(row)._2)
       .execute( id )
       .map(_.headOption)


  override def loadAll: Future[Map[ID, ToDo]] =
    pool.query(s"SELECT $TODO_ID, $TITLE, $NOTES, $DUE_DATE, $DUE_TIME FROM $TODO")
         .mapping(toIdAndToDo)
         .execute.asScala
         .map(_.toList.toMap)

  override def save(todo: ToDo): Future[ID] = pool.withTransaction { (conn: SqlConnection) =>
      conn.query(s"SELECT nextval('todo_id_seq') AS ID")
        .execute
        .map( (r: Iterable[Row]) => r.head.getLong("ID")).asInstanceOf[VertxFuture[ID]]
        .flatMap { id: Long =>
          conn.preparedQuery(s"INSERT INTO $TODO ($TODO_ID, $TITLE, $NOTES, $DUE_DATE, $DUE_TIME) VALUES ($id, ?, ?, ?, ?)")
            .execute(asVertxTuple(todo))
            .map(ID(id)).asInstanceOf[VertxFuture[ID]]
        }
  }

  override def delete(id: ID): Future[Boolean] = {
    pool.preparedQuery( s"DELETE FROM $TODO WHERE $TODO_ID = ?" )
        .execute( id )
        .map(_.rowCount == 1 )
  }
}

object ToDoDatabaseVertxJdbc {
  val TODO_ID: String = "ID"
  val TITLE: String = "TITLE"
  val NOTES: String = "NOTES"
  val DUE_DATE: String = "DUE_DATE"
  val DUE_TIME: String = "DUE_TIME"
  val TODO = "TODO"

  def toIdAndToDo(row: Row): (ID, ToDo) = {
    // id and title must be there
    val id = ID(row.getLong(TODO_ID))
    val title = row.getString(TITLE)
    val maybeNotes = Option(row.getString(NOTES))
    val maybeDueDate = Option(row.getLocalDate(DUE_DATE))
    val maybeDueTime = Option(row.getLocalTime(DUE_TIME))
    (id -> ToDo(Title(title), maybeNotes, maybeDueDate, maybeDueTime))
  }

  def asVertxTuple(todo: ToDo): Tuple = {
    val (title, notes, date, time) = asTuple(todo)
    tupleOf(title, notes, date, time)
  }

  type ToDoTuple = (String, String, LocalDate, LocalTime)

  @tailrec def asTuple(todo: ToDo, acc: ToDoTuple = (null, null, null, null)): ToDoTuple = todo match {
    case Title(title)     => acc.copy(_1 = title)
    case Note(note, todo) => asTuple(todo, acc.copy(_2 = note))
    case Date(date, todo) => asTuple(todo, acc.copy(_3 = date))
    case Time(time, todo) => asTuple(todo, acc.copy(_4 = time))
  }
}

