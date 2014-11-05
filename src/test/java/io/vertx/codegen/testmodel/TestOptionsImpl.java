package io.vertx.codegen.testmodel;

import io.vertx.core.json.JsonObject;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class TestOptionsImpl implements TestOptions {

  private String foo;
  private int bar;
  private double wibble;

  public TestOptionsImpl() {
  }

  public TestOptionsImpl(JsonObject json) {
    this.foo = json.getString("foo", null);
    this.bar = json.getInteger("bar", 0);
    this.wibble = (double)json.getNumber("wibble", 0);
  }

  public String getFoo() {
    return foo;
  }

  public TestOptions setFoo(String foo) {
    this.foo = foo;
    return this;
  }

  public int getBar() {
    return bar;
  }

  public TestOptions setBar(int bar) {
    this.bar = bar;
    return this;
  }

  public double getWibble() {
    return wibble;
  }

  public TestOptions setWibble(double wibble) {
    this.wibble = wibble;
    return this;
  }
}
