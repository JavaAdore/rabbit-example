package models

import java.time.LocalDateTime

class InvalidTransaction (reason:String ,override val amount:Double, override val date:LocalDateTime) extends Transaction(amount , date){}

object InvalidTransaction {
  def apply( reason: String, transaction: Transaction ): InvalidTransaction = {
    new InvalidTransaction(reason, transaction.amount, transaction.date)
  }
}