package io.vertx.lang.scala.itest.db.jdbc

import io.vertx.lang.scala.itest.db.ToDoDatabase
import io.vertx.jdbcclient.JDBCPool
import io.vertx.lang.scala.itest.domain.ToDo
import io.vertx.lang.scala.itest.domain.ToDo.{Title, Date, Time, Note}
import io.vertx.lang.scala.ScalaVerticle
import scala.concurrent.Future
import io.vertx.sqlclient.Tuple
import scala.language.implicitConversions
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import scala.jdk.CollectionConverters.*
import io.vertx.sqlclient.RowSet
import io.vertx.sqlclient.Row
import io.vertx.lang.scala.itest.db.jdbc.ToDoDatabaseVertxJdbc.{DUE_DATE, DUE_TIME, NOTES, TITLE, TODO}
import scala.util.Try
import io.vertx.lang.scala.itest.db.jdbc.ToDoDatabaseVertxJdbc.getStringO
import java.time.LocalDate
import java.time.LocalTime
import io.vertx.lang.scala.itest.db.jdbc.ToDoDatabaseVertxJdbc.getLocalDateO
import io.vertx.lang.scala.itest.db.jdbc.ToDoDatabaseVertxJdbc.getLocalTimeO
import io.vertx.lang.scala.itest.db.jdbc.ToDoDatabaseVertxJdbc.getTitle
import scala.annotation.tailrec
import io.vertx.lang.scala.itest.db.jdbc.ToDoDatabaseVertxJdbc.TODO_ID
import io.vertx.lang.scala.itest.db.jdbc.ToDoDatabaseVertxJdbc.getId
import io.vertx.lang.scala.itest.db.ID

trait ToDoDatabaseVertxJdbc(conn: JDBCPool) extends ToDoDatabase:
  
  override def load(id: ID): Future[Option[ToDo]] = conn
    .preparedQuery(s"SELECT $TITLE, $NOTES, $DUE_DATE, $DUE_TIME FROM $TODO WHERE $TODO_ID = ?")
    .execute(Tuple.of(id))
    .map(rowSet => rowSet.iterator.asScala.nextOption)
    .map(rowOption => rowOption.flatMap(parse))

  override def loadAll: Future[Map[ID, ToDo]] = 
    for {
      rowSet <- conn.query(s"SELECT $TODO_ID, $TITLE, $NOTES, $DUE_DATE, $DUE_TIME FROM $TODO").execute()
      rows = rowSet.iterator.asScala.toList
      tuples = rows.map(parseWithId(_)).filter(_.isDefined).map(_.get)
    } yield tuples.toMap

  override def save(todo: ToDo): Future[ID] = conn
    .preparedQuery(s"INSERT INTO $TODO ($TODO_ID, $TITLE, $NOTES, $DUE_DATE, $DUE_TIME) VALUES (nextval('todo_id_seq'), ?, ?, ?, ?)")
    .execute(asTuple(todo))
    .map(rowSet => rowSet.property(JDBCPool.GENERATED_KEYS).getLong(0).asInstanceOf[Long])
    .map(longId => ID(longId))

  override def delete(id: ID): Future[ID] = conn
    .preparedQuery(s"DELETE FROM $TODO WHERE $TODO_ID = ?")
    .execute(Tuple.of(id))
    .map(_ => id)


  private def parseWithId(row: Row): Option[(ID, ToDo)] = 
    for {
      longId <- row.getId
      id = ID(longId)
      todo   <- parse(row)
    } yield (id -> todo)

  private def parse(row: Row): Option[ToDo] = 
    for {
      title <- row.getTitle
      note = row.getStringO(NOTES)
      date = row.getLocalDateO(DUE_DATE)
      time = row.getLocalTimeO(DUE_TIME)
    } yield combine(title, note, date, time)
  
  private def combine: (Title, Option[String], Option[LocalDate], Option[LocalTime]) => ToDo = {
    case (title, None, None, None) => title
    case (title, Some(notes), None, None) => Note(notes, title)
    case (title, maybeNotes, Some(date), None) => Date(date, combine(title, maybeNotes, None, None))
    case (title, maybeNotes, maybeDate, Some(time)) => Time(time, combine(title, maybeNotes, maybeDate, None))
  }

  @tailrec
  private def asTuple(todo: ToDo, acc: (String, LocalDate, LocalTime) = (null, null, null)): Tuple = todo match
    case Title(title)     => Tuple.of(title, acc._1, acc._2, acc._3)
    case Note(note, todo) => asTuple(todo, acc.copy(_1 = note))
    case Date(date, todo) => asTuple(todo, acc.copy(_2 = date))
    case Time(time, todo) => asTuple(todo, acc.copy(_3 = time))
  
    
object ToDoDatabaseVertxJdbc:
  val TODO_ID: String = "id"
  val TITLE: String = "title"
  val NOTES: String = "notes"
  val DUE_DATE: String = "due_date"
  val DUE_TIME: String = "due_time"
  val TODO = "todo"

  extension (row: Row)
    def safeGet[T](f: => T): Option[T] = Try { f }.toOption
    def getStringO(column: String): Option[String] = safeGet(row.getString(column))
    def getLongO(column: String): Option[Long] = safeGet(row.getLong(column))
    def getLocalDateO(column: String): Option[LocalDate] = safeGet(row.getLocalDate(column))
    def getLocalTimeO(column: String): Option[LocalTime] = safeGet(row.getLocalTime(column))
    def getTitle: Option[Title] = row.getStringO(TITLE).map(Title(_))
    def getId: Option[Long] = row.getLongO(TODO_ID)