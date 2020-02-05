package ua.site.controller;

import ua.site.BD.dao.CRUD.EditValues;
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

@WebServlet("/editController")
public class EditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("adminCab").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id=req.getParameter("userId");
        String login=req.getParameter("userLogin");
        String password=req.getParameter("userPassword");
        String name=req.getParameter("userName");
        String surname=req.getParameter("userSurname");
        String subjectId=req.getParameter("userSubId");
        String specialization_id=req.getParameter("userSpecId");
        String mark=req.getParameter("mark");

        User obj_User_Bean=new User();

        obj_User_Bean.setId(Integer.parseInt(id));
        obj_User_Bean.setName(name);
        obj_User_Bean.setSurname(surname);
        obj_User_Bean.setLogin(login);
        obj_User_Bean.setPassword(password);

        System.out.println(login);
        System.out.println(password);
        System.out.println(name);
        System.out.println(surname);
        System.out.println(subjectId);
        System.out.println("mark is "+mark);

        obj_User_Bean.setSubjectId(Integer.parseInt(subjectId));
        /*obj_User_Bean.setSpecializationId(Integer.parseInt(specialization_id));*/
        obj_User_Bean.setMark(Integer.parseInt(mark));

        EditValues editValues= new EditValues();
        editValues.editUser(obj_User_Bean);


        HttpSession sessionUser = req.getSession();
        ReadValues objReadValues = new ReadValues();
        List<User> list = objReadValues.getValuesForAdmin();

        sessionUser.setAttribute("userSession", list);
        req.getRequestDispatcher("/cabinets/adminCabinet.jsp").forward(req, resp);
        /*req.getRequestDispatcher("/WEB-INF/view/mainPage.jsp").forward(req, resp);*/
        /*doGet(req, resp);*/
    }
}
