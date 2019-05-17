package entity;

import javax.persistence.*;

@Entity
@Table(name = "movie_actors")
//@NamedQuery(
//        name="findAllActorsFromAMovie",
//        query="select t from Actor t where t.movieId = id"
//)
public class Actor {

    @EmbeddedId
    private ActorID id;

    public Actor() {
    }

    public ActorID getId() {
        return id;
    }

    public void setId(ActorID id) {
        this.id = id;
    }
}
