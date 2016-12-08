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
class ImageViewController @Inject() extends Controller {

  def index(imageId: Long) = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def delete(password: long) = Action {
    //Look up password and delete image
    
  }

}
