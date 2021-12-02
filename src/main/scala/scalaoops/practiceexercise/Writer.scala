package scalaoops.practiceexercise

/**
  *
  * @param firstname
  * @param surname
  * @param year
  */
class Writer(firstname: String, surname: String, var year: Int) {
  def fullName = firstname + "-" + surname
}
