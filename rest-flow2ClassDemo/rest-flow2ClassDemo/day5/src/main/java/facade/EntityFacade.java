package facade;

import entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.SynchronizationType;

public class EntityFacade  {


    //TODO Remove/Change this before use
    public long getPersonsCount() {
          EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try {
            long PersonsCount = (long) em.createQuery("SELECT COUNT(s) FROM Student s").getSingleResult();
            return PersonsCount;
        } finally {
            em.close();
        }

    }
    

    public static List<Student> getAllPersons() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createNamedQuery("Student.findAll").getResultList();
        } finally {
            em.close();
        }
    }
    
    public static void main(String[] args) {
     
        System.out.println(getAllPersons());
    }
}
