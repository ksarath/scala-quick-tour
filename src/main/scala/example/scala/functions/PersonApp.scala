package example.scala.functions

import scala.annotation.tailrec

// Functions, High-order functions, Closures

object PersonApp extends App {
  def doSomethingV1(input1: String, input2: Int): String = {
    // some calculation
    s"$input1 $input2"
  }

  def doSomethingV2(input1: String)(input2: Int): String = {
    // some calculation
    s"$input1 $input2"
  }

  val doSomethingV3: (String, Int) => String =
    (input1, input2) => {
      // some calculation
      s"$input1 $input2"
    }

  val doSomethingV4: String => Int => String =
    input1 => input2 => {
      // some calculation
      s"$input1 $input2"
    }

  val doSomethingV5 =
    (input1: String, input2: Int) => {
      // some calculation
      s"$input1 $input2"
    }

  println(doSomethingV1("abc", 1))
  println(doSomethingV2("abc")(1))
  println(doSomethingV3("abc", 1))
  println(doSomethingV4("abc")(1))
  println(doSomethingV5("abc", 1))


  def higherOrderV1(fn: Int => String, input: Int): String =
    fn(input)

  def higherOrderV2(fn1: Int => String, fn2: String => String): Int => String =
    fn1.andThen(fn2)

  def higherOrderV3(fn1: Int => String, fn2: String => String): Int => String =
    input => fn2(fn1(input))


  println(higherOrderV1(_.toString, 32)) // v => v.toString
  println(higherOrderV2(_.toString, v => s"$v something"))
  println(higherOrderV2(_.toString, v => s"$v something")(32))
  println(higherOrderV3(_.toString, v => s"$v something"))
  println(higherOrderV3(_.toString, v => s"$v something")(32))


  def closureV1(from: Int, to: Int): List[Int] = {
    @tailrec
    def addNext(input: Int, prevList: List[Int] = Nil): List[Int] = {
      if (input > to) prevList
      else addNext(input + 1, prevList :+ input)
    }

    addNext(from)
  }

  println(closureV1(10, 20))

  // Partial Functions
  val getUserEndPoint: PartialFunction[String, String] = {
    case x if x.contains("GET /users/") => s"This is Sarath"
  }
}
