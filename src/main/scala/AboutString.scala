package cn.egg

/**
 * 字符串
 */
object AboutString {

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

    val numPattern = "[0-9]+".r
    val address = "湖墅南路505号中华保险大厦9楼"
    println(numPattern.findFirstIn(address))
    numPattern.findAllIn(address).foreach(println)

    println(address.replaceAll("[0-9]", "x"))

    val addressDetailPattern = "\\S+([0-9]+)\\S+([0-9]+)\\S+".r
    val addressDetailPattern(num, floor) = address
    println(s"num: $num, floor: $floor")

    println("HAL".increment)
    println(123.increment)

  }

  private def toLowerCase(c: Char): Char = {
    (c.toByte + 32).toChar
  }

  implicit class SpringImprovements(val s: String) {
    def increment = s.map(c => (c.toByte + 1).toChar)
  }

  implicit class IntImprovements(val i: Int) {
    def increment = i + 1
  }

}