import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
public class Main {

	public static void main(String[] args) {
		Student s1=new Student("s1",2);
		Application a1 = new Application("A1", LocalDate.of(2019, Month.JUNE, 1), Language.JAVA);
        System.out.println(a1.lang);
        s1.setPreferences(a1);
        
	}

}
