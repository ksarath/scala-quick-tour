package example.scala.patternmatch

// Pattern match possible for any class / object with extractors using unapply methods

object PersonApp extends App {
  val a = (true, "some", 1)
  val result1 = a match {
    case (true, _, _)                        => "first case"
    case (_, "some", n) if n < 2              => "second case"
    case (_, "some", n) if n > 1              => "third case"
    case (_, some, n) if some == "someother"  => s"fourth case: $n"
    case somethingElse                        => s"nothing matched: $somethingElse"
  }

  val optionVal = Option("something")
  val result2 = optionVal match {
    case None => "Empty value"
    case Some(v) => s"Found value: $v"
  }

  // You can also nest these pattern matches
  // You can use pattern match with Scala collections, case classes, ADTs

  println(result1)
  println(result2)
}
