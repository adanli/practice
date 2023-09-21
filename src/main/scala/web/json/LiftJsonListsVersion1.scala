package cn.egg
package web.json

import net.liftweb.json.{DefaultFormats, JsonAST, compactRender}
import net.liftweb.json.JsonDSL._
import net.liftweb.json.Serialization.write

object LiftJsonListsVersion1 extends App {

  implicit val formats = DefaultFormats

  val zhangsan = Person("zhangsan", Address("hangzhou", "zhejiang"))
  zhangsan.friends = List(
    Person("123", Address("ningbo", "zhejiang")),
    Person("456", Address("huzhou", "zhejiang"))
  )

  println(write(zhangsan))

  val json =
    (
      "person" ->
        ("name" -> zhangsan.name) ~
        ("address" ->
          ("city" -> zhangsan.address.city) ~
          ("state" -> zhangsan.address.state)
        ) ~
        ("friends" ->
          (zhangsan.friends.map(friend => {
            ("name" -> friend.name) ~
            ("address" ->
              ("city" -> friend.address.city) ~
              ("state" -> friend.address.state)
            )
          }))
        )
    )
  println(JsonAST.compactRender(JsonAST.render(json).value))
  println(JsonAST.prettyRender(JsonAST.render(json).value))



  case class Address(city: String, state: String)
  case class Person(name: String, address: Address) {
    var friends = List[Person]()
  }

}
