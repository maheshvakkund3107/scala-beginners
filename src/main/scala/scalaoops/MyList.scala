package scalaoops

abstract class MyList[+A] {

  /** head -> first element of the list.
    */
  def head: A

  /** tail -> remainder of the list.
    */
  def tail: MyList[A]

  /** isEmpty -> Is the list empty.
    */
  def isEmpty: Boolean

  /** add(int) -> new list with this element added.
    */
  def add[B >: A](element: B): MyList[B]

  /** toString -> a string representation of the list.
    */

  def printElements: String

  /** @return - formatted string
    */
  override def toString: String = "[" + printElements + "]"

}

object Empty extends MyList[Nothing] {

  /** @return - For a empty list there is no head so we throw the NoSuchElementException.
    */
  override def head: Nothing = throw new NoSuchElementException

  /** @return - For a empty list there is no tail so we throw the NoSuchElementException.
    */
  override def tail: MyList[Nothing] = throw new NoSuchElementException

  /** @return - Since the list is empty we return true.
    */
  override def isEmpty: Boolean = true

  /** @param element - Element contains the value to be added to MyList.
    * @return
    */
  def add[B >: Nothing](element: B): MyList[B] =
    new Cons(element, Empty)

  /** @return
    */
  override def printElements: String = ""

}

class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  /** @return - Will return the head for MyList Object.
    */
  override def head: A = h

  /** @return - Will return the tail for MyList Object.
    */
  override def tail: MyList[A] = t

  /** @return - Since the list is not empty we return true.
    */
  override def isEmpty: Boolean = false

  /** @param element- element contains the value to be added to MyList.
    * @return
    */
  override def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  /** @return
    */
  override def printElements: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
}

object ListTest extends App {
  val listOfIntegers: MyList[Int] =
    new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val listOfString: MyList[String] =
    new Cons[String]("Hello", new Cons[String]("World", Empty))
  println(listOfIntegers.toString)
  println(listOfString.toString)
}
