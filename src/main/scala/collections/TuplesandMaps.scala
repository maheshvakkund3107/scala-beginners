package collections

object TuplesandMaps extends App {

  /**
    * Finite ordered lists = Tuples.
    */
  val aTuple = (2, "hello", "scala") //Tuple2[Int,String] = (Int,String)

  println(aTuple._1)
  println(aTuple.copy(_2 = "goodBye Java"))
  println(aTuple.toString())

  /**
    * Maps - Keys->>Values
    */

  val aMap: Map[String, Int] = Map()

  /**
    * a->b is syntactic sugar for (a,b)
    * withDefaultValue will return a default value if the key is not found.
    */
  val phoneBook = Map(("Jim", 666), "Daniel" -> 789).withDefaultValue(-1)
  println(phoneBook.contains("Jim"))
  println(phoneBook("Mary"))

  /**
    * Add a new Pair.
    */

  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  /**
    * Functionals on maps
    * Map,FlatMap, Filter
    */

  println(phoneBook.map(pair => pair._1.toLowerCase() -> pair._2))

  /**
    *println(phoneBook.filterKeys(x => x.startsWith("J")))
    * println(phoneBook.mapValues(x => x * 10))
    */

  val myBikes = List("ThunderBird 350", "YRF R3", "S1000RR")
  val topSpeed = List(132, 167, 300)
  val bikeSpeed = (myBikes zip topSpeed).toMap
  println(bikeSpeed)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
}
