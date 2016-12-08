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
class ImageCensorController @Inject() extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def upload = Action(parse.multipartFormData) { request =>
    request.body.file("image").map { image =>
      import java.io.File
      val filename = image.filename
      //Generate some unique id.
      val imageId: Long = 1
      val contentType = image.contentType
      image.ref.moveTo(new File(s"/tmp/faceblock/inprogress/$imageId"))

      Redirect(routes.ImageCensorController.index(imageId))
    }.getOrElse {
      Redirect(routes.ImageUploadController.index).flashing(
        "error" -> "Missing file")
    }
  }
}
