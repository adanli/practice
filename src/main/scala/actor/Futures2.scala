package cn.egg
package actor

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success

object Futures2 extends App {
  implicit val baseTime = System.currentTimeMillis

  def longRunningComputation(i: Int): Future[Int] = Future{
    Thread.sleep(100)
    i+1
  }

  longRunningComputation(11).onComplete{
    case Success(value) => println(s"Got the callback, meaning = $value")
    case _ => println("error")
  }

  Thread.sleep(1000)


}
