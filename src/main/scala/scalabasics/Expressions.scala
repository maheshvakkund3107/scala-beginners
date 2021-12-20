package scalabasics

/** A unit of code that returns a value after it has been executed.
  * One or more lines of code can be considered an expression
  * if they are collected together using curly braces ({ and }).
  * This is known as an expression block.
  */
object Expressions extends App {
  val x = 1 + 2
  println(1 + 2)
  println(1 + 2 * 4)
  //+ - * / & | ^ << >> >>> (right shift with zero extension)
  println(1 == x)
  // == != > >= < <=
  println(1 != x)
  // ! && ||

  var aVariable = 2

  /** Also works with -= *= /= Works only with var (Side Effects)
    */
  aVariable += 3

  /**  Instructions are doing something.
    */

  /**    Expression is something which has value or types.
    *    Expressions are evaluated
    */

  /** If Expression
    */

  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 4
  println(aConditionValue)

  /** Never write loop
    */

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }

  /** Everything in Scala is a expression
    */

  /** Unit === void
    */
  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)

  /** Side effects: println, whiles, reassigning
    */

  /**  Code Blocks
    */

  val aCodeBlock = {
    val x = 2
    val z = x + 1

    if (z > 2) "hello" else "goodbye"
  }

  /** 1.IF in scala is an expression.
    * 2.Code Blocks in scala are expressions (The value of the block is the value of its last expression).
    * 3.Expression vs Instruction
    *  -Instructions are executed while Expressions are evaluated.
    *  -In Scala we will think in terms of expressions.
    */
}
