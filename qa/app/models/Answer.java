package models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Answer {

	public String content;
	public Question question;
	public User user;
	public String date;
	public int vote = 0;
	SimpleDateFormat formatter = new SimpleDateFormat("yy.dd.MM HH:mm:ss ");

	public Answer(String content, Question question) {
		this.content = content;
		this.question = question;
		question.getAnswers().add(this);

		Date currentTime = new Date();
		date = formatter.format(currentTime);
	}

	public void votedUp() {
		vote++;
	}

	public void votedDown() {
		vote--;
	}

	public int getVote() {
		return vote;
	}

	public void delete() {
		question.removeAnswer(this);
	}

	public Question getQuestion() {
		return question;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public String getContent() {
		return content;
	}

	public String getDate() {
		return date;
	}

}
