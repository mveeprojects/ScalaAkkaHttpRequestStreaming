package service

import config.AppConfig._
import model.{AddItem, RemoveItem}
import utils.Logging

object ItemService extends Logging {

  def addItem(itemId: String): Unit = itemActor ! AddItem(itemId)

  def removeItem(itemId: String): Unit = itemActor ! RemoveItem(itemId)
}
