package cn.egg
package otherscope

class Foo {
  def exec(f: String => Unit, name: String): Unit = {
    f(name)
  }
}
