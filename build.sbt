name := "metrics-computation"

version := "0.1"

scalaVersion := "2.12.12"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.0.1"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.0.1"

// https://mvnrepository.com/artifact/mysql/mysql-connector-java
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"

// https://mvnrepository.com/artifact/com.amazon.deequ/deequ
libraryDependencies += ("com.amazon.deequ" % "deequ" % "1.1.0_spark-3.0-scala-2.12")
  .exclude("org.scalanlp", "breeze_2.11")
  .exclude("com.chuusai", "shapeless_2.11")
  .exclude("org.apache.spark", "spark-core_2.11")
  .exclude("org.apache.spark", "spark-sql_2.11")

// https://mvnrepository.com/artifact/net.liftweb/lift-json
/*libraryDependencies += "net.liftweb" %% "lift-json" % "3.5.0"

libraryDependencies += "com.lihaoyi" %% "upickle" % "0.9.5"

// https://mvnrepository.com/artifact/com.typesafe.play/play-json
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.10.0-RC6"

*/




