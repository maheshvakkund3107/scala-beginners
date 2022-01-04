package scalaoops

/**
  */
object AnonymousClasses {

  /** @param args - Arguments for the main method.
    */
  def main(args: Array[String]): Unit = {

    abstract class Animal {
      def eat(): Unit
    }

    /** val funnyAnimal: Animal = new Animal {
      *      override def eat(): Unit = println("haha haha")
      *    }
      */
    val funnyAnimal: Animal = () => println("haha haha")

    println(funnyAnimal.getClass)

    /** Behind the scenes when a Anonymous class is created.
      *      class AnonymousClasses$$anon$1 extends Animal{
      *        override def eat: Unit = println("haha haha")
      *      }
      *      val funnyAnimal: Animal = new Animal
      */

    class Person(name: String) {
      def sayHi(): Unit = {
        println(s"Hi, my name is $name how may I help you?")
      }
    }

    val jim: Person = new Person("Jim") {
      override def sayHi(): Unit =
        println("Hi ,my name is Jim , how can i be of service")
    }

    print(jim)

    /** Rules for Anonymous Class:
      * 1. Pass in required constructor arguments if needed.
      * 2. Implement all abstract fields/Methods.
      */
  }
}
