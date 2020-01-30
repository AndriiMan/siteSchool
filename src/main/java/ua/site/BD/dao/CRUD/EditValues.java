package ua.site.BD.dao.CRUD;

import ua.site.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EditValues {

    public User get_value_of_user(int id){
        DB_Connection obj_DB_Connection=new DB_Connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        User obj_User=new User();
        try {
            String querry="select * from mybdtest.schoolchildren where id=?";
            ps=connection.prepareStatement(querry);
            ps.setString(1, String.valueOf(id));;
            rs=ps.executeQuery();
            while(rs.next()){
                obj_User.setId(rs.getInt("id"));
                obj_User.setName(rs.getString("name"));
                obj_User.setSurname(rs.getString("surname"));
                obj_User.setLogin(rs.getString("login"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return obj_User;
    }
    public void edit_user(User obj_User_Bean){
        DB_Connection obj_DB_Connection=new DB_Connection();
        Connection connection=obj_DB_Connection.get_connection();
        PreparedStatement ps=null;
        try {
            String querry="update mybdtest.schoolchildren set name=?,surname=?,login=? where id=?";
            ps=connection.prepareStatement(querry);
            ps.setString(1, obj_User_Bean.getName());;
            ps.setString(2, obj_User_Bean.getSurname());;
            ps.setString(3, obj_User_Bean.getLogin());;
            ps.setInt(4, obj_User_Bean.getId());;
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
