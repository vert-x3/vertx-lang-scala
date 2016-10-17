package io.vertx.lang.scala.tck

import io.vertx.codegen.testmodel.{CollectionTCKImpl, RefedInterface1Impl, TestEnum}
import io.vertx.lang.scala.json.Json
import io.vertx.lang.scala.json.Json._
import io.vertx.scala.codegen.testmodel.{CollectionTCK, RefedInterface1, TestDataObject}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.concurrent.ExecutionContext

@RunWith(classOf[JUnitRunner])
class CollectionTCKTest extends FlatSpec with Matchers {

  val obj = CollectionTCK(new CollectionTCKImpl)

  implicit val execCtx = new ExecutionContext {override def reportFailure(cause: Throwable): Unit = ???
    override def execute(runnable: Runnable): Unit = runnable.run()
  }


  "testMethodListParams" should "work" in {
    val refed1 = new RefedInterface1(new RefedInterface1Impl())
    refed1.setString("foo")
    val refed2 = new RefedInterface1(new RefedInterface1Impl())
    refed2.setString("bar")

    obj.methodWithListParams(
      mutable.Buffer("foo", "bar"),
      mutable.Buffer(2.toByte, 3.toByte),
      mutable.Buffer(12.toShort, 13.toShort),
      mutable.Buffer(1234, 1345),
      mutable.Buffer(123l, 456l),
      mutable.Buffer(Json.obj(("foo", "bar")), Json.obj(("eek", "wibble"))),
      mutable.Buffer(arr("foo"), arr("blah")),
      mutable.Buffer(refed1, refed2),
      mutable.Buffer(TestDataObject.fromJson(Json.obj().put("bar", 1).put("wibble", 1.1).put("foo", "String 1")), TestDataObject.fromJson(Json.obj().put("bar", 2).put("wibble", 2.2).put("foo", "String 2"))),
      mutable.Buffer(TestEnum.JULIEN, TestEnum.TIM))
  }

  "testMethodSetParams" should "work" in {
    val refed1 = new RefedInterface1(new RefedInterface1Impl())
    refed1.setString("foo")
    val refed2 = new RefedInterface1(new RefedInterface1Impl())
    refed2.setString("bar")

    obj.methodWithSetParams(
      Set("foo", "bar"),
      Set(2.toByte, 3.toByte),
      Set(12.toShort, 13.toShort),
      Set(1234, 1345),
      Set(123l, 456l),
      Set(Json.obj(("foo", "bar")), Json.obj(("eek", "wibble"))),
      Set(arr("foo"), arr("blah")),
      Set(refed1, refed2),
      Set(TestDataObject.fromJson(Json.obj().put("bar", 1).put("wibble", 1.1).put("foo", "String 1")), TestDataObject.fromJson(Json.obj().put("bar", 2).put("wibble", 2.2).put("foo", "String 2"))),
      Set(TestEnum.JULIEN, TestEnum.TIM))
  }

  "testMethodMapParams" should "work" in {
    val refed1 = new RefedInterface1(new RefedInterface1Impl())
    refed1.setString("foo")
    val refed2 = new RefedInterface1(new RefedInterface1Impl())
    refed2.setString("bar")
    obj.methodWithMapParams(
      Map("foo" -> "bar", "eek" -> "wibble"),
      Map("foo" -> 2.toByte, "eek" -> 3.toByte),
      Map("foo" -> 12.toShort, "eek" -> 13.toShort),
      Map("foo" -> 1234, "eek" -> 1345),
      Map("foo" -> 123l, "eek" -> 456l),
      Map("foo" -> Json.obj(("foo", "bar")), "eek" -> Json.obj(("eek", "wibble"))),
      Map("foo" -> arr("foo"), "eek" -> arr("blah")),
      Map("foo" -> refed1, "eek" -> refed2)
    )
  }

  "testListStringReturn" should "work" in {
    assert(List("foo", "bar", "wibble") == obj.methodWithListStringReturn())
  }

  "testListLongReturn" should "work" in {
    assert(List(123l, 456l) == obj.methodWithListLongReturn())
  }

  "testListJsonObjectReturn" should "work" in {
    val list = obj.methodWithListJsonObjectReturn()
    assert(2 == list.size)
    assert("bar" == list.head.getString("foo"))
    assert("eek" == list(1).getString("blah"))
  }

  "testListComplexJsonObjectReturn" should "work" in {
    val list = obj.methodWithListComplexJsonObjectReturn()
    assert(1 == list.size)
    val json1 = list.head
    assert(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))) == json1)
  }

  "testListJsonArrayReturn" should "work" in {
    var list = obj.methodWithListJsonArrayReturn()
    assert(2 == list.size)
    val json1 = list.head
    assert("foo" == json1.getString(0))
    val json2 = list(1)
    assert("blah" == json2.getString(0))
  }

  "testListComplexJsonArrayReturn" should "work" in {
    val list = obj.methodWithListComplexJsonArrayReturn()
    assert(2 == list.size)
    val json1 = list.head
    assert(arr(Json.obj(("foo", "hello"))) == json1)
    val json2 = list(1)
    assert(arr(Json.obj(("bar", "bye"))) == json2)
  }

  "testListVertxGenReturn" should "work" in {
    val list = obj.methodWithListVertxGenReturn()
    assert(2 == list.size)
    val refed1 = list.head
    val refed2 = list(1)
    assert("foo" == refed1.getString())
    assert("bar" == refed2.getString())
  }

  "testListDataObjectReturn" should "work" in {
    val list = obj.methodWithListDataObjectReturn()
    assert("String 1" == list.head.getFoo)
    assert(1 == list.head.getBar)
    assert(1.1 == list.head.getWibble)
    assert("String 2" == list(1).getFoo)
    assert(2 == list(1).getBar)
    assert(2.2 == list(1).getWibble)
  }

  "testSetStringReturn" should "work" in {
    assert(Set("foo", "bar", "wibble") == obj.methodWithSetStringReturn())
  }

  "testSetLongReturn" should "work" in {
    assert(Set(123l, 456l) == obj.methodWithSetLongReturn())
  }

  "testSetJsonObjectReturn" should "work" in {
    val set = obj.methodWithSetJsonObjectReturn()
    assert(2 == set.size)
    val json1 = Json.obj(("foo", "bar"))
    assert(set.contains(json1))
    val json2 = Json.obj(("blah", "eek"))
    assert(set.contains(json2))
  }


  "testSetComplexJsonObjectReturn" should "work" in {
    val set = obj.methodWithSetComplexJsonObjectReturn()
    assert(1 == set.size)
    assert(set.contains(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue")))))
  }

  "testSetJsonArrayReturn" should "work" in {
    val set = obj.methodWithSetJsonArrayReturn()
    assert(2 == set.size)
    assert(set.contains(Json.arr("foo")))
    assert(set.contains(Json.arr("blah")))
  }

  "testSetComplexJsonArrayReturn" should "work" in {
    val set = obj.methodWithSetComplexJsonArrayReturn()
    assert(2 == set.size)
    assert(set.contains(arr(Json.obj(("foo", "hello")))))
    assert(set.contains(arr(Json.obj(("bar", "bye")))))
  }

  "testSetVertxGenReturn" should "work" in {
    val set = obj.methodWithSetVertxGenReturn()
    assert(2 == set.size)
    assert(set.map(_.getString()).size == 2)
  }

  "testSetDataObjectReturn" should "work" in {
    var checkVar = 0
    val coll = obj.methodWithSetDataObjectReturn()
    val allok = coll.forall(td => {
      if ("String 1" == td.getFoo) {
        assert(1 == td.getBar)
        assert(1.1 == td.getWibble)
        checkVar += 1
        true
      }
      else if ("String 2" == td.getFoo) {
        assert(2 == td.getBar)
        assert(2.2 == td.getWibble)
        checkVar -= 1
        true
      }
      else
        false
    })

    assert(allok)
    assert(checkVar == 0)
  }

  "testMapStringReturn" should "work" in {
    val map = obj.methodWithMapStringReturn(a => {})
    assert("bar" == map("foo"))
  }

  "testMapLongReturn" should "work" in {
    val map = obj.methodWithMapLongReturn(a => {})
    assert(123l == map("foo"))
  }

  "testMapJsonObjectReturn" should "work" in {
    val map = obj.methodWithMapJsonObjectReturn(a => {})
    val m = map("foo")
    assert("eek" == m.getString("wibble"))
  }

  "testMapComplexJsonObjectReturn" should "work" in {
    val map = obj.methodWithMapComplexJsonObjectReturn(a => {})
    val m = map("foo")
    assert(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))) == m)
  }

  "testMapJsonArrayReturn" should "work" in {
    val map = obj.methodWithMapJsonArrayReturn(a => {})
    val m = map("foo")
    assert("wibble" == m.getString(0))
  }

  "testMapComplexJsonArrayReturn" should "work" in {
    val map = obj.methodWithMapComplexJsonArrayReturn(a => {})
    val m = map("foo")
    assert(arr(Json.obj(("foo", "hello")), Json.obj(("bar", "bye"))) == m)
  }

  "testMethodWithHandlerListEnum" should "work" in {
    obj.methodWithHandlerListEnum(it => assert(it == List(TestEnum.TIM, TestEnum.JULIEN)))
  }

  "testMethodWithHandlerSetEnum" should "work" in {
    obj.methodWithHandlerSetEnum(it => assert(it == Set(TestEnum.TIM, TestEnum.JULIEN)))
  }

  "testMethodWithHandlerAsyncResultListEnum" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultListEnumFuture().foreach(it => { w{assert(it.toSet.diff(Set(TestEnum.TIM, TestEnum.JULIEN)).isEmpty)}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultSetEnum" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultSetEnumFuture().foreach(it => { w{assert(it.diff(Set(TestEnum.TIM, TestEnum.JULIEN)).isEmpty)}; w.dismiss()}))
  }

  "testMethodWithHandlerListAndSet" should "work" in {
    obj.methodWithHandlerListAndSet(
      it => assert(List("foo", "bar", "wibble") == it),
      it => assert(List(5, 12, 100) == it),
      it => assert(Set("foo", "bar", "wibble") == it),
      it => assert(Set(5, 12, 100) == it)
    )
  }

  "testMethodWithHandlerAsyncResultListAndSet" should "work" in {
    import collection.JavaConverters._
    exec(4)(w => {
      obj.methodWithHandlerAsyncResultListStringFuture().foreach(it => {w {assert(List("foo", "bar", "wibble").diff(it).isEmpty)}; w.dismiss()})
      obj.methodWithHandlerAsyncResultListIntegerFuture().foreach(it => {w {assert(List(5, 12, 100).diff(it).isEmpty)}; w.dismiss()})
      obj.methodWithHandlerAsyncResultSetStringFuture().foreach(it => {w {assert(Set("foo", "bar", "wibble").diff(it).isEmpty)}; w.dismiss()})
      obj.methodWithHandlerAsyncResultSetIntegerFuture().foreach(it => {w {assert(Set(5, 12, 100).diff(it).isEmpty)}; w.dismiss()})
    })
  }

  "testMethodWithHandlerListVertxGen" should "work" in {
    obj.methodWithHandlerListVertxGen(it => assert(it.map(_.getString()) == List("foo", "bar")))
  }

  "testMethodWithHandlerListAbstractVertxGen" should "work" in {
    obj.methodWithHandlerListAbstractVertxGen(it => assert(it.map(_.getString()) == List("abstractfoo", "abstractbar")))
  }

  "testMethodWithHandlerAsyncResultListVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultListVertxGenFuture().foreach(it => { w {assert(it.map(_.getString()) == ArrayBuffer("foo", "bar"))}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultListAbstractVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultListAbstractVertxGenFuture().foreach(it => { w {assert(it.map(_.getString()) == ArrayBuffer("abstractfoo", "abstractbar"))}; w.dismiss()}))
  }

  "testMethodWithHandlerSetVertxGen" should "work" in {
    obj.methodWithHandlerSetVertxGen(it => assert(it.map(_.getString()) == Set("bar", "foo")))
  }

  "testMethodWithHandlerSetAbstractVertxGen" should "work" in {
    obj.methodWithHandlerSetAbstractVertxGen(it => assert(it.map(_.getString()) == Set("abstractfoo", "abstractbar")))
  }

  "testMethodWithHandlerAsyncResultSetVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultSetVertxGenFuture().foreach(it => { w {assert(it.map(_.getString()) == Set("bar", "foo"))}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultSetAbstractVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultSetAbstractVertxGenFuture().foreach(it => { w {assert(it.map(_.getString()) == Set("abstractbar", "abstractfoo"))}; w.dismiss()}))
  }

  "testMethodWithHandlerListJsonObject" should "work" in {
    obj.methodWithHandlerListJsonObject(it => assert(it == List(Json.obj(("cheese", "stilton")), Json.obj(("socks", "tartan")))))
  }

  "testMethodWithHandlerListComplexJsonObject" should "work" in {
    obj.methodWithHandlerListComplexJsonObject(it => assert(it == List(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))))))
  }

  "testMethodWithHandlerAsyncResultListJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultListJsonObjectFuture().foreach(it => { w {assert(List(Json.obj(("cheese", "stilton")), Json.obj(("socks", "tartan"))).sameElements(it))}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultListComplexJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultListComplexJsonObjectFuture().foreach(it => { w {assert(List(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue")))).sameElements(it))}; w.dismiss()}))
  }

  "testMethodWithHandlerSetJsonObject" should "work" in {
    obj.methodWithHandlerSetJsonObject(it => assert(it == Set(Json.obj(("cheese", "stilton")), Json.obj(("socks", "tartan")))))
  }

  "testMethodWithHandlerSetComplexJsonObject" should "work" in {
    obj.methodWithHandlerSetComplexJsonObject(it => assert(it == Set(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))))))
  }

  "testMethodWithHandlerAsyncResultSetJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultSetJsonObjectFuture().foreach(it => { w {assert(Set(Json.obj(("cheese", "stilton")), Json.obj(("socks", "tartan"))).sameElements(it))}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultSetComplexJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultSetComplexJsonObjectFuture().foreach(it => { w {assert(Set(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue")))).sameElements(it))}; w.dismiss()}))
  }

  "testMethodWithHandlerListJsonArray" should "work" in {
    obj.methodWithHandlerListJsonArray(it => assert(it == List(arr("green", "blue"), arr("yellow", "purple"))))
  }

  "testMethodWithHandlerListComplexJsonArray" should "work" in {
    obj.methodWithHandlerListComplexJsonArray(it => assert(it == List(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye"))))))
  }

  "testMethodWithHandlerListDataObject" should "work" in {
    obj.methodWithHandlerListDataObject(it => {
      assert("String 1" == it.head.getFoo)
      assert(1 == it.head.getBar)
      assert(1.1 == it.head.getWibble)
      assert("String 2" == it(1).getFoo)
      assert(2 == it(1).getBar)
      assert(2.2 == it(1).getWibble)
    })
  }

  "testMethodWithHandlerSetDataObject" should "work" in {
    var checkVar = 0
    obj.methodWithHandlerSetDataObject(it => {
      it.forall(td => {
        if ("String 1" == td.getFoo) {
          assert(1 == td.getBar)
          assert(1.1 == td.getWibble)
          checkVar += 1
        }
        else if ("String 2" == td.getFoo) {
          assert(2 == td.getBar)
          assert(2.2 == td.getWibble)
          checkVar -= 1
        }
        true
      })
    })
    assert(checkVar == 0)
  }

  "testMethodWithHandlerAsyncResultListJsonArray" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultListJsonArrayFuture().foreach(it => { w {assert(it.diff(List(arr("green", "blue"), arr("yellow", "purple"))).isEmpty)}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultListComplexJsonArray" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultListComplexJsonArrayFuture().foreach(it => { w {assert(it.diff(List(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye"))))).isEmpty)}; w.dismiss()}))
  }

  "testMethodWithHandlerSetJsonArray" should "work" in {
    obj.methodWithHandlerSetJsonArray(it => assert(it == Set(arr("green", "blue"), arr("yellow", "purple"))))
  }

  "testMethodWithHandlerSetComplexJsonArray" should "work" in {
    obj.methodWithHandlerSetComplexJsonArray(it => assert(it == Set(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye"))))))
  }

  "testMethodWithHandlerAsyncResultSetJsonArray" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultSetJsonArrayFuture().foreach(it => { w {assert(it.diff(Set(arr("green", "blue"), arr("yellow", "purple"))).isEmpty)}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultSetComplexJsonArray" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultSetComplexJsonArrayFuture().foreach(it => { w {assert(it.diff(Set(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye"))))).isEmpty)}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultListDataObject" should "work" in {
    exec1(w => obj.methodWithHandlerAsyncResultListDataObjectFuture().foreach(it => {
      w {
        assert("String 1" == it(0).getFoo)
        assert(1 == it(0).getBar)
        assert(1.1 == it(0).getWibble)

        assert("String 2" == it(1).getFoo)
        assert(2 == it(1).getBar)
        assert(2.2 == it(1).getWibble)
      }
      w.dismiss()
    }))
  }

  "testMethodWithHandlerAsyncResultSetDataObject" should "work" in {
    import collection.JavaConversions._
    var checkVar = 0
    exec1(w => obj.methodWithHandlerAsyncResultSetDataObjectFuture().foreach(it => {
      val coll = it
      coll.forall(td => {
        if ("String 1" == td.getFoo) {
          assert(1 == td.getBar)
          assert(1.1 == td.getWibble)
          checkVar += 1
          w.dismiss()
        }
        else if ("String 2" == td.getFoo) {
          assert(2 == td.getBar)
          assert(2.2 == td.getWibble)
          checkVar -= 1
          w.dismiss()
        }
        true
      })
    }))
    assert(checkVar == 0)
  }

  "testMethodWithListEnumReturn" should "work" in {
    assert(List(TestEnum.JULIEN, TestEnum.TIM) == obj.methodWithListEnumReturn())
  }

  "testMethodWithSetEnumReturn" should "work" in {
    assert(Set(TestEnum.JULIEN, TestEnum.TIM) == obj.methodWithSetEnumReturn())
  }

}
