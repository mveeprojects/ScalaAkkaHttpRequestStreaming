# Scala Akka Http Request Streaming

The intention of this codebase is to figure out how to feed Akka HTTP requests to an Akka Source.

This has been achieved by feeding Akka HTTP requests to an Actor which then offers the request information (a String) to a queue (Source.queue).

### Routes
* Add item: `curl -X PUT http://localhost:8080/item/abc`
* Delete item: `curl -X DELETE http://localhost:8080/item/abc`

### Sources:
* https://alvinalexander.com/scala/akka-actors-introduction-tutorial-101/
* https://doc.akka.io/docs/akka/current/stream/operators/Source/actorRefWithBackpressure.html
* https://doc.akka.io/docs/akka/current/stream/actor-interop.html#source-queue