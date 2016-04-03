package controllers;

import java.util.List;

import javax.inject.Inject;

import com.avaje.ebean.Model;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.signup;
import views.html.users;


public class UserController extends Controller {
	@Inject
	FormFactory formFactory;
	
	private Model.Find<Long, User> find = new Model.Find<Long, User>(){};
	
	/*
	 * ユーザの作成
	 */
	public Result create() {
		Form<User> userForm = formFactory.form(User.class).bindFromRequest();
		
		if(userForm.hasErrors()){
			return badRequest(signup.render("ERROR", formFactory.form(User.class)));
		}else{
			User user = userForm.get();
			user.save();
			return redirect(routes.HomeController.index());
		}
	}

	public Result signup() {
		return ok(signup.render("hello", formFactory.form(User.class)));
	}
	
	public Result users() {
		List<User> userList = find.all();
		return ok(users.render(userList));
	}
}
