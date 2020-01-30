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

@WebServlet("/showUsers")
public class ShowUsers extends HttpServlet {

    private List<User> users;

    @Override
    public void init() throws ServletException {

        System.out.println("In controller ShowUser");
        users = new CopyOnWriteArrayList<>();
        //users= SignInDAO.getUsers();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("users", users);
        //req.getRequestDispatcher(index).forward(req, resp);
        req.getRequestDispatcher("/WEB-INF/view/showUsers.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");

/*

        doGet(req, resp);

        final String id = req.getParameter("id");
        final String name = req.getParameter("name");
        final String login = req.getParameter("name");
        final String password = req.getParameter("password");
*/

      //  final User user = new User(Integer.parseInt(id), name, login, password);

        //users.add(user);

        doGet(req, resp);
    }

}
