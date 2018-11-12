package controller.warsztat.front;

import controller.warsztat.validation.EmailValidation;
import model.back.User;
import model.back.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;


@WebServlet(name = "registerController", urlPatterns = "/register")
public class registerController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");

        String regCodeTemp = email;

        boolean emailValidation = EmailValidation.isEmail(email);


        try {
            if(!emailValidation){
                String error = "Podaj prawdziwy adres e-mail";

                request.setAttribute("errorWrongEmail", error);
                request.setAttribute("email", email);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/front/register.jsp");
                dispatcher.forward(request,response);
            }else if(password.equals("") || password2.equals("") || email.equals("")){
                String error = "Wszystkie pola muszą być wypełnione";

                request.setAttribute("errorEmpty", error);
                request.setAttribute("email", email);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/front/register.jsp");
                dispatcher.forward(request,response);
            }else if (UserDao.checkUser(email)){
                String error = "Taki email juz istnieje!!!";
                request.setAttribute("email", email);
                request.setAttribute("errorDup", error);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/front/register.jsp");
                dispatcher.forward(request,response);
            }else if(!password.equals(password2)){
                String error = "Podane hasła różnią się od siebie";

                request.setAttribute("errorPasswordNotEquals", error);
                request.setAttribute("email", email);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/front/register.jsp");
                dispatcher.forward(request,response);


            }else {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(regCodeTemp.getBytes(), 0, regCodeTemp.length());
                String regCode = new BigInteger(1, md.digest()).toString(16);

                //String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
                User user = new User(email, password, regCode);
                try{
                    UserDao.registerUser(user);
                    String urlConfirm = regCode;
                    request.setAttribute("urlConfirm", urlConfirm);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/front/register.jsp");
                    dispatcher.forward(request,response);


                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/view/front/register.jsp");
        dispatcher.forward(request,response);
    }
}
