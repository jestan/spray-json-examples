package cc.spray.json

import cc.spray.json._

package object example {

  import DefaultJsonProtocol._

  implicit val addressFormat = jsonFormat(Address, "no", "street", "city")
  implicit val sexJsonFormat = new JsonFormat[EnumSex.Sex] {
    def write(sex: EnumSex.Sex) = JsField("sex", sex.id)

    def read(value: JsValue) = value match {
      case JsNumber(sex) => EnumSex(sex.toInt)
      case _ => throw new DeserializationException("person.sex expected")
    }
  }

  implicit val personFormat = jsonFormat(Person, "name", "age", "sex", "address")
}