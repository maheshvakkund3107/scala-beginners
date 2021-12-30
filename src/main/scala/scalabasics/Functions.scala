package scalabasics

import scala.annotation.tailrec

/**
  */
object Functions extends App {

  /** @param a - A value of the String type.
    * @param b- A value of the Int type.
    * @return - A Concatenated String value
    */
  def aFunction(a: String, b: Int): String = {
    a + "" + b
  }
  println(aFunction("HELLO", 3))

  /** @return
    * Functions can be called without the parameters.
    * The round braces are too optional.
    */
  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  /** Recursive Functions */

  /** @param aString -A value of the String type to be printed recursively.
    * @param n-Number of times the string value to be repeated.
    * @return - Returns a repeated string with specified number of times.
    */
  def repeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + repeatedFunction("hello", n - 1)
  }
  println(repeatedFunction("hello", 3))

  /** Key Takeaways
    * 1.When you need loops, use recursion
    * 2.In a normal function the return type is non mandatory,but in case of recursive function its mandatory
    * That is because the compiler cannot figure out the return type of a recursive function on its own.
    */

  /** @param aString - Input Parameter of the type String.
    */
  def aFunctionWithSideEffects(aString: String): Unit = print(aString)

  /** @param n-Number of times the function needs to be called.
    * @return
    */
  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b
    aSmallFunction(n, n - 1)
  }

  println(aBigFunction(6))

  /** Exercises */

  /**  1.A greeting function (name,age) =>Hi, my nameis $name and I am $age old
    * @param name- - It takes input as Name.
    * @param age - It takes input as Age.
    * @return - Returns a String message.
    */
  def greetingFunction(name: String, age: Int): String = {
    "Hi, my name is " + name + "and I am " + age + "old"
  }

  println(greetingFunction("mahesh", 24))

  /** 2. Prime Numbers
    */

  /** @param n - It takes input as a number to calculate the factorial of the number (Int Type).
    * @return - Factorial of the number.
    */
  def factorialNumber(n: Int): Int = {
    if (n <= 0) 1
    else n * factorialNumber(n - 1)
  }
  println(factorialNumber(4))

  /** 3.Fibonacci Series
    */

  /** @param n- It takes input as a number to calculate the Fibonacci value of the number (Int Type).
    * @return -Fibonacci Value
    */
  def fibonacciSeries(n: Int): Int = {
    if (n <= 2) 1
    else fibonacciSeries(n - 1) + fibonacciSeries(n - 2)
  }
  println(fibonacciSeries(8))

  /** 4.Prime Numbers
    */

  /** @param n- It takes input as a number to check whether it is a prime number or not.
    * @return - Boolean value of the result.
    */
  def primeNumber(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) {
        true
      } else { n % t != 0 && isPrimeUntil(t - 1) }
    }
    isPrimeUntil(n / 2)

  }
  println(primeNumber(4))
}
