package io.vertx.lang.scala.itest.db.jdbc

import io.vertx.core.Vertx
import io.vertx.jdbcclient.JDBCPool
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import io.vertx.lang.scala.itest.db.ID
import io.vertx.lang.scala.itest.domain.ToDo.{Date, Note, Time, Title}
import io.vertx.lang.scala.itest.domain.{title, ToDo}
import io.vertx.lang.scala.{asScala, VertxExecutionContext}
import io.vertx.scala.core.JsonObject
import io.vertx.scala.jdbcclient.JDBCConnectOptions
import io.vertx.scala.sqlclient.PoolOptions
import io.vertx.sqlclient.Pool
import org.scalatest.Checkpoints.Checkpoint
import org.scalatest.compatible.Assertion
import org.scalatest.funspec.FixtureAsyncFunSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.{FutureOutcome, ParallelTestExecution, Succeeded}

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.jdk.CollectionConverters.*
import scala.language.implicitConversions

class ToDoDatabaseJdbcSpec extends FixtureAsyncFunSpec, Matchers, ParallelTestExecution:

  type CUT          = ToDoDatabaseJdbc
  type FixtureParam = (CUT, Pool)

  override def withFixture(test: OneArgAsyncTest): FutureOutcome = {
    val vertx              = Vertx.vertx()
    given ExecutionContext = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    val connectOptions     = JDBCConnectOptions(jdbcUrl = s"jdbc:h2:mem:${test.name}", user = "sa", password = "")
    val poolOptions        = PoolOptions(maxSize = 5)
    val pool               = JDBCPool.pool(vertx, connectOptions, poolOptions)
    val cut                = ToDoDatabaseJdbc(pool)

    val dbSetup: Future[Unit] = for {
      _ <- pool
        .query(
          "CREATE TABLE todo (id LONG PRIMARY KEY, title VARCHAR(64) NOT NULL, notes VARCHAR(4096), due_date DATE, due_time TIME)"
        )
        .execute()
      _ <- pool.query("CREATE SEQUENCE todo_id_seq").execute()
      _ <- pool.query("INSERT INTO todo VALUES (nextval('todo_id_seq'), 'First ToDo', NULL, NULL, NULL)").execute()
      _ <- pool
        .query("INSERT INTO todo VALUES (nextval('todo_id_seq'), 'Second ToDo', 'This is the second', NULL, NULL)")
        .execute()
      _ <- pool
        .query("INSERT INTO todo VALUES (nextval('todo_id_seq'), 'Third ToDo', NULL, CURRENT_DATE, CURRENT_TIME)")
        .execute()
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
      it("should load all ToDos") { (cut, _) =>
        for {
          allToDos <- cut.loadAll
          allTitles = allToDos.values.map(_.title).toList
          assertion = allTitles should contain inOrderOnly ("First ToDo", "Second ToDo", "Third ToDo")
        } yield assertion
      }

      it("should load an empty Map if table is empty") { (cut, pool) =>
        for {
          _        <- pool.query("TRUNCATE TABLE todo").execute().mapEmpty.asScala
          allToDos <- cut.loadAll
          assertion = allToDos shouldBe empty
        } yield assertion
      }
    }

    describe("Loading single ToDos") {
      it("should load ToDo #2 (Title, Note)") { (cut, _) =>
        for {
          maybeSecondToDo <- cut.load(ID(2))
          assertion = maybeSecondToDo should matchPattern {
            case Some(Note("This is the second", Title("Second ToDo"))) =>
          }
        } yield assertion
      }

      it("should load ToDo #3 (Date, Time, Title)") { (cut, _) =>
        for {
          maybeThirdToDo <- cut.load(ID(3))
          assertion = maybeThirdToDo should matchPattern { case Some(Date(_, Time(_, Title("Third ToDo")))) => }
        } yield assertion
      }
    }

    describe("Saving ToDos") {
      it("should save a ToDo and yield ID(4)") { (cut, _) =>
        for {
          id <- cut.save(Title("Fourth ToDo"))
          assertion = id should be(4)
        } yield assertion
      }
    }

    describe("Deleting ToDos") {
      it("should delete ToDo #2") { (cut, pool) =>
        val cp = Checkpoint()
        for {
          success  <- cut.delete(ID(2))
          rowCount <- pool
            .query("SELECT count(*) AS CNT FROM todo")
            .execute()
            .map(_.asScala.head.getInteger("CNT"))
        } yield {
          cp { success should be(true) }
          cp { rowCount should be(2) }
          cp.reportAll()
          Succeeded
        }
      }

      it("should yield false if ToDo is not found") { (cut, pool) =>
        val cp = Checkpoint()
        for {
          success  <- cut.delete(ID(99))
          rowCount <- pool
            .query("SELECT count(*) AS CNT FROM todo")
            .execute()
            .map(_.asScala.head.getInteger("CNT"))
        } yield {
          cp { success should be(false) }
          cp { rowCount should be(3) }
          Succeeded
        }
      }
    }

  }
