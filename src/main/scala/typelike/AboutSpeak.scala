package cn.egg.typelike

class DogSpeak() {
  def speak(): Unit = {
    println("汪汪汪!")
  }
}

class CatSpeak() {
  def speak(): Unit = {
    println("喵喵喵!")
  }
}

object AboutSpeak extends App {
  callSpeak(new DogSpeak())
  callSpeak(new CatSpeak())

  private def callSpeak[A <: {def speak(): Unit}](obj: A): Unit = {
    obj.speak
  }

}
