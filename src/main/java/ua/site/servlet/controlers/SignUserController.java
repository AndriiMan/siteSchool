package ua.site.servlet.controlers;

import com.mysql.cj.Session;
import ua.site.modal.LoginModal;
import ua.site.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/signUserController")
public class SignUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");

        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = new User(login, password);

        LoginModal objLoginModal = new LoginModal();

        //is that name and login is
        boolean flag = objLoginModal.checkUserInBd(user);

        if (flag) {
            //main page
            /*resp.sendRedirect("/cabinets/userCabinet.jsp");*/
            System.out.println(login);
            System.out.println(password);
            //System.out.println(user.getName());
            System.out.println("Good acceess user");

            //To get all user data that was login
            setSessionUserData(session,user);
            //delete bad session attribute
            req.getSession().removeAttribute("loginUserMessage");

            resp.sendRedirect("userCab");
        }
        else{
            System.out.println(login);
            System.out.println(password);
            System.out.println("Login Failed");

            //good try nut no, try again
            req.getRequestDispatcher("logIn");
            session.setAttribute("loginUserMessage", "Login Failed, User name and Password is Wrong");
            ////To login
            resp.sendRedirect("logIn");
        }
    }
    public void setSessionUserData(HttpSession session, User user){
        // Delete session in /logOut
        session.setAttribute("userIdSession", user.getId());
        session.setAttribute("userNameSession", user.getName());
        session.setAttribute("userSurnameSession", user.getSurname());

        session.setAttribute("userSubjectSession", user.getSubject_col());

        session.setAttribute("userSubIdSession", user.getSubjectId());

        session.setAttribute("userLoginSession", user.getLogin());
        session.setAttribute("userPasswordSession", user.getPassword());

        session.setAttribute("userSpecIdSession", user.getSpecializationId());
        session.setAttribute("userMarkSession", user.getMark());

    }
}