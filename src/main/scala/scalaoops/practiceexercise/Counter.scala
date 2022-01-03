package scalaoops.practiceexercise

import scala.annotation.tailrec

/** Counter class
  * -receives an int value
  * -method current count
  * -method to increment/decrement =>new Counter
  * -overload inc/dec to receive an amount
  */
class Counter(val count: Int) {

  /** @return
    */
  def inc(): Counter = {
    println("Incrementing")

    /** Immutability.
      */
    new Counter(count + 1)
  }

  /** @return
    */
  def dec(): Counter = {
    println("Decrementing")
    new Counter(count - 1)
  }

  /** @param n- Takes a number of int type to increment.
    * @return
    */
  def inc(n: Int): Counter = {
    if (n <= 0) this
    else
      inc().inc(n - 1)
  }

  /** @param n - Takes a number of int type to decrement.
    * @return
    */
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else
      dec().dec(n - 1)
  }

  /**
    */
  def print(): Unit = {
    println(count)
  }
}
