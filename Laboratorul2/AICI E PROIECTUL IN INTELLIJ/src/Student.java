/**
 * @author Dragomir Cristian
 * @author Botez Mihai
 */

import java.util.ArrayList;

public class Student {
    /**
     * Stores the name
     */
    private String name;
    /**
     * Stores the year of study
     */
    private int yearOfStudy;
    /**
     * Stores the preferences of the student
     */
    private ArrayList<Project> preference = new ArrayList<Project>();
    /**
     * Stores the project the student is enrolled at
     */
    private Project enrollment;
    /**
     * Stores the number of preferences
     */
    private int nrPreferences;

    /**
     * Constructor
     *
     * @param name the name
     * @param year the year
     */
    public Student(String name, int year) {
        this.name = name;
        yearOfStudy = year;
        nrPreferences = 0;
    }

    /**
     * Adds a preference in the preference array
     *
     * @param a the application
     */
    void setPreferences(Application a) {
        preference.add(a);
    }

    /**
     * Adds a preference in the preference array
     *
     * @param e the essay
     */
    void setPreferences(Essay e) {
        preference.add(e);
    }

    /*void getPreferences(){


        ListIterator it = preference.listIterator();
        while(it.hasNext())
        {
            Project project=(Project)it.next();
            System.out.println(project.getName());
        }
    }
    */

    /**
     * Retrieves the preference array
     *
     * @return the preference array
     */
    ArrayList<Project> getPreferences() {
        return this.preference;
    }

    /**
     * Retrieves the number of preferences
     *
     * @return the number of preferences
     */
    public int getNrPreferences() {
        return preference.size();
    }

    /**
     * Retrieves the name of the student
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the student
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the year of study
     *
     * @return the year of study
     */
    public int getYearOfStudy() {
        return yearOfStudy;
    }

    /**
     * Sets the year of study
     *
     * @param yearOfStudy the year of study
     */
    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    /**
     * Retrieves a representation of a student object
     *
     * @return the student representation
     */
    @Override
    public String toString() {
        return getName() + " " + getYearOfStudy();
    }

    /**
     * Equals verify if 2 students are the same, names and yearOfStudy
     *
     * @param student a student
     * @return true/false
     */
    public boolean equals(Student student) {
        if (this.name.equals(student.getName()) && this.yearOfStudy == student.getYearOfStudy())
            return true;
        return false;
    }


}
