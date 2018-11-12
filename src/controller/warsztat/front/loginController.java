package controller.warsztat.    front;

import controller.warsztat.jbcrypt.BCrypt;
import model.back.User;
import model.back.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet(name = "loginController", urlPatterns = "/login")
public class loginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (password.equals("") || email.equals("")) {
            String error = "Podaj email i hasło!";

            request.setAttribute("errorEmpty", error);
            request.setAttribute("email", email);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/front/login.jsp");
            dispatcher.forward(request, response);
        } else {
            try {
                User user = UserDao.loginUser(email, password);

                if (user != null) {
                    int userId = user.getId();
                    String userEmail = user.getEmail();
                    String roleName = user.getRoleName();

                    HttpSession session = request.getSession();
                    session.setAttribute("userId", userId);
                    session.setAttribute("userEmail", userEmail);
                    session.setAttribute("isUserLogedIn", "yes");
                    session.setAttribute("roleName", roleName);


                    response.sendRedirect("/admin");
                } else {
                    String error = "Nieprawidłowy email lub hasło";

                    request.setAttribute("error", error);
                    request.setAttribute("email", email);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/front/login.jsp");
                    dispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                String error = "haslo albo email sa nieprawidlowe";
                request.setAttribute("error", error);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/front/login.jsp");
                dispatcher.forward(request, response);

            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/front/login.jsp");
        dispatcher.forward(request, response);
    }
}
