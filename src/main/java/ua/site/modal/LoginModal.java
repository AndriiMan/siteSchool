package ua.site.modal;

import ua.site.BD.dao.CRUD.BDConnection;
import ua.site.BD.dao.CRUD.ReadValues;
import ua.site.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//Class for login
public class LoginModal {


    public boolean checkUserInBd(User objUser) {
        boolean flag = false;
        BDConnection objBDConnection = new BDConnection();
        Connection connection = objBDConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String querry="select * from mybdtest.schoolchildren " +
                    "inner join mybdtest.subject on schoolchildren.subjectId=subject.subjectId " +
                    /*"inner join mybdtest.specialization on schoolchildren.specializationId=specialization.specialization_id"+*/
                    " where login=? and password=? ";

            ps = connection.prepareStatement(querry);

            ps.setString(1, objUser.getLogin());
            ps.setString(2, objUser.getPassword());

            // See Prepared statement
            //System.out.println(ps);


            rs = ps.executeQuery();
            if (rs.next()) {
                //insert date u wanna see in user cabinet
                ReadValues.setDateToObjectUserForAdmin(rs,objUser);
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
