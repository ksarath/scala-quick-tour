package example.scala.caseclasses

// Case classes, Companion object

case class Person(firstName: String, lastName: String)

object Person {
  //A companion object is an object that’s declared in the same file as a class, and has the same name as the class
  //A companion object and its class can access each other’s private members
  //A companion object’s apply method lets you create new instances of a class without using the new keyword
  //A companion object’s unapply method lets you de-construct an instance of a class into its individual components

  def apply(): Person = Person("First Name", "Last Name")
}

object PersonApp extends App {
  val p1 = Person("Sarath", "Kallatt Sivasankaran")
  println(p1)

  val p2 = Person()
  println(p2)

  val p3 = p2.copy(lastName = "Guzeev")
  println(p3)

  val p4 = p2.copy(lastName = "Guzeev", firstName = "Lev")
  println(p4)
}
