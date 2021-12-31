package scalabasics

import scala.annotation.tailrec

/**
  */
object Recursion extends App {

  /** @param n-Number for which the factorial needs to be computed.
    * @return - Factorial of a number.
    */
  def factorialNumber(n: Int): Int = {
    if (n <= 0) 1
    else n * factorialNumber(n - 1)
  }

  /** @param n- Number for which the factorial needs to be computed.
    * @return - Factorial of a number.
    */
  def anotherFactorial(n: Int): BigInt = {

    /** @param x - In each call the number is decremented by 1.
      * @param accumulator - Result/ Factorial after each call is stored in accumulator.
      * @return - Factorial of a number.
      */
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator)
    }
    factHelper(n, 1)

  }

  println(anotherFactorial(5000))

  /** @param str -Input String which needs to be concatenated multiple times.
    * @param n - Number of times the string needs to be concatenated.
    * @return - A String concatenated multiple times.
    */
  def stringTimes(str: String, n: Int) = {

    /** @param x  - In each call the number is decremented by 1.
      * @param accumulator- Result/ Factorial after each call is stored in accumulator.
      * @param str - Input String which needs to be concatenated multiple times.
      * @return - A String concatenated multiple times.
      */
    @tailrec
    def factHelper(x: Int, accumulator: String, str: String): String = {
      if (x <= 1) accumulator
      else factHelper(x - 1, accumulator.concat(str), str)
    }
    factHelper(n, str, str)
  }
  println(stringTimes("mah", 5))

  /** @param n -Number is taken as parameter to check whether it is prime or not.
    * @return - Returns true if it prime else false.
    */
  def primeNumber(n: Int): Boolean = {

    /** @param t -Number is taken as parameter to check whether it is prime or not.
      * @param isStillPrime -Returns true if it prime else false.
      * @return -Returns true if it prime else false.
      */
    @tailrec
    def isPrimeUntil(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntil(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeUntil(n / 2, true)
  }
  println(primeNumber(10))

  /** @param n -Number is taken as parameter to calculate the fibonacci value.
    * @return -  fibonacci value.
    */
  def fibonacciSeries(n: Int): Int = {

    /** @param x  -Number is taken as parameter to calculate the fibonacci value.
      * @param last - last value in the series (value of n-1).
      * @param nextToLast - value previous to last value in series(value of n-2).
      * @return - fibonacci value.
      */
    @tailrec
    def fibSeries(x: Int, last: Int, nextToLast: Int): Int = {
      if (x >= n) last
      else fibSeries(x + 1, last + nextToLast, last)
    }
    if (n <= 2) {
      1
    } else {
      fibSeries(2, 1, 1)
    }
  }
  println(fibonacciSeries(8))
}
