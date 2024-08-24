package io.vertx.lang.scala.itest.db

import io.vertx.core.Vertx
import io.vertx.core.eventbus.Message
import io.vertx.lang.scala.conv.{VertxFuture, vertxFutureToScalaFuture}
import io.vertx.lang.scala.itest.domain.ToDo
import io.vertx.lang.scala.itest.domain.ToDo.Title
import io.vertx.scala.core.DeliveryOptions
import org.scalatest.FutureOutcome
import org.scalatest.matchers.should.Matchers

import java.util.concurrent.TimeUnit
import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.language.implicitConversions
import org.scalatest.funspec.FixtureAsyncFunSpec

class ToDoDatabaseServiceSpec extends FixtureAsyncFunSpec with Matchers {

  type CUT = ToDoDatabaseService
  type FixtureParam = (Vertx, ToDoMap)

  override def withFixture(test: OneArgAsyncTest): FutureOutcome = {
    val mockDB = new ToDoMap()
    val vertx = Vertx.vertx
    val cut = new ToDoDatabaseService(mockDB)
    Await.ready(vertx.deployVerticle(cut), Duration(5, TimeUnit.SECONDS))

    complete {
      val fixture = (vertx, mockDB)
      super.withFixture(test.toNoArgAsyncTest(fixture))
    } lastly {
      vertx.close()
    }
  }

  describe("ToDoDatabaseService") {

    it("should load all ToDos") {fixture => // Use 'fixture' to access Vertx and ToDoMap
      val (vertx, mockDB) = fixture // Unpack the fixture
      mockDB.save(Title("Foo"))
      mockDB.save(Title("Bar"))
      val deliveryOptions = DeliveryOptions().addHeader(ACTION_HEADER, LOAD_ALL_ACTION)
      type Result = Map[ID, ToDo]
      for {
        todos: Result <- vertx.eventBus
          .request(READ_ADDRESS, "", deliveryOptions)
          .map((m: Message[Result]) => m.body).asInstanceOf[VertxFuture[Result]]
       titles = todos.values.toList.map(_.title)
      } yield
        titles should contain inOrder("Foo", "Bar")
    }

    it("should load ToDo by ID") { fixture => // Use 'fixture' to access Vertx and ToDoMap
      val (vertx, mockDB) = fixture // Unpack the fixture
      mockDB.save(Title("Ignore me!"))
      mockDB.save(Title("Yes, load me!"))
      val deliveryOptions = DeliveryOptions()
        .addHeader(ACTION_HEADER, LOAD_BY_ID_ACTION)
        .addHeader(ID_HEADER, "2")
      type Result = Option[ToDo]
      for {
        maybeToDo: Result <- vertx.eventBus
          .request(READ_ADDRESS, "", deliveryOptions)
          .map((m: Message[Result]) => m.body).asInstanceOf[VertxFuture[Result]]
        assertion = maybeToDo should matchPattern { case Some(ToDo.Title("Yes, load me!")) => }
      } yield assertion
    }

    it("should save a ToDo and return the ID") {fixture => // Use 'fixture' to access Vertx and ToDoMap
      val (vertx, mockDB) = fixture // Unpack the fixture
      mockDB.save(Title("First one!"))
      val deliveryOptions = DeliveryOptions().addHeader(ACTION_HEADER, SAVE_ACTION)

      for {
        id: ID <- vertx.eventBus
          .request(SAVE_ADDRESS, Title("Second one..."), deliveryOptions)
          .map((m: Message[ID]) => m.body).asInstanceOf[VertxFuture[ID]]
      } yield assert(id == ID(2))
    }

    it("should delete a ToDo") { fixture => // Use 'fixture' to access Vertx and ToDoMap
      val (vertx, mockDB) = fixture // Unpack the fixture
      for {
        _ <- mockDB.save(Title("Please, do not delete me!"))
        id <- mockDB.save(Title("Yes, delete me!"))
        _ <- mockDB.save(Title("No, not me!"))
        deliveryOptions = DeliveryOptions()
          .addHeader(ACTION_HEADER, DELETE_ACTION)
          .addHeader(ID_HEADER, "2")
        deleted: Boolean <- vertx.eventBus.request(DELETE_ADDRESS, "", deliveryOptions)
          .map((m: Message[Boolean]) => m.body).asInstanceOf[VertxFuture[Boolean]]
        assertion = deleted should be(true)
      } yield assertion
    }

  }
}
