package scalaoops.practiceexercise

/*
Counter class
-recieves an int value
-method current count
-method to increment/decremet =>new Counter
-overload inc/dec to recieve an amount
 */
class Counter(val count: Int) {
  def inc(): Counter = {
    println("Incrementing")
    new Counter(count + 1)
  }
  def dec(): Counter = {
    println("Decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else
      inc().inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else
      dec().dec(n - 1)
  }

  def print(): Unit = {
    println(count)
  }
}
