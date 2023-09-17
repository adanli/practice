package cn.egg

import scala.Console.println
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


  }

}
