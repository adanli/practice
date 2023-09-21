package cn.egg
package web.json

import com.google.gson.Gson


object GsonTest extends App {

  val p = Person(name = "zhangsan", address = Address(city = "hangzhou", state = "zhejiang"))

  val gson = new Gson
  println(gson.toJson(p))

  case class Address(city: String, state: String)
  case class Person(name: String, address: Address)
}
