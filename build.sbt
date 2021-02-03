import Dependencies._

name := "ScalaAkkaHttpRequestStreaming"

version := "0.1"

scalaVersion := "2.13.4"

lazy val root: Project = (project in file("."))
  .settings(appDeps: _*)
