import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;


public class Problem {
private List<Student> students;
  public Problem() {
	  
	  students=new ArrayList<Student>();
  }
  
void setStudents(Student s1, Student s2, Student s3,Student s4)
  {
	  
	  students.add(s1);
	  students.add(s2);
	  students.add(s3);
	  students.add(s4);
  }
  void setStudents(Student s)
  {
	  students.add(s);
  }
  void getStudents()
  {
	  
	  ListIterator it = students.listIterator(); 
	  while(it.hasNext())
	  {
		  Student s=(Student)it.next();
		  System.out.println(s.getName());
	  }
	  
	  
  }
  
}
