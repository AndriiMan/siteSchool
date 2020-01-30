package ua.site.servlet;

import ua.site.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/home")
public class GetIndexPageServlet extends HttpServlet {

    private final static String index = "/WEB-INF/view/mainPage.jsp";

    private List<User> users;

    @Override
    public void init() throws ServletException {

        System.out.println("In controller Home");
        users = new CopyOnWriteArrayList<>();
        users.add(new User(1,"Javac1", "java","pas1","Surname1",2,121));
        users.add(new User(2,"Javac2", "java","pas2","Surname2",1,124));

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("users", users);
        //req.getRequestDispatcher(index).forward(req, resp);
        req.getRequestDispatcher("/WEB-INF/view/mainPage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");

        if (!requestIsValid(req)) {
            doGet(req, resp);
        }

        final String id = req.getParameter("id");
        final String name = req.getParameter("name");
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

      //  final User user = new User( Integer.parseInt(id),name, login,password);

       // users.add(user);

        doGet(req, resp);
    }

    private boolean requestIsValid(final HttpServletRequest req) {

        final String name = req.getParameter("name");
        final String age = req.getParameter("age");

        return name != null && name.length() > 0 &&
                age != null && age.length() > 0 &&
                age.matches("[+]?\\d+");
    }
}
