/*
package ua.site.BD.dao;

import ua.site.model.User;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SignInDAO {

    public static List<User> getUsers(){
        List<User> usersList;

        String query = "SELECT * FROM mybdtest.admin";

        try (ResultSet customerResSet = ConnectionPool.getConnection().
                createStatement().executeQuery(query)) {

            usersList = initUsersList(customerResSet);

        } catch (SQLException e) {

            e.printStackTrace();
            return null;
        }

        return usersList;
    }

    //returns null if login or password are not existed
 */
/*public User getUserByLogPas(String login, String password){

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet userResSet = null;

        String query = "SELECT * FROM cms_db.сustomers WHERE login = ? AND password = ?";

        try {
            List<User> usersList = null;
            User user = null;

            connection = ConnectionPool.getConnection();

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            userResSet = preparedStatement.executeQuery();

            usersList = initUsersList(userResSet);

            if (usersList.size() == 1) {
                user = usersList.get(0);

            }


            return user;

        } catch (SQLException e) {

            e.printStackTrace();
        }finally {
            try {
                userResSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
        return null;
    }*//*



    private static List<User> initUsersList(ResultSet userResSet) throws SQLException {
        User user;
        List<User> usersList = new LinkedList<>();

        while (userResSet.next()){
            user = new User(
                    userResSet.getInt("id"),
                    userResSet.getString("login"),
                    userResSet.getString("password"),
                    userResSet.getString("name"),
                    userResSet.getString("surname"),
                    userResSet.getInt("subjectid"),
                    userResSet.getInt("specialization")
            );
            usersList.add(user);
        }
        return usersList;
    }
}
*/
