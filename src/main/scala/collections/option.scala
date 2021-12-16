package collections

object option extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)
  println(noOption)

  /**
   * Unsafe API'S
   */

  def unSafeMethod(): String = null

  /**
   * Wrong Approach
   * Some should have some valid values.
   * val result = Some(null)
   */

  /**
   * Some or None is built automatically by the compiler.
   * Null checks are handled by compiler in the Option
   */
  val result = Option(unSafeMethod())

  /**
   * Chained Methods.
   */
  def backupMethods(): String = "A Valid result"

  val chainedResult = Option(unSafeMethod()).orElse(Option(backupMethods()))

  /**
   * Design Unsafe Methods
   */
  def betterUnsafeMethods(): Option[String] = None

  def betterBackUpMethods(): Option[String] = Some("A Valid Result")

  /**
   * Functions on Options.
   */
  println(myFirstOption.isEmpty)

  /**
   * Not Recommended - Unsafe to use this.
   */
  println(myFirstOption.get)

  /**
   * map, filter,flatMap
   */
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(_ > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  /**
   * For Comprehensions
   */


}
