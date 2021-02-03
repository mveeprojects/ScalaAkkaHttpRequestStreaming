import sbt.Keys.libraryDependencies
import sbt._

object Dependencies {
  lazy val akkaVersion         = "2.6.12"
  lazy val akkaHttpVersion     = "10.2.3"
  lazy val scalaLoggingVersion = "3.9.2"
  lazy val logbackVersion      = "1.2.3"
  lazy val scalaTestVersion    = "3.2.3"
  lazy val sprayJsonVersion    = "1.3.6"
  lazy val PureConfigVersion   = "0.14.0"

  val appDeps: Def.Setting[Seq[ModuleID]] = libraryDependencies ++= Seq(
    "com.typesafe.akka"          %% "akka-actor"           % akkaVersion,
    "com.typesafe.akka"          %% "akka-stream"          % akkaVersion,
    "com.typesafe.akka"          %% "akka-http"            % akkaHttpVersion,
    "com.typesafe.scala-logging" %% "scala-logging"        % scalaLoggingVersion,
    "ch.qos.logback"              % "logback-classic"      % logbackVersion,
    "com.typesafe.akka"          %% "akka-http-spray-json" % akkaHttpVersion,
    "com.typesafe.akka"          %% "akka-http-testkit"    % akkaHttpVersion,
    "com.typesafe.akka"          %% "akka-stream-testkit"  % akkaVersion,
    "io.spray"                   %% "spray-json"           % sprayJsonVersion,
    "com.github.pureconfig"      %% "pureconfig"           % PureConfigVersion
  )
}
