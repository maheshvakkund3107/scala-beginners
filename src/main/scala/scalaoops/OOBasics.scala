package scalaoops

object OOBasics extends App {
  val person = new Person("Mahesh", 26)
  println(person.age)
  println(person.x)
  person.greet("John")
  person.greet()

  val author = new Writer("Mahesh", "Vakkund", 1812)
  val author1 = new Writer("mahesh", "vakkund", 1822)
  val novel = new Novel("Great Expectation", 1861, author)
  println(novel.authorAge)
  println(novel.isWrittenBy(author1))
  val counter = new Counter(0)
  println(counter.inc().print())
  println(counter.inc(10).print())
  println(counter.inc().inc().inc().print())

}

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

//class paramter are NOT FIELDS
//To make them fields add the keyword val or var

/*
Novel and Writer
Writer:firstname, surname, year
-method fullname

Novel:name, year of release, author
-author age
-isWrittenBy
-copy(new year of release)=new instance of novel
 */
class Writer(firstname: String, surname: String, var year: Int) {
  def fullName = firstname + "-" + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = {
    year - author.year
  }
  def isWrittenBy(author: Writer) = {
    author == this.author
  }
  def copy(newYear: Int): Novel = {
    new Novel(name, newYear, author)
  }
}

/*
Counter class
-recieves an int value
-method current count
-method to increment/decremet =>new Counter
-overload inc/dec to recieve an amount
 */
class Counter(val count: Int) {
  def inc(): Counter = {
    println("Incrementing")
    new Counter(count + 1)
  }
  def dec(): Counter = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else
      inc().inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else
      dec().dec(n - 1)
  }

  def print(): Unit = {
    println(count)
  }
}
