package io.vertx.lang.scala.itest.domain

import java.time.LocalDate
import java.time.LocalTime
import scala.annotation.tailrec

/**
  * A ToDo item is one of
  *   - Title
  *   - Note
  *   - Date for another ToDo
  *   - Time for another ToDo
  *   - Location for another ToDo
  */
sealed trait ToDo
object ToDo {
  case class Title( title: String ) extends ToDo
  case class Note( note: String, todo: ToDo ) extends ToDo
  case class Date( date: LocalDate, todo: ToDo ) extends ToDo
  case class Time(time: LocalTime, todo: ToDo) extends ToDo

  /**
   * A smart constructor that evaluates to a [[ToDo]] depending on the [[Option Options]] given.
   */
  def apply(title: Title, maybeNotes: Option[String], maybeDate: Option[LocalDate], maybeTime: Option[LocalTime]): ToDo = {
    @tailrec
    def combine(acc: ToDo, maybeNotes: Option[String], maybeDate: Option[LocalDate], maybeTime: Option[LocalTime]): ToDo =
      (maybeNotes, maybeDate, maybeTime) match {
      case (_, _, Some(time))
          => combine(Time(time, acc), maybeNotes, maybeDate, None)
      case (_, Some(date), _)
          => combine(Date(date, acc), maybeNotes, None, maybeTime)
      case (Some(note), _, _)
          => combine(Note(note, acc), None, maybeDate, maybeTime)
      case (None, None, None) => acc
    }
    combine(title, maybeNotes, maybeDate, maybeTime)
  }

  implicit class ToDoOps(todo: ToDo) {
    def title: String = todo match {
      case Title(title)  => title
      case Note(_, todo) => todo.title
      case Date(_, todo) => todo.title
      case Time(_, todo) => todo.title
    }
  }
}


