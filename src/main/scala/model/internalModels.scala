package model

trait ItemAction
case class AddItem(itemId: String) extends ItemAction
case class RemoveItem(itemId: String) extends ItemAction