import sbtrelease.ReleasePlugin._

name := "prequel"

organization := "com.gu"

scalaVersion := "2.10.4"

releaseSettings

ReleaseKeys.crossBuild := true


crossScalaVersions := Seq("2.9.2", "2.10.0")

// Runtime Dependencies
libraryDependencies ++= Seq(
    "commons-pool" % "commons-pool" % "1.5.5",
    "commons-dbcp" % "commons-dbcp" % "1.4",
    "commons-lang" % "commons-lang" % "2.6",
    "joda-time" % "joda-time" % "2.1",
    "org.joda" % "joda-convert" % "1.2"
)

// Test Dependencies
libraryDependencies ++= Seq(
    "org.hsqldb" % "hsqldb" % "2.2.4" % "test",
    "org.scalatest" %% "scalatest" % "1.9.1" % "test"
)

parallelExecution in Test := false

// Release publishing stuff

publishTo := Some( "Sonatype Staging Nexus" at "https://oss.sonatype.org/service/local/staging/deploy/maven2" )

pomIncludeRepository := { _ => false }

publishMavenStyle := true

credentials += Credentials( Path.userHome / ".ivy2" / ".credentials" )

pomExtra := (
  <url>http://github.com/james-rodgers/prequel</url>
  <licenses>
    <license>
      <name>wtfpl</name>
      <url>http://www.wtfpl.net/txt/copying/</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/james-rodgers/prequel.git</url>
    <connection>scm:git:https://github.com/james-rodgers/prequel.git</connection>
  </scm>
  <developers>
    <developer>
      <id>james-rodgers</id>
      <name>James Rodgers</name>
      <url>http://github.com/james-rodgers</url>
    </developer>
  </developers>
)
