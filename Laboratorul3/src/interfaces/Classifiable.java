package interfaces;

/**
 * @author Botez Mihai
 * @author Dragomir Cristian
 */
public interface Classifiable {
    /**
     * Stores the rank of the location
     */
    int rank = 0;

    /**
     * Sets the rank
     * @param rank the rank
     */
    void setRank(int rank);


    /**
     * Retrieves the rank
     * @return the rank
     */
    String getRank();

}
