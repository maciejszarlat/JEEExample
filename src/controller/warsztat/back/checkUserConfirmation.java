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

@WebServlet(name = "checkUserConfirmation", urlPatterns = "/checkUserConfirmation")
public class checkUserConfirmation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String urlConfirm = request.getParameter("urlConfirm");
        System.out.println(urlConfirm);

        if (urlConfirm == null) {
            String emailPassed = "To konto zostało już aktywowane. Zaloguj się";
            request.setAttribute("emailConfirmation", emailPassed);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/front/login.jsp");
            dispatcher.forward(request, response);

        } else {
            User user = new User(urlConfirm, 1);

            try {
                UserDao.checkUserConfirmation(user, urlConfirm);
                response.getWriter().append("update udany");
            } catch (SQLException e) {
                e.printStackTrace();
            }

            String emailConfirmation = "Twoje konto zostalo pomyślnie aktywowane";

            request.setAttribute("emailConfirmation", emailConfirmation);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/front/login.jsp");
            dispatcher.forward(request, response);
        }


    }
}
