package ua.site.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logOut")
public class LogOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Is logout");
        req.getSession().removeAttribute("userNameSession");
        req.getSession().removeAttribute("userSurnameSession");
        req.getSession().removeAttribute("userSubjectSession");
        req.getSession().removeAttribute("userMarkSession");

        req.getSession().removeAttribute("adminNameSession");
        req.getSession().removeAttribute("adminLoginSession");
        req.getSession().removeAttribute("adminPasswordSession");
        req.getSession().removeAttribute("userSession");
        req.getSession().removeAttribute("user");

        req.getSession().removeAttribute("loginAdminMessage");
        req.getSession().removeAttribute("loginUserMessage");

        resp.sendRedirect("home");
    }

}

