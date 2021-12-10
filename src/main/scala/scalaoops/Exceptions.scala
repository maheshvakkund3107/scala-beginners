package scalaoops

object Exceptions extends App {
  val x: String = null

  /**
    * 1.Throwing exception.
    *
    * Throwable classes extend Throwable class
    * Exception and Error are the major Throwable subtypes
    */

  /**
    * 2. How To catch exceptions.
    * Finally block is optional, use finally block only for sideeffects.
    */
  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) {
      throw new RuntimeException("No int for you")
    } else {
      42
    }
  }

  val potentialfail =
    try {
      getInt(true)
    } catch {
      case e: RuntimeException => 43
    } finally {
      println("finally")
    }
  println(potentialfail)

  /**
    * 3.How to define your own exceptions.
    */
  class MyException extends Exception
  val exception = new MyException
  throw exception

}
