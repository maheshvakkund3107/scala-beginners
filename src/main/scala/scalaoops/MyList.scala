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

  /** @param transformer- Receives a MyTransformer Object
    * @tparam B -Type Parameter
    * @return
    */
  def map[B](transformer: A => B): MyList[B]

  /** @param transformer- Receives a MyTransformer Object
    * @tparam B -Type Parameter
    * @return
    */
  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  /** @param predicate - Receives a MyPredicate Object
    * @return
    */
  def filter(predicate: A => Boolean): MyList[A]

  /** @param list - Receives a object of MyList.
    * @tparam B -Type Parameter
    * @return
    */
  def ++[B >: A](list: MyList[B]): MyList[B]

  /** @param f- Receives a function.
    */
  def foreach(f: A => Unit): Unit

  /** @param compare - Two elements to compare are received.
    * @return
    */
  def sort(compare: (A, A) => Int): MyList[A]
}

case object Empty extends MyList[Nothing] {

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
    Cons(element, Empty)

  /** @return
    */
  override def printElements: String = ""

  /** @param transformer- Receives a MyTransformer Object
    * @tparam B -Type Parameter
    *  @return
    */
  override def map[B](transformer: Nothing => B): MyList[B] = Empty

  /** @param transformer- Receives a MyTransformer Object
    * @tparam B -Type Parameter
    *  @return
    */
  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] =
    Empty

  /** @param predicate- Receives a MyPredicate Object
    *  @return
    */
  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  /** @param list- Receives a object of MyList.
    * @tparam B -Type Parameter
    * @return
    */
  override def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  /** @param f- Receives a function.
    */
  override def foreach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing, Nothing) => Int) = Empty

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

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
  override def add[B >: A](element: B): MyList[B] = Cons(element, this)

  /** @return
    */
  override def printElements: String =
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"

  /** @param predicate- Receives a MyPredicate Object
    *  @return
    */
  override def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  /** @param transformer- Receives a MyTransformer Object
    * @tparam B -Type Parameter
    *  @return
    */
  override def map[B](transformer: A => B): MyList[B] = {
    Cons(transformer(h), t.map(transformer))
  }

  /** @param list- Receives a object of MyList.
    * @tparam B -Type Parameter
    * @return
    */
  override def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, t ++ list)

  /** @param transformer- Receives a MyTransformer Object
    * @tparam B -Type Parameter
    *  @return
    */
  override def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }
  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) Cons(x, sortedList)
      else Cons(sortedList.head, insert(x, sortedList.tail))
    }
    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }
}

/** MyList
  *  -map(transformer) => MyList
  *  -filter(predicate) => MyList
  *  -flatMAp(transformer from A to MyList[B] =>MyList[B]
  */

object ListTest extends App {
  val listOfIntegers: MyList[Int] =
    new Cons[Int](1, new Cons[Int](2, new Cons[Int](3, Empty)))
  val anotherListOfIntegers: MyList[Int] =
    new Cons[Int](6, new Cons[Int](4, new Cons[Int](5, Empty)))
  val listOfString: MyList[String] =
    new Cons[String]("Hello", new Cons[String]("World", Empty))
  println(listOfIntegers.toString)
  println(listOfString.toString)

  println(
    listOfIntegers
      .map((elem: Int) => elem * 2)
      .toString
  )

  println(listOfIntegers.filter((element: Int) => element % 2 == 0).toString)

  println(listOfIntegers ++ anotherListOfIntegers)

  println(
    listOfIntegers
      .flatMap((elem: Int) =>
        new Cons[Int](elem, new Cons[Int](elem + 1, Empty))
      )
      .toString
  )
  println(listOfIntegers == anotherListOfIntegers)

  println(
    listOfIntegers
      .map((elem: Int) => elem * 2)
      .toString
  )

  listOfIntegers.foreach(println)
  println(listOfIntegers.sort((x, y) => y - x))

}
