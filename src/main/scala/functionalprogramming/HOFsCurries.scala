package functionalprogramming

import scala.annotation.tailrec

object HOFsCurries extends App {

  val superFunction: (Int, (String, (Int, Boolean)) => Int) => Int => Int =
    null

  /** @param f - Function.
    * @param n - Number of times.
    * @param x - Value.
    * @return
    */
  @tailrec
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }
  val plusOne = (x: Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  /** @param f - Function.
    * @param n - Number of times.
    * @return
    */

  def nTimesBetter(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x
    else
      (x: Int) => nTimesBetter(f, n - 1)(f(x))
  }
  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))

  def curriedFormatter(c: String)(x: Double): String = c.format(x)
  val standardFormat: Double => String = curriedFormatter("%4.2f")
  val preciseFormat: Double => String = curriedFormatter("%10.8f")
  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))

  /** Takeaways:
    * 1.Functional programming=working with functions
    *     -Pass functions as parameters.
    *     -Return functions as result.
    * 2.Currying=functions with multiple parameter list.
    */
}
