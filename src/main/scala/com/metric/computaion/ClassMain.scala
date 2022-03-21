package com.metric.computaion

import org.apache.spark.sql.{SQLContext, SparkSession}
import org.apache.spark.{SparkConf, SparkContext}


object ClassMain {

  def main(args: Array[String]): Unit = {

    //Create SparkConfig object
    val conf  = new SparkConf().setAppName("First App salima").setMaster("local")

    //Create thr SparckContext to the initialize Spark
    val sc = new SparkContext(conf)

    //Connection with mysql database
    val sqlcontext = new SQLContext(sc)
    val url = "jdbc:mysql://localhost:3306/dbDeequTest";
    val drive = "com.mysql.jdbc.Driver"
    val dbtable = "users"
    val user = "root"
    val password =""
    val userSSL = "false"
    val datasource = dbConnection.connection(sqlcontext,url, drive, dbtable, user, password, userSSL)
    datasource.printSchema()

    //Spark session
    val spark = SparkSession.builder().appName("metric computaion").getOrCreate()

    //Get Analyzers infos
    val df = sqlcontext.read.option("multiline","true").json("src/main/resources/need.json")
    df.show()

    //Metric-computation
    val metrics = MetricComputation.CalculateMetric(spark, datasource, df)
     metrics.show(truncate=false)
  }
}
