package controller.warsztat.back;

import model.back.User;
import model.back.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EmployersController", urlPatterns = "/admin/employers")
public class EmployersController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        try {
            List<User> users = UserDao.getUsers();
            request.setAttribute("USER_LIST", users);


            RequestDispatcher dispatcher = request.getRequestDispatcher("/view/back/employers.jsp");
            dispatcher.forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
