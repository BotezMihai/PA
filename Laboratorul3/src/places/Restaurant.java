package places;

import interfaces.Visitable;
import map.*;

import java.time.LocalTime;
/**
 * @author Botez Mihai
 * @author Dragomir Cristian
 */
public class Restaurant extends Node implements Visitable {
    private LocalTime openingHour = LocalTime.of(00,00);
    private LocalTime closingHour = LocalTime.of(00,00);
    public Restaurant(String nume)
    {
        super(nume);
    }
    public void setOpeningHour(LocalTime h)
    {
        openingHour=h;
    }
    public void setClosingHour(LocalTime h)
    {
        closingHour=h;
    }
    public LocalTime getOpeningHour()
    {
        return openingHour;
    }
    public LocalTime getClosingHour()
    {
        return closingHour;
    }

}
