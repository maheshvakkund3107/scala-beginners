package functionalprogramming

object WhatsAFunction extends App {

  /** DREAM : Use Functions as first class elements.
    * Problem : OOP.
    */

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }
  println(doubler(2))

  val stringToInt = new Function[String, Int] {
    override def apply(element: String): Int = element.toInt
  }
  println(stringToInt("3") + 4)

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  /** Function types : Function2[A,B,R] === (A,B)=>R
    * ALL SCALA FUNCTIONS ARE OBJECTS.
    */

}

trait MyFunction[A, B] {

  /** @param element Takes an element of the type A.
    * @return
    */
  def apply(element: A): B
}
