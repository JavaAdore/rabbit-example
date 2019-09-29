package config

import java.time.LocalDateTime

import com.rabbitmq.client.{Channel, Connection, ConnectionFactory, ConsumerShutdownSignalCallback, DeliverCallback, Delivery, ShutdownSignalException}
import com.typesafe.config.{Config, ConfigFactory}
import db.Tables._
import play.api.libs.json.Json

object Home  extends App{

  println(Json.toJson(LocalDateTime.now.toString))
}
