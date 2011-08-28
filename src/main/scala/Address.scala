import cc.spray.json._

case class Address(no: String, street: String, city: String)

object AddressProtocol extends DefaultJsonProtocol {

  implicit object AddressJsonFormat extends JsonFormat[Address] {
    def write(address: Address) = {
      JsObject(List(JsField("no", address.no), JsField("street", address.street), JsField("city", address.city)))
    }

    def read(value: JsValue) = value match {
      case JsObject(List(JsField("no", JsString(no)), JsField("street", JsString(street)), JsField("city", JsString(city)))) => {
        new Address(no, street, city)
      }
      case _ => throw new DeserializationException("Address expected")
    }
  }

}