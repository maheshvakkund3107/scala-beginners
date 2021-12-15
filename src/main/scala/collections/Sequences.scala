package collections

import scala.util.Random

object Sequences extends App {

  /**
    * Seq
    */
  val aSeq = Seq(1, 2, 3, 4, 5)
  println(aSeq)
  println(aSeq.reverse)
  println(aSeq(2))
  println(aSeq ++ Seq(7, 5, 6))
  println(aSeq.sorted)

  /**
    * Ranges
    */
  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  val aRangeUntil: Seq[Int] = 1 until 10
  aRangeUntil.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  /**
    * Lists
    * Prepend +:
    * Append :+
    */
  val aList = List(1, 2, 3)
  val prepend = 42 +: aList :+ 89
  println(prepend)

  val apples5 = List.fill(5)("apples")
  println(apples5)

  println(aList.mkString("-|-"))

  /**
    * Arrays
    */
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[Int](4)
  println(threeElements.mkString(" "))
  threeElements.foreach(println)

  /**
    * Mutation
    */
  numbers(2) = 0
  println(numbers.mkString(" "))

  /**
    * Arrays and Seq
    */
  val numbersSeq: Seq[Int] = numbers //Implicit Conversion to wrapped array.
  println(numbersSeq)

  /**
    * Vectors vs List
    */
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random()
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }
  val numberList = (1 to maxCapacity).toList
  val numberVector = (1 to maxCapacity).toVector

  /**
    * 1.Keep reference to tail.
    * 2.Updating an element in the middle takes long
    */
  println(getWriteTime(numberList))

  /**
    * 1.Depth of tree is small.
    * 2.Needs to replace an entire 32 -element chunk.
    */
  println(getWriteTime(numberVector))

}
