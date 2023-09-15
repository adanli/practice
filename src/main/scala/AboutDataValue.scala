package cn.egg

import com.github.nscala_time.time.Imports.richInt
import org.joda.time.DateTime

import scala.util.Random


/**
 * 数值
 */
object AboutDataValue {
  def main(args: Array[String]): Unit = {

    println(s"Short Max Value: ${Short.MaxValue}, Min Value: ${Short.MinValue}")

    println(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"))

    println(DateTime.now().withPeriodAdded(2.months, 1).toString("yyyy-MM-dd HH:mm:ss"))

    println("17".toInt(16))
    println(17.isValidInt)

    println(17.isValidInt)

    println(0.31512 ~= 0.3151)

    val bigNum = BigInt(1234567890)
    println(bigNum * bigNum)

    println(Random.nextInt(10000))
    println(Random.nextPrintableChar())

    for(n <- 0 to Random.nextInt(10)) yield print(s"$n ")
    println()

    (1 to 10 by 3).foreach (println)

    val pi = scala.math.Pi
    println(f"$pi%1.15f")

    // 金额
    val amount = java.text.NumberFormat.getNumberInstance().format(1234567890.12356)
    println(amount)

  }

  implicit class StringImprovements(val s: String) {
    def toInt(radix: Int): Int = Integer.parseInt(s, radix)
  }

  implicit class DoubleImprovements(val d: Double) {
    def ~=(d2: Double): Boolean = (d - d2).abs < 0.001
    def ~=(d2: Double, precision: Double): Boolean = (d - d2).abs < precision
  }

}
