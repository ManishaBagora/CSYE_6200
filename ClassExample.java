import java.util.ArrayList;
public class ClassExample {
    public static void main(String[] args){
		
	   ArrayList<String> greetings = new ArrayList<String>();
	      greetings.add("Hello! How are you?");
		  greetings.add("Hi man, what's up!");
		  greetings.add("Yo! How's going?");
		  greetings.add("Hey! How are you doing?");
		  
		  System.out.println("All greetings!");
		  System.out.println("");
		  for(String s:greetings){
		      System.out.println(s);
			  }
			}
	}