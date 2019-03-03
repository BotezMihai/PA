import java.util.ArrayList;



public class Student {
    private String name;
    private int yearOfStudy;
    private ArrayList<Project> preference=new ArrayList<Project>();
    private Project enrollment;
    private int nrPreferences;

    public Student(String name, int year) {
        this.name = name;
        yearOfStudy = year;
        nrPreferences = 0;


    }

    void setPreferences(Application a) {
        preference.add(a);

    }

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
    ArrayList<Project> getPreferences(){
        return this.preference;
    }
    /* should be called showPreferences
    void getPreferences() {
        int i;
        for (i = 0; i < nrPreferences; i++) {
            System.out.println(preference[i].getName());
        }

    }
    */

    /**
     * added getNrPreferences for using in getProjects from Problem.java
    */
     public int getNrPreferences(){
        return  preference.size();
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

    @Override
    public String toString() {
        return getName() + " " + getYearOfStudy();
    }

    /**
     * equals verify if 2 students are the same, names and yearOfStudy
     * overriding the method, Optional first point
     */
    public boolean equals(Student student) {
        if (this.name.equals(student.getName()) && this.yearOfStudy == student.getYearOfStudy())
            return true;
        return false;
    }


}
