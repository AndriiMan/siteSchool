package ua.site.BD.dao.CRUD;

import ua.site.model.Admin;
import ua.site.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Class for output users. UsersAll.
public class ReadValues {
    public static void main(String[] args) {
        ReadValues objReadValues=new ReadValues();
        objReadValues.getValues();
    }
    public List getValues(){
        BDConnection objBDConnection =new BDConnection();
        Connection connection= objBDConnection.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List list=new ArrayList();
        try {
            String querry="select * from mybdtest.schoolchildren " +
                    "inner join mybdtest.subject on schoolchildren.subjectId=subject.subjectId " +
                    "inner join mybdtest.specialization on schoolchildren.specializationId=specialization.specialization_id " +
                    "ORDER BY mark DESC";
            ps=connection.prepareStatement(querry);
            rs=ps.executeQuery();
            while(rs.next()){
                User objUser=new User();

                //Save all date from bd to new object
                //setDateToObjectUser(rs, objUser);
                list.add(setDateToObjectUser(rs, objUser));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List getValuesForAdmin() {
        BDConnection objBDConnection = new BDConnection();
        Connection connection = objBDConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            String querry = "select * from mybdtest.schoolchildren " +
                    "inner join mybdtest.subject on schoolchildren.subjectId=subject.subjectId " +
                    "ORDER BY mark DESC";
            ps = connection.prepareStatement(querry);
            rs = ps.executeQuery();
            while (rs.next()) {
                User objUser = new User();

                //Save all date from bd to new object
                //setDateToObjectUser(rs, objUser);
                list.add(setDateToObjectUserForAdmin(rs, objUser));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static User setDateToObjectUser(ResultSet rs, User objUser) throws SQLException {

        objUser.setLogin(rs.getString("login"));
        objUser.setPassword(rs.getString("password"));

        objUser.setId(rs.getInt("id"));
        objUser.setName(rs.getString("name"));
        objUser.setSurname(rs.getString("surname"));
        objUser.setSubjectId(rs.getInt("subjectId"));
        objUser.setSubject_col(rs.getString("subject_col"));
        objUser.setSpecializationId(rs.getInt("specializationId"));
        objUser.setSpecialization(rs.getString("specialization"));
        objUser.setMark(rs.getInt("mark"));

        return objUser;
    }

    public static User setDateToObjectUserForAdmin(ResultSet rs, User objUser) throws SQLException {

        objUser.setLogin(rs.getString("login"));
        objUser.setPassword(rs.getString("password"));

        objUser.setId(rs.getInt("id"));
        objUser.setName(rs.getString("name"));
        objUser.setSurname(rs.getString("surname"));
        objUser.setSubjectId(rs.getInt("subjectId"));
        objUser.setSubject_col(rs.getString("subject_col"));
        objUser.setMark(rs.getInt("mark"));

        return objUser;
    }

    public static Admin setDateToObjectAdmin(ResultSet rs, Admin objAdmin) throws SQLException {
        objAdmin.setId(rs.getInt("id"));
        objAdmin.setLogin(rs.getString("login"));
        objAdmin.setPassword(rs.getString("password"));
        objAdmin.setName(rs.getString("name"));

        return objAdmin;
    }

}