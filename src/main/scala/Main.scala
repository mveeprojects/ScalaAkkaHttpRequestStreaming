import akka.http.scaladsl.Http
import com.typesafe.scalalogging.LazyLogging
import config.AppConfig._
import route.AppRoutes

import scala.util.{Failure, Success}

object Main extends App with AppRoutes with LazyLogging {
  Http().newServerAt(config.http.host, config.http.port)
    .bindFlow(route)
    .onComplete{
      case Success(_) => logger.info(s"App running (${config.http.host}:${config.http.port})")
      case Failure(ex) => logger.error(s"App failed to start:\n${ex.getMessage}")
    }
}
