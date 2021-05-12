package actors

import akka.actor.Actor
import akka.stream.OverflowStrategy
import akka.stream.scaladsl.{Keep, Sink, Source, SourceQueueWithComplete}
import config.AppConfig._
import model.{AddItem, RemoveItem}
import utils.Logging

import scala.concurrent.duration.{DurationInt, FiniteDuration}

class ItemActor extends Actor with Logging {

  val bufferSize: Int        = 10
  val elementsToProcess: Int = 5
  val per: FiniteDuration    = 3.seconds

  def receive: Receive = {
    case AddItem(itemId) =>
      val response = s"Adding $itemId"
      logger.info(s"[ACTOR] $response")
      queue.offer(response)
    case RemoveItem(itemId) =>
      val response = s"Removing $itemId"
      logger.info(s"[ACTOR] $response")
      queue.offer(response)
    case _ => logger.error("Invalid input provided")
  }

  val queue: SourceQueueWithComplete[String] = Source
    .queue[String](bufferSize, OverflowStrategy.backpressure)
    .throttle(elementsToProcess, per)
    .toMat(Sink.foreach(x => logger.info(s"[QUEUE] $x")))(Keep.left)
    .run()
}
