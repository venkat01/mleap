import sbt._

object Dependencies {
  val sparkVersion = "2.0.0"

  lazy val baseDependencies = Seq("org.scalatest" %% "scalatest" % "3.0.0" % "test")

  lazy val sparkDependencies = Seq("org.apache.spark" %% "spark-core" % sparkVersion,
    "org.apache.spark" %% "spark-sql" % sparkVersion,
    "org.apache.spark" %% "spark-mllib" % sparkVersion,
    "org.apache.spark" %% "spark-catalyst" % sparkVersion).map(_ % "provided")

  lazy val mleapCoreDependencies = baseDependencies.union(Seq("org.apache.spark" %% "spark-mllib-local" % sparkVersion))

  lazy val mleapRuntimeDependencies = baseDependencies

  lazy val mleapSerializationDependencies = baseDependencies

  lazy val mleapSparkDependencies = baseDependencies
    .union(sparkDependencies)

  lazy val bundleMlDependencies = baseDependencies.
    union(Seq("io.spray" %% "spray-json" % "1.3.2",
      "com.jsuereth" %% "scala-arm" % "1.4"))
}