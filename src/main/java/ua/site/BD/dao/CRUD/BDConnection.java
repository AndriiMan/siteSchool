package ua.site.BD.dao.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;

//Class to connect to bd
public class BDConnection {
    public static void main(String[] args) {
        BDConnection objBDConnection =new BDConnection();
        System.out.println(objBDConnection.getConnection());
    }
    public Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybdtest?serverTimezone=Europe/Moscow","root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
        return connection;
    }
}
