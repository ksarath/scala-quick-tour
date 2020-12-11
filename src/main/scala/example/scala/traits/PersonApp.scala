package example.scala.traits

object PersonApp extends App {
  val p1 = Employee("Sarath", "Kallatt Sivasankaran")
  val p2 = Manager("Kasper", "Schipper", List(p1))
  val p3 = MixinExample("Sarath", "Kallatt Sivasankaran")

  println(p1)
  println(p2)

  val p4: Person = p3
  val result = p4 match {
    case Employee("Sarath", _) => "Hi Sarath"
    case _: Employee => "an employee"
    case p: Manager => s"${p.firstName} - a manager"
    case p: MixinExample => p.print
  }
  println(result)
}
