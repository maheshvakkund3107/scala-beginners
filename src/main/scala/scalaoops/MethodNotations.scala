package scalaoops

object MethodNotations extends App {
  class Person(name: String, favoriteMovies: String) {
    def likes(movie: String): Boolean = { movie == favoriteMovies }
  }
  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  /*Infix Notation = operator notation*/
  println(mary likes "Inception")
  /*"operators" in scala*/

}
