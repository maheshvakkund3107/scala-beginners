package scalaoops

/**
  */
object AbstractDataTypes extends App {

  /** Abstract
    * 1.Abstract class cannot be instantiated hence object creation impossible.
    */

  abstract class Animal {
    val creatureType: String
    def eat(): Unit
  }

  class Dog extends Animal {

    /** Override keyword is non mandatory since the compiler will figure it out.
      */
    override val creatureType: String = "Canine"

    override def eat(): Unit = {
      println("Dog is eating")
    }
  }

  /** Trait
    */

  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeat: String = "Fresh meat"
  }

  trait ColdBlooded {}

  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "crocodile"
    def eat(): Unit = {
      println("Crocodile is eating")
    }
    def eat(animal: Animal): Unit = {
      println(s"I am crocodile and I am eating ${animal.creatureType}")
    }
  }
  val dog = new Dog
  val crocodile = new Crocodile
  crocodile.eat()
  crocodile.eat(dog)

  /** Difference between Abstract and Trait
    * 1.Both Abstract classes and traits have both Abstract and Non Abstract members.
    * 2.Traits cannot have constructor parameters.
    * 3.We can inherit only one class at a time but inherit multiple traits at a given time.(Multiple inheritance can be achieved by traits).
    * 4.Traits = Behavior, Abstract class=Thing.
    */
}
