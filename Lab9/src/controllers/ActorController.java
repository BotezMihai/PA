package controllers;

import db.Database;
import entities.Actor;
import entities.Movie;

import java.sql.*;
import java.util.ArrayList;

public class ActorController {
    public void create(int actorId, int movieId) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into movie_actors (movie_id, actor_id) values (?,?)")) {
            pstmt.setInt(1, movieId);
            pstmt.setInt(2, actorId);
            pstmt.executeUpdate();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Actor> findAll() {
        Connection con = Database.getConnection();

        ArrayList<Actor> actors = new ArrayList<>();
        int actorId = -1;
        int movieId = -1;

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from movie_actors")) {
            while (rs.next()) {
                actorId = rs.getInt("actor_id");
                movieId = rs.getInt("movie_id");
                actors.add(new Actor(movieId, actorId));
            }
        } catch (NullPointerException | SQLException e) {
            e.printStackTrace();
        }

        return actors;
    }

    public ArrayList<Actor> findByMovie(Movie movie) {
        Connection con = Database.getConnection();

        ArrayList<Actor> actors = new ArrayList<>();
        int actorId = -1;
        int movieId1 = -1;

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from movie_actors where movie_id = " + movie.getId())) {
            while (rs.next()) {
                actorId = rs.getInt("actor_id");
                movieId1 = rs.getInt("movie_id");
                actors.add(new Actor(movie.getId(), actorId));
            }
        } catch (NullPointerException | SQLException e) {
            e.printStackTrace();
        }

        return actors;
    }

    public ArrayList<Movie> allMovies(Actor actor) {
        Connection con = Database.getConnection();

        ArrayList<Movie> movies = new ArrayList<>();
        int id = -1;
        int actorId = -1;
        int movieId = -1;
        int directorId = -1;
        String name;

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from movie_actors where actor_id = " + actor.getActorId())) {
            while (rs.next()) {
                actorId = rs.getInt("actor_id");
                movieId = rs.getInt("movie_id");
                try (Statement stmt1 = con.createStatement();
                     ResultSet rs1 = stmt1.executeQuery("select * from movies where id = " + movieId)) {
                    while (rs1.next()) {
                        id = rs1.getInt("id");
                        name = rs1.getString("name");
                        directorId = rs1.getInt("director_id");
                        movies.add(new Movie(id, directorId, name));
                    }
                } catch (NullPointerException | SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (NullPointerException | SQLException e) {
            e.printStackTrace();
        }

        return movies;
    }

}