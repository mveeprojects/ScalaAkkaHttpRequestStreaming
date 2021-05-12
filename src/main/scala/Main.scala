import akka.http.scaladsl.Http
import com.typesafe.scalalogging.LazyLogging
import config.AppConfig._
import config.AppConfig.appConfig.http._
import route.AppRoutes

import scala.util.{Failure, Success}

object Main extends App with AppRoutes with LazyLogging {
  Http()
    .newServerAt(host, port)
    .bindFlow(route)
    .onComplete {
      case Success(_)  => logger.info(s"App running ($host:$port)")
      case Failure(ex) => logger.error(s"App failed to start:\n${ex.getMessage}")
    }
}
