import java.time.LocalDate;

abstract class Project {
    String name;
    LocalDate deadline;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate localDate) {
        this.deadline = localDate;
    }

    @Override
    public String toString() {
        return name + " " + deadline;
    }

    // equals verify if two projects are equal
    public boolean equals(Project project){
        if (this.name.equals(project.getName()) && this.deadline.equals(project.getDeadline())){
            return true;
        }
        return false;
    }

}
