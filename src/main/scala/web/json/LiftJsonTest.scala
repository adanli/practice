package cn.egg
package web.json

import net.liftweb.json.DefaultFormats
import net.liftweb.json.Serialization.write




object LiftJsonTest extends App {

  val p = Person(name = "zhangsan", address = Address(city = "hangzhou", state = "zhejiang"))

  val jsonString = write(p)(DefaultFormats)
  println(jsonString)


  case class Address(city: String, state: String)
  case class Person(name: String, address: Address)
}
