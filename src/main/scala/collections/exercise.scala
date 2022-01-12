package collections

import scala.annotation.tailrec

/**
  */
object exercise extends App {

  /** Here we add a new person to the Map.
    * network here is a map to this map we add a key as person which is string and the value of the key is a new Set.
    * @param network - Receives a network object which is a Map[String,Set[String]
    * @param person - Receives a Person which is a String
    * @return
    */
  def add(
      network: Map[String, Set[String]],
      person: String
  ): Map[String, Set[String]] = {
    network + (person -> Set())
  }

  /** Here we get the friends of A, friends of B from the network map which we got.
    * Then we add the friends of  B to A and friends of A to B
    * @param network- Receives a network object which is a Map[String,Set[String]
    * @param a- Receives a Person which is a String
    * @param b- Receives a Person which is a String
    * @return
    */
  def friend(
      network: Map[String, Set[String]],
      a: String,
      b: String
  ): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  /** Here we get the friends of A, friends of B from the network map which we got.
    * Then we remove the friends of  B to A and friends of A to B
    * @param network- Receives a network object which is a Map[String,Set[String]
    * @param a- Receives a Person which is a String
    * @param b- Receives a Person which is a String
    * @return
    */
  def unfriend(
      network: Map[String, Set[String]],
      a: String,
      b: String
  ): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  /** @param network- Receives a network object which is a Map[String,Set[String]
    * @param person- Receives a Person which is a String
    * @return
    */
  def remove(
      network: Map[String, Set[String]],
      person: String
  ): Map[String, Set[String]] = {
    @tailrec
    def removeAux(
        friends: Set[String],
        networkAcc: Map[String, Set[String]]
    ): Map[String, Set[String]] = {
      if (friends.isEmpty) networkAcc
      else removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    }

    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
}
