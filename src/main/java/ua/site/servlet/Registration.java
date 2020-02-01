package ua.site.servlet;

import ua.site.BD.dao.CRUD.InsertValues;
import ua.site.modal.LoginModal;
import ua.site.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String subjectId = req.getParameter("subjectId");

        InsertValues objInsertValues = new InsertValues();

        User userCheck = new User(login, password, name, surname, subjectId);
        LoginModal loginModal = new LoginModal();

        //flag is that user login and password already are in bd
        boolean checkUserInBD = loginModal.checkUserLogin(userCheck);

        //flag is that insert date is correct
        boolean insertCorrect = objInsertValues.requestIsValid(login, password, name, surname, subjectId);
        //System.out.println(insertCorrect);

        if (!insertCorrect || checkUserInBD) {
            System.out.println("not nice");
            resp.sendRedirect("registration");
        } else {
            System.out.println("nice");
            objInsertValues.insertValues(login, password, name, surname, subjectId);
            resp.sendRedirect("userCab");
        }
    }
}
