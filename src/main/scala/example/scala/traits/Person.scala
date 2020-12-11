package example.scala.traits

import com.typesafe.scalalogging.LazyLogging

// Traits & Mixins

sealed trait Person {
  def firstName: String
  def lastName: String
  val fullName = s"$lastName, $firstName"
}

trait PrettyPrint {
  self: Person =>
    def print: String = self.fullName
}

case class Employee(firstName: String, lastName: String) extends Person

case class Manager(firstName: String, lastName: String, employees: List[Employee] = Nil) extends Person {
  override val fullName: String = s"$firstName (Manager)"
}

case class MixinExample(firstName: String, lastName: String) extends Person with PrettyPrint with LazyLogging {
  override def print: String = {
    logger.info(s"$lastName, $firstName")
    s"""{
       |"firstName": "$firstName",
       |"lastName": "$lastName"
       |}""".stripMargin
  }
}