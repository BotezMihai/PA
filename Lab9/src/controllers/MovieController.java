package controllers;

import com.github.javafaker.Faker;
import db.Database;
import entities.Director;
import entities.Movie;

import java.sql.*;
import java.util.ArrayList;

public class MovieController {
    public void create(String name, int directorId) throws SQLException {
        Connection con = Database.getConnection();
        if (directorId != -1) {
            try (PreparedStatement pstmt = con.prepareStatement("insert into movies (name, director_id) values (?,?)")) {
                pstmt.setString(1, name);
                pstmt.setInt(2, directorId);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Movie> findAll() {
        Connection con = Database.getConnection();

        ArrayList<Movie> movies = new ArrayList<>();
        int movieId = -1;
        int directorId = -1;
        String movieName;

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from movies")) {
            while (rs.next()) {
                movieId = rs.getInt("id");
                directorId = rs.getInt("director_id");
                movieName = rs.getString("name");
                movies.add(new Movie(movieId, directorId, movieName));
            }
        } catch (NullPointerException | SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public ArrayList<Movie> findByDirector(Director director) {
        Connection con = Database.getConnection();

        ArrayList<Movie> movies = new ArrayList<>();
        int movieId = -1;
        int directorId = -1;
        String movieName;

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from movies where director_id = " + director.getId())) {
            while (rs.next()) {
                movieId = rs.getInt("id");
                directorId = rs.getInt("director_id");
                movieName = rs.getString("name");
                movies.add(new Movie(movieId, directorId, movieName));
            }
        } catch (NullPointerException | SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }

    public void populate() throws SQLException {
        Faker faker = new Faker();
        int entrys = 100;
        while (entrys > 0){
            create(faker.name().firstName() + " " + faker.name().lastName(), entrys);
            entrys -= 1;
        }
    }

}
