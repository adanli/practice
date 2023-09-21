package cn.egg
package actor

import akka.actor.{Actor, ActorRef, ActorSystem, Props}

private object StartMessage
private object PingMessage
private object PongMessage

object PingPongTest {
  var count = 0

  def increment(): Unit = {
    count += 1
  }

  def main(args: Array[String]): Unit = {
    val topActor = ActorSystem("Top-Actor")

    val pongActor = topActor.actorOf(Props(new PongActor(name = "pong-actor")))
    val pingActor = topActor.actorOf(Props(new PingActor("ping-actor", pongActor)))

    pingActor ! StartMessage

    topActor.terminate()
  }


  class PongActor(name: String) extends Actor {
    override def receive: Receive = {
      case PingMessage => {
        if(count == 99) {
          println("end")
        } else {
          increment()
          println(s"$name-$count pong")
          sender ! PongMessage
        }
      }
      case _ => println("error")
    }
  }

  class PingActor(name: String, pongActor: ActorRef) extends Actor {
    override def receive: Receive = {
      case PongMessage => {
        increment()
        println(s"$name-$count ping")
        pongActor ! PingMessage
      }
      case StartMessage => {
        increment()
        println(s"$name-$count start")
        pongActor ! PingMessage
      }
      case _ => println("error")
    }
  }

}
