package io.vertx.lang.scala;

import com.fasterxml.jackson.module.scala.DefaultScalaModule$;
import io.vertx.core.json.Json;

/**
 * This class is needed due to the lack of real static-blocks in Scala.
 * It will register the DefaultScalaCodec for de/encoding of Case-Classes to/from JSON.
 */
public class JsonInit {

  static {
    Json.mapper.registerModule(DefaultScalaModule$.MODULE$);
  }

  /**
   * The only purpose of this method is to trigger the static-block above.
   *
   * https://docs.oracle.com/javase/specs/jls/se8/html/jls-12.html#jls-12.4.1
   */
  public static void init(){};
}
