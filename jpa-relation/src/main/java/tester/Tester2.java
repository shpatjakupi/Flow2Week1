/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Address;
import entity.Customer;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author shpattt
 */
public class Tester2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

        EntityManager em = emf.createEntityManager();

        Customer cus = new Customer("John", "Damm");
        Address address = new Address("Trebosh te Iza", "Boja");
        Address address1 = new Address("Tetove", "QiaNanen");
        cus.addAddress(address);
        cus.addAddress(address1);
         

// cus.setAddress(address);
// address.setCustomer(cus);
        try {
            em.getTransaction().begin();
            em.persist(cus);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    //    em = emf.createEntityManager();
  //      Address found = em.find(Address.class, cus.getAddress().getId());
//        System.out.println("Adresse ---> " + found.getCustomer());

    }
}
