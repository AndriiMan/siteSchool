package ua.site.BD.dao.CRUD;

import ua.site.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
                    "inner join mybdtest.specialization on schoolchildren.specializationId=specialization.specialization_id";
            ps=connection.prepareStatement(querry);
            rs=ps.executeQuery();
            while(rs.next()){
                User objUser=new User();

                //Console Check out information
                /*System.out.println(rs.getString("id"));
                System.out.println(rs.getString("login"));
                System.out.println(rs.getString("password"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("surname"));
                System.out.println(rs.getString("subjectId"));
                System.out.println(rs.getString("specializationId"));
                System.out.println(rs.getString("mark"));
                System.out.println();*/

                objUser.setId(rs.getInt("id"));
                objUser.setLogin(rs.getString("login"));
                objUser.setPassword(rs.getString("password"));
                objUser.setName(rs.getString("name"));
                objUser.setSurname(rs.getString("surname"));
                objUser.setSubjectId(rs.getInt("subjectId"));
                objUser.setSubject_col(rs.getString("subject_col"));
                objUser.setSpecializationId(rs.getInt("specializationId"));
                objUser.setSpecialization(rs.getString("specialization"));
                objUser.setMark(rs.getInt("mark"));
                list.add(objUser);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}