package models;

import java.util.ArrayList;

public class User {

	private String name;
	private String password;
	private ArrayList<Question> questions;
	private ArrayList<Answer> answers;
	private ArrayList<Question> votedQuestions;
	private Main main;

	public User(String name, String pw) {
		this.name = name;
		password = pw;
		questions = new ArrayList<Question>();
		votedQuestions = new ArrayList<Question>();
		answers = new ArrayList<Answer>();
	}

	public void ask(String ask) {
		Question question = new Question(ask);
		question.setUser(this);
		main.addQuestion(question);
		questions.add(question);
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public void answer(Question question, String ans) {
		Answer answer = new Answer(ans, question);
		answer.setUser(this);
		answers.add(answer);

	}

	public void delete() {
		main.deleteUser(this);
		answers.clear();
		questions.clear();

	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public String getName() {
		return name;
	}

	public void voteUp(Answer a) {
		a.votedUp();
	}

	public void voteUp(Question q) {
		if (!votedQuestions.contains(q)) {
			votedQuestions.add(q);
			q.vote++;
		}
	}

	public void voteDown(Answer a) {
		a.votedDown();
	}

	public void voteDown(Question q) {
		if (!votedQuestions.contains(q)) {
			votedQuestions.add(q);
			q.vote--;
		}
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
}
