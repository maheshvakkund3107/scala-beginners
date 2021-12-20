package scalabasics

/**
  */
object ValuesVariablesTypes extends App {
  val x: Int = 10
  println(x)

  /** x=12
    * vals are immutable, cannot be reassigned.
    */

  val y = 42
  println(y)

  /** Compiler can infer types based on the data.
    */

  val str: String = "hello"

  /** Semicolons are allowed in scala
    *
    * val str: String = "hello";
    */

  val aBoolean: Boolean = false
  val aChar: Char = 'a'

  /** Compiler complains if number too long.
    *
    * There are size for each data type in scala
    *
    * Boolean-1 Bit True or false.
    * Int - 4bytes or 32bits
    * Short- 2bytes or 16bits
    * Long-8bytes or 64bits
    * Float -4bytes or 32bits - Single Precision
    * Double - 4bytes or 32 bits - Double precision
    */

  val aShort: Short = 1242
  val aLong: Long = 1224345436456456L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  /** Variables
    */

  var aVariable: Int = 4

  /** Side Effects.
    */
  aVariable = 6

  /** Key Takeaways
    * 1: Prefer vals over vars
    * 2: All vals and vars have types
    * 3: Compiler automatically infers types when omitted
    */

}
