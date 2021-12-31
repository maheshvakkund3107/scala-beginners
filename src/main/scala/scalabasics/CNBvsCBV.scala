package scalabasics

/**
  */
object CNBvsCBV extends App {

  /** 1.Value is computed before the call.
    * 2.Same value is used everywhere.
    *
    * @param x- Takes a input value of long type.
    */
  def calledByValue(x: Long): Unit = {
    println("by Value :" + x)
    println("by Value:" + x)
  }

  /** 1.Expression is passed internally.
    * 2.Expression is evaluated at every use within.
    *
    * @param x - Takes a input value of long type.
    */
  def calledByName(x: => Long): Unit = {
    println("by Name :" + x)
    println("by Name :" + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  /** @return
    */
  def infinite(): Int = 1 + infinite()

  /** @param x- Takes a input value of Int type.
    * @param y- Takes a input value of Int type.
    */
  def printFirst(x: Int, y: => Int): Unit = println(x)
  printFirst(34, infinite())
}
