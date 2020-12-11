package example.scala.parallel

import scala.concurrent.Future
import scala.util.{Failure, Success}

// Futures

import scala.concurrent.ExecutionContext.Implicits.global

object PersonApp extends App {
  val someParallelOp = Future {
    println("fetching results")
    5
  }

  val someParallelSomeOtherOp = Future {
    println("fetching results")
    10
  }

  val result = for {
    result1 <- someParallelOp
    result2 <- someParallelSomeOtherOp
  } yield result1 * result2


  // Same as Try
  // Use map, flatMap, fold, recover, recoverWith, pattern match on onComplete etc
  val result2 = result.map(_ * 10)
  val result3 = result.flatMap(v => Future { v * 6})
  val result4 = result.recoverWith(_ => Future {10})

  result.onComplete {
    // We generally don't use this method since its return type is Unit,
    // in akka / mutable code / at the end of an API endpoint (for sending back the response) etc you might see this type of code
    case Success(value) => println(value)
    case Failure(ex) => println(ex.getMessage)
  }

  println(result)
  println(result.value)
  Thread.sleep(1000)
  println(result)
  println(result.value)
}
