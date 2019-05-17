package entity;

import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

    @Column(name="name")
    public String name;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    public Person() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setId(Integer id) {
        this.id = id;
    }
}
