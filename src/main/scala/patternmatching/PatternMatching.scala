package patternmatching

import java.beans.Expression
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
    * @param name - Takes a name as a parameter.
    * @param age- Takes a age as a parameter.
    */
  case class Person(name: String, age: Int)
  val bob = Person("mahesh", 15)

  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi my name is $n and I cant drink"
    case Person(n, a)           => s"Hi my name is $n and I am $a years old"
    case null                   => "I don't know you"
  }
  println(greeting)

  /** 1.CASES are matched in order.
    * 2.If cases are not matched we get scala.MatchError.
    * 3.Type of PatternMatching Expression? Unified type of all the types in all the cases.
    * 4.Pattern matching really works well with case classes.
    */

  /** Pattern matching on sealed hierarchies.
    */

  /** Pattern matching for sealed classes needs exhaustive pattern, else compiler will highlight it.
    */
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(greeting: String) extends Animal
  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
    case _              => println("I don't know you")
  }

  val i = 6
  val isEvenNormal = i % 2 == 0

  /** Exercise.
    */

  trait Expr
  case class Number(n: Int) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n)   => s"$n"
    case Sum(e1, e2) => show(e1) + "+" + show(e2)
    case Prod(e1, e2) =>
      def mayBeShowParentheses(exp: Expr) =
        exp match {
          case Prod(_, _) => show(exp)
          case Number(_)  => show(exp)
          case _          => "(" + show(exp) + ")"
        }
      mayBeShowParentheses(e1) + "*" + mayBeShowParentheses(e2)
  }
  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Prod(Sum(Number(2), Number(3)), Number(4))))
}
