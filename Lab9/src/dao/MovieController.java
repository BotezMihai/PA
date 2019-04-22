package dao;

import db.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
