package main.controllers;

import main.services.StudentService;
import main.services.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Aleksei Lysov on 19.04.2017.
 */
public class ListServlet extends HttpServlet {

    private static StudentService studentService = new StudentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("name", "heloo!!!");
        req.setAttribute("list", studentService.getAllStudents());
        getServletContext().getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
