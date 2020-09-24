package com.bigdata.etl

import java.sql.DriverManager
import java.util.Properties

import org.apache.spark.sql.SparkSession

object ProviceCityCT {
  def main(args: Array[String]): Unit = {
    val sc = SparkSession.builder().appName("ProviceCityCT").master("local[*]").getOrCreate()
    val df = sc.read.load("output\\part-.gz.parquet")
    val resDF = df.groupBy("provincename", "cityname").count()
    val properties = new Properties()
    properties.setProperty("user","root")
    properties.setProperty("password","cyh121598")
    resDF.write.jdbc("jdbc:mysql://localhost:3306/test","test",properties)
    resDF.coalesce(1).write.partitionBy("provincename", "cityname").json("opt")
  }
}
