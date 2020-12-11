package example.scala.tuples

// Tuples

object PersonApp extends App {
  val tupleV1 = (1, "some string")
  val (firstValue, secondValue) = tupleV1

  println(tupleV1)
  println(s"${tupleV1._1} && ${tupleV1._2}")
  println(s"$firstValue $secondValue")
  println((1, "hi", 3.8, "some element in a tuple"))
}
