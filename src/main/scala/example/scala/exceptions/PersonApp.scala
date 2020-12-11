package example.scala.exceptions

import scala.util.{Failure, Success, Try}

object PersonApp extends App {
  // Java way works
  // try {} catch() {} finally {}
  // throw ex; throws Exception etc

  // Scala way
  val div: (Int, Int) => Double = (a, b) => a / b

  val resultOfDiv: Try[Int] =
    Try(div(38, 0)).
      map(_.toInt).
      recover(_ => 0) // recoverWith in case you have an alternate option to try out

  resultOfDiv.recoverWith(_ => Try(0))

  println(resultOfDiv)
  println(resultOfDiv.isSuccess) // Better way is to pattern match
  println(resultOfDiv.isFailure) // Better way is to pattern match

  val result = resultOfDiv match {
    case Success(value) => value
    case Failure(exception) =>
      exception.printStackTrace()
      0
  }

  println(result)

  // You can also convert Try to Option or Either
  println(resultOfDiv.toOption)
  println(resultOfDiv.toEither)

  // if you want to map over failure
  println(
    resultOfDiv.failed.map {
      case ex: RuntimeException => s"Failed with error: ${ex.getMessage}"
      case _: NullPointerException => s"NPE - What?"
    }
  )
  println(resultOfDiv.fold(_ => 0, v => v))

  println(Try(2).flatMap(v => Try(v *2)))
}
