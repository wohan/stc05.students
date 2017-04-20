package main.controllers;

import main.model.entity.User;
import main.services.StudentService;
import main.services.StudentServiceImpl;
import main.services.UserService;
import main.services.UserServiceImpl;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Aleksei Lysov on 19.04.2017.
 */
public class StudentServlet extends HttpServlet {

    private static StudentService studentService = new StudentServiceImpl();
    private static final Logger LOGGER = Logger.getLogger(StudentServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/student.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String login = req.getParameter("login");
//        String passwor = req.getParameter("password");
//
//        User user = null;
//        if ((user = userService.auth(login, passwor)) != null){
//            req.getSession().setAttribute("login", login);
//            LOGGER.debug("login: " + login);
//            resp.sendRedirect(req.getContextPath() + "/listStudents");
//        }
//
////        if (("user".equals(login)) && ("password".equals(passwor)))
////        if (("user".equals(login)) && ("password".equals(passwor)))
////            resp.sendRedirect(req.getContextPath() + "/listStudents");
////        else
////            resp.sendRedirect(req.getContextPath() + "/error");
        System.out.println("test");
        resp.sendRedirect(req.getContextPath() + "/listStudents");
    }


}
