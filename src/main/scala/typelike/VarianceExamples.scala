package cn.egg
package typelike

class GrandParent
class Parent extends GrandParent
class Child extends Parent

// 不变, 只能用类型A
class InvariantClass[A]
// 协变, 可以用类型A和A的子集
class CovariantClass[+A]
// 逆变, 可以用类型A和A的父集
class ContravariantClass[-A]

class VarianceExamples {

  def invarMethod(x: InvariantClass[Parent]) {}
  def covarMethod(x: CovariantClass[Parent]) {}
  def contraMethod(x: ContravariantClass[Parent]) {}

//  invarMethod(new InvariantClass[Child]) // 编译不通过
  invarMethod(new InvariantClass[Parent]) // 编译通过
//  invarMethod(new InvariantClass[GrandParent]) // 编译不通过

  covarMethod(new CovariantClass[Child]) // 编译通过
  covarMethod(new CovariantClass[Parent]) // 编译通过
//  covarMethod(new CovariantClass[GrandParent]) // 编译不通过

//  contraMethod(new ContravariantClass[Child]) // 编译不通过
  contraMethod(new ContravariantClass[Parent]) // 编译通过
  contraMethod(new ContravariantClass[GrandParent]) // 编译通过

}
