package controllers;

import com.github.javafaker.Faker;
import db.Database;
import entities.Person;

import java.sql.*;
import java.util.ArrayList;

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
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<Person> findAll() {
        Connection con = Database.getConnection();

        ArrayList<Person> persons = new ArrayList<>();
        int personId = -1;
        String personName;

        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select * from persons")) {
            while (rs.next()) {
                personId = rs.getInt("id");
                personName = rs.getString("name");
                persons.add(new Person(personId, personName));
            }
        } catch (NullPointerException | SQLException e) {
            e.printStackTrace();
        }

        return persons;
    }

    public void populate() throws SQLException {
        Faker faker = new Faker();
        int entrys = 100;
        while (entrys > 0){
            create(faker.name().firstName() + " " + faker.name().lastName());
            entrys -= 1;
        }
    }

}