package scalaoops.practiceexercise

/** @param name - Name of the Novel
  * @param year - Year of Release of the Novel.
  * @param author - Writer object.
  */
class Novel(name: String, year: Int, author: Writer) {

  /** @return
    */
  def authorAge: Int = {
    year - author.year
  }

  /** @param author - Takes an Writer object as parameter.
    */
  def isWrittenBy(author: Writer): Boolean = {
    author == this.author
  }

  /** @param newYear - Takes an year values as parameter.
    * @return
    */
  def copy(newYear: Int): Novel = {
    new Novel(name, newYear, author)
  }
}
