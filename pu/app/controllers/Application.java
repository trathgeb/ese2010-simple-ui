package controllers;
import java.util.ArrayList;

import models.*;
import play.db.zdb.ZDBModel.ZDBModelBucket.Find;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)

public class Application extends Controller {

	static Main main = Bootstrap.main;
    public static void index() {
    	ArrayList<Question> questions = main.getQuestions();
        render(questions, main);
    }
    
    public static void voteUpQuestion(Question q){
    	q.vote ++;
    	renderJSON(q);
//    	render(question);
    	
    }
    
    public static void voteDownQuestion(Question q){
    	q.vote --;
    	renderJSON(q);
//    	render(question);
    	
    }
    
    public static void voteUpAnswer(Answer a){
    	a.vote ++;
    	renderJSON(a);
    }
    
    public static void voteDownAnswer(Answer a){
    	a.vote --;
    	renderJSON(a);
    }
    

    public static void addQuestion(String content){
    	Security.currentUser.ask(content);
    	ArrayList<Question> questions = main.getQuestions();
    	render(questions);
    }
    
    public static void answer(String content, Question q){
    	Security.currentUser.answer(q, content);
    	
    	render();
    }
    
    public static void display(Question q){
    	
    	render(q);
    }

}