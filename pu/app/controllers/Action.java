package controllers;
import java.util.ArrayList;

import models.*;
import play.mvc.Controller;
import play.mvc.With;

public class Action  extends Controller{
	
    public static void voteUpQuestion(Question q){
    	Security.currentUser.voteUp(q);
//    	render(q);
    }

}
