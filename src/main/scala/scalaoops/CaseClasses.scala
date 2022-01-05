package scalaoops

object CaseClasses extends App {

  /** @param name -Name of the person.
    * @param age - Age of the person.
    */
  case class Person(name: String, age: Int)

  /** 1.Class parameters are promoted to fields when we use the keyword case.
    *
    * class Person(val/var name: String, age: Int) without case.
    */
  /** val jim = new Person("Mahesh", 22) */
  val jim = Person("Mahesh", 22)
  println(jim.name)

  /** 2.Sensible toString.
    *
    * Output without case: scala_ops.CaseClasses$Person@cd866b
    * Output with case:Person(Mahesh,22)
    */
  println(jim.toString)
  println(jim)

  /** 3.equals and hashcode implemented Out of the Box implemented by case claas
    */
  val jim2 = Person("Mahesh", 22)
  println(jim == jim2)

  /** 4.Case Classes have handy copy method.
    */
  val jim3 = jim.copy()
  println(jim3)
  val jim4 = jim.copy(age = 45)
  println(jim4)

  /** 5. Case classes have companion objects.
    */
  /** Companion object are automatically created by Scala by the below line */
  val thePerson = Person
  val mary = Person("Mary", 45)

  /** 6. Case classes are Serializable.
    */

  /** 7.Case classes have extractor patterns.
    * Case classes can be used in pattern matching
    */

  case object UnitedKingdom {
    def name: String = "UK"
  }
}
