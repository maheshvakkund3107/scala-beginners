package functionalprogramming

/**
  *
  */
object AnonymousFunctions extends App {
  val doubler = new Function[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  /**
    * Anonymous Function (Lambda)
    */
  val doubles: Int => Int = (x: Int) => x * 2
  val doubles1: Int => Int = x => x * 2

  /**
    * Multiple parameters in  a lambda
    */

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  /**
    * No parameters.
    */
  val justDoSomething: () => Int = () => 3
  println(justDoSomething) /**Prints the function only */
  println(justDoSomething()) /**Prints the value / calls the function*/

  /**
    * Curly braces with lambda.
    */
  val stringToInt = { (str: Int) => str.toInt }

  /**
   MOAR Syntactic sugar.
    */

  /**
    * Equivalent : x=x+1
    * Underscore below is a parameter.
    */
  val niceIncrementer: Int => Int = _ + 1
  val niceAdder: (Int, Int) => Int = _ + _

  /**
    *
    *
  val superAdder: Function1[Int, Function1[Int, Int]] =
    new Function1[Int, Function1[Int, Int]] {
      override def apply(x: Int): Function1[Int, Int] =
        new Function1[Int, Int] {
          override def apply(y: Int): Int = x + y
        }
    }*/

  val superAdder = (x: Int) => (y: Int) => x + y
  println(superAdder(3)(4))

}
