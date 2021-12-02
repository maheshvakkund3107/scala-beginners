package scalaoops.practiceexercise

/**
  *
  * @param name
  * @param year
  * @param author
  */
class Novel(name: String, year: Int, author: Writer) {

  /**
    *
    * @return
    */
  def authorAge = {
    year - author.year
  }

  /**
    *
    * @param author
    */
  def isWrittenBy(author: Writer) = {
    author == this.author
  }

  /**
    *
    * @param newYear
    * @return
    */
  def copy(newYear: Int): Novel = {
    new Novel(name, newYear, author)
  }
}
