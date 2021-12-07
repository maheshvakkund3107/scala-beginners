package scalaoops.practiceexercise

import sun.invoke.empty.Empty

/**
  *
  * @tparam A
  */
abstract class MyList[+A] {

  /**
    * @return : First element of the list.
    */
  def head: A

  /**
    *
    * @return : Remainder of the list.
    */
  def tail: MyList[A]

  /**
    *
    * @return : Is this list empty.
    */
  def isEmpty: Boolean

  /**
    *
    * @param element
    * @tparam B
    * @return : New list with this element added.
    */
  def add[B >: A](element: B): MyList[B]

  /**
    *
    * @return
    */
  def printElements: String

  /**
    *
    * @return A String representation of the list.
    */
  override def toString: String = "[" + printElements + "]"

  /**
    *
    * @param transformer
    * @tparam B
    * @return
    */
  def map[B](transformer: A => B): MyList[B]

  /**
    *
    * @param transformer
    * @tparam B
    * @return
    */
  def flatMap[B](transformer: A => MyList[B]): MyList[B]

  /**
    *
    * @param predicate
    * @return
    */
  def filter(predicate: A => Boolean): MyList[A]

  /**
    * Concatenation
    *
    * @param list
    * @tparam B
    * @return
    */
  def ++[B >: A](list: MyList[B]): MyList[B]

  /**
    *
    * @param f
    */
  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyList[A]
}

case object Empty extends MyList[Nothing] {

  /**
    *
    * @return
    */
  def head: Nothing = throw new NoSuchElementException

  /**
    *
    * @return
    */
  def tail: MyList[Nothing] = throw new NoSuchElementException

  /**
    *
    * @return
    */
  def isEmpty: Boolean = true

  /**
    *
    * @param element
    * @tparam B
    * @return
    */
  def add[B >: Nothing](element: B): MyList[B] = {
    new Cons(element, Empty)
  }

  /**
    *
    * @return
    */
  override def printElements: String = ""

  /**
    *
    * @param transformer
    * @tparam B
    * @return
    */
  def map[B](transformer: Nothing => B): MyList[B] = Empty

  /**
    *
    * @param transformer
    * @tparam B
    * @return
    */
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] =
    Empty

  /**
    *
    * @param predicate
    * @return
    */
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  /**
    *
    * @param list
    * @tparam B
    * @return
    */
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  /**
    *
    * @param f
    */
  def foreach(f: Nothing => Unit): Unit = ()
  def sort(compare: (Nothing, Nothing) => Int) = Empty
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {

  /**
    *
    * @return
    */
  def head: A = h

  /**
    *
    * @return
    */
  def tail: MyList[A] = t

  /**
    *
    * @return
    */
  def isEmpty: Boolean = false

  /**
    *
    * @param element
    * @tparam B
    * @return
    */
  def add[B >: A](element: B): MyList[B] = {
    new Cons(element, this)
  }

  /**
    *
    * @return
    */
  override def printElements: String = {
    if (t.isEmpty) "" + h
    else s"${h}  ${t.printElements}"
  }

  /**
    * [1,2,3].filter(n%2==0)=
    * [2,3].filter(n%2==0)=
    * new Cons(2,[3].filter(n%2==0))
    * new Cons(2,Empty.filter(n%2==0))
    * new Cons(2,Empty)
    */

  /**
    *
    * @param predicate
    * @return
    */
  def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) {
      new Cons(h, t.filter(predicate))
    } else {
      t.filter(predicate)
    }
  }

  /*
  [1,2,3].map(n,2)=
      new Cons(2,[2,3].map(n*2))
      new Cons(2,new Cons(4,[3].map(n*2)))
      new Cons(2,new Cons(4,new Cons(6,Empty.map(n*2))))
      new Cons(2,new Cons(4,new Cons(6,Empty)))
   */

  /**
    *
    * @param transformer
    * @tparam B
    * @return
    */
  def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  /**
    *
    * @param transformer
    * @tparam B
    * @return
    */
  def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }

  /**
    *
    * @param list
    * @tparam B
    * @return
    */
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  /**
    *
    * @param f
    */
  def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] =
      if (sortedList.isEmpty) {
        new Cons(x, Empty)
      } else if (compare(x, sortedList.head) <= 0) {

        new Cons(x, sortedList)
      } else new Cons(sortedList.head, insert(x, sortedList.tail))

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }
}

/**
  *
  */
object ListTest extends App {
  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] =
    new Cons("Hello", new Cons("World", new Cons("Scala", Empty)))
  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  /**
    *
    *
    * println(
    * listOfIntegers
    * .map(new Function1[Int, Int] {
    * override def apply(element: Int): Int = element * 2
    * })
    * .toString
    * )
    *
    * println(
    * listOfIntegers
    * .filter(
    * new Function1[Int, Boolean] {
    * override def apply(element: Int): Boolean = element % 2 == 0
    * }
    * )
    * .toString
    * )
    * println(
    * listOfIntegers
    * .flatMap(
    * new Function1[Int, MyList[Int]] {
    * override def apply(element: Int): MyList[Int] =
    * new Cons(element, new Cons[Int](element + 1, Empty))
    * }
    * )
    * .toString
    * ) */

  println(
    listOfIntegers
      .map((element: Int) => element * 2)
      .toString
  )

  println(
    listOfIntegers
      .filter(element => element % 2 == 0)
      .toString
  )
  println(
    listOfIntegers
      .flatMap(element => new Cons(element, new Cons[Int](element + 1, Empty)))
      .toString
  )
  listOfIntegers.foreach(x => println(x))
  println(listOfIntegers.sort((x, y) => y - x))
}
