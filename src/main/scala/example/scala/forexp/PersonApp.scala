package example.scala.forexp

object PersonApp extends App {
  for(i <- 1 to 10) {
    print(i + " ")
  }
  println()

  for(
    i <- 1 to 10 if i % 2 == 0;
    j <- 1 to 10 if j % 3 == 0
  ) {
    print(i + j + " ")
  }
  println()

  // 99% of usage
  val results = for {
    i <- 1 to 10 if i % 2 == 0
    j <- 1 to 10 if j % 3 == 0
  } yield i + j
  println(results)

  case class Person(id: Int, name: String, addressId: Int)
  case class Address(id: Int, cityId: Int)
  case class City(id: Int, name: String)

  val getPersonById: Int => Option[Person] = id => Option(Person(id, "name", 2000))
  val getAddressById: Int => Option[Address] = id => Option(Address(id, 15000))
  val getCityById: Int => Option[City] = id => Option(City(id, "London"))

  val cityName: Option[String] = for {
    person    <- getPersonById(100)
    address   <- getAddressById(person.addressId)
    city      <- getCityById(address.cityId)
  } yield city.name

  println(cityName)

  val getPersonById1: Int => Either[String, Person] = id => Right(Person(id, "name", 2000))
  val getAddressById1: Int => Either[String, Address] = id => Right(Address(id, 15000))
  val getCityById1: Int => Either[String, City] = id => Right(City(id, "London"))

  val cityName1: Either[String, String] = for {
    person    <- getPersonById1(100)
    address   <- getAddressById1(person.addressId)
    someVal   = "City: "
    city      <- getCityById1(address.cityId)
  } yield someVal + city.name

  println(cityName1)

  // while - I have never used it in Scala
  var i = 1
  while(i < 10) {
    print(i)
    i = i + 1
  }
}
