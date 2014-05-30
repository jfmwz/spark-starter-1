import AssemblyKeys._ // put this at the top of the file

name:="spark-starter-1"

scalaVersion :="2.10.1"

version :="0.1"

resolvers ++= Seq(
  "Akka Repository" at "http://repo.akka.io/releases/",
  "Spray Repository" at "http://repo.spray.cc/",
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases" at "http://oss.sonatype.org/content/repositories/releases"
  )

libraryDependencies ++= {
  Seq(
    "org.scalatest" %% "scalatest" % "1.9.1" % "test",
    "org.apache.spark" %% "spark-core" % "1.0.0" % "provided"
  )
}

runMain in Compile <<= Defaults.runMainTask(fullClasspath in Compile, runner in (Compile, run))

run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))

assemblySettings

assembleArtifact in packageScala := false

test in assembly := {}
