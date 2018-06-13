package nl.hu.ict.dp.nscasus;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    private static String orclcfg = "nl.hu.ict.jpa.oracle";
    private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        // get the Hibernate - JPA entityManager
        EntityManager em = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory(orclcfg);
            em = entityManagerFactory.createEntityManager();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        /*
         * Aanmaken van de domein objecten
         */
        OVChipkaart kaart = new OVChipkaart();
        kaart.setKaartopdruk("mijn eerste kaart");
        
        OVChipkaart kaart2 = new OVChipkaart();
        kaart2.setKaartopdruk("Van: Pieter");
        
        Reiziger persoon = new Reiziger();
        persoon.setVoorl("Henk");
        persoon.setAchternaam("Boompjes");
        persoon.setGBdatum(Date.valueOf("1977-05-22"));
        persoon.setReizigerOVChipkaart(kaart);
        
        Reiziger persoon2 = new Reiziger();
        persoon2.setVoorl("Piet");
        persoon2.setTussenvoegsel("van");
        persoon2.setAchternaam("Acht");
        persoon2.setGBdatum(Date.valueOf("1955-10-10"));
        persoon2.setReizigerOVChipkaart(kaart2);
        
        
        /*
         * Opslaan van de data in de domein objecten
         */
        em.getTransaction().begin();
        
        em.persist(kaart);
        em.persist(kaart2);
        
        em.persist(persoon);
        em.persist(persoon2);
        
        Reiziger reisUitDB1 = em.find(Reiziger.class, persoon.getId());
        System.out.println("Reiziger gelezen: " + reisUitDB1);
        
        Reiziger reisUitDB2 = em.find(Reiziger.class, persoon2.getId());
        System.out.println("Reiziger gelezen: " + reisUitDB2);
        
        em.remove(persoon2);
        
        em.getTransaction().commit();
        
        System.out.println("Reiziger 2 verwijdert: " + persoon2);
        
        em.close();
        System.out.println("-- einde --");
    }
}
