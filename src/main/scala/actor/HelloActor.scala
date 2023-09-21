package cn.egg
package actor

import akka.actor.Actor

class HelloActor(name: String) extends Actor{
  def this() {
    this(null)
  }

  override def receive: Receive = {
    case "hello" => println(s"hello back at you, from $name")
    case _ => println(s"huh?, from $name")
  }
}
