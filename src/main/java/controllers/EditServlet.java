package controllers;

import dao.factory.DaoFactory;
import model.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditServlet", urlPatterns = {"/edit"})
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Pet pet = DaoFactory.getPetDao().find(id);
        System.out.println("id = " + id);
        System.out.println("pet = " + pet);
        request.setAttribute("pet", pet);
        request.setAttribute("pets", DaoFactory.getPetDao().list());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
