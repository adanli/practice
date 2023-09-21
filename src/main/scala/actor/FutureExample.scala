package cn.egg
package actor


import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Random, Success, Failure}

object FutureExample extends App {

  val f = Future {
    Thread.sleep(Random.nextInt(500))
    42
  }

  println("before execute")
  f.onComplete {
    case Success(value) => println(s"execute success $value")
    case Failure(exception) => exception.printStackTrace()
  }

  println("A ..."); Thread.sleep(100)
  println("B ..."); Thread.sleep(100)
  println("C ..."); Thread.sleep(100)
  println("D ..."); Thread.sleep(100)
  println("E ..."); Thread.sleep(100)
  println("F ..."); Thread.sleep(100)
  println("G ..."); Thread.sleep(100)

  Thread.sleep(2000)

}
