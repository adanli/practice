package cn.egg

import scala.Console.{println, withErr}
import scala.annotation.switch
import scala.util.control.Breaks
import scala.util.control.Breaks.{break, breakable}

/**
 * 流程控制
 */
object AboutControl {

  def main(args: Array[String]): Unit = {

    for {
      x <- 1 to 10
      y <- 1 to 10
    } yield println(s"x: $x, y: $y")

    val list = List(1,2,3,4,5)
    (for {
      x <- list.indices
    } yield list(x))
      .foreach(println)

    val map = Map(
      "zhangsan" -> 18,
      "lisi" -> 24,
      "wangwu" -> 16
    )
    for((k, v) <- map) yield println(s"key: $k, value: $v")

    val Outer = new Breaks

    // break
    println("----------break----------")
    Outer.breakable {
      for(e <- list) {
        if(e > 3) Outer.break
        println(e)
      }
    }

    // continue
    println("----------continue----------")
    for(e <- list) {
      breakable {
        if(e == 3) break
        println(e)
      }
    }

    // 三目
    (for(i <- List(1, 2, 3, 4, 5)) yield if(i%2==0) i else 0).foreach(i => print(s"$i "))
    println()


    // switch 月份
    (for(i <- 1 to 12) yield {
      (i: @switch) match {
        case 1 => "一月"
        case 2 => "二月"
        case 3 => "三月"
        case 4 => "四月"
        case 5 => "五月"
        case 6 => "六月"
        case 7 => "七月"
        case 8 => "八月"
        case 9 => "九月"
        case 10 => "十月"
        case 11 => "十一月"
        case 12 => "十二月"
        case _ => "未知月份"
      }
    }).foreach(println)

    println(getResult((1, 3)))
    println(getResult(5))
    println(getResult(Map("zhangsan"->"18", "lisi"->"24", "wangwu"->"15")))
    println(getResult(List(1,2,3,4,5)))

    toInt("42") match {
      case Some(i) => println(i)
      case None => println("wrong type")
    }

    println(matchLevel(5))
    println(matchLevel(15))
    println(matchLevel(25))
    println(matchLevel(35))
    println(matchLevel(45))
    println(matchLevel(55))

    println(listToString(List("a", "b", "c", "d", "c")))

    var i = 0;
    whilst(i < 5) {
      println(s"$i")
      i+=1
    }

  }

  private def listToString(list: List[String]): String = {
    list match {
      case s :: rest => s + " " + listToString(rest)
      case Nil => ""
    }
  }

  def matchLevel(i: Int) = {
    i match {
      case a if 1 to 10 contains(a) => "level 1-10"
      case b if 11 to 20 contains(b) => "level 11-20"
      case c if 21 to 30 contains(c) => "level 21-30"
      case d if 31 to 40 contains(d) => "level 31-40"
      case e if 41 to 50 contains(e) => "level 41-50"
      case _ => "level > 50"
    }
  }

  def toInt(s: String) = {
    try {
      Some(s.toInt)
    } catch {
      case e: Exception => None
    }
  }

  private def getResult(x: Any): String = {
    x match {
      case 0 => "0"
      case "hello" => "hello"
      case true => "true"
      case List(a, b, c) => s"list with three elements"
      case list @ List(1, _*) => s"list begin with 1, remain: $list"
      case (a, b) => s"tuple: a=$a, b=$b"
      case s: String => s"string: $s"
      case i: Int => s"int: $i"
      case l: Long => s"long: $l"
      case list: List[_] => s"list: $list"
      case map: Map[_, _] => s"map: ${map.toString()}"
      case _ => "other"
    }
  }

  def whilst(testCondition: => Boolean)(codeBlock: => Unit): Unit = {
    while (testCondition) {
      codeBlock
    }
  }

}
