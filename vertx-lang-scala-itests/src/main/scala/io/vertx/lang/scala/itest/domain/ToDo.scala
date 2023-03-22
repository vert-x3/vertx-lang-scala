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

/**
  * Some smart constructors.
  */
object ToDo:
  def apply(title: String): ToDo = Title(title)
  def apply(title: String, dateTime: LocalDateTime): ToDo =
    Date(dateTime.toLocalDate, Time(dateTime.toLocalTime, Title(title)))
  def apply(title: String, note: String, dateTime: LocalDateTime): ToDo = 
    Date(dateTime.toLocalDate, Time(dateTime.toLocalTime, Note(note, Title(title))))

extension(todo: ToDo)
  def title: String = todo match
    case Title(title)  => title
    case Note(_, todo) => todo.title
    case Date(_, todo) => todo.title
    case Time(_, todo) => todo.title
  

  