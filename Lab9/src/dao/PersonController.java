package dao;

import db.Database;

import java.sql.*;

public class PersonController {
    public void create(String name) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement("insert into persons (name) values (?)")) {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public Integer findByName(String name) throws SQLException {
        Connection con = Database.getConnection();
        int result = -1;
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select id from persons where name like '" + name + "'")) {
            while (rs.next()){
                result = rs.getInt(1);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return result;
    }
//    public String findById(int id) throws SQLException { ... }
}