package io.vertx.lang.scala.itest.db.jdbc

import io.vertx.core.Vertx
import io.vertx.jdbcclient.JDBCPool
import io.vertx.lang.scala.conv.{VertxFuture, vertxFutureToScalaFuture}
import io.vertx.lang.scala.VertxExecutionContext
import io.vertx.lang.scala.itest.db.ID
import io.vertx.lang.scala.itest.domain.ToDo.Date
import io.vertx.lang.scala.itest.domain.ToDo.Note
import io.vertx.lang.scala.itest.domain.ToDo.Time
import io.vertx.lang.scala.itest.domain.ToDo.Title
import io.vertx.lang.scala.json.Json
import io.vertx.sqlclient.Row
import org.scalatest.Checkpoints.Checkpoint
import org.scalatest.{FutureOutcome, ParallelTestExecution, Succeeded}
import org.scalatest.funspec.FixtureAsyncFunSpec
import org.scalatest.matchers.should.Matchers
import io.vertx.lang.scala.VertxFutureConverter
import java.util.concurrent.TimeUnit
import scala.concurrent.Await
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.concurrent.duration.Duration
import scala.language.implicitConversions

class ToDoDatabaseJdbcSpec extends FixtureAsyncFunSpec with Matchers with ParallelTestExecution {

  type CUT = ToDoDatabaseJdbc
  type FixtureParam = (CUT, JDBCPool)

  override def withFixture(test: OneArgAsyncTest): FutureOutcome = {
    val vertx = Vertx.vertx()
    implicit val executionContext: ExecutionContext = (VertxExecutionContext(vertx, vertx.getOrCreateContext()))
    val config = Json.obj(Map(
      "url" -> s"jdbc:h2:mem:${test.name}",
      "username" -> "sa",
      "password" -> "",
    ))
    val pool = JDBCPool.pool(vertx, config)
    val cut = new ToDoDatabaseJdbc(pool)

    val dbSetup: Future[Unit] = for {
      _ <- pool.query("CREATE TABLE todo (id LONG PRIMARY KEY, title VARCHAR(64) NOT NULL, notes VARCHAR(4096), due_date DATE, due_time TIME)").execute().asScala
      _ <- pool.query("CREATE SEQUENCE todo_id_seq").execute().asScala
      _ <- pool.query("INSERT INTO todo VALUES (nextval('todo_id_seq'), 'First ToDo', NULL, NULL, NULL)").execute().asScala
      _ <- pool.query("INSERT INTO todo VALUES (nextval('todo_id_seq'), 'Second ToDo', 'This is the second', NULL, NULL)").execute().asScala
      _ <- pool.query("INSERT INTO todo VALUES (nextval('todo_id_seq'), 'Third ToDo', NULL, CURRENT_DATE, CURRENT_TIME)").execute().asScala
    } yield ()
    Await.ready(dbSetup, Duration(5, TimeUnit.SECONDS))

    complete {
      val fixture: FixtureParam = (cut, pool)
      super.withFixture(test.toNoArgAsyncTest(fixture))
    } lastly {
      vertx.close()
    }
  }


  describe("ToDoDatabaseJdbc") {
    describe("Loading all ToDos") {
      it("should load all ToDos") { fixture =>
        val (cut, _) = fixture
        for {
          allToDos <- cut.loadAll
          allTitles = allToDos.values.map(_.title).toList
          assertion = allTitles should contain inOrderOnly("First ToDo", "Second ToDo", "Third ToDo")
        } yield assertion
      }

      it("should load an empty Map if table is empty") {  fixture =>

        val (cut, pool) = fixture
        for {
          _ <- pool.query("TRUNCATE TABLE todo").execute().asScala
          allToDos <- cut.loadAll
        } yield allToDos shouldBe empty
      }
    }

    describe("Loading single ToDos") {
      it("should load ToDo #2 (Title, Note)") { fixture =>
        val (cut, _) = fixture
        for {
          maybeSecondToDo <- cut.load(ID(2))
          assertion = maybeSecondToDo should matchPattern { case Some(Note("This is the second", Title("Second ToDo"))) => }
        } yield assertion
      }

      it("should load ToDo #3 (Date, Time, Title)") { fixture =>
        val (cut, _) = fixture
        for {
          maybeThirdToDo <- cut.load(ID(3))
          assertion = maybeThirdToDo should matchPattern { case Some(Date(_, Time(_, Title("Third ToDo")))) => }
        } yield assertion
      }
    }

    describe("Saving ToDos") {
      it("should save a ToDo and yield ID(4)") { fixture =>
        val (cut, _) = fixture
        for {
          id <- cut.save(Title("Fourth ToDo"))
          assertion = id should be(4)
        } yield assertion
      }
    }

    describe("Deleting ToDos") {
      it("should delete ToDo #2") { fixture =>
        val (cut, pool) = fixture
        val cp = new Checkpoint()
        for {
          success <- cut.delete(ID(2))
          rowCount: Int <- pool.query("SELECT count(*) AS CNT FROM todo")
            .execute
            .map((r: Iterable[Row]) => r.head.getInteger("CNT")).asInstanceOf[VertxFuture[Int]]
        } yield {
          cp {
            success should be(true)
          }
          cp {
            rowCount should be(2)
          }
          cp.reportAll()
          Succeeded
        }
      }

      it("should yield false if ToDo is not found") { fixture =>
        val (cut, pool) = fixture
        val cp = new Checkpoint()
        for {
          success <- cut.delete(ID(99))
          rowCount: Int <- pool.query("SELECT count(*) AS CNT FROM todo")
            .execute()
            .map((r: Iterable[Row]) => r.head.getInteger("CNT")).asInstanceOf[VertxFuture[Int]]
        } yield {
          cp {
            success should be(false)
          }
          cp {
            rowCount should be(3)
          }
          Succeeded
        }
      }
    }

  }
}

