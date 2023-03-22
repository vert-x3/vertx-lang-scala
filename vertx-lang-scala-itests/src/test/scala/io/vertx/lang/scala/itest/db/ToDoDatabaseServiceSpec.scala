package io.vertx.lang.scala.itest.db

import io.vertx.core.Vertx
import io.vertx.lang.scala.ImplicitConversions.scalaVerticleToJavaVerticle
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import io.vertx.lang.scala.itest.db.ACTION_HEADER
import io.vertx.lang.scala.itest.domain.ToDo
import io.vertx.lang.scala.itest.domain.title
import io.vertx.scala.core.DeliveryOptions
import org.scalatest.FutureOutcome
import org.scalatest.funspec.AsyncFunSpec
import org.scalatest.matchers.should.Matchers

import java.time.LocalDateTime
import java.util.concurrent.TimeUnit
import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.Promise
import scala.concurrent.duration.Duration
import scala.language.implicitConversions


class ToDoDatabaseServiceSpec extends AsyncFunSpec, Matchers:

  var vertx: Vertx = _
  var cut: ToDoDatabaseService = _
  var mockDB: ToDoMap = _

  override def withFixture(test: NoArgAsyncTest): FutureOutcome = {
    mockDB = ToDoMap()
    vertx = Vertx.vertx()
    cut = ToDoDatabaseService(mockDB)
    Await.ready(vertx.deployVerticle(cut), Duration(5, TimeUnit.SECONDS))
    complete {
      super.withFixture(test)
    } lastly {
      vertx.close()
    }
  }

  describe("ToDoDatabaseService") {

    it("should load all ToDos") {
      mockDB.save(ToDo("Foo"))
      mockDB.save(ToDo("Bar"))
      val deliveryOptions = DeliveryOptions().addHeader(ACTION_HEADER, LOAD_ALL_ACTION)
      for {
        todos <- vertx.eventBus
          .request[Map[ID, ToDo]](READ_ADDRESS, "", deliveryOptions)
          .map(_.body)
        titles = todos.values.toList.map(_.title)
        assertion = titles should contain inOrder("Foo", "Bar")
      } yield assertion
    }

    it("should load ToDo by ID") {
      mockDB.save(ToDo("Ignore me!"))
      mockDB.save(ToDo("Yes, load me!"))
      val deliveryOptions = DeliveryOptions()
        .addHeader(ACTION_HEADER, LOAD_BY_ID_ACTION)
        .addHeader(ID_HEADER, "2")
      for {
        maybeToDo <- vertx.eventBus
          .request[Option[ToDo]](READ_ADDRESS, "", deliveryOptions)
          .map(_.body)
        assertion = maybeToDo should matchPattern { case Some(ToDo.Title("Yes, load me!")) => } 
      } yield assertion
    }

    it("should save a ToDo and return the ID") {
      mockDB.save(ToDo("First one!"))
      val deliveryOptions = DeliveryOptions().addHeader(ACTION_HEADER, SAVE_ACTION)
      for {
        id <- vertx.eventBus
          .request[ID](SAVE_ADDRESS, ToDo("Second one..."), deliveryOptions)
          .map(_.body)
        assertion = assert(id == ID(2))
      } yield assertion
    }

    it("should delete a ToDo") {
      for {
        _  <- mockDB.save(ToDo("Please, do not delete me!"))
        id <- mockDB.save(ToDo("Yes, delete me!"))
        _  <- mockDB.save(ToDo("No, not me!"))
        deliveryOptions = DeliveryOptions()
          .addHeader(ACTION_HEADER, DELETE_ACTION)
          .addHeader(ID_HEADER, "2")
        deletedId <- vertx.eventBus.request[ID](DELETE_ADDRESS, "", deliveryOptions)
          .map(_.body)
        assertion = assert(deletedId == id)
      } yield assertion
    }

  }

end ToDoDatabaseServiceSpec