package lectures

object Expressions extends App {
  val x = 1 + 2
  println(1 + 2)
  println(1 + 2 * 4)
  //+ - * / & | ^ << >> >>> (right shift with zero extension)
  println(1 == x)
  // == != > >= < <=
  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 //Also works with -= *= /= Works only with var (Side Effects)
  //Instructions
  /*
  Instructions are doing something.
   */
  //Expressions
  /*
    Expression is something which has value or types.
    Expressions are evaluated
    IF in scala is a recurssion
   */

  //If Expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 4
  println(aConditionValue)

  //Never write loop
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  //Everything in Scala is a expression
  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  //Side effects: println, whiles, reassigning

  //Code Blocks

  val aCodeBlock = {
    val x = 2
    val z = x + 1

    if (z > 2) "hello" else "goodbye"
  }
}
