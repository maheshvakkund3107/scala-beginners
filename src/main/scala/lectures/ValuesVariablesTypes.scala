package lectures

object ValuesVariablesTypes extends App {
  val x: Int = 10
  println(x)
  //x=12
  //vals are immutable, cannot be reassigned.

  val y = 42
  println(y)
  //compiler can infer types.

  val str: String = "hello";
  //Semicolons are allowed in scala

}
