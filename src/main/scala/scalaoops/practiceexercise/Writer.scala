package scalaoops.practiceexercise

/** @param firstname - First Name of the writer.
  * @param surname - Last Name of the Author.
  * @param year - Year of birth of the author.
  */
class Writer(firstname: String, surname: String, var year: Int) {
  def fullName: String = firstname + "-" + surname
}
