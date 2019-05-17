package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseController {

    public void createTables() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS persons (id int primary key unique auto_increment, name varchar(100) not null)");
            statement.execute("CREATE TABLE IF NOT EXISTS movies (id int primary key unique auto_increment, name varchar(100) not null, director_id int not null references persons on delete restrict)");
            statement.execute("CREATE TABLE IF NOT EXISTS movie_actors (actor_id int not null references persons on delete restrict, movie_id int not null references movies on delete restrict)");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void closeConnection()
    {
        Connection con = Database.getConnection();
        if(con!=null)
        {
            try {
                con.close();
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
