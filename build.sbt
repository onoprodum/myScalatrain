name := "scalatrain"

version := "1.0"

scalaVersion := "2.11.1"

resolvers ++= Seq(
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases"
)

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.11.5" % "test"
)

libraryDependencies ++= Seq(
    "org.specs2" %% "specs2" % "2.4" % "test"
  )
