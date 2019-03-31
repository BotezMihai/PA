import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    LinkedList<Edge> listOfEdges;
    int numberOfNodes;

    public Graph(int numberOfNodes){
        listOfEdges=new LinkedList<Edge>();
        this.numberOfNodes=numberOfNodes;



    }
    public void addEdge( Edge edge) {
         listOfEdges.add(edge);

    }
    public void show(){
        for (Edge edge : listOfEdges)
        {
            System.out.println(edge);
        }
    }
    public Edge pollFirst()
    {
        return listOfEdges.pollFirst();
    }
}
