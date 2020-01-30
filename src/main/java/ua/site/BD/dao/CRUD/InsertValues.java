package ua.site.BD.dao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertValues {
    public void insert_values(String login, String password, String name, String surname, String subject_id) {
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        try {
            String query = "insert into mybdtest.schoolchildren(login, password,name,surname,subject_id) values(?,?,?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, surname);
            ps.setString(5, subject_id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Can't connect to db to insert data");
            System.err.println(e);
        }
    }
}
