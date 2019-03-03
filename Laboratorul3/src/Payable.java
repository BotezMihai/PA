/**
 * @author Botez Mihai
 * @author Dragomir Cristian
 */
interface Payable {
    /**
     * Stores the entry fee
     */
    double entryFee = 0;

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
