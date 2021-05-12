package service

import akka.stream.scaladsl.Source
import config.AppConfig._
import model.{AddItem, RemoveItem}
import utils.Logging

object ItemService extends Logging {

  def addItem(itemId: String): Unit = itemActor ! AddItem(itemId)

  def removeItem(itemId: String): Unit = itemActor ! RemoveItem(itemId)

  // https://doc.akka.io/docs/akka/current/stream/operators/Source/actorRefWithBackpressure.html
//  val sourceFromActor = Source.actorRefWithBackpressure[Long](Int.MaxValue)
}
