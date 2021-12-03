package scalaoops

import scalaoops.practiceexercise.Writer

object PackagingAndImports extends App {

  /**
    * Package members are accessible by their simple name
    */
  val writer = new Writer("mahesh", "abcd", 2011)

  /**
    * Importing the package using Fully Qualified Name.
    * scalaoops.practiceexercise.Writer
    */

  /**
    * Package Object
    */
  sayHello
  println(SPPED_OF_LIGHT)

  /**
    * If multiple Classes/objects are to be imported from the same package
    *
    * scalaoops.practiceexercise._
    */

}
