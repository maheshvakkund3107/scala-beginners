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
  class Animal {
    val creatureType = "wild"
    protected def eat = { println("Eating") }
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
  class Dog(override val creatureType: String) extends Animal {
    /*
    override val creatureType: String = "domestic"
     */
    override def eat = println("Dog is eating")
  }
  val dog = new Dog("domestic")
  dog.eat
  println(dog.creatureType)
}
