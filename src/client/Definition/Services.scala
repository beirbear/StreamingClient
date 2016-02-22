package client.Definition

import scala.collection.mutable.ArrayBuffer
import java.nio.ByteBuffer

object Services {
  def wrapObject(timeStamp: Long, attrIndex: Int, data: Array[Double]): ByteBuffer = {
    def getSize(dataClass: Any): Int = {
      dataClass match {                                 
      case l: Long => TestConfiguration.SIZE_LONG
      case i: Int => TestConfiguration.SIZE_INT
      case d: Double => TestConfiguration.SIZE_DOUBLE       
      case _ => throw new Exception("havn't implemented yet!");
      }   
    }
    
    val capacity = getSize(timeStamp) + getSize(attrIndex) + getSize(data(0)) * data.length
    
    var dataBuffer = ByteBuffer.allocate(capacity)
    dataBuffer.putLong(timeStamp)
    dataBuffer.putInt(attrIndex)
    dataBuffer.put(data.map(_.toByte))
    
    dataBuffer
  }
}