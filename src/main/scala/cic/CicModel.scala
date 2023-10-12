//package cn.egg
//package cic
//
//object CicModel {
//
//  def main(args: Array[String]): Unit = {
//    /*// 保单
//    val policy = new Policy("保单", 1000000)
//    policy.deductibles ++= Seq(Deductible("免赔额", deductibleAmount = 10000, deductibleRate = 0))
//
//    // 标的，办公楼
//    val subject1 = new Subject("办公楼", "富春路100号")
//
//    // 标的，拱北小区2-101室
//    val subject2 = new Subject("仓库", address = "拱北小区2-101室")
//    policy.subjects ++= Seq(subject1, subject2)
//
//    // 保险项目，固定资产-便携式设备
//    val insuranceItem1 = new InsuranceItem("固定资产-便携式设备")*/
//
//
//
//  }
//
//}
//
//// 保单
//// 保单，保额，标的，条款
//case class Policy(name: String, policyInsured: BigDecimal, subjects: Seq[Subject], clauses: Seq[Clause]) extends LimitAndDeductible {
//  def this(name: String) = {
//    this(name, policyInsured = 0, subjects = Seq(), clauses = Seq())
//  }
//
//  def this(name: String, policyInsured: BigDecimal) = {
//    this(name, policyInsured, subjects = Seq(), clauses = Seq())
//  }
//
//}
//
//// 标的
//// 标的，地址，保险项目
//case class Subject(name: String, address: String, insuranceItems: Seq[InsuranceItem]) extends LimitAndDeductible {
//  def this(name: String) = {
//    this(name, None.get, Seq())
//  }
//
//  def this(name: String, address: String) = {
//    this(name, address, Seq())
//  }
//
//}
//
//// 保险项目
//// 保险项目，条款
//case class InsuranceItem(name: String, clauses: Seq[Clause]) extends LimitAndDeductible {
//  def this(name: String) = {
//    this(name, Seq())
//  }
//}
//
//// 条款，责任
//case class Clause(name: String, coverages: Seq[Coverage]) extends LimitAndDeductible
//
//// 责任
//case class Coverage(name: String) extends LimitAndDeductible
//
//// 风险类型
//case class RiskItem(name: String)
//
//// 限额
//// 限额名称，限额，限额比例
//case class Limit(name: String, limitAmount: BigDecimal, limitRate: BigDecimal)
//
//// 免赔
//// 免赔，免赔额，免赔率
//case class Deductible(name: String, deductibleAmount: BigDecimal, deductibleRate: BigDecimal)
//
//// 限额、免赔基础组
//case class LimitAndDeductible(limits: Seq[Limit], deductibles: Seq[Deductible]) {
//  def this() = {
//    this(Seq(), Seq())
//  }
//}
//
//
