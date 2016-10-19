package io.vertx.lang.scala.onthefly

import scala.reflect.internal.util.SourceFile
import scala.tools.nsc.reporters.ConsoleReporter
import scala.tools.nsc.{Global, Settings}

/**
  * The Scala-compiler retains state between compilations. Especially the reporter is problematic as it
  * is checked for errors on each run and the run won't start if any error from the previous run is not cleared.
  * This class also takes of creating the required run-Instances as these aren't reuasble betwen executions.
  *
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
class ReusableCompiler(settings: Settings) {

  private val reporter = new ConsoleReporter(settings)

  private val global = new Global(settings, reporter)

  def compileSources(list: List[SourceFile]): Unit = {
    val run = new global.Run
    reporter.reset()
    run.compileSources(list)
    if(reporter.hasErrors)
      throw new ClassNotFoundException("Unable to compile sources, check logs.")
  }
}

object ReusableCompiler {
  def apply(settings: Settings): ReusableCompiler =
    new ReusableCompiler(settings)
}
