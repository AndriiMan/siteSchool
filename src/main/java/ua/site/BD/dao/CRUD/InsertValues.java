package ua.site.BD.dao.CRUD;

import java.sql.*;

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

            //convert name to id in schoolchild table
            ps.setString(5, subjectId);

getSubjIdByName();

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
                subjectId != null && subjectId.length() != 0 && subjectId.length() > 0 &&
                subjectId.matches("[+]?\\d+");
    }

    public static String getSubjIdByName(){
        BDConnection objBDConnection = new BDConnection();
        Connection connection = objBDConnection.getConnection();
        //PreparedStatement ps = null;
        String subject_col="History";
        Statement ps = null;
        String subjectId=null;
        try {
            ps = connection.createStatement();

            String sql="select * from mybdtest.subject where subject.subject_col="+subject_col;
            //String query = "select * from mybdtest.subject where subject_col=?";
            //ps = connection.prepareStatement(sql);
            //ps.setString(1, login);
            ResultSet rs = ps.executeQuery(sql);

            while (rs.next()){
                subjectId=rs.getString("subjectId");
                System.out.println("Start");
                System.out.println("Sub col "+rs.getString("subject_col"));
                System.out.println("Sub id "+rs.getString("subjectId"));
                System.out.println("End");
               }
            //ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Can't connect to db to insert data");
            System.err.println(e);
        }
        return subjectId;
    }
}