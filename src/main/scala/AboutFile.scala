package cn.egg

object AboutFile {
  def main(args: Array[String]): Unit = {
    val file = scala.io.Source.fromFile("/Users/adan/code/egg/practice/src/main/scala/AboutFile.scala")
    for (line <- file.getLines()) {
      println(line)
    }
    file.close()

    import sys.process._

    val result = "ls -la"
    println(result.!!)

  }

}
