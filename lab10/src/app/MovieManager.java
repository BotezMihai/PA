package app;


import com.github.javafaker.Faker;
import controller.ActorController;
import controller.MovieController;
import controller.PersonController;
import entity.Actor;
import entity.ActorID;
import entity.Movie;
import entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MovieManager {
    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("MoviesPU");
    private MovieController movieController;
    private PersonController personController;
    private ActorController actorController;

    public void run() {
        movieController = new MovieController(emf);
        personController = new PersonController(emf);
        actorController = new ActorController(emf);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input command:");
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] params = command.trim().split("\\s+");
            switch (params[0]) {
                case "create-person":
                    createPerson(params[1]); //the person name
                    break;
                case "create-movie":
                    createMovie(params[1], params[2]); //the movie name and the director
                    break;
                case "list-movies":
                    listMovies(params[1]); //the director name
                    break;
                case "create-actor":
                    createActor(Integer.parseInt(params[1]), Integer.parseInt(params[2])); // movie_id and actori_id
                    break;
//                case "list-actors":
//                    listActors(params[1]); //the director name
//                    break;
                case "create-data":
                    createData();
                    break;

            }
        }
        emf.close();
    }

    private void createData() {
        Faker faker = new Faker();
        int entrys = 100;
        while (entrys > 0) {
            Person person = new Person();
            person.setName(faker.name().firstName() + " " + faker.name().lastName());
            personController.create(person);

            Movie movie = new Movie();
            movie.setName(faker.starTrek().character());
            Random random3 = new Random();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(random3.nextInt(entrys + 1));
            String directorId = stringBuilder.toString();
            movie.setDirector(directorId);
            movieController.create(movie);

            Actor actor = new Actor();
            Random random1 = new Random();
            Random random2 = new Random();
            ActorID actorID = new ActorID(random1.nextInt(entrys + 1) + 1, random2.nextInt(entrys + 1) + 1);
            actor.setId(actorID);
            actorController.create(actor);
            entrys -= 1;
        }
    }

    private void createPerson(String personName) {
        Person p = new Person();
        p.setName(personName);
        personController.create(p);
    }

    private void createMovie(String movieName, String directorName) {
        Movie m = new Movie();
        m.setName(movieName);
        m.setDirector(directorName);
        movieController.create(m);
    }

    private void createActor(int movieId, int actorId) {
        Actor actor = new Actor();
        ActorID actorID = new ActorID(movieId, actorId);
        actor.setId(actorID);
        actorController.create(actor);
    }

    private void listMovies(String directorName) {
        ArrayList<Movie> movies = movieController.list(directorName);
        for (Movie movie : movies) {
            System.out.printf("%s      %s\n", movie.getName(), movie.getDirector());
        }
    }

//    private void listActors(String directorName) {
//        ArrayList<Actor> actors = actorController.list(directorName);
//        for (Actor actor : actors) {
//            System.out.printf("%s      %s\n", actor.getId().getActorId(), actor.getId().getMovieId());
//        }
//    }

    public static void main(String args[]) {
        new MovieManager().run();
    }
}
