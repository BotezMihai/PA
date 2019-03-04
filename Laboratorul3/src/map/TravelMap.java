package map;

import java.util.ArrayList;

/**
 * @author Botez Mihai
 * @author Dragomir Cristian
 */
public class TravelMap {
    /**
     * Stores the list of nodes
     */
    private ArrayList<Node> listOfNodes;

    /**
     * Stores the list of edges
     */
    private ArrayList<Edge> listOfEdges;

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

    /**
     * Retrieves the list with nodes
     * @return the list with nodes
     */
    public ArrayList<Node> getNodes()
    {
        return listOfNodes;
    }

    @Override
    public String toString() {
        String travelMap = new String();
        travelMap += "Map : \n";
        for (int i = 0; i < listOfEdges.size(); i++){
            travelMap += listOfEdges.get(i).toString();
            travelMap += '\n';
        }
        return travelMap;
    }
}
