package by.it_academy.jd2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/fin")
public class FinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String[] rows = req.getParameterValues("rows");

        PrintWriter writer = resp.getWriter();
        writer.write("<h2>Калькулятор усреднения акций</h2>");

        writer.write("<table border='1'>");
        writer.write("<tr><th></th><th>Цена (₽)</th><th>Количество (n)</th><th>Сумма (₽)</th></tr>");

        double totalQuantity = 0;
        double totalAmount = 0;
        double averagePrice = 0;

        for (int i=1; i<= rows.length; i++) {
            String[] cells = rows[i-1].split(",");
            writer.write("<tr>");
            writer.write("<td>" + i + "</td>");
            for (String cell : cells) {
                writer.write("<td>" + cell + "</td>");
            }

            double result = Double.parseDouble(cells[0]) * Double.parseDouble(cells[1]);
            totalQuantity = totalQuantity + Long.parseLong(cells[1]);
            totalAmount = totalAmount + result;
            averagePrice = totalAmount/totalQuantity;

            writer.write("<td>" + result + "</td>");
            writer.write("</tr>");
        }
        writer.write("</table>");



        writer.write("<table border='1' style='margin-top: 20px'>");
        writer.write("<tr><td>Общая сумма, ₽</td><td>Общая численность</td><td>Средняя цена, ₽</td></tr>");
        writer.write("<tr><td>" + totalAmount + "</td><td>" + totalQuantity + "</td><td>" + averagePrice + "</td></tr>");
        writer.write("</table>");
    }
}

