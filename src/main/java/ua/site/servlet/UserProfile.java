/*
package ua.site.servlet;

import ua.site.BD.dao.CRUD.DB_Connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

*/
/**
 * Servlet implementation class UserProfile
 *//*

@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;

    */
/**
     * @see HttpServlet#HttpServlet()
     *//*

    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

    */
/**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     *//*

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    */
/**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     *//*

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        try {
            DB_Connection obj_DB_Connection=new DB_Connection();
            Connection con=obj_DB_Connection.get_connection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select mybdtest.schoolchildren.login,mybdtest.schoolchildren.password from mybdtest.schoolchildren where login='"+login+"' and password='"+pass+"'");

            if(rs.next()) {
                //response.sendRedirect("http://localhost:8080/loginDemo/WelcomeUser.jsp?name="+rs.getString("uname"));
               // response.sendRedirect(request.getContextPath() + "/welcomeUser.jsp");
                response.sendRedirect(request.getContextPath() + "/welcomeUser.jsp" +"?"+rs.getString("login"));
                HttpSession session = request.getSession();
                session.setAttribute("login", login);

            }else {
                out.println("Wrong id and password");
            }



        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

}
*/
