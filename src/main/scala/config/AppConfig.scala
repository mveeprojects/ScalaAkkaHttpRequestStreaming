package config

import pureconfig.ConfigSource
import pureconfig.generic.auto._

object AppConfig extends ActorSystemConf {
  case class HttpConfig(host: String, port: Int)
  case class AppConfig(http: HttpConfig)
  val config: AppConfig = ConfigSource.default.loadOrThrow[AppConfig]
}
