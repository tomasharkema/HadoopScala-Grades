import java.util.TimeZone

import com.twitter.scalding._
import com.twitter.scalding.source.TypedText

object Schema extends Enumeration {
  val Loopbaan, `Nummer studiedeel`, Omschrijving, Toetsdatum, `Offic. cijfer` = Value // arbitrary number of fields
}

import Schema._

class WordCountJob(args: Args) extends Job(args) {
  implicit val tz = TimeZone.getDefault
  Csv(args("input"), separator = ",", fields = Schema, skipHeader = true)
    .read
    .project(Toetsdatum, `Offic. cijfer`)
    // Map cijfer string naar USA format en filter vold. uit
    .map(`Offic. cijfer` -> `Offic. cijfer`) { cijfer: String => cijfer.replaceAll(",", ".").replaceAll("vold.", "6") }
    // Map cijfer naar een Float
    .map(`Offic. cijfer` -> `Offic. cijfer`) { cijfer: Float => cijfer }

    // Map datum to right format
    .map(Toetsdatum -> Toetsdatum) { datum: String =>
      val components = datum.split("-")
      //06-11-15 => 2015-11-06
      RichDate(s"20${components(2)}-${components(1)}-${components(0)}")
    }
    .groupBy(Toetsdatum) { _.average(`Offic. cijfer`, `Offic. cijfer`) }
    .groupAll { _.sortBy(Toetsdatum) }
    .write(Tsv(args("output")))
}