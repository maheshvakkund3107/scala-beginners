package scalaoops.practiceexercise

abstract class MyList[+A] {

  /*
  1.head : First element of the list.
  2.tail : Remainder of the list.
  3.isEmpty : Is this list empty.
  4.add(int) : New list with this element added.
  5.toString : a String representation of the list.
   */

  def head: A

  def tail: MyList[A]

  def isEmpty: Boolean

  def add[B >: A](element: B): MyList[B]

  def printElements: String

  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException

  def tail: MyList[Nothing] = throw new NoSuchElementException

  def isEmpty: Boolean = true

  def add[B >: Nothing](element: B): MyList[B] = {
    new Cons(element, Empty)
  }

  override def printElements: String = ""
}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h

  def tail: MyList[A] = t

  def isEmpty: Boolean = false

  def add[B >: A](element: B): MyList[B] = {
    new Cons(element, this)
  }

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else s"${h}  ${t.printElements}"

  }
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] =
    new Cons("Helllo", new Cons("World", new Cons("Scala", Empty)))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}
