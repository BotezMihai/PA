import interfaces.Visitable;
import map.Edge;
import map.Node;
import map.TravelMap;
import places.Hotel;
import places.Museum;

import java.time.LocalTime;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Hotel v1 = new Hotel("California");
        Museum v2 = new Museum("Iasi");
        v2.setEntryFee(20);

        System.out.println(v1.getEntryFee());
        System.out.println(v2.getName());

        v2.setOpeningHour(LocalTime.of(10, 14));
        System.out.println(v2.getOpeningHour());
        TravelMap map = new TravelMap();
        map.addNode(v1);
        map.addNode(v2);
        Edge e = new Edge(v1, v2, 15);
        map.addEdge(e);
        // Implement the toString method for the TravelMap class.
        System.out.println("The map is: \n" + map.getNodes());
        System.out.println(map.toString());

        // Using streams, display the locations that are visitable and are not payable,
        // sorted by their opening hour.
        ArrayList<Node> visitableNotPayablePlaces = map.getNodes();
        visitableNotPayablePlaces.stream().filter(y -> y instanceof Visitable).forEach(x -> System.out.println("Visitable " + x));

        // Create default methods in the interface Visitable, with the opening hour 09:30 and
        // the closing hour 20:00.
        v2.setBasicHours();
        System.out.println("setBasicHours used! See below.");
        System.out.println(v2.getOpeningHour() + " " + v2.getClosingHour());

        // Create a static method getVisitingDuration,in the interface Visitable,
        // that returns a Duration object, representing how long a location is opened during a day.
        System.out.println("Opened for: " + v2.getVisitingDuration());




    }
}
