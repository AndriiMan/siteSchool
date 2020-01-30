package ua.site.BD.dao.CRUD;

import ua.site.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReadValues {
    public static void main(String[] args) {
        ReadValues obj_ReadValues=new ReadValues();
        obj_ReadValues.get_values();
    }
    public List get_values(){
        DB_Connection obj_DB_Connection=new DB_Connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        List list=new ArrayList();
        try {
            String querry="select * from mybdtest.schoolchildren";
            ps=connection.prepareStatement(querry);
            rs=ps.executeQuery();
            while(rs.next()){
                User obj_User=new User();

                //Console Check out information
                /*System.out.println(rs.getString("id"));
                System.out.println(rs.getString("login"));
                System.out.println(rs.getString("password"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("surname"));
                System.out.println(rs.getString("subject_id1"));
                System.out.println(rs.getString("subject_id2"));
                System.out.println(rs.getString("subject_id3"));
                System.out.println(rs.getString("specialization_id"));
                System.out.println(rs.getString("mark"));
                System.out.println();*/

                obj_User.setId(rs.getInt("id"));
                obj_User.setLogin(rs.getString("login"));
                obj_User.setPassword(rs.getString("password"));
                obj_User.setName(rs.getString("name"));
                obj_User.setSurname(rs.getString("surname"));
                obj_User.setSubjectid(rs.getInt("subject_id"));
                obj_User.setSpecialization(rs.getInt("specialization_id"));
                obj_User.setMark(rs.getInt("mark"));
                list.add(obj_User);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}