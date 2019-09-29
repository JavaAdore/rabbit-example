package config


 import com.google.inject.Inject
 import com.rabbitmq.client.AMQP.BasicProperties
 import com.rabbitmq.client.{AMQP, Channel, Connection, ConnectionFactory}
 import javax.inject.Singleton
 import play.api.Configuration
 import play.api.libs.json.Json

@Singleton
class RabbitConnection @Inject()(config: Configuration)   {


   val rabbitHost:String     = config.get[String]("rabbit.host")
   val rabbitPort:Int        = config.get[Int]   ("rabbit.port")
   val rabbitUserName:String = config.get[String]("rabbit.userName")
   val rabbitPassword:String = config.get[String]("rabbit.password")
   val rabbitTestInfo:String = config.get[String]("rabbit.testInfo")

  private val factory = new ConnectionFactory

    factory.setHost(rabbitHost)
    factory.setPort(rabbitPort)
    factory.setUsername(rabbitUserName)
    factory.setPassword(rabbitPassword)


    val connection: Connection = factory.newConnection


    def createChannel:Channel = {
      connection.createChannel
    }

  def createBasicProperties:BasicProperties = {
    val basicPropertiesBuilder:BasicProperties.Builder = new BasicProperties.Builder
    val basicProperties: AMQP.BasicProperties=  basicPropertiesBuilder.build()
    basicProperties

  }


}



