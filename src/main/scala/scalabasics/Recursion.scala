package scalabasics

import scala.annotation.tailrec

object Recursion extends App {
  def factorialNumber(n: Int): Int = {
    if (n <= 0) 1
    else n * factorialNumber(n - 1)
  }

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumalator: BigInt): BigInt = {
      if (x <= 1) accumalator
      else factHelper(x - 1, x * accumalator)
    }
    factHelper(n, 1)

  }

  /*
  anotherFactorial(10)=factHelper(10,1)
  =factHelper(9,10*1)
  =factHelper(8,10*9*1)
  =factHelper(7,10*9*8*1)
  ...
  =factHelper(1,10*9*8*7...*1)
  =1*2*3*4...*10
   */
  println(anotherFactorial(5000))

  def stringNtimes(str: String, n: Int) = {
    @tailrec
    def factHelper(x: Int, accumalator: String, str: String): String = {
      if (x <= 1) accumalator
      else factHelper(x - 1, accumalator.concat(str), str)
    }
    factHelper(n, str, str)
  }
  println(stringNtimes("mah", 5))

  def primeNumber(n: Int): Boolean = {
    @tailrec
    def isPrimeUntill(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntill(t - 1, n % t != 0 && isStillPrime)
    }
    isPrimeUntill(n / 2, true)
  }
  println(primeNumber(10))

  def fibonacciSeries(n: Int): Int = {
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
