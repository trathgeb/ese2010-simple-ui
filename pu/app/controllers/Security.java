package controllers;
import java.util.Iterator;

import models.*;

public class Security  extends Secure.Security{
    
	public static User currentUser;
	
    static boolean authenticate(String username, String password) {
        User user = null;
    
        
	    
        if(!Bootstrap.main.getUsers().isEmpty()){
	        for(User u : Bootstrap.main.getUsers()){
	        	if(u.getName().equals(username))
	        		user=u;
	        }
        }
        
        currentUser = user;
        return user != null && user.getPassword().equals(password);


    }    
    
}

