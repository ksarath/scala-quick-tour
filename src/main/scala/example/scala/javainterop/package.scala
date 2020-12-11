package example.scala

import java.util.{List => JList}

import scala.jdk.CollectionConverters._

package object javainterop {
  def toJavaList[A](list: List[A]): JList[A] =
    list.asJava
}
