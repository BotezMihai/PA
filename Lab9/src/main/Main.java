package main;

import dao.MovieController;
import dao.PersonController;
import db.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            PersonController persons = new PersonController();
            MovieController movies = new MovieController();

            persons.create("Francis Ford Coppola");
            persons.create("Marlon Brando");
            persons.create("Al Pacino");
            System.out.println("am trecut prin astea");
            Database.commit();

            movies.create("The Godfather", persons.findByName("Coppola"));
            //Add other movies to the database
            Database.commit();

            Database.closeConnection();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
