package ua.site.BD.dao.CRUD;

import ua.site.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Class to edit date of user
public class EditValues {

    public User getValueOfUser(int id){
        BDConnection objBDConnection =new BDConnection();
        Connection connection= objBDConnection.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        User objUser=new User();
        try {
            String querry="select * from mybdtest.schoolchildren " +
                    "inner join mybdtest.subject on schoolchildren.subjectId=subject.subjectId " +
                    "inner join mybdtest.specialization on schoolchildren.specializationId=specialization.specialization_id " +
                    "where id=?";
            ps=connection.prepareStatement(querry);
            ps.setString(1, String.valueOf(id));;
            rs=ps.executeQuery();
            while(rs.next()){
                ReadValues.setDateToObjectUser(rs,objUser);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return objUser;
    }

    public User getValueOfUserForAdmin(int id) {
        BDConnection objBDConnection = new BDConnection();
        Connection connection = objBDConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        User objUser = new User();
        try {
            String querry = "select * from mybdtest.schoolchildren " +
                    "inner join mybdtest.subject on schoolchildren.subjectId=subject.subjectId " +
                    "where id=?";
            ps = connection.prepareStatement(querry);
            ps.setString(1, String.valueOf(id));
            ;
            rs = ps.executeQuery();
            while (rs.next()) {
                ReadValues.setDateToObjectUserForAdmin(rs, objUser);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return objUser;
    }

    public void editUser(User objUser){
        BDConnection objBDConnection =new BDConnection();
        Connection connection= objBDConnection.getConnection();
        PreparedStatement ps=null;
        try {
            String querry="update mybdtest.schoolchildren set login=?, password=?, name=?, surname=?, " +

                    " mark=?, subjectId=?, specializationId=?  where id=?";

            System.out.println("In edit user");

            ps=connection.prepareStatement(querry);
            ps.setString(1, objUser.getLogin());
            ps.setString(2, objUser.getPassword());
            ps.setString(3, objUser.getName());
            ps.setString(4, objUser.getSurname());
            ps.setInt(5, objUser.getMark());
            ps.setInt(6, objUser.getSubjectId());
            ps.setInt(7, objUser.getSpecializationId());
            ps.setInt(8, objUser.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}