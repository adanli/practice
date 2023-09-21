package cn.egg
package actor

import akka.actor.{ActorSystem, Props}

object AboutActor {
  def main(args: Array[String]): Unit = {
    val system = ActorSystem("HelloSystem")

    // create and start actor
    val helloActor = system.actorOf(Props(new HelloActor("hello-actor")), "hello-actor")
    val helloActorWithoutConstruct = system.actorOf(Props(new HelloActor("")), "hello-actor-without-construct")

    // send actor two messages
    helloActor ! "hello"
    helloActor ! "hi"

    helloActorWithoutConstruct ! "hello"
    helloActorWithoutConstruct ! "hi"

    system.terminate()
  }

}
