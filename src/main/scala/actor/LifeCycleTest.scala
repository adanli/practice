package cn.egg
package actor

import akka.actor.{Actor, ActorSystem, Kill, PoisonPill, Props}

private object BoomMessage
private object OtherMessage

object LifeCycleTest {
  def main(args: Array[String]): Unit = {
    val actor = ActorSystem("top-actor")

    val lifeCycleActor = actor.actorOf(Props[LifeCycleActor], "lifeCycleActor")

    lifeCycleActor ! "hello"
    Thread.sleep(1000)

    lifeCycleActor ! "hi"
    Thread.sleep(1000)

//    lifeCycleActor ! PoisonPill
    lifeCycleActor ! Kill

    lifeCycleActor ! OtherMessage
    Thread.sleep(1000)

    lifeCycleActor ! BoomMessage
    Thread.sleep(1000)

    actor.stop(lifeCycleActor)
    Thread.sleep(1000)

    actor.terminate()

  }


  class LifeCycleActor extends Actor {
    override def receive: Receive = {
      case BoomMessage => throw new Exception("boom!")
      case OtherMessage => println("some message")
      case msg: AnyRef => println(s"Got a message: $msg")
    }

    override def preStart(): Unit = {
      println("preStart in LifeCycleActor")
      super.preStart()
    }

    override def postStop(): Unit = {
      println("postStop in LifeCycleActor")
      super.postStop()
    }

    override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
      println("preRestart in LifeCycleActor")
      println(s"  reason: $reason")
      println(s"  message: $message")
      super.preRestart(reason, message)
    }

    override def postRestart(reason: Throwable): Unit = {
      println("postRestart in LifeCycleActor")
      println(s"  reason: $reason")
      super.postRestart(reason)
    }
  }

}
