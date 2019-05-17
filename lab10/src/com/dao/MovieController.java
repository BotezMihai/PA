package com.dao;

import java.sql.*;

public class MovieController {

    public void createMovie(String name, Integer directorID) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into movies (name, director_id) values (?, ?)")) {
            pstmt.setString(2, String.valueOf(directorID));
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        }

    }

    public void createActor(Integer movieID, Integer personID) throws SQLException
    {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into movie_actors (actor_id, movie_id) values (?, ?)")) {
            pstmt.setString(1, String.valueOf(personID));
            pstmt.setString(2, String.valueOf(movieID));
            pstmt.executeUpdate();
        }
    }

    public void list(Integer directorID) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.getResultSet()) {
            stmt.executeQuery("select name from movies where director_id = directorID");
            System.out.println(rs.next() ? rs.getInt(1) : null);
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from movies where name like '" + name + "'")) {
            return rs.next() ? rs.getInt(1) : null;
        }
    }
}
