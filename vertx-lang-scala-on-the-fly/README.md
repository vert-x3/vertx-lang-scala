A small library to allow compiling classes from classpath/string.
It will also resolve classes your script depends on and for which code 
is available on the classpath.

Execute script:
```scala
import de.codepitbull.lang.scala.onthefly.OnTheFlyCompiler

val compiler = new OnTheFlyCompiler(None)
val script   = "println(\"you should see me\")"

compiler.eval[Unit](script)
```

Compile class and execute a method on it:
```scala
import de.codepitbull.lang.scala.onthefly.OnTheFlyCompiler

val compiler = new OnTheFlyCompiler(None)
val script = "import de.codepitbull.scala.onthefly.Extendthis\n" +
             "class Test extends Extendthis{\n" +
             "override def hello():String = \"hello\"\n" +
             "}"
             
compiler.compileClass(script)

compiler
  .findClass("Test")
  .get
  .newInstance()
  .asInstanceOf[Extendthis]
  .hello()
```

Alternative: https://github.com/kostaskougios/scalascriptengine
