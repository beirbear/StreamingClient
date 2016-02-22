package client

import client.Definition.AttributeProperties
import client.Definition.DataProperty
import client.Definition.TestConfiguration
import client.Definition.RandomData

object ReadDataSource {
  private[this] val numOfAttributes = TestConfiguration.NUM_OF_ATTRIBUTE
  private[this] val numOfRecords = TestConfiguration.NUM_OF_RECORDS
  private[this] val randData = new RandomData(numOfAttributes, numOfRecords)
  private[this] var dataTimeStamp = System.currentTimeMillis()
  
  val isNoData = randData.isNoData
  
  def getHeaders(): Array[AttributeProperties] = {
    val header = new Array[AttributeProperties](numOfAttributes)
    import client.Definition.DataProperty._
    for (i <- 0 until numOfAttributes)
      header(i) = AttributeProperties("Column " + i, 0.0.getClass, Numerical, "Sample Data" + 1)

      header
  }
  
  def getData(numOfRecords: Int): Array[Array[Double]] = {
    val res = randData.getRecords(numOfRecords)
    dataTimeStamp = System.currentTimeMillis()
    
    res
  }
}