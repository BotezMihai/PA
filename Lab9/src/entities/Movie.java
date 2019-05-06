package entities;

public class Movie {
    private String name;
    private int directorId;
    private int id;

    public Movie(int id, int directorId, String name) {
        this.directorId = directorId;
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", directorId=" + directorId +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
