package collections

import scala.util.{Failure, Random, Success, Try}

object handlingFailure extends App {

  /** Create Success and Failure
    */

  val sSuccess: _root_.scala.util.Success[Int] = Success.apply(3)
  val aFailure: _root_.scala.util.Failure[Nothing] =
    Failure.apply(new RuntimeException("Super Failure"))

  Predef.println(handlingFailure.sSuccess)
  Predef.println(handlingFailure.aFailure)

  def unSafeMethod(): String = throw new RuntimeException(
    "No String for you buster"
  )

  /** Try objects via the apply method.
    */
  val potentialFailure: _root_.scala.util.Try[_root_.scala.Predef.String] =
    Try.apply(handlingFailure.unSafeMethod())
  Predef.println(handlingFailure.potentialFailure)

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
    .apply(handlingFailure.unSafeMethod())
    .orElse(Try.apply(handlingFailure.backUpMethod()))
  Predef.println(handlingFailure.fallbackTry)

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

  /** Exercise
    */

  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String): Unit = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html></html>"
      else throw new RuntimeException("Connection Interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())
    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("SomeOne else took the port")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(
      getConnection(host, port)
    )
  }

  val possibleConnection = HttpService.getSafeConnection(hostname, port)
  val possibleHtml =
    possibleConnection.flatMap(connection => connection.getSafe("/home"))
  possibleHtml.foreach(renderHTML)

  /** Shorthand Version
    */

  HttpService
    .getSafeConnection(hostname, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  for {
    connection <- HttpService.getSafeConnection(hostname, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)

  /** try{
    *   connection = HttpService.getSafeConnection(hostname, port)
    *    try{
    *      page = connection.getSafe("/home")
    *      renderHTML(html)
    *    }catch (Exception e){
    *
    *    }
    *  }catch (Exception e){
    *
    *  }
    */
}
