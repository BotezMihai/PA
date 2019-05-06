package entities;

public class Director {
    private int id;

    public Director(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
