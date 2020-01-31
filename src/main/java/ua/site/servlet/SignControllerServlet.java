package ua.site.servlet;

import ua.site.modal.LoginModal;
import ua.site.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signController")
public class SignControllerServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");

        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(login, password);

        LoginModal objLoginModal = new LoginModal();

        //is that name and login is
        boolean flag = objLoginModal.checkUserName(user);
        if (flag) {
            //main page
            /*resp.sendRedirect("/cabinets/userCabinet.jsp");*/
            System.out.println(login);
            System.out.println(password);
            System.out.println("Good acceess user");

            //To get userName that was login
            session.setAttribute("userSession", user.getLogin());

            resp.sendRedirect("userCab");
        }
        else{
            System.out.println(login);
            System.out.println(password);
            System.out.println("Login Failed");

            //good try nut no, try again
            req.getRequestDispatcher("logIn");
            session.setAttribute("loginMessage", "Login Failed, User name and Password is Wrong");
            ////To login
            resp.sendRedirect("logIn");
        }
    }
}