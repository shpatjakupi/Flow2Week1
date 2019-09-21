/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Customer;
import entity.Customer2;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author shpattt
 */
public class Tester {

    public static void main(String[] args) {
        Customer c1 = new Customer("asdf", "fdasf");
        Customer c2 = new Customer("bong", "dsad");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
 
    }
}
