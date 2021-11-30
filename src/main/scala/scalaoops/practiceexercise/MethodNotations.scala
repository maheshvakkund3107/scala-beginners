package scalaoops.practiceexercise

object MethodNotations extends App {
  class Person(val name: String, favoriteMovies: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovies
    def +(person: Person): String =
      s"${this.name}  is hanging out with ${person.name}"
    def +(nickname: String): Person =
      new Person(s"$name ($nickname)", favoriteMovies)
    def unary_! : String =
      s"$name what the heck?"
    def unary_+ : Person = new Person(name, favoriteMovies, age + 1)
    def isAlive: Boolean = true
    def learns: String = s"$name learns scala"
    def apply(): String = s"Hi My name is $name and I like $favoriteMovies"
    def apply(n: Int): String = s"$name watched $favoriteMovies $n times"
  }
  /*
   * Exercise 1:
    Overload the + operator.
   * */
  /*
  () will call the apply()
   * */
  val mary = new Person("Mary", "Inception")
  println((mary + "the rockstar")())
  println((mary + "the rockstar").apply())

  /*Exercise 2:
  Add an age to Person class.
  Add a unary +  operator => new Person with age + 1
  +mary =>mary with the age incrementer
   */
  println((+mary).age)

  /*Exercise 3:
  Add a "learns" method in the Person class => "Mary learns Scala"
  Use it in Postfix Notation.
   */
  println(mary.learns)

  /*
  Overload the apply method.
  mary.apply(2) => Mary watched Inception 2 times.
   */
  println(mary(2))
}
