package ua.site.servlet.controlers;

import ua.site.BD.dao.CRUD.ReadValues;
import ua.site.modal.LoginModal;
import ua.site.modal.LoginModalAdmin;
import ua.site.model.Admin;
import ua.site.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/signAdminController")
public class SignAdminController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");

        HttpSession session = req.getSession();
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Admin admin = new Admin(login, password);

        LoginModalAdmin objLoginModal = new LoginModalAdmin();

        //is that name and login is right
        boolean flag = objLoginModal.checkAdminLogin(admin);
        if (flag) {
            //main page
            /*resp.sendRedirect("/cabinets/userCabinet.jsp");*/
            System.out.println(login);
            System.out.println(password);
            System.out.println(admin.getName());
            System.out.println("Good acceess admin");

            //To get all user data that was login
            setSessionAdminData(session,admin);

            //tested
            //System.out.println("In do post print user for admin!!!");

            HttpSession sessionUser = req.getSession();
            ReadValues objReadValues = new ReadValues();
            List<User> list = objReadValues.getValuesForAdmin();

            sessionUser.setAttribute("userSession", list);

            //delete bad session attribute
            req.getSession().removeAttribute("loginAdminMessage");

            resp.sendRedirect("adminCab");
        }
        else{
            System.out.println(login);
            System.out.println(password);
            System.out.println("Login Failed");

            //good try nut no, try again
            req.getRequestDispatcher("logInAdmin");
            session.setAttribute("loginAdminMessage", "Login Failed, User name and Password is Wrong");
            ////To login
            resp.sendRedirect("logInAdmin");
        }
    }
    public void setSessionAdminData(HttpSession session, Admin admin){
        session.setAttribute("adminNameSession", admin.getName());
        session.setAttribute("adminLoginSession", admin.getLogin());
        session.setAttribute("adminPasswordSession", admin.getPassword());

    }
}
