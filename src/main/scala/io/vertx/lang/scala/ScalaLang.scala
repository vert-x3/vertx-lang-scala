package io.vertx.lang.scala

import io.vertx.codetrans.{CodeBuilder, Lang, Script}

/**
  * Created by jochen on 24.09.16.
  */
class ScalaLang extends Lang{
  def codeBuilder: CodeBuilder = new ScalaCodeBuilder

  @throws[Exception]
  def loadScript(loader: ClassLoader, source: String): Script = {
    throw new RuntimeException("can't compile on the fly")
  }

  def getExtension: String = {
    return "scala"
  }
}
