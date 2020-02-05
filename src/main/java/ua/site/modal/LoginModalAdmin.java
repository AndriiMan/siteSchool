package ua.site.modal;

import ua.site.BD.dao.CRUD.BDConnection;
import ua.site.BD.dao.CRUD.ReadValues;
import ua.site.model.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginModalAdmin {
    public boolean checkAdminLogin(Admin objAdmin) {
        boolean flag = false;
        BDConnection objBDConnection = new BDConnection();
        Connection connection = objBDConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String querry = "select * from mybdtest.admin where login=? and password=? ";

            ps = connection.prepareStatement(querry);

            ps.setString(1, objAdmin.getLogin());
            ps.setString(2, objAdmin.getPassword());

            // See Prepared statement
            System.out.println(ps);


            rs = ps.executeQuery();
            if (rs.next()) {
                //insert date u wanna see in admin cabinet
                ReadValues.setDateToObjectAdmin(rs, objAdmin);
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