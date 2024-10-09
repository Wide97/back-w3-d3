package marcowidesott.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private Event evento;

    private String stato;

    public Partecipazione() {
    }

    public Partecipazione(Persona persona, Event evento, String stato) {
        this.persona = persona;
        this.evento = evento;
        this.stato = stato;
    }

    public long getId() {
        return id;
    }

    public Persona getPersona() {
        return persona;
    }

    public Event getEvento() {
        return evento;
    }

    public String getStato() {
        return stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato='" + stato + '\'' +
                '}';
    }
}
