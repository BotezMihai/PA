import java.time.LocalDate;

public class Essay extends Project {
    
	Topic topic;
	public Essay(String name, LocalDate localDate, Language lang)
	{
     setName(name);
	setDeadline(localDate);
	this.topic=topic;	
	}
}
