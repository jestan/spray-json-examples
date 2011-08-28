import cc.spray.json._

object Sex extends Enumeration {
  type Sex = Value
  val MALE = Value("MALE")
  val FEMALE = Value("FEMALE")
}

case class Person(name: String, age: Int, sex: Sex.Sex , address: Address)

object PersonProtocol extends DefaultJsonProtocol {

  import AddressProtocol._

  implicit object PersonJsonFormat extends JsonFormat[Person] {
    def write(person: Person) = {
      JsObject(List(JsField("name", person.name),  JsField("age", person.age), JsField("sex", person.sex.id), JsField("address", person.address.toJson)))
    }

    def read(value: JsValue) = value match {
      case JsObject(List(JsField("name", JsString(name)), JsField("age", JsNumber(age)), JsField("sex", JsNumber(sex)), JsField("address", address))) => {
        Person(name, age.toInt, Sex(sex.toInt), address.fromJson[Address])
      }
      case _ => throw new DeserializationException("Person expected")
    }
  }

}