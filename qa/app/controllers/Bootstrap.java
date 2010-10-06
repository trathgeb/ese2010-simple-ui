package controllers;

import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

@OnApplicationStart
public class Bootstrap extends Job {

	public static Main main;
	public static User user1;
	public static User user2;

	public void doJob() {
		main = main.getInstanceOf();
		user1 = new User("Bob", "1");
		user2 = new User("Ale", "2");
		main.addUser(user1);
		user1.ask("what?");
		user1.ask("why?");

		user1.answer(main.getQuestions().get(0), "Dont know!");
		user2.answer(main.getQuestions().get(1), "Cant help!");
		
		

	}

}
