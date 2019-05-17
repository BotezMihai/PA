package entity;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Column(name = "name")
    private String name;
    @Column(name = "director_id")
    private Integer director;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", directorId=" + director +
                ", id=" + id +
                '}';
    }

    public void setDirector(String director) {
        this.director = Integer.valueOf(director);
    }

    public Integer getDirector() {
        return director;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }
}
