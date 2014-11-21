package io.vertx.codegen.testmodel;

import io.vertx.codegen.annotations.CacheReturn;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.List;
import java.util.Set;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
@VertxGen
public interface TestInterface<T> extends SuperInterface1, SuperInterface2 {

  // Test params

  void methodWithBasicParams(byte b, short s, int i, long l, float f, double d, boolean bool, char ch, String str);

  void methodWithBasicBoxedParams(Byte b, Short s, Integer i, Long l, Float f, Double d, Boolean bool, Character ch);

  void methodWithHandlerBasicTypes(Handler<Byte> byteHandler, Handler<Short> shortHandler, Handler<Integer> intHandler,
                                   Handler<Long> longHandler, Handler<Float> floatHandler, Handler<Double> doubleHandler,
                                   Handler<Boolean> booleanHandler, Handler<Character> charHandler, Handler<String> stringHandler);

  void methodWithHandlerAsyncResultByte(boolean sendFailure, Handler<AsyncResult<Byte>> handler);
  void methodWithHandlerAsyncResultShort(boolean sendFailure, Handler<AsyncResult<Short>> handler);
  void methodWithHandlerAsyncResultInteger(boolean sendFailure, Handler<AsyncResult<Integer>> handler);
  void methodWithHandlerAsyncResultLong(boolean sendFailure, Handler<AsyncResult<Long>> handler);
  void methodWithHandlerAsyncResultFloat(boolean sendFailure, Handler<AsyncResult<Float>> handler);
  void methodWithHandlerAsyncResultDouble(boolean sendFailure, Handler<AsyncResult<Double>> handler);
  void methodWithHandlerAsyncResultBoolean(boolean sendFailure, Handler<AsyncResult<Boolean>> handler);
  void methodWithHandlerAsyncResultCharacter(boolean sendFailure, Handler<AsyncResult<Character>> handler);
  void methodWithHandlerAsyncResultString(boolean sendFailure, Handler<AsyncResult<String>> handler);

  void methodWithUserTypes(RefedInterface1 refed);

  void methodWithObjectParam(String str, Object obj);

  void methodWithOptionsParam(TestOptions options);

  void methodWithNullOptionsParam(TestOptions options);

  void methodWithHandlerListAndSet(Handler<List<String>> listStringHandler, Handler<List<Integer>> listIntHandler,
                                   Handler<Set<String>> setStringHandler, Handler<Set<Integer>> setIntHandler);

  void methodWithHandlerAsyncResultListString(Handler<AsyncResult<List<String>>> handler);
  void methodWithHandlerAsyncResultListInteger(Handler<AsyncResult<List<Integer>>> handler);
  void methodWithHandlerAsyncResultSetString(Handler<AsyncResult<Set<String>>> handler);
  void methodWithHandlerAsyncResultSetInteger(Handler<AsyncResult<Set<Integer>>> handler);

  void methodWithHandlerListVertxGen(Handler<List<RefedInterface1>> listHandler);

  void methodWithHandlerSetVertxGen(Handler<Set<RefedInterface1>> listHandler);

  void methodWithHandlerListJsonObject(Handler<List<JsonObject>> listHandler);

  void methodWithHandlerListNullJsonObject(Handler<List<JsonObject>> listHandler);

  void methodWithHandlerSetJsonObject(Handler<Set<JsonObject>> listHandler);

  void methodWithHandlerSetNullJsonObject(Handler<Set<JsonObject>> listHandler);

  void methodWithHandlerListJsonArray(Handler<List<JsonArray>> listHandler);

  void methodWithHandlerListNullJsonArray(Handler<List<JsonArray>> listHandler);

  void methodWithHandlerSetJsonArray(Handler<Set<JsonArray>> listHandler);

  void methodWithHandlerSetNullJsonArray(Handler<Set<JsonArray>> listHandler);

  void methodWithHandlerAsyncResultListVertxGen(Handler<AsyncResult<List<RefedInterface1>>> listHandler);

  void methodWithHandlerAsyncResultSetVertxGen(Handler<AsyncResult<Set<RefedInterface1>>> listHandler);

  void methodWithHandlerAsyncResultListJsonObject(Handler<AsyncResult<List<JsonObject>>> listHandler);

  void methodWithHandlerAsyncResultListNullJsonObject(Handler<AsyncResult<List<JsonObject>>> listHandler);

  void methodWithHandlerAsyncResultSetJsonObject(Handler<AsyncResult<Set<JsonObject>>> listHandler);

  void methodWithHandlerAsyncResultSetNullJsonObject(Handler<AsyncResult<Set<JsonObject>>> listHandler);

  void methodWithHandlerAsyncResultListJsonArray(Handler<AsyncResult<List<JsonArray>>> listHandler);

  void methodWithHandlerAsyncResultListNullJsonArray(Handler<AsyncResult<List<JsonArray>>> listHandler);

  void methodWithHandlerAsyncResultSetJsonArray(Handler<AsyncResult<Set<JsonArray>>> listHandler);

  void methodWithHandlerAsyncResultSetNullJsonArray(Handler<AsyncResult<Set<JsonArray>>> listHandler);

  void methodWithHandlerUserTypes(Handler<RefedInterface1> handler);

  void methodWithHandlerAsyncResultUserTypes(Handler<AsyncResult<RefedInterface1>> handler);

  void methodWithHandlerVoid(Handler<Void> handler);

  void methodWithHandlerAsyncResultVoid(boolean sendFailure, Handler<AsyncResult<Void>> handler);

  void methodWithHandlerThrowable(Handler<Throwable> handler);

  byte methodWithByteReturn();

  short methodWithShortReturn();

  int methodWithIntReturn();

  long methodWithLongReturn();

  float methodWithFloatReturn();

  double methodWithDoubleReturn();

  boolean methodWithBooleanReturn();

  char methodWithCharReturn();

  String methodWithStringReturn();

  RefedInterface1 methodWithVertxGenReturn();

  List<String> methodWithListStringReturn();

  Set<String> methodWithSetStringReturn();

  String overloadedMethod(String str, RefedInterface1 refed);

  String overloadedMethod(String str, RefedInterface1 refed, long period);

  String overloadedMethod(String str, RefedInterface1 refed, long period, Handler<String> handler);

  <U> U methodWithGenericReturn(String type);

  <U> void methodWithGenericParam(String type, U u);

  <U> void methodWithGenericHandler(String type, Handler<U> handler);

  <U> void methodWithGenericHandlerAsyncResult(String type, Handler<AsyncResult<U>> asyncResultHandler);

  @Fluent
  TestInterface fluentMethod(String str);

  static RefedInterface1 staticFactoryMethod(String foo) {
    RefedInterface1 refed = new RefedInterface1Impl();
    refed.setString(foo);
    return refed;
  }

  @CacheReturn
  RefedInterface1 methodWithCachedReturn(String foo);

  JsonObject methodWithJsonObjectReturn();

  JsonObject methodWithNullJsonObjectReturn();

  JsonArray methodWithJsonArrayReturn();

  JsonArray methodWithNullJsonArrayReturn();

  void methodWithJsonParams(JsonObject jsonObject, JsonArray jsonArray);

  void methodWithNullJsonParams(JsonObject jsonObject, JsonArray jsonArray);

  void methodWithHandlerJson(Handler<JsonObject> jsonObjectHandler, Handler<JsonArray> jsonArrayHandler);

  void methodWithHandlerNullJson(Handler<JsonObject> jsonObjectHandler, Handler<JsonArray> jsonArrayHandler);

  void methodWithHandlerAsyncResultJsonObject(Handler<AsyncResult<JsonObject>> handler);

  void methodWithHandlerAsyncResultNullJsonObject(Handler<AsyncResult<JsonObject>> handler);

  void methodWithHandlerAsyncResultJsonArray(Handler<AsyncResult<JsonArray>> handler);

  void methodWithHandlerAsyncResultNullJsonArray(Handler<AsyncResult<JsonArray>> handler);

}
