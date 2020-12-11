package example.scala.ifelse

case class Person(firstName: String, lastName: String) {
  val fullName = s"$lastName, $firstName"
}

object PersonApp extends App {
  val p1 = Person("Sarath", "Kallatt Sivasankaran")
  println(p1)
  println(p1.fullName)

  val welcomeMessage =
    if (p1.firstName == "Sarath") {
      // 1 + 1
      "Hi Sarath, how are you?"
    } else if (p1.lastName == "Mike") {
      "Hello Mike"
    } else {
      "Hi there"
    }
  println(welcomeMessage)
}
