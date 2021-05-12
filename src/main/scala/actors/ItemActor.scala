package actors

import akka.actor.Actor
import akka.stream.OverflowStrategy
import akka.stream.scaladsl.{Keep, Sink, Source, SourceQueueWithComplete}
import config.AppConfig._
import config.AppConfig.appConfig.stream._
import model.{AddItem, RemoveItem}
import utils.Logging

class ItemActor extends Actor with Logging {

  def receive: Receive = {
    case AddItem(itemId) =>
      val response = s"Adding $itemId"
      logger.info(s"[ACTOR] $response")
      itemQueue.offer(response)
    case RemoveItem(itemId) =>
      val response = s"Removing $itemId"
      logger.info(s"[ACTOR] $response")
      itemQueue.offer(response)
    case _ => logger.error("Invalid input provided")
  }

  val itemQueue: SourceQueueWithComplete[String] = Source
    .queue[String](bufferSize, OverflowStrategy.backpressure)
    .throttle(elementsToProcess, interval)
    .toMat(Sink.foreach(x => logger.info(s"[QUEUE] $x")))(Keep.left)
    .run()
}
