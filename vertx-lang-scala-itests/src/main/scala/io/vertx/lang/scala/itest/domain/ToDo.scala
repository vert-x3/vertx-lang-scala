package io.vertx.lang.scala.itest.domain

import java.time.LocalDate
import java.time.LocalTime
import java.time.LocalDateTime
import scala.annotation.tailrec

/**
  * A ToDo item is one of
  *   - Title
  *   - Note
  *   - Date for another ToDo
  *   - Time for another ToDo
  *   - Location for another ToDo
  */
enum ToDo:
  case Title(val title: String)
  case Note(val note: String, val todo: ToDo)
  case Date(val date: LocalDate, val todo: ToDo)
  case Time(val time: LocalTime, val todo: ToDo)
export ToDo.*

object ToDo:
  /**
    * A smart constructor that evaluates to a [[ToDo]] depending on the [[Option Options]] given.
    */
  def apply(title: Title, maybeNotes: Option[String], maybeDate: Option[LocalDate], maybeTime: Option[LocalTime]): ToDo = 
    @tailrec def combine(acc: ToDo, maybeNotes: Option[String], maybeDate: Option[LocalDate], maybeTime: Option[LocalTime]): ToDo = (maybeNotes, maybeDate, maybeTime) match
      case (_, _, Some(time)) => combine(Time(time, acc), maybeNotes, maybeDate, None)
      case (_, Some(date), _) => combine(Date(date, acc), maybeNotes, None, maybeTime)
      case (Some(note), _, _) => combine(Note(note, acc), None, maybeDate, maybeTime)
      case (None, None, None) => acc
    combine(title, maybeNotes, maybeDate, maybeTime)
  

extension(todo: ToDo)
  def title: String = todo match
    case Title(title)  => title
    case Note(_, todo) => todo.title
    case Date(_, todo) => todo.title
    case Time(_, todo) => todo.title
  

  