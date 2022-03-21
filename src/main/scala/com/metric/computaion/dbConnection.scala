package com.metric.computaion

import org.apache.spark.SparkContext
import org.apache.spark.sql.{DataFrame, SQLContext}

object dbConnection {

  //Connection with mysql database
  def connection (sqlcontext: SQLContext, url:String, drive:String, dbtable: String, user: String, password: String, userSSL: String) : DataFrame = {
    val datasource = { sqlcontext.read.format("jdbc")
      .option("url", url)
      .option("driver", drive)
      .option("dbtable", dbtable)
      .option("user", user)
      .option("password", password)
      .option("useSSL", userSSL)
      .load()
    }
    return datasource
  }

}
