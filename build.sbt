name := "zio-playground"

version := "0.1"

lazy val zioVersion    = "1.0.12"

scalaVersion := "2.13.7"
libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % zioVersion
)