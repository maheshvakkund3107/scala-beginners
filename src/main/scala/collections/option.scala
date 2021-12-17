package collections

import java.sql.Connection
import scala.util.Random

object option extends App {

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None
  println(myFirstOption)
  println(noOption)

  /**
   * Unsafe API'S
   */

  def unSafeMethod(): String = null

  /**
   * Wrong Approach
   * Some should have some valid values.
   * val result = Some(null)
   */

  /**
   * Some or None is built automatically by the compiler.
   * Null checks are handled by compiler in the Option
   */
  val result = Option(unSafeMethod())

  /**
   * Chained Methods.
   */
  def backupMethods(): String = "A Valid result"

  val chainedResult = Option(unSafeMethod()).orElse(Option(backupMethods()))

  /**
   * Design Unsafe Methods
   */
  def betterUnsafeMethods(): Option[String] = None

  def betterBackUpMethods(): Option[String] = Some("A Valid Result")

  /**
   * Functions on Options.
   */
  println(myFirstOption.isEmpty)

  /**
   * Not Recommended - Unsafe to use this.
   */
  println(myFirstOption.get)

  /**
   * map, filter,flatMap
   */
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(_ > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  /**
   * For Comprehensions
   */

  /**
   * Exercise 1
   */

  val config: Map[String, String] = Map(
    "host" -> "127.0.0.1",
    "port" -> "8080"
  )

  class Connection {
    def connect = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  /**
   * Try to establish the connection, if so- print the connect method.
   */

  val host = config.get("host")
  val port = config.get("port")
  /**
   * if (h!=null)
   * if(p!=null)
   * return Connection.apply(h,p)
   */
  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  /**
   * if(connectionStats == null) println(None) else print(ConnectionStatus.get)
   *
   */
  val connectionStatus = connection.map(c => c.connect)
  println(connectionStatus)

  /**
   * if(status!=null)
   * println(status)
   */
  connectionStatus.foreach(println)
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port))
      .map(connection => connection.connect))
    .foreach(println)
}
