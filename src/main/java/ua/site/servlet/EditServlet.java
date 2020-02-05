package ua.site.servlet;

import ua.site.BD.dao.CRUD.EditValues;
import ua.site.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("In do get editServlet");

        req.getRequestDispatcher("/edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF8");

        //System.out.println("In do post editServlet");

        HttpSession session=req.getSession();

        String id= req.getParameter("userId");

        EditValues editValues=new EditValues();
        User objUser=editValues.getValueOfUserForAdmin(Integer.parseInt(id));

        session.setAttribute("userId",objUser.getId());
        session.setAttribute("userName",objUser.getName());
        session.setAttribute("userSurname",objUser.getSurname());
        session.setAttribute("userSubject",objUser.getSubject_col());
        session.setAttribute("userMark",objUser.getMark());
        session.setAttribute("userSubId",objUser.getSubjectId());
        session.setAttribute("userLogin",objUser.getLogin());
        session.setAttribute("userPassword",objUser.getPassword());

        session.setAttribute("userId", id);

        doGet(req, resp);
    }
}
