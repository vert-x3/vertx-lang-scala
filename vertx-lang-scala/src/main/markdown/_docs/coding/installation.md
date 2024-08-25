---
title: Installation
---

# Installation

To use Vert.x for Scala, add the following dependency to the _dependencies_ section of your
build descriptor:


## sbt

```sbt
libraryDependencies += "io.vertx" % "vertx-core" % "{{projectVersion}}"
libraryDependencies += "io.vertx" %% "vertx-lang-scala" % "{{projectVersion}}"
```

## Gradle

```kotlin title="build.gradle"
implementation "io.vertx:vertx-core:{{projectVersion}}"
implementation "io.vertx:vertx-lang-scala_3:{{projectVersion}}"
```

## Maven

```xml title="pom.xml"
<dependency>
  <groupId>io.vertx</groupId>
  <artifactId>vertx-core</artifactId>
  <version>{{projectVersion}}</version>
</dependency>
<dependency>
  <groupId>io.vertx</groupId>
  <artifactId>vertx-lang-scala_3</artifactId>
  <version>{{projectVersion}}</version>
</dependency>
```


## What is in the package?

As of now, Vert.x for Scala provides

  - implicit conversions between Vert.x Futures/Promises and Scala Futures/Promises
  - a base class for Verticle implementations, [[io.vertx.lang.scala.ScalaVerticle]]
  - an [ExecutionContext](https://scala-lang.org/api/3.x/scala/concurrent/ExecutionContext$.html) that is `given` by any `ScalaVerticle`
  - the [[io.vertx.lang.scala.json.Json]] object which provides some useful smart constructors and functions
  - and generated `apply` methods for most of Vert.x' Data Objects

At the moment, Vert.x for Scala does not provide generated APIs for Vert.x `core` or any other
module. This is something that is up for the future.
