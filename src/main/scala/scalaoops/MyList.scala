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
  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  /** @param transformer- Receives a MyTransformer Object
    * @tparam B -Type Parameter
    * @return
    */
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  /** @param predicate - Receives a MyPredicate Object
    * @return
    */
  def filter(predicate: MyPredicate[A]): MyList[A]

  /** @param list - Receives a object of MyList.
    * @tparam B -Type Parameter
    * @return
    */
  def ++[B >: A](list: MyList[B]): MyList[B]
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

  /** @param transformer- Receives a MyTransformer Object
    * @tparam B -Type Parameter
    *  @return
    */
  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  /** @param transformer- Receives a MyTransformer Object
    * @tparam B -Type Parameter
    *  @return
    */
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] =
    Empty

  /** @param predicate- Receives a MyPredicate Object
    *  @return
    */
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  /** @param list- Receives a object of MyList.
    * @tparam B -Type Parameter
    * @return
    */
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

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

  /** @param predicate- Receives a MyPredicate Object
    *  @return
    */
  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  /** @param transformer- Receives a MyTransformer Object
    * @tparam B -Type Parameter
    *  @return
    */
  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  /** @param list- Receives a object of MyList.
    * @tparam B -Type Parameter
    * @return
    */
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  /** @param transformer- Receives a MyTransformer Object
    * @tparam B -Type Parameter
    *  @return
    */
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)
}

/** Generic Trait MyPredicate[T]
  */
trait MyPredicate[-T] {
  def test(element: T): Boolean
}

/** Generic trait MyTransformer[A,B]
  */
trait MyTransformer[-A, B] {
  def transform(elem: A): B
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

  /*println(
   *    listOfIntegers
   *      .map(new MyTransformer[Int, Int] {
   *        override def transform(elem: Int): Int = elem * 2
   *      })
   *      .toString
   *  )
   */

  println(
    listOfIntegers
      .map((elem: Int) => elem * 2)
      .toString
  )

  println(listOfIntegers.filter((element: Int) => element % 2 == 0).toString)

  println(listOfIntegers ++ anotherListOfIntegers)

  /* println(
   *    listOfIntegers
   *      .flatMap(new MyTransformer[Int, MyList[Int]] {
   *        override def transform(elem: Int): MyList[Int] =
   *          new Cons[Int](elem, new Cons[Int](elem + 1, Empty))
   *      })
   *      .toString
   *  )
   */

  println(
    listOfIntegers
      .flatMap((elem: Int) =>
        new Cons[Int](elem, new Cons[Int](elem + 1, Empty))
      )
      .toString
  )
}
