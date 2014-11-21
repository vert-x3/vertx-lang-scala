package io.vertx.codegen.testmodel;

/**
 * @author <a href="http://tfox.org">Tim Fox</a>
 */
public class RefedInterface1Impl implements RefedInterface1 {

  private String str;

  @Override
  public String getString() {
    return str;
  }

  @Override
  public RefedInterface1 setString(String str) {
    this.str = str;
    return this;
  }

  @Override
  public boolean equals(Object obj) {
    return ((RefedInterface1Impl) obj).str.equals(str);
  }

  @Override
  public String toString() {
    return "TestInterface1[str=" + str + "]";
  }
}
