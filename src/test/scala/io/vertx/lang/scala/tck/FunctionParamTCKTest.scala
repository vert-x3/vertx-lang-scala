package io.vertx.lang.scala.tck

import io.vertx.codegen.testmodel.FunctionParamTCKImpl
import io.vertx.scala.codegen.testmodel.FunctionParamTCK
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner
import scala.compat.java8.FunctionConverters._

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class FunctionParamTCKTest extends FlatSpec with Matchers {
  val obj = FunctionParamTCK(new FunctionParamTCKImpl())
  //FIXME apply this strategy internally
  "testBasicParam" should "work" in {
    val ret = obj.methodWithBasicParam(
      asJavaFunction(it => { assert(100.toByte == it); "ok0" }),
      asJavaFunction(it => { assert(1000.toShort == it); "ok1" }),
      asJavaFunction(it => { assert(100000 == it); "ok2" }),
      asJavaFunction(it => { assert(10000000000L == it); "ok3" }),
      asJavaFunction(it => { assert(3.5.toFloat == it); "ok4" }),
      asJavaFunction(it => { assert(0.01 == it); "ok5" }),
      asJavaFunction(it => { assert(true == it); "ok6" }),
      asJavaFunction(it => { assert('F' == it); "ok7" }),
      asJavaFunction(it => { assert("wibble" == it); "ok8" }))
    assert(List("ok0","ok1","ok2","ok3","ok4","ok5","ok6","ok7","ok8") == ret)
  }

//  @Test
//  public void testJsonParam() {
//    def ret = obj.methodWithJsonParam(
//      { assertEquals([one:1,two:2,three:3], it); return "ok0" },
//      { assertEquals(["one","two","three"], it); return "ok1" })
//    assertEquals(["ok0","ok1"], ret);
//  }
//
//  @Test
//  public void testVoidParam() {
//    assertEquals("ok", obj.methodWithVoidParam { assertEquals(null, it); return "ok" })
//  }
//
//  @Test
//  public void testUserTypeParam() {
//    RefedInterface1 refed = new RefedInterface1(new RefedInterface1Impl());
//    assertEquals("ok", obj.methodWithUserTypeParam(refed) {
//      it.setString("foobarjuu")
//      assertEquals("foobarjuu", it.getString())
//      return "ok"
//    })
//  }
//
//  @Test
//  public void testObjectParam() {
//    assertEquals("ok", obj.methodWithObjectParam(123) {
//      assertEquals(123, it)
//      return "ok"
//    })
//    assertEquals("ok", obj.methodWithObjectParam("the-string-arg") {
//      assertEquals("the-string-arg", it)
//      return "ok"
//    })
//  }
//
//  @Test
//  public void testDataObjectParam() {
//    assertEquals("ok", obj.methodWithDataObjectParam() {
//      assertEquals("foo_value", it.foo)
//      assertEquals(3, it.bar)
//      assertEquals(0.01, it.wibble, 0)
//      return "ok"
//    })
//  }
//
//  @Test
//  public void testEnumParam() {
//    assertEquals("ok", obj.methodWithEnumParam() {
//      assertEquals(TestEnum.TIM, it)
//      return "ok"
//    })
//  }
//
//  @Test
//  public void testListParam() {
//    assertEquals("ok", obj.methodWithListParam() {
//      assertEquals(["one", "two", "three"], it)
//      return "ok"
//    })
//  }
//
//  @Test
//  public void testSetParam() {
//    assertEquals("ok", obj.methodWithSetParam() {
//      assertEquals(["one", "two", "three"] as Set, it)
//      return "ok"
//    })
//  }
//
//  @Test
//  public void testMapParam() {
//    assertEquals("ok", obj.methodWithMapParam() {
//      assertEquals([one:"one", two:"two", three:"three"], it)
//      return "ok"
//    })
//  }
//
//  @Test
//  public void testGenericParam() {
//    assertEquals("ok", obj.methodWithGenericParam(123) {
//      assertEquals(123, it)
//      return "ok"
//    })
//    assertEquals("ok", obj.methodWithGenericParam("the-string-arg") {
//      assertEquals("the-string-arg", it)
//      return "ok"
//    })
//  }
//
//  @Test
//  public void testGenericUserTypeParam() {
//    assertEquals("ok", obj.methodWithGenericUserTypeParam(123) {
//      assertEquals(123, it.getValue())
//      return "ok"
//    })
//    assertEquals("ok", obj.methodWithGenericUserTypeParam("the-string-arg") {
//      assertEquals("the-string-arg", it.getValue())
//      return "ok"
//    })
//  }
//
//  @Test
//  public void testNullableListParam() {
//    assertEquals("ok", obj.methodWithNullableListParam() {
//      assertEquals(null, it)
//      return "ok"
//    })
//  }
//
//  @Test
//  public void testBasicReturn() {
//    assertEquals("ok", obj.methodWithBasicReturn(
//      { (byte)10 },
//      { (short)1000 },
//      { (int)100000 },
//      { (long)10000000000 },
//      { (float)0.01 },
//      { (double)0.00001 },
//      { true },
//      { 'C' as Character },
//      { "the-return" }
//    ))
//  }
//
//  @Test
//  public void testJsonReturn() {
//    assertEquals("ok", obj.methodWithJsonReturn(
//      { [foo:"foo_value",bar:10,wibble:0.1] },
//      { ["one","two","three"] }
//    ))
//  }
//
//  @Test
//  public void testObjectReturn() {
//    assertEquals("ok", obj.methodWithObjectReturn(
//      {
//        switch (it) {
//          case 0: return "the-string"
//          case 1: return 123
//          case 2: return true
//          case 3: return [foo:"foo_value"]
//          case 4: return ["foo","bar"]
//          default: throw new Exception()
//        }
//      }
//    ))
//  }
//
//  @Test
//  public void testDataObjectReturn() {
//    assertEquals("ok", obj.methodWithDataObjectReturn({[foo:"wasabi",bar:6,wibble:0.01]}))
//  }
//
//  @Test
//  public void testEnumReturn() {
//    assertEquals("ok", obj.methodWithEnumReturn({TestEnum.NICK}))
//  }
//
//  @Test
//  public void testListReturn() {
//    assertEquals("ok", obj.methodWithListReturn({["one", "two", "three"]}))
//  }
//
//  @Test
//  public void testSetReturn() {
//    assertEquals("ok", obj.methodWithSetReturn({["one", "two", "three"] as Set}))
//  }
//
//  @Test
//  public void testMapReturn() {
//    assertEquals("ok", obj.methodWithMapReturn({[one:"one", two:"two", three:"three"]}))
//  }
//
//  @Test
//  public void testGenericReturn() {
//    // Does not pass -> CCE in Groovy -> investigate
//    /*
//        assertEquals("ok", obj.methodWithGenericReturn(
//            {
//              switch (it) {
//                case 0: return "the-string"
//                case 1: return 123
//                case 2: return true
//                case 3: return [foo:"foo_value"]
//                case 4: return ["foo","bar"]
//                default: throw new Exception()
//              }
//            }
//        ))
//    */
//  }
//
//  @Test
//  public void testGenericUserTypeReturn() {
//    assertEquals("ok", obj.methodWithGenericUserTypeReturn({ it }))
//  }
//
//  @Test
//  public void testNullableListReturn() {
//    assertEquals("ok", obj.methodWithNullableListReturn({ null }))
//  }
}
