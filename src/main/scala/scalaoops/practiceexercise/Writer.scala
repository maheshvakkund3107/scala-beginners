package scalaoops.practiceexercise

/*
Novel and Writer
Writer:firstname, surname, year
-method fullname

Novel:name, year of release, author
-author age
-isWrittenBy
-copy(new year of release)=new instance of novel
 */
class Writer(firstname: String, surname: String, var year: Int) {
  def fullName = firstname + "-" + surname
}

