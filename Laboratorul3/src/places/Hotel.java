package places; /**
 * @author Botez Mihai
 * @author Dragomir Cristian
 */
import interfaces.Classifiable;
import interfaces.Payable;
import map.*;
import java.util.Scanner;
public class Hotel extends Node implements Classifiable, Payable {

      private String rank;
      private int singleRoom;
      private int doubleRoom;
       public Hotel (String nume)
       {
           super(nume);
           singleRoom=doubleRoom=0;
       }
  public void setRank(int s)
  {
        rank=String.format("places.Hotel with %d stars",s);

  }
  public String getRank()
  {
      return rank;
  }
   public void setEntryFee(int s)
   {
          System.out.println("Set this for 1. Single Room or for 2. Double Room");
       Scanner sc = new Scanner(System.in);
       int option = sc.nextInt();
       if(option==1)
           singleRoom=s;
       else if(option==2)
       {
           doubleRoom=s;
       }
       else {
           System.out.println("Wrong number");
       }
   }
   public int getEntryFee()
   {
       System.out.println("Price for single room 1, for double room is 2");
       Scanner sc = new Scanner(System.in);
       int option = sc.nextInt();
       if(option==1)
           return singleRoom;
       else if (option==2)
           return doubleRoom;
       else
           return 0;
   }


}
