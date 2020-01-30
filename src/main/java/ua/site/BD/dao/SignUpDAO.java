/*package ua.site.BD.dao;

import ua.site.model.User;

import javax.servlet.annotation.WebServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/signUp")
public class SignUpDAO {

    public void createUser(User user)    {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO mybdtest.admin " +
                "(name, login, password)" +
                "VALUES (?, ?, ?)";

        try {

            connection = ConnectionPool.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(sql);

            int role = 1;


            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getPassword());

            preparedStatement.executeUpdate();

            connection.commit();

        } catch (SQLException e) {

            try {
                connection.rollback();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}*/
