package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class ImageCensorontroller @Inject() extends Controller {

  def index(imageId: Long) = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def save(imageId: Long) = Action(parse.multipartFormData) { request =>
    request.body.file("image").map { image =>
      import java.io.File

      image.ref.moveTo(new File(s"/tmp/faceblock/completed/$imageId"))

      Redirect(routes.ImageViewController.index(imageId))
    }.getOrElse {
      Redirect(routes.ImageCensorController.index).flashing(
        "error" -> "Missing file")
    }
  }
}
