package cn.egg
package actor

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext. Implicits.global

object Futures1 extends App {
  implicit val baseTime = System.currentTimeMillis

  val f = Future {
    Thread.sleep(500)
    1 + 1
  }

  val result = Await.result(f, Duration(1, TimeUnit.SECONDS))
  println(result)

  Thread.sleep(1000)

}
