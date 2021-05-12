package actors

import akka.actor.Actor
import model.{AddItem, RemoveItem}
import utils.Logging

trait AppActor extends Actor with Logging

class ItemActor extends AppActor {
  def receive: Receive = {
    case AddItem(itemId) => logger.info(s"Adding $itemId")
    case RemoveItem(itemId) => logger.info(s"Removing $itemId")
    case _ => logger.error("Invalid input provided")
  }
}
