package ua.site.servlet;

import ua.site.BD.dao.CRUD.ReadValues;
import ua.site.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@WebServlet("/showUsers")
public class ShowUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/view/showUsers.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");

        System.out.println("In do post print user");

        HttpSession sessionUser = req.getSession();

        ReadValues objReadValues = new ReadValues();
        List<User> list = objReadValues.getValues();

        sessionUser.setAttribute("userSession", list);
        doGet(req, resp);

    }
}