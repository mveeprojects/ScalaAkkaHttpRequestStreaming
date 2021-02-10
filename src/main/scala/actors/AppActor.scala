package actors

import akka.actor.Actor
import model.{AddItem, Hello, RemoveItem}
import utils.Logging

trait AppActor extends Actor with Logging

class HelloActor extends AppActor  {
  def receive: Receive = {
    case Hello(msg) => logger.info(s"You said: $msg")
    case _          => logger.info("huh?")
  }
}

class ItemActor extends AppActor {
  def receive: Receive = {
    case AddItem(itemId) => logger.info(s"Adding $itemId")
    case RemoveItem(itemId) => logger.info(s"Removing $itemId")
    case _ => logger.error("Invalid input provided")
  }
}
