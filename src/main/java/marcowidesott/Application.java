package marcowidesott;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("backd2w3");

    public static void main(String[] args) {
        System.out.println("hello!");

    }
}