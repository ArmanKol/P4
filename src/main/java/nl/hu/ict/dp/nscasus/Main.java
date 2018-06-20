package nl.hu.ict.dp.nscasus;

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
        
        OVChipkaart kaart1 = new OVChipkaart();
        kaart1.setKaartopdruk("mijn ovchipkaart");
        
        Reiziger reiziger = new Reiziger();
        
        Reiziger reiziger2 = new Reiziger(1, "A", "Kol");
        
        reiziger.addOVChipkaart(kaart1);
        
        /*
         * Opslaan van de data in de domein objecten
         */
        em.getTransaction().begin();
        
        em.persist(kaart1);
        
        em.merge(reiziger2);
        
        Reiziger reisUitDB1 = em.find(Reiziger.class, reiziger.getID());
        System.out.println("Reiziger gelezen: " + reisUitDB1);
        
        Reiziger reisUitDB2 = em.find(Reiziger.class, reiziger2.getID());
        System.out.println("Reiziger gelezen: " + reisUitDB2);
        
        em.remove(reiziger);
        
        em.getTransaction().commit();
        
        System.out.println("Reiziger 2 verwijdert: " + reiziger2);
        
        em.close();
        System.out.println("-- einde --");
    }
}
