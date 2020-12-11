package example.scala.javainterop

import java.util.{List => JList}

import scala.jdk.CollectionConverters._

case class MessagesEx(messages: List[String])

object MessagesEx {
  def fromJava(messages: JList[String]): MessagesEx =
    MessagesEx(messages.asScala.toList)

  def toJavaList[A](list: List[A]): JList[A] =
    list.asJava
}
