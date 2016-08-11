package io.vertx.lang.scala.tck

import io.vertx.codegen.testmodel.DataObjectTCKImpl
import io.vertx.lang.scala.json.Json
import io.vertx.scala.codegen.testmodel._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class DataObjectTCKTest extends FlatSpec with Matchers {
  val dataObjectTCK = DataObjectTCK(new DataObjectTCKImpl())

  "testReadDataObjectWithValues" should "work" in {
    val dataObject = dataObjectTCK.getDataObjectWithValues().asJava.toJson
    assert(true == dataObject.getBoolean("booleanValue"))
    assert(520 == dataObject.getInteger("shortValue"))
    assert(123456 == dataObject.getInteger("intValue"))
    assert(123456789 == dataObject.getLong("longValue"))
    assert(1.1f == dataObject.getFloat("floatValue"))
    assert(1.11 == dataObject.getDouble("doubleValue"))
    assert(1040 == dataObject.getInteger("boxedShortValue"))
    assert(true == dataObject.getBoolean("boxedBooleanValue"))
    assert(654321 == dataObject.getInteger("boxedIntValue"))
    assert(987654321 == dataObject.getLong("boxedLongValue"))
    assert(2.2f == dataObject.getFloat("boxedFloatValue"))
    assert(2.22 == dataObject.getDouble("boxedDoubleValue"))
    assert("wibble" == dataObject.getString("stringValue"))
    assert(Json.obj().put("foo", "eek").put("bar", "wibble") == dataObject.getJsonObject("jsonObjectValue"))
    assert(Json.arr("eek", "wibble") == dataObject.getJsonArray("jsonArrayValue"))
    assert("TIM" == dataObject.getString("enumValue"))
    assert("MIKE" == dataObject.getString("genEnumValue"))
    assert("1" == dataObject.getJsonObject("dataObjectValue").getString("foo"))
    assert(1 == dataObject.getJsonObject("dataObjectValue").getInteger("bar"))
    assert(1.1f == dataObject.getJsonObject("dataObjectValue").getFloat("wibble"))
  }


  "testWriteDataObjectWithValues" should "work" in {
    val dataObject = DataObjectWithValues.fromJson(Json.obj()
      .put("booleanValue", true)
      .put("shortValue", 520)
      .put("intValue", 123456)
      .put("longValue", 123456789)
      .put("floatValue", 1.1)
      .put("doubleValue", 1.11)
      .put("boxedBooleanValue", true)
      .put("boxedShortValue", 1040)
      .put("boxedIntValue", 654321)
      .put("boxedLongValue", 987654321)
      .put("boxedFloatValue", 2.2)
      .put("boxedDoubleValue", 2.22)
      .put("stringValue", "wibble")
      .put("jsonObjectValue", Json.obj().put("foo", "eek").put("bar", "wibble"))
      .put("jsonArrayValue", Json.arr("eek", "wibble"))
      .put("enumValue", "TIM")
      .put("genEnumValue", "MIKE")
      .put("dataObjectValue", Json.obj().put("foo", "1").put("bar", 1).put("wibble", 1.1f)))
    dataObjectTCK.setDataObjectWithValues(dataObject)
  }

  "testReadDataObjectWithLists" should "work" ignore {
    val dataObject = dataObjectTCK.getDataObjectWithLists().asJava.toJson
    assert(dataObject.getJsonArray("booleanValues") != null)
    assert(Json.arr(true, false, true) === dataObject.getJsonArray("booleanValues"))
    assert(dataObject.getJsonArray("shortValues") != null)
    assert(Json.arr(0, 520, 1040) == dataObject.getJsonArray("shortValues"))
    assert(dataObject.getJsonArray("integerValues") != null)
    assert(Json.arr(0, 123456, 654321) === dataObject.getJsonArray("integerValues"))
    assert(dataObject.getJsonArray("longValues") != null)
    assert(Json.arr(0, 123456789, 987654321) === dataObject.getJsonArray("longValues"))
    assert(dataObject.getJsonArray("floatValues") != null)
    assert(Json.arr(1.1f, 2.2f, 3.3f) === dataObject.getJsonArray("floatValues"))
    assert(dataObject.getJsonArray("doubleValues") != null)
    assert(Json.arr(1.11, 2.22, 3.33) === dataObject.getJsonArray("doubleValues"))
    assert(dataObject.getJsonArray("stringValues") != null)
    assert(Json.arr("stringValues1", "stringValues2", "stringValues3") === dataObject.getJsonArray("stringValues"))
    assert(dataObject.getJsonArray("jsonObjectValues") != null)
    assert(Json.arr(Json.obj().put("foo", "eek"), Json.obj().put("foo", "wibble")) === dataObject.getJsonArray("jsonObjectValues"))
    assert(dataObject.getJsonArray("jsonArrayValues") != null)
    assert(Json.arr(Json.arr("foo"), Json.arr("bar")) === dataObject.getJsonArray("jsonArrayValues"))
    assert(dataObject.getJsonArray("dataObjectValues") != null)
    val dataObjectValues = dataObject.getJsonArray("dataObjectValues")
    assert(2 == dataObjectValues.size)
    assert(dataObject.getJsonArray("dataObject1") == dataObjectValues.getJsonObject(0))
    assert(dataObject.getJsonArray("dataObject2") == dataObjectValues.getJsonObject(1))
    assert(dataObject.getJsonArray("enumValues") != null)
    assert(Json.arr("TIM", "JULIEN") === dataObject.getJsonArray("enumValues"))
    assert(dataObject.getJsonArray("genEnumValues") != null)
    assert(Json.arr("BOB", "LAURA") === dataObject.getJsonArray("genEnumValues"))
  }

  "testWriteDataObjectWithLists" should "work" ignore {
    import collection.JavaConversions._

    println(Json.arr(mapAsJavaMap(Map("foo" -> "eek")), mapAsJavaMap(Map("foo" -> "wibble"))).getValue(0).getClass)

    val dataObject = DataObjectWithLists.fromJson(Json.obj()
      .put("booleanValues", Json.arr(true, false, true))
      .put("shortValues", Json.arr(0, 520, 1040))
      .put("integerValues", Json.arr(0, 123456, 654321))
      .put("longValues", Json.arr(0l, 123456789l, 987654321l))
      .put("floatValues", Json.arr(1.1f, 2.2f, 3.3f))
      .put("doubleValues", Json.arr(1.11, 2.22, 3.33))
      //TODO broken due to automatic conversion
      .put("jsonObjectValues", Json.arr(mapAsJavaMap(Map("foo" -> "eek")), mapAsJavaMap(Map("foo" -> "wibble"))))
      .put("jsonArrayValues", Json.arr(Json.arr("foo"), Json.arr("bar")))
      .put("stringValues", Json.arr("stringValues1", "stringValues2", "stringValues3"))
      .put("dataObjectValues", Json.arr(Json.obj().put("foo", "1").put("bar", 1).put("wibble", 1.1f), Json.obj().put("foo", "2").put("bar", 2).put("wibble", 2.2f)))
      .put("enumValues", Json.arr("TIM", "JULIEN"))
      .put("genEnumValues", Json.arr("bob", "laura")))
    dataObjectTCK.setDataObjectWithLists(dataObject)
  }

  "testReadDataObjectWithMaps" should "work" ignore {
    val dataObject = dataObjectTCK.getDataObjectWithMaps().asJava.toJson
    assert(Json.obj().put("1", true).put("2", false) == dataObject.getJsonObject("booleanValues"))
    assert(Json.obj().put("1", 520).put("2", 1040) == dataObject.getJsonObject("shortValues"))
    assert(Json.obj().put("1", 123456).put("2", 654321) == dataObject.getJsonObject("integerValues"))
    assert(Json.obj().put("1", 123456789l).put("2", 987654321l) == dataObject.getJsonObject("longValues"))
    assert(Json.obj().put("1", "stringValues1").put("2", "stringValues2") == dataObject.getJsonObject("stringValues"))
    assert(Json.obj().put("1", Json.obj().put("foo", "eek")).put("2", Json.obj().put("foo", "wibble")) == dataObject.getJsonObject("jsonObjectValues"))
    assert(Json.obj().put("1", Json.arr("foo")).put("2", Json.arr("bar")) == dataObject.getJsonObject("jsonArrayValues"))
    assert("1" == dataObject.getJsonObject("dataObjectValues").getJsonObject("1").getString("foo"))
    assert(1 == dataObject.getJsonObject("dataObjectValues").getJsonObject("1").getInteger("bar"))
    assert(1.1f == dataObject.getJsonObject("dataObjectValues").getJsonObject("1").getFloat("wibble"))
    assert("2" == dataObject.getJsonObject("dataObjectValues").getJsonObject("2").getString("foo"))
    assert(2 == dataObject.getJsonObject("dataObjectValues").getJsonObject("2").getInteger("bar"))
    assert(2.2f == dataObject.getJsonObject("dataObjectValues").getJsonObject("2").getFloat("wibble"))
    assert(Json.obj().put("1", "TIM").put("2", "JULIEN") == dataObject.getJsonObject("enumValues"))
    assert(Json.obj().put("1", "bob").put("2", "laura") == dataObject.getJsonObject("genEnumValues"))
  }

  "testWriteDataObjectWithMaps" should "work" ignore {
    val dataObject = DataObjectWithMaps.fromJson(Json.obj()
      .put("booleanValues", Json.obj().put("1", true).put("2", false))
      .put("shortValues", Json.obj().put("1", 520).put("2", 1040))
      .put("integerValues", Json.obj().put("1", 123456).put("2", 654321))
      .put("longValues", Json.obj().put("1", 123456789).put("2", 987654321))
      .put("floatValues", Json.obj().put("1", 1.1).put("2", 2.2))
      .put("doubleValues", Json.obj().put("1", 1.11).put("2", 2.22))
      .put("stringValues", Json.obj().put("1", "stringValues1").put("2", "stringValues2"))
      .put("jsonObjectValues", Json.obj().put("1", Json.obj().put("foo", "eek")).put("2", Json.obj().put("foo", "wibble")))
      .put("jsonArrayValues", Json.obj().put("1", Json.arr("foo")).put("2", Json.arr("bar")))
      .put("dataObjectValues", Json.obj().put("1", Json.arr(Json.obj().put("foo", "1").put("bar", 1).put("wibble", 1.1f), Json.obj().put("foo", "2").put("bar", 2).put("wibble", 2.2f))))
      .put("enumValues", Json.obj().put("1", "TIM").put("2", "JULIEN"))
      .put("genEnumValues", Json.obj().put("1", "bob").put("2", "laura"))
    )
    dataObjectTCK.setDataObjectWithMaps(dataObject)
  }

  "testMethodWithOnlyJsonObjectConstructorDataObject" should "work" in {
    val dataObject = DataObjectWithOnlyJsonObjectConstructor.fromJson(Json.obj().put("foo", "bar"))
    dataObjectTCK.methodWithOnlyJsonObjectConstructorDataObject(dataObject)
  }
}
