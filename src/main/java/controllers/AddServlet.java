package controllers;

import dao.PetDao;
import dao.factory.DaoFactory;
import model.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddServlet", urlPatterns = "/add")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pet pet = parse(request);
        PetDao petDao = DaoFactory.getPetDao();
        petDao.save(pet);
        response.sendRedirect("/index");
    }

    private Pet parse(HttpServletRequest request) {
        String name = request.getParameter("name");
        String note = request.getParameter("note");
        String idRead = request.getParameter("id");
        Pet pet = new Pet();
        pet.setName(name);
        pet.setNote(note);
        if (idRead != null && idRead != "") {
            pet.setId(Long.parseLong(idRead));
        }
        System.out.println("pet = " + pet);
        return pet;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
