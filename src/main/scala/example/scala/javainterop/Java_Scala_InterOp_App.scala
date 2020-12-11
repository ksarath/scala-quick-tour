package example.scala.javainterop

import example.java.JavaClass

import scala.jdk.CollectionConverters.SeqHasAsJava

object Java_Scala_InterOp_App extends App {
  val javaObject = new JavaClass("SomeMessage")
  println(javaObject.getMessage)
  println(javaObject.appendMessages(List("this is from scala").asJava))
  println(javaObject.getMessages)

  println(javaObject.addMessagesFromScalaClass())
  println(javaObject.getMessages)
}
