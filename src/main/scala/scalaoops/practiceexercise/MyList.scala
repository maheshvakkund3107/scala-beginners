package scalaoops.practiceexercise

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
  def map[B](transformer: MyTransformer[A, B]): MyList[B]

  /**
    *
    * @param transformer
    * @tparam B
    * @return
    */
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

  /**
    *
    * @param predicate
    * @return
    */
  def filter(predicate: MyPredicate[A]): MyList[A]

  /**
    * Concatenation
    *
    * @param list
    * @tparam B
    * @return
    */
  def ++[B >: A](list: MyList[B]): MyList[B]
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
  def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty

  /**
    *
    * @param transformer
    * @tparam B
    * @return
    */
  def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] =
    Empty

  /**
    *
    * @param predicate
    * @return
    */
  def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

  /**
    *
    * @param list
    * @tparam B
    * @return
    */
  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
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
  def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) {
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
  def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
    new Cons(transformer.transform(h), t.map(transformer))
  }

  /**
    *
    * @param transformer
    * @tparam B
    * @return
    */
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }

  /**
    *
    * @param list
    * @tparam B
    * @return
    */
  def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
}

/**
  *
  * @tparam T
  */
trait MyPredicate[-T] {
  def test(element: T): Boolean
}

/**
  *
  * @tparam A
  * @tparam B
  */
trait MyTransformer[-A, B] {
  def transform(element: A): B
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

  println(
    listOfIntegers
      .map(new MyTransformer[Int, Int] {
        override def transform(element: Int): Int = element * 2
      })
      .toString
  )

  println(
    listOfIntegers
      .filter(
        new MyPredicate[Int] {
          override def test(element: Int): Boolean = element % 2 == 0
        }
      )
      .toString
  )
  println(
    listOfIntegers
      .flatMap(
        new MyTransformer[Int, MyList[Int]] {
          override def transform(element: Int): MyList[Int] =
            new Cons(element, new Cons[Int](element + 1, Empty))
        }
      )
      .toString
  )
}
