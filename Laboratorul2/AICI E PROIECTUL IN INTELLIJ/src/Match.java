import java.util.*;
import java.util.stream.*;
java.util.Set;
        java.util.HashSet
public class Match {

    private Map matches;
    private List<Student> students;
    private ArrayList<Project> projects;
    public Match(List<Student> stud, ArrayList<Project> proj)
    {
        students=stud;
        projects=proj;
        matches=new HashMap();

    }

    public Project checkProject(Student student)
    {
        ArrayList<Project> projects1=student.getPreferences();
        int i,j;
        for(i=0;i<projects1.size();i++)
        {
            if(matches.containsValue(projects1.get(i).getName())==false)
                return projects1.get(i);

        }
        for(i=0;i<projects1.size();i++)
        {
            if(matches.containsValue(projects1.get(i).getName())==true)
            {
                Set set = matches.entrySet();

            }
        }
    }
    public void makeMatches(){

        int i;
        for(i=0;i<students.size();i++)
        {
            Project p=checkProject(students.get(i));
            matches.put(students.get(i),p);
        }

    }


}