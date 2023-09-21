package cn.egg
package actor



import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Cloud {

  def runAlgorithm(i: Int): Future[Int] = Future{
    Thread.sleep(100)
    val result = i+10
    println(s"returning result from cloud: $result")
    result
  }
}
