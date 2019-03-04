
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        Hotel v1=new Hotel("California");
       System.out.println(v1.getName());
       Museum v2=new Museum("Iasi");
       System.out.println(v2.getName());
       v2.setOpeningHour(LocalTime.of(10,14));
       System.out.println(v2.getOpeningHour());
        TravelMap map = new TravelMap();
        map.addNode(v1);
        map.addNode(v2);
        Edge e=new Edge(v1,v2,15);
        map.addEdge(e);
        System.out.println("The map is: \n" + map.getNodes());
    }
}
