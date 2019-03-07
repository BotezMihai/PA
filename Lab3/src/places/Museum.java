package places; /**
 * @author Botez Mihai
 * @author Dragomir Cristian
 */

import interfaces.Classifiable;
import interfaces.Payable;
import interfaces.Visitable;
import map.*;

import java.time.Duration;
import java.time.LocalTime;

public class Museum extends Node implements Classifiable, Visitable, Payable {
    private String typeOfMuseum;
    private LocalTime openingHour = LocalTime.of(00, 00);
    private LocalTime closingHour = LocalTime.of(00, 00);
    private int entryFee;

    public Museum(String name) {
        super(name);
    }

    public void setRank(int s) {
        if (s == 1)
            typeOfMuseum = "Human rights museum";
        else if (s == 2) {
            typeOfMuseum = "Aviation museum";
        } else if (s == 3) {
            typeOfMuseum = "Science museum";
        } else if (s == 4) {
            typeOfMuseum = "National History places.Museum";

        } else if (s < 1 && s > 4) {
            System.out.println("Wrong number");
        }

    }

    public String getRank() {
        return typeOfMuseum;
    }

    public void setOpeningHour(LocalTime h) {
        openingHour = h;


    }

    public void setClosingHour(LocalTime h) {
        closingHour = h;
    }

    public LocalTime getOpeningHour() {
        return openingHour;
    }

    public LocalTime getClosingHour() {
        return closingHour;
    }

    public void setEntryFee(int s) {
        entryFee = s;
    }

    public int getEntryFee() {
        return entryFee;
    }

    @Override
    public Duration getVisitingDuration() {
        return Duration.between(this.openingHour, this.closingHour);
    }

    @Override
    public String toString() {
        return "Museum{" + this.getName() + "}";
    }
}
