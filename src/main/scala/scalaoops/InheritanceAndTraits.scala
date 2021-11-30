package scalaoops

object InheritanceAndTraits extends App {
  /*
  Single class inheritance.
  Access Modifiers available in scala are
  1.Public
  2.Protected
  3.Private
  By default the access modifier is public
   */
  sealed class Animal {
    val creatureType = "wild"
    def eat = { println("Animal is Eating") }
  }
  class Cat extends Animal {
    def crunch = {
      eat
      println("Cat is crunching")
    }
  }
  val cat = new Cat()
  cat.crunch

  //Constructors
  //Case 1:
  class Person(name: String, age: Int)
  /*
  1.Before calling the constructor of Adult it will call the constructor of Person
  2.Constructor without the parameters is not available so it will through error.
  class Adult(name: String, age: Int, idCard: String) extends Person
   */
  class Adult(name: String, age: Int, idCard: String)
      extends Person(name: String, age: Int)

  //Auxilary constructor
  //Case 2:
  class PersonNew(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class AdultNew(name: String, age: Int, idCard: String)
      extends PersonNew(name: String)

  //Overriding
  /*
  Fields from the superclass can be overriden directly in the constructor of the child class
   */
  class Dog(override val creatureType: String) extends Animal {
    /*
    override val creatureType: String = "domestic"
     */
    override def eat = println("Dog is eating")
  }
  val dog = new Dog("domestic")
  dog.eat
  println(dog.creatureType)

  //Type Substitution : For the instance of Dog we can use the type as Animal this is called as Polymorphism
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  //Super is used when you want to reference a method or a field from the parent class.
  class Tiger extends Animal {
    override def eat: Unit = {
      super.eat
      println("Tiger is eating")
    }
  }
  val tiger = new Tiger
  tiger.eat

  //Preventing Overrides.
  /*
  1.Use final keyword on the fields or members or methods.
  2.Use final on the entire class - Stop the Extension to all classes.
  3.Seal the class - Extend classes in this file and prevent extension in other files.
   */

}
