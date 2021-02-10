package route

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import service.ItemService._

trait AppRoutes {
  def route: Route =
    concat(
      put {
        path("hello" / Segment) { msg =>
          hello(msg)
          complete(StatusCodes.OK)
        }
      },
      path("item" / Segment) { itemId =>
        concat(
          put {
            addItem(itemId)
            complete(StatusCodes.Created, s"itemId $itemId added")
          },
          delete {
            removeItem(itemId)
            complete(StatusCodes.NoContent, s"itemId $itemId removed")
          }
        )
      }
    )
}
