/**
 * @author Dragomir Cristian
 * @author Botez Mihai
 */

import java.util.*;


public class Problem {
    /**
     * Stores the students for a problem
     */
    private List<Student> students;

    /**
     * A constructor
     */
    public Problem() {
        students = new ArrayList<Student>();
    }

    /**
     * Adds 4 students in the students array
     *
     * @param s1
     * @param s2
     * @param s3
     * @param s4
     */
    void setStudents(Student s1, Student s2, Student s3, Student s4) {
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
    }

    /**
     * Adds a student in the students array
     * Also checks if there already exists this student
     * If there isn't this student then he is added
     * Else a message will pop-up
     *
     * @param student the student
     */
    void setStudents(Student student) {
        if (students.indexOf(student) == -1) {
            students.add(student);
        } else {
            System.out.println("The student " + student + " is already enrolled.");
        }

    }

    /**
     * Prints the students for the problem
     */
    void getStudents() {
        ListIterator it = students.listIterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println(s.getName());
        }

    }

    /**
     * Creates a representation for the problem object
     *
     * @return the representation
     */
    @Override
    public String toString() {
        return "Problem [students=" + students + "]";
    }

    /**
     * Retrieves an array with all unique projects from the problem
     *
     * @return the array with all projects
     */
    public ArrayList<Project> getProjects() {
        ArrayList<Project> projectsList = new ArrayList<Project>();
        Student auxiliarStudent = students.get(0);
        projectsList.addAll(auxiliarStudent.getPreferences());

        int i, j;
        for (i = 0; i < students.size(); i++) {
            auxiliarStudent = students.get(i);
            ArrayList<Project> tempPref = auxiliarStudent.getPreferences();
            for (j = 0; j < tempPref.size(); j++) {
                if (projectsList.indexOf(tempPref.get(j)) == -1) {
                    projectsList.add(tempPref.get(j));
                }
            }

        }
        return projectsList;
    }

}
