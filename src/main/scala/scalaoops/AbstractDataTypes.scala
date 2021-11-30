package scalaoops

object AbstractDataTypes extends App {
  //Abstract
  /*
  1.Abstract class cannot be instantiated hence object creation impossible.
   */
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    /*
    Override keyword is non mandtory since the compiler will figure it out.
     */
    override val creatureType: String = "Canine"
    override def eat: Unit = {
      println("Dog is eating")
    }
  }
}
