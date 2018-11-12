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

@WebServlet(name = "EmployerAddController", urlPatterns = "/admin/employer/add")
public class EmployerAddController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        double hourlyRate = Double.parseDouble(request.getParameter("hourlyRate"));
        int role = 2;

        User user = new User(email, role, firstName, lastName, hourlyRate);

        try{
            UserDao.addUser(user);

            String confirm = "Pracownik został pomyślnie dodany";
            request.setAttribute("confirm", confirm);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/back/employers.jsp");
            dispatcher.forward(request,response);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/back/addEmployer.jsp");

        requestDispatcher.forward(request,response);
    }
}
