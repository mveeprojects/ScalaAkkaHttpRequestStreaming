package config

import pureconfig.ConfigSource
import pureconfig.generic.auto._

import scala.concurrent.duration.FiniteDuration

object AppConfig extends ActorSystemConf {
  case class HttpConfig(host: String, port: Int)
  case class StreamConfig(bufferSize: Int, elementsToProcess: Int, interval: FiniteDuration)
  case class AppConfig(http: HttpConfig, stream: StreamConfig)
  val appConfig: AppConfig = ConfigSource.default.loadOrThrow[AppConfig]
}
