package route

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import service.ItemService._

trait AppRoutes {
  def route: Route =
    path("item" / Segment) { itemId =>
      concat(
        put {
          addItem(itemId) // calling the actorRef receive method essentially
          complete(StatusCodes.Created, s"itemId $itemId added")
        },
        delete {
          removeItem(itemId)
          complete(StatusCodes.NoContent)
        }
      )
    }
}
