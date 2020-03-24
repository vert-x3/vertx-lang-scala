package io.vertx.lang.scala.codegen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RenderHelpers {
  /**
   * Read template-file from the classpath and return contents as string.
   * @param fileName
   * @return
   * @throws IOException
   */
  public static String renderFile(String fileName) throws IOException{
    Class clazz = Templates.class;
    InputStream inputStream = clazz.getResourceAsStream("/templates/"+ fileName);
    return readFromInputStream(inputStream);
  }

  /**
   * Helper for converting an InputStream to a String.
   * @param inputStream
   * @return
   * @throws IOException
   */
  public static String readFromInputStream(InputStream inputStream) throws IOException {
    StringBuilder resultStringBuilder = new StringBuilder();
    try (BufferedReader br
           = new BufferedReader(new InputStreamReader(inputStream))) {
      String line;
      while ((line = br.readLine()) != null) {
        resultStringBuilder.append(line).append("\n");
      }
    }
    return resultStringBuilder.toString();
  }
}
