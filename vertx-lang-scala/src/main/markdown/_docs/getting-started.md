---
sidebar_position: 1
---

# Geting started 

Let's discover how to get started with a new Vert.x/Scala project.

Before we can start coding, we need:

  - JDK 11 or higher
  - A text editor or IDE
  - [sbt](https://www.scala-sbt.org) - the Scala Build Tool
  - `curl` or [`httpie`](https://httpie.io) or a web browser to perform HTTP requests

## 1. Bootstrap the project

One way to create a new project is to use the [Giter8](https://www.foundweekends.org/giter8/) template:

```shell
$ sbt new vert-x3/vertx-scala.g8
```

sbt will take a little moment to download and compile the template. Then, we will have to answer some questions (or go with the defaults):

  - **name** (e.g. `vertx-scala`)
  - **package** (e.g. `vertx.scala.myapp`)
  - **httpPort** (e.g. `8666`)
  - **version** (e.g. `0.1.0-SNAPSHOT`)
  - **organization** (e.g. `vertx.scala`)

After that, the project is set up and ready to be used.

## 2. Inspect the project's contents

The generated project contains:

  - The sbt build script configured to compile, assemble, test and run your application
  - A sample Verticle and sample test using [ScalaTest](https://www.scalatest.org)
  - A `README.md` file with instructions how to build and run the application

## 3. Code

Open the project in the editor or IDE of your choice and navigate to the file `HttpVerticle.scala` under `src/main/scala`. This source file contains a sample 
`Verticle` (the Vert.x deployment unit) that starts an HTTP server. We're going to modify it to greet whoever performs requests to the server. Let's change the
code as follows:

```scala mdoc:invisible
import io.vertx.lang.scala.ScalaVerticle
import io.vertx.ext.web.Router
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture

import scala.concurrent.Future
import scala.jdk.CollectionConverters.*
import scala.language.implicitConversions
import io.vertx.lang.scala.json.Json
```
```scala mdoc:nest title="HttpVerticle.scala"
class HttpVerticle extends ScalaVerticle:

  override def asyncStart: Future[Unit] =
    // Mount the handler for all incoming requests at every path and HTTP method
    val router = Router.router(vertx)
    router.route().handler(ctx => {
      // Get the address of the request
      val address = ctx.request.connection.remoteAddress.toString
      // Get the query parameter "name" or use "World" as default
      val name = ctx.queryParam("name").asScala.toList match
        case n :: _ => n
        case _      => "World"
      val greeting = s"Hello $name connected from $address"
      
      // Write a JSON response
      ctx.json(Json.obj(s"""
        {
          "name": "$name",
          "address": "$address",
          "message": "$greeting"
        }
      """))
    })

    vertx
      .createHttpServer()
      .requestHandler(router)
      .listen(8666, "0.0.0.0")
      .mapEmpty[Unit]()
```

This code cre­ates a Vert.x Web Router (the ob­ject used to route HTTP re­quests to spe­cific re­quest han­dlers) and starts an HTTP Server on port 8666. On each re­quest, it re­turns a JSON ob­ject con­tain­ing the ad­dress of the re­quest, the query pa­ra­me­ter name, and a greet­ing mes­sage.


## 4. Run

To run the code, we will use the [`sbt-revolver`](https://github.com/spray/sbt-revolver) plugin. This will restart the application automatically when any source file has changed. That way, we will have a very short turnaround time.

Open a terminal and navigate to the project directory. Then, open an `sbt` shell:

```shell
$ sbt
```

When sbt prompts for input, type `~reStart` to start the application via _sbt-revolver_ and watch the file system for changes.

```shell
sbt:vertx-scala> ~reStart

[info] Application root not yet started
[info] Starting application root in the background ...
root Starting io.vertx.core.Launcher.main(run, scala:vertx.scala.myapp.HttpVerticle)
[success] Total time: 1 s, completed 10.11.2023, 01:19:42
[info] 1. Monitoring source files for root/reStart...
[info]    Press <enter> to interrupt or '?' for more options.
root[ERROR] Succeeded in deploying verticle 
```

Now that the server is up and running, try to send a request:

import Tabs from '@theme/Tabs';
import TabItem from '@theme/TabItem';

<Tabs>
<TabItem value="httpie">

```shell
$ http localhost:8666?name=Ernie
HTTP/1.1 200 OK
content-length: 115
content-type: application/json; charset=utf-8

{
  "name": "Ernie",
  "address": "127.0.0.1:54542",
  "message": "Hello Ernie connected from 127.0.0.1:54542"
}
```

</TabItem>
<TabItem value="curl">

```shell
$ curl http://localhost:8666?name=Bert
{
  "name": "Bert",
  "address": "127.0.0.1:54542",
  "message": "Hello Bert connected from 127.0.0.1:54542"
}
```

</TabItem>
</Tabs>


## 5. Go further

Now that we've had a taste of how easy and fun it is to get started with Vert.x
and Scala, here are some pointers to help guide you further along the journey:

  - [Reactive Manifesto](https://www.reactivemanifesto.org) - this page explains what reactive systems are all about and why it is important to follow the principles.
  - [Eclipse Vert.x and reactive in a few words](https://vertx.io/introduction-to-vertx-and-reactive/) - read a few words about how Vert.x helps you build reactive systems.
  - [Vert.x for Scala Documentation](installation.md) - read a more detailed explanation of all the components that make up Vert.x for Scala
  - [Vert.x Documentation](https://vertx.io/docs/) - read about all available Vert.x modules