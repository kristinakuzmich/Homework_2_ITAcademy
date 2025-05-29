package by.it_academy.jd2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(name = "Servlet3", urlPatterns = "/print")
public class PrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        Enumeration<String> parameterNames = req.getParameterNames();

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();


        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            String value = req.getParameter(paramName);
            writer.write("<p>" + paramName + " " + value + "</p>");
        }

    }
}
