# Scala Akka Http Request Streaming

The intention of this codebase is to figure out how to feed Akka HTTP requests to an Akka Source.

This has been achieved by feeding Akka HTTP requests to an Actor which then offers the request information (a String) to
a queue (`Source.queue`).

![request-streaming-diagram](diagram/ScalaAkkaHttpRequestStreaming.png)

I considered using `Source.actorRef` initially (instead of `Source.queue`), however this did not offer backpressure,
therefore I felt that `Source.queue` was generally a better option.

I also looked into `Source.actorRefWithBackpressure` however I couldn't figure out how to get this to work without also
needing an accompanying `Sink.actorRefWithBackpressure` (see example
10 [here](https://www.programcreek.com/scala/akka.stream.OverflowStrategy)), which defeated the purpose of this
exercise.

### Routes

* Add item: `curl -X PUT http://localhost:8080/item/abc`
* Delete item: `curl -X DELETE http://localhost:8080/item/abc`

### Future work

Handling the response from offering the message to the queue e.g. (taken from source-queue link below)

```scala
queue.offer(x).map {
  case QueueOfferResult.Enqueued => println(s"enqueued $x") // do something when all is good
  case QueueOfferResult.Dropped => println(s"dropped $x") // do something when the message is dropped
  case QueueOfferResult.Failure(ex) => println(s"Offer failed ${ex.getMessage}") // do something when the offer fails
  case QueueOfferResult.QueueClosed => println("Source Queue closed") // do something when the queue is closed
}
```

### Sources

* https://alvinalexander.com/scala/akka-actors-introduction-tutorial-101/
* https://doc.akka.io/docs/akka/current/stream/operators/Source/actorRef.html
* https://doc.akka.io/docs/akka/current/stream/operators/Source/actorRefWithBackpressure.html
* https://doc.akka.io/docs/akka/current/stream/actor-interop.html#source-queue