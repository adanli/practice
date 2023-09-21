package cn.egg

object AboutFunctionProgram {

  def main(args: Array[String]): Unit = {
//    executeFunction(sayHello, "aaa")
    execute(plusOne)
    execute(plusTen)

    // 加法
    executeAndPrint((x: Int, y: Int) => x + y, 1, 2)
    // 乘法
    executeAndPrint((x: Int, y: Int) => x * y, 1, 2)

    executeAndPrint(add, 3, 5)


    // 闭包
    var hello = "Hello"
    def sayHello(name: String) = println(s"$hello, $name")

    val foo = new otherscope.Foo
    foo.exec(sayHello, "Al")

    hello = "Hola"
    foo.exec(sayHello, "Lorenzo")

//    println(isVotingAge(20))
//    println(isVotingAge(15))

    var votingAge = 18
    def isVotingAge(age: Int) = {
      println(s"source: $age dest: $votingAge result: ${age >= votingAge}")
      age >= votingAge
    }

    println(getResult(isVotingAge, 20))
    println(getResult(isVotingAge, 15))

    votingAge = 12
    println(getResult(isVotingAge, 20))
    println(getResult(isVotingAge, 15))

    // 加法
    val sum = (a:Int, b:Int, c:Int) => a + b + c
    val f = sum(1, 2, _)
    println(f(3))

    val sayHi = saySomething("Hi")
    println(sayHi("zhangsan"))

    println(greeting("english")("张三"))


    val divide = new PartialFunction[Int, Int] {
      override def isDefinedAt(x: Int): Boolean = x != 0

      override def apply(v1: Int): Int = 42 / v1
    }

    println(divide(20))
    println(divide(10))
    println(divide.isDefinedAt(0))
    println(if(divide.isDefinedAt(0)) divide(0) else 0)

    // orElse
    val convert1to5 = new PartialFunction[Int, String] {
      override def isDefinedAt(x: Int): Boolean = x>=1 && x<=5

      override def apply(v1: Int): String = {
        List("one", "two", "three", "four", "five")(v1)
      }
    }
    val convert6to10 = new PartialFunction[Int, String] {
      override def isDefinedAt(x: Int): Boolean = x >= 6 && x <= 10

      override def apply(v1: Int): String = {
        List("six", "seven", "eight", "nine", "ten")(v1-6)
      }
    }

    val convert1to10 = convert1to5 orElse convert6to10
    println(convert1to10(4))
    println(convert1to10(8))

  }

//  val sayHello = (x: Any) => {println(s"hello world $x")}
  val plusOne = (x: Int) => println(x + 1)
  val plusTen = (x: Int) => println(x + 10)

  def executeFunction(callback: String => Unit, str: String) {
    callback(str)
  }

  def execute(callback: Int => Unit) {
    callback(1)
  }

  /*下⾯的exec⽅法接受⼀个输入参数为String、Int和Double型的函数，返回Seq[String]*/
  def exec(callback: (String, Int, Double) => Seq[String]): Unit = {

  }

  def executeAndPrint(calculate:(Int, Int)=>Int, x: Int, y:Int) {
    val result = calculate(x, y)
    println(result)
  }

  def add(x: Int, y: Int): Int = {
    x + y
  }

  private def getResult(f: Int => Boolean, x: Int): Boolean = {
    f(x)
  }

  def saySomething(prefix: String) = (s: String) => {
    s"$prefix $s"
  }

  def greeting(language: String) = (name: String) => {
    language match {
      case "english" => s"hello $name"
      case "china" => s"你好 $name"
      case _ => "error type"
    }
  }

}
