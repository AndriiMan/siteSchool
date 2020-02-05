package ua.site.controller;

import ua.site.BD.dao.CRUD.EditValues;
import ua.site.BD.dao.CRUD.InsertValues;
import ua.site.BD.dao.CRUD.ReadValues;
import ua.site.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/userSpecControl")
public class UserSpecializationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("showUsers").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id=req.getParameter("userId");
        String login=req.getParameter("userLogin");
        String password=req.getParameter("userPassword");
        String name=req.getParameter("userName");
        String surname=req.getParameter("userSurname");
        String subjectId=req.getParameter("userSubId");
        String mark=req.getParameter("mark");

        String specialization_id=InsertValues.getSpecIdByName(req.getParameter("specialization"));

        System.out.println("Sub id is "+subjectId);
        System.out.println("Name is is "+name);
        System.out.println("id is "+id);
        System.out.println("specialization_id is "+specialization_id);
        /*String subject_col= req.getParameter("subject_col");*/




        User obj_User=new User();

        obj_User.setId(Integer.parseInt(id));
        obj_User.setName(name);
        obj_User.setSurname(surname);
        obj_User.setLogin(login);
        obj_User.setPassword(password);
        obj_User.setSpecializationId(Integer.parseInt(specialization_id));

        System.out.println(login);
        System.out.println(password);
        System.out.println(name);
        System.out.println(surname);
        System.out.println(subjectId);
        System.out.println(specialization_id);

        System.out.println("special id is "+specialization_id);

        obj_User.setSubjectId(Integer.parseInt(subjectId));
        /*obj_User_Bean.setSpecializationId(Integer.parseInt(specialization_id));*/
        obj_User.setMark(Integer.parseInt(mark));

        EditValues editValues= new EditValues();
        editValues.editUser(obj_User);

        HttpSession sessionUser = req.getSession();
        ReadValues objReadValues = new ReadValues();
        List<User> list = objReadValues.getValues();

        sessionUser.setAttribute("userSession", list);

        req.getRequestDispatcher("/WEB-INF/view/showUsers.jsp").forward(req, resp);
        /*req.getRequestDispatcher("/WEB-INF/view/mainPage.jsp").forward(req, resp);*/
        /*doGet(req, resp);*/
    }


}
