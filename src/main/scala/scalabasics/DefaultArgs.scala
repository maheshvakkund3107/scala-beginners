package scalabasics

import scala.annotation.tailrec

/**
  */
object DefaultArgs extends App {
  val fact12 = trFact(12)
  val fact10 = trFact(10, 2)
  println(fact12)

  /** @param n - Number to calculate the factorial of the number.
    * @param acc - Accumulator to store the intermediate results.
    * @return - Returns the factorial of the number.
    */
  @tailrec
  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFact(n - 1, n * acc)
  }
  print(fact10)

  /** @param format - String as an argument.
    * @param width -Int value as an argument
    * @param height -Int value as an argument
    */
  def savePicture(
      format: String = "jpg",
      width: Int = 1920,
      height: Int = 1080
  ): Unit = {
    println("saving picture")
  }
  savePicture()
  savePicture(width = 800)
  savePicture(height = 600, width = 800, format = "bmp")

  /** 1.Pass in every leading argument.
    * 2.Name the arguments.
    * 3.Can name all the parameters or pass them in a different order
    */

}
