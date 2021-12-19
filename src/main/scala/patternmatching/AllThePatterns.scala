package patternmatching

import patternmatching.PatternMatching.{Person, bob}
import scalaoops.Generics.MyList
import scalaoops.practiceexercise.{Cons, Empty}

import scala.util.matching.Regex
import scala.util.matching.Regex.Match

case object AllThePatterns extends App {

  /** 1.Constants.
    */
  val x: Any = "Scala"
  val constants = x match {
    case 1              => "A number"
    case "Scala"        => "The Scala"
    case true           => "The Truth"
    case AllThePatterns => "A singleTon object"
  }

  /** 2-Match Anything
    * 2.1 Wild Card.
    */
  val matchAnything = x match {
    case _ => "Wildcard"
  }

  /** 2.2 Variables
    */
  val matchVariable = x match {
    case something => s"I have found $something"
  }

  /** 3-Tuples
    */
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1, 1)         =>
    case (something, 2) => s"I have found $something"
  }

  val nestedTuples = (1, (2, 3))
  val matchANestedTuple = nestedTuples match {
    case (_, (2, 3)) =>
  }

  /** 4-Case classes - Constructor pattern
    */
  /** val aList: MyList[Int] = Cons(1, Cons(2, Empty))
    *  val matchAList = aList match {
    *    case Empty                              =>
    *    case Cons(head, Cons(subhead, subtail)) =>
    *  }
    */

  /** 5-List Patterns
    */
  val aStandardList = List(1, 2, 3, 54)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _)    => // Extractor Advanced.
    case List(1, _*)         => //List of arbitary length -Advanced.
    case 1 :: List(_)        => //infix pattern
    case List(1, 2, 3) :+ 42 => //infix pattern
  }

  /** 6-Type Specifiers.
    */
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => //Explicit Type Specifier
    case _               =>
  }

  /** 7,8 Need to practice.
    * 7-NAME BINDING.
    * 8-MULTI PATTERNS.
    */

  /** 9-If guards.
    */
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi my name is $n and I cant drink"
    case Person(n, a)           => s"Hi my name is $n and I am $a years old"
    case _                      => "I dont know you"
  }

}
