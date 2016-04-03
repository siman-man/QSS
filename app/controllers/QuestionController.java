package controllers;

import java.util.List;

import javax.inject.Inject;

import com.avaje.ebean.Model;

import models.Question;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.input;
import views.html.questions;


public class QuestionController extends Controller {
	@Inject
	FormFactory formFactory;
	
	private Model.Find<Long, Question> find = new Model.Find<Long, Question>(){};
	
	/*
	 * 質問の作成
	 */
	public Result create() {
		Form<Question> questionForm = formFactory.form(Question.class).bindFromRequest();
		
		if(questionForm.hasErrors()){
			return badRequest(input.render("ERROR", formFactory.form(Question.class)));
		}else{
			Question question = questionForm.get();
			question.save();
			return redirect(routes.QuestionController.questions());
		}
	}

	public Result input() {
		return ok(input.render("hello", formFactory.form(Question.class)));
	}
	
	public Result questions() {
		List<Question> questionList = find.all();
		return ok(questions.render(questionList));
	}
}
