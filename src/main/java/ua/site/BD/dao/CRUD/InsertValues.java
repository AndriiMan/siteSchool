package ua.site.BD.dao.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;

//Class for registration users

public class InsertValues {
    public void insertValues(String login, String password, String name, String surname, String subjectId) {
        BDConnection objBDConnection = new BDConnection();
        Connection connection = objBDConnection.getConnection();
        PreparedStatement ps = null;
        try {
            String query = "insert into mybdtest.schoolchildren(login, password,name,surname,subjectId) values(?,?,?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, surname);
            ps.setString(5, subjectId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Can't connect to db to insert data");
            System.err.println(e);
        }
    }

    //checking
    public boolean requestIsValid(String login, String password, String name, String surname, String subjectId) {

        return name != null && name.length() > 0 &&
               surname != null && surname.length()>0 &&
               login != null && login.length()>0 &&
               password != null && password.length()>0 &&
                subjectId != null && subjectId.length() > 0 &&
                subjectId.matches("[+]?\\d+");
    }
}
