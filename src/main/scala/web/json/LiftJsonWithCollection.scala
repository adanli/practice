package cn.egg
package web.json

import net.liftweb.json.{DefaultFormats, JsonAST, compactRender, prettyRender}
import net.liftweb.json.JsonDSL._
import net.liftweb.json.Serialization.write

object LiftJsonWithCollection extends App {

  val json = List(1, 2, 3)
  println(write(json)(DefaultFormats))
  println(compactRender(JsonAST.render(json).value))
  println(prettyRender(JsonAST.render(json).value))

  val map = Map("first-name" -> "zhang", "last-name" -> "san")
  println(write(map)(DefaultFormats))
  println(compactRender(JsonAST.render(map).value))
  println(prettyRender(JsonAST.render(map).value))

}
