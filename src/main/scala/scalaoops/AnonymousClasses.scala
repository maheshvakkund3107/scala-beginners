package scalaoops

object AnonymousClasses {
  def main(args: Array[String]): Unit = {

    abstract class Animal {
      def eat: Unit
    }

    val funnyAnimal: Animal = new Animal {
      override def eat: Unit = println("hahahaha")
    }

    println(funnyAnimal.getClass)
    /*
    Behind the scenes when a Anonymous class is created.

    class AnonymousClasses$$anon$1 extends Animal{
     override def eat: Unit = println("hahahaha")
    }

    val funnyAnimal: Animal = new Animal
     */
  }
}
