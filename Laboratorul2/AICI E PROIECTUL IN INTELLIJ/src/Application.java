/**
 * @author Dragomir Cristian
 * @author Botez Mihai
 */

import java.time.LocalDate;

public class Application extends Project {
    /**
     * Stores the language
     */
    Language lang;

    /**
     * A constructor
     *
     * @param name      the name
     * @param localDate the deadline
     * @param lang      the language
     */
    public Application(String name, LocalDate localDate, Language lang) {
        setName(name);
        setDeadline(localDate);
        this.lang = lang;
    }

    /**
     * Creates a representation of an application object
     *
     * @return the representation
     */
    public String toString() {
        return name + " " + deadline + " " + lang;
    }
}
