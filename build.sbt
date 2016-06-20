name := "hadoop4s"

organization := "io.harkema"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "com.twitter" % "scalding-core_2.11" % "0.16.0"
libraryDependencies += "com.twitter" % "scalding-args_2.11" % "0.16.0"
libraryDependencies += "com.twitter" % "scalding-date_2.11" % "0.16.0"
libraryDependencies += "com.twitter" % "scalding-commons_2.11" % "0.16.0"
libraryDependencies += "com.twitter" % "scalding-avro_2.11" % "0.16.0"
libraryDependencies += "com.twitter" % "scalding-repl_2.11" % "0.16.0"
libraryDependencies += "com.twitter" % "scalding-parquet_2.11" % "0.16.0"
libraryDependencies += "org.apache.hadoop" % "hadoop-main" % "2.7.2"
libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.7.2"

resolvers ++= Seq(
  "Local Maven Repository" at "file://" + Path.userHome.absolutePath + "/.m2/repository",
  "maven central" at "https://repo.maven.apache.org/maven2",
  "releases" at "https://oss.sonatype.org/content/repositories/releases",
  "snapshots" at "https://oss.sonatype.org/content/repositories/snapshots",
  "Concurrent Maven Repo" at "http://conjars.org/repo",
  "Twitter Maven" at "http://maven.twttr.com",
  "Cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"
)

mainClass in assembly := Some("Runner")
mainClass := Some("Runner")

scalacOptions += "-target:jvm-1.7"
javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

mergeStrategy in assembly <<= (mergeStrategy in assembly) {
  (old) => {
    case s if s.endsWith(".class") => MergeStrategy.last
    case s if s.endsWith("project.clj") => MergeStrategy.concat
    case s if s.endsWith(".html") => MergeStrategy.last
    case s if s.endsWith(".dtd") => MergeStrategy.last
    case s if s.endsWith(".xsd") => MergeStrategy.last
    case s if s.endsWith("pom.properties") => MergeStrategy.last
    case s if s.endsWith("pom.xml") => MergeStrategy.last
    case s if s.endsWith(".jnilib") => MergeStrategy.rename
    case s if s.endsWith("jansi.dll") => MergeStrategy.rename
    case s if s.endsWith("properties") => MergeStrategy.filterDistinctLines
    case x => old(x)
  }
}