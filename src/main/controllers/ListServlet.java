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

        String id = req.getParameter("delete");

        if (( id != null) && (!id.isEmpty())) {
            deleteStudent(req.getParameter("delete"));
            resp.sendRedirect(req.getContextPath() + "/listStudents");
        }else {
            req.setAttribute("list", studentService.getAllStudents());
            getServletContext().getRequestDispatcher("/list.jsp").forward(req, resp);
        }
    }

    private void deleteStudent(String id){
        if (id.matches("\\d+")) {
            studentService.deleteStudent(Integer.parseInt(id));
        }
    }
}
