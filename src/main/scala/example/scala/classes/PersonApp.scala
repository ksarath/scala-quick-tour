package example.scala.classes

// Classes, Objects, Type Inference, Singleton

class Person(val firstName: String)

object Person {
  def apply() = new Person("default")
}

class Person2(firstName: String, var lastName: String)

class Person3(firstName: String, lastName: String) {
  println("initializing Person3")
  val fullName = s"$lastName, $firstName"
}

class Employee(name: String, age: Int) extends Person(name)

object PersonApp extends App {
  println("Again hello there!!!")

  val p1 = new Person("Sarath")
  println(p1.firstName)
  // p1.firstName = "Newname" // ERROR - immutable

  val p2 = new Person2("Sarath", "Kallatt Sivasankaran")
  println(p2.lastName)
  p2.lastName = "K S"
  println(p2.lastName)
  // println(p1.firstName) // ERROR - private access modifier

  val p3 = new Person3("Sarath", "Kallatt Sivasankaran")
  println(p3.fullName)
}
