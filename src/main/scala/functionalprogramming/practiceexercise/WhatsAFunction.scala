package functionalprogramming.practiceexercise

object WhatsAFunction extends App {

  /**
    * A function which takes 2 Strings, and concatenates them.
    */
  val stringConcatenation: (String, String) => String =
    (a: String, b: String) => a.concat(b)
  println(stringConcatenation("ABCD", "DEFG"))

  /**
    * A function which takes an int and returns another function which takes an int and returns an int
    */
  val superAdder: Int => Int => Int =
    (x: Int) => (y: Int) => x + y

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(4)(3)) /**Curried Function*/

}
