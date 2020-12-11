package example.scala.lazyeval

object PersonApp extends App {
  lazy val p = {
    println("initializing p")
    "I am ready"
  }

  def callByNameEx1(op: => String) = {
    println("Inside callByNameEx1:")
    callByNameEx2(op)
  }

  def callByNameEx2(op: => String) = {
    println("Inside callByNameEx2:")
    println(op)
  }

  callByNameEx1 {
    println("doing some heavy calcluation")
    "Succeeded in getting the result"
  }

  println(p)
}
