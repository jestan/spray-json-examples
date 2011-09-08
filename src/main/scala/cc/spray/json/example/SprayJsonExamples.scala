package cc.spray.json.example

import cc.spray.json._


object EnumSex extends Enumeration {
  type Sex = Value
  val MALE = Value("MALE")
  val FEMALE = Value("FEMALE")
}

case class Address(no: String, street: String, city: String)

case class Person(name: String, age: Int, sex: EnumSex.Sex, address: Address)

object SprayJsonExamples {
  def main(args: Array[String]) {
    val json = """{ "no": "A1", "street" : "Main Street", "city" : "Colombo" }"""
    val address = JsonParser(json).fromJson[Address]
    println(address)

    val json2 = """{ "name" : "John", "age" : 26,  "sex" : 0 , "address" : { "no": "A1", "street" : "Main Street", "city" : "Colombo" }}"""

    val person = JsonParser(json2).fromJson[Person]
    println(person)
  }
}
