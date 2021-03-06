package scalaoops

/**
  */
object Objects extends App {

  /** Scala does not have class level functionality ("Static")
    * SCALA OBJECT => SINGLETON INSTANCE
    */

  /**
    */
  object Person {

    /** STATIC/ CLASS LEVEL FUNCTIONALITY. */
    val N_EYES = 2

    /** @return
      */
    def canFly: Boolean = false

    /** apply() is a factory method */

    /** @param mother - Takes a person object as a parameter
      * @param father- Takes a person object as a parameter
      * @return
      */
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  /** @param name- Takes a person name as a parameter
    */
  class Person(val name: String) {

    /** INSTANCE LEVEL FUNCTIONALITY. */
  }

  /** If class and objects are in the same file they are called as "COMPANIONS" */

  println(Person.N_EYES)
  println(Person.canFly)
  val john = new Person("John")
  val mary = new Person("Mary")
  println(john == mary)
  val bogie = Person(mary, john)

  val person1 = Person
  val person2 = Person
  println(person1 == person2)

  /** KEY TAKE AWAY */
  /** Scala Objects:
    * 1.Are in their own class
    * 2.Are the only instance.
    * 3.Singleton pattern in one line.
    */

  /** Scala Companions:
    * 1.Can access each others(Object,Class) private member.
    * 2.Scala is more Object oriented compared scala since all the code
    * that we write can only be accessed in an instance of something.
    */

}
