package marcowidesott;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import marcowidesott.dao.EventsDAO;
import marcowidesott.dao.LocationDAO;
import marcowidesott.dao.PartecipazioneDAO;
import marcowidesott.dao.PersonaDAO;
import marcowidesott.entities.*;

import java.time.LocalDate;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tuo-persistence-unit");
        EntityManager em = emf.createEntityManager();

        // Creazione delle DAO
        EventsDAO eventsDAO = new EventsDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);  // Passa EntityManager al costruttore
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        // Creazione di una nuova persona
        Persona persona = new Persona("Mario", "Rossi", "mario.rossi@example.com", LocalDate.of(1990, 5, 20), 'M');
        personaDAO.save(persona);
        System.out.println("Persona salvata: " + persona);

        // Creazione di una nuova location
        Location location = new Location("Teatro della Musica", "Roma");
        locationDAO.save(location);
        System.out.println("Location salvata: " + location);

        // Creazione di un nuovo evento
        Event evento = new Event("Concerto di musica live", LocalDate.of(2024, 10, 15), "Un evento imperdibile", TipoEvento.PUBBLICO, 100);
        eventsDAO.save(evento);
        System.out.println("Evento salvato: " + evento);

        // Registrazione della partecipazione della persona all'evento
        Partecipazione partecipazione = new Partecipazione(persona, evento, "CONFIRMATA");
        partecipazioneDAO.save(partecipazione);
        System.out.println("Partecipazione salvata: " + partecipazione);

        // Chiusura dell'EntityManager
        em.close();
        emf.close();
    }
}

