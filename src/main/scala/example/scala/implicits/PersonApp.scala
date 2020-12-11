package example.scala.implicits

import java.util.{ArrayList, List => JList}
import scala.jdk.CollectionConverters._

object PersonApp extends App {
  // Only use it when needed
  implicit val implicitContext: String = "This is an implicit context"

  def someMethodV1(input: String)(implicit context: String): String =
    s"$input: $context"

  println(someMethodV1("input"))



  implicit def convertJavaToScala[A](list: JList[A]): List[A] =
    list.asScala.toList

  def someMethodV2(input: List[String]): String =
    input.mkString(" :: ")

  val javaList = new ArrayList[String]();
  javaList.add("this is a java list item")
  println(someMethodV2(javaList))

  // Implicit resolution - See https://docs.scala-lang.org/tutorials/FAQ/finding-implicits.html
  // Type classes and ADT - Separate topic for another session
}
