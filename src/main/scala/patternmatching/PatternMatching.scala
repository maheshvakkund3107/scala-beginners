package patternmatching

import scala.util.Random

object PatternMatching extends App {

  /** switch on steroids
    */
  val random = Random
  val x = random.nextInt(10)
  val description = x match {
    case 1 => "The One"
    case 2 => "The Two"
    case 3 => "The Three"
    case _ => "WildCard"
  }
  println(x)
  println(description)

  /** 1.Decompose values.
    *
    * @param name
    * @param age
    */
  case class Person(name: String, age: Int)
  val bob = Person("mahesh", 15)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi my name is $n and I cant drink"
    case Person(n, a)           => s"Hi my name is $n and I am $a years old"
    case _                      => "I dont know you"
  }
  println(greeting)

  /** 1.CASES are matched in order.
    * 2. If cases are not matched we get MATCHERROR.
    * 3.Type of PM Expression? Unified type of all the types in all the cases.
    * 4.Pattern matching really works well with case classes.
    */

  /** Pattern matching on sealed hierrachies.
    */

  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal
  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
  }

  val i = 6
  val isEvenCond = if (i % 2 == 0) true else false
  val isEvenNormal = i % 2 == 0

}
