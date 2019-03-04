/**
 * @author Botez Mihai
 * @author Dragomir Cristian
 */
public class Hotel extends Node implements Classifiable{

       String rank;
       public Hotel (String nume)
       {
           super(nume);
       }
  public void setRank(int s)
  {
        rank=String.format("Hotel with %d stars",s);

  }
  public String getRank()
  {
      return rank;
  }


}
