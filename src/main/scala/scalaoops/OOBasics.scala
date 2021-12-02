package scalaoops

import scalaoops.practiceexercise.{Counter, Novel, Person, Writer}

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

/**class paramter are NOT FIELDS*/
/**To make them fields add the keyword val or var*/
