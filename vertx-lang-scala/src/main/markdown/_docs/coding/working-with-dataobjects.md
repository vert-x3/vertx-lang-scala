---
title: Working with DataObjects
---

== Data Objects with a Scala flavor
Data objects are heavily used all across the Vert.x API. To make things feel more native to Scala devs we generated their Scala counterparts with some additional functions.
For each Vert.x module the included data objects have been extended and can be found by simply adding a *scala* to the package name:

----
io.vertx.core => io.vertx.scala.core
----

Here is a quick example for PemKeyCertOptions.
[source, scala]
----
import io.vertx.scala.PemKeyCertOptions

PemKeyCertOptions() //Generate PemKeyCertOptions with default values
PemKeyCertOptions(json) // Generate PemKeyCertOptions from a Json-object
PemKeyCertOptions(certPath = "/tmp/certs") // Generate PemKeyCertOptions with default values but change certPath to /tmp/certs
----

The resulting instances can be used like regular data objects.