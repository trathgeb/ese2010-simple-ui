package controllers;

import java.util.ArrayList;

import models.*;

import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Application extends Controller {

	static Main main = Bootstrap.main;

	public static void index() {
		ArrayList<Question> questions = main.getQuestions();
		java.util.Collections.sort(questions);
		render(questions, main);
	}

	public static void voteUpQuestion(int ID) {
		for (Question q : main.getQuestions()) {
			if (q.ID == ID) {
				Security.currentUser.voteUp(q);
			}
		}

		index();

	}

	public static void voteDownQuestion(int ID) {
		for (Question q : main.getQuestions()) {
			if (q.ID == ID) {
				Security.currentUser.voteDown(q);
			}
		}

		index();

	}

	public static void addQuestion(String content) {
		Security.currentUser.ask(content);
		index();
	}

	public static void answer(int ID, String content) {

		for (Question q : main.getQuestions()) {
			if (q.ID == ID) {
				Security.currentUser.answer(q, content);
			}
		}

		index();
	}

}