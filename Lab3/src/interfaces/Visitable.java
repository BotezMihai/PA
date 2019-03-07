package interfaces; /**
 * @author Botez Mihai
 * @author Dragomir Cristian
 */
import java.time.LocalTime;

public interface Visitable {
    /**
     * Stores the opening hour
     */
    // LocalTime openingHour = LocalTime.of(00,00);

    /**
     * Stores the closing hour
     */
    LocalTime closingHour = LocalTime.of(00,00);

    /**
     * Sets the opening hour
     * @param openingHour the opening hour
     */
    void setOpeningHour(LocalTime openingHour);

    /**
     * Sets the closing hour
     * @param closingHour the closing hour
     */
    void setClosingHour(LocalTime closingHour);

    /**
     * Retrieves the opening hour
     * @return the opening hour
     */
    LocalTime getOpeningHour();

    /**
     * Retrieves the closing hour
     * @return the closing hour
     */
    LocalTime getClosingHour();


}
