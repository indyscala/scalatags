
lazy val commonSettings = Seq(
  organization := "org.indyscala.scalatags",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.4",

  homepage := Some(url("https://github.com/indyscala/scalatags")),
  licenses := Seq(
    "MIT" -> url("http://opensource.org/licenses/MIT")
  ),

  libraryDependencies += "com.lihaoyi" %% "scalatags" % "0.6.7"
)

lazy val basics = (project in file("basics"))
  .settings(
    commonSettings,
  )

lazy val site = (project in file("site"))
  .enablePlugins(HepekPlugin)
  .settings(
    commonSettings,
  )

lazy val `scalatags-demo` = (project in file("."))
  .aggregate(basics, site)
