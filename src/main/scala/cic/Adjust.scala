package cn.egg
package cic

object Adjust {
  private val insuranceItem = (
    ("流动资产", "存货"),
    ("固定资产", "便捷设备"),
    ("营业利润", null),
    ("审计费用", null),
  )

  val policy:Policy = new Policy("12345")


  def main(args: Array[String]): Unit = {
    init()
    println()
  }

  def init(): Unit = {
    val clause1 = Clause("财产综合险条款-财产综合险责任")
    val clause2 = Clause("营业中断条款-营业中断责任")
    val clause3 = Clause("附加台风条款-台风责任")
    val clause4 = Clause("KE07：附加个人财产条款-个人财产责任")


    val subject1 = new Subject("长安街1号")
    val subject2 = new Subject("长安街2号")
    policy.subjects = policy.subjects :+ subject1
    policy.subjects = policy.subjects :+ subject2

    val subjectItem1 = SubjectItem("0001", insuranceItem._1)
    val subjectItem2 = SubjectItem("0002", insuranceItem._2)
    val subjectItem4 = SubjectItem("0004", insuranceItem._3)
    val subjectItem5 = SubjectItem("0005", insuranceItem._4)
    subject1.subjectItems = subject1.subjectItems :+ subjectItem1
    subject1.subjectItems = subject1.subjectItems :+ subjectItem2
    subject1.subjectItems = subject1.subjectItems :+ subjectItem4
    subject1.subjectItems = subject1.subjectItems :+ subjectItem5

    val subjectItem3 = SubjectItem("0003", insuranceItem._1)
    subject2.subjectItems = subject2.subjectItems :+ subjectItem3

  }


  /**
   * 保单
   */
  case class Policy(policyNo: String, var subjects: Array[Subject]) {
    def this(policyNo: String) {
      this(policyNo, Array())
    }
  }

  /**
   * 标的
   */
  case class Subject(name: String, var subjectItems: Array[SubjectItem]) {
    def this(name: String) {
      this(name, Array())
    }
  }

  /**
   * 标的项
   */
  case class SubjectItem(name: String, itemType: (String, String), clauses: Array[Clause])

  /**
   * 条款
   */
  case class Clause(name: String, coverages: Array[Coverage]) {
    def this(name: String) {
      this(name, Array())
    }
  }

  /**
   * 责任
   */
  case class Coverage(name: String)



}
