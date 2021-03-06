package de.leanovate.swaggercheck.fixtures.uber

import org.scalacheck.{Arbitrary, Gen}
import play.api.libs.json.Json

case class UberError(
                  code: Option[Int],
                  message: Option[String],
                  fields: Option[String]
                  )

object UberError {
  implicit val jsonFormat = Json.format[UberError]

  implicit val arbitrary = Arbitrary(for {
    code <- Gen.option(Gen.choose(400, 599))
    message <- Gen.option(Gen.alphaStr)
    fields <- Gen.option(Gen.identifier)
  } yield UberError(code, message, fields))
}