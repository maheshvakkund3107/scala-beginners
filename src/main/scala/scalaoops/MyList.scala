package scalaoops

abstract class MyList {

  /** head -> first element of the list.
    */
  def head: Int

  /** tail -> remainder of the list.
    */
  def tail: MyList

  /** isEmpty -> Is the list empty.
    */
  def isEmpty: Boolean

  /** add(int) -> new list with this element added.
    */
  def add(element: Int): MyList

  /** toString -> a string representation of the list.
    */

  def printElements: String

  /** @return - formatted string
    */
  override def toString: String = "[" + printElements + "]"

}

object Empty extends MyList {

  /** @return - For a empty list there is no head so we throw the NoSuchElementException.
    */
  override def head: Int = throw new NoSuchElementException

  /** @return - For a empty list there is no tail so we throw the NoSuchElementException.
    */
  override def tail: MyList = throw new NoSuchElementException

  /** @return - Since the list is empty we return true.
    */
  override def isEmpty: Boolean = true

  /** @param element - Element contains the value to be added to MyList.
    * @return
    */
  override def add(element: Int): MyList = new Cons(element, Empty)

  /** @return
    */
  override def printElements: String = ""

}

class Cons(h: Int, t: MyList) extends MyList {

  /** @return - Will return the head for MyList Object.
    */
  override def head: Int = h

  /** @return - Will return the tail for MyList Object.
    */
  override def tail: MyList = t

  /** @return - Since the list is not empty we return true.
    */
  override def isEmpty: Boolean = false

  /** @param element- element contains the value to be added to MyList.
    * @return
    */
  override def add(element: Int): MyList = new Cons(element, this)

  /** @return
    */
  override def printElements: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
}

object ListTest extends App {
  val list = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)
  println(list.toString)
}
