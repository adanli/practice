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
    println(s"his name is ${name.length} characters long")

  }
}