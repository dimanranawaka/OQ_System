package servlet;

import dao.AdminsDao;
import model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/adminValidator")
public class AdminValidatorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        resp.setContentType("text/html");

        String adminUserName = req.getParameter("adminUserName");
        String adminPassword = req.getParameter("adminPassword");

        Admin admin = new Admin();

        admin.setAdminUserName(adminUserName);
        admin.setAdminPassword(adminPassword);

        boolean status = AdminsDao.doValidate(admin);

        HttpSession session = req.getSession();

        if (status){

            session.setAttribute("userName", admin.getAdminUserName());
            resp.sendRedirect("AdminPanel.jsp");

        }else {

            String message2 = "Invalid Username or Password";
            resp.sendRedirect("AdminLogin.jsp?message2="+message2);

        }

    }
}
