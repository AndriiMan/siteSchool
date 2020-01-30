/*
package ua.site.servlet;


import ua.site.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {


    @Override
    public void init() throws ServletException {
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

       // User user = usersModel.getUser(login, password);

     //   req.getSession().setAttribute("user", user);
       // System.out.println("Current user:\n" + user.toString());

        resp.sendRedirect("home");
    }
}
*/
