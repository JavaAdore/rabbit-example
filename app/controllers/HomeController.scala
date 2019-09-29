package controllers

import com.typesafe.config.ConfigFactory
import config.RabbitConnection
import javax.inject._
import play.api._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(cc: ControllerComponents,rabbitConnection:RabbitConnection) extends AbstractController(cc) {


  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def environment = Action{
    val conf = ConfigFactory.load()
   val environment =  conf.getString("environment")
    Ok(s"current environment is $environment")
  }

  def rabbitConfigurationData:Action[AnyContent] = Action{
   val rabbitConfigurationData:JsValue =
     Json.obj("host"     -> rabbitConnection.rabbitHost,
                      "port"     -> rabbitConnection.rabbitPort,
                      "userName" -> rabbitConnection.rabbitUserName,
                      "password" -> rabbitConnection.rabbitPassword,
                      "test info"-> rabbitConnection.rabbitTestInfo
    )
     Ok(rabbitConfigurationData)
  }
}
