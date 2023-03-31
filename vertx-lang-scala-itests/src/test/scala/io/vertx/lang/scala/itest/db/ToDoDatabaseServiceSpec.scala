package io.vertx.lang.scala.itest.db

import io.vertx.core.Vertx
import io.vertx.lang.scala.ImplicitConversions.scalaVerticleToJavaVerticle
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import io.vertx.lang.scala.itest.db.ACTION_HEADER
import io.vertx.lang.scala.itest.domain.ToDo
import io.vertx.lang.scala.itest.domain.ToDo.Title
import io.vertx.lang.scala.itest.domain.title
import io.vertx.scala.core.DeliveryOptions
import org.scalatest.FutureOutcome
import org.scalatest.matchers.should.Matchers

import java.time.LocalDateTime
import java.util.concurrent.TimeUnit
import scala.concurrent.Await
import scala.concurrent.Future
import scala.concurrent.Promise
import scala.concurrent.duration.Duration
import scala.language.implicitConversions
import org.scalatest.funspec.FixtureAsyncFunSpec
import org.scalatest.ParallelTestExecution


class ToDoDatabaseServiceSpec extends FixtureAsyncFunSpec, Matchers:

  type CUT = ToDoDatabaseService
  type FixtureParam = (Vertx, ToDoMap)

  override def withFixture(test: OneArgAsyncTest): FutureOutcome = {
    val mockDB = ToDoMap()
    val vertx = Vertx.vertx()
    val cut = ToDoDatabaseService(mockDB)
    Await.ready(vertx.deployVerticle(cut), Duration(5, TimeUnit.SECONDS))

    complete {
      val fixture = (vertx, mockDB)
      super.withFixture(test.toNoArgAsyncTest(fixture))
    } lastly {
      vertx.close()
    }
  }

  describe("ToDoDatabaseService") {

    it("should load all ToDos") { (vertx, mockDB) =>
      mockDB.save(Title("Foo"))
      mockDB.save(Title("Bar"))
      val deliveryOptions = DeliveryOptions().addHeader(ACTION_HEADER, LOAD_ALL_ACTION)
      for {
        todos <- vertx.eventBus
          .request[Map[ID, ToDo]](READ_ADDRESS, "", deliveryOptions)
          .map(_.body)
        titles = todos.values.toList.map(_.title)
        assertion = titles should contain inOrder("Foo", "Bar")
      } yield assertion
    }

    it("should load ToDo by ID") { (vertx, mockDB) =>
      mockDB.save(Title("Ignore me!"))
      mockDB.save(Title("Yes, load me!"))
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

    it("should save a ToDo and return the ID") { (vertx, mockDB) =>
      mockDB.save(Title("First one!"))
      val deliveryOptions = DeliveryOptions().addHeader(ACTION_HEADER, SAVE_ACTION)
      for {
        id <- vertx.eventBus
          .request[ID](SAVE_ADDRESS, Title("Second one..."), deliveryOptions)
          .map(_.body)
        assertion = assert(id == ID(2))
      } yield assertion
    }

    it("should delete a ToDo") { (vertx, mockDB) =>
      for {
        _  <- mockDB.save(Title("Please, do not delete me!"))
        id <- mockDB.save(Title("Yes, delete me!"))
        _  <- mockDB.save(Title("No, not me!"))
        deliveryOptions = DeliveryOptions()
          .addHeader(ACTION_HEADER, DELETE_ACTION)
          .addHeader(ID_HEADER, "2")
        deleted <- vertx.eventBus.request[Boolean](DELETE_ADDRESS, "", deliveryOptions)
                                 .map(_.body)
        assertion = deleted should be(true)
      } yield assertion
    }

  }
