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
            String querry="select * from mybdtest.schoolchildren where id=?";
            ps=connection.prepareStatement(querry);
            ps.setString(1, String.valueOf(id));;
            rs=ps.executeQuery();
            while(rs.next()){
                objUser.setId(rs.getInt("id"));
                objUser.setName(rs.getString("name"));
                objUser.setSurname(rs.getString("surname"));
                objUser.setLogin(rs.getString("login"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return objUser;
    }
    public void editUser(User objUserBean){
        BDConnection objBDConnection =new BDConnection();
        Connection connection= objBDConnection.getConnection();
        PreparedStatement ps=null;
        try {
            String querry="update mybdtest.schoolchildren set name=?,surname=?,login=? where id=?";
            ps=connection.prepareStatement(querry);
            ps.setString(1, objUserBean.getName());;
            ps.setString(2, objUserBean.getSurname());;
            ps.setString(3, objUserBean.getLogin());;
            ps.setInt(4, objUserBean.getId());;
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
