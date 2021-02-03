package route

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._ // enables "put"

trait AppRoutes {
  def route: Route = {
    put {
      path("/item" / Segment) { itemId =>
        complete(StatusCodes.OK, s"itemId $itemId received")
      }
    }
  }
}
