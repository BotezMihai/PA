package interfaces;

/**
 * @author Botez Mihai
 * @author Dragomir Cristian
 */
public interface Payable {
    /**
     * Sets the entryFee
     * @param entryFee the entry fee
     */
    void setEntryFee(int entryFee);

    /**
     * Retrieves the entry fee
     * @return the entry fee
     */
    int getEntryFee();

}
