package cn.egg

/**
 * 关于集合
 */
object AboutCollect {

  def main(args: Array[String]): Unit = {
    var arr: Array[Int] = Array(1, 2, 3, 4, 5, 5, 6)

    arr = arr :+ 1

    arr.foreach(print_)
    println()

    var list: List[Int] = List(1, 2, 3, 4, 5, 5, 6)
    list = list :+ 1

    list.foreach(print_)
    println()

    /**
     * 过滤方法
     */
    // collect
    List(1, 2, 3).collect(_ > 2).foreach(print_) // false false true
    println()
    List(1, 2, 3).collect(_ * 2).foreach(print_) // 2 4 6
    println()

    // diff
    List(1, 2, 3).diff(List(1, 2)).foreach(print_) // 3
    println()

    // distinct
    list.distinct.foreach(print_) // 1 2 3 4 5 6
    println()

    // drop
    list.drop(5).foreach(print_) // 5 6
    println()

    // dropWhile
    list.dropWhile(_ < 5).foreach(print_) // 移除前期匹配到的，直到第一个不匹配的就停掉 5 5 6
    println()

    // filter
    list.filter(_ < 5).foreach(print_) // 1 2 3 4
    println()

    // filterNot
    list.filterNot(_ < 5).foreach(print_) // 5 5 6
    println()

    // find
    list.find(_ < 5).foreach(print_) // 返回符合条件的第一个元素 1
    println()

    // foldLeft
    println(list.foldLeft(0)(_ + _)) // 26

    // foldRight
    println(list.foldRight(0)(_ + _)) // 26

    // head
    println(list.head) // 1

    // headOption
    list.headOption.foreach(print_)
    println()

    // init
    list.init.foreach(print_) // 删除右边第一个 1 2 3 4 5 5
    println()

    // intersect
    list.intersect(List(1, 3, 7)).foreach(print_) // 取交集 1 3
    println()

    // last
    println(list.last) // 最后一个值 6

    // lastOption
    list.lastOption.foreach(print_) // 最后一个值 6
    println()

    // reduceLeft
    println(list.reduceLeft(_ + _)) // 26

    // reduceRight
    println(list.reduceRight(_ + _)) // 26

    // slice
    list.slice(1, 5).foreach(print_) // 从第from位置开始，截止util位置(不包含) 2 3 4 5
    println()

    // tail
    list.tail.foreach(print_) // 不包含第一位的序列 2 3 4 5 5 6
    println()

    // takeWhile
    list.takeWhile(_ < 5).foreach(print_) // 从左边开始匹配，直到第一个不匹配的停止 1 2 3 4
    println()

    // union
    list.concat(List(1, 2, 3)).foreach(print_) // 1 2 3 4 5 5 6 7 8 9
    println()

    /**
     * 转换方法
     */
    // ++
    (list ++ List(1, 2, 3)).foreach(print_) // 类似concat 1 2 3 4 5 5 6 1 2 3
    println()

    // zip
    List(1, 2, 3, 6).zip(List(2, 3, 4, 5)).foreach(print_)
    println()

    // unzip
    List(1, 2, 3).zipWithIndex.foreach(print_)
    println()

    // groupBy
    list.groupBy(_ < 5).foreach(print_)
//    list.map((_, 1)).groupBy(_._1).view.mapValues(_.length).foreach(print_)
    println()

    // partition
    println(list.partition(_<5))

    // span
    println(list.span(_<5))

    // spanAt
    println(list.splitAt(3))
  }

  private def print_(x: Any): Unit = {
    print(s"$x ")
  }

}
