package models

import java.time.LocalDateTime

import play.api.libs.json.{Format, JsResult, JsValue, Json, Reads}
import play.api.libs.json.Reads._
case class Transaction(amount:Double,date:LocalDateTime) extends Serializable

object Transaction{
  implicit val readers = Json.reads[Transaction]
  implicit val localDateFormat = new Format[LocalDateTime] {
    override def reads(json: JsValue): JsResult[LocalDateTime] =
      json.validate[String].map(LocalDateTime.parse)

    override def writes(o: LocalDateTime): JsValue = Json.toJson(o.toString)

  }
}


