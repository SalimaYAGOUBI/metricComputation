package com.metric.computaion

import com.amazon.deequ.analyzers.runners.{AnalysisRunner, AnalyzerContext}
import com.amazon.deequ.analyzers.runners.AnalyzerContext.successMetricsAsDataFrame
import com.amazon.deequ.analyzers.{ApproxCountDistinct, Completeness, Correlation, Mean, Size}
import com.amazon.deequ.metrics.Entity.Dataset
import org.apache.spark.sql.execution.datasources.DataSource
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.{DataFrame, SparkSession}

object MetricComputation {

  def CalculateMetric(spark: SparkSession, datasource: DataFrame, analyers: DataFrame): DataFrame = {
    //Metric-computation
    val analysisResult: AnalyzerContext = { AnalysisRunner
      // data to run the analysis on
      .onData(datasource)
      // define analyzers that compute metrics
      .addAnalyzer(Size())
      .addAnalyzer(Completeness("id_user"))
      .addAnalyzer(Completeness("name_user"))
      .addAnalyzer(ApproxCountDistinct("profile_user"))
      .addAnalyzer(Mean("age_user"))
      .addAnalyzer(Correlation("age_user", "profile_user"))
      // compute metrics
      .run()
    }


    // retrieve successfully computed metrics as a Spark data frame
    val metrics = successMetricsAsDataFrame(spark,analysisResult)
    return metrics
  }


}
