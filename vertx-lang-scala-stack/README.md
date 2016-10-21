# Scala Stack

Project for building scala-flavored vertx-modules.

##Problems

vertx-unit can't be built because of a missing type-param in EventBusCollector.scala:41.

Reason:

In EventBusCollector.java there is this method  _MessageConsumer register(String address);_
