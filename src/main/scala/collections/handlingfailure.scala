package collections

import scala.util.{Failure, Success, Try}

object handlingfailure extends App {

  /** Create Success and Failure
    */

  val sSuccess: _root_.scala.util.Success[Int] = Success.apply(3)
  val aFailure: _root_.scala.util.Failure[Nothing] =
    Failure.apply(new RuntimeException("Super Failure"))

  Predef.println(handlingfailure.sSuccess)
  Predef.println(handlingfailure.aFailure)

  def unSafeMethod(): String = throw new RuntimeException(
    "No String for you buster"
  )

  /** Try objects via the apply method.
    */
  val potentialFailure: _root_.scala.util.Try[_root_.scala.Predef.String] =
    Try.apply(handlingfailure.unSafeMethod())
  Predef.println(handlingfailure.potentialFailure)

  /** syntax sugar
    */
  val anotherPotentialFailure: _root_.scala.util.Try[Unit] = Try.apply({

    /** Code that might throw error
      */
  })

  /** Utilities.
    */

  Predef.println(potentialFailure.isSuccess)

  /** orElse
    */

  def backUpMethod(): String = "A valid Result"

  val fallbackTry: _root_.scala.util.Try[_root_.scala.Predef.String] = Try
    .apply(handlingfailure.unSafeMethod())
    .orElse(Try.apply(handlingfailure.backUpMethod()))
  Predef.println(handlingfailure.fallbackTry)

  /** If you design the API.
    */
  def betterUnsafeMethod(): Try[String] =
    Failure.apply(new RuntimeException)

  def betterBackupMethod(): Try[String] = Success.apply("A valid Result")

  /** map , filter, flatmap
    */

  println(sSuccess.map(_ * 2))
  println(sSuccess.flatMap(x => Success(x * 10)))
  println(sSuccess.filter(_ > 10))

}
