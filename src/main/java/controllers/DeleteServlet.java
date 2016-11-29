package controllers;

import dao.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        System.out.println("id = " + id);
        DaoFactory.getPetDao().delete(id);
        request.setAttribute("pet", null);
        request.setAttribute("pets", DaoFactory.getPetDao().list());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
