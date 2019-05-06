package main;

import controllers.ActorController;
import controllers.MovieController;
import controllers.PersonController;
import db.Database;
import entities.Actor;
import entities.Director;
import entities.Movie;
import entities.Person;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> allPersons = new ArrayList<>();
        ArrayList<Movie> allMovies = new ArrayList<>();
        ArrayList<Actor> allActors = new ArrayList<>();


        //        try {
        PersonController persons = new PersonController();
        MovieController movies = new MovieController();
        ActorController actors = new ActorController();

        allPersons = persons.findAll();
        System.out.println("All the persons: \n" + allPersons);

        allMovies = movies.findAll();
        System.out.println("All the movies: \n" + allMovies);

        try {
            actors.create(1, 1);
        } catch (SQLException e) {
            System.out.println("Error!!! : There already exists this record.");
        }

        allActors = actors.findAll();
        System.out.println("All the actors: \n" + allActors + "\n");

        Movie movie = new Movie(1, 1, "Avengers: EndGame");
        allActors = actors.findByMovie(movie);
        System.out.println("All actors who played in the movie : " + movie.getName() + "\n" + allActors + "\n");

        Actor actor = new Actor(movie.getId(), 1);
        allMovies = actors.allMovies(actor);
        System.out.println("The movies the actor: " + actor + " plays in are :\n" + allMovies + "\n");

        Director director = new Director(-1);
        allMovies = movies.findByDirector(director);
        System.out.println("All the movies directed by: " + director + "\n" + allMovies + "\n");

        Database.commit();

        try {
            persons.populate();
            movies.populate();
            Database.commit();
        } catch (SQLException e) {
            System.out.println("Can't add this record!");
            Database.rollback();
        }

        allPersons = persons.findAll();
        System.out.println("All the persons: \n" + allPersons);

        allMovies = movies.findAll();
        System.out.println("All the movies: \n" + allMovies);

    }
}
