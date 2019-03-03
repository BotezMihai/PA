import java.util.*;


public class Problem {
    private List<Student> students;

    public Problem() {

        students = new ArrayList<Student>();
    }

    void setStudents(Student s1, Student s2, Student s3, Student s4) {

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
    }

    // Modificat aici
    void setStudents(Student student) {
        if (students.indexOf(student) == -1) {
            students.add(student);
        } else {
            System.out.println("The student " + student + " is already enrolled.");
        }

    }

    void getStudents() {
        ListIterator it = students.listIterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println(s.getName());
        }

    }

    @Override
    public String toString() {
        return "Problem [students=" + students + "]";
    }

    public ArrayList getProjects(){
        ArrayList<Project> projectsList = new ArrayList<>();
        Student auxiliarStudent = students.get(0);
       // ArrayList<Project> auxiliarProjects = auxiliarStudent.getPreferences();
        ArrayList<Project> auxiliarProjects = (ArrayList)auxiliarStudent.getPreferences().clone();
        for (int i = 0; i < students.size(); i++){
            auxiliarStudent = students.get(i);

            //System.arraycopy(auxiliarStudent.getPreferences(),0,auxiliarProjects,0,auxiliarStudent.getNrPreferences());
            auxiliarProjects=(ArrayList)auxiliarStudent.getPreferences().clone();
            for (int j = 0; j < auxiliarProjects.size(); j++){
                if (projectsList.indexOf(auxiliarProjects.get(i)) == -1){
                    projectsList.add(auxiliarProjects.get(i));
                }
            }
        }
        projectsList.removeIf(Objects::isNull);
        return projectsList;
    }

}
