package config

import actors.ItemActor
import akka.actor.{ActorRef, ActorSystem, Props}

import scala.concurrent.ExecutionContext

trait ActorSystemConf {
  implicit val system: ActorSystem        = ActorSystem("my-actor-system")
  implicit val executor: ExecutionContext = system.dispatcher

  val itemActor: ActorRef = system.actorOf(Props[ItemActor], name = "item-actor")
}
