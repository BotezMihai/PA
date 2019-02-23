import java.util.List;

public class Student {
  private String name;
  private int yearOfStudy;
  private List<Project> preferences;
  private Project enrollment;
  public Student(String name, int year)
  {
	  this.name=name;
	  yearOfStudy=year;
	  
	  
	  
  }
  void setPreferences(Project a)
  {
	  preferences.add(a);
	  
  }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getYearOfStudy() {
	return yearOfStudy;
}
public void setYearOfStudy(int yearOfStudy) {
	this.yearOfStudy = yearOfStudy;
}
  
}
