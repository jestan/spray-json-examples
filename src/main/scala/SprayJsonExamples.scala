import cc.spray.json._

object SprayJsonExamples {

  import AddressProtocol._
  import PersonProtocol._

  def main(args: Array[String]) = {
    val json = """{ "no": "A1", "street" : "Main Street", "city" : "Colombo" }"""
    val address = JsonParser(json).fromJson[Address]
    println(address)

    val json2 = """{ "name" : "John", "age" : 26,  "sex" : 0 , "address" : { "no": "A1", "street" : "Main Street", "city" : "Colombo" }}"""

    val person = JsonParser(json2).fromJson[Person]
    println(person)
  }
}
