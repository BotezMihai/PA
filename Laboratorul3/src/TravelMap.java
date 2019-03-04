import java.util.ArrayList;

/**
 * @author Botez Mihai
 * @author Dragomir Cristian
 */
public class TravelMap {
    /**
     * Stores the list of nodes
     */
    public ArrayList<Node> listOfNodes;

    /**
     * Stores the list of edges
     */
    public ArrayList<Edge> listOfEdges;

    /**
     * Retrieves the list of nodes
     * @return the list of nodes
     */
    public TravelMap()
    {
        listOfNodes=new ArrayList<Node>();
        listOfEdges=new ArrayList<Edge>();
    }
    public ArrayList<Node> getListOfNodes() {
        return listOfNodes;
    }

    /**
     * Sets the list of nodes
     * @param listOfNodes the list of nodes
     */
    public void setListOfNodes(ArrayList<Node> listOfNodes) {
        this.listOfNodes = listOfNodes;
    }

    /**
     * Retrieves the list of edges
     * @return the list of edges
     */
    public ArrayList<Edge> getListOfEdges() {
        return listOfEdges;
    }


    /**
     * Sets the list of edges
     * @param listOfEdges the list of edges
     */
    public void setListOfEdges(ArrayList<Edge> listOfEdges) {
        this.listOfEdges = listOfEdges;
    }

    /**
     * Adds a node to the travel map
     * @param node the node to be added
     */
    public void addNode(Node node){
        this.listOfNodes.add(node);
    }

    /**
     * Adds an edge to the travel map
     * @param edge the edge to be added
     */
    public void addEdge(Edge edge){
        this.listOfEdges.add(edge);
    }
    public ArrayList<Node> getNodes()
    {
        return listOfNodes;
    }

}
