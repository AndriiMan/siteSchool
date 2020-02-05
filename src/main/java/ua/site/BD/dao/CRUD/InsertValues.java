package ua.site.BD.dao.CRUD;

import java.sql.*;

//Class for registration users

public class InsertValues {
    public void insertValues(String login, String password, String name, String surname, String subject_col) {
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
            ps.setString(5, getSubjIdByName(subject_col));

            //System.out.println(getSubjIdByName(subject_col));


            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Can't connect to db to insert data");
            System.err.println(e);
        }
    }

    //checking
    public boolean requestIsValid(String login, String password, String name, String surname, String subject_col) {

        return name != null && name.length() > 0 &&
                surname != null && surname.length() > 0 &&
                login != null && login.length() > 0 &&
                password != null && password.length() > 0 &&
                subject_col!=null;
    }

    public String getSubjIdByName(String sub_name) {
        BDConnection objBDConnection = new BDConnection();
        Connection connection = objBDConnection.getConnection();

        PreparedStatement st = null;
        ResultSet rs = null;
        String subjectId = null;
        
        try{

            String sql = "select subjectId from mybdtest.subject where subject.subject_col=?";
            st = connection.prepareStatement(sql);
            st.setString(1, sub_name);

            rs =  st.executeQuery();
            while (rs.next()) {
                subjectId=rs.getString("subjectId");
            }
        }
        catch (Exception e) {
            System.out.println("Can't connect to db to insert data");
            System.err.println(e);
        }
        return subjectId;
    }

    public static String getSpecIdByName(String spec_name) {
        BDConnection objBDConnection = new BDConnection();
        Connection connection = objBDConnection.getConnection();

        PreparedStatement st = null;
        ResultSet rs = null;
        String specId = null;

        try {

            String sql = "select specialization_id from mybdtest.specialization where specialization=?";
            st = connection.prepareStatement(sql);
            st.setString(1, spec_name);

            rs = st.executeQuery();
            while (rs.next()) {
                specId = rs.getString("specialization_id");
            }
        } catch (Exception e) {
            System.out.println("Can't connect to db to insert data");
            System.err.println(e);
        }
        return specId;
    }
}