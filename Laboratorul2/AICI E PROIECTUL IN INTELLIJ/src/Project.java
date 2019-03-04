/**
 * @author Dragomir Cristian
 * @author Botez Mihai
 */

import java.time.LocalDate;

abstract class Project {
    /**
     * Stores the name
     */
    String name;
    /**
     * Stores the deadline
     */
    LocalDate deadline;

    /**
     * Retrieves the name of the project
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of a project
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the deadline
     *
     * @return the deadline
     */
    public LocalDate getDeadline() {
        return deadline;
    }

    /**
     * Sets the deadlin
     *
     * @param localDate the deadline
     */
    public void setDeadline(LocalDate localDate) {
        this.deadline = localDate;
    }

    /**
     * Creates a representation of a project
     *
     * @return the representation of a project
     */
    @Override
    public String toString() {
        return name + " " + deadline;
    }

    /**
     * equals verify if two projects are equal
     *
     * @param project the project
     * @return true/false
     */
    public boolean equals(Project project) {
        if (this.name.equals(project.getName()) && this.deadline.equals(project.getDeadline())) {
            return true;
        }
        return false;
    }

}
