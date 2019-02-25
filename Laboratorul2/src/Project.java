import java.time.LocalDate;
import java.util.Date;
abstract class Project {
  String name;
  LocalDate deadline;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getDeadline() {
	return deadline;
}
public void setDeadline(LocalDate localDate) {
	this.deadline = localDate;
}
@Override
public String toString() { 
    return name+" "+deadline;
}   

}
