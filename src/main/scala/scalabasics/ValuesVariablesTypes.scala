package scalabasics

object ValuesVariablesTypes extends App {
  val x: Int = 10
  println(x)
  //x=12
  //vals are immutable, cannot be reassigned.

  val y = 42
  println(y)
  //compiler can infer types.

  val str: String = "hello";
  //Semicolons are allowed in scala

  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  //Compiler complains if number too long
  val aShort: Short = 1242
  val aLong: Long = 1224345436456456L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //variables
  var aVariable: Int = 4
  aVariable = 6 //Side Effects

  //Key Takeaways
  //1: Prefer vals over vars
  //2: All vals and vars have types
  //3: Compiler automatically infers types when omitted
}
