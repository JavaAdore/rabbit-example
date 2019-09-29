package publisher

import config.RabbitConnection
import constant.Constants
import javax.inject.{Inject, Singleton}
import models.Transaction
import util.SerializationUtils

@Singleton
class TransactionPublisher @Inject()(rabbitConnection: RabbitConnection) {

  val channel = rabbitConnection.createChannel

  def publishAddTransaction(transaction:Transaction):Unit =
  {
    val transactionAsByteArray:Array[Byte] = SerializationUtils.serialize(transaction)
    channel.basicPublish(Constants.TRANSACTION_EXCHANGE_NAME, Constants.ADD_TRANSACTION_ROUTING_KEY, rabbitConnection.createBasicProperties,transactionAsByteArray)
  }


}
