package scalabasics

/**
  *
  */
object Functions extends App {

  /**
    *
    * @param a
    * @param b
    * @return
    */
  def aFunction(a: String, b: Int): String = {
    a + "" + b
  }
  println(aFunction("HELLO", 3))

  /**
    *
    * @return
    */
  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  /*  println(aParameterlessFunction)*/

  /**Recursive Functions*/

  /**
    *
    * @param aString
    * @param n
    * @return
    */
  def repeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + repeatedFunction("hello", n - 1)
  }
  println(repeatedFunction("hello", 3))

  /**
    * Key Takeaways
    * 1.When you need loops, use recursion
    * 2.In a normal function the return type is non mandatory,but in case of recursive function its mandatory
    * That is because the compiler cannot figure out the return type of a recursive function on its own.
    *
    */

  def aFunctionWithSideEffects(aString: String): Unit = print(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b
    aSmallFunction(n, n - 1)
  }

  println(aBigFunction(6))

  /**Exercises*/

  /**
    *  1.A greeting function (name,age) =>Hi, my nameis $name and I am $age old
    * @param name
    * @param age
    * @return
    */
  def greetingFunction(name: String, age: Int): String = {
    "Hi, my name is " + name + "and I am " + age + "old"
  }

  println(greetingFunction("mahesh", 24))

  /**
    * 2. Prime Numbers
    */
  def factorialNumber(n: Int): Int = {
    if (n <= 0) 1
    else n * factorialNumber(n - 1)
  }
  println(factorialNumber(4))

  /**
    * 3.Fibonacci Series
    */
  def fibonacciSeries(n: Int): Int = {
    if (n <= 2) 1
    else fibonacciSeries(n - 1) + fibonacciSeries(n - 2)
  }
  println(fibonacciSeries(8))

  /**
    * 4.Prime Numbers
    */
  def primeNumber(n: Int): Boolean = {
    def isPrimeUntill(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntill(t - 1)
    }
    isPrimeUntill(n / 2)

  }
  println(primeNumber(4))
}
