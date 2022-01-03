package scalaoops.practiceexercise

/** class Person(name: String, age: Int)
  */
/** Constructor */

/** @param name - Take name of the person as a parameter
  * @param age - Take age of the person as a parameter
  */
class Person(name: String, val age: Int) { //constructor
  /** Class fields.
    */
  val x = 2
  println(1 + 3)

  /** @param name - Take name of the person as a parameter
    */
  def greet(name: String): Unit = {

    /** this keyword is used to access the current object parameters/fields.
      */
    println(s"${this.name} says :Hi , $name")
  }

  /** Method Overloading
    */

  def greet(): Unit = {
    print(s"Hi , I am $name")
  }

  /** @param name - Take name of the person as a parameter
    */
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}
