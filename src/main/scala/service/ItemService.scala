package service

import config.AppConfig._
import model.{AddItem, Hello, RemoveItem}
import utils.Logging

object ItemService extends Logging {

  def hello(msg: String): Unit = helloActor ! Hello(msg)

  def addItem(itemId: String): Unit = itemActor ! AddItem(itemId)

  def removeItem(itemId: String): Unit = itemActor ! RemoveItem(itemId)
}
