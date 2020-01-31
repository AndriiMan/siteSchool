package ua.site.modal;

import ua.site.BD.dao.CRUD.DB_Connection;
import ua.site.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//Class for login
public class Login_Modal {
    public boolean check_user_name(User obj_User) {
        boolean flag = false;
        DB_Connection obj_DB_Connection = new DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String qurey = "select * from mybdtest.schoolchildren where login=? and password=?";
            ps = connection.prepareStatement(qurey);
            ps.setString(1, obj_User.getLogin());
            ps.setString(2, obj_User.getPassword());

            // See Prepared statement
            //System.out.println(ps);

            rs = ps.executeQuery();
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
        return flag;
    }
}
