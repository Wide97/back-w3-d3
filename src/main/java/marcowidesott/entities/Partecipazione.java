package marcowidesott.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Event evento;

    private String stato; // CONFERMATA, DA_CONFERMARE

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
}
