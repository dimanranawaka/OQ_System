package servlet;

import dao.StudentsDao;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "studentValidator")

public class StudentValidatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter writer = resp.getWriter();

        String userName = req.getParameter("studentUserName");
        String studentPassword = req.getParameter("studentPassword");

        Student student = new Student();

        student.setStudentUserName(userName);
        student.setStudentUserName(studentPassword);

        boolean status = StudentsDao.doValidate(student);

        HttpSession session = req.getSession();

        if (status){

            session.setAttribute("studentUserName",student.getStudentUserName());
            session.setAttribute("name",student.getName());
            resp.sendRedirect("StudentInstructions.jsp");

        }else {

            String msg = "Invalid Username or Password";
            resp.sendRedirect("StudentLogin.jsp?msg="+msg);

        }

    }
}
