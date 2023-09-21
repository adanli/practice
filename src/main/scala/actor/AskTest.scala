package cn.egg
package actor

import akka.actor.{Actor, ActorSystem, Props}
import akka.util.Timeout
import akka.actor._
import akka.pattern.ask

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.language.postfixOps

case object AskNameMessage

object AskTest extends App {
  val topActor = ActorSystem("top-actor")
  val testActor = topActor.actorOf(Props[TestActor], "test-actor")

  implicit val timeout = Timeout(50 seconds)
  val future = testActor ? AskNameMessage
  val result = Await.result(future, timeout.duration).asInstanceOf[String]
  println(result)


  val future2: Future[String] = ask(testActor, AskNameMessage).mapTo[String]
  val result2 = Await.result(future2, 1 second)
  println(result2)


  topActor.terminate()


  class TestActor extends Actor {
    override def receive: Receive = {
      case AskNameMessage => {
        println("receive message")
        Thread.sleep(5000)
        sender ! "Fred"
      }
      case _ => "error"

    }
  }

}
