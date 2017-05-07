Disclaimer
==========
The code in here is currently in an early preview state.

What is it?
===========
This project provides a straming API solely based on Scala and Vert.x Read/WriteStreams.
Main aim was a convenient way for writing streams and use the already existing backpressure mechanisms available in 
Vert.x

Reactive Streams?
=================
The whole API is based on Reactive Streams (the basic Reactive Streams interfaces have been copied and renamed to 
avoid confusions). The aim of this project is to provide backpressure as defined by the Reactive Streams project but 
focus on the way Vert.x is dealing with threads.

The basic guideline is that a created stream and its stages perform on the Vert.x-eventloop thread they were created on. 
That means that all operations delivering to and receiving from a stage run in this very thread. A stage is free to 
 perform async operations as long as it makes sure they all return on the correct hread (see implementations of the 
 SyncStage and the FutureStage for further details).
As Reactive Streams are more and more becoming a standard for connecting different libraries/frameworks across 
thread-boundaries I provided a ReactiveStreamsSubscriberSink and a ReactiveStreamsPublisherSource to connect to 
frameworks like Akka or Reactor.

How to use it ?
===============
Everything is centered around *io.vertx.lang.scala.streams.Rs*. You should never have to access API-classes directly.
Inside a Verticle to the following to get all required operations:
```io.vertx.lang.scala.streams.Rs._```

Let's take small example:
```
val input = vertx.eventBus().consumer[String]("input")
val output = vertx.eventBus().sender[String]("output")
  
input.toSource
  .map(a => a.body())
  .filter(a => a.startsWith("Hello"))
  .sink(output)
```
This silly example consumes incoming messages from the *inout*-address, removes all events not starting with "Hello" and
 forwards the remaining ones to the eventbus-address *output*. All covered by backpressure.
