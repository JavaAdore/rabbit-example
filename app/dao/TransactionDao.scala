package dao

import com.google.inject.Inject
import db.Tables
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc.AbstractController
import db.Tables.MyTransactions
import db.Tables.MyTransactionsRow
import db.Tables.profile.api._
import javax.inject.Singleton
import models.Transaction
import slick.model.ForeignKeyAction
// NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
import slick.jdbc.{GetResult => GR}

import slick.jdbc.JdbcProfile

import scala.concurrent.ExecutionContext

@Singleton
class TransactionDao @Inject() (protected val dbConfigProvider: DatabaseConfigProvider)(implicit ec: ExecutionContext)
  extends HasDatabaseConfigProvider[JdbcProfile]  {

  def addTransaction(transaction:Transaction) = {

   val action =  MyTransactions+=toTransactionRow(transaction)
    db.run(action)

   }

  def toTransactionRow(transaction: Transaction): _root_.db.Tables.MyTransactionsRow = {

    MyTransactionsRow(-1,BigDecimal.apply(transaction.amount) , Some(transaction.date))
  }



}
