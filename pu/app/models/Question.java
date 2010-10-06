package models;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Question {

	public Main main;
	public String content;
	public ArrayList<Answer> answers;
	public User user;
	public String date;
	public int vote = 0;
	public Question self=this;
	SimpleDateFormat formatter = new SimpleDateFormat("yy.dd.MM  HH:mm:ss ");

	public Question(String content) {
		this.content = content;
		answers = new ArrayList<Answer>();

		Date currentTime = new Date();
		date = formatter.format(currentTime);

	}

	public void addAnswer(Answer answer) {
		answers.add(answer);
	}

	public void delete() {
		main.removeQuestion(this);

	}

	public void removeAnswer(Answer answer) {
		answers.remove(answer);

	}

	public void setMain(Main main) {
		this.main = main;

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


	public ArrayList<Answer> getAnswers() {
		return answers;
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
