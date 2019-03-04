/**
 * @author Dragomir Cristian
 * @author Botez Mihai
 */

import java.time.LocalDate;

public class Essay extends Project {
    /**
     * Stores the topic of an essay
     */
    Topic topic;

    /**
     * Constructor of a topic
     *
     * @param name
     * @param localDate
     * @param algorithms
     */
    public Essay(String name, LocalDate localDate, Topic algorithms) {
        setName(name);
        setDeadline(localDate);
        this.topic = algorithms;
    }

    /**
     * Creates a representation of an essay object
     *
     * @return the represenation
     */
    public String toString() {
        return name + " " + deadline + " " + topic;
    }


}
