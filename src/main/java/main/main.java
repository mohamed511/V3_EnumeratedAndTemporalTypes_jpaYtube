package main;

import entity.Event;
import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        // define Entity Manager
        // create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        //create entity manager
        EntityManager em = emf.createEntityManager();
        // create a product
        // Product p = new Product();
        //p.setId(2);
        //p.setName("strategy_table_4");
        //p.setPrice(4000);
        //p.setExpirationDate(LocalDate.now());
        Event e1 = new Event();
        e1.setDescription("Event 10 ");

        try{
            // get transaction
            em.getTransaction().begin();
            em.persist(e1); // adding the instance in the context
            em.getTransaction().commit();
            em.close();
        }catch (Exception e){
            em.getTransaction().rollback();
            em.close();
        }

    }
}
