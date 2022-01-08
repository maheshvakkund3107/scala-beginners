package functionalprogramming

/**
  */
object MapFlatmapFilterFor extends App {
  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)

  /** Filter
    */
  println(list.map(x => x + 1))
  println(list.map(_ + 1))

  /** Map
    */
  println(list.filter(x => x % 2 == 0))
  println(list.filter(_ % 2 == 0))

  /** FlatMap
    */
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val number = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")

  /** Iterating
    */
  val combination =
    number.flatMap(n =>
      chars.flatMap(c => colors.map(color => "" + c + n + "-" + color))
    )
  println(combination)

  /** foreach
    */
  list.foreach(println)

  /** for Comprehension
    */
  val forCombinations = for {
    n <- number if n % 2 == 0
    c <- chars
    color <- colors
  } yield ("" + c + n + "-" + color)
  println(forCombinations)

  for {
    n <- number
  } println(n)

  list.map { x =>
    x * 2
  }
}
