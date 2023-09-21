package cn.egg
package actor

import akka.actor.{Actor, ActorSystem, Props}

case object ActNormalMessage
case object TryToFindSolution
case object BadGuysMakeMeAngry

object BecomeHulkExample extends App {

  val system = ActorSystem("BecomeHulk")
  val davidBanner = system.actorOf(Props[DavidBanner], "david-banner")
  davidBanner ! ActNormalMessage
  davidBanner ! TryToFindSolution
  davidBanner ! BadGuysMakeMeAngry

  Thread.sleep(1000)
  davidBanner ! ActNormalMessage

  Thread.sleep(1000)
  system.terminate()


  class DavidBanner extends Actor {
    import context._

    def angryState: Receive = {
      case ActNormalMessage => {
        println("act normal message")
        become(normalState)
      }
    }

    def normalState: Receive = {
      case TryToFindSolution => {
        println("try to find solution")
      }
      case BadGuysMakeMeAngry => {
        println("bad guy make me angry")
        become(angryState)
      }
    }

    override def receive: Receive = {
      case BadGuysMakeMeAngry => become(angryState)
      case ActNormalMessage => become(normalState)
    }
  }

}
