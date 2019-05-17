import com.dao.*;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            DatabaseController newDB = new DatabaseController();
            newDB.createTables();
            PersonController persons = new PersonController();
            MovieController movies = new MovieController();

            persons.create("Francis Ford Coppola");
            persons.create("Marlon Brando");
            persons.create("Al Pacino");

            movies.createMovie("The Godfather", persons.findByName("Francis Ford Coppola"));
            //Add other movies to the database

            movies.createActor(movies.findByName("The Godfather"), persons.findByName("Francis Ford Coppola"));

            newDB.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            //Database.rollback();
        }
    }
}
