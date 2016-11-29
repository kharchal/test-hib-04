package dao;

import model.Pet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PetDao {
    private EntityManagerFactory emf;

    public PetDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void save(Pet pet) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            if (pet.getId() == null || pet.getId() == 0) {
                em.persist(pet);
            } else {
                em.merge(pet);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Can't save pet: " + pet);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Object list() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Pet> query = em.createQuery("FROM Pet", Pet.class);
        List<Pet> pets = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return pets;
    }

    public Pet find(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Pet pet = em.find(Pet.class, id);
        em.getTransaction().commit();
        em.close();
        return pet;
    }

    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Pet pet = em.find(Pet.class, id);
        em.remove(pet);
        em.getTransaction().commit();
        em.close();
    }
}
