package scalaoops.practiceexercise

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = {
    year - author.year
  }
  def isWrittenBy(author: Writer) = {
    author == this.author
  }
  def copy(newYear: Int): Novel = {
    new Novel(name, newYear, author)
  }
}
