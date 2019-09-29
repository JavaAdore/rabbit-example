package controllers


import com.rabbitmq.client.AMQP
import com.rabbitmq.client.AMQP.BasicProperties
import com.rabbitmq.client.AMQP.BasicProperties.Builder
import com.typesafe.config.ConfigFactory
import config.RabbitConnection
import dao.TransactionDao
import javax.inject._
import models.Transaction
import play.api._
import play.api.libs.json.Json
import play.api.mvc._
import service.TransactionService
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.{ExecutionContext, Future}
import util._
/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class TransactionController  @Inject()(cc: ControllerComponents, transactionService: TransactionService) extends AbstractController(cc) {

  def addTransaction = Action.async(parse.json) { implicit request => {
      Future{
          val transactionAsString = Json.stringify(request.body)
          val transaction:Transaction =  Json.parse(transactionAsString).as[Transaction]
          transactionService.processTransaction(transaction)
          Ok("transaction will be processed shortly")
      }
    }
  }

}
