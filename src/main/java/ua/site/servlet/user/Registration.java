package ua.site.servlet.user;

import ua.site.BD.dao.CRUD.BDConnection;
import ua.site.BD.dao.CRUD.InsertValues;
import ua.site.BD.dao.CRUD.ReadValues;
import ua.site.modal.LoginModal;
import ua.site.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/registration")
public class Registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        String subject_col= req.getParameter("subject_col");

        //System.out.println("Hardcore israel "+req.getParameter("subject_col"));

        InsertValues objInsertValues = new InsertValues();

        User userCheck = new User(login, password, name, surname);
        LoginModal loginModal = new LoginModal();

        //flag is that user login and password already are in bd
        //boolean checkUserInBD = loginModal.checkUserInBd(userCheck);

        //flag is that user login in bd
        boolean checkUserLoginInBD = checkLoginInBd(userCheck);
        System.out.println("User is in bd " + checkUserLoginInBD);

        //flag is that insert date is correct
        boolean insertCorrect = objInsertValues.requestIsValid(login, password, name, surname,subject_col);
        System.out.println("insertCorrect is correct" + insertCorrect);

        if (!insertCorrect || checkUserLoginInBD) {
            System.out.println("not nice");

        } else {
            System.out.println("nice");
            objInsertValues.insertValues(login, password, name, surname, subject_col);
            resp.sendRedirect("userCab");

        }
    }

    public boolean checkLoginInBd(User objUser) {
        boolean flag = false;
        BDConnection objBDConnection = new BDConnection();
        Connection connection = objBDConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String querry = "select * from mybdtest.schoolchildren " +
                    " where login=?";

            ps = connection.prepareStatement(querry);

            ps.setString(1, objUser.getLogin());

            // See Prepared statement
            System.out.println("Check login "+ps);

            rs = ps.executeQuery();
            if (rs.next()) {
                //insert date u wanna see in user cabinet
                //ReadValues.setDateToObjectUser(rs, objUser);
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

