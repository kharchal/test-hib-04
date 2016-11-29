package controllers;

import dao.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexServlet", urlPatterns = {"", "/index"})
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--------- Index:get ----------");
        request.setAttribute("msg", "Hello from index!");
        request.setAttribute("pet", null);
        request.setAttribute("pets", DaoFactory.getPetDao().list());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
