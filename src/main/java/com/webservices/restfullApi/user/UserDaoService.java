
package com.webservices.restfullApi.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	
	private static ArrayList<User> users = new ArrayList<User>(); 
	
	private static int count = 0; 
	
	static {
		
		users.add(new User(++count, "Evariste", LocalDate.now().minusYears(30))); 
		users.add(new User(++count, "Hervé", LocalDate.now().minusYears(29))); 

		users.add(new User(++count, "Manu", LocalDate.now().minusYears(28))); 

		
	}
	
	
   public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		UserDaoService.count = count;
	}

public List<User> getUsers() {
		
		  return  users ; 
	    }
	  
	  public User findOne(int id) {
		  
		  Predicate<? super User> predicate = user -> user.getId().equals(id); 
		  
		 return  users.stream().filter(predicate).findFirst().orElse(null); 
	  }
	  
	  public User saveUser(User user) {
		user.setId(++count);
	    users.add(user); 
	    return user ; 
	  }
	  
	  
	  public void deleteById(int id)
	  {
		  Predicate<? super User> predicate = user   -> user.getId().equals(id); 
		  users.removeIf(predicate); 
	  }
	  
	  
	

}
