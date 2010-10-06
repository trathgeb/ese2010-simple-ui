package models;
import java.util.ArrayList;

public class Main {
	private ArrayList<User> users;
	private ArrayList<Question> questions;

	public Main() {
		users = new ArrayList<User>();
		questions = new ArrayList<Question>();
	}

	public void addUser(User user) {
		users.add(user);
		user.setMain(this);
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void addQuestion(Question question) {
		questions.add(question);
		question.setMain(this);
	}

	public void removeQuestion(Question question) {
		questions.remove(question);

	}

	public void deleteUser(User user) {
		users.remove(user);
		for (Question q : user.getQuestions()) {
			questions.remove(q);
		}

		for (Answer a : user.getAnswers()) {
			a.getQuestion().getAnswers().remove(a);
		}

	}

	public ArrayList<User> getUsers() {
		return users;
	}

}
