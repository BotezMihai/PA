package entities;

public class Actor {
    private int movieId;
    private int actorId;

    public Actor(int movieId, int actorId) {
        this.actorId = actorId;
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "movieId=" + movieId +
                ", actorId=" + actorId +
                '}';
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }
}
