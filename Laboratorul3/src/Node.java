/**
 * @author Botez Mihai
 * @author Dragomir Cristian
 */
public class Node {
    /**
     * Stores the name of the node
     */
    private String name;
    /**
     * Stores the longitude of the node
     */
    private double longitude;
    /**
     * Stores the latitude of the node
     */
    private double latitude;

    /**
     * Retrieves the name of the node
     * @return the name
     */
    public Node (String name)
    {
        this.name=name;
    }


    public String getName() {
        return name;
    }

    /**
     * Sets the name of the node
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the longitude of the node
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets the longitude of the node
     * @param longitude the longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Retrieces the latitude of the node
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets the latitude of the node
     * @param latitude the latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
