package cn.egg

object Main {

  def main(args: Array[String]): Unit = {
    println("Hello world!")

    val hello = "hello world!"
    println(hello)

    Array(1, 2, 3).filter(_ != 2).foreach(println(_))

    val str: String =
      """today is
        |a good
        |day""".stripMargin.replaceAll("\n", " ")
    println(str)

    str.split(' ').foreach(println)

    val name = "aaa"
    println(s"his name is ${name.length} characters long\n")

    println(f"his name is $name%s, ${name.length}%d characters long\n")

    println("Hello World".map(_.toUpper))

    for(c <- "Hello World") println(c.toUpper)

    for(c <- "Hello World") yield println(c.toUpper)

    val result = for(c <- "Hello World" if c!='e') yield c.toUpper
    println(result.map(_.toLower))

    val result2 = for {
      c <- "Hello World"
      if c!='l'
    } yield c.toUpper
    println(result2.map(_.toLower))

    println("HELLO".map(toLowerCase))

  }

  private def toLowerCase(c: Char): Char = {
    (c.toByte + 32).toChar
  }


}