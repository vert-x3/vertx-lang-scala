package io.vertx.lang.scala.tck

import io.vertx.codegen.testmodel.DataObjectTCKImpl
import io.vertx.scala.codegen.testmodel.DataObjectTCK
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
class DataObjectTCKTest extends FlatSpec with Matchers {
  val dataObjectTCK = DataObjectTCK(new DataObjectTCKImpl())

//  "testReadDataObjectWithValues" should "work" in {
//    val dataObject = dataObjectTCK.getDataObjectWithValues();
//    assert(true == dataObject.booleanValue);
//    assert(520 == dataObject.shortValue);
//    assert(123456 == dataObject.intValue);
//    assert(123456789 == dataObject.longValue);
//    assert(1.1 == dataObject.floatValue);
//    assert(1.11 == dataObject.doubleValue);
//    assert(1040 == dataObject.boxedShortValue);
//    assert(true == dataObject.boxedBooleanValue);
//    assert(654321 == dataObject.boxedIntValue);
//    assert(987654321 == dataObject.boxedLongValue);
//    assert(2.2 == dataObject.boxedFloatValue);
//    assert(2.22 == dataObject.boxedDoubleValue);
//    assert("wibble" == dataObject.stringValue);
//    assert(JsonObject{"foo"->"eek" =="bar"->"wibble"} == dataObject.jsonObjectValue);
//    assert(JsonArray{"eek" =="wibble"} == dataObject.jsonArrayValue);
//    assert("TIM" == dataObject.enumValue);
//    assert(mike == dataObject.genEnumValue);
//    assert("1" == dataObject.dataObjectValue?.foo);
//    assert(1 == dataObject.dataObjectValue?.bar);
//    assert(1.1 == dataObject.dataObjectValue?.wibble);
//  }
//
//  shared test void testWriteDataObjectWithValues() {
//    value dataObject = DataObjectWithValues {
//      booleanValue = true;
//      shortValue = 520;
//      intValue = 123456;
//      longValue = 123456789;
//      floatValue = 1.1;
//      doubleValue = 1.11;
//      boxedBooleanValue = true;
//      boxedShortValue = 1040;
//      boxedIntValue = 654321;
//      boxedLongValue = 987654321;
//      boxedFloatValue = 2.2;
//      boxedDoubleValue = 2.22;
//      stringValue = "wibble";
//      jsonObjectValue = JsonObject{"foo"->"eek","bar"->"wibble"};
//      jsonArrayValue = JsonArray{"eek","wibble"};
//      enumValue = "TIM";
//      genEnumValue = mike;
//      dataObjectValue = TestDataObject { foo="1"; bar=1; wibble=1.1; };
//    };
//    dataObjectTCK.setDataObjectWithValues(dataObject);
//  }
//
//  shared test void testReadDataObjectWithLists() {
//    value dataObject = dataObjectTCK.getDataObjectWithLists();
//    assert(exists booleanValues = dataObject.booleanValues);
//    assertEquals(ArrayList{true,false,true}, ArrayList{*booleanValues});
//    assert(exists shortValues = dataObject.shortValues);
//    assertEquals(ArrayList{0,520,1040}, ArrayList{*shortValues});
//    assert(exists integerValues = dataObject.integerValues);
//    assertEquals(ArrayList{0,123456,654321}, ArrayList{*integerValues});
//    assert(exists longValues = dataObject.longValues);
//    assertEquals(ArrayList{0,123456789,987654321}, ArrayList{*longValues});
//    assert(exists floatValues = dataObject.floatValues);
//    assertEquals(ArrayList{1.1,2.2,3.3}, ArrayList{*floatValues});
//    assert(exists doubleValues = dataObject.doubleValues);
//    assertEquals(ArrayList{1.11,2.22,3.33}, ArrayList{*doubleValues});
//    assert(exists stringValues = dataObject.stringValues);
//    assertEquals(ArrayList{"stringValues1","stringValues2","stringValues3"}, ArrayList{*stringValues});
//    assert(exists jsonObjectValues = dataObject.jsonObjectValues);
//    assertEquals(ArrayList{JsonObject{"foo"->"eek"},JsonObject{"foo"->"wibble"}}, ArrayList{*jsonObjectValues});
//    assert(exists jsonArrayValues = dataObject.jsonArrayValues);
//    assertEquals(ArrayList{JsonArray{"foo"},JsonArray{"bar"}}, ArrayList{*jsonArrayValues});
//    assert(exists dataObjectValues = dataObject.dataObjectValues?.sequence());
//    assertEquals(2, dataObjectValues.size);
//    assert(exists dataObject1 = dataObjectValues[0]);
//    assert(exists dataObject2 = dataObjectValues[1]);
//    assert(exists enumValues = dataObject.enumValues);
//    assertEquals(ArrayList{"TIM", "JULIEN"}, ArrayList{*enumValues});
//    assert(exists genEnumValues = dataObject.genEnumValues);
//    assertEquals(ArrayList{bob, laura}, ArrayList{*genEnumValues});
//  }
//
//  shared test void testWriteDataObjectWithLists() {
//    value dataObject = DataObjectWithLists {
//      booleanValues = { true, false, true };
//      shortValues = { 0, 520, 1040 };
//      integerValues = { 0, 123456, 654321 };
//      longValues = { 0, 123456789, 987654321 };
//      floatValues = { 1.1, 2.2, 3.3 };
//      doubleValues = { 1.11, 2.22, 3.33 };
//      jsonObjectValues = {JsonObject{"foo"->"eek"},JsonObject{"foo"->"wibble"}};
//      jsonArrayValues = {JsonArray{"foo"},JsonArray{"bar"}};
//      stringValues = { "stringValues1", "stringValues2", "stringValues3" };
//      dataObjectValues = { TestDataObject { foo="1"; bar=1; wibble=1.1; }, TestDataObject { foo="2"; bar=2; wibble=2.2; } };
//      enumValues = { "TIM", "JULIEN" };
//      genEnumValues = { bob, laura };
//    };
//    dataObjectTCK.setDataObjectWithLists(dataObject);
//  }
//
//  shared test void testReadDataObjectWithMaps() {
//    value dataObject = dataObjectTCK.getDataObjectWithMaps();
//    assertEquals(HashMap{"1"->true,"2"->false}, dataObject.booleanValues);
//    assertEquals(HashMap{"1"->520,"2"->1040}, dataObject.shortValues);
//    assertEquals(HashMap{"1"->123456,"2"->654321}, dataObject.integerValues);
//    assertEquals(HashMap{"1"->123456789,"2"->987654321}, dataObject.longValues);
//    assertEquals(HashMap{"1"->"stringValues1","2"->"stringValues2"}, dataObject.stringValues);
//    assertEquals(HashMap{"1"->JsonObject{"foo"->"eek"},"2"->JsonObject{"foo"->"wibble"}}, dataObject.jsonObjectValues);
//    assertEquals(HashMap{"1"->JsonArray{"foo"},"2"->JsonArray{"bar"}}, dataObject.jsonArrayValues);
//    assertEquals("1", dataObject.dataObjectValues?.get("1")?.foo);
//    assertEquals(1, dataObject.dataObjectValues?.get("1")?.bar);
//    assertEquals(1.1, dataObject.dataObjectValues?.get("1")?.wibble);
//    assertEquals("2", dataObject.dataObjectValues?.get("2")?.foo);
//    assertEquals(2, dataObject.dataObjectValues?.get("2")?.bar);
//    assertEquals(2.2, dataObject.dataObjectValues?.get("2")?.wibble);
//    assertEquals(HashMap{"1"->"TIM","2"->"JULIEN"}, dataObject.enumValues);
//    assertEquals(HashMap{"1"->bob,"2"->laura}, dataObject.genEnumValues);
//  }
//
//  shared test void testWriteDataObjectWithMaps() {
//    value dataObject = DataObjectWithMaps {
//      booleanValues = HashMap { "1"->true, "2"->false };
//      shortValues = HashMap { "1"->520, "2"->1040 };
//      integerValues = HashMap { "1"->123456, "2"->654321 };
//      longValues = HashMap { "1"->123456789, "2"->987654321 };
//      floatValues = HashMap { "1"->1.1, "2"->2.2 };
//      doubleValues = HashMap { "1"->1.11, "2"->2.22 };
//      stringValues = HashMap { "1"->"stringValues1", "2"->"stringValues2" };
//      jsonObjectValues = HashMap { "1"->JsonObject{"foo"->"eek"}, "2"->JsonObject{"foo"->"wibble"} };
//      jsonArrayValues = HashMap { "1"->JsonArray{"foo"}, "2"->JsonArray{"bar"} };
//      dataObjectValues = HashMap { "1"-> TestDataObject { foo="1"; bar=1; wibble=1.1; },"2" -> TestDataObject { foo="2"; bar=2; wibble=2.2; } };
//      enumValues = HashMap { "1"->"TIM", "2"->"JULIEN" };
//      genEnumValues = HashMap { "1"->bob, "2"->laura };
//    };
//    dataObjectTCK.setDataObjectWithMaps(dataObject);
//  }
//
//  void testMethodWithOnlyJsonObjectConstructorDataObject() {
//    value dataObject = DataObjectWithOnlyJsonObjectConstructor {
//      foo="bar";
//    };
//    dataObjectTCK.methodWithOnlyJsonObjectConstructorDataObject(dataObject);
//  }
}
