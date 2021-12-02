package scalaoops

object MethodNotations extends App {

  /**
    *
    * @param name
    * @param favoriteMovies
    */
  class Person(val name: String, favoriteMovies: String) {

    /**
      *
      * @param movie
      * @return
      */
    def likes(movie: String): Boolean = movie == favoriteMovies

    /**
      *
      * @param person
      * @return
      */
    def +(person: Person): String =
      s"${this.name}  is hanging out with ${person.name}"

    /**
      *
      * @return
      */
    def unary_! : String =
      s"$name what the heck?"

    /**
      *
      * @return
      */
    def isAlive: Boolean = true

    /**
      *
      * @return
      */
    def apply(): String = s"Hi My name is $name and I like $favoriteMovies"
  }
  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  /**Infix Notation = operator notation (Syntactic Sugar)*/
  println(mary likes "Inception")

  /**"operators" in scala*/

  val tom = new Person("TOM", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  /**All operators in scala are method *,+,-,/,%*/

  /**Perfix Notation*/
  val x = -1 // equivalent to 1.unary_-
  val y = 1.unary_-

  /**Unary prefix only works with +,-,~,!*/
  println(!mary)
  println(mary.unary_!)

  /**Postfix Notation*/
  println(mary.isAlive)

  /**apply*/
  println(mary.apply())
  println(mary()) // Equivalent to apply()

}
