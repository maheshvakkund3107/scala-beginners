package functionalprogramming.practiceexercise

object WhatsAFunction extends App {

  /**
    * A function which takes 2 Strings, and concatenates them.
    */
  val stringConcatenation: ((String, String) => String) =
    new Function2[String, String, String] {
      override def apply(a: String, b: String): String = a.concat(b)
    }
  println(stringConcatenation("ABCD", "DEFG"))

  /**
    * A function which takes an int and returns another function which takes an int and returns an int
    */
  val superAdder: Function1[Int, Function1[Int, Int]] =
    new Function1[Int, Function1[Int, Int]] {
      override def apply(x: Int): Function1[Int, Int] =
        new Function1[Int, Int] {
          override def apply(y: Int): Int = x + y
        }
    }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(4)(3)) /**Curried Function*/
}
