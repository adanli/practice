package cn.egg
package web.json

import net.liftweb.json.{DefaultFormats, parse}

case class MailServer(url: String, username: String, password: String)

case class PersonInfo(name: String, age: Int, mails: List[MailServer])

object JsonParsingExample extends App {
  implicit val formats = DefaultFormats
  val jsonString =
    """
      |{
      | "url": "imap.gmail.com",
      | "username": "adan@gmail.com",
      | "password": "123456"
      |}
      |""".stripMargin

  val jValue = parse(jsonString)

  val mailServer = jValue.extract[MailServer]
  println(mailServer.url)
  println(mailServer.username)
  println(mailServer.password)

  val personInfoStr =
    """
      |{
      | "name": "Adan",
      | "age": 24,
      | "mails": [
      |   {
      |     "url": "imap.gmail.com",
      |      "username": "adan@gmail.com",
      |      "password": "123456"
      |   }, {
      |     "url": "126.com",
      |     "username": "adan@126.com",
      |     "password": "123456"
      |   }
      | ]
      |}
      |""".stripMargin

  val personInfo = parse(personInfoStr).extract[PersonInfo]
  println(personInfo.name)
  println(personInfo.age)
  println("person-info mails:")
  personInfo.mails.foreach { mail =>
    println(mail.url)
    println(mail.username)
    println(mail.password)
  }

}
