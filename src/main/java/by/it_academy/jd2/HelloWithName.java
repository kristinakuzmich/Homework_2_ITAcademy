package by.it_academy.jd2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet2", urlPatterns = "/hello_with_name")
public class HelloWithName extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        String name1 = req.getParameter("firstName");
        String name2 = req.getParameter("lastName");

        System.out.println("firstName = " + name1);
        System.out.println("lastName = " + name2);

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<p><span style='color: blue'> Hello, " + name1 + " " + name2 + "</span></p>");
    }
}
