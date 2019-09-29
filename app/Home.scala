import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Home  extends App {


  println(LocalDateTime.now.format(DateTimeFormatter.BASIC_ISO_DATE))
}
