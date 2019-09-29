package listener

import com.google.inject.{AbstractModule, Inject, Module}
import com.rabbitmq.client.{Channel, Connection, ConsumerShutdownSignalCallback, DeliverCallback, Delivery, ShutdownSignalException}
import config.RabbitConnection
import dao.TransactionDao
import javax.inject.Singleton
import models.Transaction
import play.api.libs.json.{JsValue, Json}
import service.TransactionService
import util.SerializationUtils

@Singleton
class TransactionListener @Inject()(rabbitConnection:RabbitConnection , transactionDao:TransactionDao)  {

    var channel: Channel= rabbitConnection.createChannel

    var deliverCallback:DeliverCallback = (consumerTag: String, message: Delivery) =>{
      var messageBody:Array[Byte] = message.getBody

       val transaction:Transaction =  SerializationUtils.deserialize[Transaction](messageBody)
      if(transaction!=null)
        {
          transactionDao.addTransaction(transaction)
        }
     }

    var consumerShutdownSignalCallback:ConsumerShutdownSignalCallback = (consumerTag: String, sig: ShutdownSignalException) =>{}

   channel.basicConsume("add-transaction-queue",true,deliverCallback,consumerShutdownSignalCallback)

}
