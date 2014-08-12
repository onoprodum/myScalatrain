import sbt._

class ScalaTrainProject(info: ProjectInfo) extends DefaultProject(info) {
  val mockito = "org.mockito" % "mockito-all" % "1.8.5" % "test"
  val specs = "org.scala-tools.testing" %% "specs" % "1.6.7" % "test" withSources
}