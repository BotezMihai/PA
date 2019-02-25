import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
public class Main {

	public static void main(String[] args) {
		Student s1=new Student("s1",2);
		Student s2=new Student("s2",2);
		Student s3=new Student("s3",2);
		Student s4=new Student("s4",2);
		Application a1 = new Application("A1", LocalDate.of(2019, Month.JUNE, 1), Language.JAVA);
		Essay e1 = new Essay("E1", LocalDate.parse("2019-06-01"), Topic.ALGORITHMS);
		System.out.println(a1.lang);
        s1.setPreferences(a1);
        s1.setPreferences(e1);
        System.out.println(s1.toString());
        Problem problem = new Problem();
        problem.setStudents(s1, s2, s3, s4);
        problem.getStudents();
        System.out.println(problem);
	}

}
