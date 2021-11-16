package scalaoops.practiceexercise

/*class Person(name: String, age: Int) */
//consructor

class Person(name: String, val age: Int) { //consructor
  val x = 2
  println(1 + 3)

  def greet(name: String): Unit = {
    println(s"${this.name} says :Hi , $name")
  }

  //Method Overloading
  def greet(): Unit = {
    print(s"Hi , I am $name")
  }

  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}
