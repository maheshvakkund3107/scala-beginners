package lectures

object StringOps extends App {
  val str: String = "Hello I am learning Scala"
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  /*Scala Specific: String interpolators*/
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  /*S-interpolators*/
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name and  I am age $age years old"
  val anothergreeting =
    s"Hello, my name is $name and  I am age ${age + 1} years old"
  println(anothergreeting)

  /*F-interpolators*/
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  /*raw-interpolator*/
  println(raw"This is a \n new line")
  val escaped = "This is a \n new line"
  println(raw"$escaped")
}
