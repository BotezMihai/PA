package places;
import interfaces.Classifiable;
import map.*;
/**
 * @author Botez Mihai
 * @author Dragomir Cristian
 */
public class Church extends Node implements Classifiable {

    private String typeOfChurch;
    public Church(String name)
    {
        super(name);
    }
    public void setRank(int s)
    {
        if(s==1)
            typeOfChurch="Cafe church";
        else if(s==2)
        {
            typeOfChurch="Cowboy church";

        }
        else if(s==3)
        {
            typeOfChurch="Basilica";
        }
        else if(s<1 && s>3)
        {
            System.out.println("Wrong Number!");
        }
    }
    public String getRank()
    {
        return typeOfChurch;
    }
}
