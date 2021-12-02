package scalaoops.practiceexercise

/**
  * class Person(name: String, age: Int)
  */
/**Consructor*/

/**
  *
  * @param name
  * @param age
  */
class Person(name: String, val age: Int) { //consructor
  val x = 2
  println(1 + 3)

  /**
    *
    * @param name
    */
  def greet(name: String): Unit = {
    println(s"${this.name} says :Hi , $name")
  }

  /**
    * Method Overloading
    */

  def greet(): Unit = {
    print(s"Hi , I am $name")
  }

  /**
    *
    * @param name
    */
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}
