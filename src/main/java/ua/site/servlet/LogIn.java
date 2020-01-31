package ua.site.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logIn")
public class LogIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Login/logIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        HttpSession session = req.getSession();
        String message=(String)session.getAttribute("loginMessage");
        if(message!=null){

            //set atribut or smth to message. After get this atribut in jsp.
            //out.println(message);
            //session.setAttribute("message",message);
            //to delete message
            session.removeAttribute("loginMessage");
        }
            doGet(req, resp);
    }

}