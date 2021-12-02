package scalabasics

/**
  *
  */
object CNBvsCBV extends App {

  /**
    *
    * 1.Value is computed before the call.
    * 2.Same value is used everywhere.
    *
    * @param x
    */
  def calledByValue(x: Long): Unit = {
    println("by Value :" + x)
    println("by Value:" + x)
  }

  /**
    * 1.Expression is passed iterally.
    * 2.Expression is evaluated at every use within.
    *
    * @param x
    */
  def calledByName(x: => Long): Unit = {
    println("by Name :" + x)
    println("by Name :" + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  /**
    *
    * @return
    */
  def infinite(): Int = 1 + infinite()

  /**
    *
    * @param x
    * @param y
    */
  def printFirst(x: Int, y: => Int) = println(x)
  //printFirst(infinite(), 34)
  printFirst(34, infinite())
}
