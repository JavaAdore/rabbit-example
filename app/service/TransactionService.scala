package service

import java.time.LocalDateTime

import com.google.inject.Inject
import config.RabbitConnection
import javax.inject.Singleton
import models.{InvalidTransaction, Transaction}
import publisher.TransactionPublisher

@Singleton
class TransactionService  @Inject()(transactionPublisher: TransactionPublisher ){

  def processTransaction(transaction: Transaction) = {

    if(transaction.date.isAfter(LocalDateTime.now))
      {
        Left(InvalidTransaction("`invalid transaction date`", transaction))
      }else
      {
        transactionPublisher.publishAddTransaction(transaction)
        Right(transaction)
      }

  }

}
