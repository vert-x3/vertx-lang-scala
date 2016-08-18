Using it
========

After building this project you can start using it with the following prototype:

[Vert.x Scala Lang SBT-starter](https://github.com/codepitbull/vertx-scala-sbt)

If you want to play with Vert.x-web and the security modules check out and build:

[Vert.x Scala Lang Stack](https://github.com/codepitbull/vertx-lang-scala-stack)

Decisions and how they came to be
=================================

Why currying?
=============

Everywhere a handler is used the API looks like this:
```
def sendWithHandler[T](address: String, message: AnyRef)( replyHandler: io.vertx.core.AsyncResult [io.vertx.scala.core.eventbus.Message[T]] => Unit) ...
```
The methods are curried for a simple reason: Scala type inference. Using the above method would look like like this:
```
vertx.eventBus.sendWithHandler[String]("hello", "msg")(reply => ...)
```
This is pretty straight forward. Let's look at an example without currying.
```
def sendWithHandler[T](address: String, message: AnyRef, replyHandler: io.vertx.core.AsyncResult [io.vertx.scala.core.eventbus.Message[T]] => Unit) ...
```
While difference in the API is pretty small, using it becomes awkward:
```
vertx.eventBus.sendWithHandler[String]("hello", "msg", (reply: AsyncResult [io.vertx.scala.core.eventbus.Message[String]]) => ...)
```
We have to provide a lot of more type-information to make this piece of code work. 

Why get some methods 'WithHandler' appended to their original names?
====================================================================
After solving the original typing problem with currying, another problem popped up.

Let's take a look at the original code without appended *WithHandler*
```
  def send(address: String, message: AnyRef)
  def send[T](address: String, message: AnyRef)( replyHandler: io.vertx.core.AsyncResult [io.vertx.scala.core.eventbus.Message[T]] => Unit)
```
The Scala-compiler can't decide which method to pich when calling _send("address", "hello world")_. The only option here is to change the method name
to avoid these _overloading_ issues. Currying and method overloading simply don't play nice along and the rule of thumb is that you can have one or the 
other.
