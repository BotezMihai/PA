import java.util.ArrayList;

public class Graph {
    ArrayList<Edge> listOfEdges;
    int numberOfNodes;

    public Graph(int numberOfNodes){
        listOfEdges=new ArrayList<Edge>();
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
}
