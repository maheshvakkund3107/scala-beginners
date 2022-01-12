package collections

object TuplesAndMaps extends App {

  /** Finite ordered lists = Tuples.
    * Tuple2(2, "hello", "scala")
    */
  val aTuple = (2, "hello", "scala") //Tuple2[Int,String] = (Int,String)

  /** Access the members of the tuples.
    */
  println(aTuple._1)

  /**  Copy the members of the tuples.
    */
  println(aTuple.copy(_2 = "goodBye Java"))
  println(aTuple.toString())

  /** Maps - Keys->>Values
    */

  val aMap: Map[String, Int] = Map()

  /** a->b is syntactic sugar for (a,b)
    * withDefaultValue will return a default value if the key is not found.
    */
  val phoneBook = Map(("Jim", 666), "Daniel" -> 789).withDefaultValue(-1)
  println(phoneBook.contains("Jim"))

  /** This will crash.(Map with apply() and does not contain key will throw  NoSuchElementException.
    * To guard against such element will add withDefaultValue(-1)
    *
    * Example :  Map(("Jim", 666), "Daniel" -> 789).withDefaultValue(-1)
    */
  println(phoneBook("Mary"))

  /** Add a new Pair.
    */

  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  /** Functions on maps
    * Map,FlatMap, Filter
    */

  println(phoneBook.map(pair => pair._1.toLowerCase() -> pair._2))

  /** These are deprecated
    *
    * println(phoneBook.filterKeys(x => x.startsWith("J")))
    * println(phoneBook.mapValues(x => x * 10))
    */
  /** Conversion to other collections.
    */
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)
  val myBikes = List("ThunderBird 350", "YRF R3", "S1000RR")
  val topSpeed = List(132, 167, 300)
  val bikeSpeed = (myBikes zip topSpeed).toMap
  println(bikeSpeed)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))
}
