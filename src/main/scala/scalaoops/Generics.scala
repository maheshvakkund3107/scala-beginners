package scalaoops

object Generics extends App {
  /*
  Type A denotes generic type.
  1.Traits can also be Type parameterized.
  2.Objects  cannot  be Type parameterized.
   */
  class MyMap[Key, Value] {}

  class MyList[+A] {
    //def add(element: A): MyList[A] = ???
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Dog its a Animal i.e  B=Animal
     */

  }

  val listOfIntegers = new MyList[Int]
  val listOfString = new MyList[String]

  // Generic Methods.

  object MyList {
    def emptys[A]: MyList[A] = new MyList[A]
  }

  val emptyListOfIntegers = MyList.emptys[Int]

  //Variance Problem

  class Animal {}

  class Cat extends Animal {}

  class Dog extends Animal {}

  /*
  Does List[Cat] extends List[Animal] ?
  1.If yes its a case of COVARIANCE.
   */
  class CovariantList[+A] {}

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  //animalList.add(new Dog) ???  => We return List of Animals.
  /*
    Does List[Cat] extends List[Animal] ?
     2.If No its a case of INVARIANCE.
   */
  class InvariantList[A] {}

  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  /*
       3.If HELL NO , its a case of CONTRVARIANCE.
   */

  class Trainer[-A] {}

  val contravariantList: Trainer[Cat] = new Trainer[Animal]

  //Bounded Types
  /*
  1.It accepts all the Sub types of Animal
  2.Bounded type solves the problem of Covariance.
   */
  class Cage[A <: Animal](animal: A)

  val cage = new Cage(new Dog)

}
