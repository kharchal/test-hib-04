package dao.factory;

import dao.PetDao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DaoFactory {
    private static EntityManagerFactory emf;
    private static PetDao petDao;

    public static void init(String name) {
        emf = Persistence.createEntityManagerFactory(name);
        System.out.println("emf = " + emf);
    }

    public static void destroy() {
        emf.close();
    }

    public static synchronized PetDao getPetDao() {
        if (petDao == null) {
            petDao = new PetDao(emf);
        }
        return petDao;
    }
}
