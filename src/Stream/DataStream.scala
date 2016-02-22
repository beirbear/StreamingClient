package Stream

import java.io._
import java.net.{InetAddress,ServerSocket,Socket}
import java.nio.ByteBuffer
import java.io.BufferedOutputStream

class DataStream(destAddress: String, destPort: Int) {
  val socket = new Socket(destAddress, destPort)
  val out = new ObjectOutputStream(socket.getOutputStream())
  val out1 = new BufferOutputStream(socket.getOutputStream())
  
  // Intend to make a dedicate one way connection
  // val in = new DataInputStream(socket.getInputStream())
  
  def sendHeader(input: Any): Unit = {
    out.write(input)
    out.flush
  }
  
  def sendData(input: ByteBuffer): Unit = {
    out.write(ByteBuffer)
  }
}