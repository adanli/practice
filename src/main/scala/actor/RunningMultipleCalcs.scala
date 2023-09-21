package cn.egg
package actor

import scala.util.Success
import scala.concurrent.ExecutionContext.Implicits.global

object RunningMultipleCalcs extends App {
  println("starting futures")

  val result1 = Cloud.runAlgorithm(10)
  val result2 = Cloud.runAlgorithm(20)
  val result3 = Cloud.runAlgorithm(30)

  println("before for-comprehension")
  val result = for {
    r1 <- result1
    r2 <- result2
    r3 <- result3
  } yield (r1 + r2 + r3)

  println("before onSuccess")
  result.onComplete {
    case Success(value) => println(s"total = $value")
    case _ => "error"
  }

  println("before sleep at the end")
  Thread.sleep(2000)

}
