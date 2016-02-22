package client.Definition

import java.util.Random

/**
  * Created by beir on 2/19/16.
  */
class RandomData(numOfAttributes: Int, numOfTuples: Int) {
  private[this] var currentTuple = 0
  private[this] val rand = new Random(System.currentTimeMillis());
  val isNoData = if (numOfTuples > currentTuple) true else false

  def getRecords(numberOfRecords: Int): Array[Array[Double]] = {
    def getArray(): Array[Array[Double]] = {
      if (numOfTuples < currentTuple + numberOfRecords) {
        var output = Array.ofDim[Double](numberOfRecords + currentTuple - numOfTuples, numOfAttributes)
        output
      } else {
        var output = Array.ofDim[Double](numberOfRecords, numOfAttributes)
        output
      }
    }
    
    var output = getArray()
    
    for (i <- 0 until numberOfRecords) {
      val period = rand.nextDouble() / 1
      for (j <- 0 until numOfAttributes)
        output(i)(j) = period + j
    }
    currentTuple += numberOfRecords
    output
  }
}
