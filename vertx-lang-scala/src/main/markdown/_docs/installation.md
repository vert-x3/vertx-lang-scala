---
sidebar_position: 1
---

# Installation

To use Vert.x for Scala, add the following dependency to the _dependencies_ section of your
build descriptor:

import Tabs from '@theme/Tabs';
import TabItem from '@theme/TabItem';

<Tabs>
<TabItem value="sbt">

```scala title="build.sbt"
libraryDependencies += "io.vertx" %  "vertx-lang-scala3" % "@VERSION@"
```

</TabItem>
<TabItem value="Gradle">

```kotlin title="build.gradle"
implementation "io.vertx:vertx-lang-scala3:@VERSION@"
```

</TabItem>
<TabItem value="Maven">

```xml title="pom.xml"
<dependency>
  <groupId>io.vertx</groupId>
  <artifactId>vertx-lang-scala3</artifactId>
  <version>@VERSION@</version>
</dependency>
```

</TabItem>
</Tabs>


## What is in the package?

As of now, Vert.x for Scala provides 

  - implicit conversions between Vert.x Futures/Promises and Scala Futures/Promises
  - a base class for Verticle implementations, `ScalaVerticle`
  - an [ExecutionContext](https://scala-lang.org/api/3.x/scala/concurrent/ExecutionContext$.html) that is `given` by any `ScalaVerticle`
  - the `Json` `object` which provides some useful smart constructors and functions
  - and generated `apply` methods for most of Vert.x' Data Objects

At the moment, Vert.x for Scala does not provide generated APIs for Vert.x `core` or any other
module. This is something that is up for the future.
