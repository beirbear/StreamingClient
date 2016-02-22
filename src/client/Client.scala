package client

import client.Definition.RandomData

/**
  * Created by beir on 2/19/16.
  */
object Client {
  def main(args: Array[String]): Unit = {
    // Read data source
    val tmp = ReadDataSource.getData(50)
    while(!ReadDataSource.isNoData) {
      val tmp = ReadDataSource.getData(5000)
    }
    println(tmp(0).mkString(" "))
  }
}
