package ua.site.modal;

import ua.site.BD.dao.CRUD.BDConnection;
import ua.site.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


//Class for login
public class LoginModal {
    public boolean checkUserName(User objUser) {
        boolean flag = false;
        BDConnection objBDConnection = new BDConnection();
        Connection connection = objBDConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String qurey = "select * from mybdtest.schoolchildren where login=? and password=?";
            ps = connection.prepareStatement(qurey);
            ps.setString(1, objUser.getLogin());
            ps.setString(2, objUser.getPassword());

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
