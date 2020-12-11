package example.scala.collections

import scala.collection.immutable.Queue

// Collections & Arrays
// Array is invariant in Scala, Java it is covariant which can lead to runtime exceptions
// List, Seq, Set, Map, Vector, Queue, LazyList (Old name = Stream)
// There are mutable version of collection - But just ignore, you don't need it

object PersonApp extends App {
  // Vector is little faster and efficient
  // But late to Scala and pattern match
  // adding to the head is a little slow compared to List
  // List -> cons operator

  // Common and useful methods:
  // map, flatMap, filter, find, findLast, fold, foldLeft, reduce, reduceLeft etc..

  // Change `Array` in below code to List, Seq, Set, Vector, Queue & LazyList
  val array1 = Array(1, 2, 3, 4)
  val array2 = array1.map(v => v * 2)
  val array3 = array1.map(v => Array(v, v * 2))
  val array4 = array1.flatMap(v => Array(v, v * 2)) // array3.flatten
  val array5 = array1.find(v => v == 2)
  val array6 = array1.fold(5)((a, b) => a * b)
  val array7 = array1.fold(5)(_ * _)
  val array8 = array1.foldLeft("")(_ + _)
  val array9 = array1.reduce(_ * _)
  val array10 = array1.reduceLeft(_ * _)

  println(array1.mkString("[", ", ", "]"))
  println(array2.mkString("[", ", ", "]"))
  println(array3.map(_.mkString("[", ", ", "]")).mkString("[", ", ", "]"))
  println(array4.mkString("[", ", ", "]"))
  println(array5)
  println(array6)
  println(array7)
  println(array8)
  println(array9)
  println(array10)



  // in List you can also prepend / add to the head using cons operator
  1 :: List(2, 3, 4)

  val array11 = array1 :+ 10
  val array12 = array1 diff Array(1, 2)
  val array13 = array1 ++ Array(10, 11)
  val headElem = array1.head // fail with NPE for Empty collection
  val headElemOption = array1.headOption
  val tailArray = array1.tail

  println(array11.mkString("[", ", ", "]"))
  println(array12.mkString("[", ", ", "]"))
  println(array13.mkString("[", ", ", "]"))
  println(headElem)
  println(headElemOption)
  println(tailArray.mkString(", "))




  val map1 = Map(1 -> 1, 2 -> 2, 3 -> 3, 4 -> 4)
  val map2 = map1.map{ case(key, value) => key -> value * 2 }
  val map3 = map1.map(v => v._1 -> Map(v._1 -> v._2 * 2))
  val map4 = map1.flatMap { case (key, value) => Map(key -> value * 2) } // map3.flatten
  val map5 = map1.find(_._1 == 2)
  val map6 = map1.fold((5, 5)) { case ((k1, v1), (k2, v2)) => (k1 * k2, v1 * v2) }
  val map7 = map1.foldLeft(5)(_ * _._2)
  val map8 = map1.reduce((a, b) => (a._1 * b._1, a._2 * b._2))
  val map9 = map1.reduceLeft[(Int, Int)]{ case ((k1, v1), (k2, v2)) => (k1 * k2, v1 * v2) }

  println(map1)
  println(map2)
  println(map3)
  println(map4)
  println(map5)
  println(map6)
  println(map7)
  println(map8)
  println(map9)

  val map10 = map1 + (10 -> 10)
  val map11 = map1 - 1
  val map12 = map1 -- Seq(1, 2)
  val map13 = map1 ++ Map(10 -> 10)
  val mapHead = map1.head // fail with NPE for Empty collection
  val mapHeadOption = map1.headOption
  val mapTail = map1.tail

  println(map10)
  println(map11)
  println(map12)
  println(map13)
  println(mapHead)
  println(mapHeadOption)
  println(mapTail)
}
