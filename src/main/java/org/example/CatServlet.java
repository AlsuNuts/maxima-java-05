package org.example;
/*
Cделать генерацию страницы через обращение к сервлету и передачу ему параметров кота:

String name

int weight

boolean isAngry
 */

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cat")
public class CatServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        String nameCat = request.getParameter("name");
        int weightCat = Integer.parseInt(request.getParameter("weight"));
        boolean isAngryCat = Boolean.parseBoolean(request.getParameter("isAngry"));

        PrintWriter writer = response.getWriter();
        writer.write(String.format("<div><h1>Данные кота:</h1><h2>Имя: $s</h2><h3>Вес: $s</h3><h4>Сердитость: $s</h3></div>", nameCat, weightCat, isAngryCat));
        writer.close();

    }
}
//   writer.write("<h1>Hello from Servlet</h1>");