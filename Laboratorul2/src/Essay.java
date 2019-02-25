import java.time.LocalDate;

public class Essay extends Project {
    
	Topic topic;
	public Essay(String name, LocalDate localDate, Topic algorithms)
	{
     setName(name);
	setDeadline(localDate);
	this.topic=algorithms;	
	}
	
	public String toString() { 
	    return name+" "+deadline+" "+topic;
	} 
	
	 
}
