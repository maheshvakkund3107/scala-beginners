package scalaoops

object Exceptions extends App {
  val x: String = null

  /** 1.Throwing exception.
    *
    * Throwable classes extend Throwable class
    * Exception and Error are the major Throwable subtypes
    */

  /** 2. How To catch exceptions.
    * Finally block is optional, use finally block only for side-effects.
    */

  /** @param withExceptions - Boolean value to check exception occurred or not
    * @return
    */
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) {
      throw new RuntimeException("No int for you")
    } else {
      42
    }
  }

  /**
    */
  val potentialfail =
    try {
      getInt(true)
    } catch {
      case e: RuntimeException => 43
    } finally {
      println("finally")
    }
  println(potentialfail)

  /** 3.How to define your own exceptions.
    */
  class MyException extends Exception
  val exception = new MyException
  throw exception

  /** Out of Memory error
    * val array: Int = Array.ofDim(Int.MaxValue)
    */

  /** Crashing the JVM
    * @return
    */
  /** def infinite: Int = 1 + infinite
    *  val noLimit = infinite
    */

}
