package db
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.PostgresProfile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription =   MyTransactions.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema


  /** Entity class storing rows of table MyTransactions
   *  @param id Database column id SqlType(bigserial), AutoInc, PrimaryKey
   *  @param tAmount Database column t_amount SqlType(numeric)
   *  @param tDate Database column t_date SqlType(timestamptz), Default(None) */
  case class MyTransactionsRow(id: Long , tAmount: scala.math.BigDecimal, tDate: Option[java.time.LocalDateTime] = None)
  /** GetResult implicit for fetching MyTransactionsRow objects using plain SQL queries */
  implicit def GetResultMyTransactionsRow(implicit e0: GR[Long], e1: GR[scala.math.BigDecimal], e2: GR[Option[java.time.LocalDateTime]]): GR[MyTransactionsRow] = GR{
    prs => import prs._
    MyTransactionsRow.tupled((<<[Long], <<[scala.math.BigDecimal], <<?[java.time.LocalDateTime]))
  }
  /** Table description of table my_transactions. Objects of this class serve as prototypes for rows in queries. */
  class MyTransactions(_tableTag: Tag) extends profile.api.Table[MyTransactionsRow](_tableTag, "my_transactions") {
    def * = (id, tAmount, tDate) <> (MyTransactionsRow.tupled, MyTransactionsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = ((Rep.Some(id), Rep.Some(tAmount), tDate)).shaped.<>({r=>import r._; _1.map(_=> MyTransactionsRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column id SqlType(bigserial), AutoInc, PrimaryKey */
    val id: Rep[Long] = column[Long]("id", O.AutoInc, O.PrimaryKey)
    /** Database column t_amount SqlType(numeric) */
    val tAmount: Rep[scala.math.BigDecimal] = column[scala.math.BigDecimal]("t_amount")
    /** Database column t_date SqlType(timestamptz), Default(None) */
    val tDate: Rep[Option[java.time.LocalDateTime]] = column[Option[java.time.LocalDateTime]]("t_date", O.Default(None))
  }
  /** Collection-like TableQuery object for table MyTransactions */
  lazy val MyTransactions = new TableQuery(tag => new MyTransactions(tag))

 }
